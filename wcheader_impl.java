package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wcheader_impl extends GXWebComponent
{
   public wcheader_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wcheader_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wcheader_impl.class ));
   }

   public wcheader_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa362( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
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
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      com.projectthani.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( "WCHeader") ;
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
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110312161", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("UserControls/UCMenuRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wcheader", new String[] {}, new String[] {}) +"\">") ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
            httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
         }
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCMENU1_Linklogo", GXutil.rtrim( Ucmenu1_Linklogo));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCMENU1_Logolg", GXutil.rtrim( Ucmenu1_Logolg));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCMENU1_Logosm", GXutil.rtrim( Ucmenu1_Logosm));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCMENU1_Htmlregistrarmedico", GXutil.rtrim( Ucmenu1_Htmlregistrarmedico));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCMENU1_Htmllogin", GXutil.rtrim( Ucmenu1_Htmllogin));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UCMENU1_Htmlperfil", GXutil.rtrim( Ucmenu1_Htmlperfil));
   }

   public void renderHtmlCloseForm362( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
         httpContext.SendComponentObjects();
         httpContext.SendServerCommands();
         httpContext.SendState();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "</form>") ;
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         include_jscripts( ) ;
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "WCHeader" ;
   }

   public String getPgmdesc( )
   {
      return "WCHeader" ;
   }

   public void wb360( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.wcheader");
            httpContext.AddJavascriptSource("UserControls/UCMenuRender.js", "", false, true);
         }
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintableheader_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUcmenu1.render(context, "ucmenu", Ucmenu1_Internalname, sPrefix+"UCMENU1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start362( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_7-156546", (short)(0)) ;
            }
            Form.getMeta().addItem("description", "WCHeader", (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup360( ) ;
         }
      }
   }

   public void ws362( )
   {
      start362( ) ;
      evt362( ) ;
   }

   public void evt362( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup360( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup360( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e11362 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup360( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e12362 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup360( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup360( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
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

   public void we362( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm362( ) ;
         }
      }
   }

   public void pa362( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
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
      rf362( ) ;
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

   public void rf362( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e12362 ();
         wb360( ) ;
      }
   }

   public void send_integrity_lvl_hashes362( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup360( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11362 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Ucmenu1_Linklogo = httpContext.cgiGet( sPrefix+"UCMENU1_Linklogo") ;
         Ucmenu1_Logolg = httpContext.cgiGet( sPrefix+"UCMENU1_Logolg") ;
         Ucmenu1_Logosm = httpContext.cgiGet( sPrefix+"UCMENU1_Logosm") ;
         Ucmenu1_Htmlregistrarmedico = httpContext.cgiGet( sPrefix+"UCMENU1_Htmlregistrarmedico") ;
         Ucmenu1_Htmllogin = httpContext.cgiGet( sPrefix+"UCMENU1_Htmllogin") ;
         Ucmenu1_Htmlperfil = httpContext.cgiGet( sPrefix+"UCMENU1_Htmlperfil") ;
         /* Read variables values. */
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
      e11362 ();
      if (returnInSub) return;
   }

   public void e11362( )
   {
      /* Start Routine */
      returnInSub = false ;
      Ucmenu1_Linklogo = formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {})  ;
      ucUcmenu1.sendProperty(context, sPrefix, false, Ucmenu1_Internalname, "LinkLogo", Ucmenu1_Linklogo);
      Ucmenu1_Logolg = httpContext.convertURL( context.getHttpContext().getImagePath( "ded4713b-2c88-41c7-a077-c77fd296ec29", "", context.getHttpContext().getTheme( ))) ;
      ucUcmenu1.sendProperty(context, sPrefix, false, Ucmenu1_Internalname, "LogoLg", Ucmenu1_Logolg);
      Ucmenu1_Logosm = httpContext.convertURL( context.getHttpContext().getImagePath( "ded4713b-2c88-41c7-a077-c77fd296ec29", "", context.getHttpContext().getTheme( ))) ;
      ucUcmenu1.sendProperty(context, sPrefix, false, Ucmenu1_Internalname, "LogoSm", Ucmenu1_Logosm);
      GXt_objcol_SdtSDTMenu1 = AV10Menu ;
      GXv_objcol_SdtSDTMenu2[0] = GXt_objcol_SdtSDTMenu1 ;
      new com.projectthani.prcgetmenu(remoteHandle, context).execute( GXv_objcol_SdtSDTMenu2) ;
      GXt_objcol_SdtSDTMenu1 = GXv_objcol_SdtSDTMenu2[0] ;
      AV10Menu = GXt_objcol_SdtSDTMenu1 ;
      AV6html += "<ul class=\"TableHeaderNav main-nav\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6html", AV6html);
      AV18GXV1 = 1 ;
      while ( AV18GXV1 <= AV10Menu.size() )
      {
         AV11MenuItem = (com.projectthani.SdtSDTMenu)((com.projectthani.SdtSDTMenu)AV10Menu.elementAt(-1+AV18GXV1));
         AV13nroSubNiveles = (short)(AV11MenuItem.getgxTv_SdtSDTMenu_Submenus().size()) ;
         AV6html += "<li class=\"has-submenu\">" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6html", AV6html);
         if ( AV13nroSubNiveles > 0 )
         {
            AV6html += "<a href=\"\">" + AV11MenuItem.getgxTv_SdtSDTMenu_Menutexto() + "</a>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6html", AV6html);
            AV6html += "<ul class=\"submenu\">" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6html", AV6html);
            AV19GXV2 = 1 ;
            while ( AV19GXV2 <= AV11MenuItem.getgxTv_SdtSDTMenu_Submenus().size() )
            {
               AV12MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)((com.projectthani.SdtSDTMenu_SubMenusItem)AV11MenuItem.getgxTv_SdtSDTMenu_Submenus().elementAt(-1+AV19GXV2));
               AV6html += "<li><a href=\"" + AV12MenuSubNivel.getgxTv_SdtSDTMenu_SubMenusItem_Menulink() + "\">" + AV12MenuSubNivel.getgxTv_SdtSDTMenu_SubMenusItem_Menutexto() + "</a></li>" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6html", AV6html);
               AV19GXV2 = (int)(AV19GXV2+1) ;
            }
            AV6html += "</ul>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6html", AV6html);
         }
         else
         {
            AV6html += "<a href=\"" + AV11MenuItem.getgxTv_SdtSDTMenu_Menulink() + "\">" + AV11MenuItem.getgxTv_SdtSDTMenu_Menutexto() + "</a>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6html", AV6html);
         }
         AV6html += "</li>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6html", AV6html);
         AV18GXV1 = (int)(AV18GXV1+1) ;
      }
      AV9HtmlRegistrateMedico += "<li class=\"nav-item\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9HtmlRegistrateMedico", AV9HtmlRegistrateMedico);
      AV9HtmlRegistrateMedico += "<a class=\"Registrate\" href=\"" + formatLink("com.projectthani.wpregistrate", new String[] {}, new String[] {})  + "\" style=\"color: #0de0fe;float: right;font-size: 15px;margin-top: 2px;text-transform:uppercase;border: 1px solid;\">Registrate </a>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9HtmlRegistrateMedico", AV9HtmlRegistrateMedico);
      AV9HtmlRegistrateMedico += "</li>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9HtmlRegistrateMedico", AV9HtmlRegistrateMedico);
      AV7HtmlLogin += "<li class=\"nav-item\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7HtmlLogin", AV7HtmlLogin);
      AV7HtmlLogin += "<a class=\"nav-link header-login\" href=\"" + formatLink("com.projectthani.wpiniciarsesion", new String[] {}, new String[] {})  + "\">Iniciar sesion</a>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7HtmlLogin", AV7HtmlLogin);
      AV7HtmlLogin += "</li>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7HtmlLogin", AV7HtmlLogin);
      AV8HtmlPerfil += "<li id=\"loggedItem\" class=\"nav-item dropdown has-arrow logged-item \">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "			<a href=\"#\" class=\"dropdown-toggle nav-link\" data-toggle=\"dropdown\" aria-expanded=\"False\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "				<span class=\"user-img\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "					<i class=\"fas fa-user-circle\" Style=\"Font-size:20px;\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "	                <font style=\"vertical-align: inherit; Font-size:14px; margin-left: 5px;font-family:" + "Poppins" + ";font-weight: 500;\">" + AV5WebSession.getValue("WSPacienteDatos") + "</font></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "				</span>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "			</a>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "			<div id=\"LogedInfo\" class=\"dropdown-menu dropdown-menu-right\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "				<a class=\"dropdown-item\" href=\"" + formatLink("com.projectthani.wphomepaciente", new String[] {}, new String[] {"PantallaEdit","PacienteFamiliarIdEdit"})  + "\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "					<i class=\"fas fa-users-cog\"><font style=\"vertical-align: inherit;margin-left: 5px;font-family:" + "Poppins" + ", " + "sans-serif" + ";font-weight: 500;\">Mi perfil</font></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "				</a>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "				<a class=\"dropdown-item\" href=\"" + formatLink("com.projectthani.wploginpaciente", new String[] {}, new String[] {})  + "\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "					<i class=\"fas fa-sign-out-alt\"><font style=\"vertical-align: inherit; margin-left: 5px;font-family:" + "Poppins" + ", " + "sans-serif" + ";font-weight: 500;\">Cerrar sesión</font></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "				</a>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "			</div>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      AV8HtmlPerfil += "		</li>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8HtmlPerfil", AV8HtmlPerfil);
      if ( (GXutil.strcmp("", AV5WebSession.getValue("WSPacienteId"))==0) )
      {
         Ucmenu1_Htmlregistrarmedico = AV9HtmlRegistrateMedico ;
         ucUcmenu1.sendProperty(context, sPrefix, false, Ucmenu1_Internalname, "HtmlRegistrarMedico", Ucmenu1_Htmlregistrarmedico);
         Ucmenu1_Htmllogin = AV7HtmlLogin ;
         ucUcmenu1.sendProperty(context, sPrefix, false, Ucmenu1_Internalname, "HtmlLogin", Ucmenu1_Htmllogin);
      }
      else
      {
         Ucmenu1_Htmlperfil = AV8HtmlPerfil ;
         ucUcmenu1.sendProperty(context, sPrefix, false, Ucmenu1_Internalname, "HtmlPerfil", Ucmenu1_Htmlperfil);
      }
      this.executeExternalObjectMethod(sPrefix, false, "AV15ShowOpcionPerfil", "showVerPerfil", new Object[] {}, false);
   }

   protected void nextLoad( )
   {
   }

   protected void e12362( )
   {
      /* Load Routine */
      returnInSub = false ;
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
      pa362( ) ;
      ws362( ) ;
      we362( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa362( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wcheader", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa362( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
      }
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa362( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws362( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws362( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we362( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110312188", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("wcheader.js", "?20225110312188", false, true);
         httpContext.AddJavascriptSource("UserControls/UCMenuRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      Ucmenu1_Internalname = sPrefix+"UCMENU1" ;
      divMaintableheader_Internalname = sPrefix+"MAINTABLEHEADER" ;
      Form.setInternalname( sPrefix+"FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusTheme");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      Ucmenu1_Htmlperfil = "" ;
      Ucmenu1_Htmllogin = "" ;
      Ucmenu1_Htmlregistrarmedico = "" ;
      Ucmenu1_Logosm = "" ;
      Ucmenu1_Logolg = "" ;
      Ucmenu1_Linklogo = "" ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
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
      sPrefix = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      ucUcmenu1 = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV10Menu = new GXBaseCollection<com.projectthani.SdtSDTMenu>(com.projectthani.SdtSDTMenu.class, "SDTMenu", "ProjectThani", remoteHandle);
      GXt_objcol_SdtSDTMenu1 = new GXBaseCollection<com.projectthani.SdtSDTMenu>(com.projectthani.SdtSDTMenu.class, "SDTMenu", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTMenu2 = new GXBaseCollection[1] ;
      AV6html = "" ;
      AV11MenuItem = new com.projectthani.SdtSDTMenu(remoteHandle, context);
      AV12MenuSubNivel = new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV9HtmlRegistrateMedico = "" ;
      AV7HtmlLogin = "" ;
      AV8HtmlPerfil = "" ;
      AV5WebSession = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nGXWrapped ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV13nroSubNiveles ;
   private int AV18GXV1 ;
   private int AV19GXV2 ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Ucmenu1_Linklogo ;
   private String Ucmenu1_Logolg ;
   private String Ucmenu1_Logosm ;
   private String Ucmenu1_Htmlregistrarmedico ;
   private String Ucmenu1_Htmllogin ;
   private String Ucmenu1_Htmlperfil ;
   private String GX_FocusControl ;
   private String divMaintableheader_Internalname ;
   private String Ucmenu1_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV6html ;
   private String AV9HtmlRegistrateMedico ;
   private String AV7HtmlLogin ;
   private String AV8HtmlPerfil ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV5WebSession ;
   private com.genexus.webpanels.GXUserControl ucUcmenu1 ;
   private GXBaseCollection<com.projectthani.SdtSDTMenu> AV10Menu ;
   private GXBaseCollection<com.projectthani.SdtSDTMenu> GXt_objcol_SdtSDTMenu1 ;
   private GXBaseCollection<com.projectthani.SdtSDTMenu> GXv_objcol_SdtSDTMenu2[] ;
   private com.projectthani.SdtSDTMenu AV11MenuItem ;
   private com.projectthani.SdtSDTMenu_SubMenusItem AV12MenuSubNivel ;
}

