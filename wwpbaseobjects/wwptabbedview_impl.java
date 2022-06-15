package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwptabbedview_impl extends GXWebComponent
{
   public wwptabbedview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwptabbedview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwptabbedview_impl.class ));
   }

   public wwptabbedview_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "Tabs") ;
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
               httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV5Tabs);
               AV7TabCode = httpContext.GetPar( "TabCode") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7TabCode", AV7TabCode);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV5Tabs,AV7TabCode});
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
               gxfirstwebparm = httpContext.GetFirstPar( "Tabs") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "Tabs") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Tabsgrid") == 0 )
            {
               nRC_GXsfl_14 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_14"))) ;
               nGXsfl_14_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_14_idx"))) ;
               sGXsfl_14_idx = httpContext.GetPar( "sGXsfl_14_idx") ;
               sPrefix = httpContext.GetPar( "sPrefix") ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxnrtabsgrid_newrow( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Tabsgrid") == 0 )
            {
               sPrefix = httpContext.GetPar( "sPrefix") ;
               init_default_properties( ) ;
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxgrtabsgrid_refresh( sPrefix) ;
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
         pa392( ) ;
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
      com.projectthani.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), false);
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
         httpContext.writeValue( "Tabbed View") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110312142", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"Form\" data-gx-class=\"Form\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.wwptabbedview", new String[] {GXutil.URLEncode(GXutil.rtrim(AV7TabCode))}, new String[] {"Tabs","TabCode"}) +"\">") ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "Form", true);
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "Form" : Form.getThemeClass())+"-fx");
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_14", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_14, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV7TabCode", GXutil.rtrim( wcpOAV7TabCode));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTABS", AV5Tabs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTABS", AV5Tabs);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTABCODE", GXutil.rtrim( AV7TabCode));
   }

   public void renderHtmlCloseForm392( )
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
         httpContext.writeTextNL( "</form>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         include_jscripts( ) ;
         if ( ! ( WebComp_Component == null ) )
         {
            WebComp_Component.componentjscripts();
         }
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
      return "WWPBaseObjects.WWPTabbedView" ;
   }

   public String getPgmdesc( )
   {
      return "Tabbed View" ;
   }

   public void wb390( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.wwpbaseobjects.wwptabbedview");
         }
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         wb_table1_2_392( true) ;
      }
      else
      {
         wb_table1_2_392( false) ;
      }
      return  ;
   }

   public void wb_table1_2_392e( boolean wbgen )
   {
      if ( wbgen )
      {
      }
      if ( wbEnd == 14 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( TabsgridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"TabsgridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Tabsgrid", TabsgridContainer);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TabsgridContainerData", TabsgridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TabsgridContainerData"+"V", TabsgridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"TabsgridContainerData"+"V"+"\" value='"+TabsgridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start392( )
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
            Form.getMeta().addItem("description", "Tabbed View", (short)(0)) ;
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
            strup390( ) ;
         }
      }
   }

   public void ws392( )
   {
      start392( ) ;
      evt392( ) ;
   }

   public void evt392( )
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
                              strup390( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup390( ) ;
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
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 4), "LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup390( ) ;
                           }
                           nGXsfl_14_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_142( ) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       /* Execute user event: Load */
                                       e11392 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
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
                                    strup390( ) ;
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
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 37 )
                     {
                        OldComponent = httpContext.cgiGet( sPrefix+"W0037") ;
                        if ( ( GXutil.len( OldComponent) == 0 ) || ( GXutil.strcmp(OldComponent, WebComp_Component_Component) != 0 ) )
                        {
                           WebComp_Component = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldComponent + "_impl", remoteHandle, context);
                           WebComp_Component_Component = OldComponent ;
                        }
                        WebComp_Component.componentprocess(sPrefix+"W0037", "", sEvt);
                        WebComp_Component_Component = OldComponent ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we392( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm392( ) ;
         }
      }
   }

   public void pa392( )
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

   public void gxnrtabsgrid_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_142( ) ;
      while ( nGXsfl_14_idx <= nRC_GXsfl_14 )
      {
         sendrow_142( ) ;
         nGXsfl_14_idx = ((subTabsgrid_Islastpage==1)&&(nGXsfl_14_idx+1>subtabsgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_14_idx+1) ;
         sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_142( ) ;
      }
      addString( httpContext.getJSONContainerResponse( TabsgridContainer)) ;
      /* End function gxnrTabsgrid_newrow */
   }

   public void gxgrtabsgrid_refresh( String sPrefix )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      TABSGRID_nCurrentRecord = 0 ;
      rf392( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrTabsgrid_refresh */
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
      rf392( ) ;
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

   public void rf392( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         TabsgridContainer.ClearRows();
      }
      wbStart = (short)(14) ;
      nGXsfl_14_idx = 1 ;
      sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_142( ) ;
      bGXsfl_14_Refreshing = true ;
      TabsgridContainer.AddObjectProperty("GridName", "Tabsgrid");
      TabsgridContainer.AddObjectProperty("CmpContext", sPrefix);
      TabsgridContainer.AddObjectProperty("InMasterPage", "false");
      TabsgridContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      TabsgridContainer.AddObjectProperty("Borderwidth", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
      TabsgridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
      TabsgridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
      TabsgridContainer.AddObjectProperty("Rules", GXutil.rtrim( "none"));
      TabsgridContainer.AddObjectProperty("Class", "FreeStyleGrid");
      TabsgridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
      TabsgridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
      TabsgridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      TabsgridContainer.AddObjectProperty("Borderwidth", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Borderwidth, (byte)(4), (byte)(0), ".", "")));
      TabsgridContainer.setPageSize( subtabsgrid_fnc_recordsperpage( ) );
      if ( subTabsgrid_Islastpage != 0 )
      {
         TABSGRID_nFirstRecordOnPage = (long)(subtabsgrid_fnc_recordcount( )-subtabsgrid_fnc_recordsperpage( )) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TABSGRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( TABSGRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         TabsgridContainer.AddObjectProperty("TABSGRID_nFirstRecordOnPage", TABSGRID_nFirstRecordOnPage);
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            WebComp_Component.componentstart();
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_142( ) ;
         /* Execute user event: Load */
         e11392 ();
         wbEnd = (short)(14) ;
         wb390( ) ;
      }
      bGXsfl_14_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes392( )
   {
   }

   public int subtabsgrid_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subtabsgrid_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subtabsgrid_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subtabsgrid_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup390( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_14 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_14"), ",", ".")) ;
         wcpOAV7TabCode = httpContext.cgiGet( sPrefix+"wcpOAV7TabCode") ;
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

   private void e11392( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_2_392( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         sStyleString += " width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(100), 10, 0) + "%" + ";" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTable4_Internalname, tblTable4_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableAttributesCell'>") ;
         wb_table2_5_392( true) ;
      }
      else
      {
         wb_table2_5_392( false) ;
      }
      return  ;
   }

   public void wb_table2_5_392e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_2_392e( true) ;
      }
      else
      {
         wb_table1_2_392e( false) ;
      }
   }

   public void wb_table2_5_392( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         sStyleString += " width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(100), 10, 0) + "%" + ";" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTable3_Internalname, tblTable3_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableAttributesCell'>") ;
         wb_table3_8_392( true) ;
      }
      else
      {
         wb_table3_8_392( false) ;
      }
      return  ;
   }

   public void wb_table3_8_392e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_5_392e( true) ;
      }
      else
      {
         wb_table2_5_392e( false) ;
      }
   }

   public void wb_table3_8_392( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         sStyleString += " width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(100), 10, 0) + "%" + ";" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTable1_Internalname, tblTable1_Internalname, "", "Table", 0, "", "", 0, 0, sStyleString, "none", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr style=\""+GXutil.CssPrettify( "vertical-align:bottom")+"\">") ;
         httpContext.writeText( "<td background=\"\"  style=\""+GXutil.CssPrettify( "vertical-align:bottom;height:25px")+"\">") ;
         wb_table4_11_392( true) ;
      }
      else
      {
         wb_table4_11_392( false) ;
      }
      return  ;
   }

   public void wb_table4_11_392e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "vertical-align:top;height:39px")+"\">") ;
         wb_table5_31_392( true) ;
      }
      else
      {
         wb_table5_31_392( false) ;
      }
      return  ;
   }

   public void wb_table5_31_392e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_8_392e( true) ;
      }
      else
      {
         wb_table3_8_392e( false) ;
      }
   }

   public void wb_table5_31_392( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         sStyleString += "background-color: " + WebUtils.getHTMLColor( (int)(0xFFFFFF)) + ";" ;
         if ( GXutil.strcmp(WebUtils.getHTMLColor( (int)(0x000000))+";", "") != 0 )
         {
            sStyleString += " border-color: " + WebUtils.getHTMLColor( (int)(0x000000)) + ";" ;
         }
         sStyleString += " width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(100), 10, 0) + "%" + ";" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTable2_Internalname, tblTable2_Internalname, "", "Table", 0, "", "", 0, 0, sStyleString, "none", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "vertical-align:top")+"\">") ;
         wb_table6_34_392( true) ;
      }
      else
      {
         wb_table6_34_392( false) ;
      }
      return  ;
   }

   public void wb_table6_34_392e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_31_392e( true) ;
      }
      else
      {
         wb_table5_31_392e( false) ;
      }
   }

   public void wb_table6_34_392( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablecomponent_Internalname, tblTablecomponent_Internalname, "", "TableView", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0037"+"", GXutil.rtrim( WebComp_Component_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0037"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.strcmp(GXutil.lower( OldComponent), GXutil.lower( WebComp_Component_Component)) != 0 )
            {
               httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0037"+"");
            }
            WebComp_Component.componentdraw();
            if ( GXutil.strcmp(GXutil.lower( OldComponent), GXutil.lower( WebComp_Component_Component)) != 0 )
            {
               httpContext.ajax_rspEndCmp();
            }
            httpContext.writeText( "</div>") ;
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_34_392e( true) ;
      }
      else
      {
         wb_table6_34_392e( false) ;
      }
   }

   public void wb_table4_11_392( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTabletabs_Internalname, tblTabletabs_Internalname, "", "Table", 0, "", "", 0, 0, sStyleString, "none", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "vertical-align:bottom")+"\">") ;
         /*  Grid Control  */
         TabsgridContainer.SetIsFreestyle(true);
         TabsgridContainer.SetWrapped(nGXWrapped);
         if ( TabsgridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+sPrefix+"TabsgridContainer"+"DivS\" data-gxgridid=\"14\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subTabsgrid_Internalname, subTabsgrid_Internalname, "", "FreeStyleGrid", 0, "", "", 0, 0, sStyleString, "none", "", 0);
            TabsgridContainer.AddObjectProperty("GridName", "Tabsgrid");
         }
         else
         {
            TabsgridContainer.AddObjectProperty("GridName", "Tabsgrid");
            TabsgridContainer.AddObjectProperty("Header", subTabsgrid_Header);
            TabsgridContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            TabsgridContainer.AddObjectProperty("Borderwidth", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Rules", GXutil.rtrim( "none"));
            TabsgridContainer.AddObjectProperty("Class", "FreeStyleGrid");
            TabsgridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 0, (byte)(4), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Borderwidth", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Borderwidth, (byte)(4), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("CmpContext", sPrefix);
            TabsgridContainer.AddObjectProperty("InMasterPage", "false");
            TabsgridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            TabsgridContainer.AddColumnProperties(TabsgridColumn);
            TabsgridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            TabsgridContainer.AddColumnProperties(TabsgridColumn);
            TabsgridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            TabsgridColumn.AddObjectProperty("Value", httpContext.convertURL( "(none)"));
            TabsgridContainer.AddColumnProperties(TabsgridColumn);
            TabsgridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            TabsgridContainer.AddColumnProperties(TabsgridColumn);
            TabsgridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            TabsgridContainer.AddColumnProperties(TabsgridColumn);
            TabsgridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            TabsgridContainer.AddColumnProperties(TabsgridColumn);
            TabsgridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            TabsgridContainer.AddColumnProperties(TabsgridColumn);
            TabsgridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            TabsgridColumn.AddObjectProperty("Value", lblTab_Caption);
            TabsgridContainer.AddColumnProperties(TabsgridColumn);
            TabsgridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            TabsgridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subTabsgrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 14 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_14 = (int)(nGXsfl_14_idx-1) ;
         if ( TabsgridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"TabsgridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Tabsgrid", TabsgridContainer);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TabsgridContainerData", TabsgridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TabsgridContainerData"+"V", TabsgridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"TabsgridContainerData"+"V"+"\" value='"+TabsgridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "vertical-align:bottom")+"\">") ;
         /* Static images/pictures */
         ClassString = "Image" ;
         StyleString = "" ;
         sImgUrl = "(none)" ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgEndtab_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\WWPTabbedView.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "width:15px")+"\">") ;
         /* Static images/pictures */
         ClassString = "Image" ;
         StyleString = "" ;
         sImgUrl = "(none)" ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgTabprevious_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "Previous Tab", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\WWPTabbedView.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td style=\""+GXutil.CssPrettify( "width:13px")+"\">") ;
         /* Static images/pictures */
         ClassString = "Image" ;
         StyleString = "" ;
         sImgUrl = "(none)" ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgTabnext_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "Next Tab", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\WWPTabbedView.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_11_392e( true) ;
      }
      else
      {
         wb_table4_11_392e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV5Tabs = (GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWPTabOptions_TabOptionsItem>)getParm(obj,0) ;
      AV7TabCode = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7TabCode", AV7TabCode);
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
      pa392( ) ;
      ws392( ) ;
      we392( ) ;
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
      sCtrlAV5Tabs = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV7TabCode = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa392( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\wwptabbedview", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa392( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV5Tabs = (GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWPTabOptions_TabOptionsItem>)getParm(obj,2) ;
         AV7TabCode = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7TabCode", AV7TabCode);
      }
      wcpOAV7TabCode = httpContext.cgiGet( sPrefix+"wcpOAV7TabCode") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV7TabCode, wcpOAV7TabCode) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV7TabCode = AV7TabCode ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV5Tabs = httpContext.cgiGet( sPrefix+"AV5Tabs_CTRL") ;
      if ( GXutil.len( sCtrlAV5Tabs) > 0 )
      {
         AV5Tabs = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWPTabOptions_TabOptionsItem>() ;
      }
      else
      {
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"AV5Tabs_PARM"), AV5Tabs);
      }
      sCtrlAV7TabCode = httpContext.cgiGet( sPrefix+"AV7TabCode_CTRL") ;
      if ( GXutil.len( sCtrlAV7TabCode) > 0 )
      {
         AV7TabCode = httpContext.cgiGet( sCtrlAV7TabCode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7TabCode", AV7TabCode);
      }
      else
      {
         AV7TabCode = httpContext.cgiGet( sPrefix+"AV7TabCode_PARM") ;
      }
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
      pa392( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws392( ) ;
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
      ws392( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"AV5Tabs_PARM", AV5Tabs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"AV5Tabs_PARM", AV5Tabs);
      }
      if ( GXutil.len( GXutil.rtrim( sCtrlAV5Tabs)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV5Tabs_CTRL", GXutil.rtrim( sCtrlAV5Tabs));
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7TabCode_PARM", GXutil.rtrim( AV7TabCode));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV7TabCode)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7TabCode_CTRL", GXutil.rtrim( sCtrlAV7TabCode));
      }
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
      we392( ) ;
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
      if ( ! ( WebComp_Component == null ) )
      {
         WebComp_Component.componentjscripts();
      }
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Component == null ) )
      {
         WebComp_Component.componentthemes();
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110312166", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/wwptabbedview.js", "?20225110312167", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_142( )
   {
      imgBegintab_Internalname = sPrefix+"BEGINTAB_"+sGXsfl_14_idx ;
      lblTab_Internalname = sPrefix+"TAB_"+sGXsfl_14_idx ;
   }

   public void subsflControlProps_fel_142( )
   {
      imgBegintab_Internalname = sPrefix+"BEGINTAB_"+sGXsfl_14_fel_idx ;
      lblTab_Internalname = sPrefix+"TAB_"+sGXsfl_14_fel_idx ;
   }

   public void sendrow_142( )
   {
      subsflControlProps_142( ) ;
      wb390( ) ;
      TabsgridRow = GXWebRow.GetNew(context,TabsgridContainer) ;
      if ( subTabsgrid_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subTabsgrid_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subTabsgrid_Class, "") != 0 )
         {
            subTabsgrid_Linesclass = subTabsgrid_Class+"Odd" ;
         }
      }
      else if ( subTabsgrid_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subTabsgrid_Backstyle = (byte)(0) ;
         subTabsgrid_Backcolor = subTabsgrid_Allbackcolor ;
         if ( GXutil.strcmp(subTabsgrid_Class, "") != 0 )
         {
            subTabsgrid_Linesclass = subTabsgrid_Class+"Uniform" ;
         }
      }
      else if ( subTabsgrid_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subTabsgrid_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subTabsgrid_Class, "") != 0 )
         {
            subTabsgrid_Linesclass = subTabsgrid_Class+"Odd" ;
         }
         subTabsgrid_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subTabsgrid_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subTabsgrid_Backstyle = (byte)(1) ;
         subTabsgrid_Backcolor = (int)(0xFFFFFF) ;
         if ( GXutil.strcmp(subTabsgrid_Class, "") != 0 )
         {
            subTabsgrid_Linesclass = subTabsgrid_Class+"Odd" ;
         }
      }
      /* Start of Columns property logic. */
      TabsgridRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"",subTabsgrid_Linesclass,""});
      TabsgridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Static images/pictures */
      ClassString = "Image" ;
      StyleString = "" ;
      sImgUrl = "(none)" ;
      TabsgridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {imgBegintab_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      if ( TabsgridContainer.GetWrapped() == 1 )
      {
         TabsgridContainer.CloseTag("cell");
      }
      TabsgridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Table start */
      TabsgridRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTabletab_Internalname+"_"+sGXsfl_14_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(0),Integer.valueOf(0),"","","","px","px",""});
      TabsgridRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      TabsgridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Text block */
      TabsgridRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTab_Internalname,"Tab Name","","",lblTab_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","UnSelectedTab",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      if ( TabsgridContainer.GetWrapped() == 1 )
      {
         TabsgridContainer.CloseTag("cell");
      }
      if ( TabsgridContainer.GetWrapped() == 1 )
      {
         TabsgridContainer.CloseTag("row");
      }
      if ( TabsgridContainer.GetWrapped() == 1 )
      {
         TabsgridContainer.CloseTag("table");
      }
      /* End of table */
      if ( TabsgridContainer.GetWrapped() == 1 )
      {
         TabsgridContainer.CloseTag("cell");
      }
      if ( TabsgridContainer.GetWrapped() == 1 )
      {
         TabsgridContainer.CloseTag("row");
      }
      send_integrity_lvl_hashes392( ) ;
      /* End of Columns property logic. */
      TabsgridContainer.AddRow(TabsgridRow);
      nGXsfl_14_idx = ((subTabsgrid_Islastpage==1)&&(nGXsfl_14_idx+1>subtabsgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_14_idx+1) ;
      sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_142( ) ;
      /* End function sendrow_142 */
   }

   public void init_default_properties( )
   {
      imgBegintab_Internalname = sPrefix+"BEGINTAB" ;
      lblTab_Internalname = sPrefix+"TAB" ;
      tblTabletab_Internalname = sPrefix+"TABLETAB" ;
      imgEndtab_Internalname = sPrefix+"ENDTAB" ;
      imgTabprevious_Internalname = sPrefix+"TABPREVIOUS" ;
      imgTabnext_Internalname = sPrefix+"TABNEXT" ;
      tblTabletabs_Internalname = sPrefix+"TABLETABS" ;
      tblTablecomponent_Internalname = sPrefix+"TABLECOMPONENT" ;
      tblTable2_Internalname = sPrefix+"TABLE2" ;
      tblTable1_Internalname = sPrefix+"TABLE1" ;
      tblTable3_Internalname = sPrefix+"TABLE3" ;
      tblTable4_Internalname = sPrefix+"TABLE4" ;
      Form.setInternalname( sPrefix+"FORM" );
      subTabsgrid_Internalname = sPrefix+"TABSGRID" ;
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
      subTabsgrid_Class = "FreeStyleGrid" ;
      subTabsgrid_Allowcollapsing = (byte)(0) ;
      lblTab_Caption = "Tab Name" ;
      subTabsgrid_Borderwidth = (short)(0) ;
      subTabsgrid_Backcolorstyle = (byte)(0) ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'TABSGRID_nFirstRecordOnPage'},{av:'TABSGRID_nEOF'},{av:'sPrefix'}]");
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
      wcpOAV7TabCode = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV5Tabs = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWPTabOptions_TabOptionsItem>(com.projectthani.wwpbaseobjects.SdtWWPTabOptions_TabOptionsItem.class, "TabOptionsItem", "ProjectThani", remoteHandle);
      AV7TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      TabsgridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldComponent = "" ;
      WebComp_Component_Component = "" ;
      subTabsgrid_Header = "" ;
      TabsgridColumn = new com.genexus.webpanels.GXWebColumn();
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV5Tabs = "" ;
      sCtrlAV7TabCode = "" ;
      TabsgridRow = new com.genexus.webpanels.GXWebRow();
      subTabsgrid_Linesclass = "" ;
      lblTab_Jsonclick = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Component = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subTabsgrid_Backcolorstyle ;
   private byte subTabsgrid_Allowselection ;
   private byte subTabsgrid_Allowhovering ;
   private byte subTabsgrid_Allowcollapsing ;
   private byte subTabsgrid_Collapsed ;
   private byte nGXWrapped ;
   private byte subTabsgrid_Backstyle ;
   private byte TABSGRID_nEOF ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short subTabsgrid_Borderwidth ;
   private int nRC_GXsfl_14 ;
   private int nGXsfl_14_idx=1 ;
   private int subTabsgrid_Islastpage ;
   private int subTabsgrid_Selectedindex ;
   private int subTabsgrid_Selectioncolor ;
   private int subTabsgrid_Hoveringcolor ;
   private int idxLst ;
   private int subTabsgrid_Backcolor ;
   private int subTabsgrid_Allbackcolor ;
   private long TABSGRID_nCurrentRecord ;
   private long TABSGRID_nFirstRecordOnPage ;
   private String wcpOAV7TabCode ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV7TabCode ;
   private String sGXsfl_14_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sStyleString ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String OldComponent ;
   private String WebComp_Component_Component ;
   private String tblTable4_Internalname ;
   private String tblTable3_Internalname ;
   private String tblTable1_Internalname ;
   private String tblTable2_Internalname ;
   private String tblTablecomponent_Internalname ;
   private String tblTabletabs_Internalname ;
   private String subTabsgrid_Internalname ;
   private String subTabsgrid_Header ;
   private String lblTab_Caption ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgEndtab_Internalname ;
   private String imgTabprevious_Internalname ;
   private String imgTabnext_Internalname ;
   private String sCtrlAV5Tabs ;
   private String sCtrlAV7TabCode ;
   private String imgBegintab_Internalname ;
   private String lblTab_Internalname ;
   private String sGXsfl_14_fel_idx="0001" ;
   private String subTabsgrid_Class ;
   private String subTabsgrid_Linesclass ;
   private String tblTabletab_Internalname ;
   private String lblTab_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_14_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private com.genexus.webpanels.GXWebGrid TabsgridContainer ;
   private com.genexus.webpanels.GXWebRow TabsgridRow ;
   private com.genexus.webpanels.GXWebColumn TabsgridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Component ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWPTabOptions_TabOptionsItem> AV5Tabs ;
}

