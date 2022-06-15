package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpregistrarreceta_impl extends GXDataArea
{
   public wpregistrarreceta_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpregistrarreceta_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpregistrarreceta_impl.class ));
   }

   public wpregistrarreceta_impl( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavSdtcitadata_citatipodiagnostico = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtmedicamentogriditems") == 0 )
         {
            nRC_GXsfl_129 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_129"))) ;
            nGXsfl_129_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_129_idx"))) ;
            sGXsfl_129_idx = httpContext.GetPar( "sGXsfl_129_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridsdtmedicamentogriditems_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdtmedicamentogriditems") == 0 )
         {
            subGridsdtmedicamentogriditems_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtmedicamentogriditems_Rows"))) ;
            AV5CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtmedicamentogriditems_refresh( subGridsdtmedicamentogriditems_Rows, AV5CitaId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Width", GXutil.rtrim( Dvpanel_informacionpaciente_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Autowidth", GXutil.booltostr( Dvpanel_informacionpaciente_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Autoheight", GXutil.booltostr( Dvpanel_informacionpaciente_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Cls", GXutil.rtrim( Dvpanel_informacionpaciente_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Title", GXutil.rtrim( Dvpanel_informacionpaciente_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Collapsible", GXutil.booltostr( Dvpanel_informacionpaciente_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Collapsed", GXutil.booltostr( Dvpanel_informacionpaciente_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Showcollapseicon", GXutil.booltostr( Dvpanel_informacionpaciente_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Iconposition", GXutil.rtrim( Dvpanel_informacionpaciente_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Autoscroll", GXutil.booltostr( Dvpanel_informacionpaciente_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Cls", GXutil.rtrim( Combo_medicamentoid_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Selectedvalue_set", GXutil.rtrim( Combo_medicamentoid_Selectedvalue_set));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Emptyitemtext", GXutil.rtrim( Combo_medicamentoid_Emptyitemtext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Width", GXutil.rtrim( Innewwindow1_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Height", GXutil.rtrim( Innewwindow1_Height));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Target", GXutil.rtrim( Innewwindow1_Target));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Width", GXutil.rtrim( Dvpanel_tablefullwidth_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Autowidth", GXutil.booltostr( Dvpanel_tablefullwidth_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Autoheight", GXutil.booltostr( Dvpanel_tablefullwidth_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Cls", GXutil.rtrim( Dvpanel_tablefullwidth_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Title", GXutil.rtrim( Dvpanel_tablefullwidth_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Collapsible", GXutil.booltostr( Dvpanel_tablefullwidth_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Collapsed", GXutil.booltostr( Dvpanel_tablefullwidth_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Showcollapseicon", GXutil.booltostr( Dvpanel_tablefullwidth_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Iconposition", GXutil.rtrim( Dvpanel_tablefullwidth_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Autoscroll", GXutil.booltostr( Dvpanel_tablefullwidth_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ADJUNTARARCHIVO_Autoupload", GXutil.booltostr( Adjuntararchivo_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ADJUNTARARCHIVO_Hideadditionalbuttons", GXutil.booltostr( Adjuntararchivo_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ADJUNTARARCHIVO_Enableuploadedfilecanceling", GXutil.booltostr( Adjuntararchivo_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ADJUNTARARCHIVO_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Adjuntararchivo_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Width", GXutil.rtrim( Dvpanel_paneldetalle_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Autowidth", GXutil.booltostr( Dvpanel_paneldetalle_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Autoheight", GXutil.booltostr( Dvpanel_paneldetalle_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Cls", GXutil.rtrim( Dvpanel_paneldetalle_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Title", GXutil.rtrim( Dvpanel_paneldetalle_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Collapsible", GXutil.booltostr( Dvpanel_paneldetalle_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Collapsed", GXutil.booltostr( Dvpanel_paneldetalle_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Showcollapseicon", GXutil.booltostr( Dvpanel_paneldetalle_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Iconposition", GXutil.rtrim( Dvpanel_paneldetalle_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Autoscroll", GXutil.booltostr( Dvpanel_paneldetalle_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Width", GXutil.rtrim( Dvpanel_panelbuton_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Autowidth", GXutil.booltostr( Dvpanel_panelbuton_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Autoheight", GXutil.booltostr( Dvpanel_panelbuton_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Cls", GXutil.rtrim( Dvpanel_panelbuton_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Title", GXutil.rtrim( Dvpanel_panelbuton_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Collapsible", GXutil.booltostr( Dvpanel_panelbuton_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Collapsed", GXutil.booltostr( Dvpanel_panelbuton_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuton_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Iconposition", GXutil.rtrim( Dvpanel_panelbuton_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Autoscroll", GXutil.booltostr( Dvpanel_panelbuton_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Class", GXutil.rtrim( Gxuitabspanel_tabs_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtmedicamentogriditems_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_EMPOWERER_Infinitescrolling", GXutil.rtrim( Gridsdtmedicamentogriditems_empowerer_Infinitescrolling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Selectedvalue_get", GXutil.rtrim( Combo_medicamentoid_Selectedvalue_get));
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
            AV5CitaId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CitaId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CitaId), "ZZZZZZZ9")));
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
      pa6F2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start6F2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034537", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpregistrarreceta", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV5CitaId,8,0))}, new String[] {"CitaId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CitaId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtpacientedata", AV29SDTPacienteData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtpacientedata", AV29SDTPacienteData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtcitadata", AV26SDTCitadata);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtcitadata", AV26SDTCitadata);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtmedicamentogriditems", AV28SDTMedicamentoGridItems);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtmedicamentogriditems", AV28SDTMedicamentoGridItems);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_129", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_129, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV10DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV10DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMEDICAMENTOID_DATA", AV22MedicamentOId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMEDICAMENTOID_DATA", AV22MedicamentOId_Data);
      }
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFAILEDFILES", AV13FailedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFAILEDFILES", AV13FailedFiles);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV5CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CitaId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTMEDICAMENTOGRIDITEMS", AV28SDTMedicamentoGridItems);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTMEDICAMENTOGRIDITEMS", AV28SDTMedicamentoGridItems);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTMEDICAMENTOGRIDITEM", AV27SDTMedicamentoGridItem);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTMEDICAMENTOGRIDITEM", AV27SDTMedicamentoGridItem);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTMEDICAMENTOGRIDITEMS_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "MEDICAMENTONOMBRE", A40000MedicamentoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Width", GXutil.rtrim( Dvpanel_informacionpaciente_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Autowidth", GXutil.booltostr( Dvpanel_informacionpaciente_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Autoheight", GXutil.booltostr( Dvpanel_informacionpaciente_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Cls", GXutil.rtrim( Dvpanel_informacionpaciente_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Title", GXutil.rtrim( Dvpanel_informacionpaciente_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Collapsible", GXutil.booltostr( Dvpanel_informacionpaciente_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Collapsed", GXutil.booltostr( Dvpanel_informacionpaciente_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Showcollapseicon", GXutil.booltostr( Dvpanel_informacionpaciente_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Iconposition", GXutil.rtrim( Dvpanel_informacionpaciente_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_INFORMACIONPACIENTE_Autoscroll", GXutil.booltostr( Dvpanel_informacionpaciente_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Cls", GXutil.rtrim( Combo_medicamentoid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Selectedvalue_set", GXutil.rtrim( Combo_medicamentoid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Emptyitemtext", GXutil.rtrim( Combo_medicamentoid_Emptyitemtext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Width", GXutil.rtrim( Innewwindow1_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Height", GXutil.rtrim( Innewwindow1_Height));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Target", GXutil.rtrim( Innewwindow1_Target));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Width", GXutil.rtrim( Dvpanel_tablefullwidth_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Autowidth", GXutil.booltostr( Dvpanel_tablefullwidth_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Autoheight", GXutil.booltostr( Dvpanel_tablefullwidth_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Cls", GXutil.rtrim( Dvpanel_tablefullwidth_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Title", GXutil.rtrim( Dvpanel_tablefullwidth_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Collapsible", GXutil.booltostr( Dvpanel_tablefullwidth_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Collapsed", GXutil.booltostr( Dvpanel_tablefullwidth_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Showcollapseicon", GXutil.booltostr( Dvpanel_tablefullwidth_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Iconposition", GXutil.rtrim( Dvpanel_tablefullwidth_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEFULLWIDTH_Autoscroll", GXutil.booltostr( Dvpanel_tablefullwidth_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ADJUNTARARCHIVO_Autoupload", GXutil.booltostr( Adjuntararchivo_Autoupload));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ADJUNTARARCHIVO_Hideadditionalbuttons", GXutil.booltostr( Adjuntararchivo_Hideadditionalbuttons));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ADJUNTARARCHIVO_Enableuploadedfilecanceling", GXutil.booltostr( Adjuntararchivo_Enableuploadedfilecanceling));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ADJUNTARARCHIVO_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Adjuntararchivo_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Width", GXutil.rtrim( Dvpanel_paneldetalle_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Autowidth", GXutil.booltostr( Dvpanel_paneldetalle_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Autoheight", GXutil.booltostr( Dvpanel_paneldetalle_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Cls", GXutil.rtrim( Dvpanel_paneldetalle_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Title", GXutil.rtrim( Dvpanel_paneldetalle_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Collapsible", GXutil.booltostr( Dvpanel_paneldetalle_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Collapsed", GXutil.booltostr( Dvpanel_paneldetalle_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Showcollapseicon", GXutil.booltostr( Dvpanel_paneldetalle_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Iconposition", GXutil.rtrim( Dvpanel_paneldetalle_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELDETALLE_Autoscroll", GXutil.booltostr( Dvpanel_paneldetalle_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Width", GXutil.rtrim( Dvpanel_panelbuton_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Autowidth", GXutil.booltostr( Dvpanel_panelbuton_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Autoheight", GXutil.booltostr( Dvpanel_panelbuton_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Cls", GXutil.rtrim( Dvpanel_panelbuton_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Title", GXutil.rtrim( Dvpanel_panelbuton_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Collapsible", GXutil.booltostr( Dvpanel_panelbuton_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Collapsed", GXutil.booltostr( Dvpanel_panelbuton_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Showcollapseicon", GXutil.booltostr( Dvpanel_panelbuton_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Iconposition", GXutil.rtrim( Dvpanel_panelbuton_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELBUTON_Autoscroll", GXutil.booltostr( Dvpanel_panelbuton_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Class", GXutil.rtrim( Gxuitabspanel_tabs_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs_Historymanagement));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtmedicamentogriditems_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_EMPOWERER_Infinitescrolling", GXutil.rtrim( Gridsdtmedicamentogriditems_empowerer_Infinitescrolling));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Selectedvalue_get", GXutil.rtrim( Combo_medicamentoid_Selectedvalue_get));
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
         we6F2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt6F2( ) ;
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
      return formatLink("com.projectthani.wpregistrarreceta", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV5CitaId,8,0))}, new String[] {"CitaId"})  ;
   }

   public String getPgmname( )
   {
      return "WPRegistrarReceta" ;
   }

   public String getPgmdesc( )
   {
      return "Registrar Receta" ;
   }

   public void wb6F0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table TableTransactionTemplate", "left", "top", "", "", "div");
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
         ucGxuitabspanel_tabs.setProperty("PageCount", Gxuitabspanel_tabs_Pagecount);
         ucGxuitabspanel_tabs.setProperty("Class", Gxuitabspanel_tabs_Class);
         ucGxuitabspanel_tabs.setProperty("HistoryManagement", Gxuitabspanel_tabs_Historymanagement);
         ucGxuitabspanel_tabs.render(context, "tab", Gxuitabspanel_tabs_Internalname, "GXUITABSPANEL_TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabgeneral_title_Internalname, "RECETA MÉDICA", "", "", lblTabgeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "tabGeneral") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "TableData", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_informacionpaciente.setProperty("Width", Dvpanel_informacionpaciente_Width);
         ucDvpanel_informacionpaciente.setProperty("AutoWidth", Dvpanel_informacionpaciente_Autowidth);
         ucDvpanel_informacionpaciente.setProperty("AutoHeight", Dvpanel_informacionpaciente_Autoheight);
         ucDvpanel_informacionpaciente.setProperty("Cls", Dvpanel_informacionpaciente_Cls);
         ucDvpanel_informacionpaciente.setProperty("Title", Dvpanel_informacionpaciente_Title);
         ucDvpanel_informacionpaciente.setProperty("Collapsible", Dvpanel_informacionpaciente_Collapsible);
         ucDvpanel_informacionpaciente.setProperty("Collapsed", Dvpanel_informacionpaciente_Collapsed);
         ucDvpanel_informacionpaciente.setProperty("ShowCollapseIcon", Dvpanel_informacionpaciente_Showcollapseicon);
         ucDvpanel_informacionpaciente.setProperty("IconPosition", Dvpanel_informacionpaciente_Iconposition);
         ucDvpanel_informacionpaciente.setProperty("AutoScroll", Dvpanel_informacionpaciente_Autoscroll);
         ucDvpanel_informacionpaciente.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_informacionpaciente_Internalname, "DVPANEL_INFORMACIONPACIENTEContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_INFORMACIONPACIENTEContainer"+"InformacionPaciente"+"\" style=\"display:none;\">") ;
         wb_table1_22_6F2( true) ;
      }
      else
      {
         wb_table1_22_6F2( false) ;
      }
      return  ;
   }

   public void wb_table1_22_6F2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tablefullwidth.setProperty("Width", Dvpanel_tablefullwidth_Width);
         ucDvpanel_tablefullwidth.setProperty("AutoWidth", Dvpanel_tablefullwidth_Autowidth);
         ucDvpanel_tablefullwidth.setProperty("AutoHeight", Dvpanel_tablefullwidth_Autoheight);
         ucDvpanel_tablefullwidth.setProperty("Cls", Dvpanel_tablefullwidth_Cls);
         ucDvpanel_tablefullwidth.setProperty("Title", Dvpanel_tablefullwidth_Title);
         ucDvpanel_tablefullwidth.setProperty("Collapsible", Dvpanel_tablefullwidth_Collapsible);
         ucDvpanel_tablefullwidth.setProperty("Collapsed", Dvpanel_tablefullwidth_Collapsed);
         ucDvpanel_tablefullwidth.setProperty("ShowCollapseIcon", Dvpanel_tablefullwidth_Showcollapseicon);
         ucDvpanel_tablefullwidth.setProperty("IconPosition", Dvpanel_tablefullwidth_Iconposition);
         ucDvpanel_tablefullwidth.setProperty("AutoScroll", Dvpanel_tablefullwidth_Autoscroll);
         ucDvpanel_tablefullwidth.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablefullwidth_Internalname, "DVPANEL_TABLEFULLWIDTHContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEFULLWIDTHContainer"+"TableFullWidth"+"\" style=\"display:none;\">") ;
         wb_table2_94_6F2( true) ;
      }
      else
      {
         wb_table2_94_6F2( false) ;
      }
      return  ;
   }

   public void wb_table2_94_6F2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDigitalizacion_title_Internalname, "DIGITALIZACIÓN", "", "", lblDigitalizacion_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Digitalizacion") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_paneldetalle.setProperty("Width", Dvpanel_paneldetalle_Width);
         ucDvpanel_paneldetalle.setProperty("AutoWidth", Dvpanel_paneldetalle_Autowidth);
         ucDvpanel_paneldetalle.setProperty("AutoHeight", Dvpanel_paneldetalle_Autoheight);
         ucDvpanel_paneldetalle.setProperty("Cls", Dvpanel_paneldetalle_Cls);
         ucDvpanel_paneldetalle.setProperty("Title", Dvpanel_paneldetalle_Title);
         ucDvpanel_paneldetalle.setProperty("Collapsible", Dvpanel_paneldetalle_Collapsible);
         ucDvpanel_paneldetalle.setProperty("Collapsed", Dvpanel_paneldetalle_Collapsed);
         ucDvpanel_paneldetalle.setProperty("ShowCollapseIcon", Dvpanel_paneldetalle_Showcollapseicon);
         ucDvpanel_paneldetalle.setProperty("IconPosition", Dvpanel_paneldetalle_Iconposition);
         ucDvpanel_paneldetalle.setProperty("AutoScroll", Dvpanel_paneldetalle_Autoscroll);
         ucDvpanel_paneldetalle.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_paneldetalle_Internalname, "DVPANEL_PANELDETALLEContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELDETALLEContainer"+"PanelDetalle"+"\" style=\"display:none;\">") ;
         wb_table3_155_6F2( true) ;
      }
      else
      {
         wb_table3_155_6F2( false) ;
      }
      return  ;
   }

   public void wb_table3_155_6F2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelbuton.setProperty("Width", Dvpanel_panelbuton_Width);
         ucDvpanel_panelbuton.setProperty("AutoWidth", Dvpanel_panelbuton_Autowidth);
         ucDvpanel_panelbuton.setProperty("AutoHeight", Dvpanel_panelbuton_Autoheight);
         ucDvpanel_panelbuton.setProperty("Cls", Dvpanel_panelbuton_Cls);
         ucDvpanel_panelbuton.setProperty("Title", Dvpanel_panelbuton_Title);
         ucDvpanel_panelbuton.setProperty("Collapsible", Dvpanel_panelbuton_Collapsible);
         ucDvpanel_panelbuton.setProperty("Collapsed", Dvpanel_panelbuton_Collapsed);
         ucDvpanel_panelbuton.setProperty("ShowCollapseIcon", Dvpanel_panelbuton_Showcollapseicon);
         ucDvpanel_panelbuton.setProperty("IconPosition", Dvpanel_panelbuton_Iconposition);
         ucDvpanel_panelbuton.setProperty("AutoScroll", Dvpanel_panelbuton_Autoscroll);
         ucDvpanel_panelbuton.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelbuton_Internalname, "DVPANEL_PANELBUTONContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELBUTONContainer"+"Panelbuton"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divPanelbuton_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 mb10", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 185,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndescargararchivo_Internalname, "gx.evt.setGridEvt("+GXutil.str( 129, 3, 0)+","+"null"+");", "Descargar", bttBtndescargararchivo_Jsonclick, 5, "Descargar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DODESCARGARARCHIVO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 mb10", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 187,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnenviararchivopaciente_Internalname, "gx.evt.setGridEvt("+GXutil.str( 129, 3, 0)+","+"null"+");", "Enviar a Paciente", bttBtnenviararchivopaciente_Jsonclick, 5, "Enviar a Paciente", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOENVIARARCHIVOPACIENTE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 189,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnsalirdigitalizacion_Internalname, "gx.evt.setGridEvt("+GXutil.str( 129, 3, 0)+","+"null"+");", "Salir", bttBtnsalirdigitalizacion_Jsonclick, 5, "Salir", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOSALIRDIGITALIZACION\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
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
         ucMsgdvelop.render(context, "dvelop.dvmessage", Msgdvelop_Internalname, "MSGDVELOPContainer");
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
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 196,'',false,'" + sGXsfl_129_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavMedicamentoid_Internalname, GXutil.ltrim( localUtil.ntoc( AV21MedicamentOId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV21MedicamentOId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,196);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMedicamentoid_Jsonclick, 0, "Attribute", "", "", "", "", edtavMedicamentoid_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPRegistrarReceta.htm");
         /* User Defined Control */
         ucGridsdtmedicamentogriditems_empowerer.setProperty("InfiniteScrolling", Gridsdtmedicamentogriditems_empowerer_Infinitescrolling);
         ucGridsdtmedicamentogriditems_empowerer.render(context, "wwp.gridempowerer", Gridsdtmedicamentogriditems_empowerer_Internalname, "GRIDSDTMEDICAMENTOGRIDITEMS_EMPOWERERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 129 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsdtmedicamentogriditemsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridsdtmedicamentogriditemsContainer.AddObjectProperty("GRIDSDTMEDICAMENTOGRIDITEMS_nEOF", GRIDSDTMEDICAMENTOGRIDITEMS_nEOF);
               GridsdtmedicamentogriditemsContainer.AddObjectProperty("GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage", GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage);
               AV51GXV9 = nGXsfl_129_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridsdtmedicamentogriditemsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdtmedicamentogriditems", GridsdtmedicamentogriditemsContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtmedicamentogriditemsContainerData", GridsdtmedicamentogriditemsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtmedicamentogriditemsContainerData"+"V", GridsdtmedicamentogriditemsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtmedicamentogriditemsContainerData"+"V"+"\" value='"+GridsdtmedicamentogriditemsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start6F2( )
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
         Form.getMeta().addItem("description", "Registrar Receta", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6F0( ) ;
   }

   public void ws6F2( )
   {
      start6F2( ) ;
      evt6F2( ) ;
   }

   public void evt6F2( )
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
                        else if ( GXutil.strcmp(sEvt, "'DODESCARGARARCHIVO'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoDescargarArchivo' */
                           e116F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOENVIARARCHIVOPACIENTE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoEnviarArchivoPaciente' */
                           e126F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOSALIRDIGITALIZACION'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoSalirDigitalizacion' */
                           e136F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGUARDARDIGITALIZACION'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGuardarDigitalizacion' */
                           e146F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOELIMINARARCHIVO'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoEliminarArchivo' */
                           e156F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGUARDARRECETA'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGuardarReceta' */
                           e166F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOSALIR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoSalir' */
                           e176F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGUARDAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGuardar' */
                           e186F2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTMEDICAMENTOGRIDITEMSPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDSDTMEDICAMENTOGRIDITEMSPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridsdtmedicamentogriditems_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridsdtmedicamentogriditems_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridsdtmedicamentogriditems_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridsdtmedicamentogriditems_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 32), "GRIDSDTMEDICAMENTOGRIDITEMS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "VELIMINARRECETA.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "VELIMINARRECETA.CLICK") == 0 ) )
                        {
                           nGXsfl_129_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_129_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_129_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1292( ) ;
                           AV51GXV9 = nGXsfl_129_idx ;
                           if ( ( AV28SDTMedicamentoGridItems.size() >= AV51GXV9 ) && ( AV51GXV9 > 0 ) )
                           {
                              AV28SDTMedicamentoGridItems.currentItem( ((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV51GXV9)) );
                              AV12EliminarReceta = httpContext.cgiGet( edtavEliminarreceta_Internalname) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavEliminarreceta_Internalname, AV12EliminarReceta);
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
                                 e196F2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDSDTMEDICAMENTOGRIDITEMS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e206F2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VELIMINARRECETA.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e216F2 ();
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

   public void we6F2( )
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

   public void pa6F2( )
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
            GX_FocusControl = edtavSdtpacientedata_pacienteapellidopaterno_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridsdtmedicamentogriditems_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1292( ) ;
      while ( nGXsfl_129_idx <= nRC_GXsfl_129 )
      {
         sendrow_1292( ) ;
         nGXsfl_129_idx = ((subGridsdtmedicamentogriditems_Islastpage==1)&&(nGXsfl_129_idx+1>subgridsdtmedicamentogriditems_fnc_recordsperpage( )) ? 1 : nGXsfl_129_idx+1) ;
         sGXsfl_129_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_129_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1292( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtmedicamentogriditemsContainer)) ;
      /* End function gxnrGridsdtmedicamentogriditems_newrow */
   }

   public void gxgrgridsdtmedicamentogriditems_refresh( int subGridsdtmedicamentogriditems_Rows ,
                                                        int AV5CitaId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord = 0 ;
      rf6F2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdtmedicamentogriditems_refresh */
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
      if ( cmbavSdtcitadata_citatipodiagnostico.getItemCount() > 0 )
      {
         AV26SDTCitadata.setgxTv_SdtSDTCitaData_Citatipodiagnostico( cmbavSdtcitadata_citatipodiagnostico.getValidValue(AV26SDTCitadata.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSdtcitadata_citatipodiagnostico.setValue( GXutil.rtrim( AV26SDTCitadata.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Values", cmbavSdtcitadata_citatipodiagnostico.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = 0 ;
      GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord = 0 ;
      GXCCtl = "GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage_" + sGXsfl_129_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      send_integrity_hashes( ) ;
      rf6F2( ) ;
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
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidopaterno_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidomaterno_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientenombres_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled), 5, 0), true);
      edtavSdtcitadata_citapesodescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citapesodescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citapesodescripcion_Enabled), 5, 0), true);
      edtavSdtcitadata_citaestaturadescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citaestaturadescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citaestaturadescripcion_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled), 5, 0), true);
      cmbavSdtcitadata_citatipodiagnostico.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcitadata_citatipodiagnostico.getEnabled(), 5, 0), true);
      edtavEliminarreceta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarreceta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarreceta_Enabled), 5, 0), !bGXsfl_129_Refreshing);
      edtavSdtmedicamentogriditems__medicamentonombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtmedicamentogriditems__medicamentonombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtmedicamentogriditems__medicamentonombre_Enabled), 5, 0), !bGXsfl_129_Refreshing);
      edtavSdtmedicamentogriditems__medicamentocantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtmedicamentogriditems__medicamentocantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtmedicamentogriditems__medicamentocantidad_Enabled), 5, 0), !bGXsfl_129_Refreshing);
      edtavArchivoadjuntofullname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavArchivoadjuntofullname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavArchivoadjuntofullname_Enabled), 5, 0), true);
   }

   public void rf6F2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtmedicamentogriditemsContainer.ClearRows();
      }
      wbStart = (short)(129) ;
      nGXsfl_129_idx = (int)(1+GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage) ;
      sGXsfl_129_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_129_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1292( ) ;
      bGXsfl_129_Refreshing = true ;
      GridsdtmedicamentogriditemsContainer.AddObjectProperty("GridName", "Gridsdtmedicamentogriditems");
      GridsdtmedicamentogriditemsContainer.AddObjectProperty("CmpContext", "");
      GridsdtmedicamentogriditemsContainer.AddObjectProperty("InMasterPage", "false");
      GridsdtmedicamentogriditemsContainer.AddObjectProperty("Class", "GridNoBorder WorkWith");
      GridsdtmedicamentogriditemsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsdtmedicamentogriditemsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsdtmedicamentogriditemsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsdtmedicamentogriditemsContainer.setPageSize( subgridsdtmedicamentogriditems_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1292( ) ;
         e206F2 ();
         if ( ( GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord > 0 ) && ( GRIDSDTMEDICAMENTOGRIDITEMS_nGridOutOfScope == 0 ) && ( nGXsfl_129_idx == 1 ) )
         {
            GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord = 0 ;
            GRIDSDTMEDICAMENTOGRIDITEMS_nGridOutOfScope = 1 ;
            subgridsdtmedicamentogriditems_firstpage( ) ;
            e206F2 ();
         }
         wbEnd = (short)(129) ;
         wb6F0( ) ;
      }
      bGXsfl_129_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6F2( )
   {
   }

   public int subgridsdtmedicamentogriditems_fnc_pagecount( )
   {
      GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount = subgridsdtmedicamentogriditems_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount) % (subgridsdtmedicamentogriditems_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount/ (double) (subgridsdtmedicamentogriditems_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount/ (double) (subgridsdtmedicamentogriditems_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdtmedicamentogriditems_fnc_recordcount( )
   {
      return AV28SDTMedicamentoGridItems.size() ;
   }

   public int subgridsdtmedicamentogriditems_fnc_recordsperpage( )
   {
      if ( subGridsdtmedicamentogriditems_Rows > 0 )
      {
         return subGridsdtmedicamentogriditems_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdtmedicamentogriditems_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage/ (double) (subgridsdtmedicamentogriditems_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdtmedicamentogriditems_firstpage( )
   {
      GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtmedicamentogriditems_refresh( subGridsdtmedicamentogriditems_Rows, AV5CitaId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtmedicamentogriditems_nextpage( )
   {
      GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount = subgridsdtmedicamentogriditems_fnc_recordcount( ) ;
      if ( ( GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount >= subgridsdtmedicamentogriditems_fnc_recordsperpage( ) ) && ( GRIDSDTMEDICAMENTOGRIDITEMS_nEOF == 0 ) )
      {
         GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = (long)(GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage+subgridsdtmedicamentogriditems_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      if ( GRIDSDTMEDICAMENTOGRIDITEMS_nEOF == 1 )
      {
         GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsdtmedicamentogriditemsContainer.AddObjectProperty("GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage", GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtmedicamentogriditems_refresh( subGridsdtmedicamentogriditems_Rows, AV5CitaId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDTMEDICAMENTOGRIDITEMS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdtmedicamentogriditems_previouspage( )
   {
      if ( GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage >= subgridsdtmedicamentogriditems_fnc_recordsperpage( ) )
      {
         GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = (long)(GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage-subgridsdtmedicamentogriditems_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtmedicamentogriditems_refresh( subGridsdtmedicamentogriditems_Rows, AV5CitaId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtmedicamentogriditems_lastpage( )
   {
      GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount = subgridsdtmedicamentogriditems_fnc_recordcount( ) ;
      if ( GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount > subgridsdtmedicamentogriditems_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount) % (subgridsdtmedicamentogriditems_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = (long)(GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount-subgridsdtmedicamentogriditems_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = (long)(GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount-((int)((GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount) % (subgridsdtmedicamentogriditems_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtmedicamentogriditems_refresh( subGridsdtmedicamentogriditems_Rows, AV5CitaId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdtmedicamentogriditems_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = (long)(subgridsdtmedicamentogriditems_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtmedicamentogriditems_refresh( subGridsdtmedicamentogriditems_Rows, AV5CitaId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidopaterno_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacienteapellidomaterno_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientenombres_Enabled), 5, 0), true);
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled), 5, 0), true);
      edtavSdtcitadata_citapesodescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citapesodescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citapesodescripcion_Enabled), 5, 0), true);
      edtavSdtcitadata_citaestaturadescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_citaestaturadescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_citaestaturadescripcion_Enabled), 5, 0), true);
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled), 5, 0), true);
      cmbavSdtcitadata_citatipodiagnostico.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtcitadata_citatipodiagnostico.getEnabled(), 5, 0), true);
      edtavEliminarreceta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarreceta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarreceta_Enabled), 5, 0), !bGXsfl_129_Refreshing);
      edtavSdtmedicamentogriditems__medicamentonombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtmedicamentogriditems__medicamentonombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtmedicamentogriditems__medicamentonombre_Enabled), 5, 0), !bGXsfl_129_Refreshing);
      edtavSdtmedicamentogriditems__medicamentocantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtmedicamentogriditems__medicamentocantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtmedicamentogriditems__medicamentocantidad_Enabled), 5, 0), !bGXsfl_129_Refreshing);
      edtavArchivoadjuntofullname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavArchivoadjuntofullname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavArchivoadjuntofullname_Enabled), 5, 0), true);
      /* Using cursor H006F3 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV21MedicamentOId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000MedicamentoNombre = H006F3_A40000MedicamentoNombre[0] ;
         n40000MedicamentoNombre = H006F3_n40000MedicamentoNombre[0] ;
      }
      else
      {
         A40000MedicamentoNombre = "" ;
         n40000MedicamentoNombre = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40000MedicamentoNombre", A40000MedicamentoNombre);
      }
      pr_default.close(0);
      fix_multi_value_controls( ) ;
   }

   public void strup6F0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e196F2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtpacientedata"), AV29SDTPacienteData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtcitadata"), AV26SDTCitadata);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtmedicamentogriditems"), AV28SDTMedicamentoGridItems);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV10DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMEDICAMENTOID_DATA"), AV22MedicamentOId_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vUPLOADEDFILES"), AV31UploadedFiles);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFAILEDFILES"), AV13FailedFiles);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTMEDICAMENTOGRIDITEMS"), AV28SDTMedicamentoGridItems);
         /* Read saved values. */
         nRC_GXsfl_129 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_129"), ",", ".")) ;
         AV5CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "vCITAID"), ",", ".")) ;
         GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage"), ",", ".") ;
         GRIDSDTMEDICAMENTOGRIDITEMS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTMEDICAMENTOGRIDITEMS_nEOF"), ",", ".")) ;
         subGridsdtmedicamentogriditems_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTMEDICAMENTOGRIDITEMS_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_informacionpaciente_Width = httpContext.cgiGet( "DVPANEL_INFORMACIONPACIENTE_Width") ;
         Dvpanel_informacionpaciente_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_INFORMACIONPACIENTE_Autowidth")) ;
         Dvpanel_informacionpaciente_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_INFORMACIONPACIENTE_Autoheight")) ;
         Dvpanel_informacionpaciente_Cls = httpContext.cgiGet( "DVPANEL_INFORMACIONPACIENTE_Cls") ;
         Dvpanel_informacionpaciente_Title = httpContext.cgiGet( "DVPANEL_INFORMACIONPACIENTE_Title") ;
         Dvpanel_informacionpaciente_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_INFORMACIONPACIENTE_Collapsible")) ;
         Dvpanel_informacionpaciente_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_INFORMACIONPACIENTE_Collapsed")) ;
         Dvpanel_informacionpaciente_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_INFORMACIONPACIENTE_Showcollapseicon")) ;
         Dvpanel_informacionpaciente_Iconposition = httpContext.cgiGet( "DVPANEL_INFORMACIONPACIENTE_Iconposition") ;
         Dvpanel_informacionpaciente_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_INFORMACIONPACIENTE_Autoscroll")) ;
         Combo_medicamentoid_Cls = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Cls") ;
         Combo_medicamentoid_Selectedvalue_set = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Selectedvalue_set") ;
         Combo_medicamentoid_Emptyitemtext = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Emptyitemtext") ;
         Innewwindow1_Width = httpContext.cgiGet( "INNEWWINDOW1_Width") ;
         Innewwindow1_Height = httpContext.cgiGet( "INNEWWINDOW1_Height") ;
         Innewwindow1_Target = httpContext.cgiGet( "INNEWWINDOW1_Target") ;
         Dvpanel_tablefullwidth_Width = httpContext.cgiGet( "DVPANEL_TABLEFULLWIDTH_Width") ;
         Dvpanel_tablefullwidth_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEFULLWIDTH_Autowidth")) ;
         Dvpanel_tablefullwidth_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEFULLWIDTH_Autoheight")) ;
         Dvpanel_tablefullwidth_Cls = httpContext.cgiGet( "DVPANEL_TABLEFULLWIDTH_Cls") ;
         Dvpanel_tablefullwidth_Title = httpContext.cgiGet( "DVPANEL_TABLEFULLWIDTH_Title") ;
         Dvpanel_tablefullwidth_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEFULLWIDTH_Collapsible")) ;
         Dvpanel_tablefullwidth_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEFULLWIDTH_Collapsed")) ;
         Dvpanel_tablefullwidth_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEFULLWIDTH_Showcollapseicon")) ;
         Dvpanel_tablefullwidth_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEFULLWIDTH_Iconposition") ;
         Dvpanel_tablefullwidth_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEFULLWIDTH_Autoscroll")) ;
         Adjuntararchivo_Autoupload = GXutil.strtobool( httpContext.cgiGet( "ADJUNTARARCHIVO_Autoupload")) ;
         Adjuntararchivo_Hideadditionalbuttons = GXutil.strtobool( httpContext.cgiGet( "ADJUNTARARCHIVO_Hideadditionalbuttons")) ;
         Adjuntararchivo_Enableuploadedfilecanceling = GXutil.strtobool( httpContext.cgiGet( "ADJUNTARARCHIVO_Enableuploadedfilecanceling")) ;
         Adjuntararchivo_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( "ADJUNTARARCHIVO_Maxnumberoffiles"), ",", ".")) ;
         Dvpanel_paneldetalle_Width = httpContext.cgiGet( "DVPANEL_PANELDETALLE_Width") ;
         Dvpanel_paneldetalle_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLE_Autowidth")) ;
         Dvpanel_paneldetalle_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLE_Autoheight")) ;
         Dvpanel_paneldetalle_Cls = httpContext.cgiGet( "DVPANEL_PANELDETALLE_Cls") ;
         Dvpanel_paneldetalle_Title = httpContext.cgiGet( "DVPANEL_PANELDETALLE_Title") ;
         Dvpanel_paneldetalle_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLE_Collapsible")) ;
         Dvpanel_paneldetalle_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLE_Collapsed")) ;
         Dvpanel_paneldetalle_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLE_Showcollapseicon")) ;
         Dvpanel_paneldetalle_Iconposition = httpContext.cgiGet( "DVPANEL_PANELDETALLE_Iconposition") ;
         Dvpanel_paneldetalle_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELDETALLE_Autoscroll")) ;
         Dvpanel_panelbuton_Width = httpContext.cgiGet( "DVPANEL_PANELBUTON_Width") ;
         Dvpanel_panelbuton_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTON_Autowidth")) ;
         Dvpanel_panelbuton_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTON_Autoheight")) ;
         Dvpanel_panelbuton_Cls = httpContext.cgiGet( "DVPANEL_PANELBUTON_Cls") ;
         Dvpanel_panelbuton_Title = httpContext.cgiGet( "DVPANEL_PANELBUTON_Title") ;
         Dvpanel_panelbuton_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTON_Collapsible")) ;
         Dvpanel_panelbuton_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTON_Collapsed")) ;
         Dvpanel_panelbuton_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTON_Showcollapseicon")) ;
         Dvpanel_panelbuton_Iconposition = httpContext.cgiGet( "DVPANEL_PANELBUTON_Iconposition") ;
         Dvpanel_panelbuton_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELBUTON_Autoscroll")) ;
         Gxuitabspanel_tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABS_Pagecount"), ",", ".")) ;
         Gxuitabspanel_tabs_Class = httpContext.cgiGet( "GXUITABSPANEL_TABS_Class") ;
         Gxuitabspanel_tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS_Historymanagement")) ;
         Gridsdtmedicamentogriditems_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTMEDICAMENTOGRIDITEMS_EMPOWERER_Gridinternalname") ;
         Gridsdtmedicamentogriditems_empowerer_Infinitescrolling = httpContext.cgiGet( "GRIDSDTMEDICAMENTOGRIDITEMS_EMPOWERER_Infinitescrolling") ;
         nRC_GXsfl_129 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_129"), ",", ".")) ;
         nGXsfl_129_fel_idx = 0 ;
         while ( nGXsfl_129_fel_idx < nRC_GXsfl_129 )
         {
            nGXsfl_129_fel_idx = ((subGridsdtmedicamentogriditems_Islastpage==1)&&(nGXsfl_129_fel_idx+1>subgridsdtmedicamentogriditems_fnc_recordsperpage( )) ? 1 : nGXsfl_129_fel_idx+1) ;
            sGXsfl_129_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_129_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1292( ) ;
            AV51GXV9 = nGXsfl_129_fel_idx ;
            if ( ( AV28SDTMedicamentoGridItems.size() >= AV51GXV9 ) && ( AV51GXV9 > 0 ) )
            {
               AV28SDTMedicamentoGridItems.currentItem( ((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV51GXV9)) );
               AV12EliminarReceta = httpContext.cgiGet( edtavEliminarreceta_Internalname) ;
            }
         }
         if ( nGXsfl_129_fel_idx == 0 )
         {
            nGXsfl_129_idx = 1 ;
            sGXsfl_129_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_129_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1292( ) ;
         }
         nGXsfl_129_fel_idx = 1 ;
         /* Read variables values. */
         AV29SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacienteapellidopaterno( httpContext.cgiGet( edtavSdtpacientedata_pacienteapellidopaterno_Internalname) );
         AV29SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacienteapellidomaterno( httpContext.cgiGet( edtavSdtpacientedata_pacienteapellidomaterno_Internalname) );
         AV29SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientenombres( httpContext.cgiGet( edtavSdtpacientedata_pacientenombres_Internalname) );
         AV29SDTPacienteData.setgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion( httpContext.cgiGet( edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname) );
         AV26SDTCitadata.setgxTv_SdtSDTCitaData_Citapesodescripcion( httpContext.cgiGet( edtavSdtcitadata_citapesodescripcion_Internalname) );
         AV26SDTCitadata.setgxTv_SdtSDTCitaData_Citaestaturadescripcion( httpContext.cgiGet( edtavSdtcitadata_citaestaturadescripcion_Internalname) );
         AV26SDTCitadata.setgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre( httpContext.cgiGet( edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname) );
         cmbavSdtcitadata_citatipodiagnostico.setName( cmbavSdtcitadata_citatipodiagnostico.getInternalname() );
         cmbavSdtcitadata_citatipodiagnostico.setValue( httpContext.cgiGet( cmbavSdtcitadata_citatipodiagnostico.getInternalname()) );
         AV26SDTCitadata.setgxTv_SdtSDTCitaData_Citatipodiagnostico( httpContext.cgiGet( cmbavSdtcitadata_citatipodiagnostico.getInternalname()) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavMedicamentocantidad_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavMedicamentocantidad_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vMEDICAMENTOCANTIDAD");
            GX_FocusControl = edtavMedicamentocantidad_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV20MedicamentoCantidad = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20MedicamentoCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20MedicamentoCantidad), 4, 0));
         }
         else
         {
            AV20MedicamentoCantidad = (short)(localUtil.ctol( httpContext.cgiGet( edtavMedicamentocantidad_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20MedicamentoCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20MedicamentoCantidad), 4, 0));
         }
         AV24MedicamentoIndicaciones = httpContext.cgiGet( edtavMedicamentoindicaciones_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24MedicamentoIndicaciones", AV24MedicamentoIndicaciones);
         AV8ArchivoAdjuntoFullName = httpContext.cgiGet( edtavArchivoadjuntofullname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8ArchivoAdjuntoFullName", AV8ArchivoAdjuntoFullName);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavMedicamentoid_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavMedicamentoid_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vMEDICAMENTOID");
            GX_FocusControl = edtavMedicamentoid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV21MedicamentOId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21MedicamentOId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21MedicamentOId), 4, 0));
         }
         else
         {
            AV21MedicamentOId = (short)(localUtil.ctol( httpContext.cgiGet( edtavMedicamentoid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21MedicamentOId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21MedicamentOId), 4, 0));
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
      e196F2 ();
      if ( returnInSub )
      {
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e196F2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_SdtSDTCitaData1 = AV26SDTCitadata;
      GXv_SdtSDTCitaData2[0] = GXt_SdtSDTCitaData1;
      new com.projectthani.dpgetcitabyid(remoteHandle, context).execute( AV5CitaId, GXv_SdtSDTCitaData2) ;
      GXt_SdtSDTCitaData1 = GXv_SdtSDTCitaData2[0] ;
      AV26SDTCitadata = GXt_SdtSDTCitaData1;
      GXt_SdtSDTPacienteData3 = AV29SDTPacienteData;
      GXv_SdtSDTPacienteData4[0] = GXt_SdtSDTPacienteData3;
      new com.projectthani.dpgetpacientebyid(remoteHandle, context).execute( AV26SDTCitadata.getgxTv_SdtSDTCitaData_Pacienteid(), GXv_SdtSDTPacienteData4) ;
      GXt_SdtSDTPacienteData3 = GXv_SdtSDTPacienteData4[0] ;
      AV29SDTPacienteData = GXt_SdtSDTPacienteData3;
      divTablearchivodata_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablearchivodata_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablearchivodata_Visible), 5, 0), true);
      AV28SDTMedicamentoGridItems.clear();
      gx_BV129 = true ;
      /* Using cursor H006F4 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV5CitaId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A19CitaId = H006F4_A19CitaId[0] ;
         A267RecetaMedicaNombreArchivo = H006F4_A267RecetaMedicaNombreArchivo[0] ;
         n267RecetaMedicaNombreArchivo = H006F4_n267RecetaMedicaNombreArchivo[0] ;
         A270RecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
         A271RecetaArchivoTipo = H006F4_A271RecetaArchivoTipo[0] ;
         A270RecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
         A272RecetaMedicaFlag = H006F4_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = H006F4_n272RecetaMedicaFlag[0] ;
         A270RecetaMedicaArchivo = H006F4_A270RecetaMedicaArchivo[0] ;
         n270RecetaMedicaArchivo = H006F4_n270RecetaMedicaArchivo[0] ;
         A269RecetaMedicaCantidad = H006F4_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = H006F4_n269RecetaMedicaCantidad[0] ;
         A42MedicamentoId = H006F4_A42MedicamentoId[0] ;
         n42MedicamentoId = H006F4_n42MedicamentoId[0] ;
         A332RecetaIndicaciones = H006F4_A332RecetaIndicaciones[0] ;
         A230MedicamentoNombre = H006F4_A230MedicamentoNombre[0] ;
         A230MedicamentoNombre = H006F4_A230MedicamentoNombre[0] ;
         if ( A272RecetaMedicaFlag == 0 )
         {
            divTablearchivodata_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablearchivodata_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablearchivodata_Visible), 5, 0), true);
            divTableadjuntararchivo_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, divTableadjuntararchivo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableadjuntararchivo_Visible), 5, 0), true);
            bttBtnguardardigitalizacion_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnguardardigitalizacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnguardardigitalizacion_Visible), 5, 0), true);
            AV7ArchivoAdjuntoBlob = A270RecetaMedicaArchivo ;
            AV8ArchivoAdjuntoFullName = A267RecetaMedicaNombreArchivo ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8ArchivoAdjuntoFullName", AV8ArchivoAdjuntoFullName);
            AV33ArchivoExtension = A271RecetaArchivoTipo ;
         }
         if ( A272RecetaMedicaFlag == 1 )
         {
            AV27SDTMedicamentoGridItem = (com.projectthani.SdtSDTMedicamentoGridItem)new com.projectthani.SdtSDTMedicamentoGridItem(remoteHandle, context);
            AV27SDTMedicamentoGridItem.setgxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad( A269RecetaMedicaCantidad );
            AV27SDTMedicamentoGridItem.setgxTv_SdtSDTMedicamentoGridItem_Medicamentoid( A42MedicamentoId );
            AV27SDTMedicamentoGridItem.setgxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones( A332RecetaIndicaciones );
            AV27SDTMedicamentoGridItem.setgxTv_SdtSDTMedicamentoGridItem_Medicamentonombre( A230MedicamentoNombre );
            AV28SDTMedicamentoGridItems.add(AV27SDTMedicamentoGridItem, 0);
            gx_BV129 = true ;
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV10DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
      AV10DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      edtavMedicamentoid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMedicamentoid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMedicamentoid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOMEDICAMENTOID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
      Gridsdtmedicamentogriditems_empowerer_Gridinternalname = subGridsdtmedicamentogriditems_Internalname ;
      ucGridsdtmedicamentogriditems_empowerer.sendProperty(context, "", false, Gridsdtmedicamentogriditems_empowerer_Internalname, "GridInternalName", Gridsdtmedicamentogriditems_empowerer_Gridinternalname);
      subGridsdtmedicamentogriditems_Rows = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   private void e206F2( )
   {
      /* Gridsdtmedicamentogriditems_Load Routine */
      returnInSub = false ;
      AV51GXV9 = 1 ;
      while ( AV51GXV9 <= AV28SDTMedicamentoGridItems.size() )
      {
         AV28SDTMedicamentoGridItems.currentItem( ((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV51GXV9)) );
         AV12EliminarReceta = "<i class=\"fa fa-times\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavEliminarreceta_Internalname, AV12EliminarReceta);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(129) ;
         }
         if ( ( subGridsdtmedicamentogriditems_Islastpage == 1 ) || ( subGridsdtmedicamentogriditems_Rows == 0 ) || ( ( GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord >= GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage ) && ( GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord < GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage + subgridsdtmedicamentogriditems_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1292( ) ;
            GRIDSDTMEDICAMENTOGRIDITEMS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTMEDICAMENTOGRIDITEMS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord + 1 >= subgridsdtmedicamentogriditems_fnc_recordcount( ) )
            {
               GRIDSDTMEDICAMENTOGRIDITEMS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTMEDICAMENTOGRIDITEMS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTMEDICAMENTOGRIDITEMS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord = (long)(GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_129_Refreshing )
         {
            httpContext.doAjaxLoad(129, GridsdtmedicamentogriditemsRow);
         }
         AV51GXV9 = (int)(AV51GXV9+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e116F2( )
   {
      /* 'DoDescargarArchivo' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.prcdescargararchivo", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV5CitaId,8,0)),GXutil.URLEncode(GXutil.booltostr(AV40isVal))}, new String[] {"CitaId","Val"}) );
      httpContext.wjLocDisableFrm = (byte)(2) ;
      if ( ! AV40isVal )
      {
         httpContext.GX_msglist.addItem("No existe ninguna receta medica.");
      }
   }

   public void e126F2( )
   {
      /* 'DoEnviarArchivoPaciente' Routine */
      returnInSub = false ;
      new com.projectthani.prcenviarrecetamedica(remoteHandle, context).execute( AV5CitaId) ;
      httpContext.GX_msglist.addItem("La receta fue enviada con exito");
   }

   public void e136F2( )
   {
      /* 'DoSalirDigitalizacion' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(0);
      returnInSub = true;
      if (true) return;
   }

   public void e146F2( )
   {
      /* 'DoGuardarDigitalizacion' Routine */
      returnInSub = false ;
      if ( AV31UploadedFiles.size() > 0 )
      {
         AV39FileReceta = ((com.projectthani.SdtFileUploadData)AV31UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_File() ;
         AV36FileName = ((com.projectthani.SdtFileUploadData)AV31UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_Name() ;
         AV37FileExtencion = ((com.projectthani.SdtFileUploadData)AV31UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_Extension() ;
         GXv_boolean7[0] = AV6isSaved ;
         new com.projectthani.prcinsertardigitalizacion(remoteHandle, context).execute( AV5CitaId, AV39FileReceta, AV36FileName, AV37FileExtencion, GXv_boolean7) ;
         wpregistrarreceta_impl.this.AV6isSaved = GXv_boolean7[0] ;
         if ( AV6isSaved )
         {
            divTableadjuntararchivo_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, divTableadjuntararchivo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableadjuntararchivo_Visible), 5, 0), true);
            bttBtnguardardigitalizacion_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnguardardigitalizacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnguardardigitalizacion_Visible), 5, 0), true);
            divTablearchivodata_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablearchivodata_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablearchivodata_Visible), 5, 0), true);
         }
         else
         {
            httpContext.GX_msglist.addItem("Ocurrio un error");
         }
         this.executeUsercontrolMethod("", false, "ADJUNTARARCHIVOContainer", "Clear", "", new Object[] {});
      }
      else
      {
         httpContext.GX_msglist.addItem("Adjunte un archivo valido");
      }
      /*  Sending Event outputs  */
   }

   public void e156F2( )
   {
      /* 'DoEliminarArchivo' Routine */
      returnInSub = false ;
      new com.projectthani.prceliminararchivorecetamedica(remoteHandle, context).execute( AV5CitaId) ;
      divTableadjuntararchivo_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, divTableadjuntararchivo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableadjuntararchivo_Visible), 5, 0), true);
      bttBtnguardardigitalizacion_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnguardardigitalizacion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnguardardigitalizacion_Visible), 5, 0), true);
      divTablearchivodata_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablearchivodata_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablearchivodata_Visible), 5, 0), true);
      /*  Sending Event outputs  */
   }

   public void e166F2( )
   {
      AV51GXV9 = nGXsfl_129_idx ;
      if ( AV28SDTMedicamentoGridItems.size() >= AV51GXV9 )
      {
         AV28SDTMedicamentoGridItems.currentItem( ((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV51GXV9)) );
      }
      /* 'DoGuardarReceta' Routine */
      returnInSub = false ;
      httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "", "Se registro satisfactoriamente.", "success", "", "true"));
      GXv_boolean7[0] = AV6isSaved ;
      new com.projectthani.prcguardarmedicamentos(remoteHandle, context).execute( AV5CitaId, AV28SDTMedicamentoGridItems, GXv_boolean7) ;
      wpregistrarreceta_impl.this.AV6isSaved = GXv_boolean7[0] ;
   }

   public void e176F2( )
   {
      /* 'DoSalir' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(0);
      returnInSub = true;
      if (true) return;
   }

   public void e186F2( )
   {
      AV51GXV9 = nGXsfl_129_idx ;
      if ( AV28SDTMedicamentoGridItems.size() >= AV51GXV9 )
      {
         AV28SDTMedicamentoGridItems.currentItem( ((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV51GXV9)) );
      }
      /* 'DoGuardar' Routine */
      returnInSub = false ;
      /* Using cursor H006F6 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV21MedicamentOId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         A40000MedicamentoNombre = H006F6_A40000MedicamentoNombre[0] ;
         n40000MedicamentoNombre = H006F6_n40000MedicamentoNombre[0] ;
      }
      else
      {
         A40000MedicamentoNombre = "" ;
         n40000MedicamentoNombre = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40000MedicamentoNombre", A40000MedicamentoNombre);
      }
      pr_default.close(2);
      AV27SDTMedicamentoGridItem.setgxTv_SdtSDTMedicamentoGridItem_Medicamentoid( AV21MedicamentOId );
      AV27SDTMedicamentoGridItem.setgxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad( AV20MedicamentoCantidad );
      AV27SDTMedicamentoGridItem.setgxTv_SdtSDTMedicamentoGridItem_Medicamentoindicaciones( AV24MedicamentoIndicaciones );
      AV27SDTMedicamentoGridItem.setgxTv_SdtSDTMedicamentoGridItem_Medicamentonombre( A40000MedicamentoNombre );
      AV28SDTMedicamentoGridItems.add(AV27SDTMedicamentoGridItem, 0);
      gx_BV129 = true ;
      AV20MedicamentoCantidad = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20MedicamentoCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20MedicamentoCantidad), 4, 0));
      AV21MedicamentOId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21MedicamentOId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21MedicamentOId), 4, 0));
      AV24MedicamentoIndicaciones = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24MedicamentoIndicaciones", AV24MedicamentoIndicaciones);
      Combo_medicamentoid_Selectedvalue_set = ((0==AV21MedicamentOId) ? "" : GXutil.trim( GXutil.str( AV21MedicamentOId, 4, 0))) ;
      ucCombo_medicamentoid.sendProperty(context, "", false, Combo_medicamentoid_Internalname, "SelectedValue_set", Combo_medicamentoid_Selectedvalue_set);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27SDTMedicamentoGridItem", AV27SDTMedicamentoGridItem);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28SDTMedicamentoGridItems", AV28SDTMedicamentoGridItems);
      nGXsfl_129_bak_idx = nGXsfl_129_idx ;
      gxgrgridsdtmedicamentogriditems_refresh( subGridsdtmedicamentogriditems_Rows, AV5CitaId) ;
      nGXsfl_129_idx = nGXsfl_129_bak_idx ;
      sGXsfl_129_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_129_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1292( ) ;
   }

   public void S112( )
   {
      /* 'LOADCOMBOMEDICAMENTOID' Routine */
      returnInSub = false ;
      AV56GXV13 = 1 ;
      GXt_objcol_SdtSDTMedicamentoData8 = AV55GXV12 ;
      GXv_objcol_SdtSDTMedicamentoData9[0] = GXt_objcol_SdtSDTMedicamentoData8 ;
      new com.projectthani.dpgetmedicamento(remoteHandle, context).execute( GXv_objcol_SdtSDTMedicamentoData9) ;
      GXt_objcol_SdtSDTMedicamentoData8 = GXv_objcol_SdtSDTMedicamentoData9[0] ;
      AV55GXV12 = GXt_objcol_SdtSDTMedicamentoData8 ;
      while ( AV56GXV13 <= AV55GXV12.size() )
      {
         AV23MedicamentOId_DPItem = (com.projectthani.SdtSDTMedicamentoData)((com.projectthani.SdtSDTMedicamentoData)AV55GXV12.elementAt(-1+AV56GXV13));
         AV9Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( AV23MedicamentOId_DPItem.getgxTv_SdtSDTMedicamentoData_Medicamentoid(), 4, 0)) );
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( AV23MedicamentOId_DPItem.getgxTv_SdtSDTMedicamentoData_Medicamentonombre() );
         AV22MedicamentOId_Data.add(AV9Combo_DataItem, 0);
         AV56GXV13 = (int)(AV56GXV13+1) ;
      }
      AV22MedicamentOId_Data.sort("Title");
      Combo_medicamentoid_Selectedvalue_set = ((0==AV21MedicamentOId) ? "" : GXutil.trim( GXutil.str( AV21MedicamentOId, 4, 0))) ;
      ucCombo_medicamentoid.sendProperty(context, "", false, Combo_medicamentoid_Internalname, "SelectedValue_set", Combo_medicamentoid_Selectedvalue_set);
   }

   public void e216F2( )
   {
      AV51GXV9 = nGXsfl_129_idx ;
      if ( AV28SDTMedicamentoGridItems.size() >= AV51GXV9 )
      {
         AV28SDTMedicamentoGridItems.currentItem( ((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV51GXV9)) );
      }
      /* Eliminarreceta_Click Routine */
      returnInSub = false ;
      AV18i = (short)(AV28SDTMedicamentoGridItems.size()) ;
      AV27SDTMedicamentoGridItem = (com.projectthani.SdtSDTMedicamentoGridItem)((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.currentItem());
      while ( AV18i >= 1 )
      {
         if ( AV27SDTMedicamentoGridItem.getgxTv_SdtSDTMedicamentoGridItem_Medicamentoid() == ((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV18i)).getgxTv_SdtSDTMedicamentoGridItem_Medicamentoid() )
         {
            AV28SDTMedicamentoGridItems.removeItem(AV18i);
            gx_BV129 = true ;
         }
         AV18i = (short)(AV18i-1) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27SDTMedicamentoGridItem", AV27SDTMedicamentoGridItem);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV28SDTMedicamentoGridItems", AV28SDTMedicamentoGridItems);
      nGXsfl_129_bak_idx = nGXsfl_129_idx ;
      gxgrgridsdtmedicamentogriditems_refresh( subGridsdtmedicamentogriditems_Rows, AV5CitaId) ;
      nGXsfl_129_idx = nGXsfl_129_bak_idx ;
      sGXsfl_129_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_129_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1292( ) ;
   }

   public void wb_table3_155_6F2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPaneldetalle_Internalname, tblPaneldetalle_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableadjuntararchivo_Internalname, divTableadjuntararchivo_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* User Defined Control */
         ucAdjuntararchivo.setProperty("AutoUpload", Adjuntararchivo_Autoupload);
         ucAdjuntararchivo.setProperty("HideAdditionalButtons", Adjuntararchivo_Hideadditionalbuttons);
         ucAdjuntararchivo.setProperty("TooltipText", Adjuntararchivo_Tooltiptext);
         ucAdjuntararchivo.setProperty("EnableUploadedFileCanceling", Adjuntararchivo_Enableuploadedfilecanceling);
         ucAdjuntararchivo.setProperty("MaxNumberOfFiles", Adjuntararchivo_Maxnumberoffiles);
         ucAdjuntararchivo.setProperty("UploadedFiles", AV31UploadedFiles);
         ucAdjuntararchivo.setProperty("FailedFiles", AV13FailedFiles);
         ucAdjuntararchivo.render(context, "fileupload", Adjuntararchivo_Internalname, "ADJUNTARARCHIVOContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablearchivodata_Internalname, divTablearchivodata_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 DataContentCell DscTop", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavArchivoadjuntofullname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavArchivoadjuntofullname_Internalname, "Archivo Adjunto", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'',false,'" + sGXsfl_129_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavArchivoadjuntofullname_Internalname, AV8ArchivoAdjuntoFullName, GXutil.rtrim( localUtil.format( AV8ArchivoAdjuntoFullName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,169);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavArchivoadjuntofullname_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavArchivoadjuntofullname_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablebtn_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 175,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnguardardigitalizacion_Internalname, "gx.evt.setGridEvt("+GXutil.str( 129, 3, 0)+","+"null"+");", "Guardar", bttBtnguardardigitalizacion_Jsonclick, 5, "Guardar", "", StyleString, ClassString, bttBtnguardardigitalizacion_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGUARDARDIGITALIZACION\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 mb10", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 177,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtneliminararchivo_Internalname, "gx.evt.setGridEvt("+GXutil.str( 129, 3, 0)+","+"null"+");", "Eliminar", bttBtneliminararchivo_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOELIMINARARCHIVO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_155_6F2e( true) ;
      }
      else
      {
         wb_table3_155_6F2e( false) ;
      }
   }

   public void wb_table2_94_6F2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablefullwidth_Internalname, tblTablefullwidth_Internalname, "", "TableFullWidth", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "TableFullWidth", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedmedicamentoid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_medicamentoid_Internalname, "Medicamento", "", "", lblTextblockcombo_medicamentoid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_medicamentoid.setProperty("Caption", Combo_medicamentoid_Caption);
         ucCombo_medicamentoid.setProperty("Cls", Combo_medicamentoid_Cls);
         ucCombo_medicamentoid.setProperty("EmptyItemText", Combo_medicamentoid_Emptyitemtext);
         ucCombo_medicamentoid.setProperty("DropDownOptionsTitleSettingsIcons", AV10DDO_TitleSettingsIcons);
         ucCombo_medicamentoid.setProperty("DropDownOptionsData", AV22MedicamentOId_Data);
         ucCombo_medicamentoid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_medicamentoid_Internalname, "COMBO_MEDICAMENTOIDContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavMedicamentocantidad_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavMedicamentocantidad_Internalname, "Cantidad", " AttributeFormCustomLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'" + sGXsfl_129_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavMedicamentocantidad_Internalname, GXutil.ltrim( localUtil.ntoc( AV20MedicamentoCantidad, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavMedicamentocantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20MedicamentoCantidad), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20MedicamentoCantidad), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMedicamentocantidad_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavMedicamentocantidad_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablemedicamentoindicaciones_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmedicamentoindicaciones_Internalname, "Indicaciones", "", "", lblTextblockmedicamentoindicaciones_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavMedicamentoindicaciones_Internalname, "Medicamento Indicaciones", "col-sm-3 AttributeFormCustomLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'" + sGXsfl_129_idx + "',0)\"" ;
         ClassString = "AttributeFormCustom" ;
         StyleString = "" ;
         ClassString = "AttributeFormCustom" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavMedicamentoindicaciones_Internalname, AV24MedicamentoIndicaciones, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,118);\"", (short)(0), 1, edtavMedicamentoindicaciones_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         wb_table4_121_6F2( true) ;
      }
      else
      {
         wb_table4_121_6F2( false) ;
      }
      return  ;
   }

   public void wb_table4_121_6F2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /*  Grid Control  */
         GridsdtmedicamentogriditemsContainer.SetWrapped(nGXWrapped);
         if ( GridsdtmedicamentogriditemsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridsdtmedicamentogriditemsContainer"+"DivS\" data-gxgridid=\"129\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridsdtmedicamentogriditems_Internalname, subGridsdtmedicamentogriditems_Internalname, "", "GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGridsdtmedicamentogriditems_Backcolorstyle == 0 )
            {
               subGridsdtmedicamentogriditems_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGridsdtmedicamentogriditems_Class) > 0 )
               {
                  subGridsdtmedicamentogriditems_Linesclass = subGridsdtmedicamentogriditems_Class+"Title" ;
               }
            }
            else
            {
               subGridsdtmedicamentogriditems_Titlebackstyle = (byte)(1) ;
               if ( subGridsdtmedicamentogriditems_Backcolorstyle == 1 )
               {
                  subGridsdtmedicamentogriditems_Titlebackcolor = subGridsdtmedicamentogriditems_Allbackcolor ;
                  if ( GXutil.len( subGridsdtmedicamentogriditems_Class) > 0 )
                  {
                     subGridsdtmedicamentogriditems_Linesclass = subGridsdtmedicamentogriditems_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGridsdtmedicamentogriditems_Class) > 0 )
                  {
                     subGridsdtmedicamentogriditems_Linesclass = subGridsdtmedicamentogriditems_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Medicamento") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Cantidad") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("GridName", "Gridsdtmedicamentogriditems");
         }
         else
         {
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("GridName", "Gridsdtmedicamentogriditems");
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Header", subGridsdtmedicamentogriditems_Header);
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Class", "GridNoBorder WorkWith");
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("CmpContext", "");
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("InMasterPage", "false");
            GridsdtmedicamentogriditemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtmedicamentogriditemsColumn.AddObjectProperty("Value", AV12EliminarReceta);
            GridsdtmedicamentogriditemsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminarreceta_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddColumnProperties(GridsdtmedicamentogriditemsColumn);
            GridsdtmedicamentogriditemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtmedicamentogriditemsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtmedicamentogriditems__medicamentonombre_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddColumnProperties(GridsdtmedicamentogriditemsColumn);
            GridsdtmedicamentogriditemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtmedicamentogriditemsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtmedicamentogriditems__medicamentocantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddColumnProperties(GridsdtmedicamentogriditemsColumn);
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdtmedicamentogriditems_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 129 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_129 = (int)(nGXsfl_129_idx-1) ;
         if ( GridsdtmedicamentogriditemsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("GRIDSDTMEDICAMENTOGRIDITEMS_nEOF", GRIDSDTMEDICAMENTOGRIDITEMS_nEOF);
            GridsdtmedicamentogriditemsContainer.AddObjectProperty("GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage", GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage);
            AV51GXV9 = nGXsfl_129_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridsdtmedicamentogriditemsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdtmedicamentogriditems", GridsdtmedicamentogriditemsContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtmedicamentogriditemsContainerData", GridsdtmedicamentogriditemsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtmedicamentogriditemsContainerData"+"V", GridsdtmedicamentogriditemsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtmedicamentogriditemsContainerData"+"V"+"\" value='"+GridsdtmedicamentogriditemsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable4_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 138,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnguardarreceta_Internalname, "gx.evt.setGridEvt("+GXutil.str( 129, 3, 0)+","+"null"+");", "Guardar", bttBtnguardarreceta_Jsonclick, 5, "Guardar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGUARDARRECETA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 140,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnexportarrecetamedica_Internalname, "gx.evt.setGridEvt("+GXutil.str( 129, 3, 0)+","+"null"+");", "Descargar Receta", bttBtnexportarrecetamedica_Jsonclick, 7, "Descargar Receta", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e226f1_client"+"'", TempTags, "", 2, "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 142,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnsalir_Internalname, "gx.evt.setGridEvt("+GXutil.str( 129, 3, 0)+","+"null"+");", "Salir", bttBtnsalir_Jsonclick, 5, "Salir", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOSALIR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucInnewwindow1.setProperty("Width", Innewwindow1_Width);
         ucInnewwindow1.setProperty("Height", Innewwindow1_Height);
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_94_6F2e( true) ;
      }
      else
      {
         wb_table2_94_6F2e( false) ;
      }
   }

   public void wb_table4_121_6F2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblUnnamedtable3_Internalname, tblUnnamedtable3_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnguardar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 129, 3, 0)+","+"null"+");", "Agregar", bttBtnguardar_Jsonclick, 5, "Agregar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGUARDAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarReceta.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 126,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnlimpiar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 129, 3, 0)+","+"null"+");", "Limpiar", bttBtnlimpiar_Jsonclick, 7, "Limpiar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e236f1_client"+"'", TempTags, "", 2, "HLP_WPRegistrarReceta.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_121_6F2e( true) ;
      }
      else
      {
         wb_table4_121_6F2e( false) ;
      }
   }

   public void wb_table1_22_6F2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblInformacionpaciente_Internalname, tblInformacionpaciente_Internalname, "", "TableFullWidth", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesdtpacientedata_pacienteapellidopaterno_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksdtpacientedata_pacienteapellidopaterno_Internalname, "Ap. Paterno", "", "", lblTextblocksdtpacientedata_pacienteapellidopaterno_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, "Paciente Apellido Paterno", "col-sm-3 AttributeFormCustomLabel", 0, true, "");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacienteapellidopaterno_Internalname, AV29SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidopaterno(), GXutil.rtrim( localUtil.format( AV29SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidopaterno(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacienteapellidopaterno_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacienteapellidopaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesdtpacientedata_pacienteapellidomaterno_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksdtpacientedata_pacienteapellidomaterno_Internalname, "Ap. Materno", "", "", lblTextblocksdtpacientedata_pacienteapellidomaterno_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, "Paciente Apellido Materno", "col-sm-3 AttributeFormCustomLabel", 0, true, "");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacienteapellidomaterno_Internalname, AV29SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidomaterno(), GXutil.rtrim( localUtil.format( AV29SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacienteapellidomaterno(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacienteapellidomaterno_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacienteapellidomaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesdtpacientedata_pacientenombres_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksdtpacientedata_pacientenombres_Internalname, "Nombres", "", "", lblTextblocksdtpacientedata_pacientenombres_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientenombres_Internalname, "Paciente Nombres", "col-sm-3 AttributeFormCustomLabel", 0, true, "");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientenombres_Internalname, AV29SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientenombres(), GXutil.rtrim( localUtil.format( AV29SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientenombres(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientenombres_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacientenombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesdtpacientedata_pacientefechanacimientodescripcion_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksdtpacientedata_pacientefechanacimientodescripcion_Internalname, "Fecha Nac.", "", "", lblTextblocksdtpacientedata_pacientefechanacimientodescripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, "Paciente Fecha Nacimiento Descripcion", "col-sm-3 AttributeFormCustomLabel", 0, true, "");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname, AV29SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion(), GXutil.rtrim( localUtil.format( AV29SDTPacienteData.getgxTv_SdtSDTPacienteData_Pacientefechanacimientodescripcion(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtpacientedata_pacientefechanacimientodescripcion_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesdtcitadata_citapesodescripcion_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksdtcitadata_citapesodescripcion_Internalname, "Peso", "", "", lblTextblocksdtcitadata_citapesodescripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citapesodescripcion_Internalname, "Cita Peso Descripcion", "col-sm-3 AttributeFormCustomLabel", 0, true, "");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_citapesodescripcion_Internalname, AV26SDTCitadata.getgxTv_SdtSDTCitaData_Citapesodescripcion(), GXutil.rtrim( localUtil.format( AV26SDTCitadata.getgxTv_SdtSDTCitaData_Citapesodescripcion(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_citapesodescripcion_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtcitadata_citapesodescripcion_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesdtcitadata_citaestaturadescripcion_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksdtcitadata_citaestaturadescripcion_Internalname, "Estatura", "", "", lblTextblocksdtcitadata_citaestaturadescripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_citaestaturadescripcion_Internalname, "Cita Estatura Descripcion", "col-sm-3 AttributeFormCustomLabel", 0, true, "");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_citaestaturadescripcion_Internalname, AV26SDTCitadata.getgxTv_SdtSDTCitaData_Citaestaturadescripcion(), GXutil.rtrim( localUtil.format( AV26SDTCitadata.getgxTv_SdtSDTCitaData_Citaestaturadescripcion(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_citaestaturadescripcion_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtcitadata_citaestaturadescripcion_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, "Especialidad", "", "", lblTextblocksdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, "SGCita Disponibilidad Especialidad Nombre", "col-sm-3 AttributeFormCustomLabel", 0, true, "");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname, AV26SDTCitadata.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre(), GXutil.rtrim( localUtil.format( AV26SDTCitadata.getgxTv_SdtSDTCitaData_Sgcitadisponibilidadespecialidadnombre(), "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick, 0, "AttributeFormCustom", "", "", "", "", 1, edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='DataContentCell DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablesdtcitadata_citatipodiagnostico_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksdtcitadata_citatipodiagnostico_Internalname, "Tipo Diagnostico", "", "", lblTextblocksdtcitadata_citatipodiagnostico_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarReceta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Cita Tipo Diagnostico", "col-sm-3 AttributeFormCustomLabel", 0, true, "");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSdtcitadata_citatipodiagnostico, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), GXutil.rtrim( AV26SDTCitadata.getgxTv_SdtSDTCitaData_Citatipodiagnostico()), 1, cmbavSdtcitadata_citatipodiagnostico.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavSdtcitadata_citatipodiagnostico.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeFormCustom", "", "", "", "", true, (byte)(1), "HLP_WPRegistrarReceta.htm");
         cmbavSdtcitadata_citatipodiagnostico.setValue( GXutil.rtrim( AV26SDTCitadata.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtcitadata_citatipodiagnostico.getInternalname(), "Values", cmbavSdtcitadata_citatipodiagnostico.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_22_6F2e( true) ;
      }
      else
      {
         wb_table1_22_6F2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV5CitaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CitaId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CitaId), "ZZZZZZZ9")));
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
      pa6F2( ) ;
      ws6F2( ) ;
      we6F2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202251103495", true, true);
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
      httpContext.AddJavascriptSource("wpregistrarreceta.js", "?202251103495", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1292( )
   {
      edtavEliminarreceta_Internalname = "vELIMINARRECETA_"+sGXsfl_129_idx ;
      edtavSdtmedicamentogriditems__medicamentonombre_Internalname = "SDTMEDICAMENTOGRIDITEMS__MEDICAMENTONOMBRE_"+sGXsfl_129_idx ;
      edtavSdtmedicamentogriditems__medicamentocantidad_Internalname = "SDTMEDICAMENTOGRIDITEMS__MEDICAMENTOCANTIDAD_"+sGXsfl_129_idx ;
   }

   public void subsflControlProps_fel_1292( )
   {
      edtavEliminarreceta_Internalname = "vELIMINARRECETA_"+sGXsfl_129_fel_idx ;
      edtavSdtmedicamentogriditems__medicamentonombre_Internalname = "SDTMEDICAMENTOGRIDITEMS__MEDICAMENTONOMBRE_"+sGXsfl_129_fel_idx ;
      edtavSdtmedicamentogriditems__medicamentocantidad_Internalname = "SDTMEDICAMENTOGRIDITEMS__MEDICAMENTOCANTIDAD_"+sGXsfl_129_fel_idx ;
   }

   public void sendrow_1292( )
   {
      subsflControlProps_1292( ) ;
      wb6F0( ) ;
      if ( ( subGridsdtmedicamentogriditems_Rows * 1 == 0 ) || ( nGXsfl_129_idx - GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage <= subgridsdtmedicamentogriditems_fnc_recordsperpage( ) * 1 ) )
      {
         GridsdtmedicamentogriditemsRow = GXWebRow.GetNew(context,GridsdtmedicamentogriditemsContainer) ;
         if ( subGridsdtmedicamentogriditems_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdtmedicamentogriditems_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdtmedicamentogriditems_Class, "") != 0 )
            {
               subGridsdtmedicamentogriditems_Linesclass = subGridsdtmedicamentogriditems_Class+"Odd" ;
            }
         }
         else if ( subGridsdtmedicamentogriditems_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdtmedicamentogriditems_Backstyle = (byte)(0) ;
            subGridsdtmedicamentogriditems_Backcolor = subGridsdtmedicamentogriditems_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdtmedicamentogriditems_Class, "") != 0 )
            {
               subGridsdtmedicamentogriditems_Linesclass = subGridsdtmedicamentogriditems_Class+"Uniform" ;
            }
         }
         else if ( subGridsdtmedicamentogriditems_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdtmedicamentogriditems_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdtmedicamentogriditems_Class, "") != 0 )
            {
               subGridsdtmedicamentogriditems_Linesclass = subGridsdtmedicamentogriditems_Class+"Odd" ;
            }
            subGridsdtmedicamentogriditems_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdtmedicamentogriditems_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdtmedicamentogriditems_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_129_idx) % (2))) == 0 )
            {
               subGridsdtmedicamentogriditems_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtmedicamentogriditems_Class, "") != 0 )
               {
                  subGridsdtmedicamentogriditems_Linesclass = subGridsdtmedicamentogriditems_Class+"Even" ;
               }
            }
            else
            {
               subGridsdtmedicamentogriditems_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtmedicamentogriditems_Class, "") != 0 )
               {
                  subGridsdtmedicamentogriditems_Linesclass = subGridsdtmedicamentogriditems_Class+"Odd" ;
               }
            }
         }
         if ( GridsdtmedicamentogriditemsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_129_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtmedicamentogriditemsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminarreceta_Enabled!=0)&&(edtavEliminarreceta_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 130,'',false,'"+sGXsfl_129_idx+"',129)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridsdtmedicamentogriditemsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarreceta_Internalname,AV12EliminarReceta,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminarreceta_Enabled!=0)&&(edtavEliminarreceta_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,130);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVELIMINARRECETA.CLICK."+sGXsfl_129_idx+"'","","","","",edtavEliminarreceta_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavEliminarreceta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(129),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtmedicamentogriditemsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtmedicamentogriditemsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtmedicamentogriditems__medicamentonombre_Internalname,((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV51GXV9)).getgxTv_SdtSDTMedicamentoGridItem_Medicamentonombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtmedicamentogriditems__medicamentonombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtmedicamentogriditems__medicamentonombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(129),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtmedicamentogriditemsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtmedicamentogriditemsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtmedicamentogriditems__medicamentocantidad_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV51GXV9)).getgxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavSdtmedicamentogriditems__medicamentocantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV51GXV9)).getgxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTMedicamentoGridItem)AV28SDTMedicamentoGridItems.elementAt(-1+AV51GXV9)).getgxTv_SdtSDTMedicamentoGridItem_Medicamentocantidad()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtmedicamentogriditems__medicamentocantidad_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtmedicamentogriditems__medicamentocantidad_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(129),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes6F2( ) ;
         GridsdtmedicamentogriditemsContainer.AddRow(GridsdtmedicamentogriditemsRow);
         nGXsfl_129_idx = ((subGridsdtmedicamentogriditems_Islastpage==1)&&(nGXsfl_129_idx+1>subgridsdtmedicamentogriditems_fnc_recordsperpage( )) ? 1 : nGXsfl_129_idx+1) ;
         sGXsfl_129_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_129_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1292( ) ;
      }
      /* End function sendrow_1292 */
   }

   public void init_default_properties( )
   {
      lblTabgeneral_title_Internalname = "TABGENERAL_TITLE" ;
      lblTextblocksdtpacientedata_pacienteapellidopaterno_Internalname = "TEXTBLOCKSDTPACIENTEDATA_PACIENTEAPELLIDOPATERNO" ;
      edtavSdtpacientedata_pacienteapellidopaterno_Internalname = "SDTPACIENTEDATA_PACIENTEAPELLIDOPATERNO" ;
      divUnnamedtablesdtpacientedata_pacienteapellidopaterno_Internalname = "UNNAMEDTABLESDTPACIENTEDATA_PACIENTEAPELLIDOPATERNO" ;
      lblTextblocksdtpacientedata_pacienteapellidomaterno_Internalname = "TEXTBLOCKSDTPACIENTEDATA_PACIENTEAPELLIDOMATERNO" ;
      edtavSdtpacientedata_pacienteapellidomaterno_Internalname = "SDTPACIENTEDATA_PACIENTEAPELLIDOMATERNO" ;
      divUnnamedtablesdtpacientedata_pacienteapellidomaterno_Internalname = "UNNAMEDTABLESDTPACIENTEDATA_PACIENTEAPELLIDOMATERNO" ;
      lblTextblocksdtpacientedata_pacientenombres_Internalname = "TEXTBLOCKSDTPACIENTEDATA_PACIENTENOMBRES" ;
      edtavSdtpacientedata_pacientenombres_Internalname = "SDTPACIENTEDATA_PACIENTENOMBRES" ;
      divUnnamedtablesdtpacientedata_pacientenombres_Internalname = "UNNAMEDTABLESDTPACIENTEDATA_PACIENTENOMBRES" ;
      lblTextblocksdtpacientedata_pacientefechanacimientodescripcion_Internalname = "TEXTBLOCKSDTPACIENTEDATA_PACIENTEFECHANACIMIENTODESCRIPCION" ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname = "SDTPACIENTEDATA_PACIENTEFECHANACIMIENTODESCRIPCION" ;
      divUnnamedtablesdtpacientedata_pacientefechanacimientodescripcion_Internalname = "UNNAMEDTABLESDTPACIENTEDATA_PACIENTEFECHANACIMIENTODESCRIPCION" ;
      lblTextblocksdtcitadata_citapesodescripcion_Internalname = "TEXTBLOCKSDTCITADATA_CITAPESODESCRIPCION" ;
      edtavSdtcitadata_citapesodescripcion_Internalname = "SDTCITADATA_CITAPESODESCRIPCION" ;
      divUnnamedtablesdtcitadata_citapesodescripcion_Internalname = "UNNAMEDTABLESDTCITADATA_CITAPESODESCRIPCION" ;
      lblTextblocksdtcitadata_citaestaturadescripcion_Internalname = "TEXTBLOCKSDTCITADATA_CITAESTATURADESCRIPCION" ;
      edtavSdtcitadata_citaestaturadescripcion_Internalname = "SDTCITADATA_CITAESTATURADESCRIPCION" ;
      divUnnamedtablesdtcitadata_citaestaturadescripcion_Internalname = "UNNAMEDTABLESDTCITADATA_CITAESTATURADESCRIPCION" ;
      lblTextblocksdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname = "TEXTBLOCKSDTCITADATA_SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname = "SDTCITADATA_SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      divUnnamedtablesdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname = "UNNAMEDTABLESDTCITADATA_SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      lblTextblocksdtcitadata_citatipodiagnostico_Internalname = "TEXTBLOCKSDTCITADATA_CITATIPODIAGNOSTICO" ;
      cmbavSdtcitadata_citatipodiagnostico.setInternalname( "SDTCITADATA_CITATIPODIAGNOSTICO" );
      divUnnamedtablesdtcitadata_citatipodiagnostico_Internalname = "UNNAMEDTABLESDTCITADATA_CITATIPODIAGNOSTICO" ;
      tblInformacionpaciente_Internalname = "INFORMACIONPACIENTE" ;
      Dvpanel_informacionpaciente_Internalname = "DVPANEL_INFORMACIONPACIENTE" ;
      lblTextblockcombo_medicamentoid_Internalname = "TEXTBLOCKCOMBO_MEDICAMENTOID" ;
      Combo_medicamentoid_Internalname = "COMBO_MEDICAMENTOID" ;
      divTablesplittedmedicamentoid_Internalname = "TABLESPLITTEDMEDICAMENTOID" ;
      edtavMedicamentocantidad_Internalname = "vMEDICAMENTOCANTIDAD" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      lblTextblockmedicamentoindicaciones_Internalname = "TEXTBLOCKMEDICAMENTOINDICACIONES" ;
      edtavMedicamentoindicaciones_Internalname = "vMEDICAMENTOINDICACIONES" ;
      divUnnamedtablemedicamentoindicaciones_Internalname = "UNNAMEDTABLEMEDICAMENTOINDICACIONES" ;
      bttBtnguardar_Internalname = "BTNGUARDAR" ;
      bttBtnlimpiar_Internalname = "BTNLIMPIAR" ;
      tblUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      edtavEliminarreceta_Internalname = "vELIMINARRECETA" ;
      edtavSdtmedicamentogriditems__medicamentonombre_Internalname = "SDTMEDICAMENTOGRIDITEMS__MEDICAMENTONOMBRE" ;
      edtavSdtmedicamentogriditems__medicamentocantidad_Internalname = "SDTMEDICAMENTOGRIDITEMS__MEDICAMENTOCANTIDAD" ;
      bttBtnguardarreceta_Internalname = "BTNGUARDARRECETA" ;
      bttBtnexportarrecetamedica_Internalname = "BTNEXPORTARRECETAMEDICA" ;
      bttBtnsalir_Internalname = "BTNSALIR" ;
      divUnnamedtable4_Internalname = "UNNAMEDTABLE4" ;
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
      tblTablefullwidth_Internalname = "TABLEFULLWIDTH" ;
      Dvpanel_tablefullwidth_Internalname = "DVPANEL_TABLEFULLWIDTH" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      lblDigitalizacion_title_Internalname = "DIGITALIZACION_TITLE" ;
      Adjuntararchivo_Internalname = "ADJUNTARARCHIVO" ;
      divTableadjuntararchivo_Internalname = "TABLEADJUNTARARCHIVO" ;
      edtavArchivoadjuntofullname_Internalname = "vARCHIVOADJUNTOFULLNAME" ;
      divTablearchivodata_Internalname = "TABLEARCHIVODATA" ;
      bttBtnguardardigitalizacion_Internalname = "BTNGUARDARDIGITALIZACION" ;
      bttBtneliminararchivo_Internalname = "BTNELIMINARARCHIVO" ;
      divTablebtn_Internalname = "TABLEBTN" ;
      tblPaneldetalle_Internalname = "PANELDETALLE" ;
      Dvpanel_paneldetalle_Internalname = "DVPANEL_PANELDETALLE" ;
      bttBtndescargararchivo_Internalname = "BTNDESCARGARARCHIVO" ;
      bttBtnenviararchivopaciente_Internalname = "BTNENVIARARCHIVOPACIENTE" ;
      bttBtnsalirdigitalizacion_Internalname = "BTNSALIRDIGITALIZACION" ;
      divPanelbuton_Internalname = "PANELBUTON" ;
      Dvpanel_panelbuton_Internalname = "DVPANEL_PANELBUTON" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Gxuitabspanel_tabs_Internalname = "GXUITABSPANEL_TABS" ;
      Msgdvelop_Internalname = "MSGDVELOP" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavMedicamentoid_Internalname = "vMEDICAMENTOID" ;
      Gridsdtmedicamentogriditems_empowerer_Internalname = "GRIDSDTMEDICAMENTOGRIDITEMS_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridsdtmedicamentogriditems_Internalname = "GRIDSDTMEDICAMENTOGRIDITEMS" ;
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
      edtavSdtmedicamentogriditems__medicamentocantidad_Jsonclick = "" ;
      edtavSdtmedicamentogriditems__medicamentonombre_Jsonclick = "" ;
      edtavEliminarreceta_Jsonclick = "" ;
      edtavEliminarreceta_Visible = -1 ;
      cmbavSdtcitadata_citatipodiagnostico.setJsonclick( "" );
      cmbavSdtcitadata_citatipodiagnostico.setEnabled( 0 );
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick = "" ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      edtavSdtcitadata_citaestaturadescripcion_Jsonclick = "" ;
      edtavSdtcitadata_citaestaturadescripcion_Enabled = 0 ;
      edtavSdtcitadata_citapesodescripcion_Jsonclick = "" ;
      edtavSdtcitadata_citapesodescripcion_Enabled = 0 ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Jsonclick = "" ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      edtavSdtpacientedata_pacientenombres_Jsonclick = "" ;
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      edtavSdtpacientedata_pacienteapellidomaterno_Jsonclick = "" ;
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      edtavSdtpacientedata_pacienteapellidopaterno_Jsonclick = "" ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      subGridsdtmedicamentogriditems_Allowcollapsing = (byte)(0) ;
      subGridsdtmedicamentogriditems_Allowselection = (byte)(0) ;
      edtavSdtmedicamentogriditems__medicamentocantidad_Enabled = 0 ;
      edtavSdtmedicamentogriditems__medicamentonombre_Enabled = 0 ;
      edtavEliminarreceta_Enabled = 1 ;
      subGridsdtmedicamentogriditems_Header = "" ;
      subGridsdtmedicamentogriditems_Class = "GridNoBorder WorkWith" ;
      subGridsdtmedicamentogriditems_Backcolorstyle = (byte)(0) ;
      edtavMedicamentoindicaciones_Enabled = 1 ;
      edtavMedicamentocantidad_Jsonclick = "" ;
      edtavMedicamentocantidad_Enabled = 1 ;
      Combo_medicamentoid_Caption = "" ;
      bttBtnguardardigitalizacion_Visible = 1 ;
      edtavArchivoadjuntofullname_Jsonclick = "" ;
      edtavArchivoadjuntofullname_Enabled = 1 ;
      divTablearchivodata_Visible = 1 ;
      Adjuntararchivo_Tooltiptext = "" ;
      divTableadjuntararchivo_Visible = 1 ;
      edtavSdtmedicamentogriditems__medicamentocantidad_Enabled = -1 ;
      edtavSdtmedicamentogriditems__medicamentonombre_Enabled = -1 ;
      cmbavSdtcitadata_citatipodiagnostico.setEnabled( -1 );
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = -1 ;
      edtavSdtcitadata_citaestaturadescripcion_Enabled = -1 ;
      edtavSdtcitadata_citapesodescripcion_Enabled = -1 ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = -1 ;
      edtavSdtpacientedata_pacientenombres_Enabled = -1 ;
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = -1 ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = -1 ;
      edtavMedicamentoid_Jsonclick = "" ;
      edtavMedicamentoid_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Registrar Receta" );
      Gridsdtmedicamentogriditems_empowerer_Infinitescrolling = "Grid" ;
      Gxuitabspanel_tabs_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs_Class = "" ;
      Gxuitabspanel_tabs_Pagecount = 2 ;
      Dvpanel_panelbuton_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuton_Iconposition = "Right" ;
      Dvpanel_panelbuton_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuton_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuton_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelbuton_Title = "" ;
      Dvpanel_panelbuton_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelbuton_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelbuton_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelbuton_Width = "100%" ;
      Dvpanel_paneldetalle_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_paneldetalle_Iconposition = "Right" ;
      Dvpanel_paneldetalle_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_paneldetalle_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_paneldetalle_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_paneldetalle_Title = "" ;
      Dvpanel_paneldetalle_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_paneldetalle_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_paneldetalle_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_paneldetalle_Width = "100%" ;
      Adjuntararchivo_Maxnumberoffiles = 1 ;
      Adjuntararchivo_Enableuploadedfilecanceling = GXutil.toBoolean( -1) ;
      Adjuntararchivo_Hideadditionalbuttons = GXutil.toBoolean( -1) ;
      Adjuntararchivo_Autoupload = GXutil.toBoolean( -1) ;
      Dvpanel_tablefullwidth_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablefullwidth_Iconposition = "Right" ;
      Dvpanel_tablefullwidth_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablefullwidth_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablefullwidth_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tablefullwidth_Title = "" ;
      Dvpanel_tablefullwidth_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tablefullwidth_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablefullwidth_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablefullwidth_Width = "100%" ;
      Innewwindow1_Target = "" ;
      Innewwindow1_Height = "600" ;
      Innewwindow1_Width = "800" ;
      Combo_medicamentoid_Emptyitemtext = "Seleccione un medicamento" ;
      Combo_medicamentoid_Cls = "ExtendedCombo AttributeFormCustom" ;
      Dvpanel_informacionpaciente_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_informacionpaciente_Iconposition = "Right" ;
      Dvpanel_informacionpaciente_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_informacionpaciente_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_informacionpaciente_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_informacionpaciente_Title = "Información del Paciente" ;
      Dvpanel_informacionpaciente_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_informacionpaciente_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_informacionpaciente_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_informacionpaciente_Width = "100%" ;
      subGridsdtmedicamentogriditems_Rows = 50 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavSdtcitadata_citatipodiagnostico.setName( "SDTCITADATA_CITATIPODIAGNOSTICO" );
      cmbavSdtcitadata_citatipodiagnostico.setWebtags( "" );
      cmbavSdtcitadata_citatipodiagnostico.addItem("Prensuntivo", "Prensuntivo", (short)(0));
      cmbavSdtcitadata_citatipodiagnostico.addItem("Definitivo", "Definitivo", (short)(0));
      cmbavSdtcitadata_citatipodiagnostico.addItem("Repetitivo", "Repetitivo", (short)(0));
      if ( cmbavSdtcitadata_citatipodiagnostico.getItemCount() > 0 )
      {
         AV26SDTCitadata.setgxTv_SdtSDTCitaData_Citatipodiagnostico( cmbavSdtcitadata_citatipodiagnostico.getValidValue(AV26SDTCitadata.getgxTv_SdtSDTCitaData_Citatipodiagnostico()) );
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage'},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nEOF'},{av:'AV28SDTMedicamentoGridItems',fld:'vSDTMEDICAMENTOGRIDITEMS',grid:129,pic:''},{av:'nRC_GXsfl_129',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'GridRC',grid:129},{av:'subGridsdtmedicamentogriditems_Rows',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'Rows'},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDSDTMEDICAMENTOGRIDITEMS.LOAD","{handler:'e206F2',iparms:[]");
      setEventMetadata("GRIDSDTMEDICAMENTOGRIDITEMS.LOAD",",oparms:[{av:'AV12EliminarReceta',fld:'vELIMINARRECETA',pic:''}]}");
      setEventMetadata("'DODESCARGARARCHIVO'","{handler:'e116F2',iparms:[{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DODESCARGARARCHIVO'",",oparms:[]}");
      setEventMetadata("'DOENVIARARCHIVOPACIENTE'","{handler:'e126F2',iparms:[{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOENVIARARCHIVOPACIENTE'",",oparms:[]}");
      setEventMetadata("'DOSALIRDIGITALIZACION'","{handler:'e136F2',iparms:[]");
      setEventMetadata("'DOSALIRDIGITALIZACION'",",oparms:[]}");
      setEventMetadata("'DOGUARDARDIGITALIZACION'","{handler:'e146F2',iparms:[{av:'AV31UploadedFiles',fld:'vUPLOADEDFILES',pic:''},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOGUARDARDIGITALIZACION'",",oparms:[{av:'divTableadjuntararchivo_Visible',ctrl:'TABLEADJUNTARARCHIVO',prop:'Visible'},{ctrl:'BTNGUARDARDIGITALIZACION',prop:'Visible'},{av:'divTablearchivodata_Visible',ctrl:'TABLEARCHIVODATA',prop:'Visible'}]}");
      setEventMetadata("'DOELIMINARARCHIVO'","{handler:'e156F2',iparms:[{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOELIMINARARCHIVO'",",oparms:[{av:'divTableadjuntararchivo_Visible',ctrl:'TABLEADJUNTARARCHIVO',prop:'Visible'},{ctrl:'BTNGUARDARDIGITALIZACION',prop:'Visible'},{av:'divTablearchivodata_Visible',ctrl:'TABLEARCHIVODATA',prop:'Visible'}]}");
      setEventMetadata("'DOGUARDARRECETA'","{handler:'e166F2',iparms:[{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV28SDTMedicamentoGridItems',fld:'vSDTMEDICAMENTOGRIDITEMS',grid:129,pic:''},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage'},{av:'nRC_GXsfl_129',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'GridRC',grid:129}]");
      setEventMetadata("'DOGUARDARRECETA'",",oparms:[]}");
      setEventMetadata("'DOEXPORTARRECETAMEDICA'","{handler:'e226F1',iparms:[{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOEXPORTARRECETAMEDICA'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'}]}");
      setEventMetadata("'DOSALIR'","{handler:'e176F2',iparms:[]");
      setEventMetadata("'DOSALIR'",",oparms:[]}");
      setEventMetadata("'DOGUARDAR'","{handler:'e186F2',iparms:[{av:'AV21MedicamentOId',fld:'vMEDICAMENTOID',pic:'ZZZ9'},{av:'AV27SDTMedicamentoGridItem',fld:'vSDTMEDICAMENTOGRIDITEM',pic:''},{av:'AV20MedicamentoCantidad',fld:'vMEDICAMENTOCANTIDAD',pic:'ZZZ9'},{av:'AV24MedicamentoIndicaciones',fld:'vMEDICAMENTOINDICACIONES',pic:''},{av:'AV28SDTMedicamentoGridItems',fld:'vSDTMEDICAMENTOGRIDITEMS',grid:129,pic:''},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage'},{av:'nRC_GXsfl_129',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'GridRC',grid:129},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nEOF'},{av:'subGridsdtmedicamentogriditems_Rows',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'Rows'},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOGUARDAR'",",oparms:[{av:'AV27SDTMedicamentoGridItem',fld:'vSDTMEDICAMENTOGRIDITEM',pic:''},{av:'A40000MedicamentoNombre',fld:'MEDICAMENTONOMBRE',pic:''},{av:'AV28SDTMedicamentoGridItems',fld:'vSDTMEDICAMENTOGRIDITEMS',grid:129,pic:''},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage'},{av:'nRC_GXsfl_129',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'GridRC',grid:129},{av:'AV20MedicamentoCantidad',fld:'vMEDICAMENTOCANTIDAD',pic:'ZZZ9'},{av:'AV21MedicamentOId',fld:'vMEDICAMENTOID',pic:'ZZZ9'},{av:'AV24MedicamentoIndicaciones',fld:'vMEDICAMENTOINDICACIONES',pic:''},{av:'Combo_medicamentoid_Selectedvalue_set',ctrl:'COMBO_MEDICAMENTOID',prop:'SelectedValue_set'}]}");
      setEventMetadata("'DOLIMPIAR'","{handler:'e236F1',iparms:[]");
      setEventMetadata("'DOLIMPIAR'",",oparms:[{av:'AV20MedicamentoCantidad',fld:'vMEDICAMENTOCANTIDAD',pic:'ZZZ9'},{av:'AV21MedicamentOId',fld:'vMEDICAMENTOID',pic:'ZZZ9'},{av:'AV24MedicamentoIndicaciones',fld:'vMEDICAMENTOINDICACIONES',pic:''},{av:'Combo_medicamentoid_Selectedvalue_set',ctrl:'COMBO_MEDICAMENTOID',prop:'SelectedValue_set'}]}");
      setEventMetadata("VELIMINARRECETA.CLICK","{handler:'e216F2',iparms:[{av:'AV28SDTMedicamentoGridItems',fld:'vSDTMEDICAMENTOGRIDITEMS',grid:129,pic:''},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage'},{av:'nRC_GXsfl_129',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'GridRC',grid:129},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nEOF'},{av:'subGridsdtmedicamentogriditems_Rows',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'Rows'},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("VELIMINARRECETA.CLICK",",oparms:[{av:'AV27SDTMedicamentoGridItem',fld:'vSDTMEDICAMENTOGRIDITEM',pic:''},{av:'AV28SDTMedicamentoGridItems',fld:'vSDTMEDICAMENTOGRIDITEMS',grid:129,pic:''},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage'},{av:'nRC_GXsfl_129',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'GridRC',grid:129}]}");
      setEventMetadata("GRIDSDTMEDICAMENTOGRIDITEMS_FIRSTPAGE","{handler:'subgridsdtmedicamentogriditems_firstpage',iparms:[{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage'},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nEOF'},{av:'subGridsdtmedicamentogriditems_Rows',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'Rows'},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV28SDTMedicamentoGridItems',fld:'vSDTMEDICAMENTOGRIDITEMS',grid:129,pic:''},{av:'nRC_GXsfl_129',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'GridRC',grid:129}]");
      setEventMetadata("GRIDSDTMEDICAMENTOGRIDITEMS_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTMEDICAMENTOGRIDITEMS_PREVPAGE","{handler:'subgridsdtmedicamentogriditems_previouspage',iparms:[{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage'},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nEOF'},{av:'subGridsdtmedicamentogriditems_Rows',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'Rows'},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV28SDTMedicamentoGridItems',fld:'vSDTMEDICAMENTOGRIDITEMS',grid:129,pic:''},{av:'nRC_GXsfl_129',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'GridRC',grid:129}]");
      setEventMetadata("GRIDSDTMEDICAMENTOGRIDITEMS_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTMEDICAMENTOGRIDITEMS_NEXTPAGE","{handler:'subgridsdtmedicamentogriditems_nextpage',iparms:[{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage'},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nEOF'},{av:'subGridsdtmedicamentogriditems_Rows',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'Rows'},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV28SDTMedicamentoGridItems',fld:'vSDTMEDICAMENTOGRIDITEMS',grid:129,pic:''},{av:'nRC_GXsfl_129',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'GridRC',grid:129}]");
      setEventMetadata("GRIDSDTMEDICAMENTOGRIDITEMS_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDSDTMEDICAMENTOGRIDITEMS_LASTPAGE","{handler:'subgridsdtmedicamentogriditems_lastpage',iparms:[{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage'},{av:'GRIDSDTMEDICAMENTOGRIDITEMS_nEOF'},{av:'subGridsdtmedicamentogriditems_Rows',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'Rows'},{av:'AV5CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV28SDTMedicamentoGridItems',fld:'vSDTMEDICAMENTOGRIDITEMS',grid:129,pic:''},{av:'nRC_GXsfl_129',ctrl:'GRIDSDTMEDICAMENTOGRIDITEMS',prop:'GridRC',grid:129}]");
      setEventMetadata("GRIDSDTMEDICAMENTOGRIDITEMS_LASTPAGE",",oparms:[]}");
      setEventMetadata("VALIDV_GXV8","{handler:'validv_Gxv8',iparms:[]");
      setEventMetadata("VALIDV_GXV8",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv11',iparms:[]");
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
      Combo_medicamentoid_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Combo_medicamentoid_Selectedvalue_set = "" ;
      Gridsdtmedicamentogriditems_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV29SDTPacienteData = new com.projectthani.SdtSDTPacienteData(remoteHandle, context);
      AV26SDTCitadata = new com.projectthani.SdtSDTCitaData(remoteHandle, context);
      AV28SDTMedicamentoGridItems = new GXBaseCollection<com.projectthani.SdtSDTMedicamentoGridItem>(com.projectthani.SdtSDTMedicamentoGridItem.class, "SDTMedicamentoGridItem", "ProjectThani", remoteHandle);
      AV10DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV22MedicamentOId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV31UploadedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV13FailedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV27SDTMedicamentoGridItem = new com.projectthani.SdtSDTMedicamentoGridItem(remoteHandle, context);
      A40000MedicamentoNombre = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucGxuitabspanel_tabs = new com.genexus.webpanels.GXUserControl();
      lblTabgeneral_title_Jsonclick = "" ;
      ucDvpanel_informacionpaciente = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_tablefullwidth = new com.genexus.webpanels.GXUserControl();
      lblDigitalizacion_title_Jsonclick = "" ;
      ucDvpanel_paneldetalle = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panelbuton = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      bttBtndescargararchivo_Jsonclick = "" ;
      bttBtnenviararchivopaciente_Jsonclick = "" ;
      bttBtnsalirdigitalizacion_Jsonclick = "" ;
      ucMsgdvelop = new com.genexus.webpanels.GXUserControl();
      ucGridsdtmedicamentogriditems_empowerer = new com.genexus.webpanels.GXUserControl();
      GridsdtmedicamentogriditemsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV12EliminarReceta = "" ;
      GXCCtl = "" ;
      scmdbuf = "" ;
      H006F3_A40000MedicamentoNombre = new String[] {""} ;
      H006F3_n40000MedicamentoNombre = new boolean[] {false} ;
      AV24MedicamentoIndicaciones = "" ;
      AV8ArchivoAdjuntoFullName = "" ;
      GXt_SdtSDTCitaData1 = new com.projectthani.SdtSDTCitaData(remoteHandle, context);
      GXv_SdtSDTCitaData2 = new com.projectthani.SdtSDTCitaData[1] ;
      GXt_SdtSDTPacienteData3 = new com.projectthani.SdtSDTPacienteData(remoteHandle, context);
      GXv_SdtSDTPacienteData4 = new com.projectthani.SdtSDTPacienteData[1] ;
      H006F4_A50RecetaMedicaId = new short[1] ;
      H006F4_A19CitaId = new int[1] ;
      H006F4_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      H006F4_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      H006F4_A271RecetaArchivoTipo = new String[] {""} ;
      H006F4_A272RecetaMedicaFlag = new byte[1] ;
      H006F4_n272RecetaMedicaFlag = new boolean[] {false} ;
      H006F4_A270RecetaMedicaArchivo = new String[] {""} ;
      H006F4_n270RecetaMedicaArchivo = new boolean[] {false} ;
      H006F4_A269RecetaMedicaCantidad = new short[1] ;
      H006F4_n269RecetaMedicaCantidad = new boolean[] {false} ;
      H006F4_A42MedicamentoId = new short[1] ;
      H006F4_n42MedicamentoId = new boolean[] {false} ;
      H006F4_A332RecetaIndicaciones = new String[] {""} ;
      H006F4_A230MedicamentoNombre = new String[] {""} ;
      A267RecetaMedicaNombreArchivo = "" ;
      A270RecetaMedicaArchivo_Filename = "" ;
      A271RecetaArchivoTipo = "" ;
      A270RecetaMedicaArchivo_Filetype = "" ;
      A270RecetaMedicaArchivo = "" ;
      A332RecetaIndicaciones = "" ;
      A230MedicamentoNombre = "" ;
      AV7ArchivoAdjuntoBlob = "" ;
      AV33ArchivoExtension = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GridsdtmedicamentogriditemsRow = new com.genexus.webpanels.GXWebRow();
      AV39FileReceta = "" ;
      AV36FileName = "" ;
      AV37FileExtencion = "" ;
      GXv_boolean7 = new boolean[1] ;
      H006F6_A40000MedicamentoNombre = new String[] {""} ;
      H006F6_n40000MedicamentoNombre = new boolean[] {false} ;
      ucCombo_medicamentoid = new com.genexus.webpanels.GXUserControl();
      AV55GXV12 = new GXBaseCollection<com.projectthani.SdtSDTMedicamentoData>(com.projectthani.SdtSDTMedicamentoData.class, "SDTMedicamentoData", "ProjectThani", remoteHandle);
      GXt_objcol_SdtSDTMedicamentoData8 = new GXBaseCollection<com.projectthani.SdtSDTMedicamentoData>(com.projectthani.SdtSDTMedicamentoData.class, "SDTMedicamentoData", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTMedicamentoData9 = new GXBaseCollection[1] ;
      AV23MedicamentOId_DPItem = new com.projectthani.SdtSDTMedicamentoData(remoteHandle, context);
      AV9Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      ucAdjuntararchivo = new com.genexus.webpanels.GXUserControl();
      bttBtnguardardigitalizacion_Jsonclick = "" ;
      bttBtneliminararchivo_Jsonclick = "" ;
      lblTextblockcombo_medicamentoid_Jsonclick = "" ;
      lblTextblockmedicamentoindicaciones_Jsonclick = "" ;
      subGridsdtmedicamentogriditems_Linesclass = "" ;
      GridsdtmedicamentogriditemsColumn = new com.genexus.webpanels.GXWebColumn();
      bttBtnguardarreceta_Jsonclick = "" ;
      bttBtnexportarrecetamedica_Jsonclick = "" ;
      bttBtnsalir_Jsonclick = "" ;
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      bttBtnguardar_Jsonclick = "" ;
      bttBtnlimpiar_Jsonclick = "" ;
      lblTextblocksdtpacientedata_pacienteapellidopaterno_Jsonclick = "" ;
      lblTextblocksdtpacientedata_pacienteapellidomaterno_Jsonclick = "" ;
      lblTextblocksdtpacientedata_pacientenombres_Jsonclick = "" ;
      lblTextblocksdtpacientedata_pacientefechanacimientodescripcion_Jsonclick = "" ;
      lblTextblocksdtcitadata_citapesodescripcion_Jsonclick = "" ;
      lblTextblocksdtcitadata_citaestaturadescripcion_Jsonclick = "" ;
      lblTextblocksdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick = "" ;
      lblTextblocksdtcitadata_citatipodiagnostico_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpregistrarreceta__default(),
         new Object[] {
             new Object[] {
            H006F3_A40000MedicamentoNombre, H006F3_n40000MedicamentoNombre
            }
            , new Object[] {
            H006F4_A50RecetaMedicaId, H006F4_A19CitaId, H006F4_A267RecetaMedicaNombreArchivo, H006F4_n267RecetaMedicaNombreArchivo, H006F4_A271RecetaArchivoTipo, H006F4_A272RecetaMedicaFlag, H006F4_n272RecetaMedicaFlag, H006F4_A270RecetaMedicaArchivo, H006F4_n270RecetaMedicaArchivo, H006F4_A269RecetaMedicaCantidad,
            H006F4_n269RecetaMedicaCantidad, H006F4_A42MedicamentoId, H006F4_n42MedicamentoId, H006F4_A332RecetaIndicaciones, H006F4_A230MedicamentoNombre
            }
            , new Object[] {
            H006F6_A40000MedicamentoNombre, H006F6_n40000MedicamentoNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavSdtpacientedata_pacienteapellidopaterno_Enabled = 0 ;
      edtavSdtpacientedata_pacienteapellidomaterno_Enabled = 0 ;
      edtavSdtpacientedata_pacientenombres_Enabled = 0 ;
      edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled = 0 ;
      edtavSdtcitadata_citapesodescripcion_Enabled = 0 ;
      edtavSdtcitadata_citaestaturadescripcion_Enabled = 0 ;
      edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled = 0 ;
      cmbavSdtcitadata_citatipodiagnostico.setEnabled( 0 );
      edtavEliminarreceta_Enabled = 0 ;
      edtavSdtmedicamentogriditems__medicamentonombre_Enabled = 0 ;
      edtavSdtmedicamentogriditems__medicamentocantidad_Enabled = 0 ;
      edtavArchivoadjuntofullname_Enabled = 0 ;
   }

   private byte GRIDSDTMEDICAMENTOGRIDITEMS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGridsdtmedicamentogriditems_Backcolorstyle ;
   private byte A272RecetaMedicaFlag ;
   private byte subGridsdtmedicamentogriditems_Titlebackstyle ;
   private byte subGridsdtmedicamentogriditems_Allowselection ;
   private byte subGridsdtmedicamentogriditems_Allowhovering ;
   private byte subGridsdtmedicamentogriditems_Allowcollapsing ;
   private byte subGridsdtmedicamentogriditems_Collapsed ;
   private byte nGXWrapped ;
   private byte subGridsdtmedicamentogriditems_Backstyle ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short AV21MedicamentOId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV20MedicamentoCantidad ;
   private short A269RecetaMedicaCantidad ;
   private short A42MedicamentoId ;
   private short AV18i ;
   private int wcpOAV5CitaId ;
   private int nRC_GXsfl_129 ;
   private int nGXsfl_129_idx=1 ;
   private int subGridsdtmedicamentogriditems_Rows ;
   private int AV5CitaId ;
   private int Adjuntararchivo_Maxnumberoffiles ;
   private int Gxuitabspanel_tabs_Pagecount ;
   private int edtavMedicamentoid_Visible ;
   private int AV51GXV9 ;
   private int subGridsdtmedicamentogriditems_Islastpage ;
   private int edtavSdtpacientedata_pacienteapellidopaterno_Enabled ;
   private int edtavSdtpacientedata_pacienteapellidomaterno_Enabled ;
   private int edtavSdtpacientedata_pacientenombres_Enabled ;
   private int edtavSdtpacientedata_pacientefechanacimientodescripcion_Enabled ;
   private int edtavSdtcitadata_citapesodescripcion_Enabled ;
   private int edtavSdtcitadata_citaestaturadescripcion_Enabled ;
   private int edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Enabled ;
   private int edtavEliminarreceta_Enabled ;
   private int edtavSdtmedicamentogriditems__medicamentonombre_Enabled ;
   private int edtavSdtmedicamentogriditems__medicamentocantidad_Enabled ;
   private int edtavArchivoadjuntofullname_Enabled ;
   private int GRIDSDTMEDICAMENTOGRIDITEMS_nGridOutOfScope ;
   private int nGXsfl_129_fel_idx=1 ;
   private int divTablearchivodata_Visible ;
   private int A19CitaId ;
   private int divTableadjuntararchivo_Visible ;
   private int bttBtnguardardigitalizacion_Visible ;
   private int nGXsfl_129_bak_idx=1 ;
   private int AV56GXV13 ;
   private int edtavMedicamentocantidad_Enabled ;
   private int edtavMedicamentoindicaciones_Enabled ;
   private int subGridsdtmedicamentogriditems_Titlebackcolor ;
   private int subGridsdtmedicamentogriditems_Allbackcolor ;
   private int subGridsdtmedicamentogriditems_Selectedindex ;
   private int subGridsdtmedicamentogriditems_Selectioncolor ;
   private int subGridsdtmedicamentogriditems_Hoveringcolor ;
   private int idxLst ;
   private int subGridsdtmedicamentogriditems_Backcolor ;
   private int edtavEliminarreceta_Visible ;
   private long GRIDSDTMEDICAMENTOGRIDITEMS_nFirstRecordOnPage ;
   private long GRIDSDTMEDICAMENTOGRIDITEMS_nCurrentRecord ;
   private long GRIDSDTMEDICAMENTOGRIDITEMS_nRecordCount ;
   private String Combo_medicamentoid_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_129_idx="0001" ;
   private String Dvpanel_informacionpaciente_Width ;
   private String Dvpanel_informacionpaciente_Cls ;
   private String Dvpanel_informacionpaciente_Title ;
   private String Dvpanel_informacionpaciente_Iconposition ;
   private String Combo_medicamentoid_Cls ;
   private String Combo_medicamentoid_Selectedvalue_set ;
   private String Combo_medicamentoid_Emptyitemtext ;
   private String Innewwindow1_Width ;
   private String Innewwindow1_Height ;
   private String Innewwindow1_Target ;
   private String Dvpanel_tablefullwidth_Width ;
   private String Dvpanel_tablefullwidth_Cls ;
   private String Dvpanel_tablefullwidth_Title ;
   private String Dvpanel_tablefullwidth_Iconposition ;
   private String Dvpanel_paneldetalle_Width ;
   private String Dvpanel_paneldetalle_Cls ;
   private String Dvpanel_paneldetalle_Title ;
   private String Dvpanel_paneldetalle_Iconposition ;
   private String Dvpanel_panelbuton_Width ;
   private String Dvpanel_panelbuton_Cls ;
   private String Dvpanel_panelbuton_Title ;
   private String Dvpanel_panelbuton_Iconposition ;
   private String Gxuitabspanel_tabs_Class ;
   private String Gridsdtmedicamentogriditems_empowerer_Gridinternalname ;
   private String Gridsdtmedicamentogriditems_empowerer_Infinitescrolling ;
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
   private String Gxuitabspanel_tabs_Internalname ;
   private String lblTabgeneral_title_Internalname ;
   private String lblTabgeneral_title_Jsonclick ;
   private String divTableattributes_Internalname ;
   private String Dvpanel_informacionpaciente_Internalname ;
   private String Dvpanel_tablefullwidth_Internalname ;
   private String lblDigitalizacion_title_Internalname ;
   private String lblDigitalizacion_title_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String Dvpanel_paneldetalle_Internalname ;
   private String Dvpanel_panelbuton_Internalname ;
   private String divPanelbuton_Internalname ;
   private String TempTags ;
   private String bttBtndescargararchivo_Internalname ;
   private String bttBtndescargararchivo_Jsonclick ;
   private String bttBtnenviararchivopaciente_Internalname ;
   private String bttBtnenviararchivopaciente_Jsonclick ;
   private String bttBtnsalirdigitalizacion_Internalname ;
   private String bttBtnsalirdigitalizacion_Jsonclick ;
   private String Msgdvelop_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavMedicamentoid_Internalname ;
   private String edtavMedicamentoid_Jsonclick ;
   private String Gridsdtmedicamentogriditems_empowerer_Internalname ;
   private String sStyleString ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavEliminarreceta_Internalname ;
   private String edtavSdtpacientedata_pacienteapellidopaterno_Internalname ;
   private String GXCCtl ;
   private String edtavSdtpacientedata_pacienteapellidomaterno_Internalname ;
   private String edtavSdtpacientedata_pacientenombres_Internalname ;
   private String edtavSdtpacientedata_pacientefechanacimientodescripcion_Internalname ;
   private String edtavSdtcitadata_citapesodescripcion_Internalname ;
   private String edtavSdtcitadata_citaestaturadescripcion_Internalname ;
   private String edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname ;
   private String edtavSdtmedicamentogriditems__medicamentonombre_Internalname ;
   private String edtavSdtmedicamentogriditems__medicamentocantidad_Internalname ;
   private String edtavArchivoadjuntofullname_Internalname ;
   private String scmdbuf ;
   private String sGXsfl_129_fel_idx="0001" ;
   private String edtavMedicamentocantidad_Internalname ;
   private String edtavMedicamentoindicaciones_Internalname ;
   private String divTablearchivodata_Internalname ;
   private String A270RecetaMedicaArchivo_Filename ;
   private String A270RecetaMedicaArchivo_Filetype ;
   private String divTableadjuntararchivo_Internalname ;
   private String bttBtnguardardigitalizacion_Internalname ;
   private String subGridsdtmedicamentogriditems_Internalname ;
   private String Combo_medicamentoid_Internalname ;
   private String tblPaneldetalle_Internalname ;
   private String Adjuntararchivo_Tooltiptext ;
   private String Adjuntararchivo_Internalname ;
   private String edtavArchivoadjuntofullname_Jsonclick ;
   private String divTablebtn_Internalname ;
   private String bttBtnguardardigitalizacion_Jsonclick ;
   private String bttBtneliminararchivo_Internalname ;
   private String bttBtneliminararchivo_Jsonclick ;
   private String tblTablefullwidth_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String divTablesplittedmedicamentoid_Internalname ;
   private String lblTextblockcombo_medicamentoid_Internalname ;
   private String lblTextblockcombo_medicamentoid_Jsonclick ;
   private String Combo_medicamentoid_Caption ;
   private String edtavMedicamentocantidad_Jsonclick ;
   private String divUnnamedtablemedicamentoindicaciones_Internalname ;
   private String lblTextblockmedicamentoindicaciones_Internalname ;
   private String lblTextblockmedicamentoindicaciones_Jsonclick ;
   private String subGridsdtmedicamentogriditems_Class ;
   private String subGridsdtmedicamentogriditems_Linesclass ;
   private String subGridsdtmedicamentogriditems_Header ;
   private String divUnnamedtable4_Internalname ;
   private String bttBtnguardarreceta_Internalname ;
   private String bttBtnguardarreceta_Jsonclick ;
   private String bttBtnexportarrecetamedica_Internalname ;
   private String bttBtnexportarrecetamedica_Jsonclick ;
   private String bttBtnsalir_Internalname ;
   private String bttBtnsalir_Jsonclick ;
   private String Innewwindow1_Internalname ;
   private String tblUnnamedtable3_Internalname ;
   private String bttBtnguardar_Internalname ;
   private String bttBtnguardar_Jsonclick ;
   private String bttBtnlimpiar_Internalname ;
   private String bttBtnlimpiar_Jsonclick ;
   private String tblInformacionpaciente_Internalname ;
   private String divUnnamedtablesdtpacientedata_pacienteapellidopaterno_Internalname ;
   private String lblTextblocksdtpacientedata_pacienteapellidopaterno_Internalname ;
   private String lblTextblocksdtpacientedata_pacienteapellidopaterno_Jsonclick ;
   private String edtavSdtpacientedata_pacienteapellidopaterno_Jsonclick ;
   private String divUnnamedtablesdtpacientedata_pacienteapellidomaterno_Internalname ;
   private String lblTextblocksdtpacientedata_pacienteapellidomaterno_Internalname ;
   private String lblTextblocksdtpacientedata_pacienteapellidomaterno_Jsonclick ;
   private String edtavSdtpacientedata_pacienteapellidomaterno_Jsonclick ;
   private String divUnnamedtablesdtpacientedata_pacientenombres_Internalname ;
   private String lblTextblocksdtpacientedata_pacientenombres_Internalname ;
   private String lblTextblocksdtpacientedata_pacientenombres_Jsonclick ;
   private String edtavSdtpacientedata_pacientenombres_Jsonclick ;
   private String divUnnamedtablesdtpacientedata_pacientefechanacimientodescripcion_Internalname ;
   private String lblTextblocksdtpacientedata_pacientefechanacimientodescripcion_Internalname ;
   private String lblTextblocksdtpacientedata_pacientefechanacimientodescripcion_Jsonclick ;
   private String edtavSdtpacientedata_pacientefechanacimientodescripcion_Jsonclick ;
   private String divUnnamedtablesdtcitadata_citapesodescripcion_Internalname ;
   private String lblTextblocksdtcitadata_citapesodescripcion_Internalname ;
   private String lblTextblocksdtcitadata_citapesodescripcion_Jsonclick ;
   private String edtavSdtcitadata_citapesodescripcion_Jsonclick ;
   private String divUnnamedtablesdtcitadata_citaestaturadescripcion_Internalname ;
   private String lblTextblocksdtcitadata_citaestaturadescripcion_Internalname ;
   private String lblTextblocksdtcitadata_citaestaturadescripcion_Jsonclick ;
   private String edtavSdtcitadata_citaestaturadescripcion_Jsonclick ;
   private String divUnnamedtablesdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname ;
   private String lblTextblocksdtcitadata_sgcitadisponibilidadespecialidadnombre_Internalname ;
   private String lblTextblocksdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick ;
   private String edtavSdtcitadata_sgcitadisponibilidadespecialidadnombre_Jsonclick ;
   private String divUnnamedtablesdtcitadata_citatipodiagnostico_Internalname ;
   private String lblTextblocksdtcitadata_citatipodiagnostico_Internalname ;
   private String lblTextblocksdtcitadata_citatipodiagnostico_Jsonclick ;
   private String ROClassString ;
   private String edtavEliminarreceta_Jsonclick ;
   private String edtavSdtmedicamentogriditems__medicamentonombre_Jsonclick ;
   private String edtavSdtmedicamentogriditems__medicamentocantidad_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_informacionpaciente_Autowidth ;
   private boolean Dvpanel_informacionpaciente_Autoheight ;
   private boolean Dvpanel_informacionpaciente_Collapsible ;
   private boolean Dvpanel_informacionpaciente_Collapsed ;
   private boolean Dvpanel_informacionpaciente_Showcollapseicon ;
   private boolean Dvpanel_informacionpaciente_Autoscroll ;
   private boolean Dvpanel_tablefullwidth_Autowidth ;
   private boolean Dvpanel_tablefullwidth_Autoheight ;
   private boolean Dvpanel_tablefullwidth_Collapsible ;
   private boolean Dvpanel_tablefullwidth_Collapsed ;
   private boolean Dvpanel_tablefullwidth_Showcollapseicon ;
   private boolean Dvpanel_tablefullwidth_Autoscroll ;
   private boolean Adjuntararchivo_Autoupload ;
   private boolean Adjuntararchivo_Hideadditionalbuttons ;
   private boolean Adjuntararchivo_Enableuploadedfilecanceling ;
   private boolean Dvpanel_paneldetalle_Autowidth ;
   private boolean Dvpanel_paneldetalle_Autoheight ;
   private boolean Dvpanel_paneldetalle_Collapsible ;
   private boolean Dvpanel_paneldetalle_Collapsed ;
   private boolean Dvpanel_paneldetalle_Showcollapseicon ;
   private boolean Dvpanel_paneldetalle_Autoscroll ;
   private boolean Dvpanel_panelbuton_Autowidth ;
   private boolean Dvpanel_panelbuton_Autoheight ;
   private boolean Dvpanel_panelbuton_Collapsible ;
   private boolean Dvpanel_panelbuton_Collapsed ;
   private boolean Dvpanel_panelbuton_Showcollapseicon ;
   private boolean Dvpanel_panelbuton_Autoscroll ;
   private boolean Gxuitabspanel_tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_129_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000MedicamentoNombre ;
   private boolean returnInSub ;
   private boolean gx_BV129 ;
   private boolean n267RecetaMedicaNombreArchivo ;
   private boolean n272RecetaMedicaFlag ;
   private boolean n270RecetaMedicaArchivo ;
   private boolean n269RecetaMedicaCantidad ;
   private boolean n42MedicamentoId ;
   private boolean AV40isVal ;
   private boolean AV6isSaved ;
   private boolean GXv_boolean7[] ;
   private String A270RecetaMedicaArchivo ;
   private String AV7ArchivoAdjuntoBlob ;
   private String AV39FileReceta ;
   private String A40000MedicamentoNombre ;
   private String AV12EliminarReceta ;
   private String AV24MedicamentoIndicaciones ;
   private String AV8ArchivoAdjuntoFullName ;
   private String A267RecetaMedicaNombreArchivo ;
   private String A271RecetaArchivoTipo ;
   private String A332RecetaIndicaciones ;
   private String A230MedicamentoNombre ;
   private String AV33ArchivoExtension ;
   private String AV36FileName ;
   private String AV37FileExtencion ;
   private com.genexus.webpanels.GXWebGrid GridsdtmedicamentogriditemsContainer ;
   private com.genexus.webpanels.GXWebRow GridsdtmedicamentogriditemsRow ;
   private com.genexus.webpanels.GXWebColumn GridsdtmedicamentogriditemsColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_informacionpaciente ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablefullwidth ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_paneldetalle ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelbuton ;
   private com.genexus.webpanels.GXUserControl ucMsgdvelop ;
   private com.genexus.webpanels.GXUserControl ucGridsdtmedicamentogriditems_empowerer ;
   private com.genexus.webpanels.GXUserControl ucCombo_medicamentoid ;
   private com.genexus.webpanels.GXUserControl ucAdjuntararchivo ;
   private com.genexus.webpanels.GXUserControl ucInnewwindow1 ;
   private HTMLChoice cmbavSdtcitadata_citatipodiagnostico ;
   private IDataStoreProvider pr_default ;
   private String[] H006F3_A40000MedicamentoNombre ;
   private boolean[] H006F3_n40000MedicamentoNombre ;
   private short[] H006F4_A50RecetaMedicaId ;
   private int[] H006F4_A19CitaId ;
   private String[] H006F4_A267RecetaMedicaNombreArchivo ;
   private boolean[] H006F4_n267RecetaMedicaNombreArchivo ;
   private String[] H006F4_A271RecetaArchivoTipo ;
   private byte[] H006F4_A272RecetaMedicaFlag ;
   private boolean[] H006F4_n272RecetaMedicaFlag ;
   private String[] H006F4_A270RecetaMedicaArchivo ;
   private boolean[] H006F4_n270RecetaMedicaArchivo ;
   private short[] H006F4_A269RecetaMedicaCantidad ;
   private boolean[] H006F4_n269RecetaMedicaCantidad ;
   private short[] H006F4_A42MedicamentoId ;
   private boolean[] H006F4_n42MedicamentoId ;
   private String[] H006F4_A332RecetaIndicaciones ;
   private String[] H006F4_A230MedicamentoNombre ;
   private String[] H006F6_A40000MedicamentoNombre ;
   private boolean[] H006F6_n40000MedicamentoNombre ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV22MedicamentOId_Data ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV31UploadedFiles ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV13FailedFiles ;
   private GXBaseCollection<com.projectthani.SdtSDTMedicamentoData> AV55GXV12 ;
   private GXBaseCollection<com.projectthani.SdtSDTMedicamentoData> GXt_objcol_SdtSDTMedicamentoData8 ;
   private GXBaseCollection<com.projectthani.SdtSDTMedicamentoData> GXv_objcol_SdtSDTMedicamentoData9[] ;
   private GXBaseCollection<com.projectthani.SdtSDTMedicamentoGridItem> AV28SDTMedicamentoGridItems ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV9Combo_DataItem ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV10DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
   private com.projectthani.SdtSDTMedicamentoData AV23MedicamentOId_DPItem ;
   private com.projectthani.SdtSDTCitaData AV26SDTCitadata ;
   private com.projectthani.SdtSDTCitaData GXt_SdtSDTCitaData1 ;
   private com.projectthani.SdtSDTCitaData GXv_SdtSDTCitaData2[] ;
   private com.projectthani.SdtSDTMedicamentoGridItem AV27SDTMedicamentoGridItem ;
   private com.projectthani.SdtSDTPacienteData AV29SDTPacienteData ;
   private com.projectthani.SdtSDTPacienteData GXt_SdtSDTPacienteData3 ;
   private com.projectthani.SdtSDTPacienteData GXv_SdtSDTPacienteData4[] ;
}

final  class wpregistrarreceta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006F3", "SELECT COALESCE( T1.[MedicamentoNombre], '') AS MedicamentoNombre FROM (SELECT [MedicamentoNombre] AS MedicamentoNombre, [MedicamentoId] FROM [Medicamento] WHERE [MedicamentoId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006F4", "SELECT T1.[RecetaMedicaId], T1.[CitaId], T1.[RecetaMedicaNombreArchivo], T1.[RecetaArchivoTipo], T1.[RecetaMedicaFlag], T1.[RecetaMedicaArchivo], T1.[RecetaMedicaCantidad], T1.[MedicamentoId], T1.[RecetaIndicaciones], T2.[MedicamentoNombre] FROM ([RecetaMedica] T1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId] = T1.[MedicamentoId]) WHERE T1.[CitaId] = ? ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006F6", "SELECT COALESCE( T1.[MedicamentoNombre], '') AS MedicamentoNombre FROM (SELECT [MedicamentoNombre] AS MedicamentoNombre, [MedicamentoId] FROM [Medicamento] WHERE [MedicamentoId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getBLOBFile(6, rslt.getVarchar(4), rslt.getVarchar(3));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((short[]) buf[11])[0] = rslt.getShort(8);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((String[]) buf[14])[0] = rslt.getVarchar(10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

