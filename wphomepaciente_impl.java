package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wphomepaciente_impl extends GXDataArea
{
   public wphomepaciente_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wphomepaciente_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wphomepaciente_impl.class ));
   }

   public wphomepaciente_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV9PantallaEdit = (String) args[0];
         AV6PacienteFamiliarIdEdit = (int) GXutil.lval( args[1]);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

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
         gxfirstwebparm = httpContext.GetFirstPar( "PantallaEdit") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "PantallaEdit") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "PantallaEdit") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid2") == 0 )
         {
            nRC_GXsfl_15 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_15"))) ;
            nGXsfl_15_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_15_idx"))) ;
            sGXsfl_15_idx = httpContext.GetPar( "sGXsfl_15_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgrid2_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid2") == 0 )
         {
            AV9PantallaEdit = httpContext.GetPar( "PantallaEdit") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid2_refresh( AV9PantallaEdit) ;
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
            AV9PantallaEdit = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9PantallaEdit", AV9PantallaEdit);
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPANTALLAEDIT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9PantallaEdit, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV6PacienteFamiliarIdEdit = (int)(GXutil.lval( httpContext.GetPar( "PacienteFamiliarIdEdit"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV6PacienteFamiliarIdEdit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6PacienteFamiliarIdEdit), 8, 0));
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
      pa342( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start342( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033469", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormFondoHomPagPaciente\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoHomPagPaciente\" data-gx-class=\"form-horizontal FormFondoHomPagPaciente\" novalidate action=\""+formatLink("com.projectthani.wphomepaciente", new String[] {GXutil.URLEncode(GXutil.rtrim(AV9PantallaEdit)),GXutil.URLEncode(GXutil.ltrimstr(AV6PacienteFamiliarIdEdit,8,0))}, new String[] {"PantallaEdit","PacienteFamiliarIdEdit"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormFondoHomPagPaciente", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPANTALLAEDIT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9PantallaEdit, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Datospaciente", AV5DatosPaciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Datospaciente", AV5DatosPaciente);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_15", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_15, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPANTALLA", AV8Pantalla);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPANTALLAEDIT", AV9PantallaEdit);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPANTALLAEDIT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9PantallaEdit, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEFAMILIARIDEDIT", GXutil.ltrim( localUtil.ntoc( AV6PacienteFamiliarIdEdit, (byte)(8), (byte)(0), ",", "")));
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
      if ( ! ( WebComp_Componentform == null ) )
      {
         WebComp_Componentform.componentjscripts();
      }
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormFondoHomPagPaciente" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we342( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt342( ) ;
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
      return formatLink("com.projectthani.wphomepaciente", new String[] {GXutil.URLEncode(GXutil.rtrim(AV9PantallaEdit)),GXutil.URLEncode(GXutil.ltrimstr(AV6PacienteFamiliarIdEdit,8,0))}, new String[] {"PantallaEdit","PacienteFamiliarIdEdit"})  ;
   }

   public String getPgmname( )
   {
      return "WPHomePaciente" ;
   }

   public String getPgmdesc( )
   {
      return "Home Paciente" ;
   }

   public void wb340( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table TableTransactionTemplate", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "TableHomePaciente", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableborderhp_Internalname, 1, 0, "px", 0, "px", "TableBorderHP", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid2Container.SetIsFreestyle(true);
         Grid2Container.SetWrapped(nGXWrapped);
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"Grid2Container"+"DivS\" data-gxgridid=\"15\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGrid2_Internalname, subGrid2_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            Grid2Container.AddObjectProperty("GridName", "Grid2");
         }
         else
         {
            Grid2Container.AddObjectProperty("GridName", "Grid2");
            Grid2Container.AddObjectProperty("Header", subGrid2_Header);
            Grid2Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            Grid2Container.AddObjectProperty("Class", "FreeStyleGrid");
            Grid2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("CmpContext", "");
            Grid2Container.AddObjectProperty("InMasterPage", "false");
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlidpaciente_Enabled, (byte)(5), (byte)(0), ".", "")));
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlnombresapellidos_Enabled, (byte)(5), (byte)(0), ".", "")));
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlfechanacimientoedad_Enabled, (byte)(5), (byte)(0), ".", "")));
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtldireccion_Enabled, (byte)(5), (byte)(0), ".", "")));
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid2_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid2_Allowselection, (byte)(1), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid2_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid2_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid2_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid2_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid2_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_15 = (int)(nGXsfl_15_idx-1) ;
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV13GXV1 = nGXsfl_15_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Grid2Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid2", Grid2Container);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData", Grid2Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData"+"V", Grid2Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid2ContainerData"+"V"+"\" value='"+Grid2Container.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable4_Internalname, 1, 0, "px", 0, "px", "TableMenuPaciente1", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TablePB10", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
         ClassString = "ButtonMiMenuPaciente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttMiperfil_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Mi Perfil", bttMiperfil_Jsonclick, 7, "Mi Perfil", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11341_client"+"'", TempTags, "", 2, "HLP_WPHomePaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TablePB10", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
         ClassString = "ButtonMiMenuPaciente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttDependientes_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Dependientes", bttDependientes_Jsonclick, 7, "Dependientes", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e12341_client"+"'", TempTags, "", 2, "HLP_WPHomePaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TablePB10", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
         ClassString = "ButtonMiMenuPaciente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttMiscitas_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Mis Citas", bttMiscitas_Jsonclick, 7, "Mis Citas", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e13341_client"+"'", TempTags, "", 2, "HLP_WPHomePaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TablePB10", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
         ClassString = "ButtonMiMenuPaciente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttComprobantes_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Mis Comprobantes", bttComprobantes_Jsonclick, 7, "Mis Comprobantes", "", StyleString, ClassString, bttComprobantes_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e14341_client"+"'", TempTags, "", 2, "HLP_WPHomePaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TablePB10", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
         ClassString = "ButtonMiMenuPaciente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCambiarpassword_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Cambiar Contraseña", bttCambiarpassword_Jsonclick, 7, "Cambiar Contraseña", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e15341_client"+"'", TempTags, "", 2, "HLP_WPHomePaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TablePB10", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
         ClassString = "ButtonHPPCerrarSesion" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCerrarsesion_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", "Cerrar Sesión", bttCerrarsesion_Jsonclick, 7, "Cerrar Sesión", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e16341_client"+"'", TempTags, "", 2, "HLP_WPHomePaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "TableContentPaciente", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0062"+"", GXutil.rtrim( WebComp_Componentform_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0062"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Componentform_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldComponentform), GXutil.lower( WebComp_Componentform_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0062"+"");
               }
               WebComp_Componentform.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldComponentform), GXutil.lower( WebComp_Componentform_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
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
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Grid2Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV13GXV1 = nGXsfl_15_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Grid2Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid2", Grid2Container);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData", Grid2Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData"+"V", Grid2Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid2ContainerData"+"V"+"\" value='"+Grid2Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start342( )
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
         Form.getMeta().addItem("description", "Home Paciente", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup340( ) ;
   }

   public void ws342( )
   {
      start342( ) ;
      evt342( ) ;
   }

   public void evt342( )
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID2.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_15_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_152( ) ;
                           AV13GXV1 = nGXsfl_15_idx ;
                           if ( ( AV5DatosPaciente.size() >= AV13GXV1 ) && ( AV13GXV1 > 0 ) )
                           {
                              AV5DatosPaciente.currentItem( ((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV13GXV1)) );
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
                                 e17342 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e18342 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID2.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e19342 ();
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
                     if ( nCmpId == 62 )
                     {
                        OldComponentform = httpContext.cgiGet( "W0062") ;
                        if ( ( GXutil.len( OldComponentform) == 0 ) || ( GXutil.strcmp(OldComponentform, WebComp_Componentform_Component) != 0 ) )
                        {
                           WebComp_Componentform = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldComponentform + "_impl", remoteHandle, context);
                           WebComp_Componentform_Component = OldComponentform ;
                        }
                        if ( GXutil.len( WebComp_Componentform_Component) != 0 )
                        {
                           WebComp_Componentform.componentprocess("W0062", "", sEvt);
                        }
                        WebComp_Componentform_Component = OldComponentform ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we342( )
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

   public void pa342( )
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

   public void gxnrgrid2_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_152( ) ;
      while ( nGXsfl_15_idx <= nRC_GXsfl_15 )
      {
         sendrow_152( ) ;
         nGXsfl_15_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_15_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid2Container)) ;
      /* End function gxnrGrid2_newrow */
   }

   public void gxgrgrid2_refresh( String AV9PantallaEdit )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e18342 ();
      GRID2_nCurrentRecord = 0 ;
      rf342( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid2_refresh */
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
      rf342( ) ;
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
      edtavCtlidpaciente_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlidpaciente_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlidpaciente_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavCtlnombresapellidos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnombresapellidos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnombresapellidos_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavCtlfechanacimientoedad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlfechanacimientoedad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlfechanacimientoedad_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavCtldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldireccion_Enabled), 5, 0), !bGXsfl_15_Refreshing);
   }

   public void rf342( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid2Container.ClearRows();
      }
      wbStart = (short)(15) ;
      /* Execute user event: Refresh */
      e18342 ();
      nGXsfl_15_idx = 1 ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
      bGXsfl_15_Refreshing = true ;
      Grid2Container.AddObjectProperty("GridName", "Grid2");
      Grid2Container.AddObjectProperty("CmpContext", "");
      Grid2Container.AddObjectProperty("InMasterPage", "false");
      Grid2Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      Grid2Container.AddObjectProperty("Class", "FreeStyleGrid");
      Grid2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid2Container.setPageSize( subgrid2_fnc_recordsperpage( ) );
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Componentform_Component) != 0 )
            {
               WebComp_Componentform.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_152( ) ;
         e19342 ();
         wbEnd = (short)(15) ;
         wb340( ) ;
      }
      bGXsfl_15_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes342( )
   {
   }

   public int subgrid2_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavCtlidpaciente_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlidpaciente_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlidpaciente_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavCtlnombresapellidos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnombresapellidos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnombresapellidos_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavCtlfechanacimientoedad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlfechanacimientoedad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlfechanacimientoedad_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavCtldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldireccion_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup340( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e17342 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Datospaciente"), AV5DatosPaciente);
         /* Read saved values. */
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_15"), ",", ".")) ;
         AV6PacienteFamiliarIdEdit = (int)(localUtil.ctol( httpContext.cgiGet( "vPACIENTEFAMILIARIDEDIT"), ",", ".")) ;
         AV8Pantalla = httpContext.cgiGet( "vPANTALLA") ;
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_15"), ",", ".")) ;
         nGXsfl_15_fel_idx = 0 ;
         while ( nGXsfl_15_fel_idx < nRC_GXsfl_15 )
         {
            nGXsfl_15_fel_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_15_fel_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_15_fel_idx+1) ;
            sGXsfl_15_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_152( ) ;
            AV13GXV1 = nGXsfl_15_fel_idx ;
            if ( ( AV5DatosPaciente.size() >= AV13GXV1 ) && ( AV13GXV1 > 0 ) )
            {
               AV5DatosPaciente.currentItem( ((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV13GXV1)) );
            }
         }
         if ( nGXsfl_15_fel_idx == 0 )
         {
            nGXsfl_15_idx = 1 ;
            sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_152( ) ;
         }
         nGXsfl_15_fel_idx = 1 ;
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
      e17342 ();
      if (returnInSub) return;
   }

   public void e17342( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" type=\"text/css\" href=\"./static/MiPerfilCitas.css\">" );
      bttComprobantes_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttComprobantes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttComprobantes_Visible), 5, 0), true);
      if ( (GXutil.strcmp("", AV10WebSession.getValue("WSPacienteId"))==0) )
      {
         callWebObject(formatLink("com.projectthani.wploginpaciente", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV9PantallaEdit, "EditarPacienteFamiliar") == 0 ) && ( AV6PacienteFamiliarIdEdit > 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Componentform = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Componentform_Component), GXutil.lower( "WCEditarPacienteFamiliar")) != 0 )
         {
            WebComp_Componentform = WebUtils.getWebComponent(getClass(), "com.projectthani.wceditarpacientefamiliar_impl", remoteHandle, context);
            WebComp_Componentform_Component = "WCEditarPacienteFamiliar" ;
         }
         if ( GXutil.len( WebComp_Componentform_Component) != 0 )
         {
            WebComp_Componentform.setjustcreated();
            WebComp_Componentform.componentprepare(new Object[] {"W0062","",Integer.valueOf(AV6PacienteFamiliarIdEdit)});
            WebComp_Componentform.componentbind(new Object[] {""});
         }
      }
      else
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Componentform = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Componentform_Component), GXutil.lower( "WCMiPerfil")) != 0 )
         {
            WebComp_Componentform = WebUtils.getWebComponent(getClass(), "com.projectthani.wcmiperfil_impl", remoteHandle, context);
            WebComp_Componentform_Component = "WCMiPerfil" ;
         }
         if ( GXutil.len( WebComp_Componentform_Component) != 0 )
         {
            WebComp_Componentform.setjustcreated();
            WebComp_Componentform.componentprepare(new Object[] {"W0062",""});
            WebComp_Componentform.componentbind(new Object[] {});
         }
      }
      if ( GXutil.strcmp(AV9PantallaEdit, "MisCitas") == 0 )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Componentform = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Componentform_Component), GXutil.lower( "WCMisCitas")) != 0 )
         {
            WebComp_Componentform = WebUtils.getWebComponent(getClass(), "com.projectthani.wcmiscitas_impl", remoteHandle, context);
            WebComp_Componentform_Component = "WCMisCitas" ;
         }
         if ( GXutil.len( WebComp_Componentform_Component) != 0 )
         {
            WebComp_Componentform.setjustcreated();
            WebComp_Componentform.componentprepare(new Object[] {"W0062",""});
            WebComp_Componentform.componentbind(new Object[] {});
         }
      }
      AV7PacienteId = (int)(GXutil.lval( AV10WebSession.getValue("WSPacienteId"))) ;
      GXt_objcol_SdtSDTDatosDelPaciente1 = AV5DatosPaciente ;
      GXv_objcol_SdtSDTDatosDelPaciente2[0] = GXt_objcol_SdtSDTDatosDelPaciente1 ;
      new com.projectthani.prcinfodelpaciente(remoteHandle, context).execute( AV7PacienteId, GXv_objcol_SdtSDTDatosDelPaciente2) ;
      GXt_objcol_SdtSDTDatosDelPaciente1 = GXv_objcol_SdtSDTDatosDelPaciente2[0] ;
      AV5DatosPaciente = GXt_objcol_SdtSDTDatosDelPaciente1 ;
      gx_BV15 = true ;
   }

   public void e18342( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      AV6PacienteFamiliarIdEdit = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6PacienteFamiliarIdEdit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6PacienteFamiliarIdEdit), 8, 0));
      /*  Sending Event outputs  */
   }

   private void e19342( )
   {
      /* Grid2_Load Routine */
      returnInSub = false ;
      AV13GXV1 = 1 ;
      while ( AV13GXV1 <= AV5DatosPaciente.size() )
      {
         AV5DatosPaciente.currentItem( ((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV13GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(15) ;
         }
         sendrow_152( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_15_Refreshing )
         {
            httpContext.doAjaxLoad(15, Grid2Row);
         }
         AV13GXV1 = (int)(AV13GXV1+1) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV9PantallaEdit = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9PantallaEdit", AV9PantallaEdit);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPANTALLAEDIT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9PantallaEdit, ""))));
      AV6PacienteFamiliarIdEdit = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6PacienteFamiliarIdEdit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6PacienteFamiliarIdEdit), 8, 0));
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
      pa342( ) ;
      ws342( ) ;
      we342( ) ;
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
      if ( ! ( WebComp_Componentform == null ) )
      {
         if ( GXutil.len( WebComp_Componentform_Component) != 0 )
         {
            WebComp_Componentform.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334639", true, true);
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
      httpContext.AddJavascriptSource("wphomepaciente.js", "?20225110334639", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_152( )
   {
      edtavCtlidpaciente_Internalname = "CTLIDPACIENTE_"+sGXsfl_15_idx ;
      edtavCtlfotografia_Internalname = "CTLFOTOGRAFIA_"+sGXsfl_15_idx ;
      edtavCtlnombresapellidos_Internalname = "CTLNOMBRESAPELLIDOS_"+sGXsfl_15_idx ;
      edtavCtlfechanacimientoedad_Internalname = "CTLFECHANACIMIENTOEDAD_"+sGXsfl_15_idx ;
      edtavCtldireccion_Internalname = "CTLDIRECCION_"+sGXsfl_15_idx ;
   }

   public void subsflControlProps_fel_152( )
   {
      edtavCtlidpaciente_Internalname = "CTLIDPACIENTE_"+sGXsfl_15_fel_idx ;
      edtavCtlfotografia_Internalname = "CTLFOTOGRAFIA_"+sGXsfl_15_fel_idx ;
      edtavCtlnombresapellidos_Internalname = "CTLNOMBRESAPELLIDOS_"+sGXsfl_15_fel_idx ;
      edtavCtlfechanacimientoedad_Internalname = "CTLFECHANACIMIENTOEDAD_"+sGXsfl_15_fel_idx ;
      edtavCtldireccion_Internalname = "CTLDIRECCION_"+sGXsfl_15_fel_idx ;
   }

   public void sendrow_152( )
   {
      subsflControlProps_152( ) ;
      wb340( ) ;
      Grid2Row = GXWebRow.GetNew(context,Grid2Container) ;
      if ( subGrid2_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGrid2_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
         {
            subGrid2_Linesclass = subGrid2_Class+"Odd" ;
         }
      }
      else if ( subGrid2_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGrid2_Backstyle = (byte)(0) ;
         subGrid2_Backcolor = subGrid2_Allbackcolor ;
         if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
         {
            subGrid2_Linesclass = subGrid2_Class+"Uniform" ;
         }
      }
      else if ( subGrid2_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGrid2_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
         {
            subGrid2_Linesclass = subGrid2_Class+"Odd" ;
         }
         subGrid2_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGrid2_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGrid2_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_15_idx) % (2))) == 0 )
         {
            subGrid2_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
            {
               subGrid2_Linesclass = subGrid2_Class+"Even" ;
            }
         }
         else
         {
            subGrid2_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
            {
               subGrid2_Linesclass = subGrid2_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( Grid2Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGrid2_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_15_idx+"\">") ;
      }
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid2table_Internalname+"_"+sGXsfl_15_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlidpaciente_Internalname,"id Paciente","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlidpaciente_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV13GXV1)).getgxTv_SdtSDTDatosDelPaciente_Idpaciente(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlidpaciente_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV13GXV1)).getgxTv_SdtSDTDatosDelPaciente_Idpaciente()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV13GXV1)).getgxTv_SdtSDTDatosDelPaciente_Idpaciente()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlidpaciente_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlidpaciente_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","Center","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"","Fotografia","col-sm-3 ImagePerfilLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Static Bitmap Variable */
      ClassString = "ImagePerfil" ;
      StyleString = "" ;
      sImgUrl = httpContext.getResourceRelative(((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV13GXV1)).getgxTv_SdtSDTDatosDelPaciente_Fotografia()) ;
      Grid2Row.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavCtlfotografia_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(4),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableML","Center","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlnombresapellidos_Internalname,"Nombres Apellidos","col-sm-3 AttributeNAPacienteLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "AttributeNAPaciente" ;
      StyleString = "" ;
      ClassString = "AttributeNAPaciente" ;
      StyleString = "" ;
      Grid2Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlnombresapellidos_Internalname,((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV13GXV1)).getgxTv_SdtSDTDatosDelPaciente_Nombresapellidos(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCtlnombresapellidos_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(7),"row",StyleString,ClassString,"","","500",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableMT4","Center","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlfechanacimientoedad_Internalname,"Fecha Nacimiento Edad","col-sm-3 AttributeInfoPacienteLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "AttributeInfoPaciente" ;
      StyleString = "" ;
      ClassString = "AttributeInfoPaciente" ;
      StyleString = "" ;
      Grid2Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlfechanacimientoedad_Internalname,((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV13GXV1)).getgxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad(),"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(edtavCtlfechanacimientoedad_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",StyleString,ClassString,"","","2097152",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableMT4","Center","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtldireccion_Internalname,"Direccion","col-sm-3 AttributeInfoPacienteLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "AttributeInfoPaciente" ;
      StyleString = "" ;
      ClassString = "AttributeInfoPaciente" ;
      StyleString = "" ;
      Grid2Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtldireccion_Internalname,((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV13GXV1)).getgxTv_SdtSDTDatosDelPaciente_Direccion(),"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(edtavCtldireccion_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",StyleString,ClassString,"","","2097152",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes342( ) ;
      /* End of Columns property logic. */
      Grid2Container.AddRow(Grid2Row);
      nGXsfl_15_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_15_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
      /* End function sendrow_152 */
   }

   public void init_default_properties( )
   {
      edtavCtlidpaciente_Internalname = "CTLIDPACIENTE" ;
      edtavCtlfotografia_Internalname = "CTLFOTOGRAFIA" ;
      edtavCtlnombresapellidos_Internalname = "CTLNOMBRESAPELLIDOS" ;
      edtavCtlfechanacimientoedad_Internalname = "CTLFECHANACIMIENTOEDAD" ;
      edtavCtldireccion_Internalname = "CTLDIRECCION" ;
      divGrid2table_Internalname = "GRID2TABLE" ;
      bttMiperfil_Internalname = "MIPERFIL" ;
      bttDependientes_Internalname = "DEPENDIENTES" ;
      bttMiscitas_Internalname = "MISCITAS" ;
      bttComprobantes_Internalname = "COMPROBANTES" ;
      bttCambiarpassword_Internalname = "CAMBIARPASSWORD" ;
      bttCerrarsesion_Internalname = "CERRARSESION" ;
      divTable4_Internalname = "TABLE4" ;
      divTableborderhp_Internalname = "TABLEBORDERHP" ;
      divTable2_Internalname = "TABLE2" ;
      divTable3_Internalname = "TABLE3" ;
      divTable1_Internalname = "TABLE1" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid2_Internalname = "GRID2" ;
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
      edtavCtlidpaciente_Jsonclick = "" ;
      subGrid2_Class = "FreeStyleGrid" ;
      edtavCtldireccion_Enabled = -1 ;
      edtavCtlfechanacimientoedad_Enabled = -1 ;
      edtavCtlnombresapellidos_Enabled = -1 ;
      edtavCtlidpaciente_Enabled = -1 ;
      bttComprobantes_Visible = 1 ;
      subGrid2_Allowcollapsing = (byte)(0) ;
      edtavCtldireccion_Enabled = 0 ;
      edtavCtlfechanacimientoedad_Enabled = 0 ;
      edtavCtlnombresapellidos_Enabled = 0 ;
      edtavCtlidpaciente_Enabled = 0 ;
      subGrid2_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Home Paciente" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'AV5DatosPaciente',fld:'vDATOSPACIENTE',grid:15,pic:''},{av:'nRC_GXsfl_15',ctrl:'GRID2',prop:'GridRC',grid:15},{av:'AV9PantallaEdit',fld:'vPANTALLAEDIT',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV6PacienteFamiliarIdEdit',fld:'vPACIENTEFAMILIARIDEDIT',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("'MIPERFIL'","{handler:'e11341',iparms:[]");
      setEventMetadata("'MIPERFIL'",",oparms:[{ctrl:'COMPONENTFORM'}]}");
      setEventMetadata("'DEPENDIENTES'","{handler:'e12341',iparms:[]");
      setEventMetadata("'DEPENDIENTES'",",oparms:[{ctrl:'COMPONENTFORM'}]}");
      setEventMetadata("'MISCITAS'","{handler:'e13341',iparms:[]");
      setEventMetadata("'MISCITAS'",",oparms:[{ctrl:'COMPONENTFORM'}]}");
      setEventMetadata("'COMPROBANTES'","{handler:'e14341',iparms:[]");
      setEventMetadata("'COMPROBANTES'",",oparms:[{ctrl:'COMPONENTFORM'}]}");
      setEventMetadata("'CAMBIARPASSWORD'","{handler:'e15341',iparms:[]");
      setEventMetadata("'CAMBIARPASSWORD'",",oparms:[{ctrl:'COMPONENTFORM'}]}");
      setEventMetadata("'CERRARSESION'","{handler:'e16341',iparms:[]");
      setEventMetadata("'CERRARSESION'",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv6',iparms:[]");
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
      wcpOAV9PantallaEdit = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV5DatosPaciente = new GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente>(com.projectthani.SdtSDTDatosDelPaciente.class, "SDTDatosDelPaciente", "ProjectThani", remoteHandle);
      AV8Pantalla = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      Grid2Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid2_Header = "" ;
      Grid2Column = new com.genexus.webpanels.GXWebColumn();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttMiperfil_Jsonclick = "" ;
      bttDependientes_Jsonclick = "" ;
      bttMiscitas_Jsonclick = "" ;
      bttComprobantes_Jsonclick = "" ;
      bttCambiarpassword_Jsonclick = "" ;
      bttCerrarsesion_Jsonclick = "" ;
      WebComp_Componentform_Component = "" ;
      OldComponentform = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV10WebSession = httpContext.getWebSession();
      GXt_objcol_SdtSDTDatosDelPaciente1 = new GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente>(com.projectthani.SdtSDTDatosDelPaciente.class, "SDTDatosDelPaciente", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTDatosDelPaciente2 = new GXBaseCollection[1] ;
      Grid2Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid2_Linesclass = "" ;
      ROClassString = "" ;
      sImgUrl = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavCtlidpaciente_Enabled = 0 ;
      edtavCtlnombresapellidos_Enabled = 0 ;
      edtavCtlfechanacimientoedad_Enabled = 0 ;
      edtavCtldireccion_Enabled = 0 ;
      WebComp_Componentform = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subGrid2_Backcolorstyle ;
   private byte subGrid2_Allowselection ;
   private byte subGrid2_Allowhovering ;
   private byte subGrid2_Allowcollapsing ;
   private byte subGrid2_Collapsed ;
   private byte nDonePA ;
   private byte GRID2_nEOF ;
   private byte nGXWrapped ;
   private byte subGrid2_Backstyle ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV6PacienteFamiliarIdEdit ;
   private int nRC_GXsfl_15 ;
   private int nGXsfl_15_idx=1 ;
   private int AV6PacienteFamiliarIdEdit ;
   private int edtavCtlidpaciente_Enabled ;
   private int edtavCtlnombresapellidos_Enabled ;
   private int edtavCtlfechanacimientoedad_Enabled ;
   private int edtavCtldireccion_Enabled ;
   private int subGrid2_Selectedindex ;
   private int subGrid2_Selectioncolor ;
   private int subGrid2_Hoveringcolor ;
   private int AV13GXV1 ;
   private int bttComprobantes_Visible ;
   private int subGrid2_Islastpage ;
   private int nGXsfl_15_fel_idx=1 ;
   private int AV7PacienteId ;
   private int idxLst ;
   private int subGrid2_Backcolor ;
   private int subGrid2_Allbackcolor ;
   private long GRID2_nCurrentRecord ;
   private long GRID2_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_15_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTable1_Internalname ;
   private String divTable2_Internalname ;
   private String divTableborderhp_Internalname ;
   private String sStyleString ;
   private String subGrid2_Internalname ;
   private String subGrid2_Header ;
   private String divTable4_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttMiperfil_Internalname ;
   private String bttMiperfil_Jsonclick ;
   private String bttDependientes_Internalname ;
   private String bttDependientes_Jsonclick ;
   private String bttMiscitas_Internalname ;
   private String bttMiscitas_Jsonclick ;
   private String bttComprobantes_Internalname ;
   private String bttComprobantes_Jsonclick ;
   private String bttCambiarpassword_Internalname ;
   private String bttCambiarpassword_Jsonclick ;
   private String bttCerrarsesion_Internalname ;
   private String bttCerrarsesion_Jsonclick ;
   private String divTable3_Internalname ;
   private String WebComp_Componentform_Component ;
   private String OldComponentform ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavCtlidpaciente_Internalname ;
   private String edtavCtlnombresapellidos_Internalname ;
   private String edtavCtlfechanacimientoedad_Internalname ;
   private String edtavCtldireccion_Internalname ;
   private String sGXsfl_15_fel_idx="0001" ;
   private String edtavCtlfotografia_Internalname ;
   private String subGrid2_Class ;
   private String subGrid2_Linesclass ;
   private String divGrid2table_Internalname ;
   private String ROClassString ;
   private String edtavCtlidpaciente_Jsonclick ;
   private String sImgUrl ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_15_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean bDynCreated_Componentform ;
   private boolean gx_BV15 ;
   private boolean gx_refresh_fired ;
   private String wcpOAV9PantallaEdit ;
   private String AV9PantallaEdit ;
   private String AV8Pantalla ;
   private com.genexus.webpanels.GXWebGrid Grid2Container ;
   private com.genexus.webpanels.GXWebRow Grid2Row ;
   private com.genexus.webpanels.GXWebColumn Grid2Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Componentform ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente> AV5DatosPaciente ;
   private GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente> GXt_objcol_SdtSDTDatosDelPaciente1 ;
   private GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente> GXv_objcol_SdtSDTDatosDelPaciente2[] ;
}

