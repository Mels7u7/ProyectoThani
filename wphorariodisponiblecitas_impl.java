package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wphorariodisponiblecitas_impl extends GXDataArea
{
   public wphorariodisponiblecitas_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wphorariodisponiblecitas_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wphorariodisponiblecitas_impl.class ));
   }

   public wphorariodisponiblecitas_impl( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavCitapresencial = UIFactory.getCheckbox(this);
      chkavCitadomicilio = UIFactory.getCheckbox(this);
      chkavCitavirtual = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "ProfesionalId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "ProfesionalId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "ProfesionalId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridreservacita") == 0 )
         {
            nRC_GXsfl_12 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_12"))) ;
            nGXsfl_12_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_12_idx"))) ;
            sGXsfl_12_idx = httpContext.GetPar( "sGXsfl_12_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridreservacita_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridreservacita") == 0 )
         {
            AV6CitaPresencial = httpContext.GetPar( "CitaPresencial") ;
            AV5CitaDomicilio = httpContext.GetPar( "CitaDomicilio") ;
            AV7CitaVirtual = httpContext.GetPar( "CitaVirtual") ;
            AV21ProfesionalId = (short)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridreservacita_refresh( AV6CitaPresencial, AV5CitaDomicilio, AV7CitaVirtual, AV21ProfesionalId) ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV21ProfesionalId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ProfesionalId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21ProfesionalId), "ZZZ9")));
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
      pa6A2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start6A2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034325", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("UserControls/UCListadoHorasCitasDisponiblesRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormFondoGeneral\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoGeneral\" data-gx-class=\"form-horizontal FormFondoGeneral\" novalidate action=\""+formatLink("com.projectthani.wphorariodisponiblecitas", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV21ProfesionalId,4,0))}, new String[] {"ProfesionalId"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormFondoGeneral", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21ProfesionalId), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Doctorreservarcita", AV11DoctorReservarCita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Doctorreservarcita", AV11DoctorReservarCita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_12", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_12, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vHORARIOSDOCTOR", AV13HorariosDoctor);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vHORARIOSDOCTOR", AV13HorariosDoctor);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV21ProfesionalId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21ProfesionalId), "ZZZ9")));
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormFondoGeneral" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we6A2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt6A2( ) ;
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
      return formatLink("com.projectthani.wphorariodisponiblecitas", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV21ProfesionalId,4,0))}, new String[] {"ProfesionalId"})  ;
   }

   public String getPgmname( )
   {
      return "WPHorarioDisponibleCitas" ;
   }

   public String getPgmdesc( )
   {
      return "Listado de horaios disponibles para la cita" ;
   }

   public void wb6A0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "TableMainTableCitas", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 tbReservaDetalleDoctorCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabledetalledoctorreserva_Internalname, 1, 0, "px", 0, "px", "tbReservaDetalleDoctor", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "tbReservaDoctorDetalle", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridreservacitaContainer.SetIsFreestyle(true);
         GridreservacitaContainer.SetWrapped(nGXWrapped);
         if ( GridreservacitaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridreservacitaContainer"+"DivS\" data-gxgridid=\"12\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridreservacita_Internalname, subGridreservacita_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridreservacitaContainer.AddObjectProperty("GridName", "Gridreservacita");
         }
         else
         {
            GridreservacitaContainer.AddObjectProperty("GridName", "Gridreservacita");
            GridreservacitaContainer.AddObjectProperty("Header", subGridreservacita_Header);
            GridreservacitaContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridreservacitaContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridreservacitaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridreservacitaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridreservacitaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridreservacita_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridreservacitaContainer.AddObjectProperty("CmpContext", "");
            GridreservacitaContainer.AddObjectProperty("InMasterPage", "false");
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlprofesionalid_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlprofesionalnombrecompleto_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlespecialidadnombre_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtldireccion_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridreservacitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlcalificacion_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridreservacitaContainer.AddColumnProperties(GridreservacitaColumn);
            GridreservacitaContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridreservacita_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridreservacitaContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridreservacita_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridreservacitaContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridreservacita_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridreservacitaContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridreservacita_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridreservacitaContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridreservacita_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridreservacitaContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridreservacita_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridreservacitaContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridreservacita_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 12 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_12 = (int)(nGXsfl_12_idx-1) ;
         if ( GridreservacitaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV28GXV1 = nGXsfl_12_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridreservacitaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridreservacita", GridreservacitaContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridreservacitaContainerData", GridreservacitaContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridreservacitaContainerData"+"V", GridreservacitaContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridreservacitaContainerData"+"V"+"\" value='"+GridreservacitaContainer.GridValuesHidden()+"'/>") ;
            }
         }
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableleyenda_Internalname, 1, 0, "px", 0, "px", "tbLeyenda", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 tbLeyendaCell", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock5_Internalname, "Leyenda", "", "", lblTextblock5_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "txbLeyenda", 0, "", 1, 1, 0, (short)(0), "HLP_WPHorarioDisponibleCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 tbSeparadorLeyenda", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTxbocupado_Internalname, lblTxbocupado_Caption, "", "", lblTxbocupado_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPHorarioDisponibleCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTxblibre_Internalname, lblTxblibre_Caption, "", "", lblTxblibre_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPHorarioDisponibleCitas.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable4_Internalname, 1, 0, "px", 0, "px", "tbReservaDoctorFiltro", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock4_Internalname, "Filtro de búsqueda", "", "", lblTextblock4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "txbCabeceraTitulo", 0, "", 1, 1, 0, (short)(0), "HLP_WPHorarioDisponibleCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock2_Internalname, "Tipo de cita:", "", "", lblTextblock2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "txbSubTituloHoras", 0, "", 1, 1, 0, (short)(0), "HLP_WPHorarioDisponibleCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCitapresencial.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'" + sGXsfl_12_idx + "',0)\"" ;
         ClassString = "CheckBoxHorasTA" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCitapresencial.getInternalname(), AV6CitaPresencial, "", "", 1, chkavCitapresencial.getEnabled(), "P", "Presencial", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(71, this, 'P', 'NN',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,71);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCitadomicilio.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'" + sGXsfl_12_idx + "',0)\"" ;
         ClassString = "CheckBoxHorasTA" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCitadomicilio.getInternalname(), AV5CitaDomicilio, "", "", 1, chkavCitadomicilio.getEnabled(), "D", "Domicilio", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(76, this, 'D', 'NN',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,76);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCitavirtual.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'" + sGXsfl_12_idx + "',0)\"" ;
         ClassString = "CheckBoxHorasTA" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCitavirtual.getInternalname(), AV7CitaVirtual, "", "", 1, chkavCitavirtual.getEnabled(), "V", "Virtual", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(81, this, 'V', 'NN',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,81);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable5_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-3 txbDateImput", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock3_Internalname, "Desde:", "", "", lblTextblock3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "txbDateFrom", 0, "", 1, 1, 0, (short)(0), "HLP_WPHorarioDisponibleCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-9 txbDateFromImputCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavDatefrom_Internalname, "Desde:", "col-sm-3 AttDateFromDateToLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'" + sGXsfl_12_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDatefrom_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDatefrom_Internalname, localUtil.format(AV8DateFrom, "99/99/9999"), localUtil.format( AV8DateFrom, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,90);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDatefrom_Jsonclick, 0, "AttDateFromDateTo", "", "", "", "", 1, edtavDatefrom_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPHorarioDisponibleCitas.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavDatefrom_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavDatefrom_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPHorarioDisponibleCitas.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-3 txbDateImput", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock6_Internalname, "Hasta:", "", "", lblTextblock6_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "txbDateTo", 0, "", 1, 1, 0, (short)(0), "HLP_WPHorarioDisponibleCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-9 txbDateFromImputCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavDateto_Internalname, "Hasta:", "col-sm-3 AttDateFromDateToLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'',false,'" + sGXsfl_12_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDateto_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDateto_Internalname, localUtil.format(AV9DateTo, "99/99/9999"), localUtil.format( AV9DateTo, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,96);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDateto_Jsonclick, 0, "AttDateFromDateTo", "", "", "", "", 1, edtavDateto_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPHorarioDisponibleCitas.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavDateto_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavDateto_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPHorarioDisponibleCitas.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 btnBuscarHorasCell", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
         ClassString = "btnBuscarHoras" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBuscarhoras_Internalname, "gx.evt.setGridEvt("+GXutil.str( 12, 2, 0)+","+"null"+");", "Buscar", bttBuscarhoras_Jsonclick, 5, "Buscar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'BUSCARHORAS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPHorarioDisponibleCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 tbReservaCitaHorarioCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableseleccionarhorario_Internalname, 1, 0, "px", 0, "px", "tbReservaCitaHorario", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 tbLeyendaPrincipalCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableprincipalleyenda_Internalname, 1, 0, "px", 0, "px", "TableReservaDoctorMesTitle", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 tbFechaActual", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbmostarfechaactual_Internalname, lblTbmostarfechaactual_Caption, "", "", lblTbmostarfechaactual_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "txbFechaActual", 0, "", 1, 1, 0, (short)(0), "HLP_WPHorarioDisponibleCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUclistadohorascitasdisponibles1.setProperty("STDHorariosDoctor", AV13HorariosDoctor);
         ucUclistadohorascitasdisponibles1.render(context, "uclistadohorascitasdisponibles", Uclistadohorascitasdisponibles1_Internalname, "UCLISTADOHORASCITASDISPONIBLES1Container");
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
      if ( wbEnd == 12 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridreservacitaContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV28GXV1 = nGXsfl_12_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridreservacitaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridreservacita", GridreservacitaContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridreservacitaContainerData", GridreservacitaContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridreservacitaContainerData"+"V", GridreservacitaContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridreservacitaContainerData"+"V"+"\" value='"+GridreservacitaContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start6A2( )
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
         Form.getMeta().addItem("description", "Listado de horaios disponibles para la cita", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6A0( ) ;
   }

   public void ws6A2( )
   {
      start6A2( ) ;
      evt6A2( ) ;
   }

   public void evt6A2( )
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
                        else if ( GXutil.strcmp(sEvt, "'BUSCARHORAS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'BuscarHoras' */
                           e116A2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 20), "GRIDRESERVACITA.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_12_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_122( ) ;
                           AV28GXV1 = nGXsfl_12_idx ;
                           if ( ( AV11DoctorReservarCita.size() >= AV28GXV1 ) && ( AV28GXV1 > 0 ) )
                           {
                              AV11DoctorReservarCita.currentItem( ((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e126A2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDRESERVACITA.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e136A2 ();
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
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we6A2( )
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

   public void pa6A2( )
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
            GX_FocusControl = chkavCitapresencial.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridreservacita_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_122( ) ;
      while ( nGXsfl_12_idx <= nRC_GXsfl_12 )
      {
         sendrow_122( ) ;
         nGXsfl_12_idx = ((subGridreservacita_Islastpage==1)&&(nGXsfl_12_idx+1>subgridreservacita_fnc_recordsperpage( )) ? 1 : nGXsfl_12_idx+1) ;
         sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_122( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridreservacitaContainer)) ;
      /* End function gxnrGridreservacita_newrow */
   }

   public void gxgrgridreservacita_refresh( String AV6CitaPresencial ,
                                            String AV5CitaDomicilio ,
                                            String AV7CitaVirtual ,
                                            short AV21ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDRESERVACITA_nCurrentRecord = 0 ;
      rf6A2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridreservacita_refresh */
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
      AV6CitaPresencial = ((GXutil.strcmp(GXutil.rtrim( AV6CitaPresencial), "P")==0) ? "P" : "NN") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CitaPresencial", AV6CitaPresencial);
      AV5CitaDomicilio = ((GXutil.strcmp(GXutil.rtrim( AV5CitaDomicilio), "D")==0) ? "D" : "NN") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CitaDomicilio", AV5CitaDomicilio);
      AV7CitaVirtual = ((GXutil.strcmp(GXutil.rtrim( AV7CitaVirtual), "V")==0) ? "V" : "NN") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CitaVirtual", AV7CitaVirtual);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf6A2( ) ;
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
      edtavCtlprofesionalid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlprofesionalid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlprofesionalid_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtlprofesionalnombrecompleto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlprofesionalnombrecompleto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlprofesionalnombrecompleto_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtlespecialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlespecialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlespecialidadnombre_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldireccion_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtlcalificacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlcalificacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlcalificacion_Enabled), 5, 0), !bGXsfl_12_Refreshing);
   }

   public void rf6A2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridreservacitaContainer.ClearRows();
      }
      wbStart = (short)(12) ;
      nGXsfl_12_idx = 1 ;
      sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_122( ) ;
      bGXsfl_12_Refreshing = true ;
      GridreservacitaContainer.AddObjectProperty("GridName", "Gridreservacita");
      GridreservacitaContainer.AddObjectProperty("CmpContext", "");
      GridreservacitaContainer.AddObjectProperty("InMasterPage", "false");
      GridreservacitaContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridreservacitaContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridreservacitaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridreservacitaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridreservacitaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridreservacita_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridreservacitaContainer.setPageSize( subgridreservacita_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_122( ) ;
         e136A2 ();
         wbEnd = (short)(12) ;
         wb6A0( ) ;
      }
      bGXsfl_12_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6A2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV21ProfesionalId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21ProfesionalId), "ZZZ9")));
   }

   public int subgridreservacita_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridreservacita_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridreservacita_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridreservacita_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavCtlprofesionalid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlprofesionalid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlprofesionalid_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtlprofesionalnombrecompleto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlprofesionalnombrecompleto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlprofesionalnombrecompleto_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtlespecialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlespecialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlespecialidadnombre_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldireccion_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtlcalificacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlcalificacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlcalificacion_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup6A0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e126A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Doctorreservarcita"), AV11DoctorReservarCita);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vHORARIOSDOCTOR"), AV13HorariosDoctor);
         /* Read saved values. */
         nRC_GXsfl_12 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_12"), ",", ".")) ;
         nRC_GXsfl_12 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_12"), ",", ".")) ;
         nGXsfl_12_fel_idx = 0 ;
         while ( nGXsfl_12_fel_idx < nRC_GXsfl_12 )
         {
            nGXsfl_12_fel_idx = ((subGridreservacita_Islastpage==1)&&(nGXsfl_12_fel_idx+1>subgridreservacita_fnc_recordsperpage( )) ? 1 : nGXsfl_12_fel_idx+1) ;
            sGXsfl_12_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_122( ) ;
            AV28GXV1 = nGXsfl_12_fel_idx ;
            if ( ( AV11DoctorReservarCita.size() >= AV28GXV1 ) && ( AV28GXV1 > 0 ) )
            {
               AV11DoctorReservarCita.currentItem( ((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)) );
            }
         }
         if ( nGXsfl_12_fel_idx == 0 )
         {
            nGXsfl_12_idx = 1 ;
            sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_122( ) ;
         }
         nGXsfl_12_fel_idx = 1 ;
         /* Read variables values. */
         AV6CitaPresencial = ((GXutil.strcmp(httpContext.cgiGet( chkavCitapresencial.getInternalname()), "P")==0) ? "P" : "NN") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6CitaPresencial", AV6CitaPresencial);
         AV5CitaDomicilio = ((GXutil.strcmp(httpContext.cgiGet( chkavCitadomicilio.getInternalname()), "D")==0) ? "D" : "NN") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CitaDomicilio", AV5CitaDomicilio);
         AV7CitaVirtual = ((GXutil.strcmp(httpContext.cgiGet( chkavCitavirtual.getInternalname()), "V")==0) ? "V" : "NN") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CitaVirtual", AV7CitaVirtual);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavDatefrom_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vDATEFROM");
            GX_FocusControl = edtavDatefrom_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV8DateFrom = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8DateFrom", localUtil.format(AV8DateFrom, "99/99/9999"));
         }
         else
         {
            AV8DateFrom = localUtil.ctod( httpContext.cgiGet( edtavDatefrom_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8DateFrom", localUtil.format(AV8DateFrom, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavDateto_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vDATETO");
            GX_FocusControl = edtavDateto_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV9DateTo = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9DateTo", localUtil.format(AV9DateTo, "99/99/9999"));
         }
         else
         {
            AV9DateTo = localUtil.ctod( httpContext.cgiGet( edtavDateto_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9DateTo", localUtil.format(AV9DateTo, "99/99/9999"));
         }
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
      e126A2 ();
      if (returnInSub) return;
   }

   public void e126A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      this.executeExternalObjectMethod("", false, "AV25ActualizarPagina", "ActualizarPaginaV4", new Object[] {Integer.valueOf(2)}, false);
      AV13HorariosDoctor.clear();
      AV23Year = (short)(GXutil.year( Gx_date)) ;
      AV22Weekday = localUtil.cdow( (Gx_date), "spa") ;
      AV10Day = (short)(GXutil.day( Gx_date)) ;
      AV20Month = localUtil.cmonth( localUtil.ctod( localUtil.dtoc( Gx_date, 3, "/"), 3), "spa") ;
      AV12FechaActual = AV22Weekday + " " + GXutil.str( AV10Day, 4, 0) + " de " + GXutil.lower( AV20Month) + " del " + GXutil.str( AV23Year, 4, 0) ;
      lblTbmostarfechaactual_Caption = AV12FechaActual ;
      httpContext.ajax_rsp_assign_prop("", false, lblTbmostarfechaactual_Internalname, "Caption", lblTbmostarfechaactual_Caption, true);
      AV18LeyendaOcupado = "<a  class=\"btn\"  style=\"width:100px;height:25px;padding-top:2px;background:#00BAED;\">Libre</a>" ;
      AV17LeyendaLibre = "<a class=\"btn \"  style=\"width:100px;height:25px;padding-top:2px;background:#e9e9e9;\">Ocupado</a>" ;
      lblTxblibre_Caption = AV17LeyendaLibre ;
      httpContext.ajax_rsp_assign_prop("", false, lblTxblibre_Internalname, "Caption", lblTxblibre_Caption, true);
      lblTxbocupado_Caption = AV18LeyendaOcupado ;
      httpContext.ajax_rsp_assign_prop("", false, lblTxbocupado_Internalname, "Caption", lblTxbocupado_Caption, true);
      GXt_objcol_SdtSDTDoctorReservarCita1 = AV11DoctorReservarCita ;
      GXv_objcol_SdtSDTDoctorReservarCita2[0] = GXt_objcol_SdtSDTDoctorReservarCita1 ;
      new com.projectthani.prcmostrardoctorreservacita(remoteHandle, context).execute( AV21ProfesionalId, GXv_objcol_SdtSDTDoctorReservarCita2) ;
      GXt_objcol_SdtSDTDoctorReservarCita1 = GXv_objcol_SdtSDTDoctorReservarCita2[0] ;
      AV11DoctorReservarCita = GXt_objcol_SdtSDTDoctorReservarCita1 ;
      gx_BV12 = true ;
      AV8DateFrom = Gx_date ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8DateFrom", localUtil.format(AV8DateFrom, "99/99/9999"));
      AV9DateTo = GXutil.dadd( Gx_date, (6)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9DateTo", localUtil.format(AV9DateTo, "99/99/9999"));
      AV24TipoDeCita = "" ;
      GXv_objcol_SdtSDTHorariosDoctor3[0] = AV13HorariosDoctor ;
      new com.projectthani.prcgethorariodisponibledoctor(remoteHandle, context).execute( AV21ProfesionalId, AV8DateFrom, AV9DateTo, AV24TipoDeCita, GXv_objcol_SdtSDTHorariosDoctor3) ;
      AV13HorariosDoctor = GXv_objcol_SdtSDTHorariosDoctor3[0] ;
   }

   public void e116A2( )
   {
      /* 'BuscarHoras' Routine */
      returnInSub = false ;
      AV13HorariosDoctor.clear();
      AV24TipoDeCita = AV5CitaDomicilio + AV6CitaPresencial + AV7CitaVirtual ;
      AV24TipoDeCita = GXutil.strReplace( AV24TipoDeCita, "NN", "") ;
      GXv_objcol_SdtSDTHorariosDoctor3[0] = AV13HorariosDoctor ;
      new com.projectthani.prcgethorariodisponibledoctor(remoteHandle, context).execute( AV21ProfesionalId, AV8DateFrom, AV9DateTo, AV24TipoDeCita, GXv_objcol_SdtSDTHorariosDoctor3) ;
      AV13HorariosDoctor = GXv_objcol_SdtSDTHorariosDoctor3[0] ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13HorariosDoctor", AV13HorariosDoctor);
   }

   private void e136A2( )
   {
      /* Gridreservacita_Load Routine */
      returnInSub = false ;
      AV28GXV1 = 1 ;
      while ( AV28GXV1 <= AV11DoctorReservarCita.size() )
      {
         AV11DoctorReservarCita.currentItem( ((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(12) ;
         }
         sendrow_122( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
         {
            httpContext.doAjaxLoad(12, GridreservacitaRow);
         }
         AV28GXV1 = (int)(AV28GXV1+1) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV21ProfesionalId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ProfesionalId), 4, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21ProfesionalId), "ZZZ9")));
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
      pa6A2( ) ;
      ws6A2( ) ;
      we6A2( ) ;
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
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511034381", true, true);
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
      httpContext.AddJavascriptSource("wphorariodisponiblecitas.js", "?2022511034381", false, true);
      httpContext.AddJavascriptSource("UserControls/UCListadoHorasCitasDisponiblesRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_122( )
   {
      edtavCtlprofesionalid_Internalname = "CTLPROFESIONALID_"+sGXsfl_12_idx ;
      edtavCtlprofesionalfoto_Internalname = "CTLPROFESIONALFOTO_"+sGXsfl_12_idx ;
      edtavCtlprofesionalnombrecompleto_Internalname = "CTLPROFESIONALNOMBRECOMPLETO_"+sGXsfl_12_idx ;
      edtavCtlespecialidadnombre_Internalname = "CTLESPECIALIDADNOMBRE_"+sGXsfl_12_idx ;
      edtavCtldireccion_Internalname = "CTLDIRECCION_"+sGXsfl_12_idx ;
      edtavCtlcalificacion_Internalname = "CTLCALIFICACION_"+sGXsfl_12_idx ;
   }

   public void subsflControlProps_fel_122( )
   {
      edtavCtlprofesionalid_Internalname = "CTLPROFESIONALID_"+sGXsfl_12_fel_idx ;
      edtavCtlprofesionalfoto_Internalname = "CTLPROFESIONALFOTO_"+sGXsfl_12_fel_idx ;
      edtavCtlprofesionalnombrecompleto_Internalname = "CTLPROFESIONALNOMBRECOMPLETO_"+sGXsfl_12_fel_idx ;
      edtavCtlespecialidadnombre_Internalname = "CTLESPECIALIDADNOMBRE_"+sGXsfl_12_fel_idx ;
      edtavCtldireccion_Internalname = "CTLDIRECCION_"+sGXsfl_12_fel_idx ;
      edtavCtlcalificacion_Internalname = "CTLCALIFICACION_"+sGXsfl_12_fel_idx ;
   }

   public void sendrow_122( )
   {
      subsflControlProps_122( ) ;
      wb6A0( ) ;
      GridreservacitaRow = GXWebRow.GetNew(context,GridreservacitaContainer) ;
      if ( subGridreservacita_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridreservacita_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridreservacita_Class, "") != 0 )
         {
            subGridreservacita_Linesclass = subGridreservacita_Class+"Odd" ;
         }
      }
      else if ( subGridreservacita_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridreservacita_Backstyle = (byte)(0) ;
         subGridreservacita_Backcolor = subGridreservacita_Allbackcolor ;
         if ( GXutil.strcmp(subGridreservacita_Class, "") != 0 )
         {
            subGridreservacita_Linesclass = subGridreservacita_Class+"Uniform" ;
         }
      }
      else if ( subGridreservacita_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridreservacita_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridreservacita_Class, "") != 0 )
         {
            subGridreservacita_Linesclass = subGridreservacita_Class+"Odd" ;
         }
         subGridreservacita_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridreservacita_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridreservacita_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_12_idx) % (2))) == 0 )
         {
            subGridreservacita_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridreservacita_Class, "") != 0 )
            {
               subGridreservacita_Linesclass = subGridreservacita_Class+"Even" ;
            }
         }
         else
         {
            subGridreservacita_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridreservacita_Class, "") != 0 )
            {
               subGridreservacita_Linesclass = subGridreservacita_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridreservacitaContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridreservacita_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_12_idx+"\">") ;
      }
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGridreservacitatable1_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridreservacitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlprofesionalid_Internalname,"Disponibilidad Id","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridreservacitaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlprofesionalid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)).getgxTv_SdtSDTDoctorReservarCita_Profesionalid(), (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlprofesionalid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)).getgxTv_SdtSDTDoctorReservarCita_Profesionalid()), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)).getgxTv_SdtSDTDoctorReservarCita_Profesionalid()), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlprofesionalid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlprofesionalid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(12),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-3","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTable1_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","Center","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridreservacitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"","Profesional Foto","col-sm-3 ImgDoctorReservaLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Static Bitmap Variable */
      ClassString = "ImgDoctorReserva" ;
      StyleString = "" ;
      sImgUrl = httpContext.getResourceRelative(((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)).getgxTv_SdtSDTDoctorReservarCita_Profesionalfoto()) ;
      GridreservacitaRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavCtlprofesionalfoto_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(2),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-9","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTabledatosgenerales_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","tbReservaDetalleDoctorCell","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridreservacitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlprofesionalnombrecompleto_Internalname,"Profesional Nombre Completo","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridreservacitaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlprofesionalnombrecompleto_Internalname,((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)).getgxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlprofesionalnombrecompleto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlprofesionalnombrecompleto_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(2),Integer.valueOf(12),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridreservacitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlespecialidadnombre_Internalname,"Especialidad Nombre","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridreservacitaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlespecialidadnombre_Internalname,((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)).getgxTv_SdtSDTDoctorReservarCita_Especialidadnombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlespecialidadnombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlespecialidadnombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(2),Integer.valueOf(12),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridreservacitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtldireccion_Internalname,"Direccion","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      GridreservacitaRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtldireccion_Internalname,((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)).getgxTv_SdtSDTDoctorReservarCita_Direccion(),"","",Integer.valueOf(2),Integer.valueOf(1),Integer.valueOf(edtavCtldireccion_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(7),"row",StyleString,ClassString,"","","500",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridreservacitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridreservacitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlcalificacion_Internalname,"Calificacion","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      GridreservacitaRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlcalificacion_Internalname,((com.projectthani.SdtSDTDoctorReservarCita)AV11DoctorReservarCita.elementAt(-1+AV28GXV1)).getgxTv_SdtSDTDoctorReservarCita_Calificacion(),"","",Integer.valueOf(2),Integer.valueOf(1),Integer.valueOf(edtavCtlcalificacion_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",StyleString,ClassString,"","","2097152",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridreservacitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6A2( ) ;
      /* End of Columns property logic. */
      GridreservacitaContainer.AddRow(GridreservacitaRow);
      nGXsfl_12_idx = ((subGridreservacita_Islastpage==1)&&(nGXsfl_12_idx+1>subgridreservacita_fnc_recordsperpage( )) ? 1 : nGXsfl_12_idx+1) ;
      sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_122( ) ;
      /* End function sendrow_122 */
   }

   public void init_default_properties( )
   {
      edtavCtlprofesionalid_Internalname = "CTLPROFESIONALID" ;
      edtavCtlprofesionalfoto_Internalname = "CTLPROFESIONALFOTO" ;
      divTable1_Internalname = "TABLE1" ;
      edtavCtlprofesionalnombrecompleto_Internalname = "CTLPROFESIONALNOMBRECOMPLETO" ;
      edtavCtlespecialidadnombre_Internalname = "CTLESPECIALIDADNOMBRE" ;
      edtavCtldireccion_Internalname = "CTLDIRECCION" ;
      edtavCtlcalificacion_Internalname = "CTLCALIFICACION" ;
      divTabledatosgenerales_Internalname = "TABLEDATOSGENERALES" ;
      divGridreservacitatable1_Internalname = "GRIDRESERVACITATABLE1" ;
      divTable2_Internalname = "TABLE2" ;
      lblTextblock5_Internalname = "TEXTBLOCK5" ;
      lblTxbocupado_Internalname = "TXBOCUPADO" ;
      lblTxblibre_Internalname = "TXBLIBRE" ;
      divTableleyenda_Internalname = "TABLELEYENDA" ;
      lblTextblock4_Internalname = "TEXTBLOCK4" ;
      lblTextblock2_Internalname = "TEXTBLOCK2" ;
      chkavCitapresencial.setInternalname( "vCITAPRESENCIAL" );
      chkavCitadomicilio.setInternalname( "vCITADOMICILIO" );
      chkavCitavirtual.setInternalname( "vCITAVIRTUAL" );
      lblTextblock3_Internalname = "TEXTBLOCK3" ;
      edtavDatefrom_Internalname = "vDATEFROM" ;
      lblTextblock6_Internalname = "TEXTBLOCK6" ;
      edtavDateto_Internalname = "vDATETO" ;
      divTable5_Internalname = "TABLE5" ;
      bttBuscarhoras_Internalname = "BUSCARHORAS" ;
      divTable4_Internalname = "TABLE4" ;
      divTabledetalledoctorreserva_Internalname = "TABLEDETALLEDOCTORRESERVA" ;
      lblTbmostarfechaactual_Internalname = "TBMOSTARFECHAACTUAL" ;
      divTableprincipalleyenda_Internalname = "TABLEPRINCIPALLEYENDA" ;
      Uclistadohorascitasdisponibles1_Internalname = "UCLISTADOHORASCITASDISPONIBLES1" ;
      divTable3_Internalname = "TABLE3" ;
      divTableseleccionarhorario_Internalname = "TABLESELECCIONARHORARIO" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridreservacita_Internalname = "GRIDRESERVACITA" ;
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
      edtavCtlespecialidadnombre_Jsonclick = "" ;
      edtavCtlprofesionalnombrecompleto_Jsonclick = "" ;
      edtavCtlprofesionalid_Jsonclick = "" ;
      subGridreservacita_Class = "FreeStyleGrid" ;
      edtavCtlcalificacion_Enabled = -1 ;
      edtavCtldireccion_Enabled = -1 ;
      edtavCtlespecialidadnombre_Enabled = -1 ;
      edtavCtlprofesionalnombrecompleto_Enabled = -1 ;
      edtavCtlprofesionalid_Enabled = -1 ;
      lblTbmostarfechaactual_Caption = "Text Block" ;
      edtavDateto_Jsonclick = "" ;
      edtavDateto_Enabled = 1 ;
      edtavDatefrom_Jsonclick = "" ;
      edtavDatefrom_Enabled = 1 ;
      chkavCitavirtual.setEnabled( 1 );
      chkavCitadomicilio.setEnabled( 1 );
      chkavCitapresencial.setEnabled( 1 );
      lblTxblibre_Caption = "Text Block" ;
      lblTxbocupado_Caption = "Text Block" ;
      subGridreservacita_Allowcollapsing = (byte)(0) ;
      edtavCtlcalificacion_Enabled = 0 ;
      edtavCtldireccion_Enabled = 0 ;
      edtavCtlespecialidadnombre_Enabled = 0 ;
      edtavCtlprofesionalnombrecompleto_Enabled = 0 ;
      edtavCtlprofesionalid_Enabled = 0 ;
      subGridreservacita_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Listado de horaios disponibles para la cita" );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavCitapresencial.setName( "vCITAPRESENCIAL" );
      chkavCitapresencial.setWebtags( "" );
      chkavCitapresencial.setCaption( "Presencial" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCitapresencial.getInternalname(), "TitleCaption", chkavCitapresencial.getCaption(), true);
      chkavCitapresencial.setCheckedValue( "NN" );
      AV6CitaPresencial = ((GXutil.strcmp(GXutil.rtrim( AV6CitaPresencial), "P")==0) ? "P" : "NN") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CitaPresencial", AV6CitaPresencial);
      chkavCitadomicilio.setName( "vCITADOMICILIO" );
      chkavCitadomicilio.setWebtags( "" );
      chkavCitadomicilio.setCaption( "Domicilio" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCitadomicilio.getInternalname(), "TitleCaption", chkavCitadomicilio.getCaption(), true);
      chkavCitadomicilio.setCheckedValue( "NN" );
      AV5CitaDomicilio = ((GXutil.strcmp(GXutil.rtrim( AV5CitaDomicilio), "D")==0) ? "D" : "NN") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CitaDomicilio", AV5CitaDomicilio);
      chkavCitavirtual.setName( "vCITAVIRTUAL" );
      chkavCitavirtual.setWebtags( "" );
      chkavCitavirtual.setCaption( "Virtual" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCitavirtual.getInternalname(), "TitleCaption", chkavCitavirtual.getCaption(), true);
      chkavCitavirtual.setCheckedValue( "NN" );
      AV7CitaVirtual = ((GXutil.strcmp(GXutil.rtrim( AV7CitaVirtual), "V")==0) ? "V" : "NN") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CitaVirtual", AV7CitaVirtual);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDRESERVACITA_nFirstRecordOnPage'},{av:'GRIDRESERVACITA_nEOF'},{av:'AV11DoctorReservarCita',fld:'vDOCTORRESERVARCITA',grid:12,pic:''},{av:'nRC_GXsfl_12',ctrl:'GRIDRESERVACITA',prop:'GridRC',grid:12},{av:'AV21ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZ9',hsh:true},{av:'AV6CitaPresencial',fld:'vCITAPRESENCIAL',pic:''},{av:'AV5CitaDomicilio',fld:'vCITADOMICILIO',pic:''},{av:'AV7CitaVirtual',fld:'vCITAVIRTUAL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV6CitaPresencial',fld:'vCITAPRESENCIAL',pic:''},{av:'AV5CitaDomicilio',fld:'vCITADOMICILIO',pic:''},{av:'AV7CitaVirtual',fld:'vCITAVIRTUAL',pic:''}]}");
      setEventMetadata("'BUSCARHORAS'","{handler:'e116A2',iparms:[{av:'AV21ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZ9',hsh:true},{av:'AV8DateFrom',fld:'vDATEFROM',pic:''},{av:'AV9DateTo',fld:'vDATETO',pic:''},{av:'AV6CitaPresencial',fld:'vCITAPRESENCIAL',pic:''},{av:'AV5CitaDomicilio',fld:'vCITADOMICILIO',pic:''},{av:'AV7CitaVirtual',fld:'vCITAVIRTUAL',pic:''}]");
      setEventMetadata("'BUSCARHORAS'",",oparms:[{av:'AV13HorariosDoctor',fld:'vHORARIOSDOCTOR',pic:''},{av:'AV6CitaPresencial',fld:'vCITAPRESENCIAL',pic:''},{av:'AV5CitaDomicilio',fld:'vCITADOMICILIO',pic:''},{av:'AV7CitaVirtual',fld:'vCITAVIRTUAL',pic:''}]}");
      setEventMetadata("VALIDV_DATEFROM","{handler:'validv_Datefrom',iparms:[{av:'AV6CitaPresencial',fld:'vCITAPRESENCIAL',pic:''},{av:'AV5CitaDomicilio',fld:'vCITADOMICILIO',pic:''},{av:'AV7CitaVirtual',fld:'vCITAVIRTUAL',pic:''}]");
      setEventMetadata("VALIDV_DATEFROM",",oparms:[{av:'AV6CitaPresencial',fld:'vCITAPRESENCIAL',pic:''},{av:'AV5CitaDomicilio',fld:'vCITADOMICILIO',pic:''},{av:'AV7CitaVirtual',fld:'vCITAVIRTUAL',pic:''}]}");
      setEventMetadata("VALIDV_DATETO","{handler:'validv_Dateto',iparms:[{av:'AV6CitaPresencial',fld:'vCITAPRESENCIAL',pic:''},{av:'AV5CitaDomicilio',fld:'vCITADOMICILIO',pic:''},{av:'AV7CitaVirtual',fld:'vCITAVIRTUAL',pic:''}]");
      setEventMetadata("VALIDV_DATETO",",oparms:[{av:'AV6CitaPresencial',fld:'vCITAPRESENCIAL',pic:''},{av:'AV5CitaDomicilio',fld:'vCITADOMICILIO',pic:''},{av:'AV7CitaVirtual',fld:'vCITAVIRTUAL',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv7',iparms:[{av:'AV6CitaPresencial',fld:'vCITAPRESENCIAL',pic:''},{av:'AV5CitaDomicilio',fld:'vCITADOMICILIO',pic:''},{av:'AV7CitaVirtual',fld:'vCITAVIRTUAL',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV6CitaPresencial',fld:'vCITAPRESENCIAL',pic:''},{av:'AV5CitaDomicilio',fld:'vCITADOMICILIO',pic:''},{av:'AV7CitaVirtual',fld:'vCITAVIRTUAL',pic:''}]}");
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
      AV6CitaPresencial = "" ;
      AV5CitaDomicilio = "" ;
      AV7CitaVirtual = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV11DoctorReservarCita = new GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita>(com.projectthani.SdtSDTDoctorReservarCita.class, "SDTDoctorReservarCita", "ProjectThani", remoteHandle);
      AV13HorariosDoctor = new GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor>(com.projectthani.SdtSDTHorariosDoctor.class, "SDTHorariosDoctor", "ProjectThani", remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      GridreservacitaContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGridreservacita_Header = "" ;
      GridreservacitaColumn = new com.genexus.webpanels.GXWebColumn();
      lblTextblock5_Jsonclick = "" ;
      lblTxbocupado_Jsonclick = "" ;
      lblTxblibre_Jsonclick = "" ;
      lblTextblock4_Jsonclick = "" ;
      lblTextblock2_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblock3_Jsonclick = "" ;
      AV8DateFrom = GXutil.resetTime(GXutil.now( )) ;
      lblTextblock6_Jsonclick = "" ;
      AV9DateTo = GXutil.nullDate() ;
      bttBuscarhoras_Jsonclick = "" ;
      lblTbmostarfechaactual_Jsonclick = "" ;
      ucUclistadohorascitasdisponibles1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      Gx_date = GXutil.nullDate() ;
      AV22Weekday = "" ;
      AV20Month = "" ;
      AV12FechaActual = "" ;
      AV18LeyendaOcupado = "" ;
      AV17LeyendaLibre = "" ;
      GXt_objcol_SdtSDTDoctorReservarCita1 = new GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita>(com.projectthani.SdtSDTDoctorReservarCita.class, "SDTDoctorReservarCita", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTDoctorReservarCita2 = new GXBaseCollection[1] ;
      AV24TipoDeCita = "" ;
      GXv_objcol_SdtSDTHorariosDoctor3 = new GXBaseCollection[1] ;
      GridreservacitaRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridreservacita_Linesclass = "" ;
      ROClassString = "" ;
      sImgUrl = "" ;
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavCtlprofesionalid_Enabled = 0 ;
      edtavCtlprofesionalnombrecompleto_Enabled = 0 ;
      edtavCtlespecialidadnombre_Enabled = 0 ;
      edtavCtldireccion_Enabled = 0 ;
      edtavCtlcalificacion_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subGridreservacita_Backcolorstyle ;
   private byte subGridreservacita_Allowselection ;
   private byte subGridreservacita_Allowhovering ;
   private byte subGridreservacita_Allowcollapsing ;
   private byte subGridreservacita_Collapsed ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGridreservacita_Backstyle ;
   private byte GRIDRESERVACITA_nEOF ;
   private short wcpOAV21ProfesionalId ;
   private short AV21ProfesionalId ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV23Year ;
   private short AV10Day ;
   private int nRC_GXsfl_12 ;
   private int nGXsfl_12_idx=1 ;
   private int edtavCtlprofesionalid_Enabled ;
   private int edtavCtlprofesionalnombrecompleto_Enabled ;
   private int edtavCtlespecialidadnombre_Enabled ;
   private int edtavCtldireccion_Enabled ;
   private int edtavCtlcalificacion_Enabled ;
   private int subGridreservacita_Selectedindex ;
   private int subGridreservacita_Selectioncolor ;
   private int subGridreservacita_Hoveringcolor ;
   private int AV28GXV1 ;
   private int edtavDatefrom_Enabled ;
   private int edtavDateto_Enabled ;
   private int subGridreservacita_Islastpage ;
   private int nGXsfl_12_fel_idx=1 ;
   private int idxLst ;
   private int subGridreservacita_Backcolor ;
   private int subGridreservacita_Allbackcolor ;
   private long GRIDRESERVACITA_nCurrentRecord ;
   private long GRIDRESERVACITA_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_12_idx="0001" ;
   private String AV6CitaPresencial ;
   private String AV5CitaDomicilio ;
   private String AV7CitaVirtual ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTabledetalledoctorreserva_Internalname ;
   private String divTable2_Internalname ;
   private String sStyleString ;
   private String subGridreservacita_Internalname ;
   private String subGridreservacita_Header ;
   private String divTableleyenda_Internalname ;
   private String lblTextblock5_Internalname ;
   private String lblTextblock5_Jsonclick ;
   private String lblTxbocupado_Internalname ;
   private String lblTxbocupado_Caption ;
   private String lblTxbocupado_Jsonclick ;
   private String lblTxblibre_Internalname ;
   private String lblTxblibre_Caption ;
   private String lblTxblibre_Jsonclick ;
   private String divTable4_Internalname ;
   private String lblTextblock4_Internalname ;
   private String lblTextblock4_Jsonclick ;
   private String lblTextblock2_Internalname ;
   private String lblTextblock2_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String divTable5_Internalname ;
   private String lblTextblock3_Internalname ;
   private String lblTextblock3_Jsonclick ;
   private String edtavDatefrom_Internalname ;
   private String edtavDatefrom_Jsonclick ;
   private String lblTextblock6_Internalname ;
   private String lblTextblock6_Jsonclick ;
   private String edtavDateto_Internalname ;
   private String edtavDateto_Jsonclick ;
   private String bttBuscarhoras_Internalname ;
   private String bttBuscarhoras_Jsonclick ;
   private String divTableseleccionarhorario_Internalname ;
   private String divTableprincipalleyenda_Internalname ;
   private String lblTbmostarfechaactual_Internalname ;
   private String lblTbmostarfechaactual_Caption ;
   private String lblTbmostarfechaactual_Jsonclick ;
   private String divTable3_Internalname ;
   private String Uclistadohorascitasdisponibles1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavCtlprofesionalid_Internalname ;
   private String edtavCtlprofesionalnombrecompleto_Internalname ;
   private String edtavCtlespecialidadnombre_Internalname ;
   private String edtavCtldireccion_Internalname ;
   private String edtavCtlcalificacion_Internalname ;
   private String sGXsfl_12_fel_idx="0001" ;
   private String edtavCtlprofesionalfoto_Internalname ;
   private String subGridreservacita_Class ;
   private String subGridreservacita_Linesclass ;
   private String divGridreservacitatable1_Internalname ;
   private String ROClassString ;
   private String edtavCtlprofesionalid_Jsonclick ;
   private String divTable1_Internalname ;
   private String sImgUrl ;
   private String divTabledatosgenerales_Internalname ;
   private String edtavCtlprofesionalnombrecompleto_Jsonclick ;
   private String edtavCtlespecialidadnombre_Jsonclick ;
   private java.util.Date AV8DateFrom ;
   private java.util.Date AV9DateTo ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_12_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV12 ;
   private String AV18LeyendaOcupado ;
   private String AV17LeyendaLibre ;
   private String AV22Weekday ;
   private String AV20Month ;
   private String AV12FechaActual ;
   private String AV24TipoDeCita ;
   private com.genexus.webpanels.GXWebGrid GridreservacitaContainer ;
   private com.genexus.webpanels.GXWebRow GridreservacitaRow ;
   private com.genexus.webpanels.GXWebColumn GridreservacitaColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucUclistadohorascitasdisponibles1 ;
   private ICheckbox chkavCitapresencial ;
   private ICheckbox chkavCitadomicilio ;
   private ICheckbox chkavCitavirtual ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita> AV11DoctorReservarCita ;
   private GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita> GXt_objcol_SdtSDTDoctorReservarCita1 ;
   private GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita> GXv_objcol_SdtSDTDoctorReservarCita2[] ;
   private GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor> AV13HorariosDoctor ;
   private GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor> GXv_objcol_SdtSDTHorariosDoctor3[] ;
}

