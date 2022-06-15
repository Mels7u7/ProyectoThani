package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class editbookmark_impl extends GXDataArea
{
   public editbookmark_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public editbookmark_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( editbookmark_impl.class ));
   }

   public editbookmark_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "InBookmarkURL") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "InBookmarkURL") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "InBookmarkURL") ;
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
            AV16InBookmarkURL = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16InBookmarkURL", AV16InBookmarkURL);
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINBOOKMARKURL", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV16InBookmarkURL, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV9BookmarkPageDescription = httpContext.GetPar( "BookmarkPageDescription") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9BookmarkPageDescription", AV9BookmarkPageDescription);
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBOOKMARKPAGEDESCRIPTION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9BookmarkPageDescription, ""))));
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
      pa1A2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1A2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110331288", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.editbookmark", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16InBookmarkURL)),GXutil.URLEncode(GXutil.rtrim(AV9BookmarkPageDescription))}, new String[] {"InBookmarkURL","BookmarkPageDescription"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vI", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29i), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINBOOKMARKURL", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV16InBookmarkURL, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBOOKMARKPAGEDESCRIPTION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9BookmarkPageDescription, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vI", GXutil.ltrim( localUtil.ntoc( AV29i, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vI", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29i), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINBOOKMARKURL", AV16InBookmarkURL);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINBOOKMARKURL", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV16InBookmarkURL, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISEDIT", AV18IsEdit);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vBOOKMARKPAGEDESCRIPTION", AV9BookmarkPageDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBOOKMARKPAGEDESCRIPTION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9BookmarkPageDescription, ""))));
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
         we1A2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1A2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.projectthani.wwpbaseobjects.editbookmark", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16InBookmarkURL)),GXutil.URLEncode(GXutil.rtrim(AV9BookmarkPageDescription))}, new String[] {"InBookmarkURL","BookmarkPageDescription"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.EditBookmark" ;
   }

   public String getPgmdesc( )
   {
      return "Add/Edit Bookmark" ;
   }

   public void wb1A0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 PopupContentCell", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContent", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablebookmarkname_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 MergeLabelCell CellWidth_12_5", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockbookmarkname_Internalname, "Nombre", "", "", lblTextblockbookmarkname_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\EditBookmark.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 CellWidth_87_5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavBookmarkname_Internalname, "Bookmark Name", "col-sm-3 AttributeRealWidthLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavBookmarkname_Internalname, AV5BookmarkName, GXutil.rtrim( localUtil.format( AV5BookmarkName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,21);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBookmarkname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavBookmarkname_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\EditBookmark.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablebookmarkurl_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 MergeLabelCell CellWidth_12_5", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockbookmarkurl_Internalname, "Dirección", "", "", lblTextblockbookmarkurl_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\EditBookmark.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 CellWidth_87_5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavBookmarkurl_Internalname, "Bookmark URL", "col-sm-3 AttributeRealWidthLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavBookmarkurl_Internalname, AV10BookmarkURL, GXutil.rtrim( localUtil.format( AV10BookmarkURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", AV10BookmarkURL, "_blank", "", "", edtavBookmarkurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavBookmarkurl_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_WWPBaseObjects\\EditBookmark.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupRight", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", "Guardar", bttBtnenter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\EditBookmark.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndel_Internalname, "", "REMOVE", bttBtndel_Jsonclick, 5, "REMOVE", "", StyleString, ClassString, bttBtndel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DODEL\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\EditBookmark.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", "Cancelar", bttBtncancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\EditBookmark.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start1A2( )
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
         Form.getMeta().addItem("description", "Add/Edit Bookmark", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1A0( ) ;
   }

   public void ws1A2( )
   {
      start1A2( ) ;
      evt1A2( ) ;
   }

   public void evt1A2( )
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
                           e111A2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DODEL'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoDel' */
                           e121A2 ();
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
                                 e131A2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e141A2 ();
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

   public void we1A2( )
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

   public void pa1A2( )
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
            GX_FocusControl = edtavBookmarkname_Internalname ;
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf1A2( ) ;
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

   public void rf1A2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e141A2 ();
         wb1A0( ) ;
      }
   }

   public void send_integrity_lvl_hashes1A2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vI", GXutil.ltrim( localUtil.ntoc( AV29i, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vI", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29i), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINBOOKMARKURL", AV16InBookmarkURL);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINBOOKMARKURL", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV16InBookmarkURL, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup1A0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV5BookmarkName = httpContext.cgiGet( edtavBookmarkname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5BookmarkName", AV5BookmarkName);
         AV10BookmarkURL = httpContext.cgiGet( edtavBookmarkurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10BookmarkURL", AV10BookmarkURL);
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
      e111A2 ();
      if (returnInSub) return;
   }

   public void e111A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV10BookmarkURL = AV16InBookmarkURL ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10BookmarkURL", AV10BookmarkURL);
      AV5BookmarkName = AV9BookmarkPageDescription ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5BookmarkName", AV5BookmarkName);
      AV13GridStateCollection.fromxml(new com.projectthani.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( "AppBookmarks"), null, null);
      AV29i = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29i), 4, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vI", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29i), "ZZZ9")));
      AV33GXV1 = 1 ;
      while ( AV33GXV1 <= AV13GridStateCollection.size() )
      {
         AV14GridStateCollectionItem = (com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)((com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)AV13GridStateCollection.elementAt(-1+AV33GXV1));
         if ( GXutil.strcmp(AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml(), AV10BookmarkURL) == 0 )
         {
            AV30ProgramDescription = AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Title() ;
            if (true) break;
         }
         else
         {
            AV29i = (short)(AV29i+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29i), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vI", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29i), "ZZZ9")));
         }
         AV33GXV1 = (int)(AV33GXV1+1) ;
      }
      if ( AV29i > AV13GridStateCollection.size() )
      {
         bttBtndel_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtndel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndel_Visible), 5, 0), true);
         Form.setCaption( "Bookmark this page" );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      }
      else
      {
         Form.setCaption( "Edit Bookmark for this page" );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      }
   }

   public void e121A2( )
   {
      /* 'DoDel' Routine */
      returnInSub = false ;
      AV13GridStateCollection.fromxml(new com.projectthani.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( "AppBookmarks"), null, null);
      if ( AV29i <= AV13GridStateCollection.size() )
      {
         AV13GridStateCollection.removeItem(AV29i);
         new com.projectthani.wwpbaseobjects.savemanagefiltersstate(remoteHandle, context).execute( "AppBookmarks", AV13GridStateCollection.toxml(false, true, "Items", "")) ;
         this.executeExternalObjectMethod("", false, "GlobalEvents", "Master_RefreshHeader", new Object[] {}, true);
         httpContext.setWebReturnParms(new Object[] {AV16InBookmarkURL});
         httpContext.setWebReturnParmsMetadata(new Object[] {"AV16InBookmarkURL"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e131A2 ();
      if (returnInSub) return;
   }

   public void e131A2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV5BookmarkName = GXutil.trim( AV5BookmarkName) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5BookmarkName", AV5BookmarkName);
      if ( (GXutil.strcmp("", AV5BookmarkName)==0) )
      {
         httpContext.GX_msglist.addItem("Empty");
      }
      else
      {
         AV13GridStateCollection.fromxml(new com.projectthani.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( "AppBookmarks"), null, null);
         AV19IsNameUnique = true ;
         AV34GXV2 = 1 ;
         while ( AV34GXV2 <= AV13GridStateCollection.size() )
         {
            AV14GridStateCollectionItem = (com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)((com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)AV13GridStateCollection.elementAt(-1+AV34GXV2));
            if ( GXutil.strcmp(AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml(), AV10BookmarkURL) == 0 )
            {
               AV18IsEdit = true ;
               httpContext.ajax_rsp_assign_attri("", false, "AV18IsEdit", AV18IsEdit);
            }
            AV34GXV2 = (int)(AV34GXV2+1) ;
         }
         if ( AV18IsEdit )
         {
            AV35GXV3 = 1 ;
            while ( AV35GXV3 <= AV13GridStateCollection.size() )
            {
               AV14GridStateCollectionItem = (com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)((com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)AV13GridStateCollection.elementAt(-1+AV35GXV3));
               if ( GXutil.strcmp(AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml(), AV10BookmarkURL) == 0 )
               {
                  AV14GridStateCollectionItem.setgxTv_SdtGridStateCollection_Item_Title( AV5BookmarkName );
               }
               AV35GXV3 = (int)(AV35GXV3+1) ;
            }
         }
         else
         {
            AV14GridStateCollectionItem = (com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)new com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
            AV14GridStateCollectionItem.setgxTv_SdtGridStateCollection_Item_Title( AV5BookmarkName );
            AV14GridStateCollectionItem.setgxTv_SdtGridStateCollection_Item_Gridstatexml( AV10BookmarkURL );
            AV13GridStateCollection.add(AV14GridStateCollectionItem, 1);
         }
         new com.projectthani.wwpbaseobjects.savemanagefiltersstate(remoteHandle, context).execute( "AppBookmarks", AV13GridStateCollection.toxml(false, true, "Items", "")) ;
         this.executeExternalObjectMethod("", false, "GlobalEvents", "Master_RefreshHeader", new Object[] {}, true);
         httpContext.setWebReturnParms(new Object[] {AV16InBookmarkURL});
         httpContext.setWebReturnParmsMetadata(new Object[] {"AV16InBookmarkURL"});
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

   protected void e141A2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV16InBookmarkURL = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16InBookmarkURL", AV16InBookmarkURL);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINBOOKMARKURL", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV16InBookmarkURL, ""))));
      AV9BookmarkPageDescription = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9BookmarkPageDescription", AV9BookmarkPageDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBOOKMARKPAGEDESCRIPTION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9BookmarkPageDescription, ""))));
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
      pa1A2( ) ;
      ws1A2( ) ;
      we1A2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110331322", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/editbookmark.js", "?20225110331323", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockbookmarkname_Internalname = "TEXTBLOCKBOOKMARKNAME" ;
      edtavBookmarkname_Internalname = "vBOOKMARKNAME" ;
      divUnnamedtablebookmarkname_Internalname = "UNNAMEDTABLEBOOKMARKNAME" ;
      lblTextblockbookmarkurl_Internalname = "TEXTBLOCKBOOKMARKURL" ;
      edtavBookmarkurl_Internalname = "vBOOKMARKURL" ;
      divUnnamedtablebookmarkurl_Internalname = "UNNAMEDTABLEBOOKMARKURL" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtndel_Internalname = "BTNDEL" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      bttBtndel_Visible = 1 ;
      edtavBookmarkurl_Jsonclick = "" ;
      edtavBookmarkurl_Enabled = 1 ;
      edtavBookmarkname_Jsonclick = "" ;
      edtavBookmarkname_Enabled = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Add/Edit Bookmark" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV29i',fld:'vI',pic:'ZZZ9',hsh:true},{av:'AV9BookmarkPageDescription',fld:'vBOOKMARKPAGEDESCRIPTION',pic:'',hsh:true},{av:'AV16InBookmarkURL',fld:'vINBOOKMARKURL',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DODEL'","{handler:'e121A2',iparms:[{av:'AV29i',fld:'vI',pic:'ZZZ9',hsh:true},{av:'AV16InBookmarkURL',fld:'vINBOOKMARKURL',pic:'',hsh:true}]");
      setEventMetadata("'DODEL'",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e131A2',iparms:[{av:'AV5BookmarkName',fld:'vBOOKMARKNAME',pic:''},{av:'AV10BookmarkURL',fld:'vBOOKMARKURL',pic:''},{av:'AV18IsEdit',fld:'vISEDIT',pic:''},{av:'AV16InBookmarkURL',fld:'vINBOOKMARKURL',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV5BookmarkName',fld:'vBOOKMARKNAME',pic:''},{av:'AV18IsEdit',fld:'vISEDIT',pic:''}]}");
      setEventMetadata("VALIDV_BOOKMARKURL","{handler:'validv_Bookmarkurl',iparms:[]");
      setEventMetadata("VALIDV_BOOKMARKURL",",oparms:[]}");
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
      wcpOAV16InBookmarkURL = "" ;
      wcpOAV9BookmarkPageDescription = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV16InBookmarkURL = "" ;
      AV9BookmarkPageDescription = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblockbookmarkname_Jsonclick = "" ;
      TempTags = "" ;
      AV5BookmarkName = "" ;
      lblTextblockbookmarkurl_Jsonclick = "" ;
      AV10BookmarkURL = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtndel_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV13GridStateCollection = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item>(com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item.class, "Item", "", remoteHandle);
      AV14GridStateCollectionItem = new com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
      AV30ProgramDescription = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short AV29i ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavBookmarkname_Enabled ;
   private int edtavBookmarkurl_Enabled ;
   private int bttBtndel_Visible ;
   private int AV33GXV1 ;
   private int AV34GXV2 ;
   private int AV35GXV3 ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
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
   private String divUnnamedtablebookmarkname_Internalname ;
   private String lblTextblockbookmarkname_Internalname ;
   private String lblTextblockbookmarkname_Jsonclick ;
   private String edtavBookmarkname_Internalname ;
   private String TempTags ;
   private String edtavBookmarkname_Jsonclick ;
   private String divUnnamedtablebookmarkurl_Internalname ;
   private String lblTextblockbookmarkurl_Internalname ;
   private String lblTextblockbookmarkurl_Jsonclick ;
   private String edtavBookmarkurl_Internalname ;
   private String edtavBookmarkurl_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtndel_Internalname ;
   private String bttBtndel_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV18IsEdit ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV19IsNameUnique ;
   private String wcpOAV16InBookmarkURL ;
   private String wcpOAV9BookmarkPageDescription ;
   private String AV16InBookmarkURL ;
   private String AV9BookmarkPageDescription ;
   private String AV5BookmarkName ;
   private String AV10BookmarkURL ;
   private String AV30ProgramDescription ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item> AV13GridStateCollection ;
   private com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item AV14GridStateCollectionItem ;
}

