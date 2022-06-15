package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class exportoptions_impl extends GXDataArea
{
   public exportoptions_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public exportoptions_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( exportoptions_impl.class ));
   }

   public exportoptions_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV12ExcelFileName = (String) args[0];
         AV9DefaultTitle = (String) args[1];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
      cmbavExporttype = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "ExcelFileName") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "ExcelFileName") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "ExcelFileName") ;
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
            AV12ExcelFileName = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12ExcelFileName", AV12ExcelFileName);
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEXCELFILENAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12ExcelFileName, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV9DefaultTitle = httpContext.GetPar( "DefaultTitle") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9DefaultTitle", AV9DefaultTitle);
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTTITLE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9DefaultTitle, ""))));
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
      pa0C2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0C2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033959", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormNoBackgroundColor\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.exportoptions", new String[] {GXutil.URLEncode(GXutil.rtrim(AV12ExcelFileName)),GXutil.URLEncode(GXutil.rtrim(AV9DefaultTitle))}, new String[] {"ExcelFileName","DefaultTitle"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormNoBackgroundColor", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOOGLEDOCRESULTXML", getSecureSignedToken( "", AV14GoogleDocResultXML));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEXCELFILENAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12ExcelFileName, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTTITLE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9DefaultTitle, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGOOGLEDOCRESULTXML", AV14GoogleDocResultXML);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOOGLEDOCRESULTXML", getSecureSignedToken( "", AV14GoogleDocResultXML));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vEXCELFILENAME", AV12ExcelFileName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEXCELFILENAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12ExcelFileName, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDEFAULTTITLE", GXutil.rtrim( AV9DefaultTitle));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTTITLE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9DefaultTitle, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEEXPORT_Width", GXutil.rtrim( Dvpanel_tableexport_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEEXPORT_Autowidth", GXutil.booltostr( Dvpanel_tableexport_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEEXPORT_Autoheight", GXutil.booltostr( Dvpanel_tableexport_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEEXPORT_Cls", GXutil.rtrim( Dvpanel_tableexport_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEEXPORT_Title", GXutil.rtrim( Dvpanel_tableexport_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEEXPORT_Collapsible", GXutil.booltostr( Dvpanel_tableexport_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEEXPORT_Collapsed", GXutil.booltostr( Dvpanel_tableexport_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEEXPORT_Showcollapseicon", GXutil.booltostr( Dvpanel_tableexport_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEEXPORT_Iconposition", GXutil.rtrim( Dvpanel_tableexport_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEEXPORT_Autoscroll", GXutil.booltostr( Dvpanel_tableexport_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Width", GXutil.rtrim( Innewwindow1_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Height", GXutil.rtrim( Innewwindow1_Height));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Target", GXutil.rtrim( Innewwindow1_Target));
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormNoBackgroundColor" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we0C2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0C2( ) ;
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
      return formatLink("com.projectthani.wwpbaseobjects.exportoptions", new String[] {GXutil.URLEncode(GXutil.rtrim(AV12ExcelFileName)),GXutil.URLEncode(GXutil.rtrim(AV9DefaultTitle))}, new String[] {"ExcelFileName","DefaultTitle"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.ExportOptions" ;
   }

   public String getPgmdesc( )
   {
      return "Opciones para Exportar a Excel" ;
   }

   public void wb0C0( )
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
         wb_table1_6_0C2( true) ;
      }
      else
      {
         wb_table1_6_0C2( false) ;
      }
      return  ;
   }

   public void wb_table1_6_0C2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start0C2( )
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
         Form.getMeta().addItem("description", "Opciones para Exportar a Excel", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0C0( ) ;
   }

   public void ws0C2( )
   {
      start0C2( ) ;
      evt0C2( ) ;
   }

   public void evt0C2( )
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e110C2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DODOWNLOADTOFILE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoDownloadToFile' */
                           e120C2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOSAVEGOOGLEDRIVE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoSaveGoogleDrive' */
                           e130C2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e140C2 ();
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
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we0C2( )
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

   public void pa0C2( )
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
            GX_FocusControl = cmbavExporttype.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
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
      if ( cmbavExporttype.getItemCount() > 0 )
      {
         AV13ExportType = (byte)(GXutil.lval( cmbavExporttype.getValidValue(GXutil.trim( GXutil.str( AV13ExportType, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13ExportType", GXutil.str( AV13ExportType, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavExporttype.setValue( GXutil.trim( GXutil.str( AV13ExportType, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavExporttype.getInternalname(), "Values", cmbavExporttype.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf0C2( ) ;
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
   }

   public void rf0C2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e140C2 ();
         wb0C0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0C2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGOOGLEDOCRESULTXML", AV14GoogleDocResultXML);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOOGLEDOCRESULTXML", getSecureSignedToken( "", AV14GoogleDocResultXML));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0C0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110C2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Dvpanel_tableexport_Width = httpContext.cgiGet( "DVPANEL_TABLEEXPORT_Width") ;
         Dvpanel_tableexport_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEEXPORT_Autowidth")) ;
         Dvpanel_tableexport_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEEXPORT_Autoheight")) ;
         Dvpanel_tableexport_Cls = httpContext.cgiGet( "DVPANEL_TABLEEXPORT_Cls") ;
         Dvpanel_tableexport_Title = httpContext.cgiGet( "DVPANEL_TABLEEXPORT_Title") ;
         Dvpanel_tableexport_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEEXPORT_Collapsible")) ;
         Dvpanel_tableexport_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEEXPORT_Collapsed")) ;
         Dvpanel_tableexport_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEEXPORT_Showcollapseicon")) ;
         Dvpanel_tableexport_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEEXPORT_Iconposition") ;
         Dvpanel_tableexport_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEEXPORT_Autoscroll")) ;
         Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
         Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
         Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
         Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
         Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
         Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
         Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
         Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
         Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
         Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
         Innewwindow1_Width = httpContext.cgiGet( "INNEWWINDOW1_Width") ;
         Innewwindow1_Height = httpContext.cgiGet( "INNEWWINDOW1_Height") ;
         Innewwindow1_Target = httpContext.cgiGet( "INNEWWINDOW1_Target") ;
         /* Read variables values. */
         cmbavExporttype.setValue( httpContext.cgiGet( cmbavExporttype.getInternalname()) );
         AV13ExportType = (byte)(GXutil.lval( httpContext.cgiGet( cmbavExporttype.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13ExportType", GXutil.str( AV13ExportType, 1, 0));
         AV22User = httpContext.cgiGet( edtavUser_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22User", AV22User);
         AV5DocTitle = httpContext.cgiGet( edtavDoctitle_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5DocTitle", AV5DocTitle);
         AV20Password = httpContext.cgiGet( edtavPassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Password", AV20Password);
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
      e110C2 ();
      if (returnInSub) return;
   }

   public void e110C2( )
   {
      /* Start Routine */
      returnInSub = false ;
      tblTablecontent_Height = 388 ;
      httpContext.ajax_rsp_assign_prop("", false, tblTablecontent_Internalname, "Height", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablecontent_Height), 9, 0), true);
      AV5DocTitle = AV9DefaultTitle ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5DocTitle", AV5DocTitle);
      AV5DocTitle = AV9DefaultTitle ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5DocTitle", AV5DocTitle);
      edtavPassword_Ispassword = (byte)(1) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavPassword_Internalname, "Ispassword", GXutil.str( edtavPassword_Ispassword, 1, 0), true);
      if ( GXutil.strcmp(AV16HttpRequest.getMethod(), "GET") == 0 )
      {
         tblTablegoogledriveinfo_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblTablegoogledriveinfo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablegoogledriveinfo_Visible), 5, 0), true);
         bttBtnsavegoogledrive_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnsavegoogledrive_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnsavegoogledrive_Visible), 5, 0), true);
      }
      AV21URL = formatLink(AV12ExcelFileName, new String[] {}, new String[] {})  ;
      bttBtndownloadtofile_Jsonclick = "exportActionDownloadFile('"+AV21URL+"')" ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtndownloadtofile_Internalname, "Jsonclick", bttBtndownloadtofile_Jsonclick, true);
      lblJs_Caption = "<script type=\"text/javascript\">function exportActionDownloadFile(u) { var element = document.createElement(\"iframe\"); element.setAttribute(\"src\", u);document.body.appendChild(element); return true; }</script>" ;
      httpContext.ajax_rsp_assign_prop("", false, lblJs_Internalname, "Caption", lblJs_Caption, true);
      tblTablecontent_Width = 560 ;
      httpContext.ajax_rsp_assign_prop("", false, tblTablecontent_Internalname, "Width", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablecontent_Width), 9, 0), true);
      tblTablecontent_Height = 386 ;
      httpContext.ajax_rsp_assign_prop("", false, tblTablecontent_Internalname, "Height", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablecontent_Height), 9, 0), true);
   }

   public void e120C2( )
   {
      /* 'DoDownloadToFile' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void e130C2( )
   {
      /* 'DoSaveGoogleDrive' Routine */
      returnInSub = false ;
      AV15GoogleDocsResult.fromxml(AV14GoogleDocResultXML, null, null);
      if ( AV15GoogleDocsResult.getgxTv_SdtGoogleDocsResult_Success() )
      {
         Innewwindow1_Target = ((com.projectthani.wwpbaseobjects.SdtGoogleDocsResult_Doc)AV15GoogleDocsResult.getgxTv_SdtGoogleDocsResult_Docs().elementAt(-1+1)).getgxTv_SdtGoogleDocsResult_Doc_Url() ;
         ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
         Innewwindow1_Height = "600" ;
         ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
         Innewwindow1_Width = "800" ;
         ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
         this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
         httpContext.GX_msglist.addItem("The document was succesully uploaded to Google Drive");
         bttBtncancel_Caption = "Cerrar" ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtncancel_Internalname, "Caption", bttBtncancel_Caption, true);
         tblTablecontent_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblTablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablecontent_Visible), 5, 0), true);
         bttBtndownloadtofile_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtndownloadtofile_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndownloadtofile_Visible), 5, 0), true);
         bttBtnsavegoogledrive_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnsavegoogledrive_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnsavegoogledrive_Visible), 5, 0), true);
      }
      else
      {
         httpContext.GX_msglist.addItem("Error uploading Spreadsheet:  "+AV15GoogleDocsResult.getgxTv_SdtGoogleDocsResult_Error());
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e140C2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_6_0C2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemain_Internalname, tblTablemain_Internalname, "", "TableMainTransaction", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblJs_Internalname, lblJs_Caption, "", "", lblJs_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\ExportOptions.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='PopupContentCell'>") ;
         wb_table2_15_0C2( true) ;
      }
      else
      {
         wb_table2_15_0C2( false) ;
      }
      return  ;
   }

   public void wb_table2_15_0C2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divHtml_usertable_ut_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         wb_table3_52_0C2( true) ;
      }
      else
      {
         wb_table3_52_0C2( false) ;
      }
      return  ;
   }

   public void wb_table3_52_0C2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupRight", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndownloadtofile_Internalname, "", "Guardar", bttBtndownloadtofile_Jsonclick, 5, "Guardar", "", StyleString, ClassString, bttBtndownloadtofile_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DODOWNLOADTOFILE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\ExportOptions.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnsavegoogledrive_Internalname, "", "Guardar", bttBtnsavegoogledrive_Jsonclick, 5, "Guardar", "", StyleString, ClassString, bttBtnsavegoogledrive_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOSAVEGOOGLEDRIVE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\ExportOptions.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", bttBtncancel_Caption, bttBtncancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\ExportOptions.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_6_0C2e( true) ;
      }
      else
      {
         wb_table1_6_0C2e( false) ;
      }
   }

   public void wb_table3_52_0C2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblUt_Internalname, tblUt_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr class='Table'>") ;
         httpContext.writeText( "<td class='Table'>") ;
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_52_0C2e( true) ;
      }
      else
      {
         wb_table3_52_0C2e( false) ;
      }
   }

   public void wb_table2_15_0C2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTablecontent_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         sStyleString += " height: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablecontent_Height), 10, 0) + "px" + ";" ;
         sStyleString += " width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablecontent_Width), 10, 0) + "px" + ";" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablecontent_Internalname, tblTablecontent_Internalname, "", "Table", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='ExportOptionsPanellCell'>") ;
         /* User Defined Control */
         ucDvpanel_tableexport.setProperty("Width", Dvpanel_tableexport_Width);
         ucDvpanel_tableexport.setProperty("AutoWidth", Dvpanel_tableexport_Autowidth);
         ucDvpanel_tableexport.setProperty("AutoHeight", Dvpanel_tableexport_Autoheight);
         ucDvpanel_tableexport.setProperty("Cls", Dvpanel_tableexport_Cls);
         ucDvpanel_tableexport.setProperty("Title", Dvpanel_tableexport_Title);
         ucDvpanel_tableexport.setProperty("Collapsible", Dvpanel_tableexport_Collapsible);
         ucDvpanel_tableexport.setProperty("Collapsed", Dvpanel_tableexport_Collapsed);
         ucDvpanel_tableexport.setProperty("ShowCollapseIcon", Dvpanel_tableexport_Showcollapseicon);
         ucDvpanel_tableexport.setProperty("IconPosition", Dvpanel_tableexport_Iconposition);
         ucDvpanel_tableexport.setProperty("AutoScroll", Dvpanel_tableexport_Autoscroll);
         ucDvpanel_tableexport.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableexport_Internalname, "DVPANEL_TABLEEXPORTContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEEXPORTContainer"+"TableExport"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableexport_Internalname, 1, 0, "px", 0, "px", "TableData", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellFL", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavExporttype.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavExporttype.getInternalname(), "Tipo de exportaci�n", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavExporttype, cmbavExporttype.getInternalname(), GXutil.trim( GXutil.str( AV13ExportType, 1, 0)), 1, cmbavExporttype.getJsonclick(), 7, "'"+""+"'"+",false,"+"'"+"e150c1_client"+"'", "int", "", 1, cmbavExporttype.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "", true, (byte)(1), "HLP_WWPBaseObjects\\ExportOptions.htm");
         cmbavExporttype.setValue( GXutil.trim( GXutil.str( AV13ExportType, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavExporttype.getInternalname(), "Values", cmbavExporttype.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='ExportOptionsPanellCell'>") ;
         wb_table4_28_0C2( true) ;
      }
      else
      {
         wb_table4_28_0C2( false) ;
      }
      return  ;
   }

   public void wb_table4_28_0C2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_15_0C2e( true) ;
      }
      else
      {
         wb_table2_15_0C2e( false) ;
      }
   }

   public void wb_table4_28_0C2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTablegoogledriveinfo_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablegoogledriveinfo_Internalname, tblTablegoogledriveinfo_Internalname, "", "Table100x100", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
         ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
         ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
         ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
         ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
         ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
         ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
         ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
         ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
         ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
         ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "TableData", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellFL", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUser_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavUser_Internalname, "Email", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavUser_Internalname, AV22User, GXutil.rtrim( localUtil.format( AV22User, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUser_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUser_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\ExportOptions.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellFL", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavDoctitle_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavDoctitle_Internalname, "T�tulo del documento", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDoctitle_Internalname, AV5DocTitle, GXutil.rtrim( localUtil.format( AV5DocTitle, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDoctitle_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavDoctitle_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\ExportOptions.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellFL", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPassword_Internalname, "Contrase�a", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPassword_Internalname, AV20Password, GXutil.rtrim( localUtil.format( AV20Password, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPassword_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavPassword_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, edtavPassword_Ispassword, (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\ExportOptions.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_28_0C2e( true) ;
      }
      else
      {
         wb_table4_28_0C2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV12ExcelFileName = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12ExcelFileName", AV12ExcelFileName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEXCELFILENAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12ExcelFileName, ""))));
      AV9DefaultTitle = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9DefaultTitle", AV9DefaultTitle);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEFAULTTITLE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9DefaultTitle, ""))));
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
      pa0C2( ) ;
      ws0C2( ) ;
      we0C2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110331032", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/exportoptions.js", "?20225110331032", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblJs_Internalname = "JS" ;
      cmbavExporttype.setInternalname( "vEXPORTTYPE" );
      divTableexport_Internalname = "TABLEEXPORT" ;
      Dvpanel_tableexport_Internalname = "DVPANEL_TABLEEXPORT" ;
      edtavUser_Internalname = "vUSER" ;
      edtavDoctitle_Internalname = "vDOCTITLE" ;
      edtavPassword_Internalname = "vPASSWORD" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      tblTablegoogledriveinfo_Internalname = "TABLEGOOGLEDRIVEINFO" ;
      tblTablecontent_Internalname = "TABLECONTENT" ;
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
      tblUt_Internalname = "UT" ;
      divHtml_usertable_ut_Internalname = "HTML_USERTABLE_UT" ;
      bttBtndownloadtofile_Internalname = "BTNDOWNLOADTOFILE" ;
      bttBtnsavegoogledrive_Internalname = "BTNSAVEGOOGLEDRIVE" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      tblTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      edtavPassword_Jsonclick = "" ;
      edtavPassword_Enabled = 1 ;
      edtavDoctitle_Jsonclick = "" ;
      edtavDoctitle_Enabled = 1 ;
      edtavUser_Jsonclick = "" ;
      edtavUser_Enabled = 1 ;
      cmbavExporttype.setJsonclick( "" );
      cmbavExporttype.setEnabled( 1 );
      tblTablecontent_Width = 0 ;
      tblTablecontent_Height = 0 ;
      bttBtnsavegoogledrive_Visible = 1 ;
      bttBtndownloadtofile_Visible = 1 ;
      tblTablecontent_Visible = 1 ;
      bttBtncancel_Caption = "Cancelar" ;
      lblJs_Caption = "JS" ;
      tblTablegoogledriveinfo_Visible = 1 ;
      edtavPassword_Ispassword = (byte)(0) ;
      Innewwindow1_Target = "" ;
      Innewwindow1_Height = "50" ;
      Innewwindow1_Width = "50" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = "Informaci�n de Google Drive" ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Dvpanel_tableexport_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableexport_Iconposition = "Right" ;
      Dvpanel_tableexport_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableexport_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableexport_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableexport_Title = "D�nde exportar?" ;
      Dvpanel_tableexport_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableexport_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableexport_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableexport_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Opciones para Exportar a Excel" );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavExporttype.setName( "vEXPORTTYPE" );
      cmbavExporttype.setWebtags( "" );
      cmbavExporttype.addItem("1", "Download to disk", (short)(0));
      cmbavExporttype.addItem("2", "Upload to Google Drive", (short)(0));
      if ( cmbavExporttype.getItemCount() > 0 )
      {
         AV13ExportType = (byte)(GXutil.lval( cmbavExporttype.getValidValue(GXutil.trim( GXutil.str( AV13ExportType, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13ExportType", GXutil.str( AV13ExportType, 1, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV14GoogleDocResultXML',fld:'vGOOGLEDOCRESULTXML',pic:'',hsh:true},{av:'AV12ExcelFileName',fld:'vEXCELFILENAME',pic:'',hsh:true},{av:'AV9DefaultTitle',fld:'vDEFAULTTITLE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DODOWNLOADTOFILE'","{handler:'e120C2',iparms:[]");
      setEventMetadata("'DODOWNLOADTOFILE'",",oparms:[]}");
      setEventMetadata("'DOSAVEGOOGLEDRIVE'","{handler:'e130C2',iparms:[{av:'AV14GoogleDocResultXML',fld:'vGOOGLEDOCRESULTXML',pic:'',hsh:true}]");
      setEventMetadata("'DOSAVEGOOGLEDRIVE'",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{ctrl:'BTNCANCEL',prop:'Caption'},{av:'tblTablecontent_Visible',ctrl:'TABLECONTENT',prop:'Visible'},{ctrl:'BTNDOWNLOADTOFILE',prop:'Visible'},{ctrl:'BTNSAVEGOOGLEDRIVE',prop:'Visible'}]}");
      setEventMetadata("VEXPORTTYPE.CLICK","{handler:'e150C1',iparms:[{av:'cmbavExporttype'},{av:'AV13ExportType',fld:'vEXPORTTYPE',pic:'9'}]");
      setEventMetadata("VEXPORTTYPE.CLICK",",oparms:[{av:'tblTablegoogledriveinfo_Visible',ctrl:'TABLEGOOGLEDRIVEINFO',prop:'Visible'},{ctrl:'BTNDOWNLOADTOFILE',prop:'Visible'},{ctrl:'BTNSAVEGOOGLEDRIVE',prop:'Visible'}]}");
      setEventMetadata("VALIDV_EXPORTTYPE","{handler:'validv_Exporttype',iparms:[]");
      setEventMetadata("VALIDV_EXPORTTYPE",",oparms:[]}");
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
      wcpOAV12ExcelFileName = "" ;
      wcpOAV9DefaultTitle = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV12ExcelFileName = "" ;
      AV9DefaultTitle = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV14GoogleDocResultXML = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV22User = "" ;
      AV5DocTitle = "" ;
      AV20Password = "" ;
      AV16HttpRequest = httpContext.getHttpRequest();
      AV21URL = "" ;
      bttBtndownloadtofile_Jsonclick = "" ;
      AV15GoogleDocsResult = new com.projectthani.wwpbaseobjects.SdtGoogleDocsResult(remoteHandle, context);
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      sStyleString = "" ;
      lblJs_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtnsavegoogledrive_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      ucDvpanel_tableexport = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV13ExportType ;
   private byte edtavPassword_Ispassword ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int tblTablecontent_Height ;
   private int tblTablegoogledriveinfo_Visible ;
   private int bttBtnsavegoogledrive_Visible ;
   private int tblTablecontent_Width ;
   private int tblTablecontent_Visible ;
   private int bttBtndownloadtofile_Visible ;
   private int edtavUser_Enabled ;
   private int edtavDoctitle_Enabled ;
   private int edtavPassword_Enabled ;
   private int idxLst ;
   private String wcpOAV9DefaultTitle ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV9DefaultTitle ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_tableexport_Width ;
   private String Dvpanel_tableexport_Cls ;
   private String Dvpanel_tableexport_Title ;
   private String Dvpanel_tableexport_Iconposition ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Innewwindow1_Width ;
   private String Innewwindow1_Height ;
   private String Innewwindow1_Target ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavUser_Internalname ;
   private String edtavDoctitle_Internalname ;
   private String edtavPassword_Internalname ;
   private String tblTablecontent_Internalname ;
   private String tblTablegoogledriveinfo_Internalname ;
   private String bttBtnsavegoogledrive_Internalname ;
   private String bttBtndownloadtofile_Jsonclick ;
   private String bttBtndownloadtofile_Internalname ;
   private String lblJs_Caption ;
   private String lblJs_Internalname ;
   private String Innewwindow1_Internalname ;
   private String bttBtncancel_Caption ;
   private String bttBtncancel_Internalname ;
   private String sStyleString ;
   private String tblTablemain_Internalname ;
   private String lblJs_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divHtml_usertable_ut_Internalname ;
   private String TempTags ;
   private String bttBtnsavegoogledrive_Jsonclick ;
   private String bttBtncancel_Jsonclick ;
   private String tblUt_Internalname ;
   private String Dvpanel_tableexport_Internalname ;
   private String divTableexport_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtavUser_Jsonclick ;
   private String edtavDoctitle_Jsonclick ;
   private String edtavPassword_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_tableexport_Autowidth ;
   private boolean Dvpanel_tableexport_Autoheight ;
   private boolean Dvpanel_tableexport_Collapsible ;
   private boolean Dvpanel_tableexport_Collapsed ;
   private boolean Dvpanel_tableexport_Showcollapseicon ;
   private boolean Dvpanel_tableexport_Autoscroll ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV14GoogleDocResultXML ;
   private String wcpOAV12ExcelFileName ;
   private String AV12ExcelFileName ;
   private String AV22User ;
   private String AV5DocTitle ;
   private String AV20Password ;
   private String AV21URL ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV16HttpRequest ;
   private com.genexus.webpanels.GXUserControl ucInnewwindow1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableexport ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private HTMLChoice cmbavExporttype ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtGoogleDocsResult AV15GoogleDocsResult ;
}

