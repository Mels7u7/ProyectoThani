package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpinformaciondetalladadelprofesional_impl extends GXDataArea
{
   public wpinformaciondetalladadelprofesional_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpinformaciondetalladadelprofesional_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpinformaciondetalladadelprofesional_impl.class ));
   }

   public wpinformaciondetalladadelprofesional_impl( int remoteHandle ,
                                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento = new HTMLChoice();
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo = new HTMLChoice();
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita = new HTMLChoice();
      cmbavSdtprofesionalinformaciongenerals__profesionalestado = new HTMLChoice();
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "ProfesionalId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "ProfesionalId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "ProfesionalId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Freestylegridinformaciongeneral") == 0 )
         {
            nRC_GXsfl_40 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_40"))) ;
            nGXsfl_40_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_40_idx"))) ;
            sGXsfl_40_idx = httpContext.GetPar( "sGXsfl_40_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrfreestylegridinformaciongeneral_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Freestylegridinformaciongeneral") == 0 )
         {
            subGridsdtprofesionalespecialidadsedes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalespecialidadsedes_Rows"))) ;
            subGridsdtprofesionaleducacions_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionaleducacions_Rows"))) ;
            subGridsdtprofesionalexperiencialaborals_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalexperiencialaborals_Rows"))) ;
            subGridsdtprofesionalpremioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalpremioss_Rows"))) ;
            subGridsdtprofesionalservicioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalservicioss_Rows"))) ;
            AV19ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrfreestylegridinformaciongeneral_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Width", GXutil.rtrim( Dvpanel_panelbuttons_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autowidth", GXutil.booltostr( Dvpanel_panelbuttons_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoheight", GXutil.booltostr( Dvpanel_panelbuttons_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Cls", GXutil.rtrim( Dvpanel_panelbuttons_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Title", GXutil.rtrim( Dvpanel_panelbuttons_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsible", GXutil.booltostr( Dvpanel_panelbuttons_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsed", GXutil.booltostr( Dvpanel_panelbuttons_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuttons_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Iconposition", GXutil.rtrim( Dvpanel_panelbuttons_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoscroll", GXutil.booltostr( Dvpanel_panelbuttons_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Width", GXutil.rtrim( Dvpanel_paneinfogeneral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autowidth", GXutil.booltostr( Dvpanel_paneinfogeneral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoheight", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Cls", GXutil.rtrim( Dvpanel_paneinfogeneral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Title", GXutil.rtrim( Dvpanel_paneinfogeneral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsible", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsed", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Showcollapseicon", GXutil.booltostr( Dvpanel_paneinfogeneral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Iconposition", GXutil.rtrim( Dvpanel_paneinfogeneral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoscroll", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Width", GXutil.rtrim( Dvpanel_panelespecialidad_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autowidth", GXutil.booltostr( Dvpanel_panelespecialidad_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoheight", GXutil.booltostr( Dvpanel_panelespecialidad_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Cls", GXutil.rtrim( Dvpanel_panelespecialidad_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Title", GXutil.rtrim( Dvpanel_panelespecialidad_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsible", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsed", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Showcollapseicon", GXutil.booltostr( Dvpanel_panelespecialidad_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Iconposition", GXutil.rtrim( Dvpanel_panelespecialidad_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoscroll", GXutil.booltostr( Dvpanel_panelespecialidad_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Width", GXutil.rtrim( Dvpanel_panelpremios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autowidth", GXutil.booltostr( Dvpanel_panelpremios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoheight", GXutil.booltostr( Dvpanel_panelpremios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Cls", GXutil.rtrim( Dvpanel_panelpremios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Title", GXutil.rtrim( Dvpanel_panelpremios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsible", GXutil.booltostr( Dvpanel_panelpremios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsed", GXutil.booltostr( Dvpanel_panelpremios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Iconposition", GXutil.rtrim( Dvpanel_panelpremios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremios_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_wizardip_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Class", GXutil.rtrim( Gxuitabspanel_wizardip_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Historymanagement", GXutil.booltostr( Gxuitabspanel_wizardip_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_WIZARDIP_Tabsinternalname", GXutil.rtrim( Wizard_wizardip_Tabsinternalname));
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtprofesionalespecialidadsedes") == 0 )
         {
            nRC_GXsfl_161 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_161"))) ;
            nGXsfl_161_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_161_idx"))) ;
            sGXsfl_161_idx = httpContext.GetPar( "sGXsfl_161_idx") ;
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
            AV19ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Width", GXutil.rtrim( Dvpanel_panelbuttons_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autowidth", GXutil.booltostr( Dvpanel_panelbuttons_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoheight", GXutil.booltostr( Dvpanel_panelbuttons_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Cls", GXutil.rtrim( Dvpanel_panelbuttons_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Title", GXutil.rtrim( Dvpanel_panelbuttons_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsible", GXutil.booltostr( Dvpanel_panelbuttons_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsed", GXutil.booltostr( Dvpanel_panelbuttons_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuttons_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Iconposition", GXutil.rtrim( Dvpanel_panelbuttons_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoscroll", GXutil.booltostr( Dvpanel_panelbuttons_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Width", GXutil.rtrim( Dvpanel_paneinfogeneral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autowidth", GXutil.booltostr( Dvpanel_paneinfogeneral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoheight", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Cls", GXutil.rtrim( Dvpanel_paneinfogeneral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Title", GXutil.rtrim( Dvpanel_paneinfogeneral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsible", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsed", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Showcollapseicon", GXutil.booltostr( Dvpanel_paneinfogeneral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Iconposition", GXutil.rtrim( Dvpanel_paneinfogeneral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoscroll", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Width", GXutil.rtrim( Dvpanel_panelespecialidad_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autowidth", GXutil.booltostr( Dvpanel_panelespecialidad_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoheight", GXutil.booltostr( Dvpanel_panelespecialidad_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Cls", GXutil.rtrim( Dvpanel_panelespecialidad_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Title", GXutil.rtrim( Dvpanel_panelespecialidad_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsible", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsed", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Showcollapseicon", GXutil.booltostr( Dvpanel_panelespecialidad_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Iconposition", GXutil.rtrim( Dvpanel_panelespecialidad_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoscroll", GXutil.booltostr( Dvpanel_panelespecialidad_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Width", GXutil.rtrim( Dvpanel_panelpremios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autowidth", GXutil.booltostr( Dvpanel_panelpremios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoheight", GXutil.booltostr( Dvpanel_panelpremios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Cls", GXutil.rtrim( Dvpanel_panelpremios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Title", GXutil.rtrim( Dvpanel_panelpremios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsible", GXutil.booltostr( Dvpanel_panelpremios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsed", GXutil.booltostr( Dvpanel_panelpremios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Iconposition", GXutil.rtrim( Dvpanel_panelpremios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremios_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_wizardip_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Class", GXutil.rtrim( Gxuitabspanel_wizardip_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Historymanagement", GXutil.booltostr( Gxuitabspanel_wizardip_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_WIZARDIP_Tabsinternalname", GXutil.rtrim( Wizard_wizardip_Tabsinternalname));
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
            nRC_GXsfl_183 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_183"))) ;
            nGXsfl_183_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_183_idx"))) ;
            sGXsfl_183_idx = httpContext.GetPar( "sGXsfl_183_idx") ;
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
            AV19ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Width", GXutil.rtrim( Dvpanel_panelbuttons_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autowidth", GXutil.booltostr( Dvpanel_panelbuttons_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoheight", GXutil.booltostr( Dvpanel_panelbuttons_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Cls", GXutil.rtrim( Dvpanel_panelbuttons_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Title", GXutil.rtrim( Dvpanel_panelbuttons_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsible", GXutil.booltostr( Dvpanel_panelbuttons_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsed", GXutil.booltostr( Dvpanel_panelbuttons_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuttons_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Iconposition", GXutil.rtrim( Dvpanel_panelbuttons_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoscroll", GXutil.booltostr( Dvpanel_panelbuttons_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Width", GXutil.rtrim( Dvpanel_paneinfogeneral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autowidth", GXutil.booltostr( Dvpanel_paneinfogeneral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoheight", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Cls", GXutil.rtrim( Dvpanel_paneinfogeneral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Title", GXutil.rtrim( Dvpanel_paneinfogeneral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsible", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsed", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Showcollapseicon", GXutil.booltostr( Dvpanel_paneinfogeneral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Iconposition", GXutil.rtrim( Dvpanel_paneinfogeneral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoscroll", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Width", GXutil.rtrim( Dvpanel_panelespecialidad_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autowidth", GXutil.booltostr( Dvpanel_panelespecialidad_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoheight", GXutil.booltostr( Dvpanel_panelespecialidad_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Cls", GXutil.rtrim( Dvpanel_panelespecialidad_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Title", GXutil.rtrim( Dvpanel_panelespecialidad_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsible", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsed", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Showcollapseicon", GXutil.booltostr( Dvpanel_panelespecialidad_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Iconposition", GXutil.rtrim( Dvpanel_panelespecialidad_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoscroll", GXutil.booltostr( Dvpanel_panelespecialidad_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Width", GXutil.rtrim( Dvpanel_panelpremios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autowidth", GXutil.booltostr( Dvpanel_panelpremios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoheight", GXutil.booltostr( Dvpanel_panelpremios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Cls", GXutil.rtrim( Dvpanel_panelpremios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Title", GXutil.rtrim( Dvpanel_panelpremios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsible", GXutil.booltostr( Dvpanel_panelpremios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsed", GXutil.booltostr( Dvpanel_panelpremios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Iconposition", GXutil.rtrim( Dvpanel_panelpremios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremios_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_wizardip_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Class", GXutil.rtrim( Gxuitabspanel_wizardip_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Historymanagement", GXutil.booltostr( Gxuitabspanel_wizardip_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_WIZARDIP_Tabsinternalname", GXutil.rtrim( Wizard_wizardip_Tabsinternalname));
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
            nRC_GXsfl_208 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_208"))) ;
            nGXsfl_208_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_208_idx"))) ;
            sGXsfl_208_idx = httpContext.GetPar( "sGXsfl_208_idx") ;
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
            AV19ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Width", GXutil.rtrim( Dvpanel_panelbuttons_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autowidth", GXutil.booltostr( Dvpanel_panelbuttons_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoheight", GXutil.booltostr( Dvpanel_panelbuttons_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Cls", GXutil.rtrim( Dvpanel_panelbuttons_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Title", GXutil.rtrim( Dvpanel_panelbuttons_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsible", GXutil.booltostr( Dvpanel_panelbuttons_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsed", GXutil.booltostr( Dvpanel_panelbuttons_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuttons_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Iconposition", GXutil.rtrim( Dvpanel_panelbuttons_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoscroll", GXutil.booltostr( Dvpanel_panelbuttons_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Width", GXutil.rtrim( Dvpanel_paneinfogeneral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autowidth", GXutil.booltostr( Dvpanel_paneinfogeneral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoheight", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Cls", GXutil.rtrim( Dvpanel_paneinfogeneral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Title", GXutil.rtrim( Dvpanel_paneinfogeneral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsible", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsed", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Showcollapseicon", GXutil.booltostr( Dvpanel_paneinfogeneral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Iconposition", GXutil.rtrim( Dvpanel_paneinfogeneral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoscroll", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Width", GXutil.rtrim( Dvpanel_panelespecialidad_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autowidth", GXutil.booltostr( Dvpanel_panelespecialidad_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoheight", GXutil.booltostr( Dvpanel_panelespecialidad_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Cls", GXutil.rtrim( Dvpanel_panelespecialidad_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Title", GXutil.rtrim( Dvpanel_panelespecialidad_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsible", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsed", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Showcollapseicon", GXutil.booltostr( Dvpanel_panelespecialidad_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Iconposition", GXutil.rtrim( Dvpanel_panelespecialidad_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoscroll", GXutil.booltostr( Dvpanel_panelespecialidad_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Width", GXutil.rtrim( Dvpanel_panelpremios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autowidth", GXutil.booltostr( Dvpanel_panelpremios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoheight", GXutil.booltostr( Dvpanel_panelpremios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Cls", GXutil.rtrim( Dvpanel_panelpremios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Title", GXutil.rtrim( Dvpanel_panelpremios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsible", GXutil.booltostr( Dvpanel_panelpremios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsed", GXutil.booltostr( Dvpanel_panelpremios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Iconposition", GXutil.rtrim( Dvpanel_panelpremios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremios_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_wizardip_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Class", GXutil.rtrim( Gxuitabspanel_wizardip_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Historymanagement", GXutil.booltostr( Gxuitabspanel_wizardip_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_WIZARDIP_Tabsinternalname", GXutil.rtrim( Wizard_wizardip_Tabsinternalname));
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
            nRC_GXsfl_232 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_232"))) ;
            nGXsfl_232_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_232_idx"))) ;
            sGXsfl_232_idx = httpContext.GetPar( "sGXsfl_232_idx") ;
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
            AV19ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Width", GXutil.rtrim( Dvpanel_panelbuttons_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autowidth", GXutil.booltostr( Dvpanel_panelbuttons_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoheight", GXutil.booltostr( Dvpanel_panelbuttons_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Cls", GXutil.rtrim( Dvpanel_panelbuttons_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Title", GXutil.rtrim( Dvpanel_panelbuttons_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsible", GXutil.booltostr( Dvpanel_panelbuttons_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsed", GXutil.booltostr( Dvpanel_panelbuttons_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuttons_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Iconposition", GXutil.rtrim( Dvpanel_panelbuttons_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoscroll", GXutil.booltostr( Dvpanel_panelbuttons_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Width", GXutil.rtrim( Dvpanel_paneinfogeneral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autowidth", GXutil.booltostr( Dvpanel_paneinfogeneral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoheight", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Cls", GXutil.rtrim( Dvpanel_paneinfogeneral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Title", GXutil.rtrim( Dvpanel_paneinfogeneral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsible", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsed", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Showcollapseicon", GXutil.booltostr( Dvpanel_paneinfogeneral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Iconposition", GXutil.rtrim( Dvpanel_paneinfogeneral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoscroll", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Width", GXutil.rtrim( Dvpanel_panelespecialidad_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autowidth", GXutil.booltostr( Dvpanel_panelespecialidad_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoheight", GXutil.booltostr( Dvpanel_panelespecialidad_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Cls", GXutil.rtrim( Dvpanel_panelespecialidad_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Title", GXutil.rtrim( Dvpanel_panelespecialidad_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsible", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsed", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Showcollapseicon", GXutil.booltostr( Dvpanel_panelespecialidad_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Iconposition", GXutil.rtrim( Dvpanel_panelespecialidad_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoscroll", GXutil.booltostr( Dvpanel_panelespecialidad_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Width", GXutil.rtrim( Dvpanel_panelpremios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autowidth", GXutil.booltostr( Dvpanel_panelpremios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoheight", GXutil.booltostr( Dvpanel_panelpremios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Cls", GXutil.rtrim( Dvpanel_panelpremios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Title", GXutil.rtrim( Dvpanel_panelpremios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsible", GXutil.booltostr( Dvpanel_panelpremios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsed", GXutil.booltostr( Dvpanel_panelpremios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Iconposition", GXutil.rtrim( Dvpanel_panelpremios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremios_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_wizardip_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Class", GXutil.rtrim( Gxuitabspanel_wizardip_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Historymanagement", GXutil.booltostr( Gxuitabspanel_wizardip_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_WIZARDIP_Tabsinternalname", GXutil.rtrim( Wizard_wizardip_Tabsinternalname));
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
            nRC_GXsfl_255 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_255"))) ;
            nGXsfl_255_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_255_idx"))) ;
            sGXsfl_255_idx = httpContext.GetPar( "sGXsfl_255_idx") ;
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
            AV19ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Width", GXutil.rtrim( Dvpanel_panelbuttons_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autowidth", GXutil.booltostr( Dvpanel_panelbuttons_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoheight", GXutil.booltostr( Dvpanel_panelbuttons_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Cls", GXutil.rtrim( Dvpanel_panelbuttons_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Title", GXutil.rtrim( Dvpanel_panelbuttons_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsible", GXutil.booltostr( Dvpanel_panelbuttons_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsed", GXutil.booltostr( Dvpanel_panelbuttons_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuttons_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Iconposition", GXutil.rtrim( Dvpanel_panelbuttons_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoscroll", GXutil.booltostr( Dvpanel_panelbuttons_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Width", GXutil.rtrim( Dvpanel_paneinfogeneral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autowidth", GXutil.booltostr( Dvpanel_paneinfogeneral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoheight", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Cls", GXutil.rtrim( Dvpanel_paneinfogeneral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Title", GXutil.rtrim( Dvpanel_paneinfogeneral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsible", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsed", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Showcollapseicon", GXutil.booltostr( Dvpanel_paneinfogeneral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Iconposition", GXutil.rtrim( Dvpanel_paneinfogeneral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoscroll", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Width", GXutil.rtrim( Dvpanel_panelespecialidad_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autowidth", GXutil.booltostr( Dvpanel_panelespecialidad_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoheight", GXutil.booltostr( Dvpanel_panelespecialidad_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Cls", GXutil.rtrim( Dvpanel_panelespecialidad_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Title", GXutil.rtrim( Dvpanel_panelespecialidad_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsible", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsed", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Showcollapseicon", GXutil.booltostr( Dvpanel_panelespecialidad_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Iconposition", GXutil.rtrim( Dvpanel_panelespecialidad_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoscroll", GXutil.booltostr( Dvpanel_panelespecialidad_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Width", GXutil.rtrim( Dvpanel_panelpremios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autowidth", GXutil.booltostr( Dvpanel_panelpremios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoheight", GXutil.booltostr( Dvpanel_panelpremios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Cls", GXutil.rtrim( Dvpanel_panelpremios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Title", GXutil.rtrim( Dvpanel_panelpremios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsible", GXutil.booltostr( Dvpanel_panelpremios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsed", GXutil.booltostr( Dvpanel_panelpremios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Iconposition", GXutil.rtrim( Dvpanel_panelpremios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremios_Autoscroll));
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_wizardip_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Class", GXutil.rtrim( Gxuitabspanel_wizardip_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Historymanagement", GXutil.booltostr( Gxuitabspanel_wizardip_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_WIZARDIP_Tabsinternalname", GXutil.rtrim( Wizard_wizardip_Tabsinternalname));
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV19ProfesionalId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ProfesionalId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV19ProfesionalId), "ZZZZZZZ9")));
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
      pa2O2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2O2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110335533", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
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
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
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
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVTabsTransform/DVTabsTransformRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpinformaciondetalladadelprofesional", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV19ProfesionalId,8,0))}, new String[] {"ProfesionalId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV19ProfesionalId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionalinformaciongenerals", AV27SDTProfesionalInformacionGenerals);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionalinformaciongenerals", AV27SDTProfesionalInformacionGenerals);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionalespecialidadsedes", AV28SDTProfesionalEspecialidadSedes);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionalespecialidadsedes", AV28SDTProfesionalEspecialidadSedes);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionaleducacions", AV20SDTProfesionalEducacions);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionaleducacions", AV20SDTProfesionalEducacions);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionalexperiencialaborals", AV21SDTProfesionalExperienciaLaborals);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionalexperiencialaborals", AV21SDTProfesionalExperienciaLaborals);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionalpremioss", AV22SDTProfesionalPremioss);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionalpremioss", AV22SDTProfesionalPremioss);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionalservicioss", AV23SDTProfesionalServicioss);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionalservicioss", AV23SDTProfesionalServicioss);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_40", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_40, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_161", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_161, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_183", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_183, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_208", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_208, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_232", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_232, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_255", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_255, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALESPECIALIDADSEDESCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV29GridSDTProfesionalEspecialidadSedesCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALESPECIALIDADSEDESPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV30GridSDTProfesionalEspecialidadSedesPageCount, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALEDUCACIONSCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV8GridSDTProfesionalEducacionsCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALEDUCACIONSPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV9GridSDTProfesionalEducacionsPageCount, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALEXPERIENCIALABORALSCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV10GridSDTProfesionalExperienciaLaboralsCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALEXPERIENCIALABORALSPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV11GridSDTProfesionalExperienciaLaboralsPageCount, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALPREMIOSSCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV12GridSDTProfesionalPremiossCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALPREMIOSSPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV13GridSDTProfesionalPremiossPageCount, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALSERVICIOSSCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV14GridSDTProfesionalServiciossCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALSERVICIOSSPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV15GridSDTProfesionalServiciossPageCount, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV19ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV19ProfesionalId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPROFESIONALESPECIALIDADSEDES", AV28SDTProfesionalEspecialidadSedes);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPROFESIONALESPECIALIDADSEDES", AV28SDTProfesionalEspecialidadSedes);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPROFESIONALEDUCACIONS", AV20SDTProfesionalEducacions);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPROFESIONALEDUCACIONS", AV20SDTProfesionalEducacions);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPROFESIONALEXPERIENCIALABORALS", AV21SDTProfesionalExperienciaLaborals);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPROFESIONALEXPERIENCIALABORALS", AV21SDTProfesionalExperienciaLaborals);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPROFESIONALPREMIOSS", AV22SDTProfesionalPremioss);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPROFESIONALPREMIOSS", AV22SDTProfesionalPremioss);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPROFESIONALSERVICIOSS", AV23SDTProfesionalServicioss);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPROFESIONALSERVICIOSS", AV23SDTProfesionalServicioss);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Width", GXutil.rtrim( Dvpanel_panelbuttons_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autowidth", GXutil.booltostr( Dvpanel_panelbuttons_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoheight", GXutil.booltostr( Dvpanel_panelbuttons_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Cls", GXutil.rtrim( Dvpanel_panelbuttons_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Title", GXutil.rtrim( Dvpanel_panelbuttons_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsible", GXutil.booltostr( Dvpanel_panelbuttons_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Collapsed", GXutil.booltostr( Dvpanel_panelbuttons_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuttons_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Iconposition", GXutil.rtrim( Dvpanel_panelbuttons_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTTONS_Autoscroll", GXutil.booltostr( Dvpanel_panelbuttons_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Width", GXutil.rtrim( Dvpanel_paneinfogeneral_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autowidth", GXutil.booltostr( Dvpanel_paneinfogeneral_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoheight", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Cls", GXutil.rtrim( Dvpanel_paneinfogeneral_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Title", GXutil.rtrim( Dvpanel_paneinfogeneral_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsible", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Collapsed", GXutil.booltostr( Dvpanel_paneinfogeneral_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Showcollapseicon", GXutil.booltostr( Dvpanel_paneinfogeneral_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Iconposition", GXutil.rtrim( Dvpanel_paneinfogeneral_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEINFOGENERAL_Autoscroll", GXutil.booltostr( Dvpanel_paneinfogeneral_Autoscroll));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Width", GXutil.rtrim( Dvpanel_panelespecialidad_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autowidth", GXutil.booltostr( Dvpanel_panelespecialidad_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoheight", GXutil.booltostr( Dvpanel_panelespecialidad_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Cls", GXutil.rtrim( Dvpanel_panelespecialidad_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Title", GXutil.rtrim( Dvpanel_panelespecialidad_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsible", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Collapsed", GXutil.booltostr( Dvpanel_panelespecialidad_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Showcollapseicon", GXutil.booltostr( Dvpanel_panelespecialidad_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Iconposition", GXutil.rtrim( Dvpanel_panelespecialidad_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELESPECIALIDAD_Autoscroll", GXutil.booltostr( Dvpanel_panelespecialidad_Autoscroll));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Width", GXutil.rtrim( Dvpanel_panelpremios_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autowidth", GXutil.booltostr( Dvpanel_panelpremios_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoheight", GXutil.booltostr( Dvpanel_panelpremios_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Cls", GXutil.rtrim( Dvpanel_panelpremios_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Title", GXutil.rtrim( Dvpanel_panelpremios_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsible", GXutil.booltostr( Dvpanel_panelpremios_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Collapsed", GXutil.booltostr( Dvpanel_panelpremios_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremios_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Iconposition", GXutil.rtrim( Dvpanel_panelpremios_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremios_Autoscroll));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_wizardip_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Class", GXutil.rtrim( Gxuitabspanel_wizardip_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_WIZARDIP_Historymanagement", GXutil.booltostr( Gxuitabspanel_wizardip_Historymanagement));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_WIZARDIP_Tabsinternalname", GXutil.rtrim( Wizard_wizardip_Tabsinternalname));
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
         we2O2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2O2( ) ;
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
      return formatLink("com.projectthani.wpinformaciondetalladadelprofesional", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV19ProfesionalId,8,0))}, new String[] {"ProfesionalId"})  ;
   }

   public String getPgmname( )
   {
      return "WPInformacionDetalladaDelProfesional" ;
   }

   public String getPgmdesc( )
   {
      return "Información Detallada Del Profesional" ;
   }

   public void wb2O0( )
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
         ucDvpanel_panelbuttons.setProperty("Width", Dvpanel_panelbuttons_Width);
         ucDvpanel_panelbuttons.setProperty("AutoWidth", Dvpanel_panelbuttons_Autowidth);
         ucDvpanel_panelbuttons.setProperty("AutoHeight", Dvpanel_panelbuttons_Autoheight);
         ucDvpanel_panelbuttons.setProperty("Cls", Dvpanel_panelbuttons_Cls);
         ucDvpanel_panelbuttons.setProperty("Title", Dvpanel_panelbuttons_Title);
         ucDvpanel_panelbuttons.setProperty("Collapsible", Dvpanel_panelbuttons_Collapsible);
         ucDvpanel_panelbuttons.setProperty("Collapsed", Dvpanel_panelbuttons_Collapsed);
         ucDvpanel_panelbuttons.setProperty("ShowCollapseIcon", Dvpanel_panelbuttons_Showcollapseicon);
         ucDvpanel_panelbuttons.setProperty("IconPosition", Dvpanel_panelbuttons_Iconposition);
         ucDvpanel_panelbuttons.setProperty("AutoScroll", Dvpanel_panelbuttons_Autoscroll);
         ucDvpanel_panelbuttons.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelbuttons_Internalname, "DVPANEL_PANELBUTTONSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELBUTTONSContainer"+"PanelButtons"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divPanelbuttons_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnactivarcuenta_Internalname, "gx.evt.setGridEvt("+GXutil.str( 40, 2, 0)+","+"null"+");", "Activar Cuenta", bttBtnactivarcuenta_Jsonclick, 5, "Activar Cuenta", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOACTIVARCUENTA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPInformacionDetalladaDelProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnsalir_Internalname, "gx.evt.setGridEvt("+GXutil.str( 40, 2, 0)+","+"null"+");", "Cancelar", bttBtnsalir_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e112o1_client"+"'", TempTags, "", 2, "HLP_WPInformacionDetalladaDelProfesional.htm");
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
         /* User Defined Control */
         ucGxuitabspanel_wizardip.setProperty("PageCount", Gxuitabspanel_wizardip_Pagecount);
         ucGxuitabspanel_wizardip.setProperty("Class", Gxuitabspanel_wizardip_Class);
         ucGxuitabspanel_wizardip.setProperty("HistoryManagement", Gxuitabspanel_wizardip_Historymanagement);
         ucGxuitabspanel_wizardip.render(context, "tab", Gxuitabspanel_wizardip_Internalname, "GXUITABSPANEL_WIZARDIPContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabinformaciongeneral_title_Internalname, "Información General", "", "", lblTabinformaciongeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPInformacionDetalladaDelProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabInformacionGeneral") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableinformaciongeneral_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_paneinfogeneral.setProperty("Width", Dvpanel_paneinfogeneral_Width);
         ucDvpanel_paneinfogeneral.setProperty("AutoWidth", Dvpanel_paneinfogeneral_Autowidth);
         ucDvpanel_paneinfogeneral.setProperty("AutoHeight", Dvpanel_paneinfogeneral_Autoheight);
         ucDvpanel_paneinfogeneral.setProperty("Cls", Dvpanel_paneinfogeneral_Cls);
         ucDvpanel_paneinfogeneral.setProperty("Title", Dvpanel_paneinfogeneral_Title);
         ucDvpanel_paneinfogeneral.setProperty("Collapsible", Dvpanel_paneinfogeneral_Collapsible);
         ucDvpanel_paneinfogeneral.setProperty("Collapsed", Dvpanel_paneinfogeneral_Collapsed);
         ucDvpanel_paneinfogeneral.setProperty("ShowCollapseIcon", Dvpanel_paneinfogeneral_Showcollapseicon);
         ucDvpanel_paneinfogeneral.setProperty("IconPosition", Dvpanel_paneinfogeneral_Iconposition);
         ucDvpanel_paneinfogeneral.setProperty("AutoScroll", Dvpanel_paneinfogeneral_Autoscroll);
         ucDvpanel_paneinfogeneral.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_paneinfogeneral_Internalname, "DVPANEL_PANEINFOGENERALContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANEINFOGENERALContainer"+"PaneInfoGeneral"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divPaneinfogeneral_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         FreestylegridinformaciongeneralContainer.SetIsFreestyle(true);
         FreestylegridinformaciongeneralContainer.SetWrapped(nGXWrapped);
         if ( FreestylegridinformaciongeneralContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"FreestylegridinformaciongeneralContainer"+"DivS\" data-gxgridid=\"40\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subFreestylegridinformaciongeneral_Internalname, subFreestylegridinformaciongeneral_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            FreestylegridinformaciongeneralContainer.AddObjectProperty("GridName", "Freestylegridinformaciongeneral");
         }
         else
         {
            FreestylegridinformaciongeneralContainer.AddObjectProperty("GridName", "Freestylegridinformaciongeneral");
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Header", subFreestylegridinformaciongeneral_Header);
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Class", "FreeStyleGrid");
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylegridinformaciongeneral_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddObjectProperty("CmpContext", "");
            FreestylegridinformaciongeneralContainer.AddObjectProperty("InMasterPage", "false");
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionalnombres_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionalcop_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__paisdescripcion_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Enabled, (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            FreestylegridinformaciongeneralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtprofesionalinformaciongenerals__profesionalestado.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddColumnProperties(FreestylegridinformaciongeneralColumn);
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subFreestylegridinformaciongeneral_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subFreestylegridinformaciongeneral_Allowselection, (byte)(1), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subFreestylegridinformaciongeneral_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subFreestylegridinformaciongeneral_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subFreestylegridinformaciongeneral_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subFreestylegridinformaciongeneral_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            FreestylegridinformaciongeneralContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subFreestylegridinformaciongeneral_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 40 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_40 = (int)(nGXsfl_40_idx-1) ;
         if ( FreestylegridinformaciongeneralContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV33GXV1 = nGXsfl_40_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"FreestylegridinformaciongeneralContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Freestylegridinformaciongeneral", FreestylegridinformaciongeneralContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FreestylegridinformaciongeneralContainerData", FreestylegridinformaciongeneralContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FreestylegridinformaciongeneralContainerData"+"V", FreestylegridinformaciongeneralContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"FreestylegridinformaciongeneralContainerData"+"V"+"\" value='"+FreestylegridinformaciongeneralContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabespecialidad_title_Internalname, "Especialidad", "", "", lblTabespecialidad_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPInformacionDetalladaDelProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabEspecialidad") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableespecialidad_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelespecialidad.setProperty("Width", Dvpanel_panelespecialidad_Width);
         ucDvpanel_panelespecialidad.setProperty("AutoWidth", Dvpanel_panelespecialidad_Autowidth);
         ucDvpanel_panelespecialidad.setProperty("AutoHeight", Dvpanel_panelespecialidad_Autoheight);
         ucDvpanel_panelespecialidad.setProperty("Cls", Dvpanel_panelespecialidad_Cls);
         ucDvpanel_panelespecialidad.setProperty("Title", Dvpanel_panelespecialidad_Title);
         ucDvpanel_panelespecialidad.setProperty("Collapsible", Dvpanel_panelespecialidad_Collapsible);
         ucDvpanel_panelespecialidad.setProperty("Collapsed", Dvpanel_panelespecialidad_Collapsed);
         ucDvpanel_panelespecialidad.setProperty("ShowCollapseIcon", Dvpanel_panelespecialidad_Showcollapseicon);
         ucDvpanel_panelespecialidad.setProperty("IconPosition", Dvpanel_panelespecialidad_Iconposition);
         ucDvpanel_panelespecialidad.setProperty("AutoScroll", Dvpanel_panelespecialidad_Autoscroll);
         ucDvpanel_panelespecialidad.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelespecialidad_Internalname, "DVPANEL_PANELESPECIALIDADContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELESPECIALIDADContainer"+"PanelEspecialidad"+"\" style=\"display:none;\">") ;
         wb_table1_155_2O2( true) ;
      }
      else
      {
         wb_table1_155_2O2( false) ;
      }
      return  ;
   }

   public void wb_table1_155_2O2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabeducacion_title_Internalname, "Educación", "", "", lblTabeducacion_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPInformacionDetalladaDelProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabEducacion") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableeducacion_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
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
         wb_table2_177_2O2( true) ;
      }
      else
      {
         wb_table2_177_2O2( false) ;
      }
      return  ;
   }

   public void wb_table2_177_2O2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabexperiencialaboral_title_Internalname, "Experiencia Laboral", "", "", lblTabexperiencialaboral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPInformacionDetalladaDelProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabExperienciaLaboral") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableexperiencialaboral_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
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
         wb_table3_202_2O2( true) ;
      }
      else
      {
         wb_table3_202_2O2( false) ;
      }
      return  ;
   }

   public void wb_table3_202_2O2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"title5"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpremios_title_Internalname, "Premios", "", "", lblTabpremios_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPInformacionDetalladaDelProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPremios") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablepremios_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelpremios.setProperty("Width", Dvpanel_panelpremios_Width);
         ucDvpanel_panelpremios.setProperty("AutoWidth", Dvpanel_panelpremios_Autowidth);
         ucDvpanel_panelpremios.setProperty("AutoHeight", Dvpanel_panelpremios_Autoheight);
         ucDvpanel_panelpremios.setProperty("Cls", Dvpanel_panelpremios_Cls);
         ucDvpanel_panelpremios.setProperty("Title", Dvpanel_panelpremios_Title);
         ucDvpanel_panelpremios.setProperty("Collapsible", Dvpanel_panelpremios_Collapsible);
         ucDvpanel_panelpremios.setProperty("Collapsed", Dvpanel_panelpremios_Collapsed);
         ucDvpanel_panelpremios.setProperty("ShowCollapseIcon", Dvpanel_panelpremios_Showcollapseicon);
         ucDvpanel_panelpremios.setProperty("IconPosition", Dvpanel_panelpremios_Iconposition);
         ucDvpanel_panelpremios.setProperty("AutoScroll", Dvpanel_panelpremios_Autoscroll);
         ucDvpanel_panelpremios.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelpremios_Internalname, "DVPANEL_PANELPREMIOSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELPREMIOSContainer"+"PanelPremios"+"\" style=\"display:none;\">") ;
         wb_table4_226_2O2( true) ;
      }
      else
      {
         wb_table4_226_2O2( false) ;
      }
      return  ;
   }

   public void wb_table4_226_2O2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"title6"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabservicios_title_Internalname, "Servicios", "", "", lblTabservicios_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPInformacionDetalladaDelProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabServicios") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_WIZARDIPContainer"+"panel6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableservicios_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
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
         wb_table5_249_2O2( true) ;
      }
      else
      {
         wb_table5_249_2O2( false) ;
      }
      return  ;
   }

   public void wb_table5_249_2O2e( boolean wbgen )
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
         /* User Defined Control */
         ucWizard_wizardip.render(context, "dvelop.dvtabstransform", Wizard_wizardip_Internalname, "WIZARD_WIZARDIPContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 40 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( FreestylegridinformaciongeneralContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV33GXV1 = nGXsfl_40_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"FreestylegridinformaciongeneralContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Freestylegridinformaciongeneral", FreestylegridinformaciongeneralContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FreestylegridinformaciongeneralContainerData", FreestylegridinformaciongeneralContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FreestylegridinformaciongeneralContainerData"+"V", FreestylegridinformaciongeneralContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"FreestylegridinformaciongeneralContainerData"+"V"+"\" value='"+FreestylegridinformaciongeneralContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 161 )
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
               AV58GXV26 = nGXsfl_161_idx ;
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
      if ( wbEnd == 183 )
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
               AV62GXV30 = nGXsfl_183_idx ;
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
      if ( wbEnd == 208 )
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
               AV68GXV36 = nGXsfl_208_idx ;
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
      if ( wbEnd == 232 )
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
               AV73GXV41 = nGXsfl_232_idx ;
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
      if ( wbEnd == 255 )
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
               AV78GXV46 = nGXsfl_255_idx ;
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

   public void start2O2( )
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
         Form.getMeta().addItem("description", "Información Detallada Del Profesional", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2O0( ) ;
   }

   public void ws2O2( )
   {
      start2O2( ) ;
      evt2O2( ) ;
   }

   public void evt2O2( )
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
                           e122O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e162O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e172O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e182O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e192O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e202O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e212O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOACTIVARCUENTA'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoActivarCuenta' */
                           e222O2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 36), "FREESTYLEGRIDINFORMACIONGENERAL.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_40_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_402( ) ;
                           AV33GXV1 = nGXsfl_40_idx ;
                           if ( ( AV27SDTProfesionalInformacionGenerals.size() >= AV33GXV1 ) && ( AV33GXV1 > 0 ) )
                           {
                              AV27SDTProfesionalInformacionGenerals.currentItem( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)) );
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
                                 e232O2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e242O2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "FREESTYLEGRIDINFORMACIONGENERAL.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e252O2 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 40), "GRIDSDTPROFESIONALESPECIALIDADSEDES.LOAD") == 0 )
                        {
                           nGXsfl_161_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_161_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_161_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1617( ) ;
                           AV58GXV26 = (int)(nGXsfl_161_idx+GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage) ;
                           if ( ( AV28SDTProfesionalEspecialidadSedes.size() >= AV58GXV26 ) && ( AV58GXV26 > 0 ) )
                           {
                              AV28SDTProfesionalEspecialidadSedes.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALESPECIALIDADSEDES.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e262O7 ();
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
                           nGXsfl_183_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_183_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_183_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1836( ) ;
                           AV62GXV30 = (int)(nGXsfl_183_idx+GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage) ;
                           if ( ( AV20SDTProfesionalEducacions.size() >= AV62GXV30 ) && ( AV62GXV30 > 0 ) )
                           {
                              AV20SDTProfesionalEducacions.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEDUCACIONS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e272O6 ();
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
                           nGXsfl_208_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_208_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_208_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2085( ) ;
                           AV68GXV36 = (int)(nGXsfl_208_idx+GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage) ;
                           if ( ( AV21SDTProfesionalExperienciaLaborals.size() >= AV68GXV36 ) && ( AV68GXV36 > 0 ) )
                           {
                              AV21SDTProfesionalExperienciaLaborals.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV21SDTProfesionalExperienciaLaborals.elementAt(-1+AV68GXV36)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEXPERIENCIALABORALS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e282O5 ();
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
                           nGXsfl_232_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_232_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_232_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2324( ) ;
                           AV73GXV41 = (int)(nGXsfl_232_idx+GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage) ;
                           if ( ( AV22SDTProfesionalPremioss.size() >= AV73GXV41 ) && ( AV73GXV41 > 0 ) )
                           {
                              AV22SDTProfesionalPremioss.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV22SDTProfesionalPremioss.elementAt(-1+AV73GXV41)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALPREMIOSS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e292O4 ();
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
                           nGXsfl_255_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_255_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_255_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2553( ) ;
                           AV78GXV46 = (int)(nGXsfl_255_idx+GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage) ;
                           if ( ( AV23SDTProfesionalServicioss.size() >= AV78GXV46 ) && ( AV78GXV46 > 0 ) )
                           {
                              AV23SDTProfesionalServicioss.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV23SDTProfesionalServicioss.elementAt(-1+AV78GXV46)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALSERVICIOSS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e302O3 ();
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

   public void we2O2( )
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

   public void pa2O2( )
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
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrfreestylegridinformaciongeneral_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_402( ) ;
      while ( nGXsfl_40_idx <= nRC_GXsfl_40 )
      {
         sendrow_402( ) ;
         nGXsfl_40_idx = ((subFreestylegridinformaciongeneral_Islastpage==1)&&(nGXsfl_40_idx+1>subfreestylegridinformaciongeneral_fnc_recordsperpage( )) ? 1 : nGXsfl_40_idx+1) ;
         sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_402( ) ;
      }
      addString( httpContext.getJSONContainerResponse( FreestylegridinformaciongeneralContainer)) ;
      /* End function gxnrFreestylegridinformaciongeneral_newrow */
   }

   public void gxnrgridsdtprofesionalservicioss_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2553( ) ;
      while ( nGXsfl_255_idx <= nRC_GXsfl_255 )
      {
         sendrow_2553( ) ;
         nGXsfl_255_idx = ((subGridsdtprofesionalservicioss_Islastpage==1)&&(nGXsfl_255_idx+1>subgridsdtprofesionalservicioss_fnc_recordsperpage( )) ? 1 : nGXsfl_255_idx+1) ;
         sGXsfl_255_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_255_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2553( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtprofesionalserviciossContainer)) ;
      /* End function gxnrGridsdtprofesionalservicioss_newrow */
   }

   public void gxnrgridsdtprofesionalpremioss_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2324( ) ;
      while ( nGXsfl_232_idx <= nRC_GXsfl_232 )
      {
         sendrow_2324( ) ;
         nGXsfl_232_idx = ((subGridsdtprofesionalpremioss_Islastpage==1)&&(nGXsfl_232_idx+1>subgridsdtprofesionalpremioss_fnc_recordsperpage( )) ? 1 : nGXsfl_232_idx+1) ;
         sGXsfl_232_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_232_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2324( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtprofesionalpremiossContainer)) ;
      /* End function gxnrGridsdtprofesionalpremioss_newrow */
   }

   public void gxnrgridsdtprofesionalexperiencialaborals_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2085( ) ;
      while ( nGXsfl_208_idx <= nRC_GXsfl_208 )
      {
         sendrow_2085( ) ;
         nGXsfl_208_idx = ((subGridsdtprofesionalexperiencialaborals_Islastpage==1)&&(nGXsfl_208_idx+1>subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )) ? 1 : nGXsfl_208_idx+1) ;
         sGXsfl_208_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_208_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2085( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtprofesionalexperiencialaboralsContainer)) ;
      /* End function gxnrGridsdtprofesionalexperiencialaborals_newrow */
   }

   public void gxnrgridsdtprofesionaleducacions_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1836( ) ;
      while ( nGXsfl_183_idx <= nRC_GXsfl_183 )
      {
         sendrow_1836( ) ;
         nGXsfl_183_idx = ((subGridsdtprofesionaleducacions_Islastpage==1)&&(nGXsfl_183_idx+1>subgridsdtprofesionaleducacions_fnc_recordsperpage( )) ? 1 : nGXsfl_183_idx+1) ;
         sGXsfl_183_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_183_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1836( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtprofesionaleducacionsContainer)) ;
      /* End function gxnrGridsdtprofesionaleducacions_newrow */
   }

   public void gxnrgridsdtprofesionalespecialidadsedes_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1617( ) ;
      while ( nGXsfl_161_idx <= nRC_GXsfl_161 )
      {
         sendrow_1617( ) ;
         nGXsfl_161_idx = ((subGridsdtprofesionalespecialidadsedes_Islastpage==1)&&(nGXsfl_161_idx+1>subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )) ? 1 : nGXsfl_161_idx+1) ;
         sGXsfl_161_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_161_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1617( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtprofesionalespecialidadsedesContainer)) ;
      /* End function gxnrGridsdtprofesionalespecialidadsedes_newrow */
   }

   public void gxgrfreestylegridinformaciongeneral_refresh( int subGridsdtprofesionalespecialidadsedes_Rows ,
                                                            int subGridsdtprofesionaleducacions_Rows ,
                                                            int subGridsdtprofesionalexperiencialaborals_Rows ,
                                                            int subGridsdtprofesionalpremioss_Rows ,
                                                            int subGridsdtprofesionalservicioss_Rows ,
                                                            int AV19ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e242O2 ();
      FREESTYLEGRIDINFORMACIONGENERAL_nCurrentRecord = 0 ;
      rf2O2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrFreestylegridinformaciongeneral_refresh */
   }

   public void gxgrgridsdtprofesionalespecialidadsedes_refresh( int subGridsdtprofesionalespecialidadsedes_Rows ,
                                                                int subGridsdtprofesionaleducacions_Rows ,
                                                                int subGridsdtprofesionalexperiencialaborals_Rows ,
                                                                int subGridsdtprofesionalpremioss_Rows ,
                                                                int subGridsdtprofesionalservicioss_Rows ,
                                                                int AV19ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e242O2 ();
      GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord = 0 ;
      rf2O7( ) ;
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
                                                         int AV19ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e242O2 ();
      GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord = 0 ;
      rf2O6( ) ;
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
                                                                  int AV19ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e242O2 ();
      GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord = 0 ;
      rf2O5( ) ;
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
                                                       int AV19ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e242O2 ();
      GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord = 0 ;
      rf2O4( ) ;
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
                                                         int AV19ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e242O2 ();
      GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord = 0 ;
      rf2O3( ) ;
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
      rf2O2( ) ;
      rf2O7( ) ;
      rf2O6( ) ;
      rf2O5( ) ;
      rf2O4( ) ;
      rf2O3( ) ;
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
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalnombres_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalcop_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalcop_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalcop_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__paisdescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__paisdescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__paisdescripcion_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionalestado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalinformaciongenerals__profesionalestado.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled), 5, 0), !bGXsfl_161_Refreshing);
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getEnabled(), 5, 0), !bGXsfl_161_Refreshing);
      edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalespecialidadsedes__costoconsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled), 5, 0), !bGXsfl_161_Refreshing);
      edtavSdtprofesionaleducacions__educacionid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionid_Enabled), 5, 0), !bGXsfl_183_Refreshing);
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled), 5, 0), !bGXsfl_183_Refreshing);
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled), 5, 0), !bGXsfl_183_Refreshing);
      edtavSdtprofesionaleducacions__educaciondesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educaciondesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educaciondesde_Enabled), 5, 0), !bGXsfl_183_Refreshing);
      edtavSdtprofesionaleducacions__educacionhasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionhasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionhasta_Enabled), 5, 0), !bGXsfl_183_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Enabled), 5, 0), !bGXsfl_208_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled), 5, 0), !bGXsfl_208_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled), 5, 0), !bGXsfl_208_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled), 5, 0), !bGXsfl_208_Refreshing);
      edtavSdtprofesionalpremioss__premiosid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosid_Enabled), 5, 0), !bGXsfl_232_Refreshing);
      edtavSdtprofesionalpremioss__premiosnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosnombre_Enabled), 5, 0), !bGXsfl_232_Refreshing);
      edtavSdtprofesionalpremioss__premiosfecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosfecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosfecha_Enabled), 5, 0), !bGXsfl_232_Refreshing);
      edtavSdtprofesionalpremioss__premiosdescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosdescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosdescripcion_Enabled), 5, 0), !bGXsfl_232_Refreshing);
      edtavSdtprofesionalservicioss__serviciosid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalservicioss__serviciosid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalservicioss__serviciosid_Enabled), 5, 0), !bGXsfl_255_Refreshing);
      edtavSdtprofesionalservicioss__serviciosnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalservicioss__serviciosnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalservicioss__serviciosnombre_Enabled), 5, 0), !bGXsfl_255_Refreshing);
   }

   public void rf2O2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         FreestylegridinformaciongeneralContainer.ClearRows();
      }
      wbStart = (short)(40) ;
      /* Execute user event: Refresh */
      e242O2 ();
      nGXsfl_40_idx = 1 ;
      sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_402( ) ;
      bGXsfl_40_Refreshing = true ;
      FreestylegridinformaciongeneralContainer.AddObjectProperty("GridName", "Freestylegridinformaciongeneral");
      FreestylegridinformaciongeneralContainer.AddObjectProperty("CmpContext", "");
      FreestylegridinformaciongeneralContainer.AddObjectProperty("InMasterPage", "false");
      FreestylegridinformaciongeneralContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      FreestylegridinformaciongeneralContainer.AddObjectProperty("Class", "FreeStyleGrid");
      FreestylegridinformaciongeneralContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      FreestylegridinformaciongeneralContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      FreestylegridinformaciongeneralContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylegridinformaciongeneral_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      FreestylegridinformaciongeneralContainer.setPageSize( subfreestylegridinformaciongeneral_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_402( ) ;
         e252O2 ();
         wbEnd = (short)(40) ;
         wb2O0( ) ;
      }
      bGXsfl_40_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2O2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV19ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV19ProfesionalId), "ZZZZZZZ9")));
   }

   public void rf2O3( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtprofesionalserviciossContainer.ClearRows();
      }
      wbStart = (short)(255) ;
      nGXsfl_255_idx = 1 ;
      sGXsfl_255_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_255_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2553( ) ;
      bGXsfl_255_Refreshing = true ;
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
         subsflControlProps_2553( ) ;
         e302O3 ();
         if ( ( GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord > 0 ) && ( GRIDSDTPROFESIONALSERVICIOSS_nGridOutOfScope == 0 ) && ( nGXsfl_255_idx == 1 ) )
         {
            GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord = 0 ;
            GRIDSDTPROFESIONALSERVICIOSS_nGridOutOfScope = 1 ;
            subgridsdtprofesionalservicioss_firstpage( ) ;
            e302O3 ();
         }
         wbEnd = (short)(255) ;
         wb2O0( ) ;
      }
      bGXsfl_255_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2O3( )
   {
   }

   public void rf2O4( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtprofesionalpremiossContainer.ClearRows();
      }
      wbStart = (short)(232) ;
      nGXsfl_232_idx = 1 ;
      sGXsfl_232_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_232_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2324( ) ;
      bGXsfl_232_Refreshing = true ;
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
         subsflControlProps_2324( ) ;
         e292O4 ();
         if ( ( GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord > 0 ) && ( GRIDSDTPROFESIONALPREMIOSS_nGridOutOfScope == 0 ) && ( nGXsfl_232_idx == 1 ) )
         {
            GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord = 0 ;
            GRIDSDTPROFESIONALPREMIOSS_nGridOutOfScope = 1 ;
            subgridsdtprofesionalpremioss_firstpage( ) ;
            e292O4 ();
         }
         wbEnd = (short)(232) ;
         wb2O0( ) ;
      }
      bGXsfl_232_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2O4( )
   {
   }

   public void rf2O5( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtprofesionalexperiencialaboralsContainer.ClearRows();
      }
      wbStart = (short)(208) ;
      nGXsfl_208_idx = 1 ;
      sGXsfl_208_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_208_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2085( ) ;
      bGXsfl_208_Refreshing = true ;
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
         subsflControlProps_2085( ) ;
         e282O5 ();
         if ( ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord > 0 ) && ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nGridOutOfScope == 0 ) && ( nGXsfl_208_idx == 1 ) )
         {
            GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord = 0 ;
            GRIDSDTPROFESIONALEXPERIENCIALABORALS_nGridOutOfScope = 1 ;
            subgridsdtprofesionalexperiencialaborals_firstpage( ) ;
            e282O5 ();
         }
         wbEnd = (short)(208) ;
         wb2O0( ) ;
      }
      bGXsfl_208_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2O5( )
   {
   }

   public void rf2O6( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtprofesionaleducacionsContainer.ClearRows();
      }
      wbStart = (short)(183) ;
      nGXsfl_183_idx = 1 ;
      sGXsfl_183_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_183_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1836( ) ;
      bGXsfl_183_Refreshing = true ;
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
         subsflControlProps_1836( ) ;
         e272O6 ();
         if ( ( GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord > 0 ) && ( GRIDSDTPROFESIONALEDUCACIONS_nGridOutOfScope == 0 ) && ( nGXsfl_183_idx == 1 ) )
         {
            GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord = 0 ;
            GRIDSDTPROFESIONALEDUCACIONS_nGridOutOfScope = 1 ;
            subgridsdtprofesionaleducacions_firstpage( ) ;
            e272O6 ();
         }
         wbEnd = (short)(183) ;
         wb2O0( ) ;
      }
      bGXsfl_183_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2O6( )
   {
   }

   public void rf2O7( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtprofesionalespecialidadsedesContainer.ClearRows();
      }
      wbStart = (short)(161) ;
      nGXsfl_161_idx = 1 ;
      sGXsfl_161_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_161_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1617( ) ;
      bGXsfl_161_Refreshing = true ;
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
         subsflControlProps_1617( ) ;
         e262O7 ();
         if ( ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord > 0 ) && ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nGridOutOfScope == 0 ) && ( nGXsfl_161_idx == 1 ) )
         {
            GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord = 0 ;
            GRIDSDTPROFESIONALESPECIALIDADSEDES_nGridOutOfScope = 1 ;
            subgridsdtprofesionalespecialidadsedes_firstpage( ) ;
            e262O7 ();
         }
         wbEnd = (short)(161) ;
         wb2O0( ) ;
      }
      bGXsfl_161_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2O7( )
   {
   }

   public int subfreestylegridinformaciongeneral_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subfreestylegridinformaciongeneral_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subfreestylegridinformaciongeneral_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subfreestylegridinformaciongeneral_fnc_currentpage( )
   {
      return -1 ;
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
      return AV23SDTProfesionalServicioss.size() ;
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
         gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
      return AV22SDTProfesionalPremioss.size() ;
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
         gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
      return AV21SDTProfesionalExperienciaLaborals.size() ;
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
         gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
      return AV20SDTProfesionalEducacions.size() ;
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
         gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
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
      return AV28SDTProfesionalEspecialidadSedes.size() ;
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
         gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
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
         gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV19ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalnombres_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalcop_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalcop_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalcop_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__paisdescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__paisdescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__paisdescripcion_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionalestado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalinformaciongenerals__profesionalestado.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled), 5, 0), !bGXsfl_161_Refreshing);
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getEnabled(), 5, 0), !bGXsfl_161_Refreshing);
      edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalespecialidadsedes__costoconsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled), 5, 0), !bGXsfl_161_Refreshing);
      edtavSdtprofesionaleducacions__educacionid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionid_Enabled), 5, 0), !bGXsfl_183_Refreshing);
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled), 5, 0), !bGXsfl_183_Refreshing);
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled), 5, 0), !bGXsfl_183_Refreshing);
      edtavSdtprofesionaleducacions__educaciondesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educaciondesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educaciondesde_Enabled), 5, 0), !bGXsfl_183_Refreshing);
      edtavSdtprofesionaleducacions__educacionhasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionhasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionhasta_Enabled), 5, 0), !bGXsfl_183_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Enabled), 5, 0), !bGXsfl_208_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled), 5, 0), !bGXsfl_208_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled), 5, 0), !bGXsfl_208_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled), 5, 0), !bGXsfl_208_Refreshing);
      edtavSdtprofesionalpremioss__premiosid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosid_Enabled), 5, 0), !bGXsfl_232_Refreshing);
      edtavSdtprofesionalpremioss__premiosnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosnombre_Enabled), 5, 0), !bGXsfl_232_Refreshing);
      edtavSdtprofesionalpremioss__premiosfecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosfecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosfecha_Enabled), 5, 0), !bGXsfl_232_Refreshing);
      edtavSdtprofesionalpremioss__premiosdescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosdescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosdescripcion_Enabled), 5, 0), !bGXsfl_232_Refreshing);
      edtavSdtprofesionalservicioss__serviciosid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalservicioss__serviciosid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalservicioss__serviciosid_Enabled), 5, 0), !bGXsfl_255_Refreshing);
      edtavSdtprofesionalservicioss__serviciosnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalservicioss__serviciosnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalservicioss__serviciosnombre_Enabled), 5, 0), !bGXsfl_255_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2O0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e232O2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionalinformaciongenerals"), AV27SDTProfesionalInformacionGenerals);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionalespecialidadsedes"), AV28SDTProfesionalEspecialidadSedes);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionaleducacions"), AV20SDTProfesionalEducacions);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionalexperiencialaborals"), AV21SDTProfesionalExperienciaLaborals);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionalpremioss"), AV22SDTProfesionalPremioss);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionalservicioss"), AV23SDTProfesionalServicioss);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTPROFESIONALESPECIALIDADSEDES"), AV28SDTProfesionalEspecialidadSedes);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTPROFESIONALEDUCACIONS"), AV20SDTProfesionalEducacions);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTPROFESIONALEXPERIENCIALABORALS"), AV21SDTProfesionalExperienciaLaborals);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTPROFESIONALPREMIOSS"), AV22SDTProfesionalPremioss);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTPROFESIONALSERVICIOSS"), AV23SDTProfesionalServicioss);
         /* Read saved values. */
         nRC_GXsfl_40 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_40"), ",", ".")) ;
         nRC_GXsfl_161 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_161"), ",", ".")) ;
         nRC_GXsfl_183 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_183"), ",", ".")) ;
         nRC_GXsfl_208 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_208"), ",", ".")) ;
         nRC_GXsfl_232 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_232"), ",", ".")) ;
         nRC_GXsfl_255 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_255"), ",", ".")) ;
         AV29GridSDTProfesionalEspecialidadSedesCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALESPECIALIDADSEDESCURRENTPAGE"), ",", ".") ;
         AV30GridSDTProfesionalEspecialidadSedesPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALESPECIALIDADSEDESPAGECOUNT"), ",", ".") ;
         AV8GridSDTProfesionalEducacionsCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALEDUCACIONSCURRENTPAGE"), ",", ".") ;
         AV9GridSDTProfesionalEducacionsPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALEDUCACIONSPAGECOUNT"), ",", ".") ;
         AV10GridSDTProfesionalExperienciaLaboralsCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALEXPERIENCIALABORALSCURRENTPAGE"), ",", ".") ;
         AV11GridSDTProfesionalExperienciaLaboralsPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALEXPERIENCIALABORALSPAGECOUNT"), ",", ".") ;
         AV12GridSDTProfesionalPremiossCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALPREMIOSSCURRENTPAGE"), ",", ".") ;
         AV13GridSDTProfesionalPremiossPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALPREMIOSSPAGECOUNT"), ",", ".") ;
         AV14GridSDTProfesionalServiciossCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALSERVICIOSSCURRENTPAGE"), ",", ".") ;
         AV15GridSDTProfesionalServiciossPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALSERVICIOSSPAGECOUNT"), ",", ".") ;
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
         Dvpanel_panelbuttons_Width = httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Width") ;
         Dvpanel_panelbuttons_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Autowidth")) ;
         Dvpanel_panelbuttons_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Autoheight")) ;
         Dvpanel_panelbuttons_Cls = httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Cls") ;
         Dvpanel_panelbuttons_Title = httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Title") ;
         Dvpanel_panelbuttons_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Collapsible")) ;
         Dvpanel_panelbuttons_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Collapsed")) ;
         Dvpanel_panelbuttons_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Showcollapseicon")) ;
         Dvpanel_panelbuttons_Iconposition = httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Iconposition") ;
         Dvpanel_panelbuttons_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTTONS_Autoscroll")) ;
         Dvpanel_paneinfogeneral_Width = httpContext.cgiGet( "DVPANEL_PANEINFOGENERAL_Width") ;
         Dvpanel_paneinfogeneral_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEINFOGENERAL_Autowidth")) ;
         Dvpanel_paneinfogeneral_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEINFOGENERAL_Autoheight")) ;
         Dvpanel_paneinfogeneral_Cls = httpContext.cgiGet( "DVPANEL_PANEINFOGENERAL_Cls") ;
         Dvpanel_paneinfogeneral_Title = httpContext.cgiGet( "DVPANEL_PANEINFOGENERAL_Title") ;
         Dvpanel_paneinfogeneral_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEINFOGENERAL_Collapsible")) ;
         Dvpanel_paneinfogeneral_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEINFOGENERAL_Collapsed")) ;
         Dvpanel_paneinfogeneral_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEINFOGENERAL_Showcollapseicon")) ;
         Dvpanel_paneinfogeneral_Iconposition = httpContext.cgiGet( "DVPANEL_PANEINFOGENERAL_Iconposition") ;
         Dvpanel_paneinfogeneral_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEINFOGENERAL_Autoscroll")) ;
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
         Dvpanel_panelespecialidad_Width = httpContext.cgiGet( "DVPANEL_PANELESPECIALIDAD_Width") ;
         Dvpanel_panelespecialidad_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELESPECIALIDAD_Autowidth")) ;
         Dvpanel_panelespecialidad_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELESPECIALIDAD_Autoheight")) ;
         Dvpanel_panelespecialidad_Cls = httpContext.cgiGet( "DVPANEL_PANELESPECIALIDAD_Cls") ;
         Dvpanel_panelespecialidad_Title = httpContext.cgiGet( "DVPANEL_PANELESPECIALIDAD_Title") ;
         Dvpanel_panelespecialidad_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELESPECIALIDAD_Collapsible")) ;
         Dvpanel_panelespecialidad_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELESPECIALIDAD_Collapsed")) ;
         Dvpanel_panelespecialidad_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELESPECIALIDAD_Showcollapseicon")) ;
         Dvpanel_panelespecialidad_Iconposition = httpContext.cgiGet( "DVPANEL_PANELESPECIALIDAD_Iconposition") ;
         Dvpanel_panelespecialidad_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELESPECIALIDAD_Autoscroll")) ;
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
         Dvpanel_panelpremios_Width = httpContext.cgiGet( "DVPANEL_PANELPREMIOS_Width") ;
         Dvpanel_panelpremios_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOS_Autowidth")) ;
         Dvpanel_panelpremios_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOS_Autoheight")) ;
         Dvpanel_panelpremios_Cls = httpContext.cgiGet( "DVPANEL_PANELPREMIOS_Cls") ;
         Dvpanel_panelpremios_Title = httpContext.cgiGet( "DVPANEL_PANELPREMIOS_Title") ;
         Dvpanel_panelpremios_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOS_Collapsible")) ;
         Dvpanel_panelpremios_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOS_Collapsed")) ;
         Dvpanel_panelpremios_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOS_Showcollapseicon")) ;
         Dvpanel_panelpremios_Iconposition = httpContext.cgiGet( "DVPANEL_PANELPREMIOS_Iconposition") ;
         Dvpanel_panelpremios_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOS_Autoscroll")) ;
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
         Gxuitabspanel_wizardip_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_WIZARDIP_Pagecount"), ",", ".")) ;
         Gxuitabspanel_wizardip_Class = httpContext.cgiGet( "GXUITABSPANEL_WIZARDIP_Class") ;
         Gxuitabspanel_wizardip_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_WIZARDIP_Historymanagement")) ;
         Gridsdtprofesionalservicioss_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname") ;
         Gridsdtprofesionalpremioss_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname") ;
         Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname") ;
         Gridsdtprofesionaleducacions_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname") ;
         Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname") ;
         Wizard_wizardip_Tabsinternalname = httpContext.cgiGet( "WIZARD_WIZARDIP_Tabsinternalname") ;
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
         nRC_GXsfl_40 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_40"), ",", ".")) ;
         nGXsfl_40_fel_idx = 0 ;
         while ( nGXsfl_40_fel_idx < nRC_GXsfl_40 )
         {
            nGXsfl_40_fel_idx = ((subFreestylegridinformaciongeneral_Islastpage==1)&&(nGXsfl_40_fel_idx+1>subfreestylegridinformaciongeneral_fnc_recordsperpage( )) ? 1 : nGXsfl_40_fel_idx+1) ;
            sGXsfl_40_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_402( ) ;
            AV33GXV1 = nGXsfl_40_fel_idx ;
            if ( ( AV27SDTProfesionalInformacionGenerals.size() >= AV33GXV1 ) && ( AV33GXV1 > 0 ) )
            {
               AV27SDTProfesionalInformacionGenerals.currentItem( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)) );
            }
         }
         if ( nGXsfl_40_fel_idx == 0 )
         {
            nGXsfl_40_idx = 1 ;
            sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_402( ) ;
         }
         nGXsfl_40_fel_idx = 1 ;
         nRC_GXsfl_161 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_161"), ",", ".")) ;
         nGXsfl_161_fel_idx = 0 ;
         while ( nGXsfl_161_fel_idx < nRC_GXsfl_161 )
         {
            nGXsfl_161_fel_idx = ((subGridsdtprofesionalespecialidadsedes_Islastpage==1)&&(nGXsfl_161_fel_idx+1>subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )) ? 1 : nGXsfl_161_fel_idx+1) ;
            sGXsfl_161_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_161_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1617( ) ;
            AV58GXV26 = (int)(nGXsfl_161_fel_idx+GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage) ;
            if ( ( AV28SDTProfesionalEspecialidadSedes.size() >= AV58GXV26 ) && ( AV58GXV26 > 0 ) )
            {
               AV28SDTProfesionalEspecialidadSedes.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)) );
            }
         }
         if ( nGXsfl_161_fel_idx == 0 )
         {
            nGXsfl_161_idx = 1 ;
            sGXsfl_161_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_161_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1617( ) ;
         }
         nGXsfl_161_fel_idx = 1 ;
         nRC_GXsfl_183 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_183"), ",", ".")) ;
         nGXsfl_183_fel_idx = 0 ;
         while ( nGXsfl_183_fel_idx < nRC_GXsfl_183 )
         {
            nGXsfl_183_fel_idx = ((subGridsdtprofesionaleducacions_Islastpage==1)&&(nGXsfl_183_fel_idx+1>subgridsdtprofesionaleducacions_fnc_recordsperpage( )) ? 1 : nGXsfl_183_fel_idx+1) ;
            sGXsfl_183_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_183_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1836( ) ;
            AV62GXV30 = (int)(nGXsfl_183_fel_idx+GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage) ;
            if ( ( AV20SDTProfesionalEducacions.size() >= AV62GXV30 ) && ( AV62GXV30 > 0 ) )
            {
               AV20SDTProfesionalEducacions.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)) );
            }
         }
         if ( nGXsfl_183_fel_idx == 0 )
         {
            nGXsfl_183_idx = 1 ;
            sGXsfl_183_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_183_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1836( ) ;
         }
         nGXsfl_183_fel_idx = 1 ;
         nRC_GXsfl_208 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_208"), ",", ".")) ;
         nGXsfl_208_fel_idx = 0 ;
         while ( nGXsfl_208_fel_idx < nRC_GXsfl_208 )
         {
            nGXsfl_208_fel_idx = ((subGridsdtprofesionalexperiencialaborals_Islastpage==1)&&(nGXsfl_208_fel_idx+1>subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )) ? 1 : nGXsfl_208_fel_idx+1) ;
            sGXsfl_208_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_208_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2085( ) ;
            AV68GXV36 = (int)(nGXsfl_208_fel_idx+GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage) ;
            if ( ( AV21SDTProfesionalExperienciaLaborals.size() >= AV68GXV36 ) && ( AV68GXV36 > 0 ) )
            {
               AV21SDTProfesionalExperienciaLaborals.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV21SDTProfesionalExperienciaLaborals.elementAt(-1+AV68GXV36)) );
            }
         }
         if ( nGXsfl_208_fel_idx == 0 )
         {
            nGXsfl_208_idx = 1 ;
            sGXsfl_208_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_208_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2085( ) ;
         }
         nGXsfl_208_fel_idx = 1 ;
         nRC_GXsfl_232 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_232"), ",", ".")) ;
         nGXsfl_232_fel_idx = 0 ;
         while ( nGXsfl_232_fel_idx < nRC_GXsfl_232 )
         {
            nGXsfl_232_fel_idx = ((subGridsdtprofesionalpremioss_Islastpage==1)&&(nGXsfl_232_fel_idx+1>subgridsdtprofesionalpremioss_fnc_recordsperpage( )) ? 1 : nGXsfl_232_fel_idx+1) ;
            sGXsfl_232_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_232_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2324( ) ;
            AV73GXV41 = (int)(nGXsfl_232_fel_idx+GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage) ;
            if ( ( AV22SDTProfesionalPremioss.size() >= AV73GXV41 ) && ( AV73GXV41 > 0 ) )
            {
               AV22SDTProfesionalPremioss.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV22SDTProfesionalPremioss.elementAt(-1+AV73GXV41)) );
            }
         }
         if ( nGXsfl_232_fel_idx == 0 )
         {
            nGXsfl_232_idx = 1 ;
            sGXsfl_232_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_232_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2324( ) ;
         }
         nGXsfl_232_fel_idx = 1 ;
         nRC_GXsfl_255 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_255"), ",", ".")) ;
         nGXsfl_255_fel_idx = 0 ;
         while ( nGXsfl_255_fel_idx < nRC_GXsfl_255 )
         {
            nGXsfl_255_fel_idx = ((subGridsdtprofesionalservicioss_Islastpage==1)&&(nGXsfl_255_fel_idx+1>subgridsdtprofesionalservicioss_fnc_recordsperpage( )) ? 1 : nGXsfl_255_fel_idx+1) ;
            sGXsfl_255_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_255_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2553( ) ;
            AV78GXV46 = (int)(nGXsfl_255_fel_idx+GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage) ;
            if ( ( AV23SDTProfesionalServicioss.size() >= AV78GXV46 ) && ( AV78GXV46 > 0 ) )
            {
               AV23SDTProfesionalServicioss.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV23SDTProfesionalServicioss.elementAt(-1+AV78GXV46)) );
            }
         }
         if ( nGXsfl_255_fel_idx == 0 )
         {
            nGXsfl_255_idx = 1 ;
            sGXsfl_255_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_255_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2553( ) ;
         }
         nGXsfl_255_fel_idx = 1 ;
         /* Read variables values. */
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
      e232O2 ();
      if (returnInSub) return;
   }

   public void e232O2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.getJscriptsrc().add("sweetalert2.all.min.js") ;
      Form.getJscriptsrc().add("SweetAlert2.js") ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/bootstrap-4.min.css\" type=\"text/css\">" );
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/sweetalert2.min.css\" type=\"text/css\">" );
      GXv_objcol_SdtSDTProfesionalEspecialidadSede1[0] = AV28SDTProfesionalEspecialidadSedes ;
      GXv_objcol_SdtSDTProfesionalInformacionGeneral2[0] = AV27SDTProfesionalInformacionGenerals ;
      GXv_objcol_SdtSDTProfesionalEducacion3[0] = AV20SDTProfesionalEducacions ;
      GXv_objcol_SdtSDTProfesionalExperienciaLaboral4[0] = AV21SDTProfesionalExperienciaLaborals ;
      GXv_objcol_SdtSDTProfesionalPremios5[0] = AV22SDTProfesionalPremioss ;
      GXv_objcol_SdtSDTProfesionalServicios6[0] = AV23SDTProfesionalServicioss ;
      new com.projectthani.prcprofesionalinformaciondetallada(remoteHandle, context).execute( AV19ProfesionalId, GXv_objcol_SdtSDTProfesionalEspecialidadSede1, GXv_objcol_SdtSDTProfesionalInformacionGeneral2, GXv_objcol_SdtSDTProfesionalEducacion3, GXv_objcol_SdtSDTProfesionalExperienciaLaboral4, GXv_objcol_SdtSDTProfesionalPremios5, GXv_objcol_SdtSDTProfesionalServicios6) ;
      AV28SDTProfesionalEspecialidadSedes = GXv_objcol_SdtSDTProfesionalEspecialidadSede1[0] ;
      AV27SDTProfesionalInformacionGenerals = GXv_objcol_SdtSDTProfesionalInformacionGeneral2[0] ;
      AV20SDTProfesionalEducacions = GXv_objcol_SdtSDTProfesionalEducacion3[0] ;
      AV21SDTProfesionalExperienciaLaborals = GXv_objcol_SdtSDTProfesionalExperienciaLaboral4[0] ;
      AV22SDTProfesionalPremioss = GXv_objcol_SdtSDTProfesionalPremios5[0] ;
      AV23SDTProfesionalServicioss = GXv_objcol_SdtSDTProfesionalServicios6[0] ;
      gx_BV161 = true ;
      gx_BV40 = true ;
      gx_BV183 = true ;
      gx_BV208 = true ;
      gx_BV232 = true ;
      gx_BV255 = true ;
      Wizard_wizardip_Tabsinternalname = "GXUITabsPanel_WizardIP" ;
      ucWizard_wizardip.sendProperty(context, "", false, Wizard_wizardip_Internalname, "TabsInternalName", Wizard_wizardip_Tabsinternalname);
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

   public void e242O2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      AV14GridSDTProfesionalServiciossCurrentPage = subgridsdtprofesionalservicioss_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14GridSDTProfesionalServiciossCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14GridSDTProfesionalServiciossCurrentPage), 10, 0));
      AV15GridSDTProfesionalServiciossPageCount = subgridsdtprofesionalservicioss_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15GridSDTProfesionalServiciossPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15GridSDTProfesionalServiciossPageCount), 10, 0));
      AV12GridSDTProfesionalPremiossCurrentPage = subgridsdtprofesionalpremioss_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12GridSDTProfesionalPremiossCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12GridSDTProfesionalPremiossCurrentPage), 10, 0));
      AV13GridSDTProfesionalPremiossPageCount = subgridsdtprofesionalpremioss_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13GridSDTProfesionalPremiossPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13GridSDTProfesionalPremiossPageCount), 10, 0));
      AV10GridSDTProfesionalExperienciaLaboralsCurrentPage = subgridsdtprofesionalexperiencialaborals_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10GridSDTProfesionalExperienciaLaboralsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10GridSDTProfesionalExperienciaLaboralsCurrentPage), 10, 0));
      AV11GridSDTProfesionalExperienciaLaboralsPageCount = subgridsdtprofesionalexperiencialaborals_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11GridSDTProfesionalExperienciaLaboralsPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11GridSDTProfesionalExperienciaLaboralsPageCount), 10, 0));
      AV8GridSDTProfesionalEducacionsCurrentPage = subgridsdtprofesionaleducacions_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8GridSDTProfesionalEducacionsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8GridSDTProfesionalEducacionsCurrentPage), 10, 0));
      AV9GridSDTProfesionalEducacionsPageCount = subgridsdtprofesionaleducacions_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9GridSDTProfesionalEducacionsPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9GridSDTProfesionalEducacionsPageCount), 10, 0));
      AV29GridSDTProfesionalEspecialidadSedesCurrentPage = subgridsdtprofesionalespecialidadsedes_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29GridSDTProfesionalEspecialidadSedesCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29GridSDTProfesionalEspecialidadSedesCurrentPage), 10, 0));
      AV30GridSDTProfesionalEspecialidadSedesPageCount = subgridsdtprofesionalespecialidadsedes_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30GridSDTProfesionalEspecialidadSedesPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GridSDTProfesionalEspecialidadSedesPageCount), 10, 0));
      /*  Sending Event outputs  */
   }

   private void e252O2( )
   {
      /* Freestylegridinformaciongeneral_Load Routine */
      returnInSub = false ;
      AV33GXV1 = 1 ;
      while ( AV33GXV1 <= AV27SDTProfesionalInformacionGenerals.size() )
      {
         AV27SDTProfesionalInformacionGenerals.currentItem( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(40) ;
         }
         sendrow_402( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_40_Refreshing )
         {
            httpContext.doAjaxLoad(40, FreestylegridinformaciongeneralRow);
         }
         AV33GXV1 = (int)(AV33GXV1+1) ;
      }
   }

   public void e202O2( )
   {
      /* Gridsdtprofesionalserviciosspaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtprofesionalserviciosspaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtprofesionalservicioss_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtprofesionalserviciosspaginationbar_Selectedpage, "Next") == 0 )
      {
         AV18PageToGo = subgridsdtprofesionalservicioss_fnc_currentpage( ) ;
         AV18PageToGo = (int)(AV18PageToGo+1) ;
         subgridsdtprofesionalservicioss_gotopage( AV18PageToGo) ;
      }
      else
      {
         AV18PageToGo = (int)(GXutil.lval( Gridsdtprofesionalserviciosspaginationbar_Selectedpage)) ;
         subgridsdtprofesionalservicioss_gotopage( AV18PageToGo) ;
      }
   }

   public void e212O2( )
   {
      /* Gridsdtprofesionalserviciosspaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtprofesionalservicioss_Rows = Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtprofesionalservicioss_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e182O2( )
   {
      /* Gridsdtprofesionalpremiosspaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtprofesionalpremiosspaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtprofesionalpremioss_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtprofesionalpremiosspaginationbar_Selectedpage, "Next") == 0 )
      {
         AV18PageToGo = subgridsdtprofesionalpremioss_fnc_currentpage( ) ;
         AV18PageToGo = (int)(AV18PageToGo+1) ;
         subgridsdtprofesionalpremioss_gotopage( AV18PageToGo) ;
      }
      else
      {
         AV18PageToGo = (int)(GXutil.lval( Gridsdtprofesionalpremiosspaginationbar_Selectedpage)) ;
         subgridsdtprofesionalpremioss_gotopage( AV18PageToGo) ;
      }
   }

   public void e192O2( )
   {
      /* Gridsdtprofesionalpremiosspaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtprofesionalpremioss_Rows = Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtprofesionalpremioss_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e162O2( )
   {
      /* Gridsdtprofesionalexperiencialaboralspaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtprofesionalexperiencialaborals_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage, "Next") == 0 )
      {
         AV18PageToGo = subgridsdtprofesionalexperiencialaborals_fnc_currentpage( ) ;
         AV18PageToGo = (int)(AV18PageToGo+1) ;
         subgridsdtprofesionalexperiencialaborals_gotopage( AV18PageToGo) ;
      }
      else
      {
         AV18PageToGo = (int)(GXutil.lval( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage)) ;
         subgridsdtprofesionalexperiencialaborals_gotopage( AV18PageToGo) ;
      }
   }

   public void e172O2( )
   {
      /* Gridsdtprofesionalexperiencialaboralspaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtprofesionalexperiencialaborals_Rows = Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtprofesionalexperiencialaborals_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e142O2( )
   {
      /* Gridsdtprofesionaleducacionspaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtprofesionaleducacionspaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtprofesionaleducacions_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtprofesionaleducacionspaginationbar_Selectedpage, "Next") == 0 )
      {
         AV18PageToGo = subgridsdtprofesionaleducacions_fnc_currentpage( ) ;
         AV18PageToGo = (int)(AV18PageToGo+1) ;
         subgridsdtprofesionaleducacions_gotopage( AV18PageToGo) ;
      }
      else
      {
         AV18PageToGo = (int)(GXutil.lval( Gridsdtprofesionaleducacionspaginationbar_Selectedpage)) ;
         subgridsdtprofesionaleducacions_gotopage( AV18PageToGo) ;
      }
   }

   public void e152O2( )
   {
      /* Gridsdtprofesionaleducacionspaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtprofesionaleducacions_Rows = Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtprofesionaleducacions_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e122O2( )
   {
      /* Gridsdtprofesionalespecialidadsedespaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtprofesionalespecialidadsedes_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage, "Next") == 0 )
      {
         AV18PageToGo = subgridsdtprofesionalespecialidadsedes_fnc_currentpage( ) ;
         AV18PageToGo = (int)(AV18PageToGo+1) ;
         subgridsdtprofesionalespecialidadsedes_gotopage( AV18PageToGo) ;
      }
      else
      {
         AV18PageToGo = (int)(GXutil.lval( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage)) ;
         subgridsdtprofesionalespecialidadsedes_gotopage( AV18PageToGo) ;
      }
   }

   public void e132O2( )
   {
      /* Gridsdtprofesionalespecialidadsedespaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtprofesionalespecialidadsedes_Rows = Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtprofesionalespecialidadsedes_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e222O2( )
   {
      /* 'DoActivarCuenta' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV7Error ;
      new com.projectthani.prcverificarcuentaprofesional(remoteHandle, context).execute( AV19ProfesionalId, GXv_char7) ;
      wpinformaciondetalladadelprofesional_impl.this.AV7Error = GXv_char7[0] ;
      if ( GXutil.strcmp(AV7Error, "Ok") == 0 )
      {
         this.executeExternalObjectMethod("", false, "AV25SweetAlert", "successAlert", new Object[] {"success","Se activó la cuenta del profesional satisfactoriamente.",""}, false);
         callWebObject(formatLink("com.projectthani.wpactivarcuentaprofesional", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         this.executeExternalObjectMethod("", false, "AV25SweetAlert", "successAlert", new Object[] {"error","Error en activar la cuenta del profesional.",""}, false);
         callWebObject(formatLink("com.projectthani.wpactivarcuentaprofesional", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
   }

   public void S112( )
   {
      /* 'CHECKREQUIREDFIELDS_TABINFORMACIONGENERAL' Routine */
      returnInSub = false ;
      AV5CheckRequiredFieldsResult = true ;
   }

   public void S122( )
   {
      /* 'CHECKREQUIREDFIELDS_TABESPECIALIDAD' Routine */
      returnInSub = false ;
      AV5CheckRequiredFieldsResult = true ;
   }

   public void S132( )
   {
      /* 'CHECKREQUIREDFIELDS_TABEDUCACION' Routine */
      returnInSub = false ;
      AV5CheckRequiredFieldsResult = true ;
   }

   public void S142( )
   {
      /* 'CHECKREQUIREDFIELDS_TABEXPERIENCIALABORAL' Routine */
      returnInSub = false ;
      AV5CheckRequiredFieldsResult = true ;
   }

   public void S152( )
   {
      /* 'CHECKREQUIREDFIELDS_TABPREMIOS' Routine */
      returnInSub = false ;
      AV5CheckRequiredFieldsResult = true ;
   }

   private void e302O3( )
   {
      /* Gridsdtprofesionalservicioss_Load Routine */
      returnInSub = false ;
      AV78GXV46 = 1 ;
      while ( AV78GXV46 <= AV23SDTProfesionalServicioss.size() )
      {
         AV23SDTProfesionalServicioss.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV23SDTProfesionalServicioss.elementAt(-1+AV78GXV46)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(255) ;
         }
         if ( ( subGridsdtprofesionalservicioss_Islastpage == 1 ) || ( subGridsdtprofesionalservicioss_Rows == 0 ) || ( ( GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord >= GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage ) && ( GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord < GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage + subgridsdtprofesionalservicioss_fnc_recordsperpage( ) ) ) )
         {
            sendrow_2553( ) ;
            GRIDSDTPROFESIONALSERVICIOSS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord + 1 >= subgridsdtprofesionalservicioss_fnc_recordcount( ) )
            {
               GRIDSDTPROFESIONALSERVICIOSS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord = (long)(GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_255_Refreshing )
         {
            httpContext.doAjaxLoad(255, GridsdtprofesionalserviciossRow);
         }
         AV78GXV46 = (int)(AV78GXV46+1) ;
      }
   }

   private void e292O4( )
   {
      /* Gridsdtprofesionalpremioss_Load Routine */
      returnInSub = false ;
      AV73GXV41 = 1 ;
      while ( AV73GXV41 <= AV22SDTProfesionalPremioss.size() )
      {
         AV22SDTProfesionalPremioss.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV22SDTProfesionalPremioss.elementAt(-1+AV73GXV41)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(232) ;
         }
         if ( ( subGridsdtprofesionalpremioss_Islastpage == 1 ) || ( subGridsdtprofesionalpremioss_Rows == 0 ) || ( ( GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord >= GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage ) && ( GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord < GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage + subgridsdtprofesionalpremioss_fnc_recordsperpage( ) ) ) )
         {
            sendrow_2324( ) ;
            GRIDSDTPROFESIONALPREMIOSS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord + 1 >= subgridsdtprofesionalpremioss_fnc_recordcount( ) )
            {
               GRIDSDTPROFESIONALPREMIOSS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord = (long)(GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_232_Refreshing )
         {
            httpContext.doAjaxLoad(232, GridsdtprofesionalpremiossRow);
         }
         AV73GXV41 = (int)(AV73GXV41+1) ;
      }
   }

   private void e282O5( )
   {
      /* Gridsdtprofesionalexperiencialaborals_Load Routine */
      returnInSub = false ;
      AV68GXV36 = 1 ;
      while ( AV68GXV36 <= AV21SDTProfesionalExperienciaLaborals.size() )
      {
         AV21SDTProfesionalExperienciaLaborals.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV21SDTProfesionalExperienciaLaborals.elementAt(-1+AV68GXV36)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(208) ;
         }
         if ( ( subGridsdtprofesionalexperiencialaborals_Islastpage == 1 ) || ( subGridsdtprofesionalexperiencialaborals_Rows == 0 ) || ( ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord >= GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage ) && ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord < GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage + subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( ) ) ) )
         {
            sendrow_2085( ) ;
            GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord + 1 >= subgridsdtprofesionalexperiencialaborals_fnc_recordcount( ) )
            {
               GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord = (long)(GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_208_Refreshing )
         {
            httpContext.doAjaxLoad(208, GridsdtprofesionalexperiencialaboralsRow);
         }
         AV68GXV36 = (int)(AV68GXV36+1) ;
      }
   }

   private void e272O6( )
   {
      /* Gridsdtprofesionaleducacions_Load Routine */
      returnInSub = false ;
      AV62GXV30 = 1 ;
      while ( AV62GXV30 <= AV20SDTProfesionalEducacions.size() )
      {
         AV20SDTProfesionalEducacions.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(183) ;
         }
         if ( ( subGridsdtprofesionaleducacions_Islastpage == 1 ) || ( subGridsdtprofesionaleducacions_Rows == 0 ) || ( ( GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord >= GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage ) && ( GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord < GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage + subgridsdtprofesionaleducacions_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1836( ) ;
            GRIDSDTPROFESIONALEDUCACIONS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord + 1 >= subgridsdtprofesionaleducacions_fnc_recordcount( ) )
            {
               GRIDSDTPROFESIONALEDUCACIONS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord = (long)(GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_183_Refreshing )
         {
            httpContext.doAjaxLoad(183, GridsdtprofesionaleducacionsRow);
         }
         AV62GXV30 = (int)(AV62GXV30+1) ;
      }
   }

   private void e262O7( )
   {
      /* Gridsdtprofesionalespecialidadsedes_Load Routine */
      returnInSub = false ;
      AV58GXV26 = 1 ;
      while ( AV58GXV26 <= AV28SDTProfesionalEspecialidadSedes.size() )
      {
         AV28SDTProfesionalEspecialidadSedes.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(161) ;
         }
         if ( ( subGridsdtprofesionalespecialidadsedes_Islastpage == 1 ) || ( subGridsdtprofesionalespecialidadsedes_Rows == 0 ) || ( ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord >= GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage ) && ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord < GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage + subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1617( ) ;
            GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord + 1 >= subgridsdtprofesionalespecialidadsedes_fnc_recordcount( ) )
            {
               GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord = (long)(GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_161_Refreshing )
         {
            httpContext.doAjaxLoad(161, GridsdtprofesionalespecialidadsedesRow);
         }
         AV58GXV26 = (int)(AV58GXV26+1) ;
      }
   }

   public void wb_table5_249_2O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelservicios_Internalname, tblPanelservicios_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalserviciossContainer"+"DivS\" data-gxgridid=\"255\">") ;
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
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "Servicios Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Del Servicio") ;
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
            GridsdtprofesionalserviciossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalservicioss__serviciosid_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddColumnProperties(GridsdtprofesionalserviciossColumn);
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
      if ( wbEnd == 255 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_255 = (int)(nGXsfl_255_idx-1) ;
         if ( GridsdtprofesionalserviciossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV78GXV46 = nGXsfl_255_idx ;
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
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("CurrentPage", AV14GridSDTProfesionalServiciossCurrentPage);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("PageCount", AV15GridSDTProfesionalServiciossPageCount);
         ucGridsdtprofesionalserviciosspaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtprofesionalserviciosspaginationbar_Internalname, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_249_2O2e( true) ;
      }
      else
      {
         wb_table5_249_2O2e( false) ;
      }
   }

   public void wb_table4_226_2O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelpremios_Internalname, tblPanelpremios_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalpremiossContainer"+"DivS\" data-gxgridid=\"232\">") ;
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
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "Premios Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Del Premio") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Fecha") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Descripcion Del Premio") ;
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
            GridsdtprofesionalpremiossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalpremioss__premiosid_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddColumnProperties(GridsdtprofesionalpremiossColumn);
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
      if ( wbEnd == 232 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_232 = (int)(nGXsfl_232_idx-1) ;
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV73GXV41 = nGXsfl_232_idx ;
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
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("CurrentPage", AV12GridSDTProfesionalPremiossCurrentPage);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("PageCount", AV13GridSDTProfesionalPremiossPageCount);
         ucGridsdtprofesionalpremiosspaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtprofesionalpremiosspaginationbar_Internalname, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_226_2O2e( true) ;
      }
      else
      {
         wb_table4_226_2O2e( false) ;
      }
   }

   public void wb_table3_202_2O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelexperiencialaboral_Internalname, tblPanelexperiencialaboral_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td rowspan=\"2\"  class='HasGridEmpowerer'>") ;
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
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalexperiencialaboralsContainer"+"DivS\" data-gxgridid=\"208\">") ;
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
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "Experiencia Laboral Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombre De La Empresa ") ;
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
            GridsdtprofesionalexperiencialaboralsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddColumnProperties(GridsdtprofesionalexperiencialaboralsColumn);
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
      if ( wbEnd == 208 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_208 = (int)(nGXsfl_208_idx-1) ;
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV68GXV36 = nGXsfl_208_idx ;
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
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("CurrentPage", AV10GridSDTProfesionalExperienciaLaboralsCurrentPage);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("PageCount", AV11GridSDTProfesionalExperienciaLaboralsPageCount);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtprofesionalexperiencialaboralspaginationbar_Internalname, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_202_2O2e( true) ;
      }
      else
      {
         wb_table3_202_2O2e( false) ;
      }
   }

   public void wb_table2_177_2O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPaneleducacion_Internalname, tblPaneleducacion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td rowspan=\"2\"  class='HasGridEmpowerer'>") ;
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
            httpContext.writeText( "<div id=\""+"GridsdtprofesionaleducacionsContainer"+"DivS\" data-gxgridid=\"183\">") ;
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
            httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombre De La Institucion") ;
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
            GridsdtprofesionaleducacionsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionaleducacions__educacionid_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddColumnProperties(GridsdtprofesionaleducacionsColumn);
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
      if ( wbEnd == 183 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_183 = (int)(nGXsfl_183_idx-1) ;
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV62GXV30 = nGXsfl_183_idx ;
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
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("CurrentPage", AV8GridSDTProfesionalEducacionsCurrentPage);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("PageCount", AV9GridSDTProfesionalEducacionsPageCount);
         ucGridsdtprofesionaleducacionspaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtprofesionaleducacionspaginationbar_Internalname, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_177_2O2e( true) ;
      }
      else
      {
         wb_table2_177_2O2e( false) ;
      }
   }

   public void wb_table1_155_2O2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelespecialidad_Internalname, tblPanelespecialidad_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalespecialidadsedesContainer"+"DivS\" data-gxgridid=\"161\">") ;
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
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Consulta") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Costo Consulta") ;
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
            GridsdtprofesionalespecialidadsedesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddColumnProperties(GridsdtprofesionalespecialidadsedesColumn);
            GridsdtprofesionalespecialidadsedesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalespecialidadsedesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddColumnProperties(GridsdtprofesionalespecialidadsedesColumn);
            GridsdtprofesionalespecialidadsedesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalespecialidadsedesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      if ( wbEnd == 161 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_161 = (int)(nGXsfl_161_idx-1) ;
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV58GXV26 = nGXsfl_161_idx ;
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
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("CurrentPage", AV29GridSDTProfesionalEspecialidadSedesCurrentPage);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("PageCount", AV30GridSDTProfesionalEspecialidadSedesPageCount);
         ucGridsdtprofesionalespecialidadsedespaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtprofesionalespecialidadsedespaginationbar_Internalname, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_155_2O2e( true) ;
      }
      else
      {
         wb_table1_155_2O2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV19ProfesionalId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ProfesionalId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV19ProfesionalId), "ZZZZZZZ9")));
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
      pa2O2( ) ;
      ws2O2( ) ;
      we2O2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110341091", true, true);
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
      httpContext.AddJavascriptSource("wpinformaciondetalladadelprofesional.js", "?20225110341091", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
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
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
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
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVTabsTransform/DVTabsTransformRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_402( )
   {
      edtavSdtprofesionalinformaciongenerals__profesionalfoto_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFOTO_"+sGXsfl_40_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTIPODOCUMENTO_"+sGXsfl_40_idx );
      edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALNRODOCUMENTO_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALAPELLIDOPATERNO_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALAPELLIDOMATERNO_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalnombres_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALNOMBRES_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFECHANACIMIENTO_"+sGXsfl_40_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALSEXO_"+sGXsfl_40_idx );
      edtavSdtprofesionalinformaciongenerals__profesionalcop_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALCOP_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTELEFONO_"+sGXsfl_40_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTIEMPOCITA_"+sGXsfl_40_idx );
      edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALCORREO_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALDIRECCION_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__paisdescripcion_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PAISDESCRIPCION_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__UBIGEODEPARTAMENTO_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__UBIGEOPROVINCIA_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__UBIGEODISTRITO_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTWITTER_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFACEBOOK_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALINSTAGRAM_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALLINKEDIN_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALDESCRIPCION_"+sGXsfl_40_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFECHAREGISTRO_"+sGXsfl_40_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALESTADO_"+sGXsfl_40_idx );
   }

   public void subsflControlProps_fel_402( )
   {
      edtavSdtprofesionalinformaciongenerals__profesionalfoto_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFOTO_"+sGXsfl_40_fel_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTIPODOCUMENTO_"+sGXsfl_40_fel_idx );
      edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALNRODOCUMENTO_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALAPELLIDOPATERNO_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALAPELLIDOMATERNO_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalnombres_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALNOMBRES_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFECHANACIMIENTO_"+sGXsfl_40_fel_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALSEXO_"+sGXsfl_40_fel_idx );
      edtavSdtprofesionalinformaciongenerals__profesionalcop_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALCOP_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTELEFONO_"+sGXsfl_40_fel_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTIEMPOCITA_"+sGXsfl_40_fel_idx );
      edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALCORREO_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALDIRECCION_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__paisdescripcion_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PAISDESCRIPCION_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__UBIGEODEPARTAMENTO_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__UBIGEOPROVINCIA_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__UBIGEODISTRITO_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTWITTER_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFACEBOOK_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALINSTAGRAM_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALLINKEDIN_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALDESCRIPCION_"+sGXsfl_40_fel_idx ;
      edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFECHAREGISTRO_"+sGXsfl_40_fel_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALESTADO_"+sGXsfl_40_fel_idx );
   }

   public void sendrow_402( )
   {
      subsflControlProps_402( ) ;
      wb2O0( ) ;
      FreestylegridinformaciongeneralRow = GXWebRow.GetNew(context,FreestylegridinformaciongeneralContainer) ;
      if ( subFreestylegridinformaciongeneral_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subFreestylegridinformaciongeneral_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subFreestylegridinformaciongeneral_Class, "") != 0 )
         {
            subFreestylegridinformaciongeneral_Linesclass = subFreestylegridinformaciongeneral_Class+"Odd" ;
         }
      }
      else if ( subFreestylegridinformaciongeneral_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subFreestylegridinformaciongeneral_Backstyle = (byte)(0) ;
         subFreestylegridinformaciongeneral_Backcolor = subFreestylegridinformaciongeneral_Allbackcolor ;
         if ( GXutil.strcmp(subFreestylegridinformaciongeneral_Class, "") != 0 )
         {
            subFreestylegridinformaciongeneral_Linesclass = subFreestylegridinformaciongeneral_Class+"Uniform" ;
         }
      }
      else if ( subFreestylegridinformaciongeneral_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subFreestylegridinformaciongeneral_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subFreestylegridinformaciongeneral_Class, "") != 0 )
         {
            subFreestylegridinformaciongeneral_Linesclass = subFreestylegridinformaciongeneral_Class+"Odd" ;
         }
         subFreestylegridinformaciongeneral_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subFreestylegridinformaciongeneral_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subFreestylegridinformaciongeneral_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_40_idx) % (2))) == 0 )
         {
            subFreestylegridinformaciongeneral_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subFreestylegridinformaciongeneral_Class, "") != 0 )
            {
               subFreestylegridinformaciongeneral_Linesclass = subFreestylegridinformaciongeneral_Class+"Even" ;
            }
         }
         else
         {
            subFreestylegridinformaciongeneral_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subFreestylegridinformaciongeneral_Class, "") != 0 )
            {
               subFreestylegridinformaciongeneral_Linesclass = subFreestylegridinformaciongeneral_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( FreestylegridinformaciongeneralContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subFreestylegridinformaciongeneral_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_40_idx+"\">") ;
      }
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsfreestylegridinformaciongeneral_Internalname+"_"+sGXsfl_40_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalfoto_Internalname+"\"","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Static Bitmap Variable */
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      sImgUrl = httpContext.getResourceRelative(((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfoto()) ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalfoto_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getInternalname(),"Tipo Documento"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      if ( ( cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTIPODOCUMENTO_" + sGXsfl_40_idx ;
         cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setName( GXCCtl );
         cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setWebtags( "" );
         cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("1", "DNI", (short)(0));
         cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("6", "RUC", (short)(0));
         cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
         cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
         cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("7", "PASAPORTE", (short)(0));
         cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
         if ( cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getItemCount() > 0 )
         {
            if ( ( AV33GXV1 > 0 ) && ( AV27SDTProfesionalInformacionGenerals.size() >= AV33GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento())==0) )
            {
               ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento( cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getValidValue(((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento()) );
            }
         }
      }
      /* ComboBox */
      FreestylegridinformaciongeneralRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento,cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento()),Integer.valueOf(1),cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","ReadonlyAttribute","","","","",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getInternalname(), "Values", cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.ToJavascriptSource(), !bGXsfl_40_Refreshing);
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Internalname,"Nro Documento"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnrodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Internalname,"Apellido Paterno"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidopaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(50),"chr",Integer.valueOf(1),"row",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Internalname,"Apellido Materno"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalapellidomaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(50),"chr",Integer.valueOf(1),"row",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalnombres_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalnombres_Internalname,"Nombres"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalnombres_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalnombres(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionalnombres_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionalnombres_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(50),"chr",Integer.valueOf(1),"row",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Internalname,"Fecha Nacimiento"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      sendrow_40230( ) ;
   }

   public void sendrow_40230( )
   {
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento(), "99/99/9999"),localUtil.format( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfechanacimiento(), "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getInternalname(),"Sexo"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      if ( ( cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALSEXO_" + sGXsfl_40_idx ;
         cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setName( GXCCtl );
         cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setWebtags( "" );
         cmbavSdtprofesionalinformaciongenerals__profesionalsexo.addItem("M", "Masculino", (short)(0));
         cmbavSdtprofesionalinformaciongenerals__profesionalsexo.addItem("F", "Femenino", (short)(0));
         if ( cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getItemCount() > 0 )
         {
            if ( ( AV33GXV1 > 0 ) && ( AV27SDTProfesionalInformacionGenerals.size() >= AV33GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo())==0) )
            {
               ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo( cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getValidValue(((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo()) );
            }
         }
      }
      /* ComboBox */
      FreestylegridinformaciongeneralRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtprofesionalinformaciongenerals__profesionalsexo,cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo()),Integer.valueOf(1),cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","ReadonlyAttribute","","","","",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getInternalname(), "Values", cmbavSdtprofesionalinformaciongenerals__profesionalsexo.ToJavascriptSource(), !bGXsfl_40_Refreshing);
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalcop_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalcop_Internalname,"CMP"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalcop_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcop(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionalcop_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionalcop_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Internalname,"Telefono"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Internalname,GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltelefono()),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(20),"chr",Integer.valueOf(1),"row",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getInternalname(),"Tiempo Cita"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      if ( ( cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTIEMPOCITA_" + sGXsfl_40_idx ;
         cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setName( GXCCtl );
         cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setWebtags( "" );
         cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.addItem("30", "30 minutos", (short)(0));
         cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.addItem("60", "1 hora", (short)(0));
         if ( cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getItemCount() > 0 )
         {
            if ( ( AV33GXV1 > 0 ) && ( AV27SDTProfesionalInformacionGenerals.size() >= AV33GXV1 ) && (0==((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita()) )
            {
               ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita( (byte)(GXutil.lval( cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getValidValue(GXutil.trim( GXutil.str( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita(), 2, 0))))) );
            }
         }
      }
      /* ComboBox */
      FreestylegridinformaciongeneralRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita,cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getInternalname(),GXutil.trim( GXutil.str( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita(), 2, 0)),Integer.valueOf(1),cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(1),Integer.valueOf(cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","ReadonlyAttribute","","","","",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setValue( GXutil.trim( GXutil.str( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita(), 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getInternalname(), "Values", cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.ToJavascriptSource(), !bGXsfl_40_Refreshing);
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Internalname,"Correo"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalcorreo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Internalname,"Direccion"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldireccion(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__paisdescripcion_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__paisdescripcion_Internalname,"Pais"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      sendrow_40260( ) ;
   }

   public void sendrow_40260( )
   {
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__paisdescripcion_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Paisdescripcion(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__paisdescripcion_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__paisdescripcion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Internalname,"Departamento"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodepartamento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Internalname,"Provincia"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeoprovincia(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Internalname,"Distrito"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Ubigeodistrito(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Internalname,"Url Twitter"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltwitter(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Internalname,"Url  Facebook"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfacebook(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Internalname,"Url  Instagram"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalinstagram(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Internalname,"Url  Linkedin"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      sendrow_40290( ) ;
   }

   public void sendrow_40290( )
   {
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionallinkedin(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Internalname,"Acerca del Profesional "," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Internalname,((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaldescripcion(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",StyleString,ClassString,"","","5000",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Internalname,"Fecha Registro"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      FreestylegridinformaciongeneralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalfecharegistro(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 DscTop","left","top","","","div"});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavSdtprofesionalinformaciongenerals__profesionalestado.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      FreestylegridinformaciongeneralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavSdtprofesionalinformaciongenerals__profesionalestado.getInternalname(),"Estado Profesional"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      if ( ( cmbavSdtprofesionalinformaciongenerals__profesionalestado.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALESTADO_" + sGXsfl_40_idx ;
         cmbavSdtprofesionalinformaciongenerals__profesionalestado.setName( GXCCtl );
         cmbavSdtprofesionalinformaciongenerals__profesionalestado.setWebtags( "" );
         cmbavSdtprofesionalinformaciongenerals__profesionalestado.addItem("A", "Activo", (short)(0));
         cmbavSdtprofesionalinformaciongenerals__profesionalestado.addItem("P", "Pendiente", (short)(0));
         cmbavSdtprofesionalinformaciongenerals__profesionalestado.addItem("I", "Inactivo", (short)(0));
         if ( cmbavSdtprofesionalinformaciongenerals__profesionalestado.getItemCount() > 0 )
         {
            if ( ( AV33GXV1 > 0 ) && ( AV27SDTProfesionalInformacionGenerals.size() >= AV33GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado())==0) )
            {
               ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado( cmbavSdtprofesionalinformaciongenerals__profesionalestado.getValidValue(((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado()) );
            }
         }
      }
      /* ComboBox */
      FreestylegridinformaciongeneralRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtprofesionalinformaciongenerals__profesionalestado,cmbavSdtprofesionalinformaciongenerals__profesionalestado.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado()),Integer.valueOf(1),cmbavSdtprofesionalinformaciongenerals__profesionalestado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(cmbavSdtprofesionalinformaciongenerals__profesionalestado.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","ReadonlyAttribute","","","","",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalinformaciongenerals__profesionalestado.getInternalname(), "Values", cmbavSdtprofesionalinformaciongenerals__profesionalestado.ToJavascriptSource(), !bGXsfl_40_Refreshing);
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      FreestylegridinformaciongeneralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes2O2( ) ;
      /* End of Columns property logic. */
      FreestylegridinformaciongeneralContainer.AddRow(FreestylegridinformaciongeneralRow);
      nGXsfl_40_idx = ((subFreestylegridinformaciongeneral_Islastpage==1)&&(nGXsfl_40_idx+1>subfreestylegridinformaciongeneral_fnc_recordsperpage( )) ? 1 : nGXsfl_40_idx+1) ;
      sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_402( ) ;
      /* End function sendrow_402 */
   }

   public void subsflControlProps_1617( )
   {
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADNOMBRE_"+sGXsfl_161_idx ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setInternalname( "SDTPROFESIONALESPECIALIDADSEDES__SEDETIPOCONSULTA_"+sGXsfl_161_idx );
      edtavSdtprofesionalespecialidadsedes__costoconsulta_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__COSTOCONSULTA_"+sGXsfl_161_idx ;
   }

   public void subsflControlProps_fel_1617( )
   {
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADNOMBRE_"+sGXsfl_161_fel_idx ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setInternalname( "SDTPROFESIONALESPECIALIDADSEDES__SEDETIPOCONSULTA_"+sGXsfl_161_fel_idx );
      edtavSdtprofesionalespecialidadsedes__costoconsulta_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__COSTOCONSULTA_"+sGXsfl_161_fel_idx ;
   }

   public void sendrow_1617( )
   {
      subsflControlProps_1617( ) ;
      wb2O0( ) ;
      if ( ( subGridsdtprofesionalespecialidadsedes_Rows * 1 == 0 ) || ( nGXsfl_161_idx <= subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_161_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_161_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalespecialidadsedesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname,((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalespecialidadsedes__especialidadnombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(161),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SDTPROFESIONALESPECIALIDADSEDES__SEDETIPOCONSULTA_" + sGXsfl_161_idx ;
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setName( GXCCtl );
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setWebtags( "" );
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("", "Seleccione tipo de consulta", (short)(0));
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("V", "Virtual", (short)(0));
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("P", "En consultorio", (short)(0));
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
            if ( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getItemCount() > 0 )
            {
               if ( ( AV58GXV26 > 0 ) && ( AV28SDTProfesionalEspecialidadSedes.size() >= AV58GXV26 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta())==0) )
               {
                  ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).setgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getValidValue(((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()) );
               }
            }
         }
         /* ComboBox */
         GridsdtprofesionalespecialidadsedesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta,cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()),Integer.valueOf(1),cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(false),Integer.valueOf(1)});
         cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getInternalname(), "Values", cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.ToJavascriptSource(), !bGXsfl_161_Refreshing);
         /* Subfile cell */
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalespecialidadsedesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalespecialidadsedes__costoconsulta_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).getgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta(), (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( ((edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled!=0) ? localUtil.format( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).getgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta(), "ZZ9.99") : localUtil.format( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).getgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta(), "ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalespecialidadsedes__costoconsulta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(161),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes2O7( ) ;
         GridsdtprofesionalespecialidadsedesContainer.AddRow(GridsdtprofesionalespecialidadsedesRow);
         nGXsfl_161_idx = ((subGridsdtprofesionalespecialidadsedes_Islastpage==1)&&(nGXsfl_161_idx+1>subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )) ? 1 : nGXsfl_161_idx+1) ;
         sGXsfl_161_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_161_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1617( ) ;
      }
      /* End function sendrow_1617 */
   }

   public void subsflControlProps_1836( )
   {
      edtavSdtprofesionaleducacions__educacionid_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONID_"+sGXsfl_183_idx ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONNOMBREINSTITUCION_"+sGXsfl_183_idx ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONPAISDESCRIPCION_"+sGXsfl_183_idx ;
      edtavSdtprofesionaleducacions__educaciondesde_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONDESDE_"+sGXsfl_183_idx ;
      edtavSdtprofesionaleducacions__educacionhasta_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONHASTA_"+sGXsfl_183_idx ;
   }

   public void subsflControlProps_fel_1836( )
   {
      edtavSdtprofesionaleducacions__educacionid_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONID_"+sGXsfl_183_fel_idx ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONNOMBREINSTITUCION_"+sGXsfl_183_fel_idx ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONPAISDESCRIPCION_"+sGXsfl_183_fel_idx ;
      edtavSdtprofesionaleducacions__educaciondesde_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONDESDE_"+sGXsfl_183_fel_idx ;
      edtavSdtprofesionaleducacions__educacionhasta_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONHASTA_"+sGXsfl_183_fel_idx ;
   }

   public void sendrow_1836( )
   {
      subsflControlProps_1836( ) ;
      wb2O0( ) ;
      if ( ( subGridsdtprofesionaleducacions_Rows * 1 == 0 ) || ( nGXsfl_183_idx <= subgridsdtprofesionaleducacions_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_183_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_183_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionaleducacionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionaleducacions__educacionid_Internalname,((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)).getgxTv_SdtSDTProfesionalEducacion_Educacionid().toString(),((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)).getgxTv_SdtSDTProfesionalEducacion_Educacionid().toString(),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionaleducacions__educacionid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavSdtprofesionaleducacions__educacionid_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(183),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(false),"","",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionaleducacionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname,((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)).getgxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionaleducacions__educacionnombreinstitucion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(183),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionaleducacionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname,((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)).getgxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionaleducacions__educacionpaisdescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(183),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionaleducacionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionaleducacions__educaciondesde_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)).getgxTv_SdtSDTProfesionalEducacion_Educaciondesde(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)).getgxTv_SdtSDTProfesionalEducacion_Educaciondesde(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionaleducacions__educaciondesde_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionaleducacions__educaciondesde_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(183),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionaleducacionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionaleducacions__educacionhasta_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)).getgxTv_SdtSDTProfesionalEducacion_Educacionhasta(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTProfesionalEducacion)AV20SDTProfesionalEducacions.elementAt(-1+AV62GXV30)).getgxTv_SdtSDTProfesionalEducacion_Educacionhasta(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionaleducacions__educacionhasta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionaleducacions__educacionhasta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(183),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes2O6( ) ;
         GridsdtprofesionaleducacionsContainer.AddRow(GridsdtprofesionaleducacionsRow);
         nGXsfl_183_idx = ((subGridsdtprofesionaleducacions_Islastpage==1)&&(nGXsfl_183_idx+1>subgridsdtprofesionaleducacions_fnc_recordsperpage( )) ? 1 : nGXsfl_183_idx+1) ;
         sGXsfl_183_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_183_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1836( ) ;
      }
      /* End function sendrow_1836 */
   }

   public void subsflControlProps_2085( )
   {
      edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALID_"+sGXsfl_208_idx ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_208_idx ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALDESDE_"+sGXsfl_208_idx ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALHASTA_"+sGXsfl_208_idx ;
   }

   public void subsflControlProps_fel_2085( )
   {
      edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALID_"+sGXsfl_208_fel_idx ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_208_fel_idx ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALDESDE_"+sGXsfl_208_fel_idx ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALHASTA_"+sGXsfl_208_fel_idx ;
   }

   public void sendrow_2085( )
   {
      subsflControlProps_2085( ) ;
      wb2O0( ) ;
      if ( ( subGridsdtprofesionalexperiencialaborals_Rows * 1 == 0 ) || ( nGXsfl_208_idx <= subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_208_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_208_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalexperiencialaboralsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Internalname,((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV21SDTProfesionalExperienciaLaborals.elementAt(-1+AV68GXV36)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid().toString(),((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV21SDTProfesionalExperienciaLaborals.elementAt(-1+AV68GXV36)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid().toString(),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(208),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(false),"","",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalexperiencialaboralsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname,((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV21SDTProfesionalExperienciaLaborals.elementAt(-1+AV68GXV36)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(208),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalexperiencialaboralsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV21SDTProfesionalExperienciaLaborals.elementAt(-1+AV68GXV36)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde(), "99/99/9999"),localUtil.format( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV21SDTProfesionalExperienciaLaborals.elementAt(-1+AV68GXV36)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde(), "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(208),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalexperiencialaboralsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV21SDTProfesionalExperienciaLaborals.elementAt(-1+AV68GXV36)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta(), "99/99/9999"),localUtil.format( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV21SDTProfesionalExperienciaLaborals.elementAt(-1+AV68GXV36)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta(), "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(208),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes2O5( ) ;
         GridsdtprofesionalexperiencialaboralsContainer.AddRow(GridsdtprofesionalexperiencialaboralsRow);
         nGXsfl_208_idx = ((subGridsdtprofesionalexperiencialaborals_Islastpage==1)&&(nGXsfl_208_idx+1>subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )) ? 1 : nGXsfl_208_idx+1) ;
         sGXsfl_208_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_208_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2085( ) ;
      }
      /* End function sendrow_2085 */
   }

   public void subsflControlProps_2324( )
   {
      edtavSdtprofesionalpremioss__premiosid_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSID_"+sGXsfl_232_idx ;
      edtavSdtprofesionalpremioss__premiosnombre_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSNOMBRE_"+sGXsfl_232_idx ;
      edtavSdtprofesionalpremioss__premiosfecha_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSFECHA_"+sGXsfl_232_idx ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSDESCRIPCION_"+sGXsfl_232_idx ;
   }

   public void subsflControlProps_fel_2324( )
   {
      edtavSdtprofesionalpremioss__premiosid_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSID_"+sGXsfl_232_fel_idx ;
      edtavSdtprofesionalpremioss__premiosnombre_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSNOMBRE_"+sGXsfl_232_fel_idx ;
      edtavSdtprofesionalpremioss__premiosfecha_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSFECHA_"+sGXsfl_232_fel_idx ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSDESCRIPCION_"+sGXsfl_232_fel_idx ;
   }

   public void sendrow_2324( )
   {
      subsflControlProps_2324( ) ;
      wb2O0( ) ;
      if ( ( subGridsdtprofesionalpremioss_Rows * 1 == 0 ) || ( nGXsfl_232_idx <= subgridsdtprofesionalpremioss_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_232_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_232_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalpremiossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalpremioss__premiosid_Internalname,((com.projectthani.SdtSDTProfesionalPremios)AV22SDTProfesionalPremioss.elementAt(-1+AV73GXV41)).getgxTv_SdtSDTProfesionalPremios_Premiosid().toString(),((com.projectthani.SdtSDTProfesionalPremios)AV22SDTProfesionalPremioss.elementAt(-1+AV73GXV41)).getgxTv_SdtSDTProfesionalPremios_Premiosid().toString(),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalpremioss__premiosid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavSdtprofesionalpremioss__premiosid_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(232),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(false),"","",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalpremiossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalpremioss__premiosnombre_Internalname,((com.projectthani.SdtSDTProfesionalPremios)AV22SDTProfesionalPremioss.elementAt(-1+AV73GXV41)).getgxTv_SdtSDTProfesionalPremios_Premiosnombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalpremioss__premiosnombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalpremioss__premiosnombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(500),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(232),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalpremiossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalpremioss__premiosfecha_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalPremios)AV22SDTProfesionalPremioss.elementAt(-1+AV73GXV41)).getgxTv_SdtSDTProfesionalPremios_Premiosfecha(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTProfesionalPremios)AV22SDTProfesionalPremioss.elementAt(-1+AV73GXV41)).getgxTv_SdtSDTProfesionalPremios_Premiosfecha(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalpremioss__premiosfecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalpremioss__premiosfecha_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(232),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalpremiossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalpremioss__premiosdescripcion_Internalname,((com.projectthani.SdtSDTProfesionalPremios)AV22SDTProfesionalPremioss.elementAt(-1+AV73GXV41)).getgxTv_SdtSDTProfesionalPremios_Premiosdescripcion(),((com.projectthani.SdtSDTProfesionalPremios)AV22SDTProfesionalPremioss.elementAt(-1+AV73GXV41)).getgxTv_SdtSDTProfesionalPremios_Premiosdescripcion(),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalpremioss__premiosdescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalpremioss__premiosdescripcion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(232),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes2O4( ) ;
         GridsdtprofesionalpremiossContainer.AddRow(GridsdtprofesionalpremiossRow);
         nGXsfl_232_idx = ((subGridsdtprofesionalpremioss_Islastpage==1)&&(nGXsfl_232_idx+1>subgridsdtprofesionalpremioss_fnc_recordsperpage( )) ? 1 : nGXsfl_232_idx+1) ;
         sGXsfl_232_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_232_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2324( ) ;
      }
      /* End function sendrow_2324 */
   }

   public void subsflControlProps_2553( )
   {
      edtavSdtprofesionalservicioss__serviciosid_Internalname = "SDTPROFESIONALSERVICIOSS__SERVICIOSID_"+sGXsfl_255_idx ;
      edtavSdtprofesionalservicioss__serviciosnombre_Internalname = "SDTPROFESIONALSERVICIOSS__SERVICIOSNOMBRE_"+sGXsfl_255_idx ;
   }

   public void subsflControlProps_fel_2553( )
   {
      edtavSdtprofesionalservicioss__serviciosid_Internalname = "SDTPROFESIONALSERVICIOSS__SERVICIOSID_"+sGXsfl_255_fel_idx ;
      edtavSdtprofesionalservicioss__serviciosnombre_Internalname = "SDTPROFESIONALSERVICIOSS__SERVICIOSNOMBRE_"+sGXsfl_255_fel_idx ;
   }

   public void sendrow_2553( )
   {
      subsflControlProps_2553( ) ;
      wb2O0( ) ;
      if ( ( subGridsdtprofesionalservicioss_Rows * 1 == 0 ) || ( nGXsfl_255_idx <= subgridsdtprofesionalservicioss_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_255_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_255_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtprofesionalserviciossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalserviciossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalservicioss__serviciosid_Internalname,((com.projectthani.SdtSDTProfesionalServicios)AV23SDTProfesionalServicioss.elementAt(-1+AV78GXV46)).getgxTv_SdtSDTProfesionalServicios_Serviciosid().toString(),((com.projectthani.SdtSDTProfesionalServicios)AV23SDTProfesionalServicioss.elementAt(-1+AV78GXV46)).getgxTv_SdtSDTProfesionalServicios_Serviciosid().toString(),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalservicioss__serviciosid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavSdtprofesionalservicioss__serviciosid_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(255),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(false),"","",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionalserviciossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalserviciossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalservicioss__serviciosnombre_Internalname,((com.projectthani.SdtSDTProfesionalServicios)AV23SDTProfesionalServicioss.elementAt(-1+AV78GXV46)).getgxTv_SdtSDTProfesionalServicios_Serviciosnombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalservicioss__serviciosnombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalservicioss__serviciosnombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(255),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2O3( ) ;
         GridsdtprofesionalserviciossContainer.AddRow(GridsdtprofesionalserviciossRow);
         nGXsfl_255_idx = ((subGridsdtprofesionalservicioss_Islastpage==1)&&(nGXsfl_255_idx+1>subgridsdtprofesionalservicioss_fnc_recordsperpage( )) ? 1 : nGXsfl_255_idx+1) ;
         sGXsfl_255_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_255_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2553( ) ;
      }
      /* End function sendrow_2553 */
   }

   public void init_default_properties( )
   {
      bttBtnactivarcuenta_Internalname = "BTNACTIVARCUENTA" ;
      bttBtnsalir_Internalname = "BTNSALIR" ;
      divPanelbuttons_Internalname = "PANELBUTTONS" ;
      Dvpanel_panelbuttons_Internalname = "DVPANEL_PANELBUTTONS" ;
      lblTabinformaciongeneral_title_Internalname = "TABINFORMACIONGENERAL_TITLE" ;
      edtavSdtprofesionalinformaciongenerals__profesionalfoto_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFOTO" ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTIPODOCUMENTO" );
      edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALNRODOCUMENTO" ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALAPELLIDOPATERNO" ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALAPELLIDOMATERNO" ;
      edtavSdtprofesionalinformaciongenerals__profesionalnombres_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALNOMBRES" ;
      edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFECHANACIMIENTO" ;
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALSEXO" );
      edtavSdtprofesionalinformaciongenerals__profesionalcop_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALCOP" ;
      edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTELEFONO" ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTIEMPOCITA" );
      edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALCORREO" ;
      edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALDIRECCION" ;
      edtavSdtprofesionalinformaciongenerals__paisdescripcion_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PAISDESCRIPCION" ;
      edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__UBIGEODEPARTAMENTO" ;
      edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__UBIGEOPROVINCIA" ;
      edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__UBIGEODISTRITO" ;
      edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTWITTER" ;
      edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFACEBOOK" ;
      edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALINSTAGRAM" ;
      edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALLINKEDIN" ;
      edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALDESCRIPCION" ;
      edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Internalname = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALFECHAREGISTRO" ;
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setInternalname( "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALESTADO" );
      divUnnamedtablefsfreestylegridinformaciongeneral_Internalname = "UNNAMEDTABLEFSFREESTYLEGRIDINFORMACIONGENERAL" ;
      divPaneinfogeneral_Internalname = "PANEINFOGENERAL" ;
      Dvpanel_paneinfogeneral_Internalname = "DVPANEL_PANEINFOGENERAL" ;
      divTableinformaciongeneral_Internalname = "TABLEINFORMACIONGENERAL" ;
      lblTabespecialidad_title_Internalname = "TABESPECIALIDAD_TITLE" ;
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADNOMBRE" ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setInternalname( "SDTPROFESIONALESPECIALIDADSEDES__SEDETIPOCONSULTA" );
      edtavSdtprofesionalespecialidadsedes__costoconsulta_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__COSTOCONSULTA" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Internalname = "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR" ;
      divGridsdtprofesionalespecialidadsedestablewithpaginationbar_Internalname = "GRIDSDTPROFESIONALESPECIALIDADSEDESTABLEWITHPAGINATIONBAR" ;
      tblPanelespecialidad_Internalname = "PANELESPECIALIDAD" ;
      Dvpanel_panelespecialidad_Internalname = "DVPANEL_PANELESPECIALIDAD" ;
      divTableespecialidad_Internalname = "TABLEESPECIALIDAD" ;
      lblTabeducacion_title_Internalname = "TABEDUCACION_TITLE" ;
      edtavSdtprofesionaleducacions__educacionid_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONID" ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONNOMBREINSTITUCION" ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONPAISDESCRIPCION" ;
      edtavSdtprofesionaleducacions__educaciondesde_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONDESDE" ;
      edtavSdtprofesionaleducacions__educacionhasta_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONHASTA" ;
      Gridsdtprofesionaleducacionspaginationbar_Internalname = "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR" ;
      divGridsdtprofesionaleducacionstablewithpaginationbar_Internalname = "GRIDSDTPROFESIONALEDUCACIONSTABLEWITHPAGINATIONBAR" ;
      tblPaneleducacion_Internalname = "PANELEDUCACION" ;
      Dvpanel_paneleducacion_Internalname = "DVPANEL_PANELEDUCACION" ;
      divTableeducacion_Internalname = "TABLEEDUCACION" ;
      lblTabexperiencialaboral_title_Internalname = "TABEXPERIENCIALABORAL_TITLE" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALID" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALEMPRESANOMBRE" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALDESDE" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALHASTA" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Internalname = "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR" ;
      divGridsdtprofesionalexperiencialaboralstablewithpaginationbar_Internalname = "GRIDSDTPROFESIONALEXPERIENCIALABORALSTABLEWITHPAGINATIONBAR" ;
      tblPanelexperiencialaboral_Internalname = "PANELEXPERIENCIALABORAL" ;
      Dvpanel_panelexperiencialaboral_Internalname = "DVPANEL_PANELEXPERIENCIALABORAL" ;
      divTableexperiencialaboral_Internalname = "TABLEEXPERIENCIALABORAL" ;
      lblTabpremios_title_Internalname = "TABPREMIOS_TITLE" ;
      edtavSdtprofesionalpremioss__premiosid_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSID" ;
      edtavSdtprofesionalpremioss__premiosnombre_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSNOMBRE" ;
      edtavSdtprofesionalpremioss__premiosfecha_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSFECHA" ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSDESCRIPCION" ;
      Gridsdtprofesionalpremiosspaginationbar_Internalname = "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR" ;
      divGridsdtprofesionalpremiosstablewithpaginationbar_Internalname = "GRIDSDTPROFESIONALPREMIOSSTABLEWITHPAGINATIONBAR" ;
      tblPanelpremios_Internalname = "PANELPREMIOS" ;
      Dvpanel_panelpremios_Internalname = "DVPANEL_PANELPREMIOS" ;
      divTablepremios_Internalname = "TABLEPREMIOS" ;
      lblTabservicios_title_Internalname = "TABSERVICIOS_TITLE" ;
      edtavSdtprofesionalservicioss__serviciosid_Internalname = "SDTPROFESIONALSERVICIOSS__SERVICIOSID" ;
      edtavSdtprofesionalservicioss__serviciosnombre_Internalname = "SDTPROFESIONALSERVICIOSS__SERVICIOSNOMBRE" ;
      Gridsdtprofesionalserviciosspaginationbar_Internalname = "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR" ;
      divGridsdtprofesionalserviciosstablewithpaginationbar_Internalname = "GRIDSDTPROFESIONALSERVICIOSSTABLEWITHPAGINATIONBAR" ;
      tblPanelservicios_Internalname = "PANELSERVICIOS" ;
      Dvpanel_panelservicios_Internalname = "DVPANEL_PANELSERVICIOS" ;
      divTableservicios_Internalname = "TABLESERVICIOS" ;
      Gxuitabspanel_wizardip_Internalname = "GXUITABSPANEL_WIZARDIP" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Gridsdtprofesionalservicioss_empowerer_Internalname = "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER" ;
      Gridsdtprofesionalpremioss_empowerer_Internalname = "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER" ;
      Gridsdtprofesionalexperiencialaborals_empowerer_Internalname = "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER" ;
      Gridsdtprofesionaleducacions_empowerer_Internalname = "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER" ;
      Gridsdtprofesionalespecialidadsedes_empowerer_Internalname = "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER" ;
      Wizard_wizardip_Internalname = "WIZARD_WIZARDIP" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subFreestylegridinformaciongeneral_Internalname = "FREESTYLEGRIDINFORMACIONGENERAL" ;
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
      edtavSdtprofesionalservicioss__serviciosid_Jsonclick = "" ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Jsonclick = "" ;
      edtavSdtprofesionalpremioss__premiosfecha_Jsonclick = "" ;
      edtavSdtprofesionalpremioss__premiosnombre_Jsonclick = "" ;
      edtavSdtprofesionalpremioss__premiosid_Jsonclick = "" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Jsonclick = "" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Jsonclick = "" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Jsonclick = "" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Jsonclick = "" ;
      edtavSdtprofesionaleducacions__educacionhasta_Jsonclick = "" ;
      edtavSdtprofesionaleducacions__educaciondesde_Jsonclick = "" ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Jsonclick = "" ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Jsonclick = "" ;
      edtavSdtprofesionaleducacions__educacionid_Jsonclick = "" ;
      edtavSdtprofesionalespecialidadsedes__costoconsulta_Jsonclick = "" ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setJsonclick( "" );
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Jsonclick = "" ;
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setJsonclick( "" );
      edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__paisdescripcion_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Jsonclick = "" ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setJsonclick( "" );
      edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__profesionalcop_Jsonclick = "" ;
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setJsonclick( "" );
      edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__profesionalnombres_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Jsonclick = "" ;
      edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Jsonclick = "" ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setJsonclick( "" );
      subFreestylegridinformaciongeneral_Class = "FreeStyleGrid" ;
      subGridsdtprofesionalespecialidadsedes_Allowcollapsing = (byte)(0) ;
      subGridsdtprofesionalespecialidadsedes_Allowselection = (byte)(0) ;
      edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled = 0 ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setEnabled( 0 );
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled = 0 ;
      subGridsdtprofesionalespecialidadsedes_Header = "" ;
      subGridsdtprofesionalespecialidadsedes_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtprofesionalespecialidadsedes_Backcolorstyle = (byte)(0) ;
      subGridsdtprofesionaleducacions_Allowcollapsing = (byte)(0) ;
      subGridsdtprofesionaleducacions_Allowselection = (byte)(0) ;
      edtavSdtprofesionaleducacions__educacionhasta_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educaciondesde_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionid_Enabled = 0 ;
      subGridsdtprofesionaleducacions_Header = "" ;
      subGridsdtprofesionaleducacions_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtprofesionaleducacions_Backcolorstyle = (byte)(0) ;
      subGridsdtprofesionalexperiencialaborals_Allowcollapsing = (byte)(0) ;
      subGridsdtprofesionalexperiencialaborals_Allowselection = (byte)(0) ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Enabled = 0 ;
      subGridsdtprofesionalexperiencialaborals_Header = "" ;
      subGridsdtprofesionalexperiencialaborals_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtprofesionalexperiencialaborals_Backcolorstyle = (byte)(0) ;
      subGridsdtprofesionalpremioss_Allowcollapsing = (byte)(0) ;
      subGridsdtprofesionalpremioss_Allowselection = (byte)(0) ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosfecha_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosnombre_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosid_Enabled = 0 ;
      subGridsdtprofesionalpremioss_Header = "" ;
      subGridsdtprofesionalpremioss_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtprofesionalpremioss_Backcolorstyle = (byte)(0) ;
      subGridsdtprofesionalservicioss_Allowcollapsing = (byte)(0) ;
      subGridsdtprofesionalservicioss_Allowselection = (byte)(0) ;
      edtavSdtprofesionalservicioss__serviciosnombre_Enabled = 0 ;
      edtavSdtprofesionalservicioss__serviciosid_Enabled = 0 ;
      subGridsdtprofesionalservicioss_Header = "" ;
      subGridsdtprofesionalservicioss_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtprofesionalservicioss_Backcolorstyle = (byte)(0) ;
      edtavSdtprofesionalservicioss__serviciosnombre_Enabled = -1 ;
      edtavSdtprofesionalservicioss__serviciosid_Enabled = -1 ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Enabled = -1 ;
      edtavSdtprofesionalpremioss__premiosfecha_Enabled = -1 ;
      edtavSdtprofesionalpremioss__premiosnombre_Enabled = -1 ;
      edtavSdtprofesionalpremioss__premiosid_Enabled = -1 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled = -1 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled = -1 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled = -1 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Enabled = -1 ;
      edtavSdtprofesionaleducacions__educacionhasta_Enabled = -1 ;
      edtavSdtprofesionaleducacions__educaciondesde_Enabled = -1 ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled = -1 ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled = -1 ;
      edtavSdtprofesionaleducacions__educacionid_Enabled = -1 ;
      edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled = -1 ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setEnabled( -1 );
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled = -1 ;
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setEnabled( -1 );
      edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__paisdescripcion_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Enabled = -1 ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setEnabled( -1 );
      edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionalcop_Enabled = -1 ;
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setEnabled( -1 );
      edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionalnombres_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Enabled = -1 ;
      edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Enabled = -1 ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setEnabled( -1 );
      subFreestylegridinformaciongeneral_Allowcollapsing = (byte)(0) ;
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setEnabled( 0 );
      edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__paisdescripcion_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Enabled = 0 ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setEnabled( 0 );
      edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalcop_Enabled = 0 ;
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setEnabled( 0 );
      edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalnombres_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Enabled = 0 ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setEnabled( 0 );
      subFreestylegridinformaciongeneral_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Información Detallada Del Profesional" );
      Wizard_wizardip_Tabsinternalname = "" ;
      Gxuitabspanel_wizardip_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_wizardip_Class = "" ;
      Gxuitabspanel_wizardip_Pagecount = 6 ;
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
      Dvpanel_panelpremios_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremios_Iconposition = "Right" ;
      Dvpanel_panelpremios_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremios_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremios_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelpremios_Title = "" ;
      Dvpanel_panelpremios_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelpremios_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelpremios_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremios_Width = "100%" ;
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
      Dvpanel_panelespecialidad_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelespecialidad_Iconposition = "Right" ;
      Dvpanel_panelespecialidad_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelespecialidad_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelespecialidad_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelespecialidad_Title = "" ;
      Dvpanel_panelespecialidad_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelespecialidad_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelespecialidad_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelespecialidad_Width = "100%" ;
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
      Dvpanel_paneinfogeneral_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_paneinfogeneral_Iconposition = "Right" ;
      Dvpanel_paneinfogeneral_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_paneinfogeneral_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_paneinfogeneral_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_paneinfogeneral_Title = "" ;
      Dvpanel_paneinfogeneral_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_paneinfogeneral_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_paneinfogeneral_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_paneinfogeneral_Width = "100%" ;
      Dvpanel_panelbuttons_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuttons_Iconposition = "Right" ;
      Dvpanel_panelbuttons_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuttons_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuttons_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelbuttons_Title = "" ;
      Dvpanel_panelbuttons_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelbuttons_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelbuttons_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuttons_Width = "100%" ;
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
      GXCCtl = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTIPODOCUMENTO_" + sGXsfl_40_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setName( GXCCtl );
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setWebtags( "" );
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("1", "DNI", (short)(0));
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("6", "RUC", (short)(0));
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getItemCount() > 0 )
      {
         if ( ( AV33GXV1 > 0 ) && ( AV27SDTProfesionalInformacionGenerals.size() >= AV33GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento())==0) )
         {
            ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento( cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.getValidValue(((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltipodocumento()) );
         }
      }
      GXCCtl = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALSEXO_" + sGXsfl_40_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setName( GXCCtl );
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setWebtags( "" );
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.addItem("M", "Masculino", (short)(0));
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getItemCount() > 0 )
      {
         if ( ( AV33GXV1 > 0 ) && ( AV27SDTProfesionalInformacionGenerals.size() >= AV33GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo())==0) )
         {
            ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo( cmbavSdtprofesionalinformaciongenerals__profesionalsexo.getValidValue(((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalsexo()) );
         }
      }
      GXCCtl = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALTIEMPOCITA_" + sGXsfl_40_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setName( GXCCtl );
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setWebtags( "" );
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.addItem("30", "30 minutos", (short)(0));
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.addItem("60", "1 hora", (short)(0));
      if ( cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getItemCount() > 0 )
      {
         if ( ( AV33GXV1 > 0 ) && ( AV27SDTProfesionalInformacionGenerals.size() >= AV33GXV1 ) && (0==((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita()) )
         {
            ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita( (byte)(GXutil.lval( cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.getValidValue(GXutil.trim( GXutil.str( ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionaltiempocita(), 2, 0))))) );
         }
      }
      GXCCtl = "SDTPROFESIONALINFORMACIONGENERALS__PROFESIONALESTADO_" + sGXsfl_40_idx ;
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setName( GXCCtl );
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setWebtags( "" );
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.addItem("A", "Activo", (short)(0));
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.addItem("P", "Pendiente", (short)(0));
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.addItem("I", "Inactivo", (short)(0));
      if ( cmbavSdtprofesionalinformaciongenerals__profesionalestado.getItemCount() > 0 )
      {
         if ( ( AV33GXV1 > 0 ) && ( AV27SDTProfesionalInformacionGenerals.size() >= AV33GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado())==0) )
         {
            ((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).setgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado( cmbavSdtprofesionalinformaciongenerals__profesionalestado.getValidValue(((com.projectthani.SdtSDTProfesionalInformacionGeneral)AV27SDTProfesionalInformacionGenerals.elementAt(-1+AV33GXV1)).getgxTv_SdtSDTProfesionalInformacionGeneral_Profesionalestado()) );
         }
      }
      GXCCtl = "SDTPROFESIONALESPECIALIDADSEDES__SEDETIPOCONSULTA_" + sGXsfl_161_idx ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setName( GXCCtl );
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setWebtags( "" );
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("", "Seleccione tipo de consulta", (short)(0));
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("V", "Virtual", (short)(0));
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("P", "En consultorio", (short)(0));
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getItemCount() > 0 )
      {
         if ( ( AV58GXV26 > 0 ) && ( AV28SDTProfesionalEspecialidadSedes.size() >= AV58GXV26 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta())==0) )
         {
            ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).setgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getValidValue(((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV28SDTProfesionalEspecialidadSedes.elementAt(-1+AV58GXV26)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()) );
         }
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'FREESTYLEGRIDINFORMACIONGENERAL_nFirstRecordOnPage'},{av:'FREESTYLEGRIDINFORMACIONGENERAL_nEOF'},{av:'AV27SDTProfesionalInformacionGenerals',fld:'vSDTPROFESIONALINFORMACIONGENERALS',grid:40,pic:''},{av:'nRC_GXsfl_40',ctrl:'FREESTYLEGRIDINFORMACIONGENERAL',prop:'GridRC',grid:40},{av:'GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALSERVICIOSS_nEOF'},{av:'AV23SDTProfesionalServicioss',fld:'vSDTPROFESIONALSERVICIOSS',grid:255,pic:''},{av:'nRC_GXsfl_255',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'GridRC',grid:255},{av:'GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALPREMIOSS_nEOF'},{av:'AV22SDTProfesionalPremioss',fld:'vSDTPROFESIONALPREMIOSS',grid:232,pic:''},{av:'nRC_GXsfl_232',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'GridRC',grid:232},{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF'},{av:'AV21SDTProfesionalExperienciaLaborals',fld:'vSDTPROFESIONALEXPERIENCIALABORALS',grid:208,pic:''},{av:'nRC_GXsfl_208',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'GridRC',grid:208},{av:'GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEDUCACIONS_nEOF'},{av:'AV20SDTProfesionalEducacions',fld:'vSDTPROFESIONALEDUCACIONS',grid:183,pic:''},{av:'nRC_GXsfl_183',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'GridRC',grid:183},{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF'},{av:'AV28SDTProfesionalEspecialidadSedes',fld:'vSDTPROFESIONALESPECIALIDADSEDES',grid:161,pic:''},{av:'nRC_GXsfl_161',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'GridRC',grid:161},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV14GridSDTProfesionalServiciossCurrentPage',fld:'vGRIDSDTPROFESIONALSERVICIOSSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV15GridSDTProfesionalServiciossPageCount',fld:'vGRIDSDTPROFESIONALSERVICIOSSPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV12GridSDTProfesionalPremiossCurrentPage',fld:'vGRIDSDTPROFESIONALPREMIOSSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV13GridSDTProfesionalPremiossPageCount',fld:'vGRIDSDTPROFESIONALPREMIOSSPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV10GridSDTProfesionalExperienciaLaboralsCurrentPage',fld:'vGRIDSDTPROFESIONALEXPERIENCIALABORALSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV11GridSDTProfesionalExperienciaLaboralsPageCount',fld:'vGRIDSDTPROFESIONALEXPERIENCIALABORALSPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV8GridSDTProfesionalEducacionsCurrentPage',fld:'vGRIDSDTPROFESIONALEDUCACIONSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV9GridSDTProfesionalEducacionsPageCount',fld:'vGRIDSDTPROFESIONALEDUCACIONSPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV29GridSDTProfesionalEspecialidadSedesCurrentPage',fld:'vGRIDSDTPROFESIONALESPECIALIDADSEDESCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV30GridSDTProfesionalEspecialidadSedesPageCount',fld:'vGRIDSDTPROFESIONALESPECIALIDADSEDESPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSS.LOAD","{handler:'e302O3',iparms:[]");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSS.LOAD",",oparms:[]}");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSS.LOAD","{handler:'e292O4',iparms:[]");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSS.LOAD",",oparms:[]}");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALS.LOAD","{handler:'e282O5',iparms:[]");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALS.LOAD",",oparms:[]}");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONS.LOAD","{handler:'e272O6',iparms:[]");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONS.LOAD",",oparms:[]}");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDES.LOAD","{handler:'e262O7',iparms:[]");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDES.LOAD",",oparms:[]}");
      setEventMetadata("FREESTYLEGRIDINFORMACIONGENERAL.LOAD","{handler:'e252O2',iparms:[]");
      setEventMetadata("FREESTYLEGRIDINFORMACIONGENERAL.LOAD",",oparms:[]}");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEPAGE","{handler:'e202O2',iparms:[{av:'GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALSERVICIOSS_nEOF'},{av:'AV23SDTProfesionalServicioss',fld:'vSDTPROFESIONALSERVICIOSS',grid:255,pic:''},{av:'nRC_GXsfl_255',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'GridRC',grid:255},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalserviciosspaginationbar_Selectedpage',ctrl:'GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e212O2',iparms:[{av:'GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALSERVICIOSS_nEOF'},{av:'AV23SDTProfesionalServicioss',fld:'vSDTPROFESIONALSERVICIOSS',grid:255,pic:''},{av:'nRC_GXsfl_255',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'GridRC',grid:255},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'}]}");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEPAGE","{handler:'e182O2',iparms:[{av:'GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALPREMIOSS_nEOF'},{av:'AV22SDTProfesionalPremioss',fld:'vSDTPROFESIONALPREMIOSS',grid:232,pic:''},{av:'nRC_GXsfl_232',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'GridRC',grid:232},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalpremiosspaginationbar_Selectedpage',ctrl:'GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e192O2',iparms:[{av:'GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALPREMIOSS_nEOF'},{av:'AV22SDTProfesionalPremioss',fld:'vSDTPROFESIONALPREMIOSS',grid:232,pic:''},{av:'nRC_GXsfl_232',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'GridRC',grid:232},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'}]}");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEPAGE","{handler:'e162O2',iparms:[{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF'},{av:'AV21SDTProfesionalExperienciaLaborals',fld:'vSDTPROFESIONALEXPERIENCIALABORALS',grid:208,pic:''},{av:'nRC_GXsfl_208',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'GridRC',grid:208},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e172O2',iparms:[{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF'},{av:'AV21SDTProfesionalExperienciaLaborals',fld:'vSDTPROFESIONALEXPERIENCIALABORALS',grid:208,pic:''},{av:'nRC_GXsfl_208',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'GridRC',grid:208},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'}]}");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEPAGE","{handler:'e142O2',iparms:[{av:'GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEDUCACIONS_nEOF'},{av:'AV20SDTProfesionalEducacions',fld:'vSDTPROFESIONALEDUCACIONS',grid:183,pic:''},{av:'nRC_GXsfl_183',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'GridRC',grid:183},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionaleducacionspaginationbar_Selectedpage',ctrl:'GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e152O2',iparms:[{av:'GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEDUCACIONS_nEOF'},{av:'AV20SDTProfesionalEducacions',fld:'vSDTPROFESIONALEDUCACIONS',grid:183,pic:''},{av:'nRC_GXsfl_183',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'GridRC',grid:183},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'}]}");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEPAGE","{handler:'e122O2',iparms:[{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF'},{av:'AV28SDTProfesionalEspecialidadSedes',fld:'vSDTPROFESIONALESPECIALIDADSEDES',grid:161,pic:''},{av:'nRC_GXsfl_161',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'GridRC',grid:161},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e132O2',iparms:[{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF'},{av:'AV28SDTProfesionalEspecialidadSedes',fld:'vSDTPROFESIONALESPECIALIDADSEDES',grid:161,pic:''},{av:'nRC_GXsfl_161',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'GridRC',grid:161},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'}]}");
      setEventMetadata("'DOACTIVARCUENTA'","{handler:'e222O2',iparms:[{av:'AV19ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOACTIVARCUENTA'",",oparms:[]}");
      setEventMetadata("'DOSALIR'","{handler:'e112O1',iparms:[]");
      setEventMetadata("'DOSALIR'",",oparms:[]}");
      setEventMetadata("VALIDV_GXV3","{handler:'validv_Gxv3',iparms:[]");
      setEventMetadata("VALIDV_GXV3",",oparms:[]}");
      setEventMetadata("VALIDV_GXV9","{handler:'validv_Gxv9',iparms:[]");
      setEventMetadata("VALIDV_GXV9",",oparms:[]}");
      setEventMetadata("VALIDV_GXV12","{handler:'validv_Gxv12',iparms:[]");
      setEventMetadata("VALIDV_GXV12",",oparms:[]}");
      setEventMetadata("VALIDV_GXV13","{handler:'validv_Gxv13',iparms:[]");
      setEventMetadata("VALIDV_GXV13",",oparms:[]}");
      setEventMetadata("VALIDV_GXV19","{handler:'validv_Gxv19',iparms:[]");
      setEventMetadata("VALIDV_GXV19",",oparms:[]}");
      setEventMetadata("VALIDV_GXV20","{handler:'validv_Gxv20',iparms:[]");
      setEventMetadata("VALIDV_GXV20",",oparms:[]}");
      setEventMetadata("VALIDV_GXV21","{handler:'validv_Gxv21',iparms:[]");
      setEventMetadata("VALIDV_GXV21",",oparms:[]}");
      setEventMetadata("VALIDV_GXV22","{handler:'validv_Gxv22',iparms:[]");
      setEventMetadata("VALIDV_GXV22",",oparms:[]}");
      setEventMetadata("VALIDV_GXV25","{handler:'validv_Gxv25',iparms:[]");
      setEventMetadata("VALIDV_GXV25",",oparms:[]}");
      setEventMetadata("VALIDV_GXV28","{handler:'validv_Gxv28',iparms:[]");
      setEventMetadata("VALIDV_GXV28",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv29',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("VALIDV_GXV31","{handler:'validv_Gxv31',iparms:[]");
      setEventMetadata("VALIDV_GXV31",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv35',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("VALIDV_GXV37","{handler:'validv_Gxv37',iparms:[]");
      setEventMetadata("VALIDV_GXV37",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv40',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("VALIDV_GXV42","{handler:'validv_Gxv42',iparms:[]");
      setEventMetadata("VALIDV_GXV42",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv45',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("VALIDV_GXV47","{handler:'validv_Gxv47',iparms:[]");
      setEventMetadata("VALIDV_GXV47",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv48',iparms:[]");
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
      Gridsdtprofesionalserviciosspaginationbar_Selectedpage = "" ;
      Gridsdtprofesionalpremiosspaginationbar_Selectedpage = "" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage = "" ;
      Gridsdtprofesionaleducacionspaginationbar_Selectedpage = "" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
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
      AV27SDTProfesionalInformacionGenerals = new GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral>(com.projectthani.SdtSDTProfesionalInformacionGeneral.class, "SDTProfesionalInformacionGeneral", "ProjectThani", remoteHandle);
      AV28SDTProfesionalEspecialidadSedes = new GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede>(com.projectthani.SdtSDTProfesionalEspecialidadSede.class, "SDTProfesionalEspecialidadSede", "ProjectThani", remoteHandle);
      AV20SDTProfesionalEducacions = new GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion>(com.projectthani.SdtSDTProfesionalEducacion.class, "SDTProfesionalEducacion", "ProjectThani", remoteHandle);
      AV21SDTProfesionalExperienciaLaborals = new GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral>(com.projectthani.SdtSDTProfesionalExperienciaLaboral.class, "SDTProfesionalExperienciaLaboral", "ProjectThani", remoteHandle);
      AV22SDTProfesionalPremioss = new GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios>(com.projectthani.SdtSDTProfesionalPremios.class, "SDTProfesionalPremios", "ProjectThani", remoteHandle);
      AV23SDTProfesionalServicioss = new GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios>(com.projectthani.SdtSDTProfesionalServicios.class, "SDTProfesionalServicios", "ProjectThani", remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_panelbuttons = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      bttBtnactivarcuenta_Jsonclick = "" ;
      bttBtnsalir_Jsonclick = "" ;
      ucGxuitabspanel_wizardip = new com.genexus.webpanels.GXUserControl();
      lblTabinformaciongeneral_title_Jsonclick = "" ;
      ucDvpanel_paneinfogeneral = new com.genexus.webpanels.GXUserControl();
      FreestylegridinformaciongeneralContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subFreestylegridinformaciongeneral_Header = "" ;
      FreestylegridinformaciongeneralColumn = new com.genexus.webpanels.GXWebColumn();
      lblTabespecialidad_title_Jsonclick = "" ;
      ucDvpanel_panelespecialidad = new com.genexus.webpanels.GXUserControl();
      lblTabeducacion_title_Jsonclick = "" ;
      ucDvpanel_paneleducacion = new com.genexus.webpanels.GXUserControl();
      lblTabexperiencialaboral_title_Jsonclick = "" ;
      ucDvpanel_panelexperiencialaboral = new com.genexus.webpanels.GXUserControl();
      lblTabpremios_title_Jsonclick = "" ;
      ucDvpanel_panelpremios = new com.genexus.webpanels.GXUserControl();
      lblTabservicios_title_Jsonclick = "" ;
      ucDvpanel_panelservicios = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalservicioss_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalpremioss_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalexperiencialaborals_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionaleducacions_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalespecialidadsedes_empowerer = new com.genexus.webpanels.GXUserControl();
      ucWizard_wizardip = new com.genexus.webpanels.GXUserControl();
      GridsdtprofesionalespecialidadsedesContainer = new com.genexus.webpanels.GXWebGrid(context);
      GridsdtprofesionaleducacionsContainer = new com.genexus.webpanels.GXWebGrid(context);
      GridsdtprofesionalexperiencialaboralsContainer = new com.genexus.webpanels.GXWebGrid(context);
      GridsdtprofesionalpremiossContainer = new com.genexus.webpanels.GXWebGrid(context);
      GridsdtprofesionalserviciossContainer = new com.genexus.webpanels.GXWebGrid(context);
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXv_objcol_SdtSDTProfesionalEspecialidadSede1 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTProfesionalInformacionGeneral2 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTProfesionalEducacion3 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTProfesionalExperienciaLaboral4 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTProfesionalPremios5 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTProfesionalServicios6 = new GXBaseCollection[1] ;
      ucGridsdtprofesionalserviciosspaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalpremiosspaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalexperiencialaboralspaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionaleducacionspaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalespecialidadsedespaginationbar = new com.genexus.webpanels.GXUserControl();
      FreestylegridinformaciongeneralRow = new com.genexus.webpanels.GXWebRow();
      AV7Error = "" ;
      GXv_char7 = new String[1] ;
      GridsdtprofesionalserviciossRow = new com.genexus.webpanels.GXWebRow();
      GridsdtprofesionalpremiossRow = new com.genexus.webpanels.GXWebRow();
      GridsdtprofesionalexperiencialaboralsRow = new com.genexus.webpanels.GXWebRow();
      GridsdtprofesionaleducacionsRow = new com.genexus.webpanels.GXWebRow();
      GridsdtprofesionalespecialidadsedesRow = new com.genexus.webpanels.GXWebRow();
      subGridsdtprofesionalservicioss_Linesclass = "" ;
      GridsdtprofesionalserviciossColumn = new com.genexus.webpanels.GXWebColumn();
      subGridsdtprofesionalpremioss_Linesclass = "" ;
      GridsdtprofesionalpremiossColumn = new com.genexus.webpanels.GXWebColumn();
      subGridsdtprofesionalexperiencialaborals_Linesclass = "" ;
      GridsdtprofesionalexperiencialaboralsColumn = new com.genexus.webpanels.GXWebColumn();
      subGridsdtprofesionaleducacions_Linesclass = "" ;
      GridsdtprofesionaleducacionsColumn = new com.genexus.webpanels.GXWebColumn();
      subGridsdtprofesionalespecialidadsedes_Linesclass = "" ;
      GridsdtprofesionalespecialidadsedesColumn = new com.genexus.webpanels.GXWebColumn();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subFreestylegridinformaciongeneral_Linesclass = "" ;
      sImgUrl = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento.setEnabled( 0 );
      edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalnombres_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Enabled = 0 ;
      cmbavSdtprofesionalinformaciongenerals__profesionalsexo.setEnabled( 0 );
      edtavSdtprofesionalinformaciongenerals__profesionalcop_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Enabled = 0 ;
      cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita.setEnabled( 0 );
      edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__paisdescripcion_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Enabled = 0 ;
      edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Enabled = 0 ;
      cmbavSdtprofesionalinformaciongenerals__profesionalestado.setEnabled( 0 );
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled = 0 ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setEnabled( 0 );
      edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionid_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educaciondesde_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionhasta_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosid_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosnombre_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosfecha_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Enabled = 0 ;
      edtavSdtprofesionalservicioss__serviciosid_Enabled = 0 ;
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
   private byte subFreestylegridinformaciongeneral_Backcolorstyle ;
   private byte subFreestylegridinformaciongeneral_Allowselection ;
   private byte subFreestylegridinformaciongeneral_Allowhovering ;
   private byte subFreestylegridinformaciongeneral_Allowcollapsing ;
   private byte subFreestylegridinformaciongeneral_Collapsed ;
   private byte nDonePA ;
   private byte subGridsdtprofesionalservicioss_Backcolorstyle ;
   private byte subGridsdtprofesionalpremioss_Backcolorstyle ;
   private byte subGridsdtprofesionalexperiencialaborals_Backcolorstyle ;
   private byte subGridsdtprofesionaleducacions_Backcolorstyle ;
   private byte subGridsdtprofesionalespecialidadsedes_Backcolorstyle ;
   private byte FREESTYLEGRIDINFORMACIONGENERAL_nEOF ;
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
   private byte subFreestylegridinformaciongeneral_Backstyle ;
   private byte subGridsdtprofesionalespecialidadsedes_Backstyle ;
   private byte subGridsdtprofesionaleducacions_Backstyle ;
   private byte subGridsdtprofesionalexperiencialaborals_Backstyle ;
   private byte subGridsdtprofesionalpremioss_Backstyle ;
   private byte subGridsdtprofesionalservicioss_Backstyle ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
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
   private int wcpOAV19ProfesionalId ;
   private int Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue ;
   private int Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue ;
   private int Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue ;
   private int Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue ;
   private int Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_40 ;
   private int nRC_GXsfl_161 ;
   private int nRC_GXsfl_183 ;
   private int nRC_GXsfl_208 ;
   private int nRC_GXsfl_232 ;
   private int nRC_GXsfl_255 ;
   private int nGXsfl_40_idx=1 ;
   private int subGridsdtprofesionalespecialidadsedes_Rows ;
   private int subGridsdtprofesionaleducacions_Rows ;
   private int subGridsdtprofesionalexperiencialaborals_Rows ;
   private int subGridsdtprofesionalpremioss_Rows ;
   private int subGridsdtprofesionalservicioss_Rows ;
   private int AV19ProfesionalId ;
   private int Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow ;
   private int Gridsdtprofesionaleducacionspaginationbar_Pagestoshow ;
   private int Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow ;
   private int Gridsdtprofesionalpremiosspaginationbar_Pagestoshow ;
   private int Gridsdtprofesionalserviciosspaginationbar_Pagestoshow ;
   private int Gxuitabspanel_wizardip_Pagecount ;
   private int nGXsfl_161_idx=1 ;
   private int nGXsfl_183_idx=1 ;
   private int nGXsfl_208_idx=1 ;
   private int nGXsfl_232_idx=1 ;
   private int nGXsfl_255_idx=1 ;
   private int edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionalnombres_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionalcop_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__paisdescripcion_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Enabled ;
   private int edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Enabled ;
   private int subFreestylegridinformaciongeneral_Selectedindex ;
   private int subFreestylegridinformaciongeneral_Selectioncolor ;
   private int subFreestylegridinformaciongeneral_Hoveringcolor ;
   private int AV33GXV1 ;
   private int AV58GXV26 ;
   private int AV62GXV30 ;
   private int AV68GXV36 ;
   private int AV73GXV41 ;
   private int AV78GXV46 ;
   private int subFreestylegridinformaciongeneral_Islastpage ;
   private int subGridsdtprofesionalservicioss_Islastpage ;
   private int subGridsdtprofesionalpremioss_Islastpage ;
   private int subGridsdtprofesionalexperiencialaborals_Islastpage ;
   private int subGridsdtprofesionaleducacions_Islastpage ;
   private int subGridsdtprofesionalespecialidadsedes_Islastpage ;
   private int edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled ;
   private int edtavSdtprofesionalespecialidadsedes__costoconsulta_Enabled ;
   private int edtavSdtprofesionaleducacions__educacionid_Enabled ;
   private int edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled ;
   private int edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled ;
   private int edtavSdtprofesionaleducacions__educaciondesde_Enabled ;
   private int edtavSdtprofesionaleducacions__educacionhasta_Enabled ;
   private int edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Enabled ;
   private int edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled ;
   private int edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled ;
   private int edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled ;
   private int edtavSdtprofesionalpremioss__premiosid_Enabled ;
   private int edtavSdtprofesionalpremioss__premiosnombre_Enabled ;
   private int edtavSdtprofesionalpremioss__premiosfecha_Enabled ;
   private int edtavSdtprofesionalpremioss__premiosdescripcion_Enabled ;
   private int edtavSdtprofesionalservicioss__serviciosid_Enabled ;
   private int edtavSdtprofesionalservicioss__serviciosnombre_Enabled ;
   private int GRIDSDTPROFESIONALSERVICIOSS_nGridOutOfScope ;
   private int GRIDSDTPROFESIONALPREMIOSS_nGridOutOfScope ;
   private int GRIDSDTPROFESIONALEXPERIENCIALABORALS_nGridOutOfScope ;
   private int GRIDSDTPROFESIONALEDUCACIONS_nGridOutOfScope ;
   private int GRIDSDTPROFESIONALESPECIALIDADSEDES_nGridOutOfScope ;
   private int nGXsfl_40_fel_idx=1 ;
   private int nGXsfl_161_fel_idx=1 ;
   private int nGXsfl_183_fel_idx=1 ;
   private int nGXsfl_208_fel_idx=1 ;
   private int nGXsfl_232_fel_idx=1 ;
   private int nGXsfl_255_fel_idx=1 ;
   private int AV18PageToGo ;
   private int subGridsdtprofesionalservicioss_Titlebackcolor ;
   private int subGridsdtprofesionalservicioss_Allbackcolor ;
   private int subGridsdtprofesionalservicioss_Selectedindex ;
   private int subGridsdtprofesionalservicioss_Selectioncolor ;
   private int subGridsdtprofesionalservicioss_Hoveringcolor ;
   private int subGridsdtprofesionalpremioss_Titlebackcolor ;
   private int subGridsdtprofesionalpremioss_Allbackcolor ;
   private int subGridsdtprofesionalpremioss_Selectedindex ;
   private int subGridsdtprofesionalpremioss_Selectioncolor ;
   private int subGridsdtprofesionalpremioss_Hoveringcolor ;
   private int subGridsdtprofesionalexperiencialaborals_Titlebackcolor ;
   private int subGridsdtprofesionalexperiencialaborals_Allbackcolor ;
   private int subGridsdtprofesionalexperiencialaborals_Selectedindex ;
   private int subGridsdtprofesionalexperiencialaborals_Selectioncolor ;
   private int subGridsdtprofesionalexperiencialaborals_Hoveringcolor ;
   private int subGridsdtprofesionaleducacions_Titlebackcolor ;
   private int subGridsdtprofesionaleducacions_Allbackcolor ;
   private int subGridsdtprofesionaleducacions_Selectedindex ;
   private int subGridsdtprofesionaleducacions_Selectioncolor ;
   private int subGridsdtprofesionaleducacions_Hoveringcolor ;
   private int subGridsdtprofesionalespecialidadsedes_Titlebackcolor ;
   private int subGridsdtprofesionalespecialidadsedes_Allbackcolor ;
   private int subGridsdtprofesionalespecialidadsedes_Selectedindex ;
   private int subGridsdtprofesionalespecialidadsedes_Selectioncolor ;
   private int subGridsdtprofesionalespecialidadsedes_Hoveringcolor ;
   private int idxLst ;
   private int subFreestylegridinformaciongeneral_Backcolor ;
   private int subFreestylegridinformaciongeneral_Allbackcolor ;
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
   private long AV29GridSDTProfesionalEspecialidadSedesCurrentPage ;
   private long AV30GridSDTProfesionalEspecialidadSedesPageCount ;
   private long AV8GridSDTProfesionalEducacionsCurrentPage ;
   private long AV9GridSDTProfesionalEducacionsPageCount ;
   private long AV10GridSDTProfesionalExperienciaLaboralsCurrentPage ;
   private long AV11GridSDTProfesionalExperienciaLaboralsPageCount ;
   private long AV12GridSDTProfesionalPremiossCurrentPage ;
   private long AV13GridSDTProfesionalPremiossPageCount ;
   private long AV14GridSDTProfesionalServiciossCurrentPage ;
   private long AV15GridSDTProfesionalServiciossPageCount ;
   private long FREESTYLEGRIDINFORMACIONGENERAL_nCurrentRecord ;
   private long GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord ;
   private long GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord ;
   private long GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord ;
   private long GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord ;
   private long GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord ;
   private long GRIDSDTPROFESIONALSERVICIOSS_nRecordCount ;
   private long GRIDSDTPROFESIONALPREMIOSS_nRecordCount ;
   private long GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount ;
   private long GRIDSDTPROFESIONALEDUCACIONS_nRecordCount ;
   private long GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount ;
   private long FREESTYLEGRIDINFORMACIONGENERAL_nFirstRecordOnPage ;
   private String Gridsdtprofesionalserviciosspaginationbar_Selectedpage ;
   private String Gridsdtprofesionalpremiosspaginationbar_Selectedpage ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage ;
   private String Gridsdtprofesionaleducacionspaginationbar_Selectedpage ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_40_idx="0001" ;
   private String Dvpanel_panelbuttons_Width ;
   private String Dvpanel_panelbuttons_Cls ;
   private String Dvpanel_panelbuttons_Title ;
   private String Dvpanel_panelbuttons_Iconposition ;
   private String Dvpanel_paneinfogeneral_Width ;
   private String Dvpanel_paneinfogeneral_Cls ;
   private String Dvpanel_paneinfogeneral_Title ;
   private String Dvpanel_paneinfogeneral_Iconposition ;
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
   private String Dvpanel_panelespecialidad_Width ;
   private String Dvpanel_panelespecialidad_Cls ;
   private String Dvpanel_panelespecialidad_Title ;
   private String Dvpanel_panelespecialidad_Iconposition ;
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
   private String Dvpanel_paneleducacion_Width ;
   private String Dvpanel_paneleducacion_Cls ;
   private String Dvpanel_paneleducacion_Title ;
   private String Dvpanel_paneleducacion_Iconposition ;
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
   private String Dvpanel_panelexperiencialaboral_Width ;
   private String Dvpanel_panelexperiencialaboral_Cls ;
   private String Dvpanel_panelexperiencialaboral_Title ;
   private String Dvpanel_panelexperiencialaboral_Iconposition ;
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
   private String Dvpanel_panelpremios_Width ;
   private String Dvpanel_panelpremios_Cls ;
   private String Dvpanel_panelpremios_Title ;
   private String Dvpanel_panelpremios_Iconposition ;
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
   private String Dvpanel_panelservicios_Width ;
   private String Dvpanel_panelservicios_Cls ;
   private String Dvpanel_panelservicios_Title ;
   private String Dvpanel_panelservicios_Iconposition ;
   private String Gxuitabspanel_wizardip_Class ;
   private String Gridsdtprofesionalservicioss_empowerer_Gridinternalname ;
   private String Gridsdtprofesionalpremioss_empowerer_Gridinternalname ;
   private String Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname ;
   private String Gridsdtprofesionaleducacions_empowerer_Gridinternalname ;
   private String Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname ;
   private String Wizard_wizardip_Tabsinternalname ;
   private String sGXsfl_161_idx="0001" ;
   private String sGXsfl_183_idx="0001" ;
   private String sGXsfl_208_idx="0001" ;
   private String sGXsfl_232_idx="0001" ;
   private String sGXsfl_255_idx="0001" ;
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
   private String Dvpanel_panelbuttons_Internalname ;
   private String divPanelbuttons_Internalname ;
   private String TempTags ;
   private String bttBtnactivarcuenta_Internalname ;
   private String bttBtnactivarcuenta_Jsonclick ;
   private String bttBtnsalir_Internalname ;
   private String bttBtnsalir_Jsonclick ;
   private String Gxuitabspanel_wizardip_Internalname ;
   private String lblTabinformaciongeneral_title_Internalname ;
   private String lblTabinformaciongeneral_title_Jsonclick ;
   private String divTableinformaciongeneral_Internalname ;
   private String Dvpanel_paneinfogeneral_Internalname ;
   private String divPaneinfogeneral_Internalname ;
   private String sStyleString ;
   private String subFreestylegridinformaciongeneral_Internalname ;
   private String subFreestylegridinformaciongeneral_Header ;
   private String lblTabespecialidad_title_Internalname ;
   private String lblTabespecialidad_title_Jsonclick ;
   private String divTableespecialidad_Internalname ;
   private String Dvpanel_panelespecialidad_Internalname ;
   private String lblTabeducacion_title_Internalname ;
   private String lblTabeducacion_title_Jsonclick ;
   private String divTableeducacion_Internalname ;
   private String Dvpanel_paneleducacion_Internalname ;
   private String lblTabexperiencialaboral_title_Internalname ;
   private String lblTabexperiencialaboral_title_Jsonclick ;
   private String divTableexperiencialaboral_Internalname ;
   private String Dvpanel_panelexperiencialaboral_Internalname ;
   private String lblTabpremios_title_Internalname ;
   private String lblTabpremios_title_Jsonclick ;
   private String divTablepremios_Internalname ;
   private String Dvpanel_panelpremios_Internalname ;
   private String lblTabservicios_title_Internalname ;
   private String lblTabservicios_title_Jsonclick ;
   private String divTableservicios_Internalname ;
   private String Dvpanel_panelservicios_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Gridsdtprofesionalservicioss_empowerer_Internalname ;
   private String Gridsdtprofesionalpremioss_empowerer_Internalname ;
   private String Gridsdtprofesionalexperiencialaborals_empowerer_Internalname ;
   private String Gridsdtprofesionaleducacions_empowerer_Internalname ;
   private String Gridsdtprofesionalespecialidadsedes_empowerer_Internalname ;
   private String Wizard_wizardip_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalnombres_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalcop_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionaldireccion_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__paisdescripcion_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionaldescripcion_Internalname ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Internalname ;
   private String edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname ;
   private String edtavSdtprofesionalespecialidadsedes__costoconsulta_Internalname ;
   private String edtavSdtprofesionaleducacions__educacionid_Internalname ;
   private String edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname ;
   private String edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname ;
   private String edtavSdtprofesionaleducacions__educaciondesde_Internalname ;
   private String edtavSdtprofesionaleducacions__educacionhasta_Internalname ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Internalname ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname ;
   private String edtavSdtprofesionalpremioss__premiosid_Internalname ;
   private String edtavSdtprofesionalpremioss__premiosnombre_Internalname ;
   private String edtavSdtprofesionalpremioss__premiosfecha_Internalname ;
   private String edtavSdtprofesionalpremioss__premiosdescripcion_Internalname ;
   private String edtavSdtprofesionalservicioss__serviciosid_Internalname ;
   private String edtavSdtprofesionalservicioss__serviciosnombre_Internalname ;
   private String sGXsfl_40_fel_idx="0001" ;
   private String sGXsfl_161_fel_idx="0001" ;
   private String sGXsfl_183_fel_idx="0001" ;
   private String sGXsfl_208_fel_idx="0001" ;
   private String sGXsfl_232_fel_idx="0001" ;
   private String sGXsfl_255_fel_idx="0001" ;
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
   private String AV7Error ;
   private String GXv_char7[] ;
   private String tblPanelservicios_Internalname ;
   private String divGridsdtprofesionalserviciosstablewithpaginationbar_Internalname ;
   private String subGridsdtprofesionalservicioss_Class ;
   private String subGridsdtprofesionalservicioss_Linesclass ;
   private String subGridsdtprofesionalservicioss_Header ;
   private String tblPanelpremios_Internalname ;
   private String divGridsdtprofesionalpremiosstablewithpaginationbar_Internalname ;
   private String subGridsdtprofesionalpremioss_Class ;
   private String subGridsdtprofesionalpremioss_Linesclass ;
   private String subGridsdtprofesionalpremioss_Header ;
   private String tblPanelexperiencialaboral_Internalname ;
   private String divGridsdtprofesionalexperiencialaboralstablewithpaginationbar_Internalname ;
   private String subGridsdtprofesionalexperiencialaborals_Class ;
   private String subGridsdtprofesionalexperiencialaborals_Linesclass ;
   private String subGridsdtprofesionalexperiencialaborals_Header ;
   private String tblPaneleducacion_Internalname ;
   private String divGridsdtprofesionaleducacionstablewithpaginationbar_Internalname ;
   private String subGridsdtprofesionaleducacions_Class ;
   private String subGridsdtprofesionaleducacions_Linesclass ;
   private String subGridsdtprofesionaleducacions_Header ;
   private String tblPanelespecialidad_Internalname ;
   private String divGridsdtprofesionalespecialidadsedestablewithpaginationbar_Internalname ;
   private String subGridsdtprofesionalespecialidadsedes_Class ;
   private String subGridsdtprofesionalespecialidadsedes_Linesclass ;
   private String subGridsdtprofesionalespecialidadsedes_Header ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalfoto_Internalname ;
   private String subFreestylegridinformaciongeneral_Class ;
   private String subFreestylegridinformaciongeneral_Linesclass ;
   private String divUnnamedtablefsfreestylegridinformaciongeneral_Internalname ;
   private String sImgUrl ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalnrodocumento_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalapellidopaterno_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalapellidomaterno_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalnombres_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalfechanacimiento_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalcop_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionaltelefono_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalcorreo_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__paisdescripcion_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__ubigeodepartamento_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__ubigeoprovincia_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__ubigeodistrito_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionaltwitter_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalfacebook_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalinstagram_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionallinkedin_Jsonclick ;
   private String edtavSdtprofesionalinformaciongenerals__profesionalfecharegistro_Jsonclick ;
   private String edtavSdtprofesionalespecialidadsedes__especialidadnombre_Jsonclick ;
   private String edtavSdtprofesionalespecialidadsedes__costoconsulta_Jsonclick ;
   private String edtavSdtprofesionaleducacions__educacionid_Jsonclick ;
   private String edtavSdtprofesionaleducacions__educacionnombreinstitucion_Jsonclick ;
   private String edtavSdtprofesionaleducacions__educacionpaisdescripcion_Jsonclick ;
   private String edtavSdtprofesionaleducacions__educaciondesde_Jsonclick ;
   private String edtavSdtprofesionaleducacions__educacionhasta_Jsonclick ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboralid_Jsonclick ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Jsonclick ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Jsonclick ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Jsonclick ;
   private String edtavSdtprofesionalpremioss__premiosid_Jsonclick ;
   private String edtavSdtprofesionalpremioss__premiosnombre_Jsonclick ;
   private String edtavSdtprofesionalpremioss__premiosfecha_Jsonclick ;
   private String edtavSdtprofesionalpremioss__premiosdescripcion_Jsonclick ;
   private String edtavSdtprofesionalservicioss__serviciosid_Jsonclick ;
   private String edtavSdtprofesionalservicioss__serviciosnombre_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_panelbuttons_Autowidth ;
   private boolean Dvpanel_panelbuttons_Autoheight ;
   private boolean Dvpanel_panelbuttons_Collapsible ;
   private boolean Dvpanel_panelbuttons_Collapsed ;
   private boolean Dvpanel_panelbuttons_Showcollapseicon ;
   private boolean Dvpanel_panelbuttons_Autoscroll ;
   private boolean Dvpanel_paneinfogeneral_Autowidth ;
   private boolean Dvpanel_paneinfogeneral_Autoheight ;
   private boolean Dvpanel_paneinfogeneral_Collapsible ;
   private boolean Dvpanel_paneinfogeneral_Collapsed ;
   private boolean Dvpanel_paneinfogeneral_Showcollapseicon ;
   private boolean Dvpanel_paneinfogeneral_Autoscroll ;
   private boolean Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst ;
   private boolean Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious ;
   private boolean Gridsdtprofesionalespecialidadsedespaginationbar_Shownext ;
   private boolean Gridsdtprofesionalespecialidadsedespaginationbar_Showlast ;
   private boolean Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_panelespecialidad_Autowidth ;
   private boolean Dvpanel_panelespecialidad_Autoheight ;
   private boolean Dvpanel_panelespecialidad_Collapsible ;
   private boolean Dvpanel_panelespecialidad_Collapsed ;
   private boolean Dvpanel_panelespecialidad_Showcollapseicon ;
   private boolean Dvpanel_panelespecialidad_Autoscroll ;
   private boolean Gridsdtprofesionaleducacionspaginationbar_Showfirst ;
   private boolean Gridsdtprofesionaleducacionspaginationbar_Showprevious ;
   private boolean Gridsdtprofesionaleducacionspaginationbar_Shownext ;
   private boolean Gridsdtprofesionaleducacionspaginationbar_Showlast ;
   private boolean Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_paneleducacion_Autowidth ;
   private boolean Dvpanel_paneleducacion_Autoheight ;
   private boolean Dvpanel_paneleducacion_Collapsible ;
   private boolean Dvpanel_paneleducacion_Collapsed ;
   private boolean Dvpanel_paneleducacion_Showcollapseicon ;
   private boolean Dvpanel_paneleducacion_Autoscroll ;
   private boolean Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst ;
   private boolean Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious ;
   private boolean Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext ;
   private boolean Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast ;
   private boolean Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_panelexperiencialaboral_Autowidth ;
   private boolean Dvpanel_panelexperiencialaboral_Autoheight ;
   private boolean Dvpanel_panelexperiencialaboral_Collapsible ;
   private boolean Dvpanel_panelexperiencialaboral_Collapsed ;
   private boolean Dvpanel_panelexperiencialaboral_Showcollapseicon ;
   private boolean Dvpanel_panelexperiencialaboral_Autoscroll ;
   private boolean Gridsdtprofesionalpremiosspaginationbar_Showfirst ;
   private boolean Gridsdtprofesionalpremiosspaginationbar_Showprevious ;
   private boolean Gridsdtprofesionalpremiosspaginationbar_Shownext ;
   private boolean Gridsdtprofesionalpremiosspaginationbar_Showlast ;
   private boolean Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_panelpremios_Autowidth ;
   private boolean Dvpanel_panelpremios_Autoheight ;
   private boolean Dvpanel_panelpremios_Collapsible ;
   private boolean Dvpanel_panelpremios_Collapsed ;
   private boolean Dvpanel_panelpremios_Showcollapseicon ;
   private boolean Dvpanel_panelpremios_Autoscroll ;
   private boolean Gridsdtprofesionalserviciosspaginationbar_Showfirst ;
   private boolean Gridsdtprofesionalserviciosspaginationbar_Showprevious ;
   private boolean Gridsdtprofesionalserviciosspaginationbar_Shownext ;
   private boolean Gridsdtprofesionalserviciosspaginationbar_Showlast ;
   private boolean Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_panelservicios_Autowidth ;
   private boolean Dvpanel_panelservicios_Autoheight ;
   private boolean Dvpanel_panelservicios_Collapsible ;
   private boolean Dvpanel_panelservicios_Collapsed ;
   private boolean Dvpanel_panelservicios_Showcollapseicon ;
   private boolean Dvpanel_panelservicios_Autoscroll ;
   private boolean Gxuitabspanel_wizardip_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_40_Refreshing=false ;
   private boolean bGXsfl_161_Refreshing=false ;
   private boolean bGXsfl_183_Refreshing=false ;
   private boolean bGXsfl_208_Refreshing=false ;
   private boolean bGXsfl_232_Refreshing=false ;
   private boolean bGXsfl_255_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV161 ;
   private boolean gx_BV40 ;
   private boolean gx_BV183 ;
   private boolean gx_BV208 ;
   private boolean gx_BV232 ;
   private boolean gx_BV255 ;
   private boolean gx_refresh_fired ;
   private boolean AV5CheckRequiredFieldsResult ;
   private com.genexus.webpanels.GXWebGrid FreestylegridinformaciongeneralContainer ;
   private com.genexus.webpanels.GXWebGrid GridsdtprofesionalespecialidadsedesContainer ;
   private com.genexus.webpanels.GXWebGrid GridsdtprofesionaleducacionsContainer ;
   private com.genexus.webpanels.GXWebGrid GridsdtprofesionalexperiencialaboralsContainer ;
   private com.genexus.webpanels.GXWebGrid GridsdtprofesionalpremiossContainer ;
   private com.genexus.webpanels.GXWebGrid GridsdtprofesionalserviciossContainer ;
   private com.genexus.webpanels.GXWebRow FreestylegridinformaciongeneralRow ;
   private com.genexus.webpanels.GXWebRow GridsdtprofesionalserviciossRow ;
   private com.genexus.webpanels.GXWebRow GridsdtprofesionalpremiossRow ;
   private com.genexus.webpanels.GXWebRow GridsdtprofesionalexperiencialaboralsRow ;
   private com.genexus.webpanels.GXWebRow GridsdtprofesionaleducacionsRow ;
   private com.genexus.webpanels.GXWebRow GridsdtprofesionalespecialidadsedesRow ;
   private com.genexus.webpanels.GXWebColumn FreestylegridinformaciongeneralColumn ;
   private com.genexus.webpanels.GXWebColumn GridsdtprofesionalserviciossColumn ;
   private com.genexus.webpanels.GXWebColumn GridsdtprofesionalpremiossColumn ;
   private com.genexus.webpanels.GXWebColumn GridsdtprofesionalexperiencialaboralsColumn ;
   private com.genexus.webpanels.GXWebColumn GridsdtprofesionaleducacionsColumn ;
   private com.genexus.webpanels.GXWebColumn GridsdtprofesionalespecialidadsedesColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelbuttons ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_wizardip ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_paneinfogeneral ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelespecialidad ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_paneleducacion ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelexperiencialaboral ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelpremios ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelservicios ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalservicioss_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalpremioss_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalexperiencialaborals_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionaleducacions_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalespecialidadsedes_empowerer ;
   private com.genexus.webpanels.GXUserControl ucWizard_wizardip ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalserviciosspaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalpremiosspaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalexperiencialaboralspaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionaleducacionspaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalespecialidadsedespaginationbar ;
   private HTMLChoice cmbavSdtprofesionalinformaciongenerals__profesionaltipodocumento ;
   private HTMLChoice cmbavSdtprofesionalinformaciongenerals__profesionalsexo ;
   private HTMLChoice cmbavSdtprofesionalinformaciongenerals__profesionaltiempocita ;
   private HTMLChoice cmbavSdtprofesionalinformaciongenerals__profesionalestado ;
   private HTMLChoice cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion> AV20SDTProfesionalEducacions ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion> GXv_objcol_SdtSDTProfesionalEducacion3[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral> AV21SDTProfesionalExperienciaLaborals ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral> GXv_objcol_SdtSDTProfesionalExperienciaLaboral4[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios> AV22SDTProfesionalPremioss ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios> GXv_objcol_SdtSDTProfesionalPremios5[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios> AV23SDTProfesionalServicioss ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios> GXv_objcol_SdtSDTProfesionalServicios6[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral> AV27SDTProfesionalInformacionGenerals ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral> GXv_objcol_SdtSDTProfesionalInformacionGeneral2[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede> AV28SDTProfesionalEspecialidadSedes ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede> GXv_objcol_SdtSDTProfesionalEspecialidadSede1[] ;
}

