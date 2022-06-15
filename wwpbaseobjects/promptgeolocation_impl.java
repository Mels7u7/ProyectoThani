package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class promptgeolocation_impl extends GXWebPanel
{
   public promptgeolocation_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public promptgeolocation_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( promptgeolocation_impl.class ));
   }

   public promptgeolocation_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "Geolocation") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "Geolocation") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "Geolocation") ;
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
            AV7Geolocation = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7Geolocation", AV7Geolocation);
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
         pa0E2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws0E2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we0E2( ) ;
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
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( "Seleccionar Geolocalización") ;
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
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033887", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("GXGoogleVisualizationLibrary/MAP/mapsproviders.js", "", false, true);
      httpContext.AddJavascriptSource("GXGoogleVisualizationLibrary/MAP/Gxmap.js", "", false, true);
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      httpContext.writeText( " "+"class=\"FormNoBackgroundColor\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"FormNoBackgroundColor\" data-gx-class=\"FormNoBackgroundColor\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.promptgeolocation", new String[] {GXutil.URLEncode(GXutil.rtrim(AV7Geolocation))}, new String[] {"Geolocation"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "FormNoBackgroundColor", true);
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGXMAPDATA", GxMapData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGXMAPDATA", GxMapData);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vLATITUDE", AV10Latitude);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vLONGITUDE", AV11Longitude);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGEOLOCATION", AV7Geolocation);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEMAPCONTROL1_Provider", GXutil.rtrim( Googlemapcontrol1_Provider));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEMAPCONTROL1_Type", GXutil.rtrim( Googlemapcontrol1_Type));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEMAPCONTROL1_City", GXutil.rtrim( Googlemapcontrol1_City));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEMAPCONTROL1_Latitude", GXutil.rtrim( Googlemapcontrol1_Latitude));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEMAPCONTROL1_Longitude", GXutil.rtrim( Googlemapcontrol1_Longitude));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEMAPCONTROL1_Precision", GXutil.ltrim( localUtil.ntoc( Googlemapcontrol1_Precision, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEMAPCONTROL1_Onclick", GXutil.rtrim( Googlemapcontrol1_Onclick));
   }

   public void renderHtmlCloseForm0E2( )
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
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.PromptGeolocation" ;
   }

   public String getPgmdesc( )
   {
      return "Seleccionar Geolocalización" ;
   }

   public void wb0E0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         wb_table1_2_0E2( true) ;
      }
      else
      {
         wb_table1_2_0E2( false) ;
      }
      return  ;
   }

   public void wb_table1_2_0E2e( boolean wbgen )
   {
      if ( wbgen )
      {
      }
      wbLoad = true ;
   }

   public void start0E2( )
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
         Form.getMeta().addItem("description", "Seleccionar Geolocalización", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0E0( ) ;
   }

   public void ws0E2( )
   {
      start0E2( ) ;
      evt0E2( ) ;
   }

   public void evt0E2( )
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
                        e110E2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! wbErr )
                        {
                           Rfr0gs = false ;
                           if ( ! Rfr0gs )
                           {
                              /* Execute user event: Enter */
                              e120E2 ();
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e130E2 ();
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

   public void we0E2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm0E2( ) ;
         }
      }
   }

   public void pa0E2( )
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
      rf0E2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "WWPBaseObjects.PromptGeolocation" ;
      Gx_err = (short)(0) ;
   }

   public void rf0E2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e130E2 ();
         wb0E0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0E2( )
   {
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "WWPBaseObjects.PromptGeolocation" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0E0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vGXMAPDATA"), GxMapData);
         /* Read saved values. */
         AV10Latitude = httpContext.cgiGet( "vLATITUDE") ;
         AV11Longitude = httpContext.cgiGet( "vLONGITUDE") ;
         Googlemapcontrol1_Provider = httpContext.cgiGet( "GOOGLEMAPCONTROL1_Provider") ;
         Googlemapcontrol1_Type = httpContext.cgiGet( "GOOGLEMAPCONTROL1_Type") ;
         Googlemapcontrol1_City = httpContext.cgiGet( "GOOGLEMAPCONTROL1_City") ;
         Googlemapcontrol1_Latitude = httpContext.cgiGet( "GOOGLEMAPCONTROL1_Latitude") ;
         Googlemapcontrol1_Longitude = httpContext.cgiGet( "GOOGLEMAPCONTROL1_Longitude") ;
         Googlemapcontrol1_Precision = (int)(localUtil.ctol( httpContext.cgiGet( "GOOGLEMAPCONTROL1_Precision"), ",", ".")) ;
         Googlemapcontrol1_Onclick = httpContext.cgiGet( "GOOGLEMAPCONTROL1_Onclick") ;
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
      e110E2 ();
      if (returnInSub) return;
   }

   public void e110E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV12SplittedGeolocation = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV7Geolocation,",")) ;
      if ( AV12SplittedGeolocation.size() == 2 )
      {
         GxMapPoint.setgxTv_SdtGxMap_Point_Pointlat( GXutil.trim( (String)AV12SplittedGeolocation.elementAt(-1+1)) );
         GxMapPoint.setgxTv_SdtGxMap_Point_Pointlong( GXutil.trim( (String)AV12SplittedGeolocation.elementAt(-1+2)) );
         GxMapData.getgxTv_SdtGxMap_Points().add(GxMapPoint, 0);
         Googlemapcontrol1_Latitude = GXutil.trim( (String)AV12SplittedGeolocation.elementAt(-1+1)) ;
         ucGooglemapcontrol1.sendProperty(context, "", false, Googlemapcontrol1_Internalname, "Latitude", Googlemapcontrol1_Latitude);
         Googlemapcontrol1_Longitude = GXutil.trim( (String)AV12SplittedGeolocation.elementAt(-1+2)) ;
         ucGooglemapcontrol1.sendProperty(context, "", false, Googlemapcontrol1_Internalname, "Longitude", Googlemapcontrol1_Longitude);
      }
      GXt_boolean1 = AV14IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "PromptGeolocation", GXv_boolean2) ;
      promptgeolocation_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV14IsAuthorized = GXt_boolean1 ;
      if ( ! AV14IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e120E2 ();
      if (returnInSub) return;
   }

   public void e120E2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV10Latitude)==0) || ! (GXutil.strcmp("", GXutil.trim( AV7Geolocation))==0) )
      {
         if ( ! (GXutil.strcmp("", AV10Latitude)==0) )
         {
            AV7Geolocation = AV10Latitude + "," + AV11Longitude ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7Geolocation", AV7Geolocation);
         }
         httpContext.setWebReturnParms(new Object[] {AV7Geolocation});
         httpContext.setWebReturnParmsMetadata(new Object[] {"AV7Geolocation"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e130E2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_2_0E2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         sStyleString += " height: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(420), 10, 0) + "px" + ";" ;
         sStyleString += " width: " + GXutil.ltrimstr( DecimalUtil.doubleToDec(618), 10, 0) + "px" + ";" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablemain_Internalname, tblTablemain_Internalname, "", "TableMain", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='PopupContentCell'>") ;
         wb_table2_8_0E2( true) ;
      }
      else
      {
         wb_table2_8_0E2( false) ;
      }
      return  ;
   }

   public void wb_table2_8_0E2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divActiongroup_actions_Internalname, 1, 0, "px", 0, "px", "ActionGroupRight", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 15,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", "Seleccionar Geolocalización", bttBtnenter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\PromptGeolocation.htm");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", "Cancelar", bttBtncancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\PromptGeolocation.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_2_0E2e( true) ;
      }
      else
      {
         wb_table1_2_0E2e( false) ;
      }
   }

   public void wb_table2_8_0E2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblUtgeolocation_Internalname, tblUtgeolocation_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr class='Table'>") ;
         httpContext.writeText( "<td class='Table'>") ;
         /* User Defined Control */
         ucGooglemapcontrol1.setProperty("Title", Googlemapcontrol1_Title);
         ucGooglemapcontrol1.setProperty("Provider", Googlemapcontrol1_Provider);
         ucGooglemapcontrol1.setProperty("Type", Googlemapcontrol1_Type);
         ucGooglemapcontrol1.setProperty("City", Googlemapcontrol1_City);
         ucGooglemapcontrol1.setProperty("Latitude", Googlemapcontrol1_Latitude);
         ucGooglemapcontrol1.setProperty("Longitude", Googlemapcontrol1_Longitude);
         ucGooglemapcontrol1.setProperty("Precision", Googlemapcontrol1_Precision);
         ucGooglemapcontrol1.setProperty("GxMap", GxMapData);
         ucGooglemapcontrol1.setProperty("ClickLatitude", AV10Latitude);
         ucGooglemapcontrol1.setProperty("ClickLongitude", AV11Longitude);
         ucGooglemapcontrol1.setProperty("Onclick", Googlemapcontrol1_Onclick);
         ucGooglemapcontrol1.render(context, "googlemapcontrol", Googlemapcontrol1_Internalname, "GOOGLEMAPCONTROL1Container");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_8_0E2e( true) ;
      }
      else
      {
         wb_table2_8_0E2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV7Geolocation = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7Geolocation", AV7Geolocation);
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
      pa0E2( ) ;
      ws0E2( ) ;
      we0E2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202251103397", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/promptgeolocation.js", "?202251103398", false, true);
      httpContext.AddJavascriptSource("GXGoogleVisualizationLibrary/MAP/mapsproviders.js", "", false, true);
      httpContext.AddJavascriptSource("GXGoogleVisualizationLibrary/MAP/Gxmap.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      Googlemapcontrol1_Internalname = "GOOGLEMAPCONTROL1" ;
      tblUtgeolocation_Internalname = "UTGEOLOCATION" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      divActiongroup_actions_Internalname = "ACTIONGROUP_ACTIONS" ;
      tblTablemain_Internalname = "TABLEMAIN" ;
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
      Googlemapcontrol1_Title = "Map Title" ;
      Googlemapcontrol1_Onclick = "getvalue" ;
      Googlemapcontrol1_Precision = 15 ;
      Googlemapcontrol1_City = "" ;
      Googlemapcontrol1_Type = "G_NORMAL_MAP" ;
      Googlemapcontrol1_Provider = "GOOGLE" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
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
      setEventMetadata("ENTER","{handler:'e120E2',iparms:[{av:'AV10Latitude',fld:'vLATITUDE',pic:''},{av:'AV7Geolocation',fld:'vGEOLOCATION',pic:''},{av:'AV11Longitude',fld:'vLONGITUDE',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7Geolocation',fld:'vGEOLOCATION',pic:''}]}");
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
      wcpOAV7Geolocation = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV7Geolocation = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GxMapData = new com.projectthani.SdtGxMap(remoteHandle, context);
      AV10Latitude = "" ;
      AV11Longitude = "" ;
      Googlemapcontrol1_Latitude = "" ;
      Googlemapcontrol1_Longitude = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV18Pgmname = "" ;
      AV12SplittedGeolocation = new GXSimpleCollection<String>(String.class, "internal", "");
      GxMapPoint = new com.projectthani.SdtGxMap_Point(remoteHandle, context);
      ucGooglemapcontrol1 = new com.genexus.webpanels.GXUserControl();
      GXv_boolean2 = new boolean[1] ;
      sStyleString = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      AV18Pgmname = "WWPBaseObjects.PromptGeolocation" ;
      /* GeneXus formulas. */
      AV18Pgmname = "WWPBaseObjects.PromptGeolocation" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int Googlemapcontrol1_Precision ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Googlemapcontrol1_Provider ;
   private String Googlemapcontrol1_Type ;
   private String Googlemapcontrol1_City ;
   private String Googlemapcontrol1_Latitude ;
   private String Googlemapcontrol1_Longitude ;
   private String Googlemapcontrol1_Onclick ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV18Pgmname ;
   private String Googlemapcontrol1_Internalname ;
   private String sStyleString ;
   private String tblTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divActiongroup_actions_Internalname ;
   private String TempTags ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String tblUtgeolocation_Internalname ;
   private String Googlemapcontrol1_Title ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV14IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String wcpOAV7Geolocation ;
   private String AV7Geolocation ;
   private String AV10Latitude ;
   private String AV11Longitude ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGooglemapcontrol1 ;
   private com.projectthani.SdtGxMap_Point GxMapPoint ;
   private GXSimpleCollection<String> AV12SplittedGeolocation ;
   private com.projectthani.SdtGxMap GxMapData ;
}

