package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class terminoscondicionesproveedor_impl extends GXDataArea
{
   public terminoscondicionesproveedor_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public terminoscondicionesproveedor_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( terminoscondicionesproveedor_impl.class ));
   }

   public terminoscondicionesproveedor_impl( int remoteHandle ,
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
         MasterPageObj= createMasterPage(remoteHandle, "com.projectthani.mphomepage");
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
      pa6J2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start6J2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034340", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.terminoscondicionesproveedor", new String[] {}, new String[] {}) +"\">") ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
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
         we6J2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt6J2( ) ;
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
      return formatLink("com.projectthani.terminoscondicionesproveedor", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "TerminosCondicionesProveedor" ;
   }

   public String getPgmdesc( )
   {
      return "Terminos Condiciones Proveedor" ;
   }

   public void wb6J0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "TableTerminosCondiciones", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTcproveedor_Internalname, lblTcproveedor_Caption, "", "", lblTcproveedor_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_TerminosCondicionesProveedor.htm");
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
         /* User Defined Control */
         ucDvmessage1.render(context, "dvelop.dvmessage", Dvmessage1_Internalname, "DVMESSAGE1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start6J2( )
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
         Form.getMeta().addItem("description", "Terminos Condiciones Proveedor", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6J0( ) ;
   }

   public void ws6J2( )
   {
      start6J2( ) ;
      evt6J2( ) ;
   }

   public void evt6J2( )
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
                           e116J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e126J2 ();
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

   public void we6J2( )
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

   public void pa6J2( )
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
      rf6J2( ) ;
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

   public void rf6J2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e126J2 ();
         wb6J0( ) ;
      }
   }

   public void send_integrity_lvl_hashes6J2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup6J0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e116J2 ();
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
      e116J2 ();
      if (returnInSub) return;
   }

   public void e116J2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_objcol_SdtSDTTermCondProveedor1 = AV8TCProveedorList ;
      GXv_objcol_SdtSDTTermCondProveedor2[0] = GXt_objcol_SdtSDTTermCondProveedor1 ;
      new com.projectthani.prcterminoscondicionesproveedor(remoteHandle, context).execute( GXv_objcol_SdtSDTTermCondProveedor2) ;
      GXt_objcol_SdtSDTTermCondProveedor1 = GXv_objcol_SdtSDTTermCondProveedor2[0] ;
      AV8TCProveedorList = GXt_objcol_SdtSDTTermCondProveedor1 ;
      AV5HtmlTCProveedor += "<div class=\"card\" style=\"background: white;\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
      AV5HtmlTCProveedor += " <div class=\"card-header\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
      AV12GXV1 = 1 ;
      while ( AV12GXV1 <= AV8TCProveedorList.size() )
      {
         AV6TCProveedor = (com.projectthani.SdtSDTTermCondProveedor)((com.projectthani.SdtSDTTermCondProveedor)AV8TCProveedorList.elementAt(-1+AV12GXV1));
         AV5HtmlTCProveedor += "<h3 class=\"card-title\" " ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "style=\"text-align: center;" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "font-size: 22px;" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "font-family:MyriadPro-Regular;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += AV6TCProveedor.getgxTv_SdtSDTTermCondProveedor_Titulo() + "</h3>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += " </div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "<div class=\"card-body\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "<ul class=\"list-group\"style=\"border:0px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "<li class=\"list-group-item\"" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "style=\"text-align:justify;" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "font-size:16px; " ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "margin-top:-15px; " ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "margin-right:-15px; " ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "margin-left:-15px; " ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "padding-left:30px; " ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "padding-right:30px; " ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "font-family:AcuminVariableConcept;" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += "border:0px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV5HtmlTCProveedor += AV6TCProveedor.getgxTv_SdtSDTTermCondProveedor_Descripcion() + "</li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV13GXV2 = 1 ;
         while ( AV13GXV2 <= AV6TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().size() )
         {
            AV7TCProveedorItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)((com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem)AV6TCProveedor.getgxTv_SdtSDTTermCondProveedor_Subsdttermcondproveedor().elementAt(-1+AV13GXV2));
            AV5HtmlTCProveedor += "<li class=\"list-group-item\"" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "style=\"text-align:justify;" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "font-size:16px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "margin-top:-15px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "margin-right:-15px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "margin-left:-15px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "font-weight: 900; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "padding-left:30px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "padding-right:30px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "font-family:AcuminVariableConcept;" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "border:0px none #f0f0f0;\">" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += AV7TCProveedorItem.getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Titulo() + "</li>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "<li class=\"list-group-item\"" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "style=\"text-align:justify;" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "font-size:16px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "margin-top:-15px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "margin-right:-15px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "margin-left:-15px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "padding-left:30px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "padding-right:30px; " ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "font-family:AcuminVariableConcept;" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += "border:0px none #f0f0f0;\">" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV5HtmlTCProveedor += AV7TCProveedorItem.getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Descripcion() + "</li>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
            AV14GXV3 = 1 ;
            while ( AV14GXV3 <= AV7TCProveedorItem.getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor().size() )
            {
               AV9TCProveedorSubItem = (com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem)((com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem)AV7TCProveedorItem.getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_Subsubsdttcproveedor().elementAt(-1+AV14GXV3));
               AV5HtmlTCProveedor += "<li class=\"list-group-item\"" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV5HtmlTCProveedor += "style=\"text-align:justify;" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV5HtmlTCProveedor += "font-size:16px; " ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV5HtmlTCProveedor += "margin-top:-30px; " ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV5HtmlTCProveedor += "margin-right:-15px; " ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV5HtmlTCProveedor += "margin-left:-15px; " ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV5HtmlTCProveedor += "padding-left:60px; " ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV5HtmlTCProveedor += "padding-right:30px; " ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV5HtmlTCProveedor += "font-family:AcuminVariableConcept;" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV5HtmlTCProveedor += "border:0px none #f0f0f0;\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV5HtmlTCProveedor += AV9TCProveedorSubItem.getgxTv_SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem_Descripcion() + "</li>" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
               AV14GXV3 = (int)(AV14GXV3+1) ;
            }
            AV13GXV2 = (int)(AV13GXV2+1) ;
         }
         AV5HtmlTCProveedor += "        </ul>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
         AV12GXV1 = (int)(AV12GXV1+1) ;
      }
      AV5HtmlTCProveedor += "    </div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
      AV5HtmlTCProveedor += "</div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5HtmlTCProveedor", AV5HtmlTCProveedor);
      lblTcproveedor_Caption = AV5HtmlTCProveedor ;
      httpContext.ajax_rsp_assign_prop("", false, lblTcproveedor_Internalname, "Caption", lblTcproveedor_Caption, true);
   }

   protected void nextLoad( )
   {
   }

   protected void e126J2( )
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
      pa6J2( ) ;
      ws6J2( ) ;
      we6J2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511034363", true, true);
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
         httpContext.AddJavascriptSource("messages.spa.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("terminoscondicionesproveedor.js", "?2022511034363", false, true);
         httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTcproveedor_Internalname = "TCPROVEEDOR" ;
      divTable2_Internalname = "TABLE2" ;
      divTable1_Internalname = "TABLE1" ;
      Dvmessage1_Internalname = "DVMESSAGE1" ;
      divMaintable_Internalname = "MAINTABLE" ;
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
      lblTcproveedor_Caption = "Text Block" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Terminos Condiciones Proveedor" );
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
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTcproveedor_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV8TCProveedorList = new GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor>(com.projectthani.SdtSDTTermCondProveedor.class, "SDTTermCondProveedor", "ProjectThani", remoteHandle);
      GXt_objcol_SdtSDTTermCondProveedor1 = new GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor>(com.projectthani.SdtSDTTermCondProveedor.class, "SDTTermCondProveedor", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTTermCondProveedor2 = new GXBaseCollection[1] ;
      AV5HtmlTCProveedor = "" ;
      AV6TCProveedor = new com.projectthani.SdtSDTTermCondProveedor(remoteHandle, context);
      AV7TCProveedorItem = new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem(remoteHandle, context);
      AV9TCProveedorSubItem = new com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int AV12GXV1 ;
   private int AV13GXV2 ;
   private int AV14GXV3 ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable1_Internalname ;
   private String divTable2_Internalname ;
   private String lblTcproveedor_Internalname ;
   private String lblTcproveedor_Caption ;
   private String lblTcproveedor_Jsonclick ;
   private String Dvmessage1_Internalname ;
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
   private String AV5HtmlTCProveedor ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor> AV8TCProveedorList ;
   private GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor> GXt_objcol_SdtSDTTermCondProveedor1 ;
   private GXBaseCollection<com.projectthani.SdtSDTTermCondProveedor> GXv_objcol_SdtSDTTermCondProveedor2[] ;
   private com.projectthani.SdtSDTTermCondProveedor AV6TCProveedor ;
   private com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem AV7TCProveedorItem ;
   private com.projectthani.SdtSDTTermCondProveedor_SubSDTTermCondProveedorItem_SubSubSDTTCProveedorItem AV9TCProveedorSubItem ;
}

