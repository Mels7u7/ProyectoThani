package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_selectimportfile_impl extends GXDataArea
{
   public wwp_selectimportfile_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_selectimportfile_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_selectimportfile_impl.class ));
   }

   public wwp_selectimportfile_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "TransactionName") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "TransactionName") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "TransactionName") ;
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
            AV14TransactionName = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14TransactionName", AV14TransactionName);
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRANSACTIONNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14TransactionName, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV9ImportType = httpContext.GetPar( "ImportType") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9ImportType", AV9ImportType);
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIMPORTTYPE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ImportType, ""))));
               AV6ExtraParmsJson = httpContext.GetPar( "ExtraParmsJson") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV6ExtraParmsJson", AV6ExtraParmsJson);
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEXTRAPARMSJSON", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6ExtraParmsJson, ""))));
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
         MasterPageObj= createMasterPage(remoteHandle, "com.projectthani.wwpbaseobjects.workwithplusmasterpageprompt");
         MasterPageObj.setDataArea(this,true);
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
      pa0K2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0K2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033978", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.wwp_selectimportfile", new String[] {GXutil.URLEncode(GXutil.rtrim(AV14TransactionName)),GXutil.URLEncode(GXutil.rtrim(AV9ImportType)),GXutil.URLEncode(GXutil.rtrim(AV6ExtraParmsJson))}, new String[] {"TransactionName","ImportType","ExtraParmsJson"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIMPORTTYPE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ImportType, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vERRORMSGS", getSecureSignedToken( "", AV5ErrorMsgs));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEXTRAPARMSJSON", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6ExtraParmsJson, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRANSACTIONNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14TransactionName, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vIMPORTTYPE", AV9ImportType);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIMPORTTYPE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ImportType, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vERRORMSGS", AV5ErrorMsgs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vERRORMSGS", AV5ErrorMsgs);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vERRORMSGS", getSecureSignedToken( "", AV5ErrorMsgs));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vEXTRAPARMSJSON", AV6ExtraParmsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEXTRAPARMSJSON", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6ExtraParmsJson, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTRANSACTIONNAME", AV14TransactionName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRANSACTIONNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14TransactionName, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vRET", AV13Ret);
      GXCCtlgxBlob = "vFILTERTOUPLOAD" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, AV7FilterToUpload);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vFILTERTOUPLOAD_Filename", GXutil.rtrim( edtavFiltertoupload_Filename));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vFILTERTOUPLOAD_Filename", GXutil.rtrim( edtavFiltertoupload_Filename));
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
         we0K2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0K2( ) ;
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
      return formatLink("com.projectthani.wwpbaseobjects.wwp_selectimportfile", new String[] {GXutil.URLEncode(GXutil.rtrim(AV14TransactionName)),GXutil.URLEncode(GXutil.rtrim(AV9ImportType)),GXutil.URLEncode(GXutil.rtrim(AV6ExtraParmsJson))}, new String[] {"TransactionName","ImportType","ExtraParmsJson"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.WWP_SelectImportFile" ;
   }

   public String getPgmdesc( )
   {
      return "Select file to import" ;
   }

   public void wb0K0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransactionPopUp", "left", "top", "", "", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "TableData", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell AttributeImportFileCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFiltertoupload_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFiltertoupload_Internalname, "File", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'',0)\"" ;
         edtavFiltertoupload_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavFiltertoupload_Internalname, "Filetype", edtavFiltertoupload_Filetype, true);
         if ( ! (GXutil.strcmp("", AV7FilterToUpload)==0) )
         {
            gxblobfileaux.setSource( AV7FilterToUpload );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtavFiltertoupload_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtavFiltertoupload_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               AV7FilterToUpload = gxblobfileaux.getURI() ;
               httpContext.ajax_rsp_assign_prop("", false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV7FilterToUpload), true);
               edtavFiltertoupload_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop("", false, edtavFiltertoupload_Internalname, "Filetype", edtavFiltertoupload_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop("", false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV7FilterToUpload), true);
         }
         com.projectthani.GxWebStd.gx_blob_field( httpContext, edtavFiltertoupload_Internalname, GXutil.rtrim( AV7FilterToUpload), httpContext.getResourceRelative(AV7FilterToUpload), ((GXutil.strcmp("", edtavFiltertoupload_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtavFiltertoupload_Filetype)==0) ? AV7FilterToUpload : edtavFiltertoupload_Filetype)) : edtavFiltertoupload_Contenttype), false, "", edtavFiltertoupload_Parameters, 0, edtavFiltertoupload_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtavFiltertoupload_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,17);\"", "", "", "HLP_WWPBaseObjects\\WWP_SelectImportFile.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupRight", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", "Import", bttBtnenter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_SelectImportFile.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnucancel_Internalname, "", "Cancel", bttBtnucancel_Jsonclick, 5, "Cancel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUCANCEL\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_SelectImportFile.htm");
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

   public void start0K2( )
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
         Form.getMeta().addItem("description", "Select file to import", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0K0( ) ;
   }

   public void ws0K2( )
   {
      start0K2( ) ;
      evt0K2( ) ;
   }

   public void evt0K2( )
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
                           e110K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUCANCEL'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUCancel' */
                           e120K2 ();
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
                                 e130K2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e140K2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e150K2 ();
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

   public void we0K2( )
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

   public void pa0K2( )
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
            GX_FocusControl = edtavFiltertoupload_Internalname ;
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
      rf0K2( ) ;
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

   public void rf0K2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e140K2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e150K2 ();
         wb0K0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0K2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vIMPORTTYPE", AV9ImportType);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIMPORTTYPE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ImportType, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vERRORMSGS", AV5ErrorMsgs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vERRORMSGS", AV5ErrorMsgs);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vERRORMSGS", getSecureSignedToken( "", AV5ErrorMsgs));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vEXTRAPARMSJSON", AV6ExtraParmsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEXTRAPARMSJSON", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6ExtraParmsJson, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTRANSACTIONNAME", AV14TransactionName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRANSACTIONNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14TransactionName, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0K0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110K2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         edtavFiltertoupload_Filename = httpContext.cgiGet( "vFILTERTOUPLOAD_Filename") ;
         /* Read variables values. */
         AV7FilterToUpload = httpContext.cgiGet( edtavFiltertoupload_Internalname) ;
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         if ( (GXutil.strcmp("", AV7FilterToUpload)==0) )
         {
            GXCCtlgxBlob = "vFILTERTOUPLOAD" + "_gxBlob" ;
            AV7FilterToUpload = httpContext.cgiGet( GXCCtlgxBlob) ;
         }
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
      e110K2 ();
      if (returnInSub) return;
   }

   public void e110K2( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e120K2( )
   {
      /* 'DoUCancel' Routine */
      returnInSub = false ;
      httpContext.GX_msglist.addItem("<#CLEAR#>");
      AV13Ret = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Ret", AV13Ret);
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e130K2 ();
      if (returnInSub) return;
   }

   public void e130K2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV8FilterToUploadExt = edtavFiltertoupload_Filename ;
      AV8FilterToUploadExt = ((GXutil.strSearch( AV8FilterToUploadExt, ".", 1)>0) ? GXutil.substring( AV8FilterToUploadExt, GXutil.strSearchRev( AV8FilterToUploadExt, ".", -1)+1, GXutil.len( AV8FilterToUploadExt)-GXutil.strSearchRev( AV8FilterToUploadExt, ".", -1)) : "") ;
      httpContext.GX_msglist.addItem("<#CLEAR#>");
      if ( ! (GXutil.strcmp("", AV7FilterToUpload)==0) )
      {
         if ( ( ( GXutil.strcmp(GXutil.upper( AV8FilterToUploadExt), "CSV") == 0 ) && ( GXutil.strcmp(AV9ImportType, "CSV") == 0 ) ) || ( ( GXutil.strcmp(GXutil.upper( AV8FilterToUploadExt), "XLSX") == 0 ) && ( GXutil.strcmp(AV9ImportType, "Excel") == 0 ) ) )
         {
            AV12ResultMsg = "" ;
            GXv_objcol_SdtMessages_Message1[0] = AV5ErrorMsgs ;
            if ( new com.projectthani.wwpbaseobjects.wwp_importdata(remoteHandle, context).executeUdp( AV14TransactionName, AV9ImportType, AV7FilterToUpload, AV6ExtraParmsJson, GXv_objcol_SdtMessages_Message1) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            AV5ErrorMsgs = GXv_objcol_SdtMessages_Message1[0] ;
            if ( Cond_result )
            {
               AV10LastErrorType = (byte)(2) ;
               AV25GXV1 = 1 ;
               while ( AV25GXV1 <= AV5ErrorMsgs.size() )
               {
                  AV11Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV5ErrorMsgs.elementAt(-1+AV25GXV1));
                  if ( ! (GXutil.strcmp("", AV12ResultMsg)==0) )
                  {
                     AV12ResultMsg += GXutil.newLine( ) ;
                     if ( ( AV10LastErrorType == 0 ) && ( AV11Message.getgxTv_SdtMessages_Message_Type() == 2 ) )
                     {
                        AV12ResultMsg += GXutil.newLine( ) ;
                     }
                  }
                  AV10LastErrorType = AV11Message.getgxTv_SdtMessages_Message_Type() ;
                  AV12ResultMsg += AV11Message.getgxTv_SdtMessages_Message_Description() ;
                  AV25GXV1 = (int)(AV25GXV1+1) ;
               }
               httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "File import success", AV12ResultMsg, "success", "", "na", ""));
               AV13Ret = true ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Ret", AV13Ret);
               httpContext.doAjaxRefresh();
            }
            else
            {
               AV7FilterToUpload = "" ;
               httpContext.ajax_rsp_assign_prop("", false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV7FilterToUpload), true);
               AV26GXV2 = 1 ;
               while ( AV26GXV2 <= AV5ErrorMsgs.size() )
               {
                  AV11Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV5ErrorMsgs.elementAt(-1+AV26GXV2));
                  if ( ! (GXutil.strcmp("", AV12ResultMsg)==0) )
                  {
                     AV12ResultMsg += GXutil.newLine( ) ;
                     if ( GXutil.strcmp(AV11Message.getgxTv_SdtMessages_Message_Id(), "WWP_LineId") == 0 )
                     {
                        AV12ResultMsg += GXutil.newLine( ) ;
                     }
                  }
                  AV12ResultMsg += AV11Message.getgxTv_SdtMessages_Message_Description() ;
                  AV26GXV2 = (int)(AV26GXV2+1) ;
               }
               httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "Error importing file", AV12ResultMsg, "error", "", "false", ""));
            }
         }
         else
         {
            AV7FilterToUpload = "" ;
            httpContext.ajax_rsp_assign_prop("", false, edtavFiltertoupload_Internalname, "URL", httpContext.getResourceRelative(AV7FilterToUpload), true);
            AV12ResultMsg = GXutil.format( "The expected file type is %1.", ((GXutil.strcmp(AV9ImportType, "CSV")==0) ? "csv" : "xlsx"), "", "", "", "", "", "", "", "") ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "Invalid file type", AV12ResultMsg, "error", "", "na", ""));
         }
      }
      else
      {
         httpContext.GX_msglist.addItem(GXutil.format( "%1 es requerido.", "File", "", "", "", "", "", "", "", ""));
      }
      /*  Sending Event outputs  */
   }

   public void e140K2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      if ( AV13Ret )
      {
         httpContext.setWebReturnParms(new Object[] {AV14TransactionName,AV9ImportType,AV6ExtraParmsJson});
         httpContext.setWebReturnParmsMetadata(new Object[] {"AV14TransactionName","AV9ImportType","AV6ExtraParmsJson"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e150K2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV14TransactionName = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14TransactionName", AV14TransactionName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRANSACTIONNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14TransactionName, ""))));
      AV9ImportType = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9ImportType", AV9ImportType);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIMPORTTYPE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ImportType, ""))));
      AV6ExtraParmsJson = (String)getParm(obj,2) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6ExtraParmsJson", AV6ExtraParmsJson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEXTRAPARMSJSON", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6ExtraParmsJson, ""))));
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
      pa0K2( ) ;
      ws0K2( ) ;
      we0K2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033996", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/wwp_selectimportfile.js", "?2022511033996", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavFiltertoupload_Internalname = "vFILTERTOUPLOAD" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtnucancel_Internalname = "BTNUCANCEL" ;
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
      edtavFiltertoupload_Jsonclick = "" ;
      edtavFiltertoupload_Parameters = "" ;
      edtavFiltertoupload_Contenttype = "" ;
      edtavFiltertoupload_Filetype = "" ;
      edtavFiltertoupload_Enabled = 1 ;
      edtavFiltertoupload_Filename = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Select file to import" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV13Ret',fld:'vRET',pic:''},{av:'AV5ErrorMsgs',fld:'vERRORMSGS',pic:'',hsh:true},{av:'AV9ImportType',fld:'vIMPORTTYPE',pic:'',hsh:true},{av:'AV6ExtraParmsJson',fld:'vEXTRAPARMSJSON',pic:'',hsh:true},{av:'AV14TransactionName',fld:'vTRANSACTIONNAME',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUCANCEL'","{handler:'e120K2',iparms:[]");
      setEventMetadata("'DOUCANCEL'",",oparms:[{av:'AV13Ret',fld:'vRET',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e130K2',iparms:[{av:'edtavFiltertoupload_Filename',ctrl:'vFILTERTOUPLOAD',prop:'Filename'},{av:'AV7FilterToUpload',fld:'vFILTERTOUPLOAD',pic:''},{av:'AV9ImportType',fld:'vIMPORTTYPE',pic:'',hsh:true},{av:'AV5ErrorMsgs',fld:'vERRORMSGS',pic:'',hsh:true},{av:'AV6ExtraParmsJson',fld:'vEXTRAPARMSJSON',pic:'',hsh:true},{av:'AV14TransactionName',fld:'vTRANSACTIONNAME',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV13Ret',fld:'vRET',pic:''},{av:'AV7FilterToUpload',fld:'vFILTERTOUPLOAD',pic:''}]}");
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
      wcpOAV14TransactionName = "" ;
      wcpOAV9ImportType = "" ;
      wcpOAV6ExtraParmsJson = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV14TransactionName = "" ;
      AV9ImportType = "" ;
      AV6ExtraParmsJson = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV5ErrorMsgs = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXKey = "" ;
      GXCCtlgxBlob = "" ;
      AV7FilterToUpload = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      bttBtnenter_Jsonclick = "" ;
      bttBtnucancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV8FilterToUploadExt = "" ;
      AV12ResultMsg = "" ;
      GXv_objcol_SdtMessages_Message1 = new GXBaseCollection[1] ;
      AV11Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV10LastErrorType ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavFiltertoupload_Enabled ;
   private int AV25GXV1 ;
   private int AV26GXV2 ;
   private int idxLst ;
   private String edtavFiltertoupload_Filename ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GXCCtlgxBlob ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableattributes_Internalname ;
   private String edtavFiltertoupload_Internalname ;
   private String TempTags ;
   private String edtavFiltertoupload_Filetype ;
   private String edtavFiltertoupload_Contenttype ;
   private String edtavFiltertoupload_Parameters ;
   private String edtavFiltertoupload_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtnucancel_Internalname ;
   private String bttBtnucancel_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV13Ret ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private String AV7FilterToUpload ;
   private String wcpOAV14TransactionName ;
   private String wcpOAV9ImportType ;
   private String wcpOAV6ExtraParmsJson ;
   private String AV14TransactionName ;
   private String AV9ImportType ;
   private String AV6ExtraParmsJson ;
   private String AV8FilterToUploadExt ;
   private String AV12ResultMsg ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV5ErrorMsgs ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message1[] ;
   private com.genexus.SdtMessages_Message AV11Message ;
}

