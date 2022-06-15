package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wphomepage_impl extends GXDataArea
{
   public wphomepage_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wphomepage_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wphomepage_impl.class ));
   }

   public wphomepage_impl( int remoteHandle ,
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridespecialidades") == 0 )
         {
            nRC_GXsfl_23 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_23"))) ;
            nGXsfl_23_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_23_idx"))) ;
            sGXsfl_23_idx = httpContext.GetPar( "sGXsfl_23_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridespecialidades_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridespecialidades") == 0 )
         {
            AV14especialidadId = (short)(GXutil.lval( httpContext.GetPar( "especialidadId"))) ;
            AV20TipoCita = httpContext.GetPar( "TipoCita") ;
            AV16Fecha = localUtil.parseDateParm( httpContext.GetPar( "Fecha")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridespecialidades_refresh( AV14especialidadId, AV20TipoCita, AV16Fecha) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDESPECIALIDADES_Class", GXutil.rtrim( subGridespecialidades_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDESPECIALIDADES_Showarrows", GXutil.rtrim( subGridespecialidades_Showarrows));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDESPECIALIDADES_Infinite", GXutil.rtrim( subGridespecialidades_Infinite));
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
      pa2T2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2T2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110334230", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESPECIALIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14especialidadId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPOCITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20TipoCita, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFECHA", getSecureSignedToken( "", AV16Fecha));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_23", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_23, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vESPECIALIDADID", GXutil.ltrim( localUtil.ntoc( AV14especialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESPECIALIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14especialidadId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTIPOCITA", GXutil.rtrim( AV20TipoCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPOCITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20TipoCita, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vFECHA", localUtil.dtoc( AV16Fecha, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFECHA", getSecureSignedToken( "", AV16Fecha));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDESPECIALIDADES_Class", GXutil.rtrim( subGridespecialidades_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDESPECIALIDADES_Showarrows", GXutil.rtrim( subGridespecialidades_Showarrows));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDESPECIALIDADES_Infinite", GXutil.rtrim( subGridespecialidades_Infinite));
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
      if ( ! ( WebComp_Component1 == null ) )
      {
         WebComp_Component1.componentjscripts();
      }
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we2T2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2T2( ) ;
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
      return formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WPHomePage" ;
   }

   public String getPgmdesc( )
   {
      return "Inicio" ;
   }

   public void wb2T0( )
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
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0006"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.ajax_rspStartCmp("gxHTMLWrpW0006"+"");
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable4_Internalname, 1, 0, "px", 0, "px", "TableEspecialidad", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable9_Internalname, 1, 0, "px", 0, "px", "TableEspecialidad2", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock4_Internalname, "Especialidades", "", "", lblTextblock4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBannerEspecialidad", 0, "", 1, 1, 0, (short)(0), "HLP_WPHomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock5_Internalname, "Contamos con las mejores especialidades.", "", "", lblTextblock5_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBanner2", 0, "", 1, 1, 0, (short)(0), "HLP_WPHomePage.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 col-lg-2", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSection7_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 col-lg-8", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridespecialidadesContainer.SetIsFreestyle(true);
         GridespecialidadesContainer.SetWrapped(nGXWrapped);
         if ( GridespecialidadesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridespecialidadesContainer"+"DivS\" data-gxgridid=\"23\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridespecialidades_Internalname, subGridespecialidades_Internalname, " "+"sdsmartgrid_multipleitems=\"multiple_quantity\""+" "+"sdsmartgrid_itemspercolumn=\"3\""+" "+"sdsmartgrid_scrolldirection=\"horizontal\""+" ", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridespecialidadesContainer.AddObjectProperty("GridName", "Gridespecialidades");
         }
         else
         {
            if ( isAjaxCallMode( ) )
            {
               GridespecialidadesContainer = new com.genexus.webpanels.GXWebGrid(context);
            }
            else
            {
               GridespecialidadesContainer.Clear();
            }
            GridespecialidadesContainer.SetIsFreestyle(true);
            GridespecialidadesContainer.SetWrapped(nGXWrapped);
            GridespecialidadesContainer.AddObjectProperty("GridName", "Gridespecialidades");
            GridespecialidadesContainer.AddObjectProperty("Header", subGridespecialidades_Header);
            GridespecialidadesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridespecialidadesContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridespecialidadesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridespecialidadesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridespecialidadesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridespecialidades_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridespecialidadesContainer.AddObjectProperty("CmpContext", "");
            GridespecialidadesContainer.AddObjectProperty("InMasterPage", "false");
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ".", "")));
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesColumn.AddObjectProperty("Value", httpContext.convertURL( A155EspecialidadFoto));
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadesColumn.AddObjectProperty("Value", A71EspecialidadNombre);
            GridespecialidadesContainer.AddColumnProperties(GridespecialidadesColumn);
            GridespecialidadesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridespecialidades_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridespecialidadesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridespecialidades_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridespecialidadesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridespecialidades_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridespecialidadesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridespecialidades_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridespecialidadesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridespecialidades_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridespecialidadesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridespecialidades_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridespecialidadesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridespecialidades_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 23 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_23 = (int)(nGXsfl_23_idx-1) ;
         if ( GridespecialidadesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridespecialidadesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridespecialidades", GridespecialidadesContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridespecialidadesContainerData", GridespecialidadesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridespecialidadesContainerData"+"V", GridespecialidadesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridespecialidadesContainerData"+"V"+"\" value='"+GridespecialidadesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 col-lg-2", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSection8_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      if ( wbEnd == 23 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridespecialidadesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridespecialidadesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridespecialidades", GridespecialidadesContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridespecialidadesContainerData", GridespecialidadesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridespecialidadesContainerData"+"V", GridespecialidadesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridespecialidadesContainerData"+"V"+"\" value='"+GridespecialidadesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start2T2( )
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
         Form.getMeta().addItem("description", "Inicio", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2T0( ) ;
   }

   public void ws2T2( )
   {
      start2T2( ) ;
      evt2T2( ) ;
   }

   public void evt2T2( )
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
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 4), "LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_23_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_232( ) ;
                           A32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".")) ;
                           A155EspecialidadFoto = httpContext.cgiGet( edtEspecialidadFoto_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A155EspecialidadFoto))), !bGXsfl_23_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A155EspecialidadFoto), true);
                           A71EspecialidadNombre = httpContext.cgiGet( edtEspecialidadNombre_Internalname) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e112T2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e122T2 ();
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
                     if ( nCmpId == 6 )
                     {
                        WebComp_Component1 = WebUtils.getWebComponent(getClass(), "com.projectthani.wcreservarcita_impl", remoteHandle, context);
                        WebComp_Component1_Component = "WCReservarCita" ;
                        WebComp_Component1.componentprocess("W0006", "", sEvt);
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we2T2( )
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

   public void pa2T2( )
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

   public void gxnrgridespecialidades_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_232( ) ;
      while ( nGXsfl_23_idx <= nRC_GXsfl_23 )
      {
         sendrow_232( ) ;
         nGXsfl_23_idx = ((subGridespecialidades_Islastpage==1)&&(nGXsfl_23_idx+1>subgridespecialidades_fnc_recordsperpage( )) ? 1 : nGXsfl_23_idx+1) ;
         sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_232( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridespecialidadesContainer)) ;
      /* End function gxnrGridespecialidades_newrow */
   }

   public void gxgrgridespecialidades_refresh( short AV14especialidadId ,
                                               String AV20TipoCita ,
                                               java.util.Date AV16Fecha )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDESPECIALIDADES_nCurrentRecord = 0 ;
      rf2T2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridespecialidades_refresh */
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
      rf2T2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   public void rf2T2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridespecialidadesContainer.ClearRows();
      }
      wbStart = (short)(23) ;
      nGXsfl_23_idx = 1 ;
      sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_232( ) ;
      bGXsfl_23_Refreshing = true ;
      GridespecialidadesContainer.AddObjectProperty("GridName", "Gridespecialidades");
      GridespecialidadesContainer.AddObjectProperty("CmpContext", "");
      GridespecialidadesContainer.AddObjectProperty("InMasterPage", "false");
      GridespecialidadesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridespecialidadesContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridespecialidadesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridespecialidadesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridespecialidadesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridespecialidades_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridespecialidadesContainer.setPageSize( subgridespecialidades_fnc_recordsperpage( ) );
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( GXutil.strcmp(WebComp_Component1_Component, "") == 0 )
         {
            WebComp_Component1 = WebUtils.getWebComponent(getClass(), "com.projectthani.wcreservarcita_impl", remoteHandle, context);
            WebComp_Component1_Component = "WCReservarCita" ;
         }
         WebComp_Component1.setjustcreated();
         WebComp_Component1.componentprepare(new Object[] {"W0006",""});
         WebComp_Component1.componentbind(new Object[] {});
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Component1 )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0006"+"");
            WebComp_Component1.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
         if ( 1 != 0 )
         {
            WebComp_Component1.componentstart();
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_232( ) ;
         /* Using cursor H002T2 */
         pr_default.execute(0);
         while ( (pr_default.getStatus(0) != 101) )
         {
            A71EspecialidadNombre = H002T2_A71EspecialidadNombre[0] ;
            A155EspecialidadFoto = H002T2_A155EspecialidadFoto[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A155EspecialidadFoto))), !bGXsfl_23_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A155EspecialidadFoto), true);
            A40000EspecialidadFoto_GXI = H002T2_A40000EspecialidadFoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A155EspecialidadFoto))), !bGXsfl_23_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A155EspecialidadFoto), true);
            A32EspecialidadId = H002T2_A32EspecialidadId[0] ;
            /* Execute user event: Load */
            e122T2 ();
            pr_default.readNext(0);
         }
         pr_default.close(0);
         wbEnd = (short)(23) ;
         wb2T0( ) ;
      }
      bGXsfl_23_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2T2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vESPECIALIDADID", GXutil.ltrim( localUtil.ntoc( AV14especialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESPECIALIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14especialidadId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTIPOCITA", GXutil.rtrim( AV20TipoCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTIPOCITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV20TipoCita, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vFECHA", localUtil.dtoc( AV16Fecha, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFECHA", getSecureSignedToken( "", AV16Fecha));
   }

   public int subgridespecialidades_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridespecialidades_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridespecialidades_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridespecialidades_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2T0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e112T2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_23 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_23"), ",", ".")) ;
         AV16Fecha = localUtil.ctod( httpContext.cgiGet( "vFECHA"), 0) ;
         AV20TipoCita = httpContext.cgiGet( "vTIPOCITA") ;
         AV14especialidadId = (short)(localUtil.ctol( httpContext.cgiGet( "vESPECIALIDADID"), ",", ".")) ;
         subGridespecialidades_Class = httpContext.cgiGet( "GRIDESPECIALIDADES_Class") ;
         subGridespecialidades_Showarrows = httpContext.cgiGet( "GRIDESPECIALIDADES_Showarrows") ;
         subGridespecialidades_Infinite = httpContext.cgiGet( "GRIDESPECIALIDADES_Infinite") ;
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
      e112T2 ();
      if (returnInSub) return;
   }

   public void e112T2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV16Fecha = Gx_date ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Fecha", localUtil.format(AV16Fecha, "99/99/99"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFECHA", getSecureSignedToken( "", AV16Fecha));
      this.executeExternalObjectMethod("", false, "AV22ActualizarPagina", "ActualizarPagina", new Object[] {Integer.valueOf(2)}, false);
   }

   private void e122T2( )
   {
      /* Load Routine */
      returnInSub = false ;
      sendrow_232( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_23_Refreshing )
      {
         httpContext.doAjaxLoad(23, GridespecialidadesRow);
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
      pa2T2( ) ;
      ws2T2( ) ;
      we2T2( ) ;
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
      httpContext.AddStyleSheetFile("HorizontalGrid/horizontalgrid.min.css", "");
      httpContext.AddStyleSheetFile("HorizontalGrid/horizontalgrid.min.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( GXutil.strcmp(WebComp_Component1_Component, "") == 0 )
      {
         WebComp_Component1 = WebUtils.getWebComponent(getClass(), "com.projectthani.wcreservarcita_impl", remoteHandle, context);
         WebComp_Component1_Component = "WCReservarCita" ;
      }
      if ( ! ( WebComp_Component1 == null ) )
      {
         WebComp_Component1.componentthemes();
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334253", true, true);
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
      httpContext.AddJavascriptSource("wphomepage.js", "?20225110334254", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      httpContext.AddJavascriptSource("HorizontalGrid/horizontalgrid.min.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_232( )
   {
      edtEspecialidadId_Internalname = "ESPECIALIDADID_"+sGXsfl_23_idx ;
      edtEspecialidadFoto_Internalname = "ESPECIALIDADFOTO_"+sGXsfl_23_idx ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE_"+sGXsfl_23_idx ;
   }

   public void subsflControlProps_fel_232( )
   {
      edtEspecialidadId_Internalname = "ESPECIALIDADID_"+sGXsfl_23_fel_idx ;
      edtEspecialidadFoto_Internalname = "ESPECIALIDADFOTO_"+sGXsfl_23_fel_idx ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE_"+sGXsfl_23_fel_idx ;
   }

   public void sendrow_232( )
   {
      subsflControlProps_232( ) ;
      wb2T0( ) ;
      GridespecialidadesRow = GXWebRow.GetNew(context,GridespecialidadesContainer) ;
      if ( subGridespecialidades_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridespecialidades_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridespecialidades_Class, "") != 0 )
         {
            subGridespecialidades_Linesclass = subGridespecialidades_Class+"Odd" ;
         }
      }
      else if ( subGridespecialidades_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridespecialidades_Backstyle = (byte)(0) ;
         subGridespecialidades_Backcolor = subGridespecialidades_Allbackcolor ;
         if ( GXutil.strcmp(subGridespecialidades_Class, "") != 0 )
         {
            subGridespecialidades_Linesclass = subGridespecialidades_Class+"Uniform" ;
         }
      }
      else if ( subGridespecialidades_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridespecialidades_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridespecialidades_Class, "") != 0 )
         {
            subGridespecialidades_Linesclass = subGridespecialidades_Class+"Odd" ;
         }
         subGridespecialidades_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridespecialidades_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridespecialidades_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_23_idx) % (2))) == 0 )
         {
            subGridespecialidades_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridespecialidades_Class, "") != 0 )
            {
               subGridespecialidades_Linesclass = subGridespecialidades_Class+"Even" ;
            }
         }
         else
         {
            subGridespecialidades_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridespecialidades_Class, "") != 0 )
            {
               subGridespecialidades_Linesclass = subGridespecialidades_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridespecialidadesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridespecialidades_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_23_idx+"\">") ;
      }
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGridespecialidadestable1_Internalname+"_"+sGXsfl_23_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtEspecialidadId_Internalname+"\"","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Attribute/Variable Label */
      GridespecialidadesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtEspecialidadId_Internalname,"Especialidad Id","col-sm-3 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridespecialidadesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEspecialidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTable8_Internalname+"_"+sGXsfl_23_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableImagenEspecialiades","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","Center","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Attribute/Variable Label */
      GridespecialidadesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"","Especialidad Foto","col-sm-3 ImageAttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Static Bitmap Variable */
      ClassString = "ImageAttribute" ;
      StyleString = "" ;
      A155EspecialidadFoto_IsBlob = (boolean)(((GXutil.strcmp("", A155EspecialidadFoto)==0)&&(GXutil.strcmp("", A40000EspecialidadFoto_GXI)==0))||!(GXutil.strcmp("", A155EspecialidadFoto)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.getResourceRelative(A155EspecialidadFoto)) ;
      GridespecialidadesRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadFoto_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(A155EspecialidadFoto_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","Center","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Div Control */
      GridespecialidadesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Attribute/Variable Label */
      GridespecialidadesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtEspecialidadNombre_Internalname,"Especialidad Nombre","col-sm-3 AttEspecialidadNombreLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      /* Single line edit */
      ROClassString = "AttEspecialidadNombre" ;
      GridespecialidadesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadNombre_Internalname,A71EspecialidadNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEspecialidadNombre_Jsonclick,Integer.valueOf(0),"AttEspecialidadNombre","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      GridespecialidadesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      GridespecialidadesRow.AddRenderProperties(GridespecialidadesColumn);
      send_integrity_lvl_hashes2T2( ) ;
      /* End of Columns property logic. */
      GridespecialidadesContainer.AddRow(GridespecialidadesRow);
      nGXsfl_23_idx = ((subGridespecialidades_Islastpage==1)&&(nGXsfl_23_idx+1>subgridespecialidades_fnc_recordsperpage( )) ? 1 : nGXsfl_23_idx+1) ;
      sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_232( ) ;
      /* End function sendrow_232 */
   }

   public void init_default_properties( )
   {
      lblTextblock4_Internalname = "TEXTBLOCK4" ;
      lblTextblock5_Internalname = "TEXTBLOCK5" ;
      divSection7_Internalname = "SECTION7" ;
      edtEspecialidadId_Internalname = "ESPECIALIDADID" ;
      edtEspecialidadFoto_Internalname = "ESPECIALIDADFOTO" ;
      divTable8_Internalname = "TABLE8" ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE" ;
      divGridespecialidadestable1_Internalname = "GRIDESPECIALIDADESTABLE1" ;
      divSection8_Internalname = "SECTION8" ;
      divTable9_Internalname = "TABLE9" ;
      divTable4_Internalname = "TABLE4" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridespecialidades_Internalname = "GRIDESPECIALIDADES" ;
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
      edtEspecialidadNombre_Jsonclick = "" ;
      edtEspecialidadId_Jsonclick = "" ;
      subGridespecialidades_Allowcollapsing = (byte)(0) ;
      subGridespecialidades_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Inicio" );
      subGridespecialidades_Infinite = GXutil.ltrimstr( DecimalUtil.doubleToDec(-1), 9, 0) ;
      subGridespecialidades_Showarrows = GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0) ;
      subGridespecialidades_Class = "FreeStyleGrid" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDESPECIALIDADES_nFirstRecordOnPage'},{av:'GRIDESPECIALIDADES_nEOF'},{av:'AV14especialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9',hsh:true},{av:'AV20TipoCita',fld:'vTIPOCITA',pic:'',hsh:true},{av:'AV16Fecha',fld:'vFECHA',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Especialidadnombre',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      AV20TipoCita = "" ;
      AV16Fecha = GXutil.nullDate() ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblock4_Jsonclick = "" ;
      lblTextblock5_Jsonclick = "" ;
      GridespecialidadesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGridespecialidades_Header = "" ;
      GridespecialidadesColumn = new com.genexus.webpanels.GXWebColumn();
      A155EspecialidadFoto = "" ;
      A71EspecialidadNombre = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A40000EspecialidadFoto_GXI = "" ;
      WebComp_Component1_Component = "" ;
      Gx_date = GXutil.nullDate() ;
      scmdbuf = "" ;
      H002T2_A71EspecialidadNombre = new String[] {""} ;
      H002T2_A155EspecialidadFoto = new String[] {""} ;
      H002T2_A40000EspecialidadFoto_GXI = new String[] {""} ;
      H002T2_A32EspecialidadId = new short[1] ;
      GridespecialidadesRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridespecialidades_Linesclass = "" ;
      ROClassString = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wphomepage__default(),
         new Object[] {
             new Object[] {
            H002T2_A71EspecialidadNombre, H002T2_A155EspecialidadFoto, H002T2_A40000EspecialidadFoto_GXI, H002T2_A32EspecialidadId
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      WebComp_Component1 = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subGridespecialidades_Backcolorstyle ;
   private byte subGridespecialidades_Allowselection ;
   private byte subGridespecialidades_Allowhovering ;
   private byte subGridespecialidades_Allowcollapsing ;
   private byte subGridespecialidades_Collapsed ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGridespecialidades_Backstyle ;
   private byte GRIDESPECIALIDADES_nEOF ;
   private short AV14especialidadId ;
   private short wbEnd ;
   private short wbStart ;
   private short A32EspecialidadId ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_23 ;
   private int nGXsfl_23_idx=1 ;
   private int subGridespecialidades_Selectedindex ;
   private int subGridespecialidades_Selectioncolor ;
   private int subGridespecialidades_Hoveringcolor ;
   private int subGridespecialidades_Islastpage ;
   private int idxLst ;
   private int subGridespecialidades_Backcolor ;
   private int subGridespecialidades_Allbackcolor ;
   private long GRIDESPECIALIDADES_nCurrentRecord ;
   private long GRIDESPECIALIDADES_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_23_idx="0001" ;
   private String AV20TipoCita ;
   private String subGridespecialidades_Class ;
   private String subGridespecialidades_Showarrows ;
   private String subGridespecialidades_Infinite ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable4_Internalname ;
   private String divTable9_Internalname ;
   private String lblTextblock4_Internalname ;
   private String lblTextblock4_Jsonclick ;
   private String lblTextblock5_Internalname ;
   private String lblTextblock5_Jsonclick ;
   private String divSection7_Internalname ;
   private String sStyleString ;
   private String subGridespecialidades_Internalname ;
   private String subGridespecialidades_Header ;
   private String divSection8_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtEspecialidadId_Internalname ;
   private String edtEspecialidadFoto_Internalname ;
   private String edtEspecialidadNombre_Internalname ;
   private String WebComp_Component1_Component ;
   private String scmdbuf ;
   private String sGXsfl_23_fel_idx="0001" ;
   private String subGridespecialidades_Linesclass ;
   private String divGridespecialidadestable1_Internalname ;
   private String ROClassString ;
   private String edtEspecialidadId_Jsonclick ;
   private String divTable8_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String edtEspecialidadNombre_Jsonclick ;
   private java.util.Date AV16Fecha ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_23_Refreshing=false ;
   private boolean bDynCreated_Component1 ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean A155EspecialidadFoto_IsBlob ;
   private String A71EspecialidadNombre ;
   private String A40000EspecialidadFoto_GXI ;
   private String A155EspecialidadFoto ;
   private com.genexus.webpanels.GXWebGrid GridespecialidadesContainer ;
   private com.genexus.webpanels.GXWebRow GridespecialidadesRow ;
   private com.genexus.webpanels.GXWebColumn GridespecialidadesColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Component1 ;
   private IDataStoreProvider pr_default ;
   private String[] H002T2_A71EspecialidadNombre ;
   private String[] H002T2_A155EspecialidadFoto ;
   private String[] H002T2_A40000EspecialidadFoto_GXI ;
   private short[] H002T2_A32EspecialidadId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class wphomepage__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002T2", "SELECT [EspecialidadNombre], [EspecialidadFoto], [EspecialidadFoto_GXI], [EspecialidadId] FROM [Especialidad] ORDER BY [EspecialidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

