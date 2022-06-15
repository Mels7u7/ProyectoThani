package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class disponibilidadhoraria_impl extends GXDataArea
{
   public disponibilidadhoraria_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public disponibilidadhoraria_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( disponibilidadhoraria_impl.class ));
   }

   public disponibilidadhoraria_impl( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
      dynavProfesionalid = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPROFESIONALID") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvprofesionalid312( ) ;
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
      pa312( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start312( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110334569", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("GXScheduler/dhtmlxscheduler.js", "", false, true);
      httpContext.AddJavascriptSource("GXScheduler/GXSchedulerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.disponibilidadhoraria", new String[] {}, new String[] {}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCURRENTEVENT", AV7currentEvent);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCURRENTEVENT", AV7currentEvent);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINITIALDATE", localUtil.dtoc( AV11initialDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vNROTRASLAPES", GXutil.ltrim( localUtil.ntoc( AV22NroTraslapes, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( A40000DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROFESIONALID", GXutil.ltrim( localUtil.ntoc( A40001ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Width", GXutil.rtrim( Dvpanel_tableheader_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autowidth", GXutil.booltostr( Dvpanel_tableheader_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autoheight", GXutil.booltostr( Dvpanel_tableheader_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Cls", GXutil.rtrim( Dvpanel_tableheader_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Title", GXutil.rtrim( Dvpanel_tableheader_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Collapsible", GXutil.booltostr( Dvpanel_tableheader_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Collapsed", GXutil.booltostr( Dvpanel_tableheader_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Showcollapseicon", GXutil.booltostr( Dvpanel_tableheader_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Iconposition", GXutil.rtrim( Dvpanel_tableheader_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autoscroll", GXutil.booltostr( Dvpanel_tableheader_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Autoload", GXutil.rtrim( Gxscheduler1_Autoload));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Loadeventsobject", GXutil.rtrim( Gxscheduler1_Loadeventsobject));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Loadeventsobjectname", GXutil.rtrim( Gxscheduler1_Loadeventsobjectname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Detailsformobject", GXutil.rtrim( Gxscheduler1_Detailsformobject));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Detailsformobjectname", GXutil.rtrim( Gxscheduler1_Detailsformobjectname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_View", GXutil.rtrim( Gxscheduler1_View));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Defaultsteptime", GXutil.ltrim( localUtil.ntoc( Gxscheduler1_Defaultsteptime, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Hoursize", GXutil.rtrim( Gxscheduler1_Hoursize));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Firsthour", GXutil.rtrim( Gxscheduler1_Firsthour));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Lasthour", GXutil.rtrim( Gxscheduler1_Lasthour));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Theme", GXutil.rtrim( Gxscheduler1_Theme));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Width", GXutil.rtrim( Gxscheduler1_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Autoresize", GXutil.rtrim( Gxscheduler1_Autoresize));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Pasteventscolor", GXutil.ltrim( localUtil.ntoc( Gxscheduler1_Pasteventscolor, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Todayeventscolor", GXutil.ltrim( localUtil.ntoc( Gxscheduler1_Todayeventscolor, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Futureeventscolor", GXutil.ltrim( localUtil.ntoc( Gxscheduler1_Futureeventscolor, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Displaymonthtab", GXutil.rtrim( Gxscheduler1_Displaymonthtab));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Displayweektab", GXutil.rtrim( Gxscheduler1_Displayweektab));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Displaydaytab", GXutil.rtrim( Gxscheduler1_Displaydaytab));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Detailsoncreate", GXutil.rtrim( Gxscheduler1_Detailsoncreate));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Detailsondblclick", GXutil.rtrim( Gxscheduler1_Detailsondblclick));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Openlinknewwindow", GXutil.rtrim( Gxscheduler1_Openlinknewwindow));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXSCHEDULER1_Allowdragndrop", GXutil.rtrim( Gxscheduler1_Allowdragndrop));
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
         we312( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt312( ) ;
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
      return formatLink("com.projectthani.disponibilidadhoraria", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "DisponibilidadHoraria" ;
   }

   public String getPgmdesc( )
   {
      return "Disponibilidad - Thani" ;
   }

   public void wb310( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "TableHeaderDisponibilidad", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tableheader.setProperty("Width", Dvpanel_tableheader_Width);
         ucDvpanel_tableheader.setProperty("AutoWidth", Dvpanel_tableheader_Autowidth);
         ucDvpanel_tableheader.setProperty("AutoHeight", Dvpanel_tableheader_Autoheight);
         ucDvpanel_tableheader.setProperty("Cls", Dvpanel_tableheader_Cls);
         ucDvpanel_tableheader.setProperty("Title", Dvpanel_tableheader_Title);
         ucDvpanel_tableheader.setProperty("Collapsible", Dvpanel_tableheader_Collapsible);
         ucDvpanel_tableheader.setProperty("Collapsed", Dvpanel_tableheader_Collapsed);
         ucDvpanel_tableheader.setProperty("ShowCollapseIcon", Dvpanel_tableheader_Showcollapseicon);
         ucDvpanel_tableheader.setProperty("IconPosition", Dvpanel_tableheader_Iconposition);
         ucDvpanel_tableheader.setProperty("AutoScroll", Dvpanel_tableheader_Autoscroll);
         ucDvpanel_tableheader.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableheader_Internalname, "DVPANEL_TABLEHEADERContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEHEADERContainer"+"DVPanel_TableHeaderTable1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDvpanel_tableheadertable1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "Middle", "", "flex-grow:1;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 15,'',false,'',0)\"" ;
         ClassString = "btn_Master2" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttAgregardisponibilidad_Internalname, "", "Agregar Disponibilidad", bttAgregardisponibilidad_Jsonclick, 5, "Agregar Disponibilidad", "", StyleString, ClassString, bttAgregardisponibilidad_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'AGREGAR DISPONIBILIDAD\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DisponibilidadHoraria.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "Middle", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_17_312( true) ;
      }
      else
      {
         wb_table1_17_312( false) ;
      }
      return  ;
   }

   public void wb_table1_17_312e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
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
         ucGxscheduler1.setProperty("AutoLoad", Gxscheduler1_Autoload);
         ucGxscheduler1.setProperty("LoadEventsObject", Gxscheduler1_Loadeventsobject);
         ucGxscheduler1.setProperty("LoadEventsObjectName", Gxscheduler1_Loadeventsobjectname);
         ucGxscheduler1.setProperty("DetailsFormObject", Gxscheduler1_Detailsformobject);
         ucGxscheduler1.setProperty("DetailsFormObjectName", Gxscheduler1_Detailsformobjectname);
         ucGxscheduler1.setProperty("View", Gxscheduler1_View);
         ucGxscheduler1.setProperty("DefaultStepTime", Gxscheduler1_Defaultsteptime);
         ucGxscheduler1.setProperty("HourSize", Gxscheduler1_Hoursize);
         ucGxscheduler1.setProperty("FirstHour", Gxscheduler1_Firsthour);
         ucGxscheduler1.setProperty("LastHour", Gxscheduler1_Lasthour);
         ucGxscheduler1.setProperty("Theme", Gxscheduler1_Theme);
         ucGxscheduler1.setProperty("Width", Gxscheduler1_Width);
         ucGxscheduler1.setProperty("AutoResize", Gxscheduler1_Autoresize);
         ucGxscheduler1.setProperty("PastEventsColor", Gxscheduler1_Pasteventscolor);
         ucGxscheduler1.setProperty("TodayEventsColor", Gxscheduler1_Todayeventscolor);
         ucGxscheduler1.setProperty("FutureEventsColor", Gxscheduler1_Futureeventscolor);
         ucGxscheduler1.setProperty("DisplayMonthTab", Gxscheduler1_Displaymonthtab);
         ucGxscheduler1.setProperty("DisplayWeekTab", Gxscheduler1_Displayweektab);
         ucGxscheduler1.setProperty("DisplayDayTab", Gxscheduler1_Displaydaytab);
         ucGxscheduler1.setProperty("DetailsOnCreate", Gxscheduler1_Detailsoncreate);
         ucGxscheduler1.setProperty("DetailsOnDblClick", Gxscheduler1_Detailsondblclick);
         ucGxscheduler1.setProperty("OpenLinkNewWindow", Gxscheduler1_Openlinknewwindow);
         ucGxscheduler1.setProperty("AllowDragNDrop", Gxscheduler1_Allowdragndrop);
         ucGxscheduler1.setProperty("CurrentEvent", AV7currentEvent);
         ucGxscheduler1.setProperty("InitialDate", AV11initialDate);
         ucGxscheduler1.render(context, "gxscheduler", Gxscheduler1_Internalname, "GXSCHEDULER1Container");
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

   public void start312( )
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
         Form.getMeta().addItem("description", "Disponibilidad - Thani", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup310( ) ;
   }

   public void ws312( )
   {
      start312( ) ;
      evt312( ) ;
   }

   public void evt312( )
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
                        else if ( GXutil.strcmp(sEvt, "GXSCHEDULER1.EVENTUPDATED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11312 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GXSCHEDULER1.EVENTSELECTED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12312 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'AGREGAR DISPONIBILIDAD'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Agregar Disponibilidad' */
                           e13312 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VPROFESIONALID.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14312 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e15312 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.MOSTRARTRASLAPESDISPONIBILIDAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e16312 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e17312 ();
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

   public void we312( )
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

   public void pa312( )
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
            GX_FocusControl = dynavProfesionalid.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvprofesionalid312( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvprofesionalid_data312( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvprofesionalid_html312( )
   {
      int gxdynajaxvalue;
      gxdlvvprofesionalid_data312( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavProfesionalid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavProfesionalid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 8, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvprofesionalid_data312( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione un profesional");
      /* Using cursor H00312 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00312_A31ProfesionalId[0], (byte)(8), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00312_A175ProfesionalNombreCompleto2[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvvprofesionalid_html312( ) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynavProfesionalid.getItemCount() > 0 )
      {
         AV16ProfesionalId = (int)(GXutil.lval( dynavProfesionalid.getValidValue(GXutil.trim( GXutil.str( AV16ProfesionalId, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16ProfesionalId), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProfesionalid.setValue( GXutil.trim( GXutil.str( AV16ProfesionalId, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProfesionalid.getInternalname(), "Values", dynavProfesionalid.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf312( ) ;
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

   public void rf312( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e17312 ();
         wb310( ) ;
      }
   }

   public void send_integrity_lvl_hashes312( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      gxvvprofesionalid_html312( ) ;
      /* Using cursor H00314 */
      pr_default.execute(1, new Object[] {AV7currentEvent.getgxTv_SdtSchedulerEvents_event_Id()});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40000DisponibilidadId = H00314_A40000DisponibilidadId[0] ;
         n40000DisponibilidadId = H00314_n40000DisponibilidadId[0] ;
      }
      else
      {
         A40000DisponibilidadId = 0 ;
         n40000DisponibilidadId = false ;
      }
      pr_default.close(1);
      /* Using cursor H00316 */
      pr_default.execute(2, new Object[] {AV23SecUserName, AV24SecUserEmail});
      if ( (pr_default.getStatus(2) != 101) )
      {
         A40001ProfesionalId = H00316_A40001ProfesionalId[0] ;
         n40001ProfesionalId = H00316_n40001ProfesionalId[0] ;
      }
      else
      {
         A40001ProfesionalId = 0 ;
         n40001ProfesionalId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40001ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40001ProfesionalId), 8, 0));
      }
      pr_default.close(2);
      fix_multi_value_controls( ) ;
   }

   public void strup310( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15312 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCURRENTEVENT"), AV7currentEvent);
         /* Read saved values. */
         AV11initialDate = localUtil.ctod( httpContext.cgiGet( "vINITIALDATE"), 0) ;
         Ddo_managefilters_Icontype = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( "DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( "DDO_MANAGEFILTERS_Cls") ;
         Dvpanel_tableheader_Width = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Width") ;
         Dvpanel_tableheader_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Autowidth")) ;
         Dvpanel_tableheader_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Autoheight")) ;
         Dvpanel_tableheader_Cls = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Cls") ;
         Dvpanel_tableheader_Title = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Title") ;
         Dvpanel_tableheader_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Collapsible")) ;
         Dvpanel_tableheader_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Collapsed")) ;
         Dvpanel_tableheader_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Showcollapseicon")) ;
         Dvpanel_tableheader_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Iconposition") ;
         Dvpanel_tableheader_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Autoscroll")) ;
         Gxscheduler1_Autoload = httpContext.cgiGet( "GXSCHEDULER1_Autoload") ;
         Gxscheduler1_Loadeventsobject = httpContext.cgiGet( "GXSCHEDULER1_Loadeventsobject") ;
         Gxscheduler1_Loadeventsobjectname = httpContext.cgiGet( "GXSCHEDULER1_Loadeventsobjectname") ;
         Gxscheduler1_Detailsformobject = httpContext.cgiGet( "GXSCHEDULER1_Detailsformobject") ;
         Gxscheduler1_Detailsformobjectname = httpContext.cgiGet( "GXSCHEDULER1_Detailsformobjectname") ;
         Gxscheduler1_View = httpContext.cgiGet( "GXSCHEDULER1_View") ;
         Gxscheduler1_Defaultsteptime = (int)(localUtil.ctol( httpContext.cgiGet( "GXSCHEDULER1_Defaultsteptime"), ",", ".")) ;
         Gxscheduler1_Hoursize = httpContext.cgiGet( "GXSCHEDULER1_Hoursize") ;
         Gxscheduler1_Firsthour = httpContext.cgiGet( "GXSCHEDULER1_Firsthour") ;
         Gxscheduler1_Lasthour = httpContext.cgiGet( "GXSCHEDULER1_Lasthour") ;
         Gxscheduler1_Theme = httpContext.cgiGet( "GXSCHEDULER1_Theme") ;
         Gxscheduler1_Width = httpContext.cgiGet( "GXSCHEDULER1_Width") ;
         Gxscheduler1_Autoresize = httpContext.cgiGet( "GXSCHEDULER1_Autoresize") ;
         Gxscheduler1_Pasteventscolor = (int)(localUtil.ctol( httpContext.cgiGet( "GXSCHEDULER1_Pasteventscolor"), ",", ".")) ;
         Gxscheduler1_Todayeventscolor = (int)(localUtil.ctol( httpContext.cgiGet( "GXSCHEDULER1_Todayeventscolor"), ",", ".")) ;
         Gxscheduler1_Futureeventscolor = (int)(localUtil.ctol( httpContext.cgiGet( "GXSCHEDULER1_Futureeventscolor"), ",", ".")) ;
         Gxscheduler1_Displaymonthtab = httpContext.cgiGet( "GXSCHEDULER1_Displaymonthtab") ;
         Gxscheduler1_Displayweektab = httpContext.cgiGet( "GXSCHEDULER1_Displayweektab") ;
         Gxscheduler1_Displaydaytab = httpContext.cgiGet( "GXSCHEDULER1_Displaydaytab") ;
         Gxscheduler1_Detailsoncreate = httpContext.cgiGet( "GXSCHEDULER1_Detailsoncreate") ;
         Gxscheduler1_Detailsondblclick = httpContext.cgiGet( "GXSCHEDULER1_Detailsondblclick") ;
         Gxscheduler1_Openlinknewwindow = httpContext.cgiGet( "GXSCHEDULER1_Openlinknewwindow") ;
         Gxscheduler1_Allowdragndrop = httpContext.cgiGet( "GXSCHEDULER1_Allowdragndrop") ;
         /* Read variables values. */
         dynavProfesionalid.setValue( httpContext.cgiGet( dynavProfesionalid.getInternalname()) );
         AV16ProfesionalId = (int)(GXutil.lval( httpContext.cgiGet( dynavProfesionalid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16ProfesionalId), 8, 0));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         gxvvprofesionalid_html312( ) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   public void e11312( )
   {
      /* Gxscheduler1_Eventupdated Routine */
      returnInSub = false ;
      /* Using cursor H00318 */
      pr_default.execute(3, new Object[] {AV7currentEvent.getgxTv_SdtSchedulerEvents_event_Id()});
      if ( (pr_default.getStatus(3) != 101) )
      {
         A40000DisponibilidadId = H00318_A40000DisponibilidadId[0] ;
         n40000DisponibilidadId = H00318_n40000DisponibilidadId[0] ;
      }
      else
      {
         A40000DisponibilidadId = 0 ;
         n40000DisponibilidadId = false ;
      }
      pr_default.close(3);
      AV8Disponibilidad.Load(A40000DisponibilidadId);
      AV8Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidaddescription( AV7currentEvent.getgxTv_SdtSchedulerEvents_event_Notes() );
      AV8Disponibilidad.Save();
      if ( AV8Disponibilidad.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "disponibilidadhoraria");
         httpContext.GX_msglist.addItem("Se actualizó la disponibilidad correctamente");
      }
      else
      {
         httpContext.GX_msglist.addItem("Hubo un error al actualizar. Contactar con el administrador");
         Application.rollbackDataStores(context, remoteHandle, pr_default, "disponibilidadhoraria");
      }
      AV20websession.remove("currentevent");
   }

   public void e12312( )
   {
      /* Gxscheduler1_Eventselected Routine */
      returnInSub = false ;
      AV20websession.setValue("currentevent", AV7currentEvent.toxml(false, true, "", ""));
      GXv_int1[0] = AV9DisponibilidadId ;
      GXv_int2[0] = AV6CitaId ;
      GXv_char3[0] = AV5CitaEstadoCita ;
      new com.projectthani.prcgetdisponibilidadbyeventid(remoteHandle, context).execute( GXutil.trim( AV7currentEvent.getgxTv_SdtSchedulerEvents_event_Id()), GXv_int1, GXv_int2, GXv_char3) ;
      disponibilidadhoraria_impl.this.AV9DisponibilidadId = GXv_int1[0] ;
      disponibilidadhoraria_impl.this.AV6CitaId = GXv_int2[0] ;
      disponibilidadhoraria_impl.this.AV5CitaEstadoCita = GXv_char3[0] ;
      if ( AV6CitaId == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.detallecalendario", new String[] {}, new String[] {}) , new Object[] {});
      }
      else
      {
         callWebObject(formatLink("com.projectthani.wpinformecita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV6CitaId,8,0))}, new String[] {"CitaId"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e13312( )
   {
      /* 'Agregar Disponibilidad' Routine */
      returnInSub = false ;
      AV20websession.remove("currentevent");
      httpContext.popup(formatLink("com.projectthani.detallecalendario", new String[] {}, new String[] {}) , new Object[] {});
   }

   public void e14312( )
   {
      /* Profesionalid_Controlvaluechanged Routine */
      returnInSub = false ;
      AV20websession.setValue("FiltroProfesional", GXutil.str( AV16ProfesionalId, 8, 0));
      this.executeUsercontrolMethod("", false, "GXSCHEDULER1Container", "Refresh", "", new Object[] {});
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e15312 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e15312( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.getJscriptsrc().add("./JSUtils.js") ;
      GXv_SdtWWPContext4[0] = AV21WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext4) ;
      AV21WWPContext = GXv_SdtWWPContext4[0] ;
      AV19SecUserId = AV21WWPContext.getgxTv_SdtWWPContext_Userid() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19SecUserId), 4, 0));
      if ( (0==AV19SecUserId) || ( AV19SecUserId == 0 ) )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.seclogin", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Using cursor H00319 */
      pr_default.execute(4, new Object[] {Short.valueOf(AV19SecUserId)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A6SecUserId = H00319_A6SecUserId[0] ;
         A14SecUserName = H00319_A14SecUserName[0] ;
         A122SecUserEmail = H00319_A122SecUserEmail[0] ;
         AV23SecUserName = A14SecUserName ;
         AV24SecUserEmail = A122SecUserEmail ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(4);
      /* Using cursor H003110 */
      pr_default.execute(5, new Object[] {Short.valueOf(AV19SecUserId)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         A6SecUserId = H003110_A6SecUserId[0] ;
         A4SecRoleId = H003110_A4SecRoleId[0] ;
         AV17SecRoleId = A4SecRoleId ;
         pr_default.readNext(5);
      }
      pr_default.close(5);
      /* Using cursor H003112 */
      pr_default.execute(6, new Object[] {AV23SecUserName, AV24SecUserEmail});
      if ( (pr_default.getStatus(6) != 101) )
      {
         A40001ProfesionalId = H003112_A40001ProfesionalId[0] ;
         n40001ProfesionalId = H003112_n40001ProfesionalId[0] ;
      }
      else
      {
         A40001ProfesionalId = 0 ;
         n40001ProfesionalId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40001ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40001ProfesionalId), 8, 0));
      }
      pr_default.close(6);
      AV16ProfesionalId = (int)(GXutil.lval( AV20websession.getValue("FiltroProfesional"))) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16ProfesionalId), 8, 0));
      if ( AV17SecRoleId == 2 )
      {
         bttAgregardisponibilidad_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttAgregardisponibilidad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttAgregardisponibilidad_Visible), 5, 0), true);
         AV16ProfesionalId = A40001ProfesionalId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16ProfesionalId), 8, 0));
         dynavProfesionalid.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynavProfesionalid.getInternalname(), "Enabled", GXutil.ltrimstr( dynavProfesionalid.getEnabled(), 5, 0), true);
         AV20websession.setValue("FiltroProfesional", GXutil.str( AV16ProfesionalId, 8, 0));
      }
      this.executeUsercontrolMethod("", false, "GXSCHEDULER1Container", "Refresh", "", new Object[] {});
   }

   public void e16312( )
   {
      /* GlobalEvents_Mostrartraslapesdisponibilidad Routine */
      returnInSub = false ;
      httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "", "No se registraron "+AV22NroTraslapes+" disponibilidades, porque existe cruce con las que ya existen.", "info", "", "true"));
   }

   protected void nextLoad( )
   {
   }

   protected void e17312( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_17_312( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablerightheader_Internalname, tblTablerightheader_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_22_312( true) ;
      }
      else
      {
         wb_table2_22_312( false) ;
      }
      return  ;
   }

   public void wb_table2_22_312e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_17_312e( true) ;
      }
      else
      {
         wb_table1_17_312e( false) ;
      }
   }

   public void wb_table2_22_312( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Left\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Left;text-align:-moz-Left;text-align:-webkit-Left;vertical-align:Bottom")+"\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavProfesionalid.getInternalname(), "Profesional", "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavProfesionalid, dynavProfesionalid.getInternalname(), GXutil.trim( GXutil.str( AV16ProfesionalId, 8, 0)), 1, dynavProfesionalid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavProfesionalid.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "", true, (byte)(1), "HLP_DisponibilidadHoraria.htm");
         dynavProfesionalid.setValue( GXutil.trim( GXutil.str( AV16ProfesionalId, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProfesionalid.getInternalname(), "Values", dynavProfesionalid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_22_312e( true) ;
      }
      else
      {
         wb_table2_22_312e( false) ;
      }
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
      pa312( ) ;
      ws312( ) ;
      we312( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334672", true, true);
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
      httpContext.AddJavascriptSource("disponibilidadhoraria.js", "?20225110334672", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("GXScheduler/dhtmlxscheduler.js", "", false, true);
      httpContext.AddJavascriptSource("GXScheduler/GXSchedulerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      bttAgregardisponibilidad_Internalname = "AGREGARDISPONIBILIDAD" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      dynavProfesionalid.setInternalname( "vPROFESIONALID" );
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divDvpanel_tableheadertable1_Internalname = "DVPANEL_TABLEHEADERTABLE1" ;
      Dvpanel_tableheader_Internalname = "DVPANEL_TABLEHEADER" ;
      divTable1_Internalname = "TABLE1" ;
      Gxscheduler1_Internalname = "GXSCHEDULER1" ;
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
      dynavProfesionalid.setJsonclick( "" );
      Ddo_managefilters_Caption = "" ;
      dynavProfesionalid.setEnabled( 1 );
      bttAgregardisponibilidad_Visible = 1 ;
      Gxscheduler1_Allowdragndrop = "false" ;
      Gxscheduler1_Openlinknewwindow = "true" ;
      Gxscheduler1_Detailsondblclick = "false" ;
      Gxscheduler1_Detailsoncreate = "true" ;
      Gxscheduler1_Displaydaytab = "true" ;
      Gxscheduler1_Displayweektab = "true" ;
      Gxscheduler1_Displaymonthtab = "true" ;
      Gxscheduler1_Futureeventscolor = (int)(0x32D2D2) ;
      Gxscheduler1_Todayeventscolor = (int)(0x32D2D2) ;
      Gxscheduler1_Pasteventscolor = (int)(0x32D2D2) ;
      Gxscheduler1_Autoresize = GXutil.booltostr( true) ;
      Gxscheduler1_Width = "500" ;
      Gxscheduler1_Theme = "terrace" ;
      Gxscheduler1_Lasthour = "23" ;
      Gxscheduler1_Firsthour = "7" ;
      Gxscheduler1_Hoursize = "4" ;
      Gxscheduler1_Defaultsteptime = 30 ;
      Gxscheduler1_View = "week" ;
      Gxscheduler1_Detailsformobjectname = "DetalleCalendario" ;
      Gxscheduler1_Detailsformobject = "com.projectthani.detallecalendario" ;
      Gxscheduler1_Loadeventsobjectname = "ProcCargarDisponibilidadCalendario" ;
      Gxscheduler1_Loadeventsobject = "proccargardisponibilidadcalendario" ;
      Gxscheduler1_Autoload = "week" ;
      Dvpanel_tableheader_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Iconposition = "Right" ;
      Dvpanel_tableheader_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tableheader_Title = "Opciones" ;
      Dvpanel_tableheader_Cls = "PanelNoHeader" ;
      Dvpanel_tableheader_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableheader_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Width = "100%" ;
      Ddo_managefilters_Cls = "ManageFilters" ;
      Ddo_managefilters_Tooltip = "WWP_ManageFiltersTooltip" ;
      Ddo_managefilters_Icon = "fas fa-filter" ;
      Ddo_managefilters_Icontype = "FontIcon" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Disponibilidad - Thani" );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      dynavProfesionalid.setName( "vPROFESIONALID" );
      dynavProfesionalid.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("GXSCHEDULER1.EVENTUPDATED","{handler:'e11312',iparms:[{av:'AV7currentEvent',fld:'vCURRENTEVENT',pic:''},{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("GXSCHEDULER1.EVENTUPDATED",",oparms:[{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("GXSCHEDULER1.EVENTSELECTED","{handler:'e12312',iparms:[{av:'AV7currentEvent',fld:'vCURRENTEVENT',pic:''},{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("GXSCHEDULER1.EVENTSELECTED",",oparms:[{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("'AGREGAR DISPONIBILIDAD'","{handler:'e13312',iparms:[{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'AGREGAR DISPONIBILIDAD'",",oparms:[{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("VPROFESIONALID.CONTROLVALUECHANGED","{handler:'e14312',iparms:[{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VPROFESIONALID.CONTROLVALUECHANGED",",oparms:[{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("GLOBALEVENTS.MOSTRARTRASLAPESDISPONIBILIDAD","{handler:'e16312',iparms:[{av:'AV22NroTraslapes',fld:'vNROTRASLAPES',pic:'ZZZZZZZ9'},{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("GLOBALEVENTS.MOSTRARTRASLAPESDISPONIBILIDAD",",oparms:[{av:'dynavProfesionalid'},{av:'AV16ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'}]}");
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
      AV7currentEvent = new com.projectthani.SdtSchedulerEvents_event(remoteHandle, context);
      AV11initialDate = GXutil.nullDate() ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucDvpanel_tableheader = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttAgregardisponibilidad_Jsonclick = "" ;
      ucGxscheduler1 = new com.genexus.webpanels.GXUserControl();
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H00312_A31ProfesionalId = new int[1] ;
      H00312_A175ProfesionalNombreCompleto2 = new String[] {""} ;
      H00314_A40000DisponibilidadId = new int[1] ;
      H00314_n40000DisponibilidadId = new boolean[] {false} ;
      AV23SecUserName = "" ;
      AV24SecUserEmail = "" ;
      H00316_A40001ProfesionalId = new int[1] ;
      H00316_n40001ProfesionalId = new boolean[] {false} ;
      H00318_A40000DisponibilidadId = new int[1] ;
      H00318_n40000DisponibilidadId = new boolean[] {false} ;
      AV8Disponibilidad = new com.projectthani.SdtDisponibilidad(remoteHandle);
      AV20websession = httpContext.getWebSession();
      GXv_int1 = new int[1] ;
      GXv_int2 = new int[1] ;
      AV5CitaEstadoCita = "" ;
      GXv_char3 = new String[1] ;
      AV21WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext4 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      H00319_A6SecUserId = new short[1] ;
      H00319_A14SecUserName = new String[] {""} ;
      H00319_A122SecUserEmail = new String[] {""} ;
      A14SecUserName = "" ;
      A122SecUserEmail = "" ;
      H003110_A6SecUserId = new short[1] ;
      H003110_A4SecRoleId = new short[1] ;
      H003112_A40001ProfesionalId = new int[1] ;
      H003112_n40001ProfesionalId = new boolean[] {false} ;
      sStyleString = "" ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidadhoraria__default(),
         new Object[] {
             new Object[] {
            H00312_A31ProfesionalId, H00312_A175ProfesionalNombreCompleto2
            }
            , new Object[] {
            H00314_A40000DisponibilidadId, H00314_n40000DisponibilidadId
            }
            , new Object[] {
            H00316_A40001ProfesionalId, H00316_n40001ProfesionalId
            }
            , new Object[] {
            H00318_A40000DisponibilidadId, H00318_n40000DisponibilidadId
            }
            , new Object[] {
            H00319_A6SecUserId, H00319_A14SecUserName, H00319_A122SecUserEmail
            }
            , new Object[] {
            H003110_A6SecUserId, H003110_A4SecRoleId
            }
            , new Object[] {
            H003112_A40001ProfesionalId, H003112_n40001ProfesionalId
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
   private byte nGXWrapped ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV19SecUserId ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short AV17SecRoleId ;
   private int AV22NroTraslapes ;
   private int A40000DisponibilidadId ;
   private int A40001ProfesionalId ;
   private int Gxscheduler1_Defaultsteptime ;
   private int Gxscheduler1_Pasteventscolor ;
   private int Gxscheduler1_Todayeventscolor ;
   private int Gxscheduler1_Futureeventscolor ;
   private int bttAgregardisponibilidad_Visible ;
   private int gxdynajaxindex ;
   private int AV16ProfesionalId ;
   private int AV9DisponibilidadId ;
   private int GXv_int1[] ;
   private int AV6CitaId ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Ddo_managefilters_Icontype ;
   private String Ddo_managefilters_Icon ;
   private String Ddo_managefilters_Tooltip ;
   private String Ddo_managefilters_Cls ;
   private String Dvpanel_tableheader_Width ;
   private String Dvpanel_tableheader_Cls ;
   private String Dvpanel_tableheader_Title ;
   private String Dvpanel_tableheader_Iconposition ;
   private String Gxscheduler1_Autoload ;
   private String Gxscheduler1_Loadeventsobject ;
   private String Gxscheduler1_Loadeventsobjectname ;
   private String Gxscheduler1_Detailsformobject ;
   private String Gxscheduler1_Detailsformobjectname ;
   private String Gxscheduler1_View ;
   private String Gxscheduler1_Hoursize ;
   private String Gxscheduler1_Firsthour ;
   private String Gxscheduler1_Lasthour ;
   private String Gxscheduler1_Theme ;
   private String Gxscheduler1_Width ;
   private String Gxscheduler1_Autoresize ;
   private String Gxscheduler1_Displaymonthtab ;
   private String Gxscheduler1_Displayweektab ;
   private String Gxscheduler1_Displaydaytab ;
   private String Gxscheduler1_Detailsoncreate ;
   private String Gxscheduler1_Detailsondblclick ;
   private String Gxscheduler1_Openlinknewwindow ;
   private String Gxscheduler1_Allowdragndrop ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable1_Internalname ;
   private String Dvpanel_tableheader_Internalname ;
   private String divDvpanel_tableheadertable1_Internalname ;
   private String divTableactions_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttAgregardisponibilidad_Internalname ;
   private String bttAgregardisponibilidad_Jsonclick ;
   private String Gxscheduler1_Internalname ;
   private String Dvmessage1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV5CitaEstadoCita ;
   private String GXv_char3[] ;
   private String sStyleString ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private java.util.Date AV11initialDate ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_tableheader_Autowidth ;
   private boolean Dvpanel_tableheader_Autoheight ;
   private boolean Dvpanel_tableheader_Collapsible ;
   private boolean Dvpanel_tableheader_Collapsed ;
   private boolean Dvpanel_tableheader_Showcollapseicon ;
   private boolean Dvpanel_tableheader_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000DisponibilidadId ;
   private boolean n40001ProfesionalId ;
   private boolean returnInSub ;
   private String AV23SecUserName ;
   private String AV24SecUserEmail ;
   private String A14SecUserName ;
   private String A122SecUserEmail ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableheader ;
   private com.genexus.webpanels.GXUserControl ucGxscheduler1 ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private HTMLChoice dynavProfesionalid ;
   private IDataStoreProvider pr_default ;
   private int[] H00312_A31ProfesionalId ;
   private String[] H00312_A175ProfesionalNombreCompleto2 ;
   private int[] H00314_A40000DisponibilidadId ;
   private boolean[] H00314_n40000DisponibilidadId ;
   private int[] H00316_A40001ProfesionalId ;
   private boolean[] H00316_n40001ProfesionalId ;
   private int[] H00318_A40000DisponibilidadId ;
   private boolean[] H00318_n40000DisponibilidadId ;
   private short[] H00319_A6SecUserId ;
   private String[] H00319_A14SecUserName ;
   private String[] H00319_A122SecUserEmail ;
   private short[] H003110_A6SecUserId ;
   private short[] H003110_A4SecRoleId ;
   private int[] H003112_A40001ProfesionalId ;
   private boolean[] H003112_n40001ProfesionalId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV20websession ;
   private com.projectthani.SdtSchedulerEvents_event AV7currentEvent ;
   private com.projectthani.SdtDisponibilidad AV8Disponibilidad ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV21WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext4[] ;
}

final  class disponibilidadhoraria__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00312", "SELECT [ProfesionalId], [ProfesionalApellidoPaterno] + ' ' + [ProfesionalApellidoMaterno] + ', ' + [ProfesionalNombres] AS ProfesionalNombreCompleto2 FROM [Profesional] ORDER BY [ProfesionalNombreCompleto2] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00314", "SELECT COALESCE( T1.[DisponibilidadId], 0) AS DisponibilidadId FROM (SELECT MIN([DisponibilidadId]) AS DisponibilidadId FROM [Disponibilidad] WHERE [EventId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00316", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT MIN([ProfesionalId]) AS ProfesionalId FROM [Profesional] WHERE [ProfesionalNroDocumento] = ? or [ProfesionalCorreo] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00318", "SELECT COALESCE( T1.[DisponibilidadId], 0) AS DisponibilidadId FROM (SELECT MIN([DisponibilidadId]) AS DisponibilidadId FROM [Disponibilidad] WHERE [EventId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00319", "SELECT [SecUserId], [SecUserName], [SecUserEmail] FROM [SecUser] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H003110", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H003112", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT MIN([ProfesionalId]) AS ProfesionalId FROM [Profesional] WHERE [ProfesionalNroDocumento] = ? or [ProfesionalCorreo] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 100);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 100);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
      }
   }

}

