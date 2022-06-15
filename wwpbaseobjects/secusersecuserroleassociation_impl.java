package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secusersecuserroleassociation_impl extends GXDataArea
{
   public secusersecuserroleassociation_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secusersecuserroleassociation_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secusersecuserroleassociation_impl.class ));
   }

   public secusersecuserroleassociation_impl( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      lstavNotassociatedrecords = new HTMLChoice();
      lstavAssociatedrecords = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "SecUserId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "SecUserId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "SecUserId") ;
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
            AV8SecUserId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecUserId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8SecUserId), "ZZZ9")));
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
      pa0W2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0W2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110331110", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.secusersecuserroleassociation", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8SecUserId,4,0))}, new String[] {"SecUserId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8SecUserId), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vADDEDKEYLIST", AV21AddedKeyList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vADDEDKEYLIST", AV21AddedKeyList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vADDEDDSCLIST", AV23AddedDscList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vADDEDDSCLIST", AV23AddedDscList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vNOTADDEDKEYLIST", AV22NotAddedKeyList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vNOTADDEDKEYLIST", AV22NotAddedKeyList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vNOTADDEDDSCLIST", AV24NotAddedDscList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vNOTADDEDDSCLIST", AV24NotAddedDscList);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vADDEDKEYLISTXML", AV17AddedKeyListXml);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vADDEDDSCLISTXML", AV19AddedDscListXml);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vNOTADDEDKEYLISTXML", AV18NotAddedKeyListXml);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vNOTADDEDDSCLISTXML", AV20NotAddedDscListXml);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECUSERID", GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECUSERID", GXutil.ltrim( localUtil.ntoc( AV8SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8SecUserId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECROLEID", GXutil.ltrim( localUtil.ntoc( A4SecRoleId, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSERROLE", AV12SecUserRole);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSERROLE", AV12SecUserRole);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECROLEID", GXutil.ltrim( localUtil.ntoc( AV9SecRoleId, (byte)(4), (byte)(0), ",", "")));
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
         we0W2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0W2( ) ;
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
      return formatLink("com.projectthani.wwpbaseobjects.secusersecuserroleassociation", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8SecUserId,4,0))}, new String[] {"SecUserId"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecUserSecUserRoleAssociation" ;
   }

   public String getPgmdesc( )
   {
      return "Sec User Sec User Role Association" ;
   }

   public void wb0W0( )
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablefullcontent_Internalname, 1, 0, "px", 0, "px", "TableAssociation", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablenotassociated_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 AssociationTitleCell", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblNotassociatedrecordstitle_Internalname, "Registros No Asociados", "", "", lblNotassociatedrecordstitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "AssociationTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecUserSecUserRoleAssociation.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, lstavNotassociatedrecords.getInternalname(), "Not Associated Records", "col-sm-3 AssociationListAttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         /* ListBox */
         com.projectthani.GxWebStd.gx_listbox_ctrl1( httpContext, lstavNotassociatedrecords, lstavNotassociatedrecords.getInternalname(), GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0)), 2, lstavNotassociatedrecords.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, lstavNotassociatedrecords.getEnabled(), 0, (short)(0), 4, "em", 0, "row", "", "AssociationListAttribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(1), "HLP_WWPBaseObjects\\SecUserSecUserRoleAssociation.htm");
         lstavNotassociatedrecords.setValue( GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, lstavNotassociatedrecords.getInternalname(), "Values", lstavNotassociatedrecords.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-1 CellTableAssociationButtons", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableassociationbuttons_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2 col-sm-12 hidden-sm hidden-md hidden-lg", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2 col-sm-12 CellMarginTopAssociationButtons", "left", "top", "", "", "div");
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
         ClassString = "AssociationImage" ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "6591e2a3-49b6-43b7-b8e3-a292564a32a4", "", context.getHttpContext().getTheme( )) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgImageassociateall_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 5, imgImageassociateall_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'ASSOCIATE ALL\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecUserSecUserRoleAssociation.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2 col-sm-12 CellMarginTopAssociationButtons", "left", "top", "", "", "div");
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         ClassString = "AssociationImage" ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "56a5f17b-0bc3-48b5-b303-afa6e0585b6d", "", context.getHttpContext().getTheme( )) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgImageassociateselected_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 5, imgImageassociateselected_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'ASSOCIATE SELECTED\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecUserSecUserRoleAssociation.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2 col-sm-12 CellMarginTopAssociationButtons", "left", "top", "", "", "div");
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
         ClassString = "AssociationImage" ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "a3800d0c-bf04-4575-bc01-11fe5d7b3525", "", context.getHttpContext().getTheme( )) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgImagedisassociateselected_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 5, imgImagedisassociateselected_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DISASSOCIATE SELECTED\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecUserSecUserRoleAssociation.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2 col-sm-12 CellMarginTopAssociationButtons", "left", "top", "", "", "div");
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
         ClassString = "AssociationImage" ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "c619e28f-4b32-4ff9-baaf-b3063fe4f782", "", context.getHttpContext().getTheme( )) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgImagedisassociateall_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 5, imgImagedisassociateall_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DISASSOCIATE ALL\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\SecUserSecUserRoleAssociation.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableassociated_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 AssociationTitleCell", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblAssociatedrecordstitle_Internalname, "Registros Asociados", "", "", lblAssociatedrecordstitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "AssociationTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecUserSecUserRoleAssociation.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, lstavAssociatedrecords.getInternalname(), "Associated Records", "col-sm-3 AssociationListAttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
         /* ListBox */
         com.projectthani.GxWebStd.gx_listbox_ctrl1( httpContext, lstavAssociatedrecords, lstavAssociatedrecords.getInternalname(), GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0)), 2, lstavAssociatedrecords.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, lstavAssociatedrecords.getEnabled(), 0, (short)(0), 4, "em", 0, "row", "", "AssociationListAttribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "", true, (byte)(1), "HLP_WWPBaseObjects\\SecUserSecUserRoleAssociation.htm");
         lstavAssociatedrecords.setValue( GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, lstavAssociatedrecords.getInternalname(), "Values", lstavAssociatedrecords.ToJavascriptSource(), true);
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirm_Internalname, "", "Confirmar", bttBtnconfirm_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecUserSecUserRoleAssociation.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", "Cancelar", bttBtncancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecUserSecUserRoleAssociation.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
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

   public void start0W2( )
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
         Form.getMeta().addItem("description", "Sec User Sec User Role Association", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0W0( ) ;
   }

   public void ws0W2( )
   {
      start0W2( ) ;
      evt0W2( ) ;
   }

   public void evt0W2( )
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
                           e110W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e120W2 ();
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
                                 e130W2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DISASSOCIATE SELECTED'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Disassociate Selected' */
                           e140W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ASSOCIATE SELECTED'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Associate selected' */
                           e150W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ASSOCIATE ALL'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Associate All' */
                           e160W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DISASSOCIATE ALL'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Disassociate All' */
                           e170W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VASSOCIATEDRECORDS.DBLCLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e180W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VNOTASSOCIATEDRECORDS.DBLCLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e190W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e200W2 ();
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "VASSOCIATEDRECORDS.DBLCLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e180W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VNOTASSOCIATEDRECORDS.DBLCLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e190W2 ();
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

   public void we0W2( )
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

   public void pa0W2( )
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
            GX_FocusControl = lstavNotassociatedrecords.getInternalname() ;
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
      if ( lstavNotassociatedrecords.getItemCount() > 0 )
      {
         AV25NotAssociatedRecords = (short)(GXutil.lval( lstavNotassociatedrecords.getValidValue(GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25NotAssociatedRecords", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25NotAssociatedRecords), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         lstavNotassociatedrecords.setValue( GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, lstavNotassociatedrecords.getInternalname(), "Values", lstavNotassociatedrecords.ToJavascriptSource(), true);
      }
      if ( lstavAssociatedrecords.getItemCount() > 0 )
      {
         AV26AssociatedRecords = (short)(GXutil.lval( lstavAssociatedrecords.getValidValue(GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26AssociatedRecords", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26AssociatedRecords), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         lstavAssociatedrecords.setValue( GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, lstavAssociatedrecords.getInternalname(), "Values", lstavAssociatedrecords.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf0W2( ) ;
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

   public void rf0W2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e120W2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e200W2 ();
         wb0W0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0W2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0W0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110W2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         lstavNotassociatedrecords.setValue( httpContext.cgiGet( lstavNotassociatedrecords.getInternalname()) );
         AV25NotAssociatedRecords = (short)(GXutil.lval( httpContext.cgiGet( lstavNotassociatedrecords.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25NotAssociatedRecords", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25NotAssociatedRecords), 4, 0));
         lstavAssociatedrecords.setValue( httpContext.cgiGet( lstavAssociatedrecords.getInternalname()) );
         AV26AssociatedRecords = (short)(GXutil.lval( httpContext.cgiGet( lstavAssociatedrecords.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26AssociatedRecords", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26AssociatedRecords), 4, 0));
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
      e110W2 ();
      if (returnInSub) return;
   }

   public void e110W2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV30WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV30WWPContext = GXv_SdtWWPContext1[0] ;
      if ( GXutil.strcmp(AV10HTTPRequest.getMethod(), "GET") == 0 )
      {
         AV33GXLvl8 = (byte)(0) ;
         /* Using cursor H000W2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV8SecUserId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A6SecUserId = H000W2_A6SecUserId[0] ;
            AV33GXLvl8 = (byte)(1) ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV33GXLvl8 == 0 )
         {
            httpContext.GX_msglist.addItem("Registro no encontrado");
         }
         /* Using cursor H000W3 */
         pr_default.execute(1);
         while ( (pr_default.getStatus(1) != 101) )
         {
            A4SecRoleId = H000W3_A4SecRoleId[0] ;
            A13SecRoleName = H000W3_A13SecRoleName[0] ;
            A12SecRoleDescription = H000W3_A12SecRoleDescription[0] ;
            AV11Exist = false ;
            /* Using cursor H000W4 */
            pr_default.execute(2, new Object[] {Short.valueOf(AV8SecUserId), Short.valueOf(A4SecRoleId)});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A6SecUserId = H000W4_A6SecUserId[0] ;
               AV11Exist = true ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(2);
            AV14Description = A12SecRoleDescription + " (" + A13SecRoleName + ")" ;
            if ( AV11Exist )
            {
               AV27InsertIndex = 1 ;
               while ( ( AV27InsertIndex <= AV23AddedDscList.size() ) && ( GXutil.strcmp((String)AV23AddedDscList.elementAt(-1+AV27InsertIndex), AV14Description) < 0 ) )
               {
                  AV27InsertIndex = (int)(AV27InsertIndex+1) ;
               }
               AV21AddedKeyList.add((short)(A4SecRoleId), AV27InsertIndex);
               AV23AddedDscList.add(AV14Description, AV27InsertIndex);
            }
            else
            {
               AV27InsertIndex = 1 ;
               while ( ( AV27InsertIndex <= AV24NotAddedDscList.size() ) && ( GXutil.strcmp((String)AV24NotAddedDscList.elementAt(-1+AV27InsertIndex), AV14Description) < 0 ) )
               {
                  AV27InsertIndex = (int)(AV27InsertIndex+1) ;
               }
               AV22NotAddedKeyList.add((short)(A4SecRoleId), AV27InsertIndex);
               AV24NotAddedDscList.add(AV14Description, AV27InsertIndex);
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
         /* Execute user subroutine: 'SAVELISTS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Using cursor H000W5 */
      pr_default.execute(3, new Object[] {Short.valueOf(AV8SecUserId)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A6SecUserId = H000W5_A6SecUserId[0] ;
         A14SecUserName = H000W5_A14SecUserName[0] ;
         Form.setCaption( GXutil.format( "Associate Roles to User :: %1", A14SecUserName, "", "", "", "", "", "", "", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(3);
   }

   public void e120W2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'UPDATEASSOCIATIONVARIABLES' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      lstavAssociatedrecords.setValue( GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavAssociatedrecords.getInternalname(), "Values", lstavAssociatedrecords.ToJavascriptSource(), true);
      lstavNotassociatedrecords.setValue( GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavNotassociatedrecords.getInternalname(), "Values", lstavNotassociatedrecords.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23AddedDscList", AV23AddedDscList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21AddedKeyList", AV21AddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22NotAddedKeyList", AV22NotAddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24NotAddedDscList", AV24NotAddedDscList);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e130W2 ();
      if (returnInSub) return;
   }

   public void e130W2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADLISTS' */
      S132 ();
      if (returnInSub) return;
      AV15i = 1 ;
      AV13Success = true ;
      AV37GXV1 = 1 ;
      while ( AV37GXV1 <= AV21AddedKeyList.size() )
      {
         AV9SecRoleId = ((Number) AV21AddedKeyList.elementAt(-1+AV37GXV1)).shortValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
         if ( AV13Success )
         {
            AV11Exist = false ;
            /* Using cursor H000W6 */
            pr_default.execute(4, new Object[] {Short.valueOf(AV8SecUserId), Short.valueOf(AV9SecRoleId)});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A4SecRoleId = H000W6_A4SecRoleId[0] ;
               A6SecUserId = H000W6_A6SecUserId[0] ;
               AV11Exist = true ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(4);
            if ( ! AV11Exist )
            {
               AV12SecUserRole = (com.projectthani.wwpbaseobjects.SdtSecUserRole)new com.projectthani.wwpbaseobjects.SdtSecUserRole( remoteHandle, context);
               AV12SecUserRole.setgxTv_SdtSecUserRole_Secuserid( AV8SecUserId );
               AV12SecUserRole.setgxTv_SdtSecUserRole_Secroleid( AV9SecRoleId );
               AV12SecUserRole.Save();
               if ( ! AV12SecUserRole.Success() )
               {
                  AV13Success = false ;
               }
            }
         }
         AV15i = (int)(AV15i+1) ;
         AV37GXV1 = (int)(AV37GXV1+1) ;
      }
      AV15i = 1 ;
      AV39GXV2 = 1 ;
      while ( AV39GXV2 <= AV22NotAddedKeyList.size() )
      {
         AV9SecRoleId = ((Number) AV22NotAddedKeyList.elementAt(-1+AV39GXV2)).shortValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
         if ( AV13Success )
         {
            AV11Exist = false ;
            /* Using cursor H000W7 */
            pr_default.execute(5, new Object[] {Short.valueOf(AV8SecUserId), Short.valueOf(AV9SecRoleId)});
            while ( (pr_default.getStatus(5) != 101) )
            {
               A4SecRoleId = H000W7_A4SecRoleId[0] ;
               A6SecUserId = H000W7_A6SecUserId[0] ;
               AV11Exist = true ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(5);
            if ( AV11Exist )
            {
               AV12SecUserRole = (com.projectthani.wwpbaseobjects.SdtSecUserRole)new com.projectthani.wwpbaseobjects.SdtSecUserRole( remoteHandle, context);
               AV12SecUserRole.Load(AV8SecUserId, AV9SecRoleId);
               if ( AV12SecUserRole.Success() )
               {
                  AV12SecUserRole.Delete();
               }
               if ( ! AV12SecUserRole.Success() )
               {
                  AV13Success = false ;
               }
            }
         }
         AV15i = (int)(AV15i+1) ;
         AV39GXV2 = (int)(AV39GXV2+1) ;
      }
      if ( AV13Success )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secusersecuserroleassociation");
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      else
      {
         /* Execute user subroutine: 'SHOW ERROR MESSAGES' */
         S142 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12SecUserRole", AV12SecUserRole);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23AddedDscList", AV23AddedDscList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21AddedKeyList", AV21AddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22NotAddedKeyList", AV22NotAddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24NotAddedDscList", AV24NotAddedDscList);
   }

   public void e140W2( )
   {
      /* 'Disassociate Selected' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'DISASSOCIATESELECTED' */
      S152 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22NotAddedKeyList", AV22NotAddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24NotAddedDscList", AV24NotAddedDscList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21AddedKeyList", AV21AddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23AddedDscList", AV23AddedDscList);
      lstavAssociatedrecords.setValue( GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavAssociatedrecords.getInternalname(), "Values", lstavAssociatedrecords.ToJavascriptSource(), true);
      lstavNotassociatedrecords.setValue( GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavNotassociatedrecords.getInternalname(), "Values", lstavNotassociatedrecords.ToJavascriptSource(), true);
   }

   public void e150W2( )
   {
      /* 'Associate selected' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ASSOCIATESELECTED' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21AddedKeyList", AV21AddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23AddedDscList", AV23AddedDscList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22NotAddedKeyList", AV22NotAddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24NotAddedDscList", AV24NotAddedDscList);
      lstavAssociatedrecords.setValue( GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavAssociatedrecords.getInternalname(), "Values", lstavAssociatedrecords.ToJavascriptSource(), true);
      lstavNotassociatedrecords.setValue( GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavNotassociatedrecords.getInternalname(), "Values", lstavNotassociatedrecords.ToJavascriptSource(), true);
   }

   public void e160W2( )
   {
      /* 'Associate All' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ASSOCIATEALL' */
      S172 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UPDATEASSOCIATIONVARIABLES' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21AddedKeyList", AV21AddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23AddedDscList", AV23AddedDscList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22NotAddedKeyList", AV22NotAddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24NotAddedDscList", AV24NotAddedDscList);
      lstavAssociatedrecords.setValue( GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavAssociatedrecords.getInternalname(), "Values", lstavAssociatedrecords.ToJavascriptSource(), true);
      lstavNotassociatedrecords.setValue( GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavNotassociatedrecords.getInternalname(), "Values", lstavNotassociatedrecords.ToJavascriptSource(), true);
   }

   public void e170W2( )
   {
      /* 'Disassociate All' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ASSOCIATEALL' */
      S172 ();
      if (returnInSub) return;
      AV22NotAddedKeyList = AV21AddedKeyList.Clone() ;
      AV24NotAddedDscList = AV23AddedDscList.Clone() ;
      AV23AddedDscList.clear();
      AV21AddedKeyList.clear();
      /* Execute user subroutine: 'SAVELISTS' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UPDATEASSOCIATIONVARIABLES' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22NotAddedKeyList", AV22NotAddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24NotAddedDscList", AV24NotAddedDscList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23AddedDscList", AV23AddedDscList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21AddedKeyList", AV21AddedKeyList);
      lstavAssociatedrecords.setValue( GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavAssociatedrecords.getInternalname(), "Values", lstavAssociatedrecords.ToJavascriptSource(), true);
      lstavNotassociatedrecords.setValue( GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavNotassociatedrecords.getInternalname(), "Values", lstavNotassociatedrecords.ToJavascriptSource(), true);
   }

   public void e180W2( )
   {
      /* Associatedrecords_Dblclick Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'DISASSOCIATESELECTED' */
      S152 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22NotAddedKeyList", AV22NotAddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24NotAddedDscList", AV24NotAddedDscList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21AddedKeyList", AV21AddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23AddedDscList", AV23AddedDscList);
      lstavAssociatedrecords.setValue( GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavAssociatedrecords.getInternalname(), "Values", lstavAssociatedrecords.ToJavascriptSource(), true);
      lstavNotassociatedrecords.setValue( GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavNotassociatedrecords.getInternalname(), "Values", lstavNotassociatedrecords.ToJavascriptSource(), true);
   }

   public void e190W2( )
   {
      /* Notassociatedrecords_Dblclick Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ASSOCIATESELECTED' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21AddedKeyList", AV21AddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV23AddedDscList", AV23AddedDscList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22NotAddedKeyList", AV22NotAddedKeyList);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24NotAddedDscList", AV24NotAddedDscList);
      lstavAssociatedrecords.setValue( GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavAssociatedrecords.getInternalname(), "Values", lstavAssociatedrecords.ToJavascriptSource(), true);
      lstavNotassociatedrecords.setValue( GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, lstavNotassociatedrecords.getInternalname(), "Values", lstavNotassociatedrecords.ToJavascriptSource(), true);
   }

   public void S122( )
   {
      /* 'UPDATEASSOCIATIONVARIABLES' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADLISTS' */
      S132 ();
      if (returnInSub) return;
      lstavAssociatedrecords.removeAllItems();
      lstavNotassociatedrecords.removeAllItems();
      AV15i = 1 ;
      AV41GXV3 = 1 ;
      while ( AV41GXV3 <= AV21AddedKeyList.size() )
      {
         AV9SecRoleId = ((Number) AV21AddedKeyList.elementAt(-1+AV41GXV3)).shortValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
         AV14Description = (String)AV23AddedDscList.elementAt(-1+AV15i) ;
         lstavAssociatedrecords.addItem(GXutil.trim( GXutil.str( AV9SecRoleId, 4, 0)), GXutil.trim( AV14Description), (short)(0));
         AV15i = (int)(AV15i+1) ;
         AV41GXV3 = (int)(AV41GXV3+1) ;
      }
      AV15i = 1 ;
      AV42GXV4 = 1 ;
      while ( AV42GXV4 <= AV22NotAddedKeyList.size() )
      {
         AV9SecRoleId = ((Number) AV22NotAddedKeyList.elementAt(-1+AV42GXV4)).shortValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
         AV14Description = (String)AV24NotAddedDscList.elementAt(-1+AV15i) ;
         lstavNotassociatedrecords.addItem(GXutil.trim( GXutil.str( AV9SecRoleId, 4, 0)), GXutil.trim( AV14Description), (short)(0));
         AV15i = (int)(AV15i+1) ;
         AV42GXV4 = (int)(AV42GXV4+1) ;
      }
   }

   public void S142( )
   {
      /* 'SHOW ERROR MESSAGES' Routine */
      returnInSub = false ;
      AV44GXV6 = 1 ;
      AV43GXV5 = AV12SecUserRole.GetMessages() ;
      while ( AV44GXV6 <= AV43GXV5.size() )
      {
         AV16Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV43GXV5.elementAt(-1+AV44GXV6));
         if ( AV16Message.getgxTv_SdtMessages_Message_Type() == 1 )
         {
            httpContext.GX_msglist.addItem(AV16Message.getgxTv_SdtMessages_Message_Description());
         }
         AV44GXV6 = (int)(AV44GXV6+1) ;
      }
   }

   public void S132( )
   {
      /* 'LOADLISTS' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV17AddedKeyListXml)==0) )
      {
         AV23AddedDscList.fromxml(AV19AddedDscListXml, null, null);
         AV21AddedKeyList.fromxml(AV17AddedKeyListXml, null, null);
      }
      if ( ! (GXutil.strcmp("", AV18NotAddedKeyListXml)==0) )
      {
         AV22NotAddedKeyList.fromxml(AV18NotAddedKeyListXml, null, null);
         AV24NotAddedDscList.fromxml(AV20NotAddedDscListXml, null, null);
      }
   }

   public void S112( )
   {
      /* 'SAVELISTS' Routine */
      returnInSub = false ;
      if ( AV21AddedKeyList.size() > 0 )
      {
         AV17AddedKeyListXml = AV21AddedKeyList.toxml(false, true, "Collection", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17AddedKeyListXml", AV17AddedKeyListXml);
         AV19AddedDscListXml = AV23AddedDscList.toxml(false, true, "Collection", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19AddedDscListXml", AV19AddedDscListXml);
      }
      else
      {
         AV17AddedKeyListXml = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17AddedKeyListXml", AV17AddedKeyListXml);
         AV19AddedDscListXml = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19AddedDscListXml", AV19AddedDscListXml);
      }
      if ( AV22NotAddedKeyList.size() > 0 )
      {
         AV18NotAddedKeyListXml = AV22NotAddedKeyList.toxml(false, true, "Collection", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18NotAddedKeyListXml", AV18NotAddedKeyListXml);
         AV20NotAddedDscListXml = AV24NotAddedDscList.toxml(false, true, "Collection", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20NotAddedDscListXml", AV20NotAddedDscListXml);
      }
      else
      {
         AV18NotAddedKeyListXml = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18NotAddedKeyListXml", AV18NotAddedKeyListXml);
         AV20NotAddedDscListXml = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20NotAddedDscListXml", AV20NotAddedDscListXml);
      }
   }

   public void S172( )
   {
      /* 'ASSOCIATEALL' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADLISTS' */
      S132 ();
      if (returnInSub) return;
      AV15i = 1 ;
      AV27InsertIndex = 1 ;
      AV45GXV7 = 1 ;
      while ( AV45GXV7 <= AV22NotAddedKeyList.size() )
      {
         AV9SecRoleId = ((Number) AV22NotAddedKeyList.elementAt(-1+AV45GXV7)).shortValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
         AV14Description = (String)AV24NotAddedDscList.elementAt(-1+AV15i) ;
         while ( ( AV27InsertIndex <= AV23AddedDscList.size() ) && ( GXutil.strcmp((String)AV23AddedDscList.elementAt(-1+AV27InsertIndex), AV14Description) < 0 ) )
         {
            AV27InsertIndex = (int)(AV27InsertIndex+1) ;
         }
         AV21AddedKeyList.add((short)(AV9SecRoleId), AV27InsertIndex);
         AV23AddedDscList.add(AV14Description, AV27InsertIndex);
         AV15i = (int)(AV15i+1) ;
         AV45GXV7 = (int)(AV45GXV7+1) ;
      }
      AV22NotAddedKeyList.clear();
      AV24NotAddedDscList.clear();
      /* Execute user subroutine: 'SAVELISTS' */
      S112 ();
      if (returnInSub) return;
   }

   public void S162( )
   {
      /* 'ASSOCIATESELECTED' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADLISTS' */
      S132 ();
      if (returnInSub) return;
      AV15i = 1 ;
      AV46GXV8 = 1 ;
      while ( AV46GXV8 <= AV22NotAddedKeyList.size() )
      {
         AV9SecRoleId = ((Number) AV22NotAddedKeyList.elementAt(-1+AV46GXV8)).shortValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
         if ( AV9SecRoleId == AV25NotAssociatedRecords )
         {
            if (true) break;
         }
         AV15i = (int)(AV15i+1) ;
         AV46GXV8 = (int)(AV46GXV8+1) ;
      }
      if ( AV15i <= AV22NotAddedKeyList.size() )
      {
         AV14Description = (String)AV24NotAddedDscList.elementAt(-1+AV15i) ;
         AV27InsertIndex = 1 ;
         while ( ( AV27InsertIndex <= AV23AddedDscList.size() ) && ( GXutil.strcmp((String)AV23AddedDscList.elementAt(-1+AV27InsertIndex), AV14Description) < 0 ) )
         {
            AV27InsertIndex = (int)(AV27InsertIndex+1) ;
         }
         AV21AddedKeyList.add((short)(AV25NotAssociatedRecords), AV27InsertIndex);
         AV23AddedDscList.add(AV14Description, AV27InsertIndex);
         AV22NotAddedKeyList.removeItem(AV15i);
         AV24NotAddedDscList.removeItem(AV15i);
         /* Execute user subroutine: 'SAVELISTS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'UPDATEASSOCIATIONVARIABLES' */
      S122 ();
      if (returnInSub) return;
   }

   public void S152( )
   {
      /* 'DISASSOCIATESELECTED' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADLISTS' */
      S132 ();
      if (returnInSub) return;
      AV15i = 1 ;
      AV47GXV9 = 1 ;
      while ( AV47GXV9 <= AV21AddedKeyList.size() )
      {
         AV9SecRoleId = ((Number) AV21AddedKeyList.elementAt(-1+AV47GXV9)).shortValue() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecRoleId), 4, 0));
         if ( AV9SecRoleId == AV26AssociatedRecords )
         {
            if (true) break;
         }
         AV15i = (int)(AV15i+1) ;
         AV47GXV9 = (int)(AV47GXV9+1) ;
      }
      if ( AV15i <= AV21AddedKeyList.size() )
      {
         AV14Description = (String)AV23AddedDscList.elementAt(-1+AV15i) ;
         AV27InsertIndex = 1 ;
         while ( ( AV27InsertIndex <= AV24NotAddedDscList.size() ) && ( GXutil.strcmp((String)AV24NotAddedDscList.elementAt(-1+AV27InsertIndex), AV14Description) < 0 ) )
         {
            AV27InsertIndex = (int)(AV27InsertIndex+1) ;
         }
         AV22NotAddedKeyList.add((short)(AV26AssociatedRecords), AV27InsertIndex);
         AV24NotAddedDscList.add(AV14Description, AV27InsertIndex);
         AV21AddedKeyList.removeItem(AV15i);
         AV23AddedDscList.removeItem(AV15i);
         /* Execute user subroutine: 'SAVELISTS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'UPDATEASSOCIATIONVARIABLES' */
      S122 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e200W2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8SecUserId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecUserId), 4, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8SecUserId), "ZZZ9")));
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
      pa0W2( ) ;
      ws0W2( ) ;
      we0W2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110331182", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secusersecuserroleassociation.js", "?20225110331182", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblNotassociatedrecordstitle_Internalname = "NOTASSOCIATEDRECORDSTITLE" ;
      lstavNotassociatedrecords.setInternalname( "vNOTASSOCIATEDRECORDS" );
      divTablenotassociated_Internalname = "TABLENOTASSOCIATED" ;
      imgImageassociateall_Internalname = "IMAGEASSOCIATEALL" ;
      imgImageassociateselected_Internalname = "IMAGEASSOCIATESELECTED" ;
      imgImagedisassociateselected_Internalname = "IMAGEDISASSOCIATESELECTED" ;
      imgImagedisassociateall_Internalname = "IMAGEDISASSOCIATEALL" ;
      divUnnamedtableassociationbuttons_Internalname = "UNNAMEDTABLEASSOCIATIONBUTTONS" ;
      lblAssociatedrecordstitle_Internalname = "ASSOCIATEDRECORDSTITLE" ;
      lstavAssociatedrecords.setInternalname( "vASSOCIATEDRECORDS" );
      divTableassociated_Internalname = "TABLEASSOCIATED" ;
      divTablefullcontent_Internalname = "TABLEFULLCONTENT" ;
      bttBtnconfirm_Internalname = "BTNCONFIRM" ;
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
      lstavAssociatedrecords.setJsonclick( "" );
      lstavAssociatedrecords.setEnabled( 1 );
      lstavNotassociatedrecords.setJsonclick( "" );
      lstavNotassociatedrecords.setEnabled( 1 );
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Sec User Sec User Role Association" );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      lstavNotassociatedrecords.setName( "vNOTASSOCIATEDRECORDS" );
      lstavNotassociatedrecords.setWebtags( "" );
      if ( lstavNotassociatedrecords.getItemCount() > 0 )
      {
         AV25NotAssociatedRecords = (short)(GXutil.lval( lstavNotassociatedrecords.getValidValue(GXutil.trim( GXutil.str( AV25NotAssociatedRecords, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25NotAssociatedRecords", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25NotAssociatedRecords), 4, 0));
      }
      lstavAssociatedrecords.setName( "vASSOCIATEDRECORDS" );
      lstavAssociatedrecords.setWebtags( "" );
      if ( lstavAssociatedrecords.getItemCount() > 0 )
      {
         AV26AssociatedRecords = (short)(GXutil.lval( lstavAssociatedrecords.getValidValue(GXutil.trim( GXutil.str( AV26AssociatedRecords, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26AssociatedRecords", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26AssociatedRecords), 4, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''},{av:'AV8SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'lstavAssociatedrecords'},{av:'AV26AssociatedRecords',fld:'vASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'lstavNotassociatedrecords'},{av:'AV25NotAssociatedRecords',fld:'vNOTASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e130W2',iparms:[{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'A6SecUserId',fld:'SECUSERID',pic:'ZZZ9'},{av:'AV8SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''},{av:'AV12SecUserRole',fld:'vSECUSERROLE',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV12SecUserRole',fld:'vSECUSERROLE',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''}]}");
      setEventMetadata("'DISASSOCIATE SELECTED'","{handler:'e140W2',iparms:[{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'lstavAssociatedrecords'},{av:'AV26AssociatedRecords',fld:'vASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''}]");
      setEventMetadata("'DISASSOCIATE SELECTED'",",oparms:[{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''},{av:'lstavAssociatedrecords'},{av:'AV26AssociatedRecords',fld:'vASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'lstavNotassociatedrecords'},{av:'AV25NotAssociatedRecords',fld:'vNOTASSOCIATEDRECORDS',pic:'ZZZ9'}]}");
      setEventMetadata("'ASSOCIATE SELECTED'","{handler:'e150W2',iparms:[{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'lstavNotassociatedrecords'},{av:'AV25NotAssociatedRecords',fld:'vNOTASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''}]");
      setEventMetadata("'ASSOCIATE SELECTED'",",oparms:[{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''},{av:'lstavAssociatedrecords'},{av:'AV26AssociatedRecords',fld:'vASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'lstavNotassociatedrecords'},{av:'AV25NotAssociatedRecords',fld:'vNOTASSOCIATEDRECORDS',pic:'ZZZ9'}]}");
      setEventMetadata("'ASSOCIATE ALL'","{handler:'e160W2',iparms:[{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''}]");
      setEventMetadata("'ASSOCIATE ALL'",",oparms:[{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'lstavAssociatedrecords'},{av:'AV26AssociatedRecords',fld:'vASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'lstavNotassociatedrecords'},{av:'AV25NotAssociatedRecords',fld:'vNOTASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''}]}");
      setEventMetadata("'DISASSOCIATE ALL'","{handler:'e170W2',iparms:[{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''}]");
      setEventMetadata("'DISASSOCIATE ALL'",",oparms:[{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''},{av:'lstavAssociatedrecords'},{av:'AV26AssociatedRecords',fld:'vASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'lstavNotassociatedrecords'},{av:'AV25NotAssociatedRecords',fld:'vNOTASSOCIATEDRECORDS',pic:'ZZZ9'}]}");
      setEventMetadata("VASSOCIATEDRECORDS.DBLCLICK","{handler:'e180W2',iparms:[{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'lstavAssociatedrecords'},{av:'AV26AssociatedRecords',fld:'vASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''}]");
      setEventMetadata("VASSOCIATEDRECORDS.DBLCLICK",",oparms:[{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''},{av:'lstavAssociatedrecords'},{av:'AV26AssociatedRecords',fld:'vASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'lstavNotassociatedrecords'},{av:'AV25NotAssociatedRecords',fld:'vNOTASSOCIATEDRECORDS',pic:'ZZZ9'}]}");
      setEventMetadata("VNOTASSOCIATEDRECORDS.DBLCLICK","{handler:'e190W2',iparms:[{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'lstavNotassociatedrecords'},{av:'AV25NotAssociatedRecords',fld:'vNOTASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''}]");
      setEventMetadata("VNOTASSOCIATEDRECORDS.DBLCLICK",",oparms:[{av:'AV9SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV21AddedKeyList',fld:'vADDEDKEYLIST',pic:''},{av:'AV23AddedDscList',fld:'vADDEDDSCLIST',pic:''},{av:'AV22NotAddedKeyList',fld:'vNOTADDEDKEYLIST',pic:''},{av:'AV24NotAddedDscList',fld:'vNOTADDEDDSCLIST',pic:''},{av:'AV17AddedKeyListXml',fld:'vADDEDKEYLISTXML',pic:''},{av:'AV19AddedDscListXml',fld:'vADDEDDSCLISTXML',pic:''},{av:'AV18NotAddedKeyListXml',fld:'vNOTADDEDKEYLISTXML',pic:''},{av:'AV20NotAddedDscListXml',fld:'vNOTADDEDDSCLISTXML',pic:''},{av:'lstavAssociatedrecords'},{av:'AV26AssociatedRecords',fld:'vASSOCIATEDRECORDS',pic:'ZZZ9'},{av:'lstavNotassociatedrecords'},{av:'AV25NotAssociatedRecords',fld:'vNOTASSOCIATEDRECORDS',pic:'ZZZ9'}]}");
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
      AV21AddedKeyList = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV23AddedDscList = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22NotAddedKeyList = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV24NotAddedDscList = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17AddedKeyListXml = "" ;
      AV19AddedDscListXml = "" ;
      AV18NotAddedKeyListXml = "" ;
      AV20NotAddedDscListXml = "" ;
      AV12SecUserRole = new com.projectthani.wwpbaseobjects.SdtSecUserRole(remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblNotassociatedrecordstitle_Jsonclick = "" ;
      TempTags = "" ;
      sImgUrl = "" ;
      imgImageassociateall_Jsonclick = "" ;
      imgImageassociateselected_Jsonclick = "" ;
      imgImagedisassociateselected_Jsonclick = "" ;
      imgImagedisassociateall_Jsonclick = "" ;
      lblAssociatedrecordstitle_Jsonclick = "" ;
      bttBtnconfirm_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV30WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV10HTTPRequest = httpContext.getHttpRequest();
      scmdbuf = "" ;
      H000W2_A6SecUserId = new short[1] ;
      H000W3_A4SecRoleId = new short[1] ;
      H000W3_A13SecRoleName = new String[] {""} ;
      H000W3_A12SecRoleDescription = new String[] {""} ;
      A13SecRoleName = "" ;
      A12SecRoleDescription = "" ;
      H000W4_A4SecRoleId = new short[1] ;
      H000W4_A6SecUserId = new short[1] ;
      AV14Description = "" ;
      H000W5_A6SecUserId = new short[1] ;
      H000W5_A14SecUserName = new String[] {""} ;
      A14SecUserName = "" ;
      H000W6_A4SecRoleId = new short[1] ;
      H000W6_A6SecUserId = new short[1] ;
      H000W7_A4SecRoleId = new short[1] ;
      H000W7_A6SecUserId = new short[1] ;
      AV43GXV5 = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV16Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secusersecuserroleassociation__default(),
         new Object[] {
             new Object[] {
            H000W2_A6SecUserId
            }
            , new Object[] {
            H000W3_A4SecRoleId, H000W3_A13SecRoleName, H000W3_A12SecRoleDescription
            }
            , new Object[] {
            H000W4_A4SecRoleId, H000W4_A6SecUserId
            }
            , new Object[] {
            H000W5_A6SecUserId, H000W5_A14SecUserName
            }
            , new Object[] {
            H000W6_A4SecRoleId, H000W6_A6SecUserId
            }
            , new Object[] {
            H000W7_A4SecRoleId, H000W7_A6SecUserId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV33GXLvl8 ;
   private byte nGXWrapped ;
   private short wcpOAV8SecUserId ;
   private short nRcdExists_8 ;
   private short nIsMod_8 ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV8SecUserId ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short AV9SecRoleId ;
   private short wbEnd ;
   private short wbStart ;
   private short AV25NotAssociatedRecords ;
   private short AV26AssociatedRecords ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int AV27InsertIndex ;
   private int AV15i ;
   private int AV37GXV1 ;
   private int AV39GXV2 ;
   private int AV41GXV3 ;
   private int AV42GXV4 ;
   private int AV44GXV6 ;
   private int AV45GXV7 ;
   private int AV46GXV8 ;
   private int AV47GXV9 ;
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
   private String divTablefullcontent_Internalname ;
   private String divTablenotassociated_Internalname ;
   private String lblNotassociatedrecordstitle_Internalname ;
   private String lblNotassociatedrecordstitle_Jsonclick ;
   private String TempTags ;
   private String divUnnamedtableassociationbuttons_Internalname ;
   private String sImgUrl ;
   private String imgImageassociateall_Internalname ;
   private String imgImageassociateall_Jsonclick ;
   private String imgImageassociateselected_Internalname ;
   private String imgImageassociateselected_Jsonclick ;
   private String imgImagedisassociateselected_Internalname ;
   private String imgImagedisassociateselected_Jsonclick ;
   private String imgImagedisassociateall_Internalname ;
   private String imgImagedisassociateall_Jsonclick ;
   private String divTableassociated_Internalname ;
   private String lblAssociatedrecordstitle_Internalname ;
   private String lblAssociatedrecordstitle_Jsonclick ;
   private String bttBtnconfirm_Internalname ;
   private String bttBtnconfirm_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV11Exist ;
   private boolean AV13Success ;
   private String AV17AddedKeyListXml ;
   private String AV19AddedDscListXml ;
   private String AV18NotAddedKeyListXml ;
   private String AV20NotAddedDscListXml ;
   private String A13SecRoleName ;
   private String A12SecRoleDescription ;
   private String AV14Description ;
   private String A14SecUserName ;
   private GXSimpleCollection<Short> AV21AddedKeyList ;
   private GXSimpleCollection<Short> AV22NotAddedKeyList ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV10HTTPRequest ;
   private HTMLChoice lstavNotassociatedrecords ;
   private HTMLChoice lstavAssociatedrecords ;
   private IDataStoreProvider pr_default ;
   private short[] H000W2_A6SecUserId ;
   private short[] H000W3_A4SecRoleId ;
   private String[] H000W3_A13SecRoleName ;
   private String[] H000W3_A12SecRoleDescription ;
   private short[] H000W4_A4SecRoleId ;
   private short[] H000W4_A6SecUserId ;
   private short[] H000W5_A6SecUserId ;
   private String[] H000W5_A14SecUserName ;
   private short[] H000W6_A4SecRoleId ;
   private short[] H000W6_A6SecUserId ;
   private short[] H000W7_A4SecRoleId ;
   private short[] H000W7_A6SecUserId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV23AddedDscList ;
   private GXSimpleCollection<String> AV24NotAddedDscList ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV43GXV5 ;
   private com.genexus.SdtMessages_Message AV16Message ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV30WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtSecUserRole AV12SecUserRole ;
}

final  class secusersecuserroleassociation__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H000W2", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H000W3", "SELECT [SecRoleId], [SecRoleName], [SecRoleDescription] FROM [SecRole] ORDER BY [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H000W4", "SELECT [SecRoleId], [SecUserId] FROM [SecUserRole] WHERE [SecUserId] = ? and [SecRoleId] = ? ORDER BY [SecUserId], [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H000W5", "SELECT [SecUserId], [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H000W6", "SELECT [SecRoleId], [SecUserId] FROM [SecUserRole] WHERE [SecUserId] = ? and [SecRoleId] = ? ORDER BY [SecUserId], [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H000W7", "SELECT [SecRoleId], [SecUserId] FROM [SecUserRole] WHERE [SecUserId] = ? and [SecRoleId] = ? ORDER BY [SecUserId], [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

