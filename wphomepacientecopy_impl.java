package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wphomepacientecopy_impl extends GXDataArea
{
   public wphomepacientecopy_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wphomepacientecopy_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wphomepacientecopy_impl.class ));
   }

   public wphomepacientecopy_impl( int remoteHandle ,
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
            nRC_GXsfl_12 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_12"))) ;
            nGXsfl_12_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_12_idx"))) ;
            sGXsfl_12_idx = httpContext.GetPar( "sGXsfl_12_idx") ;
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
            AV17PantallaEdit = httpContext.GetPar( "PantallaEdit") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid2_refresh( AV17PantallaEdit) ;
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
            AV17PantallaEdit = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17PantallaEdit", AV17PantallaEdit);
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPANTALLAEDIT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17PantallaEdit, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV14PacienteFamiliarIdEdit = (int)(GXutil.lval( httpContext.GetPar( "PacienteFamiliarIdEdit"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14PacienteFamiliarIdEdit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14PacienteFamiliarIdEdit), 8, 0));
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
      pa732( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start732( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110341017", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wphomepacientecopy", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17PantallaEdit)),GXutil.URLEncode(GXutil.ltrimstr(AV14PacienteFamiliarIdEdit,8,0))}, new String[] {"PantallaEdit","PacienteFamiliarIdEdit"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPANTALLAEDIT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17PantallaEdit, ""))));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_12", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_12, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPANTALLA", AV16Pantalla);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPANTALLAEDIT", AV17PantallaEdit);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPANTALLAEDIT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17PantallaEdit, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEFAMILIARIDEDIT", GXutil.ltrim( localUtil.ntoc( AV14PacienteFamiliarIdEdit, (byte)(8), (byte)(0), ",", "")));
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we732( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt732( ) ;
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
      return formatLink("com.projectthani.wphomepacientecopy", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17PantallaEdit)),GXutil.URLEncode(GXutil.ltrimstr(AV14PacienteFamiliarIdEdit,8,0))}, new String[] {"PantallaEdit","PacienteFamiliarIdEdit"})  ;
   }

   public String getPgmname( )
   {
      return "WPHomePacienteCopy" ;
   }

   public String getPgmdesc( )
   {
      return "WPHome Paciente Copy" ;
   }

   public void wb730( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 col-md-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "TableHomePaciente", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid2Container.SetIsFreestyle(true);
         Grid2Container.SetWrapped(nGXWrapped);
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"Grid2Container"+"DivS\" data-gxgridid=\"12\">") ;
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
            Grid2Column.AddObjectProperty("Value", lblTextblockiconperfil_Caption);
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
            Grid2Column.AddObjectProperty("Value", lblTextblockiconperfil_Caption);
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
      if ( wbEnd == 12 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_12 = (int)(nGXsfl_12_idx-1) ;
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV21GXV1 = nGXsfl_12_idx ;
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockiconperfil_Internalname, lblTextblockiconperfil_Caption, "", "", lblTextblockiconperfil_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-10", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmiperfil_Internalname, "Mi perfil", "", "", lblTextblockmiperfil_Jsonclick, "'"+""+"'"+",false,"+"'"+"e11731_client"+"'", "", "TextBlockMenuPaciente", 7, "", 1, 1, 0, (short)(0), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableMenuSeparadorP", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockicondep_Internalname, lblTextblockicondep_Caption, "", "", lblTextblockicondep_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-10 TextBlockMenuPacienteAtt", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockdependientes_Internalname, "Dependientes", "", "", lblTextblockdependientes_Jsonclick, "'"+""+"'"+",false,"+"'"+"e12731_client"+"'", "", "TextBlockMenuPaciente", 7, "", 1, 1, 0, (short)(0), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableMenuSeparadorP", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockiconcitas_Internalname, lblTextblockiconcitas_Caption, "", "", lblTextblockiconcitas_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-10", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmiscitas_Internalname, "Mis citas", "", "", lblTextblockmiscitas_Jsonclick, "'"+""+"'"+",false,"+"'"+"e13731_client"+"'", "", "TextBlockMenuPaciente", 7, "", 1, 1, 0, (short)(0), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableMenuSeparadorP", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockiconcompro_Internalname, lblTextblockiconcompro_Caption, "", "", lblTextblockiconcompro_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-10", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmiscomprobantes_Internalname, "Mis comprobantes", "", "", lblTextblockmiscomprobantes_Jsonclick, "'"+""+"'"+",false,"+"'"+"e14731_client"+"'", "", "TextBlockMenuPaciente", 7, "", 1, 1, 0, (short)(0), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableMenuSeparadorP", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockiconcambiarpass_Internalname, lblTextblockiconcambiarpass_Caption, "", "", lblTextblockiconcambiarpass_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-10", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcambiarpassword_Internalname, "Cambiar contraseña", "", "", lblTextblockcambiarpassword_Jsonclick, "'"+""+"'"+",false,"+"'"+"e15731_client"+"'", "", "TextBlockMenuPaciente", 7, "", 1, 1, 0, (short)(0), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockiconcerrarsess_Internalname, lblTextblockiconcerrarsess_Caption, "", "", lblTextblockiconcerrarsess_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-10", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcerarsesion_Internalname, "Cerrar sesión", "", "", lblTextblockcerarsesion_Jsonclick, "'"+""+"'"+",false,"+"'"+"e16731_client"+"'", "", "TextBlockMenuPaciente", 7, "", 1, 1, 0, (short)(0), "HLP_WPHomePacienteCopy.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-md-9", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "TableContentPaciente", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "W0085"+"", GXutil.rtrim( WebComp_Componentform_Component));
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0085"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Componentform_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldComponentform), GXutil.lower( WebComp_Componentform_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0085"+"");
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
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
            if ( Grid2Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV21GXV1 = nGXsfl_12_idx ;
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

   public void start732( )
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
         Form.getMeta().addItem("description", "WPHome Paciente Copy", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup730( ) ;
   }

   public void ws732( )
   {
      start732( ) ;
      evt732( ) ;
   }

   public void evt732( )
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
                           nGXsfl_12_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_122( ) ;
                           AV21GXV1 = nGXsfl_12_idx ;
                           if ( ( AV5DatosPaciente.size() >= AV21GXV1 ) && ( AV21GXV1 > 0 ) )
                           {
                              AV5DatosPaciente.currentItem( ((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV21GXV1)) );
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
                                 e17732 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e18732 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID2.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e19732 ();
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
                     if ( nCmpId == 85 )
                     {
                        OldComponentform = httpContext.cgiGet( "W0085") ;
                        if ( ( GXutil.len( OldComponentform) == 0 ) || ( GXutil.strcmp(OldComponentform, WebComp_Componentform_Component) != 0 ) )
                        {
                           WebComp_Componentform = WebUtils.getWebComponent(getClass(), "com.projectthani." + OldComponentform + "_impl", remoteHandle, context);
                           WebComp_Componentform_Component = OldComponentform ;
                        }
                        if ( GXutil.len( WebComp_Componentform_Component) != 0 )
                        {
                           WebComp_Componentform.componentprocess("W0085", "", sEvt);
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

   public void we732( )
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

   public void pa732( )
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
      subsflControlProps_122( ) ;
      while ( nGXsfl_12_idx <= nRC_GXsfl_12 )
      {
         sendrow_122( ) ;
         nGXsfl_12_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_12_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_12_idx+1) ;
         sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_122( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid2Container)) ;
      /* End function gxnrGrid2_newrow */
   }

   public void gxgrgrid2_refresh( String AV17PantallaEdit )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e18732 ();
      GRID2_nCurrentRecord = 0 ;
      rf732( ) ;
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
      rf732( ) ;
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
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlidpaciente_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlidpaciente_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtlnombresapellidos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnombresapellidos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnombresapellidos_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtlfechanacimientoedad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlfechanacimientoedad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlfechanacimientoedad_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldireccion_Enabled), 5, 0), !bGXsfl_12_Refreshing);
   }

   public void rf732( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid2Container.ClearRows();
      }
      wbStart = (short)(12) ;
      /* Execute user event: Refresh */
      e18732 ();
      nGXsfl_12_idx = 1 ;
      sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_122( ) ;
      bGXsfl_12_Refreshing = true ;
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
         subsflControlProps_122( ) ;
         e19732 ();
         wbEnd = (short)(12) ;
         wb730( ) ;
      }
      bGXsfl_12_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes732( )
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
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlidpaciente_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlidpaciente_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtlnombresapellidos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnombresapellidos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnombresapellidos_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtlfechanacimientoedad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlfechanacimientoedad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlfechanacimientoedad_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      edtavCtldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldireccion_Enabled), 5, 0), !bGXsfl_12_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup730( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e17732 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Datospaciente"), AV5DatosPaciente);
         /* Read saved values. */
         nRC_GXsfl_12 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_12"), ",", ".")) ;
         AV14PacienteFamiliarIdEdit = (int)(localUtil.ctol( httpContext.cgiGet( "vPACIENTEFAMILIARIDEDIT"), ",", ".")) ;
         AV16Pantalla = httpContext.cgiGet( "vPANTALLA") ;
         nRC_GXsfl_12 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_12"), ",", ".")) ;
         nGXsfl_12_fel_idx = 0 ;
         while ( nGXsfl_12_fel_idx < nRC_GXsfl_12 )
         {
            nGXsfl_12_fel_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_12_fel_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_12_fel_idx+1) ;
            sGXsfl_12_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_122( ) ;
            AV21GXV1 = nGXsfl_12_fel_idx ;
            if ( ( AV5DatosPaciente.size() >= AV21GXV1 ) && ( AV21GXV1 > 0 ) )
            {
               AV5DatosPaciente.currentItem( ((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV21GXV1)) );
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
      e17732 ();
      if (returnInSub) return;
   }

   public void e17732( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( (GXutil.strcmp("", AV18WebSession.getValue("WSPacienteId"))==0) )
      {
         callWebObject(formatLink("com.projectthani.wploginpaciente", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV17PantallaEdit, "EditarPacienteFamiliar") == 0 ) && ( AV14PacienteFamiliarIdEdit > 0 ) )
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
            WebComp_Componentform.componentprepare(new Object[] {"W0085","",Integer.valueOf(AV14PacienteFamiliarIdEdit)});
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
            WebComp_Componentform.componentprepare(new Object[] {"W0085",""});
            WebComp_Componentform.componentbind(new Object[] {});
         }
      }
      if ( GXutil.strcmp(AV17PantallaEdit, "MisCitas") == 0 )
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
            WebComp_Componentform.componentprepare(new Object[] {"W0085",""});
            WebComp_Componentform.componentbind(new Object[] {});
         }
      }
      AV15PacienteId = (int)(GXutil.lval( AV18WebSession.getValue("WSPacienteId"))) ;
      GXt_objcol_SdtSDTDatosDelPaciente1 = AV5DatosPaciente ;
      GXv_objcol_SdtSDTDatosDelPaciente2[0] = GXt_objcol_SdtSDTDatosDelPaciente1 ;
      new com.projectthani.prcinfodelpaciente(remoteHandle, context).execute( AV15PacienteId, GXv_objcol_SdtSDTDatosDelPaciente2) ;
      GXt_objcol_SdtSDTDatosDelPaciente1 = GXv_objcol_SdtSDTDatosDelPaciente2[0] ;
      AV5DatosPaciente = GXt_objcol_SdtSDTDatosDelPaciente1 ;
      gx_BV12 = true ;
      AV7HtmlFN = "<i class=\"fas fa-birthday-cake\"></i>" ;
      lblTbfechanacimiento_Caption = AV7HtmlFN ;
      httpContext.ajax_rsp_assign_prop("", false, lblTbfechanacimiento_Internalname, "Caption", lblTbfechanacimiento_Caption, !bGXsfl_12_Refreshing);
      AV6HtmlDireccion = "<i class=\"fas fa-map-marker-alt\"></i>" ;
      lblTbdireccion_Caption = AV6HtmlDireccion ;
      httpContext.ajax_rsp_assign_prop("", false, lblTbdireccion_Internalname, "Caption", lblTbdireccion_Caption, !bGXsfl_12_Refreshing);
      AV11IconMiPerfil = "<a><i class=\"fas fa-columns\" style=\"margin-left:28px;padding-top:2px;font-size:14px\"></i></a>" ;
      lblTextblockiconperfil_Caption = AV11IconMiPerfil ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockiconperfil_Internalname, "Caption", lblTextblockiconperfil_Caption, true);
      AV10IconDependientes += "<i class=\"fas fa-users\" style=\"margin-left:28px;padding-top:2px;font-size:14px\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IconDependientes", AV10IconDependientes);
      lblTextblockicondep_Caption = AV10IconDependientes ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockicondep_Internalname, "Caption", lblTextblockicondep_Caption, true);
      AV12IconMisCitas += "<i class=\"fas fa-columns\" style=\"margin-left:28px;padding-top:2px;font-size:14px\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IconMisCitas", AV12IconMisCitas);
      lblTextblockiconcitas_Caption = AV12IconMisCitas ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockiconcitas_Internalname, "Caption", lblTextblockiconcitas_Caption, true);
      AV13IconMisComprobantes += " <i class=\"fas fa-columns\" style=\"margin-left:28px;padding-top:2px;font-size:14px\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IconMisComprobantes", AV13IconMisComprobantes);
      lblTextblockiconcompro_Caption = AV13IconMisComprobantes ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockiconcompro_Internalname, "Caption", lblTextblockiconcompro_Caption, true);
      AV8IconCambiarPassword += "<i class=\"fas fa-lock\" style=\"margin-left:28px;padding-top:2px;font-size:14px\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8IconCambiarPassword", AV8IconCambiarPassword);
      lblTextblockiconcambiarpass_Caption = AV8IconCambiarPassword ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockiconcambiarpass_Internalname, "Caption", lblTextblockiconcambiarpass_Caption, true);
      AV9IconCerrarSesion += "<i class=\"fas fa-sign-out-alt\" style=\"margin-left:28px;padding-top:2px;font-size:14px\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IconCerrarSesion", AV9IconCerrarSesion);
      lblTextblockiconcerrarsess_Caption = AV9IconCerrarSesion ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockiconcerrarsess_Internalname, "Caption", lblTextblockiconcerrarsess_Caption, true);
   }

   public void e18732( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      AV14PacienteFamiliarIdEdit = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14PacienteFamiliarIdEdit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14PacienteFamiliarIdEdit), 8, 0));
      /*  Sending Event outputs  */
   }

   private void e19732( )
   {
      /* Grid2_Load Routine */
      returnInSub = false ;
      AV21GXV1 = 1 ;
      while ( AV21GXV1 <= AV5DatosPaciente.size() )
      {
         AV5DatosPaciente.currentItem( ((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV21GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(12) ;
         }
         sendrow_122( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_12_Refreshing )
         {
            httpContext.doAjaxLoad(12, Grid2Row);
         }
         AV21GXV1 = (int)(AV21GXV1+1) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV17PantallaEdit = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17PantallaEdit", AV17PantallaEdit);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPANTALLAEDIT", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17PantallaEdit, ""))));
      AV14PacienteFamiliarIdEdit = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14PacienteFamiliarIdEdit", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14PacienteFamiliarIdEdit), 8, 0));
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
      pa732( ) ;
      ws732( ) ;
      we732( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110341056", true, true);
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
      httpContext.AddJavascriptSource("wphomepacientecopy.js", "?20225110341056", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_122( )
   {
      edtavCtlidpaciente_Internalname = "CTLIDPACIENTE_"+sGXsfl_12_idx ;
      edtavCtlfotografia_Internalname = "CTLFOTOGRAFIA_"+sGXsfl_12_idx ;
      edtavCtlnombresapellidos_Internalname = "CTLNOMBRESAPELLIDOS_"+sGXsfl_12_idx ;
      lblTbfechanacimiento_Internalname = "TBFECHANACIMIENTO_"+sGXsfl_12_idx ;
      edtavCtlfechanacimientoedad_Internalname = "CTLFECHANACIMIENTOEDAD_"+sGXsfl_12_idx ;
      lblTbdireccion_Internalname = "TBDIRECCION_"+sGXsfl_12_idx ;
      edtavCtldireccion_Internalname = "CTLDIRECCION_"+sGXsfl_12_idx ;
   }

   public void subsflControlProps_fel_122( )
   {
      edtavCtlidpaciente_Internalname = "CTLIDPACIENTE_"+sGXsfl_12_fel_idx ;
      edtavCtlfotografia_Internalname = "CTLFOTOGRAFIA_"+sGXsfl_12_fel_idx ;
      edtavCtlnombresapellidos_Internalname = "CTLNOMBRESAPELLIDOS_"+sGXsfl_12_fel_idx ;
      lblTbfechanacimiento_Internalname = "TBFECHANACIMIENTO_"+sGXsfl_12_fel_idx ;
      edtavCtlfechanacimientoedad_Internalname = "CTLFECHANACIMIENTOEDAD_"+sGXsfl_12_fel_idx ;
      lblTbdireccion_Internalname = "TBDIRECCION_"+sGXsfl_12_fel_idx ;
      edtavCtldireccion_Internalname = "CTLDIRECCION_"+sGXsfl_12_fel_idx ;
   }

   public void sendrow_122( )
   {
      subsflControlProps_122( ) ;
      wb730( ) ;
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
         if ( ((int)((nGXsfl_12_idx) % (2))) == 0 )
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
         httpContext.writeText( "<tr"+" class=\""+subGrid2_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_12_idx+"\">") ;
      }
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid2table_Internalname+"_"+sGXsfl_12_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
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
      Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlidpaciente_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV21GXV1)).getgxTv_SdtSDTDatosDelPaciente_Idpaciente(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlidpaciente_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV21GXV1)).getgxTv_SdtSDTDatosDelPaciente_Idpaciente()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV21GXV1)).getgxTv_SdtSDTDatosDelPaciente_Idpaciente()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlidpaciente_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlidpaciente_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(12),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
      sImgUrl = httpContext.getResourceRelative(((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV21GXV1)).getgxTv_SdtSDTDatosDelPaciente_Fotografia()) ;
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
      Grid2Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlnombresapellidos_Internalname,((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV21GXV1)).getgxTv_SdtSDTDatosDelPaciente_Nombresapellidos(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCtlnombresapellidos_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(7),"row",StyleString,ClassString,"","","500",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-2 TextBlockPerfilIcon TableMT4","left","top","","","div"});
      /* Text block */
      Grid2Row.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTbfechanacimiento_Internalname,lblTbfechanacimiento_Caption,"","",lblTbfechanacimiento_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-10 TableMT4","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlfechanacimientoedad_Internalname,"Fecha Nacimiento Edad","col-sm-3 AttributeInfoPacienteLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "AttributeInfoPaciente" ;
      StyleString = "" ;
      ClassString = "AttributeInfoPaciente" ;
      StyleString = "" ;
      Grid2Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlfechanacimientoedad_Internalname,((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV21GXV1)).getgxTv_SdtSDTDatosDelPaciente_Fechanacimientoedad(),"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(edtavCtlfechanacimientoedad_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",StyleString,ClassString,"","","2097152",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-2 TextBlockPerfilIcon TableMT4","left","top","","","div"});
      /* Text block */
      Grid2Row.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTbdireccion_Internalname,lblTbdireccion_Caption,"","",lblTbdireccion_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-10 TableMT4","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtldireccion_Internalname,"Direccion","col-sm-3 AttributeInfoPacienteLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "AttributeInfoPaciente" ;
      StyleString = "" ;
      ClassString = "AttributeInfoPaciente" ;
      StyleString = "" ;
      Grid2Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtldireccion_Internalname,((com.projectthani.SdtSDTDatosDelPaciente)AV5DatosPaciente.elementAt(-1+AV21GXV1)).getgxTv_SdtSDTDatosDelPaciente_Direccion(),"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(edtavCtldireccion_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",StyleString,ClassString,"","","2097152",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes732( ) ;
      /* End of Columns property logic. */
      Grid2Container.AddRow(Grid2Row);
      nGXsfl_12_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_12_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_12_idx+1) ;
      sGXsfl_12_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_12_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_122( ) ;
      /* End function sendrow_122 */
   }

   public void init_default_properties( )
   {
      edtavCtlidpaciente_Internalname = "CTLIDPACIENTE" ;
      edtavCtlfotografia_Internalname = "CTLFOTOGRAFIA" ;
      edtavCtlnombresapellidos_Internalname = "CTLNOMBRESAPELLIDOS" ;
      lblTbfechanacimiento_Internalname = "TBFECHANACIMIENTO" ;
      edtavCtlfechanacimientoedad_Internalname = "CTLFECHANACIMIENTOEDAD" ;
      lblTbdireccion_Internalname = "TBDIRECCION" ;
      edtavCtldireccion_Internalname = "CTLDIRECCION" ;
      divGrid2table_Internalname = "GRID2TABLE" ;
      lblTextblockiconperfil_Internalname = "TEXTBLOCKICONPERFIL" ;
      lblTextblockmiperfil_Internalname = "TEXTBLOCKMIPERFIL" ;
      lblTextblockicondep_Internalname = "TEXTBLOCKICONDEP" ;
      lblTextblockdependientes_Internalname = "TEXTBLOCKDEPENDIENTES" ;
      lblTextblockiconcitas_Internalname = "TEXTBLOCKICONCITAS" ;
      lblTextblockmiscitas_Internalname = "TEXTBLOCKMISCITAS" ;
      lblTextblockiconcompro_Internalname = "TEXTBLOCKICONCOMPRO" ;
      lblTextblockmiscomprobantes_Internalname = "TEXTBLOCKMISCOMPROBANTES" ;
      lblTextblockiconcambiarpass_Internalname = "TEXTBLOCKICONCAMBIARPASS" ;
      lblTextblockcambiarpassword_Internalname = "TEXTBLOCKCAMBIARPASSWORD" ;
      lblTextblockiconcerrarsess_Internalname = "TEXTBLOCKICONCERRARSESS" ;
      lblTextblockcerarsesion_Internalname = "TEXTBLOCKCERARSESION" ;
      divTable4_Internalname = "TABLE4" ;
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
      lblTbdireccion_Caption = "Text Block" ;
      lblTbfechanacimiento_Caption = "Text Block" ;
      edtavCtldireccion_Enabled = -1 ;
      edtavCtlfechanacimientoedad_Enabled = -1 ;
      edtavCtlnombresapellidos_Enabled = -1 ;
      edtavCtlidpaciente_Enabled = -1 ;
      lblTextblockiconcerrarsess_Caption = "Text Block" ;
      lblTextblockiconcambiarpass_Caption = "Text Block" ;
      lblTextblockiconcompro_Caption = "Text Block" ;
      lblTextblockiconcitas_Caption = "Text Block" ;
      lblTextblockicondep_Caption = "Text Block" ;
      lblTextblockiconperfil_Caption = "Text Block" ;
      subGrid2_Allowcollapsing = (byte)(0) ;
      edtavCtldireccion_Enabled = 0 ;
      edtavCtlfechanacimientoedad_Enabled = 0 ;
      lblTextblockiconperfil_Caption = "Text Block" ;
      edtavCtlnombresapellidos_Enabled = 0 ;
      edtavCtlidpaciente_Enabled = 0 ;
      subGrid2_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "WPHome Paciente Copy" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'AV5DatosPaciente',fld:'vDATOSPACIENTE',grid:12,pic:''},{av:'nRC_GXsfl_12',ctrl:'GRID2',prop:'GridRC',grid:12},{av:'AV17PantallaEdit',fld:'vPANTALLAEDIT',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV14PacienteFamiliarIdEdit',fld:'vPACIENTEFAMILIARIDEDIT',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("'MIPERFIL'","{handler:'e11731',iparms:[]");
      setEventMetadata("'MIPERFIL'",",oparms:[{ctrl:'COMPONENTFORM'}]}");
      setEventMetadata("'DEPENDIENTES'","{handler:'e12731',iparms:[]");
      setEventMetadata("'DEPENDIENTES'",",oparms:[{ctrl:'COMPONENTFORM'}]}");
      setEventMetadata("'MISCITAS'","{handler:'e13731',iparms:[]");
      setEventMetadata("'MISCITAS'",",oparms:[{ctrl:'COMPONENTFORM'}]}");
      setEventMetadata("'COMPROBANTES'","{handler:'e14731',iparms:[]");
      setEventMetadata("'COMPROBANTES'",",oparms:[{ctrl:'COMPONENTFORM'}]}");
      setEventMetadata("'CAMBIARPASSWORD'","{handler:'e15731',iparms:[]");
      setEventMetadata("'CAMBIARPASSWORD'",",oparms:[{ctrl:'COMPONENTFORM'}]}");
      setEventMetadata("'CERRARSESION'","{handler:'e16731',iparms:[]");
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
      wcpOAV17PantallaEdit = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV5DatosPaciente = new GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente>(com.projectthani.SdtSDTDatosDelPaciente.class, "SDTDatosDelPaciente", "ProjectThani", remoteHandle);
      AV16Pantalla = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      Grid2Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid2_Header = "" ;
      Grid2Column = new com.genexus.webpanels.GXWebColumn();
      lblTextblockiconperfil_Jsonclick = "" ;
      lblTextblockmiperfil_Jsonclick = "" ;
      lblTextblockicondep_Jsonclick = "" ;
      lblTextblockdependientes_Jsonclick = "" ;
      lblTextblockiconcitas_Jsonclick = "" ;
      lblTextblockmiscitas_Jsonclick = "" ;
      lblTextblockiconcompro_Jsonclick = "" ;
      lblTextblockmiscomprobantes_Jsonclick = "" ;
      lblTextblockiconcambiarpass_Jsonclick = "" ;
      lblTextblockcambiarpassword_Jsonclick = "" ;
      lblTextblockiconcerrarsess_Jsonclick = "" ;
      lblTextblockcerarsesion_Jsonclick = "" ;
      WebComp_Componentform_Component = "" ;
      OldComponentform = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV18WebSession = httpContext.getWebSession();
      GXt_objcol_SdtSDTDatosDelPaciente1 = new GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente>(com.projectthani.SdtSDTDatosDelPaciente.class, "SDTDatosDelPaciente", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTDatosDelPaciente2 = new GXBaseCollection[1] ;
      AV7HtmlFN = "" ;
      AV6HtmlDireccion = "" ;
      AV11IconMiPerfil = "" ;
      AV10IconDependientes = "" ;
      AV12IconMisCitas = "" ;
      AV13IconMisComprobantes = "" ;
      AV8IconCambiarPassword = "" ;
      AV9IconCerrarSesion = "" ;
      Grid2Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid2_Linesclass = "" ;
      ROClassString = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      lblTbfechanacimiento_Jsonclick = "" ;
      lblTbdireccion_Jsonclick = "" ;
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
   private int wcpOAV14PacienteFamiliarIdEdit ;
   private int nRC_GXsfl_12 ;
   private int nGXsfl_12_idx=1 ;
   private int AV14PacienteFamiliarIdEdit ;
   private int edtavCtlidpaciente_Enabled ;
   private int edtavCtlnombresapellidos_Enabled ;
   private int edtavCtlfechanacimientoedad_Enabled ;
   private int edtavCtldireccion_Enabled ;
   private int subGrid2_Selectedindex ;
   private int subGrid2_Selectioncolor ;
   private int subGrid2_Hoveringcolor ;
   private int AV21GXV1 ;
   private int subGrid2_Islastpage ;
   private int nGXsfl_12_fel_idx=1 ;
   private int AV15PacienteId ;
   private int idxLst ;
   private int subGrid2_Backcolor ;
   private int subGrid2_Allbackcolor ;
   private long GRID2_nCurrentRecord ;
   private long GRID2_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_12_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTable1_Internalname ;
   private String divTable2_Internalname ;
   private String sStyleString ;
   private String subGrid2_Internalname ;
   private String subGrid2_Header ;
   private String lblTextblockiconperfil_Caption ;
   private String divTable4_Internalname ;
   private String lblTextblockiconperfil_Internalname ;
   private String lblTextblockiconperfil_Jsonclick ;
   private String lblTextblockmiperfil_Internalname ;
   private String lblTextblockmiperfil_Jsonclick ;
   private String lblTextblockicondep_Internalname ;
   private String lblTextblockicondep_Caption ;
   private String lblTextblockicondep_Jsonclick ;
   private String lblTextblockdependientes_Internalname ;
   private String lblTextblockdependientes_Jsonclick ;
   private String lblTextblockiconcitas_Internalname ;
   private String lblTextblockiconcitas_Caption ;
   private String lblTextblockiconcitas_Jsonclick ;
   private String lblTextblockmiscitas_Internalname ;
   private String lblTextblockmiscitas_Jsonclick ;
   private String lblTextblockiconcompro_Internalname ;
   private String lblTextblockiconcompro_Caption ;
   private String lblTextblockiconcompro_Jsonclick ;
   private String lblTextblockmiscomprobantes_Internalname ;
   private String lblTextblockmiscomprobantes_Jsonclick ;
   private String lblTextblockiconcambiarpass_Internalname ;
   private String lblTextblockiconcambiarpass_Caption ;
   private String lblTextblockiconcambiarpass_Jsonclick ;
   private String lblTextblockcambiarpassword_Internalname ;
   private String lblTextblockcambiarpassword_Jsonclick ;
   private String lblTextblockiconcerrarsess_Internalname ;
   private String lblTextblockiconcerrarsess_Caption ;
   private String lblTextblockiconcerrarsess_Jsonclick ;
   private String lblTextblockcerarsesion_Internalname ;
   private String lblTextblockcerarsesion_Jsonclick ;
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
   private String sGXsfl_12_fel_idx="0001" ;
   private String lblTbfechanacimiento_Caption ;
   private String lblTbfechanacimiento_Internalname ;
   private String lblTbdireccion_Caption ;
   private String lblTbdireccion_Internalname ;
   private String edtavCtlfotografia_Internalname ;
   private String subGrid2_Class ;
   private String subGrid2_Linesclass ;
   private String divGrid2table_Internalname ;
   private String ROClassString ;
   private String edtavCtlidpaciente_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String lblTbfechanacimiento_Jsonclick ;
   private String lblTbdireccion_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_12_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean bDynCreated_Componentform ;
   private boolean gx_BV12 ;
   private boolean gx_refresh_fired ;
   private String AV7HtmlFN ;
   private String AV6HtmlDireccion ;
   private String AV11IconMiPerfil ;
   private String AV10IconDependientes ;
   private String AV12IconMisCitas ;
   private String AV13IconMisComprobantes ;
   private String AV8IconCambiarPassword ;
   private String AV9IconCerrarSesion ;
   private String wcpOAV17PantallaEdit ;
   private String AV17PantallaEdit ;
   private String AV16Pantalla ;
   private com.genexus.webpanels.GXWebGrid Grid2Container ;
   private com.genexus.webpanels.GXWebRow Grid2Row ;
   private com.genexus.webpanels.GXWebColumn Grid2Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Componentform ;
   private com.genexus.webpanels.WebSession AV18WebSession ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente> AV5DatosPaciente ;
   private GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente> GXt_objcol_SdtSDTDatosDelPaciente1 ;
   private GXBaseCollection<com.projectthani.SdtSDTDatosDelPaciente> GXv_objcol_SdtSDTDatosDelPaciente2[] ;
}

