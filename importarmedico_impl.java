package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importarmedico_impl extends GXDataArea
{
   public importarmedico_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importarmedico_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarmedico_impl.class ));
   }

   public importarmedico_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavSdtimportmedicos__profesionaltipodocumento = new HTMLChoice();
      cmbavSdtimportmedicos__profesionalsexo = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtimportmedicos") == 0 )
         {
            nRC_GXsfl_68 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_68"))) ;
            nGXsfl_68_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_68_idx"))) ;
            sGXsfl_68_idx = httpContext.GetPar( "sGXsfl_68_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridsdtimportmedicos_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdtimportmedicos") == 0 )
         {
            subGridsdtimportmedicos_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtimportmedicos_Rows"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtimportmedicos_refresh( subGridsdtimportmedicos_Rows) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IMPORTDATA_Autoupload", GXutil.booltostr( Importdata_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IMPORTDATA_Enableuploadedfilecanceling", GXutil.booltostr( Importdata_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IMPORTDATA_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Importdata_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Width", GXutil.rtrim( Dvpanel_panelimport_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Autowidth", GXutil.booltostr( Dvpanel_panelimport_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Autoheight", GXutil.booltostr( Dvpanel_panelimport_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Cls", GXutil.rtrim( Dvpanel_panelimport_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Title", GXutil.rtrim( Dvpanel_panelimport_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Collapsible", GXutil.booltostr( Dvpanel_panelimport_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Collapsed", GXutil.booltostr( Dvpanel_panelimport_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Showcollapseicon", GXutil.booltostr( Dvpanel_panelimport_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Iconposition", GXutil.rtrim( Dvpanel_panelimport_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Autoscroll", GXutil.booltostr( Dvpanel_panelimport_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtimportmedicospaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtimportmedicospaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtimportmedicospaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtimportmedicospaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtimportmedicospaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtimportmedicospaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtimportmedicos_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
      pa302( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start302( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110334452", false, true);
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
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.importarmedico", new String[] {}, new String[] {}) +"\">") ;
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
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtimportmedicos", AV22SDTImportMedicos);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtimportmedicos", AV22SDTImportMedicos);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_68", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_68, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vUPLOADEDFILES", AV31UploadedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vUPLOADEDFILES", AV31UploadedFiles);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFAILEDFILES", AV7FailedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFAILEDFILES", AV7FailedFiles);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTIMPORTMEDICOSCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV10GridSDTImportMedicosCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTIMPORTMEDICOSPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV11GridSDTImportMedicosPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTIMPORTMEDICOS", AV22SDTImportMedicos);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTIMPORTMEDICOS", AV22SDTImportMedicos);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTIMPORTMEDICOERRORLIST", AV21SDTImportMedicoErrorList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTIMPORTMEDICOERRORLIST", AV21SDTImportMedicoErrorList);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTIMPORTMEDICOS_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IMPORTDATA_Autoupload", GXutil.booltostr( Importdata_Autoupload));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IMPORTDATA_Enableuploadedfilecanceling", GXutil.booltostr( Importdata_Enableuploadedfilecanceling));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IMPORTDATA_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Importdata_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Width", GXutil.rtrim( Dvpanel_panelimport_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Autowidth", GXutil.booltostr( Dvpanel_panelimport_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Autoheight", GXutil.booltostr( Dvpanel_panelimport_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Cls", GXutil.rtrim( Dvpanel_panelimport_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Title", GXutil.rtrim( Dvpanel_panelimport_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Collapsible", GXutil.booltostr( Dvpanel_panelimport_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Collapsed", GXutil.booltostr( Dvpanel_panelimport_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Showcollapseicon", GXutil.booltostr( Dvpanel_panelimport_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Iconposition", GXutil.rtrim( Dvpanel_panelimport_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELIMPORT_Autoscroll", GXutil.booltostr( Dvpanel_panelimport_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtimportmedicospaginationbar_Showfirst));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtimportmedicospaginationbar_Showprevious));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtimportmedicospaginationbar_Shownext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtimportmedicospaginationbar_Showlast));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtimportmedicospaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Pagingbuttonsposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Pagingcaptionposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Emptygridclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtimportmedicospaginationbar_Rowsperpageselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Rowsperpageoptions));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Rowsperpagecaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtimportmedicos_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtimportmedicospaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
         we302( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt302( ) ;
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
      return formatLink("com.projectthani.importarmedico", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "ImportarMedico" ;
   }

   public String getPgmdesc( )
   {
      return "Importar Medico" ;
   }

   public void wb300( )
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
         /* User Defined Control */
         ucDvpanel_panelimport.setProperty("Width", Dvpanel_panelimport_Width);
         ucDvpanel_panelimport.setProperty("AutoWidth", Dvpanel_panelimport_Autowidth);
         ucDvpanel_panelimport.setProperty("AutoHeight", Dvpanel_panelimport_Autoheight);
         ucDvpanel_panelimport.setProperty("Cls", Dvpanel_panelimport_Cls);
         ucDvpanel_panelimport.setProperty("Title", Dvpanel_panelimport_Title);
         ucDvpanel_panelimport.setProperty("Collapsible", Dvpanel_panelimport_Collapsible);
         ucDvpanel_panelimport.setProperty("Collapsed", Dvpanel_panelimport_Collapsed);
         ucDvpanel_panelimport.setProperty("ShowCollapseIcon", Dvpanel_panelimport_Showcollapseicon);
         ucDvpanel_panelimport.setProperty("IconPosition", Dvpanel_panelimport_Iconposition);
         ucDvpanel_panelimport.setProperty("AutoScroll", Dvpanel_panelimport_Autoscroll);
         ucDvpanel_panelimport.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelimport_Internalname, "DVPANEL_PANELIMPORTContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELIMPORTContainer"+"PanelImport"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divPanelimport_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucImportdata.setProperty("AutoUpload", Importdata_Autoupload);
         ucImportdata.setProperty("TooltipText", Importdata_Tooltiptext);
         ucImportdata.setProperty("EnableUploadedFileCanceling", Importdata_Enableuploadedfilecanceling);
         ucImportdata.setProperty("MaxNumberOfFiles", Importdata_Maxnumberoffiles);
         ucImportdata.setProperty("UploadedFiles", AV31UploadedFiles);
         ucImportdata.setProperty("FailedFiles", AV7FailedFiles);
         ucImportdata.render(context, "fileupload", Importdata_Internalname, "IMPORTDATAContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MarginTop20px", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSeccionbuton_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnprocesardata_Internalname, "gx.evt.setGridEvt("+GXutil.str( 68, 2, 0)+","+"null"+");", "Procesar", bttBtnprocesardata_Jsonclick, 5, "Procesar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOPROCESARDATA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ImportarMedico.htm");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnguardardatamedico_Internalname, "gx.evt.setGridEvt("+GXutil.str( 68, 2, 0)+","+"null"+");", "Importar Médicos", bttBtnbtnguardardatamedico_Jsonclick, 5, "Importar Médicos", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNGUARDARDATAMEDICO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ImportarMedico.htm");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtndescargarreportimport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 68, 2, 0)+","+"null"+");", "Reporte - error import", bttBtnbtndescargarreportimport_Jsonclick, 5, "Reporte - error import", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNDESCARGARREPORTIMPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ImportarMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup1_Internalname, "DETALLE DE LA IMPORTACIÓN DE MÉDICOS", 1, 0, "px", 0, "px", "GroupImportData", "", "HLP_ImportarMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDetalleimport_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;align-items:flex-start;align-content:flex-start;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableprocessdatasuccess_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockprocessdatasuccess_Internalname, "Total de data procesada:", "", "", lblTextblockprocessdatasuccess_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ImportarMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProcessdatasuccess_Internalname, "Process Data Success", "col-sm-3 ReadonlyAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'" + sGXsfl_68_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProcessdatasuccess_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ProcessDataSuccess, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavProcessdatasuccess_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ProcessDataSuccess), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ProcessDataSuccess), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProcessdatasuccess_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavProcessdatasuccess_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ImportarMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableprocessdataerror_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockprocessdataerror_Internalname, "Total de data no procesada:", "", "", lblTextblockprocessdataerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ImportarMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProcessdataerror_Internalname, "Process Data Error", "col-sm-3 ReadonlyAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'" + sGXsfl_68_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProcessdataerror_Internalname, GXutil.ltrim( localUtil.ntoc( AV19ProcessDataError, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavProcessdataerror_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19ProcessDataError), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19ProcessDataError), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProcessdataerror_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavProcessdataerror_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ImportarMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableimportdatasuccess_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockimportdatasuccess_Internalname, "Total de data importada:", "", "", lblTextblockimportdatasuccess_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ImportarMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavImportdatasuccess_Internalname, "Import Data Success", "col-sm-3 ReadonlyAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'" + sGXsfl_68_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavImportdatasuccess_Internalname, GXutil.ltrim( localUtil.ntoc( AV14ImportDataSuccess, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavImportdatasuccess_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV14ImportDataSuccess), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV14ImportDataSuccess), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,51);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavImportdatasuccess_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavImportdatasuccess_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ImportarMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableimportdataerror_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockimportdataerror_Internalname, "Total de data no importada:", "", "", lblTextblockimportdataerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ImportarMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavImportdataerror_Internalname, "Import Data Error", "col-sm-3 ReadonlyAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'" + sGXsfl_68_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavImportdataerror_Internalname, GXutil.ltrim( localUtil.ntoc( AV13ImportDataError, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavImportdataerror_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV13ImportDataError), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV13ImportDataError), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavImportdataerror_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavImportdataerror_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ImportarMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablelistmedicos_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGridsdtimportmedicostablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridsdtimportmedicosContainer.SetWrapped(nGXWrapped);
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridsdtimportmedicosContainer"+"DivS\" data-gxgridid=\"68\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridsdtimportmedicos_Internalname, subGridsdtimportmedicos_Internalname, "", "GridWithPaginationBar GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGridsdtimportmedicos_Backcolorstyle == 0 )
            {
               subGridsdtimportmedicos_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGridsdtimportmedicos_Class) > 0 )
               {
                  subGridsdtimportmedicos_Linesclass = subGridsdtimportmedicos_Class+"Title" ;
               }
            }
            else
            {
               subGridsdtimportmedicos_Titlebackstyle = (byte)(1) ;
               if ( subGridsdtimportmedicos_Backcolorstyle == 1 )
               {
                  subGridsdtimportmedicos_Titlebackcolor = subGridsdtimportmedicos_Allbackcolor ;
                  if ( GXutil.len( subGridsdtimportmedicos_Class) > 0 )
                  {
                     subGridsdtimportmedicos_Linesclass = subGridsdtimportmedicos_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGridsdtimportmedicos_Class) > 0 )
                  {
                     subGridsdtimportmedicos_Linesclass = subGridsdtimportmedicos_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Paterno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Apellido Materno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombres") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nro Documento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "F. Nacimiento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Sexo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "CMP") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Telefono") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Correo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Direccion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridsdtimportmedicosContainer.AddObjectProperty("GridName", "Gridsdtimportmedicos");
         }
         else
         {
            GridsdtimportmedicosContainer.AddObjectProperty("GridName", "Gridsdtimportmedicos");
            GridsdtimportmedicosContainer.AddObjectProperty("Header", subGridsdtimportmedicos_Header);
            GridsdtimportmedicosContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
            GridsdtimportmedicosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddObjectProperty("CmpContext", "");
            GridsdtimportmedicosContainer.AddObjectProperty("InMasterPage", "false");
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtimportmedicos__profesionalapellidopaterno_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtimportmedicos__profesionalapellidomaterno_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtimportmedicos__profesionalnombres_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtimportmedicos__profesionaltipodocumento.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtimportmedicos__profesionalnrodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtimportmedicos__profesionalfechanacimiento_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtimportmedicos__profesionalsexo.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtimportmedicos__profesionalcop_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtimportmedicos__profesionaltelefono_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtimportmedicos__profesionalcorreo_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtimportmedicosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtimportmedicos__profesionaldireccion_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddColumnProperties(GridsdtimportmedicosColumn);
            GridsdtimportmedicosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridsdtimportmedicosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 68 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_68 = (int)(nGXsfl_68_idx-1) ;
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV34GXV1 = nGXsfl_68_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridsdtimportmedicosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdtimportmedicos", GridsdtimportmedicosContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtimportmedicosContainerData", GridsdtimportmedicosContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtimportmedicosContainerData"+"V", GridsdtimportmedicosContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtimportmedicosContainerData"+"V"+"\" value='"+GridsdtimportmedicosContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridsdtimportmedicospaginationbar.setProperty("Class", Gridsdtimportmedicospaginationbar_Class);
         ucGridsdtimportmedicospaginationbar.setProperty("ShowFirst", Gridsdtimportmedicospaginationbar_Showfirst);
         ucGridsdtimportmedicospaginationbar.setProperty("ShowPrevious", Gridsdtimportmedicospaginationbar_Showprevious);
         ucGridsdtimportmedicospaginationbar.setProperty("ShowNext", Gridsdtimportmedicospaginationbar_Shownext);
         ucGridsdtimportmedicospaginationbar.setProperty("ShowLast", Gridsdtimportmedicospaginationbar_Showlast);
         ucGridsdtimportmedicospaginationbar.setProperty("PagesToShow", Gridsdtimportmedicospaginationbar_Pagestoshow);
         ucGridsdtimportmedicospaginationbar.setProperty("PagingButtonsPosition", Gridsdtimportmedicospaginationbar_Pagingbuttonsposition);
         ucGridsdtimportmedicospaginationbar.setProperty("PagingCaptionPosition", Gridsdtimportmedicospaginationbar_Pagingcaptionposition);
         ucGridsdtimportmedicospaginationbar.setProperty("EmptyGridClass", Gridsdtimportmedicospaginationbar_Emptygridclass);
         ucGridsdtimportmedicospaginationbar.setProperty("RowsPerPageSelector", Gridsdtimportmedicospaginationbar_Rowsperpageselector);
         ucGridsdtimportmedicospaginationbar.setProperty("RowsPerPageOptions", Gridsdtimportmedicospaginationbar_Rowsperpageoptions);
         ucGridsdtimportmedicospaginationbar.setProperty("Previous", Gridsdtimportmedicospaginationbar_Previous);
         ucGridsdtimportmedicospaginationbar.setProperty("Next", Gridsdtimportmedicospaginationbar_Next);
         ucGridsdtimportmedicospaginationbar.setProperty("Caption", Gridsdtimportmedicospaginationbar_Caption);
         ucGridsdtimportmedicospaginationbar.setProperty("EmptyGridCaption", Gridsdtimportmedicospaginationbar_Emptygridcaption);
         ucGridsdtimportmedicospaginationbar.setProperty("RowsPerPageCaption", Gridsdtimportmedicospaginationbar_Rowsperpagecaption);
         ucGridsdtimportmedicospaginationbar.setProperty("CurrentPage", AV10GridSDTImportMedicosCurrentPage);
         ucGridsdtimportmedicospaginationbar.setProperty("PageCount", AV11GridSDTImportMedicosPageCount);
         ucGridsdtimportmedicospaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtimportmedicospaginationbar_Internalname, "GRIDSDTIMPORTMEDICOSPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         ucGridsdtimportmedicos_empowerer.render(context, "wwp.gridempowerer", Gridsdtimportmedicos_empowerer_Internalname, "GRIDSDTIMPORTMEDICOS_EMPOWERERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 68 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV34GXV1 = nGXsfl_68_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridsdtimportmedicosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdtimportmedicos", GridsdtimportmedicosContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtimportmedicosContainerData", GridsdtimportmedicosContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtimportmedicosContainerData"+"V", GridsdtimportmedicosContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtimportmedicosContainerData"+"V"+"\" value='"+GridsdtimportmedicosContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start302( )
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
         Form.getMeta().addItem("description", "Importar Medico", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup300( ) ;
   }

   public void ws302( )
   {
      start302( ) ;
      evt302( ) ;
   }

   public void evt302( )
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
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11302 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTIMPORTMEDICOSPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12302 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOPROCESARDATA'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoProcesarData' */
                           e13302 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBTNGUARDARDATAMEDICO'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoBtnGuardarDataMedico' */
                           e14302 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBTNDESCARGARREPORTIMPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DobtnDescargarReportImport' */
                           e15302 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "GRIDSDTIMPORTMEDICOS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_68_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_68_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_682( ) ;
                           AV34GXV1 = (int)(nGXsfl_68_idx+GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage) ;
                           if ( ( AV22SDTImportMedicos.size() >= AV34GXV1 ) && ( AV34GXV1 > 0 ) )
                           {
                              AV22SDTImportMedicos.currentItem( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)) );
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
                                 e16302 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e17302 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDSDTIMPORTMEDICOS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e18302 ();
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

   public void we302( )
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

   public void pa302( )
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
            GX_FocusControl = edtavProcessdatasuccess_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridsdtimportmedicos_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_682( ) ;
      while ( nGXsfl_68_idx <= nRC_GXsfl_68 )
      {
         sendrow_682( ) ;
         nGXsfl_68_idx = ((subGridsdtimportmedicos_Islastpage==1)&&(nGXsfl_68_idx+1>subgridsdtimportmedicos_fnc_recordsperpage( )) ? 1 : nGXsfl_68_idx+1) ;
         sGXsfl_68_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_682( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtimportmedicosContainer)) ;
      /* End function gxnrGridsdtimportmedicos_newrow */
   }

   public void gxgrgridsdtimportmedicos_refresh( int subGridsdtimportmedicos_Rows )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e17302 ();
      GRIDSDTIMPORTMEDICOS_nCurrentRecord = 0 ;
      rf302( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdtimportmedicos_refresh */
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
      rf302( ) ;
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
      edtavProcessdatasuccess_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProcessdatasuccess_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProcessdatasuccess_Enabled), 5, 0), true);
      edtavProcessdataerror_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProcessdataerror_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProcessdataerror_Enabled), 5, 0), true);
      edtavImportdatasuccess_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavImportdatasuccess_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavImportdatasuccess_Enabled), 5, 0), true);
      edtavImportdataerror_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavImportdataerror_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavImportdataerror_Enabled), 5, 0), true);
      edtavSdtimportmedicos__profesionalapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalapellidopaterno_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalapellidomaterno_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalnombres_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      cmbavSdtimportmedicos__profesionaltipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtimportmedicos__profesionaltipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtimportmedicos__profesionaltipodocumento.getEnabled(), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalnrodocumento_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalfechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalfechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalfechanacimiento_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      cmbavSdtimportmedicos__profesionalsexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtimportmedicos__profesionalsexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtimportmedicos__profesionalsexo.getEnabled(), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalcop_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalcop_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalcop_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionaltelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionaltelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionaltelefono_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalcorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalcorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalcorreo_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionaldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionaldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionaldireccion_Enabled), 5, 0), !bGXsfl_68_Refreshing);
   }

   public void rf302( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtimportmedicosContainer.ClearRows();
      }
      wbStart = (short)(68) ;
      /* Execute user event: Refresh */
      e17302 ();
      nGXsfl_68_idx = 1 ;
      sGXsfl_68_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_682( ) ;
      bGXsfl_68_Refreshing = true ;
      GridsdtimportmedicosContainer.AddObjectProperty("GridName", "Gridsdtimportmedicos");
      GridsdtimportmedicosContainer.AddObjectProperty("CmpContext", "");
      GridsdtimportmedicosContainer.AddObjectProperty("InMasterPage", "false");
      GridsdtimportmedicosContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
      GridsdtimportmedicosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsdtimportmedicosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsdtimportmedicosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsdtimportmedicosContainer.setPageSize( subgridsdtimportmedicos_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_682( ) ;
         e18302 ();
         if ( ( GRIDSDTIMPORTMEDICOS_nCurrentRecord > 0 ) && ( GRIDSDTIMPORTMEDICOS_nGridOutOfScope == 0 ) && ( nGXsfl_68_idx == 1 ) )
         {
            GRIDSDTIMPORTMEDICOS_nCurrentRecord = 0 ;
            GRIDSDTIMPORTMEDICOS_nGridOutOfScope = 1 ;
            subgridsdtimportmedicos_firstpage( ) ;
            e18302 ();
         }
         wbEnd = (short)(68) ;
         wb300( ) ;
      }
      bGXsfl_68_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes302( )
   {
   }

   public int subgridsdtimportmedicos_fnc_pagecount( )
   {
      GRIDSDTIMPORTMEDICOS_nRecordCount = subgridsdtimportmedicos_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDTIMPORTMEDICOS_nRecordCount) % (subgridsdtimportmedicos_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDTIMPORTMEDICOS_nRecordCount/ (double) (subgridsdtimportmedicos_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDTIMPORTMEDICOS_nRecordCount/ (double) (subgridsdtimportmedicos_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdtimportmedicos_fnc_recordcount( )
   {
      return AV22SDTImportMedicos.size() ;
   }

   public int subgridsdtimportmedicos_fnc_recordsperpage( )
   {
      if ( subGridsdtimportmedicos_Rows > 0 )
      {
         return subGridsdtimportmedicos_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdtimportmedicos_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage/ (double) (subgridsdtimportmedicos_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdtimportmedicos_firstpage( )
   {
      GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtimportmedicos_refresh( subGridsdtimportmedicos_Rows) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtimportmedicos_nextpage( )
   {
      GRIDSDTIMPORTMEDICOS_nRecordCount = subgridsdtimportmedicos_fnc_recordcount( ) ;
      if ( ( GRIDSDTIMPORTMEDICOS_nRecordCount >= subgridsdtimportmedicos_fnc_recordsperpage( ) ) && ( GRIDSDTIMPORTMEDICOS_nEOF == 0 ) )
      {
         GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage = (long)(GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage+subgridsdtimportmedicos_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsdtimportmedicosContainer.AddObjectProperty("GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage", GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtimportmedicos_refresh( subGridsdtimportmedicos_Rows) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDTIMPORTMEDICOS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdtimportmedicos_previouspage( )
   {
      if ( GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage >= subgridsdtimportmedicos_fnc_recordsperpage( ) )
      {
         GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage = (long)(GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage-subgridsdtimportmedicos_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtimportmedicos_refresh( subGridsdtimportmedicos_Rows) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtimportmedicos_lastpage( )
   {
      GRIDSDTIMPORTMEDICOS_nRecordCount = subgridsdtimportmedicos_fnc_recordcount( ) ;
      if ( GRIDSDTIMPORTMEDICOS_nRecordCount > subgridsdtimportmedicos_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDTIMPORTMEDICOS_nRecordCount) % (subgridsdtimportmedicos_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage = (long)(GRIDSDTIMPORTMEDICOS_nRecordCount-subgridsdtimportmedicos_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage = (long)(GRIDSDTIMPORTMEDICOS_nRecordCount-((int)((GRIDSDTIMPORTMEDICOS_nRecordCount) % (subgridsdtimportmedicos_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtimportmedicos_refresh( subGridsdtimportmedicos_Rows) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdtimportmedicos_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage = (long)(subgridsdtimportmedicos_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtimportmedicos_refresh( subGridsdtimportmedicos_Rows) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavProcessdatasuccess_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProcessdatasuccess_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProcessdatasuccess_Enabled), 5, 0), true);
      edtavProcessdataerror_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProcessdataerror_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProcessdataerror_Enabled), 5, 0), true);
      edtavImportdatasuccess_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavImportdatasuccess_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavImportdatasuccess_Enabled), 5, 0), true);
      edtavImportdataerror_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavImportdataerror_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavImportdataerror_Enabled), 5, 0), true);
      edtavSdtimportmedicos__profesionalapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalapellidopaterno_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalapellidomaterno_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalnombres_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      cmbavSdtimportmedicos__profesionaltipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtimportmedicos__profesionaltipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtimportmedicos__profesionaltipodocumento.getEnabled(), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalnrodocumento_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalfechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalfechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalfechanacimiento_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      cmbavSdtimportmedicos__profesionalsexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtimportmedicos__profesionalsexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtimportmedicos__profesionalsexo.getEnabled(), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalcop_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalcop_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalcop_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionaltelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionaltelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionaltelefono_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionalcorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionalcorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionalcorreo_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      edtavSdtimportmedicos__profesionaldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtimportmedicos__profesionaldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtimportmedicos__profesionaldireccion_Enabled), 5, 0), !bGXsfl_68_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup300( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e16302 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtimportmedicos"), AV22SDTImportMedicos);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vUPLOADEDFILES"), AV31UploadedFiles);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFAILEDFILES"), AV7FailedFiles);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTIMPORTMEDICOS"), AV22SDTImportMedicos);
         /* Read saved values. */
         nRC_GXsfl_68 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_68"), ",", ".")) ;
         AV10GridSDTImportMedicosCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTIMPORTMEDICOSCURRENTPAGE"), ",", ".") ;
         AV11GridSDTImportMedicosPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTIMPORTMEDICOSPAGECOUNT"), ",", ".") ;
         GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage"), ",", ".") ;
         GRIDSDTIMPORTMEDICOS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOS_nEOF"), ",", ".")) ;
         subGridsdtimportmedicos_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOS_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Rows, (byte)(6), (byte)(0), ".", "")));
         Importdata_Autoupload = GXutil.strtobool( httpContext.cgiGet( "IMPORTDATA_Autoupload")) ;
         Importdata_Enableuploadedfilecanceling = GXutil.strtobool( httpContext.cgiGet( "IMPORTDATA_Enableuploadedfilecanceling")) ;
         Importdata_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( "IMPORTDATA_Maxnumberoffiles"), ",", ".")) ;
         Dvpanel_panelimport_Width = httpContext.cgiGet( "DVPANEL_PANELIMPORT_Width") ;
         Dvpanel_panelimport_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELIMPORT_Autowidth")) ;
         Dvpanel_panelimport_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELIMPORT_Autoheight")) ;
         Dvpanel_panelimport_Cls = httpContext.cgiGet( "DVPANEL_PANELIMPORT_Cls") ;
         Dvpanel_panelimport_Title = httpContext.cgiGet( "DVPANEL_PANELIMPORT_Title") ;
         Dvpanel_panelimport_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELIMPORT_Collapsible")) ;
         Dvpanel_panelimport_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELIMPORT_Collapsed")) ;
         Dvpanel_panelimport_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELIMPORT_Showcollapseicon")) ;
         Dvpanel_panelimport_Iconposition = httpContext.cgiGet( "DVPANEL_PANELIMPORT_Iconposition") ;
         Dvpanel_panelimport_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELIMPORT_Autoscroll")) ;
         Gridsdtimportmedicospaginationbar_Class = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Class") ;
         Gridsdtimportmedicospaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Showfirst")) ;
         Gridsdtimportmedicospaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Showprevious")) ;
         Gridsdtimportmedicospaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Shownext")) ;
         Gridsdtimportmedicospaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Showlast")) ;
         Gridsdtimportmedicospaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Gridsdtimportmedicospaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridsdtimportmedicospaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Pagingcaptionposition") ;
         Gridsdtimportmedicospaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Emptygridclass") ;
         Gridsdtimportmedicospaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselector")) ;
         Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridsdtimportmedicospaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageoptions") ;
         Gridsdtimportmedicospaginationbar_Previous = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Previous") ;
         Gridsdtimportmedicospaginationbar_Next = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Next") ;
         Gridsdtimportmedicospaginationbar_Caption = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Caption") ;
         Gridsdtimportmedicospaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Emptygridcaption") ;
         Gridsdtimportmedicospaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpagecaption") ;
         Gridsdtimportmedicos_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOS_EMPOWERER_Gridinternalname") ;
         Gridsdtimportmedicospaginationbar_Selectedpage = httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Selectedpage") ;
         Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTIMPORTMEDICOSPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         nRC_GXsfl_68 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_68"), ",", ".")) ;
         nGXsfl_68_fel_idx = 0 ;
         while ( nGXsfl_68_fel_idx < nRC_GXsfl_68 )
         {
            nGXsfl_68_fel_idx = ((subGridsdtimportmedicos_Islastpage==1)&&(nGXsfl_68_fel_idx+1>subgridsdtimportmedicos_fnc_recordsperpage( )) ? 1 : nGXsfl_68_fel_idx+1) ;
            sGXsfl_68_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_682( ) ;
            AV34GXV1 = (int)(nGXsfl_68_fel_idx+GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage) ;
            if ( ( AV22SDTImportMedicos.size() >= AV34GXV1 ) && ( AV34GXV1 > 0 ) )
            {
               AV22SDTImportMedicos.currentItem( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)) );
            }
         }
         if ( nGXsfl_68_fel_idx == 0 )
         {
            nGXsfl_68_idx = 1 ;
            sGXsfl_68_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_682( ) ;
         }
         nGXsfl_68_fel_idx = 1 ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavProcessdatasuccess_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavProcessdatasuccess_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPROCESSDATASUCCESS");
            GX_FocusControl = edtavProcessdatasuccess_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV20ProcessDataSuccess = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ProcessDataSuccess", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ProcessDataSuccess), 4, 0));
         }
         else
         {
            AV20ProcessDataSuccess = (short)(localUtil.ctol( httpContext.cgiGet( edtavProcessdatasuccess_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ProcessDataSuccess", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ProcessDataSuccess), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavProcessdataerror_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavProcessdataerror_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPROCESSDATAERROR");
            GX_FocusControl = edtavProcessdataerror_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19ProcessDataError = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ProcessDataError", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ProcessDataError), 4, 0));
         }
         else
         {
            AV19ProcessDataError = (short)(localUtil.ctol( httpContext.cgiGet( edtavProcessdataerror_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ProcessDataError", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ProcessDataError), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavImportdatasuccess_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavImportdatasuccess_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vIMPORTDATASUCCESS");
            GX_FocusControl = edtavImportdatasuccess_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV14ImportDataSuccess = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14ImportDataSuccess", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14ImportDataSuccess), 4, 0));
         }
         else
         {
            AV14ImportDataSuccess = (short)(localUtil.ctol( httpContext.cgiGet( edtavImportdatasuccess_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14ImportDataSuccess", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14ImportDataSuccess), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavImportdataerror_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavImportdataerror_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vIMPORTDATAERROR");
            GX_FocusControl = edtavImportdataerror_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV13ImportDataError = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13ImportDataError", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13ImportDataError), 4, 0));
         }
         else
         {
            AV13ImportDataError = (short)(localUtil.ctol( httpContext.cgiGet( edtavImportdataerror_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13ImportDataError", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13ImportDataError), 4, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
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
      e16302 ();
      if (returnInSub) return;
   }

   public void e16302( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.getJscriptsrc().add("AbrirNuevaVentana.js") ;
      Gridsdtimportmedicos_empowerer_Gridinternalname = subGridsdtimportmedicos_Internalname ;
      ucGridsdtimportmedicos_empowerer.sendProperty(context, "", false, Gridsdtimportmedicos_empowerer_Internalname, "GridInternalName", Gridsdtimportmedicos_empowerer_Gridinternalname);
      subGridsdtimportmedicos_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue = subGridsdtimportmedicos_Rows ;
      ucGridsdtimportmedicospaginationbar.sendProperty(context, "", false, Gridsdtimportmedicospaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e17302( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      AV10GridSDTImportMedicosCurrentPage = subgridsdtimportmedicos_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10GridSDTImportMedicosCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10GridSDTImportMedicosCurrentPage), 10, 0));
      AV11GridSDTImportMedicosPageCount = subgridsdtimportmedicos_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11GridSDTImportMedicosPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11GridSDTImportMedicosPageCount), 10, 0));
      /*  Sending Event outputs  */
   }

   private void e18302( )
   {
      /* Gridsdtimportmedicos_Load Routine */
      returnInSub = false ;
      AV34GXV1 = 1 ;
      while ( AV34GXV1 <= AV22SDTImportMedicos.size() )
      {
         AV22SDTImportMedicos.currentItem( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(68) ;
         }
         if ( ( subGridsdtimportmedicos_Islastpage == 1 ) || ( subGridsdtimportmedicos_Rows == 0 ) || ( ( GRIDSDTIMPORTMEDICOS_nCurrentRecord >= GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage ) && ( GRIDSDTIMPORTMEDICOS_nCurrentRecord < GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage + subgridsdtimportmedicos_fnc_recordsperpage( ) ) ) )
         {
            sendrow_682( ) ;
            GRIDSDTIMPORTMEDICOS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTIMPORTMEDICOS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTIMPORTMEDICOS_nCurrentRecord + 1 >= subgridsdtimportmedicos_fnc_recordcount( ) )
            {
               GRIDSDTIMPORTMEDICOS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTIMPORTMEDICOS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTIMPORTMEDICOS_nCurrentRecord = (long)(GRIDSDTIMPORTMEDICOS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_68_Refreshing )
         {
            httpContext.doAjaxLoad(68, GridsdtimportmedicosRow);
         }
         AV34GXV1 = (int)(AV34GXV1+1) ;
      }
   }

   public void e11302( )
   {
      /* Gridsdtimportmedicospaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtimportmedicospaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtimportmedicos_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtimportmedicospaginationbar_Selectedpage, "Next") == 0 )
      {
         AV18PageToGo = subgridsdtimportmedicos_fnc_currentpage( ) ;
         AV18PageToGo = (int)(AV18PageToGo+1) ;
         subgridsdtimportmedicos_gotopage( AV18PageToGo) ;
      }
      else
      {
         AV18PageToGo = (int)(GXutil.lval( Gridsdtimportmedicospaginationbar_Selectedpage)) ;
         subgridsdtimportmedicos_gotopage( AV18PageToGo) ;
      }
   }

   public void e12302( )
   {
      /* Gridsdtimportmedicospaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtimportmedicos_Rows = Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTIMPORTMEDICOS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtimportmedicos_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtimportmedicos_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e13302( )
   {
      AV34GXV1 = (int)(nGXsfl_68_idx+GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage) ;
      if ( AV22SDTImportMedicos.size() >= AV34GXV1 )
      {
         AV22SDTImportMedicos.currentItem( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)) );
      }
      /* 'DoProcesarData' Routine */
      returnInSub = false ;
      AV20ProcessDataSuccess = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ProcessDataSuccess", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ProcessDataSuccess), 4, 0));
      if ( AV31UploadedFiles.size() > 0 )
      {
         AV5File.setSource( ((com.projectthani.SdtFileUploadData)AV31UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_File() );
         GXv_objcol_SdtSDTImportMedico1[0] = AV22SDTImportMedicos ;
         GXv_int2[0] = AV20ProcessDataSuccess ;
         new com.projectthani.prcprocesardatamedicos(remoteHandle, context).execute( AV5File.getURI(), GXv_objcol_SdtSDTImportMedico1, GXv_int2) ;
         AV22SDTImportMedicos = GXv_objcol_SdtSDTImportMedico1[0] ;
         importarmedico_impl.this.AV20ProcessDataSuccess = GXv_int2[0] ;
         gx_BV68 = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20ProcessDataSuccess", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ProcessDataSuccess), 4, 0));
      }
      /*  Sending Event outputs  */
      if ( gx_BV68 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22SDTImportMedicos", AV22SDTImportMedicos);
         nGXsfl_68_bak_idx = nGXsfl_68_idx ;
         gxgrgridsdtimportmedicos_refresh( subGridsdtimportmedicos_Rows) ;
         nGXsfl_68_idx = nGXsfl_68_bak_idx ;
         sGXsfl_68_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_682( ) ;
      }
   }

   public void e14302( )
   {
      AV34GXV1 = (int)(nGXsfl_68_idx+GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage) ;
      if ( AV22SDTImportMedicos.size() >= AV34GXV1 )
      {
         AV22SDTImportMedicos.currentItem( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)) );
      }
      /* 'DoBtnGuardarDataMedico' Routine */
      returnInSub = false ;
      GXv_objcol_SdtSDTImportMedicoError3[0] = AV21SDTImportMedicoErrorList ;
      GXv_int2[0] = AV14ImportDataSuccess ;
      GXv_int4[0] = AV13ImportDataError ;
      new com.projectthani.prcsavedatamedicos(remoteHandle, context).execute( AV22SDTImportMedicos, GXv_objcol_SdtSDTImportMedicoError3, GXv_int2, GXv_int4) ;
      AV21SDTImportMedicoErrorList = GXv_objcol_SdtSDTImportMedicoError3[0] ;
      importarmedico_impl.this.AV14ImportDataSuccess = GXv_int2[0] ;
      importarmedico_impl.this.AV13ImportDataError = GXv_int4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14ImportDataSuccess", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14ImportDataSuccess), 4, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV13ImportDataError", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13ImportDataError), 4, 0));
      httpContext.GX_msglist.addItem("Se importaron: "+AV14ImportDataSuccess+" registros.");
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21SDTImportMedicoErrorList", AV21SDTImportMedicoErrorList);
   }

   public void e15302( )
   {
      /* 'DobtnDescargarReportImport' Routine */
      returnInSub = false ;
      GXv_char5[0] = AV8FileName ;
      new com.projectthani.prcerrorimportmedicos(remoteHandle, context).execute( AV21SDTImportMedicoErrorList, GXv_char5) ;
      importarmedico_impl.this.AV8FileName = GXv_char5[0] ;
      if ( GXutil.strcmp(AV8FileName, "") != 0 )
      {
         this.executeExternalObjectMethod("", false, "AV6AbrirNewPage", "NewPage", new Object[] {AV8FileName}, false);
      }
      else
      {
         httpContext.GX_msglist.addItem("Error al descargar reporte");
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
      pa302( ) ;
      ws302( ) ;
      we302( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334634", true, true);
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
      httpContext.AddJavascriptSource("importarmedico.js", "?20225110334635", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_682( )
   {
      edtavSdtimportmedicos__profesionalapellidopaterno_Internalname = "SDTIMPORTMEDICOS__PROFESIONALAPELLIDOPATERNO_"+sGXsfl_68_idx ;
      edtavSdtimportmedicos__profesionalapellidomaterno_Internalname = "SDTIMPORTMEDICOS__PROFESIONALAPELLIDOMATERNO_"+sGXsfl_68_idx ;
      edtavSdtimportmedicos__profesionalnombres_Internalname = "SDTIMPORTMEDICOS__PROFESIONALNOMBRES_"+sGXsfl_68_idx ;
      cmbavSdtimportmedicos__profesionaltipodocumento.setInternalname( "SDTIMPORTMEDICOS__PROFESIONALTIPODOCUMENTO_"+sGXsfl_68_idx );
      edtavSdtimportmedicos__profesionalnrodocumento_Internalname = "SDTIMPORTMEDICOS__PROFESIONALNRODOCUMENTO_"+sGXsfl_68_idx ;
      edtavSdtimportmedicos__profesionalfechanacimiento_Internalname = "SDTIMPORTMEDICOS__PROFESIONALFECHANACIMIENTO_"+sGXsfl_68_idx ;
      cmbavSdtimportmedicos__profesionalsexo.setInternalname( "SDTIMPORTMEDICOS__PROFESIONALSEXO_"+sGXsfl_68_idx );
      edtavSdtimportmedicos__profesionalcop_Internalname = "SDTIMPORTMEDICOS__PROFESIONALCOP_"+sGXsfl_68_idx ;
      edtavSdtimportmedicos__profesionaltelefono_Internalname = "SDTIMPORTMEDICOS__PROFESIONALTELEFONO_"+sGXsfl_68_idx ;
      edtavSdtimportmedicos__profesionalcorreo_Internalname = "SDTIMPORTMEDICOS__PROFESIONALCORREO_"+sGXsfl_68_idx ;
      edtavSdtimportmedicos__profesionaldireccion_Internalname = "SDTIMPORTMEDICOS__PROFESIONALDIRECCION_"+sGXsfl_68_idx ;
   }

   public void subsflControlProps_fel_682( )
   {
      edtavSdtimportmedicos__profesionalapellidopaterno_Internalname = "SDTIMPORTMEDICOS__PROFESIONALAPELLIDOPATERNO_"+sGXsfl_68_fel_idx ;
      edtavSdtimportmedicos__profesionalapellidomaterno_Internalname = "SDTIMPORTMEDICOS__PROFESIONALAPELLIDOMATERNO_"+sGXsfl_68_fel_idx ;
      edtavSdtimportmedicos__profesionalnombres_Internalname = "SDTIMPORTMEDICOS__PROFESIONALNOMBRES_"+sGXsfl_68_fel_idx ;
      cmbavSdtimportmedicos__profesionaltipodocumento.setInternalname( "SDTIMPORTMEDICOS__PROFESIONALTIPODOCUMENTO_"+sGXsfl_68_fel_idx );
      edtavSdtimportmedicos__profesionalnrodocumento_Internalname = "SDTIMPORTMEDICOS__PROFESIONALNRODOCUMENTO_"+sGXsfl_68_fel_idx ;
      edtavSdtimportmedicos__profesionalfechanacimiento_Internalname = "SDTIMPORTMEDICOS__PROFESIONALFECHANACIMIENTO_"+sGXsfl_68_fel_idx ;
      cmbavSdtimportmedicos__profesionalsexo.setInternalname( "SDTIMPORTMEDICOS__PROFESIONALSEXO_"+sGXsfl_68_fel_idx );
      edtavSdtimportmedicos__profesionalcop_Internalname = "SDTIMPORTMEDICOS__PROFESIONALCOP_"+sGXsfl_68_fel_idx ;
      edtavSdtimportmedicos__profesionaltelefono_Internalname = "SDTIMPORTMEDICOS__PROFESIONALTELEFONO_"+sGXsfl_68_fel_idx ;
      edtavSdtimportmedicos__profesionalcorreo_Internalname = "SDTIMPORTMEDICOS__PROFESIONALCORREO_"+sGXsfl_68_fel_idx ;
      edtavSdtimportmedicos__profesionaldireccion_Internalname = "SDTIMPORTMEDICOS__PROFESIONALDIRECCION_"+sGXsfl_68_fel_idx ;
   }

   public void sendrow_682( )
   {
      subsflControlProps_682( ) ;
      wb300( ) ;
      if ( ( subGridsdtimportmedicos_Rows * 1 == 0 ) || ( nGXsfl_68_idx <= subgridsdtimportmedicos_fnc_recordsperpage( ) * 1 ) )
      {
         GridsdtimportmedicosRow = GXWebRow.GetNew(context,GridsdtimportmedicosContainer) ;
         if ( subGridsdtimportmedicos_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdtimportmedicos_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdtimportmedicos_Class, "") != 0 )
            {
               subGridsdtimportmedicos_Linesclass = subGridsdtimportmedicos_Class+"Odd" ;
            }
         }
         else if ( subGridsdtimportmedicos_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdtimportmedicos_Backstyle = (byte)(0) ;
            subGridsdtimportmedicos_Backcolor = subGridsdtimportmedicos_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdtimportmedicos_Class, "") != 0 )
            {
               subGridsdtimportmedicos_Linesclass = subGridsdtimportmedicos_Class+"Uniform" ;
            }
         }
         else if ( subGridsdtimportmedicos_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdtimportmedicos_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdtimportmedicos_Class, "") != 0 )
            {
               subGridsdtimportmedicos_Linesclass = subGridsdtimportmedicos_Class+"Odd" ;
            }
            subGridsdtimportmedicos_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdtimportmedicos_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdtimportmedicos_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_68_idx) % (2))) == 0 )
            {
               subGridsdtimportmedicos_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtimportmedicos_Class, "") != 0 )
               {
                  subGridsdtimportmedicos_Linesclass = subGridsdtimportmedicos_Class+"Even" ;
               }
            }
            else
            {
               subGridsdtimportmedicos_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtimportmedicos_Class, "") != 0 )
               {
                  subGridsdtimportmedicos_Linesclass = subGridsdtimportmedicos_Class+"Odd" ;
               }
            }
         }
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_68_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtimportmedicosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtimportmedicos__profesionalapellidopaterno_Internalname,((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalapellidopaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtimportmedicos__profesionalapellidopaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtimportmedicos__profesionalapellidopaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(68),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtimportmedicosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtimportmedicos__profesionalapellidomaterno_Internalname,((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalapellidomaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtimportmedicos__profesionalapellidomaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtimportmedicos__profesionalapellidomaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(68),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtimportmedicosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtimportmedicos__profesionalnombres_Internalname,((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalnombres(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtimportmedicos__profesionalnombres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtimportmedicos__profesionalnombres_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(68),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbavSdtimportmedicos__profesionaltipodocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SDTIMPORTMEDICOS__PROFESIONALTIPODOCUMENTO_" + sGXsfl_68_idx ;
            cmbavSdtimportmedicos__profesionaltipodocumento.setName( GXCCtl );
            cmbavSdtimportmedicos__profesionaltipodocumento.setWebtags( "" );
            cmbavSdtimportmedicos__profesionaltipodocumento.addItem("1", "DNI", (short)(0));
            cmbavSdtimportmedicos__profesionaltipodocumento.addItem("6", "RUC", (short)(0));
            cmbavSdtimportmedicos__profesionaltipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
            cmbavSdtimportmedicos__profesionaltipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
            cmbavSdtimportmedicos__profesionaltipodocumento.addItem("7", "PASAPORTE", (short)(0));
            cmbavSdtimportmedicos__profesionaltipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
            if ( cmbavSdtimportmedicos__profesionaltipodocumento.getItemCount() > 0 )
            {
               if ( ( AV34GXV1 > 0 ) && ( AV22SDTImportMedicos.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionaltipodocumento())==0) )
               {
                  ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTImportMedico_Profesionaltipodocumento( cmbavSdtimportmedicos__profesionaltipodocumento.getValidValue(((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionaltipodocumento()) );
               }
            }
         }
         /* ComboBox */
         GridsdtimportmedicosRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtimportmedicos__profesionaltipodocumento,cmbavSdtimportmedicos__profesionaltipodocumento.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionaltipodocumento()),Integer.valueOf(1),cmbavSdtimportmedicos__profesionaltipodocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavSdtimportmedicos__profesionaltipodocumento.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbavSdtimportmedicos__profesionaltipodocumento.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionaltipodocumento()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtimportmedicos__profesionaltipodocumento.getInternalname(), "Values", cmbavSdtimportmedicos__profesionaltipodocumento.ToJavascriptSource(), !bGXsfl_68_Refreshing);
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtimportmedicosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtimportmedicos__profesionalnrodocumento_Internalname,((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalnrodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtimportmedicos__profesionalnrodocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtimportmedicos__profesionalnrodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(68),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtimportmedicosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtimportmedicos__profesionalfechanacimiento_Internalname,localUtil.format(((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalfechanacimiento(), "99/99/9999"),localUtil.format( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalfechanacimiento(), "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtimportmedicos__profesionalfechanacimiento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtimportmedicos__profesionalfechanacimiento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(68),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbavSdtimportmedicos__profesionalsexo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SDTIMPORTMEDICOS__PROFESIONALSEXO_" + sGXsfl_68_idx ;
            cmbavSdtimportmedicos__profesionalsexo.setName( GXCCtl );
            cmbavSdtimportmedicos__profesionalsexo.setWebtags( "" );
            cmbavSdtimportmedicos__profesionalsexo.addItem("M", "Masculino", (short)(0));
            cmbavSdtimportmedicos__profesionalsexo.addItem("F", "Femenino", (short)(0));
            if ( cmbavSdtimportmedicos__profesionalsexo.getItemCount() > 0 )
            {
               if ( ( AV34GXV1 > 0 ) && ( AV22SDTImportMedicos.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalsexo())==0) )
               {
                  ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTImportMedico_Profesionalsexo( cmbavSdtimportmedicos__profesionalsexo.getValidValue(((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalsexo()) );
               }
            }
         }
         /* ComboBox */
         GridsdtimportmedicosRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtimportmedicos__profesionalsexo,cmbavSdtimportmedicos__profesionalsexo.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalsexo()),Integer.valueOf(1),cmbavSdtimportmedicos__profesionalsexo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavSdtimportmedicos__profesionalsexo.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbavSdtimportmedicos__profesionalsexo.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalsexo()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtimportmedicos__profesionalsexo.getInternalname(), "Values", cmbavSdtimportmedicos__profesionalsexo.ToJavascriptSource(), !bGXsfl_68_Refreshing);
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtimportmedicosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtimportmedicos__profesionalcop_Internalname,((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalcop(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtimportmedicos__profesionalcop_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtimportmedicos__profesionalcop_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(68),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtimportmedicosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtimportmedicos__profesionaltelefono_Internalname,GXutil.rtrim( ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionaltelefono()),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtimportmedicos__profesionaltelefono_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtimportmedicos__profesionaltelefono_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(68),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtimportmedicosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtimportmedicos__profesionalcorreo_Internalname,((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalcorreo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtimportmedicos__profesionalcorreo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtimportmedicos__profesionalcorreo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(68),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtimportmedicosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtimportmedicosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtimportmedicos__profesionaldireccion_Internalname,((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionaldireccion(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtimportmedicos__profesionaldireccion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtimportmedicos__profesionaldireccion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(68),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes302( ) ;
         GridsdtimportmedicosContainer.AddRow(GridsdtimportmedicosRow);
         nGXsfl_68_idx = ((subGridsdtimportmedicos_Islastpage==1)&&(nGXsfl_68_idx+1>subgridsdtimportmedicos_fnc_recordsperpage( )) ? 1 : nGXsfl_68_idx+1) ;
         sGXsfl_68_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_68_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_682( ) ;
      }
      /* End function sendrow_682 */
   }

   public void init_default_properties( )
   {
      Importdata_Internalname = "IMPORTDATA" ;
      bttBtnprocesardata_Internalname = "BTNPROCESARDATA" ;
      bttBtnbtnguardardatamedico_Internalname = "BTNBTNGUARDARDATAMEDICO" ;
      bttBtnbtndescargarreportimport_Internalname = "BTNBTNDESCARGARREPORTIMPORT" ;
      divSeccionbuton_Internalname = "SECCIONBUTON" ;
      lblTextblockprocessdatasuccess_Internalname = "TEXTBLOCKPROCESSDATASUCCESS" ;
      edtavProcessdatasuccess_Internalname = "vPROCESSDATASUCCESS" ;
      divUnnamedtableprocessdatasuccess_Internalname = "UNNAMEDTABLEPROCESSDATASUCCESS" ;
      lblTextblockprocessdataerror_Internalname = "TEXTBLOCKPROCESSDATAERROR" ;
      edtavProcessdataerror_Internalname = "vPROCESSDATAERROR" ;
      divUnnamedtableprocessdataerror_Internalname = "UNNAMEDTABLEPROCESSDATAERROR" ;
      lblTextblockimportdatasuccess_Internalname = "TEXTBLOCKIMPORTDATASUCCESS" ;
      edtavImportdatasuccess_Internalname = "vIMPORTDATASUCCESS" ;
      divUnnamedtableimportdatasuccess_Internalname = "UNNAMEDTABLEIMPORTDATASUCCESS" ;
      lblTextblockimportdataerror_Internalname = "TEXTBLOCKIMPORTDATAERROR" ;
      edtavImportdataerror_Internalname = "vIMPORTDATAERROR" ;
      divUnnamedtableimportdataerror_Internalname = "UNNAMEDTABLEIMPORTDATAERROR" ;
      divDetalleimport_Internalname = "DETALLEIMPORT" ;
      grpUnnamedgroup1_Internalname = "UNNAMEDGROUP1" ;
      divPanelimport_Internalname = "PANELIMPORT" ;
      Dvpanel_panelimport_Internalname = "DVPANEL_PANELIMPORT" ;
      edtavSdtimportmedicos__profesionalapellidopaterno_Internalname = "SDTIMPORTMEDICOS__PROFESIONALAPELLIDOPATERNO" ;
      edtavSdtimportmedicos__profesionalapellidomaterno_Internalname = "SDTIMPORTMEDICOS__PROFESIONALAPELLIDOMATERNO" ;
      edtavSdtimportmedicos__profesionalnombres_Internalname = "SDTIMPORTMEDICOS__PROFESIONALNOMBRES" ;
      cmbavSdtimportmedicos__profesionaltipodocumento.setInternalname( "SDTIMPORTMEDICOS__PROFESIONALTIPODOCUMENTO" );
      edtavSdtimportmedicos__profesionalnrodocumento_Internalname = "SDTIMPORTMEDICOS__PROFESIONALNRODOCUMENTO" ;
      edtavSdtimportmedicos__profesionalfechanacimiento_Internalname = "SDTIMPORTMEDICOS__PROFESIONALFECHANACIMIENTO" ;
      cmbavSdtimportmedicos__profesionalsexo.setInternalname( "SDTIMPORTMEDICOS__PROFESIONALSEXO" );
      edtavSdtimportmedicos__profesionalcop_Internalname = "SDTIMPORTMEDICOS__PROFESIONALCOP" ;
      edtavSdtimportmedicos__profesionaltelefono_Internalname = "SDTIMPORTMEDICOS__PROFESIONALTELEFONO" ;
      edtavSdtimportmedicos__profesionalcorreo_Internalname = "SDTIMPORTMEDICOS__PROFESIONALCORREO" ;
      edtavSdtimportmedicos__profesionaldireccion_Internalname = "SDTIMPORTMEDICOS__PROFESIONALDIRECCION" ;
      Gridsdtimportmedicospaginationbar_Internalname = "GRIDSDTIMPORTMEDICOSPAGINATIONBAR" ;
      divGridsdtimportmedicostablewithpaginationbar_Internalname = "GRIDSDTIMPORTMEDICOSTABLEWITHPAGINATIONBAR" ;
      divTablelistmedicos_Internalname = "TABLELISTMEDICOS" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Gridsdtimportmedicos_empowerer_Internalname = "GRIDSDTIMPORTMEDICOS_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridsdtimportmedicos_Internalname = "GRIDSDTIMPORTMEDICOS" ;
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
      edtavSdtimportmedicos__profesionaldireccion_Jsonclick = "" ;
      edtavSdtimportmedicos__profesionalcorreo_Jsonclick = "" ;
      edtavSdtimportmedicos__profesionaltelefono_Jsonclick = "" ;
      edtavSdtimportmedicos__profesionalcop_Jsonclick = "" ;
      cmbavSdtimportmedicos__profesionalsexo.setJsonclick( "" );
      edtavSdtimportmedicos__profesionalfechanacimiento_Jsonclick = "" ;
      edtavSdtimportmedicos__profesionalnrodocumento_Jsonclick = "" ;
      cmbavSdtimportmedicos__profesionaltipodocumento.setJsonclick( "" );
      edtavSdtimportmedicos__profesionalnombres_Jsonclick = "" ;
      edtavSdtimportmedicos__profesionalapellidomaterno_Jsonclick = "" ;
      edtavSdtimportmedicos__profesionalapellidopaterno_Jsonclick = "" ;
      edtavSdtimportmedicos__profesionaldireccion_Enabled = -1 ;
      edtavSdtimportmedicos__profesionalcorreo_Enabled = -1 ;
      edtavSdtimportmedicos__profesionaltelefono_Enabled = -1 ;
      edtavSdtimportmedicos__profesionalcop_Enabled = -1 ;
      cmbavSdtimportmedicos__profesionalsexo.setEnabled( -1 );
      edtavSdtimportmedicos__profesionalfechanacimiento_Enabled = -1 ;
      edtavSdtimportmedicos__profesionalnrodocumento_Enabled = -1 ;
      cmbavSdtimportmedicos__profesionaltipodocumento.setEnabled( -1 );
      edtavSdtimportmedicos__profesionalnombres_Enabled = -1 ;
      edtavSdtimportmedicos__profesionalapellidomaterno_Enabled = -1 ;
      edtavSdtimportmedicos__profesionalapellidopaterno_Enabled = -1 ;
      subGridsdtimportmedicos_Allowcollapsing = (byte)(0) ;
      subGridsdtimportmedicos_Allowselection = (byte)(0) ;
      edtavSdtimportmedicos__profesionaldireccion_Enabled = 0 ;
      edtavSdtimportmedicos__profesionalcorreo_Enabled = 0 ;
      edtavSdtimportmedicos__profesionaltelefono_Enabled = 0 ;
      edtavSdtimportmedicos__profesionalcop_Enabled = 0 ;
      cmbavSdtimportmedicos__profesionalsexo.setEnabled( 0 );
      edtavSdtimportmedicos__profesionalfechanacimiento_Enabled = 0 ;
      edtavSdtimportmedicos__profesionalnrodocumento_Enabled = 0 ;
      cmbavSdtimportmedicos__profesionaltipodocumento.setEnabled( 0 );
      edtavSdtimportmedicos__profesionalnombres_Enabled = 0 ;
      edtavSdtimportmedicos__profesionalapellidomaterno_Enabled = 0 ;
      edtavSdtimportmedicos__profesionalapellidopaterno_Enabled = 0 ;
      subGridsdtimportmedicos_Header = "" ;
      subGridsdtimportmedicos_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtimportmedicos_Backcolorstyle = (byte)(0) ;
      edtavImportdataerror_Jsonclick = "" ;
      edtavImportdataerror_Enabled = 1 ;
      edtavImportdatasuccess_Jsonclick = "" ;
      edtavImportdatasuccess_Enabled = 1 ;
      edtavProcessdataerror_Jsonclick = "" ;
      edtavProcessdataerror_Enabled = 1 ;
      edtavProcessdatasuccess_Jsonclick = "" ;
      edtavProcessdatasuccess_Enabled = 1 ;
      Importdata_Tooltiptext = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Importar Medico" );
      Gridsdtimportmedicospaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridsdtimportmedicospaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridsdtimportmedicospaginationbar_Caption = "Página <CURRENT_PAGE> de <TOTAL_PAGES>" ;
      Gridsdtimportmedicospaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridsdtimportmedicospaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridsdtimportmedicospaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridsdtimportmedicospaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridsdtimportmedicospaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridsdtimportmedicospaginationbar_Pagingcaptionposition = "Left" ;
      Gridsdtimportmedicospaginationbar_Pagingbuttonsposition = "Right" ;
      Gridsdtimportmedicospaginationbar_Pagestoshow = 5 ;
      Gridsdtimportmedicospaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridsdtimportmedicospaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridsdtimportmedicospaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridsdtimportmedicospaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridsdtimportmedicospaginationbar_Class = "PaginationBar" ;
      Dvpanel_panelimport_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelimport_Iconposition = "Right" ;
      Dvpanel_panelimport_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelimport_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelimport_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelimport_Title = "" ;
      Dvpanel_panelimport_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelimport_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelimport_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelimport_Width = "100%" ;
      Importdata_Maxnumberoffiles = 1 ;
      Importdata_Enableuploadedfilecanceling = GXutil.toBoolean( -1) ;
      Importdata_Autoupload = GXutil.toBoolean( -1) ;
      subGridsdtimportmedicos_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "SDTIMPORTMEDICOS__PROFESIONALTIPODOCUMENTO_" + sGXsfl_68_idx ;
      cmbavSdtimportmedicos__profesionaltipodocumento.setName( GXCCtl );
      cmbavSdtimportmedicos__profesionaltipodocumento.setWebtags( "" );
      cmbavSdtimportmedicos__profesionaltipodocumento.addItem("1", "DNI", (short)(0));
      cmbavSdtimportmedicos__profesionaltipodocumento.addItem("6", "RUC", (short)(0));
      cmbavSdtimportmedicos__profesionaltipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavSdtimportmedicos__profesionaltipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavSdtimportmedicos__profesionaltipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavSdtimportmedicos__profesionaltipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavSdtimportmedicos__profesionaltipodocumento.getItemCount() > 0 )
      {
         if ( ( AV34GXV1 > 0 ) && ( AV22SDTImportMedicos.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionaltipodocumento())==0) )
         {
            ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTImportMedico_Profesionaltipodocumento( cmbavSdtimportmedicos__profesionaltipodocumento.getValidValue(((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionaltipodocumento()) );
         }
      }
      GXCCtl = "SDTIMPORTMEDICOS__PROFESIONALSEXO_" + sGXsfl_68_idx ;
      cmbavSdtimportmedicos__profesionalsexo.setName( GXCCtl );
      cmbavSdtimportmedicos__profesionalsexo.setWebtags( "" );
      cmbavSdtimportmedicos__profesionalsexo.addItem("M", "Masculino", (short)(0));
      cmbavSdtimportmedicos__profesionalsexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavSdtimportmedicos__profesionalsexo.getItemCount() > 0 )
      {
         if ( ( AV34GXV1 > 0 ) && ( AV22SDTImportMedicos.size() >= AV34GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalsexo())==0) )
         {
            ((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).setgxTv_SdtSDTImportMedico_Profesionalsexo( cmbavSdtimportmedicos__profesionalsexo.getValidValue(((com.projectthani.SdtSDTImportMedico)AV22SDTImportMedicos.elementAt(-1+AV34GXV1)).getgxTv_SdtSDTImportMedico_Profesionalsexo()) );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage'},{av:'GRIDSDTIMPORTMEDICOS_nEOF'},{av:'AV22SDTImportMedicos',fld:'vSDTIMPORTMEDICOS',grid:68,pic:''},{av:'nRC_GXsfl_68',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'GridRC',grid:68},{av:'subGridsdtimportmedicos_Rows',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'Rows'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV10GridSDTImportMedicosCurrentPage',fld:'vGRIDSDTIMPORTMEDICOSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV11GridSDTImportMedicosPageCount',fld:'vGRIDSDTIMPORTMEDICOSPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRIDSDTIMPORTMEDICOS.LOAD","{handler:'e18302',iparms:[]");
      setEventMetadata("GRIDSDTIMPORTMEDICOS.LOAD",",oparms:[]}");
      setEventMetadata("GRIDSDTIMPORTMEDICOSPAGINATIONBAR.CHANGEPAGE","{handler:'e11302',iparms:[{av:'GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage'},{av:'GRIDSDTIMPORTMEDICOS_nEOF'},{av:'AV22SDTImportMedicos',fld:'vSDTIMPORTMEDICOS',grid:68,pic:''},{av:'nRC_GXsfl_68',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'GridRC',grid:68},{av:'subGridsdtimportmedicos_Rows',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'Rows'},{av:'Gridsdtimportmedicospaginationbar_Selectedpage',ctrl:'GRIDSDTIMPORTMEDICOSPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDSDTIMPORTMEDICOSPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTIMPORTMEDICOSPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12302',iparms:[{av:'GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage'},{av:'GRIDSDTIMPORTMEDICOS_nEOF'},{av:'AV22SDTImportMedicos',fld:'vSDTIMPORTMEDICOS',grid:68,pic:''},{av:'nRC_GXsfl_68',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'GridRC',grid:68},{av:'subGridsdtimportmedicos_Rows',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'Rows'},{av:'Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTIMPORTMEDICOSPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDSDTIMPORTMEDICOSPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtimportmedicos_Rows',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'Rows'}]}");
      setEventMetadata("'DOPROCESARDATA'","{handler:'e13302',iparms:[{av:'AV31UploadedFiles',fld:'vUPLOADEDFILES',pic:''},{av:'AV22SDTImportMedicos',fld:'vSDTIMPORTMEDICOS',grid:68,pic:''},{av:'GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_68',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'GridRC',grid:68},{av:'GRIDSDTIMPORTMEDICOS_nEOF'},{av:'subGridsdtimportmedicos_Rows',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'Rows'}]");
      setEventMetadata("'DOPROCESARDATA'",",oparms:[{av:'AV20ProcessDataSuccess',fld:'vPROCESSDATASUCCESS',pic:'ZZZ9'},{av:'AV22SDTImportMedicos',fld:'vSDTIMPORTMEDICOS',grid:68,pic:''},{av:'GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_68',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'GridRC',grid:68}]}");
      setEventMetadata("'DOBTNGUARDARDATAMEDICO'","{handler:'e14302',iparms:[{av:'AV22SDTImportMedicos',fld:'vSDTIMPORTMEDICOS',grid:68,pic:''},{av:'GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_68',ctrl:'GRIDSDTIMPORTMEDICOS',prop:'GridRC',grid:68}]");
      setEventMetadata("'DOBTNGUARDARDATAMEDICO'",",oparms:[{av:'AV13ImportDataError',fld:'vIMPORTDATAERROR',pic:'ZZZ9'},{av:'AV14ImportDataSuccess',fld:'vIMPORTDATASUCCESS',pic:'ZZZ9'},{av:'AV21SDTImportMedicoErrorList',fld:'vSDTIMPORTMEDICOERRORLIST',pic:''}]}");
      setEventMetadata("'DOBTNDESCARGARREPORTIMPORT'","{handler:'e15302',iparms:[{av:'AV21SDTImportMedicoErrorList',fld:'vSDTIMPORTMEDICOERRORLIST',pic:''}]");
      setEventMetadata("'DOBTNDESCARGARREPORTIMPORT'",",oparms:[]}");
      setEventMetadata("VALIDV_GXV5","{handler:'validv_Gxv5',iparms:[]");
      setEventMetadata("VALIDV_GXV5",",oparms:[]}");
      setEventMetadata("VALIDV_GXV8","{handler:'validv_Gxv8',iparms:[]");
      setEventMetadata("VALIDV_GXV8",",oparms:[]}");
      setEventMetadata("VALIDV_GXV11","{handler:'validv_Gxv11',iparms:[]");
      setEventMetadata("VALIDV_GXV11",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv12',iparms:[]");
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
      Gridsdtimportmedicospaginationbar_Selectedpage = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gridsdtimportmedicos_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV22SDTImportMedicos = new GXBaseCollection<com.projectthani.SdtSDTImportMedico>(com.projectthani.SdtSDTImportMedico.class, "SDTImportMedico", "ProjectThani", remoteHandle);
      AV31UploadedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV7FailedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV21SDTImportMedicoErrorList = new GXBaseCollection<com.projectthani.SdtSDTImportMedicoError>(com.projectthani.SdtSDTImportMedicoError.class, "SDTImportMedicoError", "ProjectThani", remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_panelimport = new com.genexus.webpanels.GXUserControl();
      ucImportdata = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      bttBtnprocesardata_Jsonclick = "" ;
      bttBtnbtnguardardatamedico_Jsonclick = "" ;
      bttBtnbtndescargarreportimport_Jsonclick = "" ;
      lblTextblockprocessdatasuccess_Jsonclick = "" ;
      lblTextblockprocessdataerror_Jsonclick = "" ;
      lblTextblockimportdatasuccess_Jsonclick = "" ;
      lblTextblockimportdataerror_Jsonclick = "" ;
      GridsdtimportmedicosContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGridsdtimportmedicos_Linesclass = "" ;
      GridsdtimportmedicosColumn = new com.genexus.webpanels.GXWebColumn();
      ucGridsdtimportmedicospaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGridsdtimportmedicos_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GridsdtimportmedicosRow = new com.genexus.webpanels.GXWebRow();
      AV5File = new com.genexus.util.GXFile();
      GXv_objcol_SdtSDTImportMedico1 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTImportMedicoError3 = new GXBaseCollection[1] ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new short[1] ;
      AV8FileName = "" ;
      GXv_char5 = new String[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavProcessdatasuccess_Enabled = 0 ;
      edtavProcessdataerror_Enabled = 0 ;
      edtavImportdatasuccess_Enabled = 0 ;
      edtavImportdataerror_Enabled = 0 ;
      edtavSdtimportmedicos__profesionalapellidopaterno_Enabled = 0 ;
      edtavSdtimportmedicos__profesionalapellidomaterno_Enabled = 0 ;
      edtavSdtimportmedicos__profesionalnombres_Enabled = 0 ;
      cmbavSdtimportmedicos__profesionaltipodocumento.setEnabled( 0 );
      edtavSdtimportmedicos__profesionalnrodocumento_Enabled = 0 ;
      edtavSdtimportmedicos__profesionalfechanacimiento_Enabled = 0 ;
      cmbavSdtimportmedicos__profesionalsexo.setEnabled( 0 );
      edtavSdtimportmedicos__profesionalcop_Enabled = 0 ;
      edtavSdtimportmedicos__profesionaltelefono_Enabled = 0 ;
      edtavSdtimportmedicos__profesionalcorreo_Enabled = 0 ;
      edtavSdtimportmedicos__profesionaldireccion_Enabled = 0 ;
   }

   private byte GRIDSDTIMPORTMEDICOS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subGridsdtimportmedicos_Backcolorstyle ;
   private byte subGridsdtimportmedicos_Titlebackstyle ;
   private byte subGridsdtimportmedicos_Allowselection ;
   private byte subGridsdtimportmedicos_Allowhovering ;
   private byte subGridsdtimportmedicos_Allowcollapsing ;
   private byte subGridsdtimportmedicos_Collapsed ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGridsdtimportmedicos_Backstyle ;
   private short wbEnd ;
   private short wbStart ;
   private short AV20ProcessDataSuccess ;
   private short AV19ProcessDataError ;
   private short AV14ImportDataSuccess ;
   private short AV13ImportDataError ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int2[] ;
   private short GXv_int4[] ;
   private int Gridsdtimportmedicospaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_68 ;
   private int nGXsfl_68_idx=1 ;
   private int subGridsdtimportmedicos_Rows ;
   private int Importdata_Maxnumberoffiles ;
   private int Gridsdtimportmedicospaginationbar_Pagestoshow ;
   private int edtavProcessdatasuccess_Enabled ;
   private int edtavProcessdataerror_Enabled ;
   private int edtavImportdatasuccess_Enabled ;
   private int edtavImportdataerror_Enabled ;
   private int subGridsdtimportmedicos_Titlebackcolor ;
   private int subGridsdtimportmedicos_Allbackcolor ;
   private int edtavSdtimportmedicos__profesionalapellidopaterno_Enabled ;
   private int edtavSdtimportmedicos__profesionalapellidomaterno_Enabled ;
   private int edtavSdtimportmedicos__profesionalnombres_Enabled ;
   private int edtavSdtimportmedicos__profesionalnrodocumento_Enabled ;
   private int edtavSdtimportmedicos__profesionalfechanacimiento_Enabled ;
   private int edtavSdtimportmedicos__profesionalcop_Enabled ;
   private int edtavSdtimportmedicos__profesionaltelefono_Enabled ;
   private int edtavSdtimportmedicos__profesionalcorreo_Enabled ;
   private int edtavSdtimportmedicos__profesionaldireccion_Enabled ;
   private int subGridsdtimportmedicos_Selectedindex ;
   private int subGridsdtimportmedicos_Selectioncolor ;
   private int subGridsdtimportmedicos_Hoveringcolor ;
   private int AV34GXV1 ;
   private int subGridsdtimportmedicos_Islastpage ;
   private int GRIDSDTIMPORTMEDICOS_nGridOutOfScope ;
   private int nGXsfl_68_fel_idx=1 ;
   private int AV18PageToGo ;
   private int nGXsfl_68_bak_idx=1 ;
   private int idxLst ;
   private int subGridsdtimportmedicos_Backcolor ;
   private long GRIDSDTIMPORTMEDICOS_nFirstRecordOnPage ;
   private long AV10GridSDTImportMedicosCurrentPage ;
   private long AV11GridSDTImportMedicosPageCount ;
   private long GRIDSDTIMPORTMEDICOS_nCurrentRecord ;
   private long GRIDSDTIMPORTMEDICOS_nRecordCount ;
   private String Gridsdtimportmedicospaginationbar_Selectedpage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_68_idx="0001" ;
   private String Dvpanel_panelimport_Width ;
   private String Dvpanel_panelimport_Cls ;
   private String Dvpanel_panelimport_Title ;
   private String Dvpanel_panelimport_Iconposition ;
   private String Gridsdtimportmedicospaginationbar_Class ;
   private String Gridsdtimportmedicospaginationbar_Pagingbuttonsposition ;
   private String Gridsdtimportmedicospaginationbar_Pagingcaptionposition ;
   private String Gridsdtimportmedicospaginationbar_Emptygridclass ;
   private String Gridsdtimportmedicospaginationbar_Rowsperpageoptions ;
   private String Gridsdtimportmedicospaginationbar_Previous ;
   private String Gridsdtimportmedicospaginationbar_Next ;
   private String Gridsdtimportmedicospaginationbar_Caption ;
   private String Gridsdtimportmedicospaginationbar_Emptygridcaption ;
   private String Gridsdtimportmedicospaginationbar_Rowsperpagecaption ;
   private String Gridsdtimportmedicos_empowerer_Gridinternalname ;
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
   private String Dvpanel_panelimport_Internalname ;
   private String divPanelimport_Internalname ;
   private String Importdata_Tooltiptext ;
   private String Importdata_Internalname ;
   private String divSeccionbuton_Internalname ;
   private String TempTags ;
   private String bttBtnprocesardata_Internalname ;
   private String bttBtnprocesardata_Jsonclick ;
   private String bttBtnbtnguardardatamedico_Internalname ;
   private String bttBtnbtnguardardatamedico_Jsonclick ;
   private String bttBtnbtndescargarreportimport_Internalname ;
   private String bttBtnbtndescargarreportimport_Jsonclick ;
   private String grpUnnamedgroup1_Internalname ;
   private String divDetalleimport_Internalname ;
   private String divUnnamedtableprocessdatasuccess_Internalname ;
   private String lblTextblockprocessdatasuccess_Internalname ;
   private String lblTextblockprocessdatasuccess_Jsonclick ;
   private String edtavProcessdatasuccess_Internalname ;
   private String edtavProcessdatasuccess_Jsonclick ;
   private String divUnnamedtableprocessdataerror_Internalname ;
   private String lblTextblockprocessdataerror_Internalname ;
   private String lblTextblockprocessdataerror_Jsonclick ;
   private String edtavProcessdataerror_Internalname ;
   private String edtavProcessdataerror_Jsonclick ;
   private String divUnnamedtableimportdatasuccess_Internalname ;
   private String lblTextblockimportdatasuccess_Internalname ;
   private String lblTextblockimportdatasuccess_Jsonclick ;
   private String edtavImportdatasuccess_Internalname ;
   private String edtavImportdatasuccess_Jsonclick ;
   private String divUnnamedtableimportdataerror_Internalname ;
   private String lblTextblockimportdataerror_Internalname ;
   private String lblTextblockimportdataerror_Jsonclick ;
   private String edtavImportdataerror_Internalname ;
   private String edtavImportdataerror_Jsonclick ;
   private String divTablelistmedicos_Internalname ;
   private String divGridsdtimportmedicostablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGridsdtimportmedicos_Internalname ;
   private String subGridsdtimportmedicos_Class ;
   private String subGridsdtimportmedicos_Linesclass ;
   private String subGridsdtimportmedicos_Header ;
   private String Gridsdtimportmedicospaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Gridsdtimportmedicos_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavSdtimportmedicos__profesionalapellidopaterno_Internalname ;
   private String edtavSdtimportmedicos__profesionalapellidomaterno_Internalname ;
   private String edtavSdtimportmedicos__profesionalnombres_Internalname ;
   private String edtavSdtimportmedicos__profesionalnrodocumento_Internalname ;
   private String edtavSdtimportmedicos__profesionalfechanacimiento_Internalname ;
   private String edtavSdtimportmedicos__profesionalcop_Internalname ;
   private String edtavSdtimportmedicos__profesionaltelefono_Internalname ;
   private String edtavSdtimportmedicos__profesionalcorreo_Internalname ;
   private String edtavSdtimportmedicos__profesionaldireccion_Internalname ;
   private String sGXsfl_68_fel_idx="0001" ;
   private String GXv_char5[] ;
   private String ROClassString ;
   private String edtavSdtimportmedicos__profesionalapellidopaterno_Jsonclick ;
   private String edtavSdtimportmedicos__profesionalapellidomaterno_Jsonclick ;
   private String edtavSdtimportmedicos__profesionalnombres_Jsonclick ;
   private String GXCCtl ;
   private String edtavSdtimportmedicos__profesionalnrodocumento_Jsonclick ;
   private String edtavSdtimportmedicos__profesionalfechanacimiento_Jsonclick ;
   private String edtavSdtimportmedicos__profesionalcop_Jsonclick ;
   private String edtavSdtimportmedicos__profesionaltelefono_Jsonclick ;
   private String edtavSdtimportmedicos__profesionalcorreo_Jsonclick ;
   private String edtavSdtimportmedicos__profesionaldireccion_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Importdata_Autoupload ;
   private boolean Importdata_Enableuploadedfilecanceling ;
   private boolean Dvpanel_panelimport_Autowidth ;
   private boolean Dvpanel_panelimport_Autoheight ;
   private boolean Dvpanel_panelimport_Collapsible ;
   private boolean Dvpanel_panelimport_Collapsed ;
   private boolean Dvpanel_panelimport_Showcollapseicon ;
   private boolean Dvpanel_panelimport_Autoscroll ;
   private boolean Gridsdtimportmedicospaginationbar_Showfirst ;
   private boolean Gridsdtimportmedicospaginationbar_Showprevious ;
   private boolean Gridsdtimportmedicospaginationbar_Shownext ;
   private boolean Gridsdtimportmedicospaginationbar_Showlast ;
   private boolean Gridsdtimportmedicospaginationbar_Rowsperpageselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_68_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean gx_BV68 ;
   private String AV8FileName ;
   private com.genexus.webpanels.GXWebGrid GridsdtimportmedicosContainer ;
   private com.genexus.webpanels.GXWebRow GridsdtimportmedicosRow ;
   private com.genexus.webpanels.GXWebColumn GridsdtimportmedicosColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelimport ;
   private com.genexus.webpanels.GXUserControl ucImportdata ;
   private com.genexus.webpanels.GXUserControl ucGridsdtimportmedicospaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGridsdtimportmedicos_empowerer ;
   private com.genexus.util.GXFile AV5File ;
   private HTMLChoice cmbavSdtimportmedicos__profesionaltipodocumento ;
   private HTMLChoice cmbavSdtimportmedicos__profesionalsexo ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV31UploadedFiles ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV7FailedFiles ;
   private GXBaseCollection<com.projectthani.SdtSDTImportMedicoError> AV21SDTImportMedicoErrorList ;
   private GXBaseCollection<com.projectthani.SdtSDTImportMedicoError> GXv_objcol_SdtSDTImportMedicoError3[] ;
   private GXBaseCollection<com.projectthani.SdtSDTImportMedico> AV22SDTImportMedicos ;
   private GXBaseCollection<com.projectthani.SdtSDTImportMedico> GXv_objcol_SdtSDTImportMedico1[] ;
}

