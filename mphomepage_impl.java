package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class mphomepage_impl extends GXMasterPage
{
   public mphomepage_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public mphomepage_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mphomepage_impl.class ));
   }

   public mphomepage_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa2U2( ) ;
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws2U2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we2U2( ) ;
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         GXWebForm.addResponsiveMetaHeaders((getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getMeta());
         getDataAreaObject().renderHtmlHeaders();
      }
   }

   public void renderHtmlOpenForm( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlOpenForm();
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
   }

   public void renderHtmlCloseForm2U2( )
   {
      sendCloseFormHiddens( ) ;
      sendSecurityToken(sPrefix);
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlCloseForm();
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! ( WebComp_Component1 == null ) )
      {
         WebComp_Component1.componentjscripts();
      }
      if ( ! ( WebComp_Component2 == null ) )
      {
         WebComp_Component2.componentjscripts();
      }
      httpContext.AddJavascriptSource("mphomepage.js", "?20225110334195", false, true);
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "MPHomePage" ;
   }

   public String getPgmdesc( )
   {
      return "MPHome Page" ;
   }

   public void wb2U0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         if ( ! ShowMPWhenPopUp( ) && httpContext.isPopUpObject( ) )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
            /* Content placeholder */
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
            httpContext.writeText( ">") ;
            if ( ! isFullAjaxMode( ) )
            {
               getDataAreaObject().renderHtmlContent();
            }
            httpContext.writeText( "</div>") ;
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
            wbLoad = true ;
            return  ;
         }
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "TableMPDoccure", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "TableHeaderD", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpMPW0009"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0009"+"");
            }
            WebComp_Component1.componentdraw();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.ajax_rspEndCmp();
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 tbContentPlaceHolder", "left", "top", "", "", "div");
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         /* Content placeholder */
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
         httpContext.writeText( ">") ;
         if ( ! isFullAjaxMode( ) )
         {
            getDataAreaObject().renderHtmlContent();
         }
         httpContext.writeText( "</div>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "Bottom", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "TableFooter", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpMPW0018"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0018"+"");
            }
            WebComp_Component2.componentdraw();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.ajax_rspEndCmp();
            }
            httpContext.writeText( "</div>") ;
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "Bottom", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start2U2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2U0( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( getDataAreaObject().executeStartEvent() != 0 )
         {
            httpContext.setAjaxCallMode();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void ws2U2( )
   {
      start2U2( ) ;
      evt2U2( ) ;
   }

   public void evt2U2( )
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
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "RFR_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e112U2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e122U2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
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
               else if ( GXutil.strcmp(sEvtType, "M") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, GXutil.len( sEvt)-2) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-6) ;
                  nCmpId = (short)(GXutil.lval( sEvtType)) ;
                  if ( nCmpId == 9 )
                  {
                     WebComp_Component1 = WebUtils.getWebComponent(getClass(), "com.projectthani.wcheader_impl", remoteHandle, context);
                     WebComp_Component1_Component = "WCHeader" ;
                     WebComp_Component1.componentprocess("MPW0009", "", sEvt);
                  }
                  else if ( nCmpId == 18 )
                  {
                     WebComp_Component2 = WebUtils.getWebComponent(getClass(), "com.projectthani.wcfooter_impl", remoteHandle, context);
                     WebComp_Component2_Component = "WCFooter" ;
                     WebComp_Component2.componentprocess("MPW0018", "", sEvt);
                  }
               }
               if ( httpContext.wbHandled == 0 )
               {
                  getDataAreaObject().dispatchEvents();
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void we2U2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm2U2( ) ;
         }
      }
   }

   public void pa2U2( )
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
      rf2U2( ) ;
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

   public void rf2U2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ShowMPWhenPopUp( ) || ! httpContext.isPopUpObject( ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
         {
            if ( GXutil.strcmp(WebComp_Component1_Component, "") == 0 )
            {
               WebComp_Component1 = WebUtils.getWebComponent(getClass(), "com.projectthani.wcheader_impl", remoteHandle, context);
               WebComp_Component1_Component = "WCHeader" ;
            }
            WebComp_Component1.setjustcreated();
            WebComp_Component1.componentprepare(new Object[] {"MPW0009",""});
            WebComp_Component1.componentbind(new Object[] {});
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Component1 )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0009"+"");
               WebComp_Component1.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
            if ( 1 != 0 )
            {
               WebComp_Component1.componentstart();
            }
         }
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
         {
            if ( GXutil.strcmp(WebComp_Component2_Component, "") == 0 )
            {
               WebComp_Component2 = WebUtils.getWebComponent(getClass(), "com.projectthani.wcfooter_impl", remoteHandle, context);
               WebComp_Component2_Component = "WCFooter" ;
            }
            WebComp_Component2.setjustcreated();
            WebComp_Component2.componentprepare(new Object[] {"MPW0018",""});
            WebComp_Component2.componentbind(new Object[] {});
            if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Component2 )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0018"+"");
               WebComp_Component2.componentdraw();
               httpContext.ajax_rspEndCmp();
            }
            if ( 1 != 0 )
            {
               WebComp_Component2.componentstart();
            }
         }
         gxdyncontrolsrefreshing = true ;
         fix_multi_value_controls( ) ;
         gxdyncontrolsrefreshing = false ;
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e122U2 ();
         wb2U0( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
   }

   public void send_integrity_lvl_hashes2U2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2U0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e112U2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
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
      e112U2 ();
      if (returnInSub) return;
   }

   public void e112U2( )
   {
      /* Start Routine */
      returnInSub = false ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/style.css\" type=\"text/css\">" );
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getHeaderrawhtml()+"<link rel=\"stylesheet\" type=\"text/css\" href=\"./static/all.min-1.css\">" );
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getHeaderrawhtml()+"<link rel=\"stylesheet\" type=\"text/css\" href=\"./static/fontawesome_dc.min.css\">" );
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/HomePagePaciente.css\" type=\"text/css\">" );
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/dataTables.bootstrap4.min.css\" type=\"text/css\">" );
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/responsive.bootstrap4.min.css\" type=\"text/css\">" );
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/bootstrap-4.min.css\" type=\"text/css\">" );
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/sweetalert2.min.css\" type=\"text/css\">" );
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getHeaderrawhtml()+"<link rel=\"shortcut icon\" href=\""+httpContext.convertURL( context.getHttpContext().getImagePath( "62fabb4b-713d-4bd3-9f52-cde8b0a8f851", "", context.getHttpContext().getTheme( )))+"\">" );
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("jquery_min.js") ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("script.js") ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("ShowOpcionVerPerfil.js") ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("jquery.dataTables.min.js") ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("dataTables.bootstrap4.min.js") ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("dataTables.responsive.min.js") ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("responsive.bootstrap4.min.js") ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("DataTables.js") ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("sweetalert2.all.min.js") ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("SweetAlert2.js") ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().add("ActualizarPagina.js") ;
   }

   protected void nextLoad( )
   {
   }

   protected void e122U2( )
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
      pa2U2( ) ;
      ws2U2( ) ;
      we2U2( ) ;
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

   public void master_styles( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( GXutil.strcmp(WebComp_Component1_Component, "") == 0 )
      {
         WebComp_Component1 = WebUtils.getWebComponent(getClass(), "com.projectthani.wcheader_impl", remoteHandle, context);
         WebComp_Component1_Component = "WCHeader" ;
      }
      if ( ! ( WebComp_Component1 == null ) )
      {
         WebComp_Component1.componentthemes();
      }
      if ( GXutil.strcmp(WebComp_Component2_Component, "") == 0 )
      {
         WebComp_Component2 = WebUtils.getWebComponent(getClass(), "com.projectthani.wcfooter_impl", remoteHandle, context);
         WebComp_Component2_Component = "WCFooter" ;
      }
      if ( ! ( WebComp_Component2 == null ) )
      {
         WebComp_Component2.componentthemes();
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().item(idxLst)), "?2022511033423", true, true);
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
      httpContext.AddJavascriptSource("mphomepage.js", "?2022511033423", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      divTable1_Internalname = "TABLE1_MPAGE" ;
      divTable2_Internalname = "TABLE2_MPAGE" ;
      divMaintable_Internalname = "MAINTABLE_MPAGE" ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setInternalname( "FORM_MPAGE" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      Contholder1.setDataArea(getDataAreaObject());
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
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
      setEventMetadata("REFRESH_MPAGE","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH_MPAGE",",oparms:[]}");
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
      Contholder1 = new com.genexus.webpanels.GXDataAreaControl();
      Form = new com.genexus.webpanels.GXWebForm();
      GXKey = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      WebComp_Component1_Component = "" ;
      WebComp_Component2_Component = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sDynURL = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Component1 = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Component2 = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGotPars ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int idxLst ;
   private String GXKey ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable1_Internalname ;
   private String divTable2_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String WebComp_Component1_Component ;
   private String WebComp_Component2_Component ;
   private String sDynURL ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean toggleJsOutput ;
   private boolean bDynCreated_Component1 ;
   private boolean bDynCreated_Component2 ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Component1 ;
   private GXWebComponent WebComp_Component2 ;
   private com.genexus.webpanels.GXDataAreaControl Contholder1 ;
   private com.genexus.webpanels.GXWebForm Form ;
}

