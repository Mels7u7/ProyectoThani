package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpmiperfilprofesional_impl extends GXDataArea
{
   public wpmiperfilprofesional_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpmiperfilprofesional_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpmiperfilprofesional_impl.class ));
   }

   public wpmiperfilprofesional_impl( int remoteHandle ,
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
      cmbavProfesionaltipodocumento = new HTMLChoice();
      cmbavProfesionalsexo = new HTMLChoice();
      cmbavProfesionaldia = new HTMLChoice();
      cmbavProfesionalmes = new HTMLChoice();
      cmbavProfesionalanio = new HTMLChoice();
      dynavPaisid = new HTMLChoice();
      cmbavProfesionaltiempocita = new HTMLChoice();
      cmbavProfesionaldepartamento = new HTMLChoice();
      dynavProfesionalprovincia = new HTMLChoice();
      dynavProfesionaldistrito = new HTMLChoice();
      dynavCtlespecialidadid = new HTMLChoice();
      cmbavCtlsedetipoconsulta = new HTMLChoice();
      chkavProfesionalterminoscondiciones = UIFactory.getCheckbox(this);
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPAISID") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvpaisid6U2( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPROFESIONALPROVINCIA") == 0 )
         {
            AV45ProfesionalDepartamento = httpContext.GetPar( "ProfesionalDepartamento") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45ProfesionalDepartamento", AV45ProfesionalDepartamento);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvprofesionalprovincia6U2( AV45ProfesionalDepartamento) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPROFESIONALDISTRITO") == 0 )
         {
            AV45ProfesionalDepartamento = httpContext.GetPar( "ProfesionalDepartamento") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45ProfesionalDepartamento", AV45ProfesionalDepartamento);
            AV63ProfesionalProvincia = httpContext.GetPar( "ProfesionalProvincia") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63ProfesionalProvincia", AV63ProfesionalProvincia);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvprofesionaldistrito6U2( AV45ProfesionalDepartamento, AV63ProfesionalProvincia) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CTLESPECIALIDADID") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvctlespecialidadid6U2( ) ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridespecialidadsede") == 0 )
         {
            nRC_GXsfl_167 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_167"))) ;
            nGXsfl_167_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_167_idx"))) ;
            sGXsfl_167_idx = httpContext.GetPar( "sGXsfl_167_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridespecialidadsede_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridespecialidadsede") == 0 )
         {
            dynavPaisid.fromJSonString( httpContext.GetNextPar( ));
            AV34PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            AV66ProfesionalTerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "ProfesionalTerminosCondiciones")) ;
            AV36Pattern = httpContext.GetPar( "Pattern") ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridespecialidadsede_refresh( AV34PaisId, AV66ProfesionalTerminosCondiciones, AV36Pattern, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autoupload", GXutil.booltostr( Fileuploadimagen_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadimagen_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadimagen_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autodisableaddingfiles", GXutil.booltostr( Fileuploadimagen_Autodisableaddingfiles));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Acceptedfiletypes", GXutil.rtrim( Fileuploadimagen_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabpageregistroprofesional_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Class", GXutil.rtrim( Tabpageregistroprofesional_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Historymanagement", GXutil.booltostr( Tabpageregistroprofesional_Historymanagement));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grideducacion") == 0 )
         {
            nRC_GXsfl_195 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_195"))) ;
            nGXsfl_195_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_195_idx"))) ;
            sGXsfl_195_idx = httpContext.GetPar( "sGXsfl_195_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgrideducacion_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grideducacion") == 0 )
         {
            dynavPaisid.fromJSonString( httpContext.GetNextPar( ));
            AV34PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            AV66ProfesionalTerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "ProfesionalTerminosCondiciones")) ;
            AV36Pattern = httpContext.GetPar( "Pattern") ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrideducacion_refresh( AV34PaisId, AV66ProfesionalTerminosCondiciones, AV36Pattern, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autoupload", GXutil.booltostr( Fileuploadimagen_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadimagen_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadimagen_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autodisableaddingfiles", GXutil.booltostr( Fileuploadimagen_Autodisableaddingfiles));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Acceptedfiletypes", GXutil.rtrim( Fileuploadimagen_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabpageregistroprofesional_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Class", GXutil.rtrim( Tabpageregistroprofesional_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Historymanagement", GXutil.booltostr( Tabpageregistroprofesional_Historymanagement));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridexperiencialaboral") == 0 )
         {
            nRC_GXsfl_235 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_235"))) ;
            nGXsfl_235_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_235_idx"))) ;
            sGXsfl_235_idx = httpContext.GetPar( "sGXsfl_235_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridexperiencialaboral_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridexperiencialaboral") == 0 )
         {
            dynavPaisid.fromJSonString( httpContext.GetNextPar( ));
            AV34PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            AV66ProfesionalTerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "ProfesionalTerminosCondiciones")) ;
            AV36Pattern = httpContext.GetPar( "Pattern") ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridexperiencialaboral_refresh( AV34PaisId, AV66ProfesionalTerminosCondiciones, AV36Pattern, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autoupload", GXutil.booltostr( Fileuploadimagen_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadimagen_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadimagen_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autodisableaddingfiles", GXutil.booltostr( Fileuploadimagen_Autodisableaddingfiles));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Acceptedfiletypes", GXutil.rtrim( Fileuploadimagen_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabpageregistroprofesional_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Class", GXutil.rtrim( Tabpageregistroprofesional_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Historymanagement", GXutil.booltostr( Tabpageregistroprofesional_Historymanagement));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridpremios") == 0 )
         {
            nRC_GXsfl_266 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_266"))) ;
            nGXsfl_266_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_266_idx"))) ;
            sGXsfl_266_idx = httpContext.GetPar( "sGXsfl_266_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridpremios_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridpremios") == 0 )
         {
            dynavPaisid.fromJSonString( httpContext.GetNextPar( ));
            AV34PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            AV66ProfesionalTerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "ProfesionalTerminosCondiciones")) ;
            AV36Pattern = httpContext.GetPar( "Pattern") ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridpremios_refresh( AV34PaisId, AV66ProfesionalTerminosCondiciones, AV36Pattern, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autoupload", GXutil.booltostr( Fileuploadimagen_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadimagen_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadimagen_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autodisableaddingfiles", GXutil.booltostr( Fileuploadimagen_Autodisableaddingfiles));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Acceptedfiletypes", GXutil.rtrim( Fileuploadimagen_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabpageregistroprofesional_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Class", GXutil.rtrim( Tabpageregistroprofesional_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Historymanagement", GXutil.booltostr( Tabpageregistroprofesional_Historymanagement));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridservicios") == 0 )
         {
            nRC_GXsfl_299 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_299"))) ;
            nGXsfl_299_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_299_idx"))) ;
            sGXsfl_299_idx = httpContext.GetPar( "sGXsfl_299_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridservicios_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridservicios") == 0 )
         {
            dynavPaisid.fromJSonString( httpContext.GetNextPar( ));
            AV34PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            AV66ProfesionalTerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "ProfesionalTerminosCondiciones")) ;
            AV36Pattern = httpContext.GetPar( "Pattern") ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridservicios_refresh( AV34PaisId, AV66ProfesionalTerminosCondiciones, AV36Pattern, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autoupload", GXutil.booltostr( Fileuploadimagen_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadimagen_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadimagen_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autodisableaddingfiles", GXutil.booltostr( Fileuploadimagen_Autodisableaddingfiles));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Acceptedfiletypes", GXutil.rtrim( Fileuploadimagen_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabpageregistroprofesional_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Class", GXutil.rtrim( Tabpageregistroprofesional_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Historymanagement", GXutil.booltostr( Tabpageregistroprofesional_Historymanagement));
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
         MasterPageObj= createMasterPage(remoteHandle, "com.projectthani.wwpbaseobjects.workwithplusmasterpage");
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
      pa6U2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start6U2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110341244", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpmiperfilprofesional", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPATTERN", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV36Pattern, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Educacionlist", AV12EducacionList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Educacionlist", AV12EducacionList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Experiencialaborallist", AV18ExperienciaLaboralList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Experiencialaborallist", AV18ExperienciaLaboralList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Premioslist", AV38PremiosList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Premioslist", AV38PremiosList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Servicioslist", AV76ServiciosList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Servicioslist", AV76ServiciosList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Especialidadlist", AV15EspecialidadList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Especialidadlist", AV15EspecialidadList);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_167", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_167, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_195", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_195, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_235", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_235, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_266", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_266, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_299", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_299, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vUPLOADEDFILES", AV82UploadedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vUPLOADEDFILES", AV82UploadedFiles);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFAILEDFILES", AV19FailedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFAILEDFILES", AV19FailedFiles);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPATTERN", AV36Pattern);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPATTERN", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV36Pattern, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMENSAJE", AV25Mensaje);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMENSAJE", AV25Mensaje);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSER", AV6SecUser);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSER", AV6SecUser);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSERROLE", AV7SecUserRole);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSERROLE", AV7SecUserRole);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECROLENAME", A13SecRoleName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECROLEID", GXutil.ltrim( localUtil.ntoc( A4SecRoleId, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPROFESIONAL", AV5Profesional);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPROFESIONAL", AV5Profesional);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALFECHANACIMIENTO", localUtil.dtoc( AV52ProfesionalFechaNacimiento, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vUBIGEOCODE", GXutil.rtrim( AV81UbigeoCode));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEDUCACIONLIST", AV12EducacionList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEDUCACIONLIST", AV12EducacionList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEXPERIENCIALABORALLIST", AV18ExperienciaLaboralList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEXPERIENCIALABORALLIST", AV18ExperienciaLaboralList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPREMIOSLIST", AV38PremiosList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPREMIOSLIST", AV38PremiosList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSERVICIOSLIST", AV76ServiciosList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSERVICIOSLIST", AV76ServiciosList);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vESPECIALIDADLIST", AV15EspecialidadList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vESPECIALIDADLIST", AV15EspecialidadList);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROFESIONALID", GXutil.ltrim( localUtil.ntoc( A40000ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECUSERID", GXutil.ltrim( localUtil.ntoc( A40001SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autoupload", GXutil.booltostr( Fileuploadimagen_Autoupload));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadimagen_Enableuploadedfilecanceling));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadimagen_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Autodisableaddingfiles", GXutil.booltostr( Fileuploadimagen_Autodisableaddingfiles));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADIMAGEN_Acceptedfiletypes", GXutil.rtrim( Fileuploadimagen_Acceptedfiletypes));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabpageregistroprofesional_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Class", GXutil.rtrim( Tabpageregistroprofesional_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABPAGEREGISTROPROFESIONAL_Historymanagement", GXutil.booltostr( Tabpageregistroprofesional_Historymanagement));
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
         we6U2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt6U2( ) ;
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
      return formatLink("com.projectthani.wpmiperfilprofesional", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WPMiPerfilProfesional" ;
   }

   public String getPgmdesc( )
   {
      return "Mi Perfil" ;
   }

   public void wb6U0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "FormFondoRegProfesional", "left", "top", "", "", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "TableMainRP", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable4_Internalname, 1, 0, "px", 0, "px", "TableMainRegPerTamano", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Static images/pictures */
         ClassString = "Image" ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "62fabb4b-713d-4bd3-9f52-cde8b0a8f851", "", context.getHttpContext().getTheme( )) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgImage2_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockinfosolicitadaprof_Internalname, "A continuación, por favor ingrese la información solicitada.", "", "", lblTextblockinfosolicitadaprof_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup5_Internalname, "INFORMACIÓN GENERAL", 1, 0, "px", 0, "px", "GroupRegistroMedico", "", "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup5table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable5_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavProfesionaltipodocumento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavProfesionaltipodocumento.getInternalname(), "Tipo Documento", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavProfesionaltipodocumento, cmbavProfesionaltipodocumento.getInternalname(), GXutil.rtrim( AV68ProfesionalTipoDocumento), 1, cmbavProfesionaltipodocumento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavProfesionaltipodocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegistroProfesional", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "", true, (byte)(1), "HLP_WPMiPerfilProfesional.htm");
         cmbavProfesionaltipodocumento.setValue( GXutil.rtrim( AV68ProfesionalTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltipodocumento.getInternalname(), "Values", cmbavProfesionaltipodocumento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalnrodocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalnrodocumento_Internalname, "Nro Documento", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalnrodocumento_Internalname, AV61ProfesionalNroDocumento, GXutil.rtrim( localUtil.format( AV61ProfesionalNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalnrodocumento_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", 1, edtavProfesionalnrodocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalnombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalnombres_Internalname, "Nombres", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalnombres_Internalname, AV60ProfesionalNombres, GXutil.rtrim( localUtil.format( AV60ProfesionalNombres, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalnombres_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", 1, edtavProfesionalnombres_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalapellidopaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalapellidopaterno_Internalname, "Apellido Paterno", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalapellidopaterno_Internalname, AV41ProfesionalApellidoPaterno, GXutil.rtrim( localUtil.format( AV41ProfesionalApellidoPaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalapellidopaterno_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", 1, edtavProfesionalapellidopaterno_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalapellidomaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalapellidomaterno_Internalname, "Apellido Materno", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalapellidomaterno_Internalname, AV40ProfesionalApellidoMaterno, GXutil.rtrim( localUtil.format( AV40ProfesionalApellidoMaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalapellidomaterno_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", 1, edtavProfesionalapellidomaterno_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavProfesionalsexo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavProfesionalsexo.getInternalname(), "Sexo", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavProfesionalsexo, cmbavProfesionalsexo.getInternalname(), GXutil.rtrim( AV64ProfesionalSexo), 1, cmbavProfesionalsexo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavProfesionalsexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegistroProfesional", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,51);\"", "", true, (byte)(1), "HLP_WPMiPerfilProfesional.htm");
         cmbavProfesionalsexo.setValue( GXutil.rtrim( AV64ProfesionalSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalsexo.getInternalname(), "Values", cmbavProfesionalsexo.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 MT_15", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup1_Internalname, "Fecha nacimiento", 1, 0, "px", 0, "px", "GroupRegPer", "", "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup1table1_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavProfesionaldia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavProfesionaldia.getInternalname(), "Día", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavProfesionaldia, cmbavProfesionaldia.getInternalname(), GXutil.trim( GXutil.str( AV47ProfesionalDia, 4, 0)), 1, cmbavProfesionaldia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavProfesionaldia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegistroProfesional", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,60);\"", "", true, (byte)(1), "HLP_WPMiPerfilProfesional.htm");
         cmbavProfesionaldia.setValue( GXutil.trim( GXutil.str( AV47ProfesionalDia, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaldia.getInternalname(), "Values", cmbavProfesionaldia.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavProfesionalmes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavProfesionalmes.getInternalname(), "Mes", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavProfesionalmes, cmbavProfesionalmes.getInternalname(), GXutil.rtrim( AV59ProfesionalMes), 1, cmbavProfesionalmes.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavProfesionalmes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegistroProfesional", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "", true, (byte)(1), "HLP_WPMiPerfilProfesional.htm");
         cmbavProfesionalmes.setValue( GXutil.rtrim( AV59ProfesionalMes) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalmes.getInternalname(), "Values", cmbavProfesionalmes.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavProfesionalanio.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavProfesionalanio.getInternalname(), "Año", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavProfesionalanio, cmbavProfesionalanio.getInternalname(), GXutil.trim( GXutil.str( AV39ProfesionalAnio, 4, 0)), 1, cmbavProfesionalanio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavProfesionalanio.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegistroProfesional", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "", true, (byte)(1), "HLP_WPMiPerfilProfesional.htm");
         cmbavProfesionalanio.setValue( GXutil.trim( GXutil.str( AV39ProfesionalAnio, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalanio.getInternalname(), "Values", cmbavProfesionalanio.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalcop_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalcop_Internalname, "CMP", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalcop_Internalname, AV43ProfesionalCOP, GXutil.rtrim( localUtil.format( AV43ProfesionalCOP, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalcop_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", 1, edtavProfesionalcop_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionaldescripcion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionaldescripcion_Internalname, "Acerca de ti", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionaldescripcion_Internalname, AV46ProfesionalDescripcion, GXutil.rtrim( localUtil.format( AV46ProfesionalDescripcion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionaldescripcion_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", 1, edtavProfesionaldescripcion_Enabled, 0, "text", "", 80, "chr", 1, "row", 5000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavPaisid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavPaisid.getInternalname(), "Nacionalidad", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavPaisid, dynavPaisid.getInternalname(), GXutil.trim( GXutil.str( AV34PaisId, 4, 0)), 1, dynavPaisid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavPaisid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegistroProfesional", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "", true, (byte)(1), "HLP_WPMiPerfilProfesional.htm");
         dynavPaisid.setValue( GXutil.trim( GXutil.str( AV34PaisId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPaisid.getInternalname(), "Values", dynavPaisid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionaltelefono_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionaltelefono_Internalname, "Teléfono ", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 86,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionaltelefono_Internalname, GXutil.rtrim( AV65ProfesionalTelefono), GXutil.rtrim( localUtil.format( AV65ProfesionalTelefono, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,86);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionaltelefono_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", 1, edtavProfesionaltelefono_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavProfesionaltiempocita.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavProfesionaltiempocita.getInternalname(), "Tiempo Cita", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavProfesionaltiempocita, cmbavProfesionaltiempocita.getInternalname(), GXutil.trim( GXutil.str( AV67ProfesionalTiempoCita, 2, 0)), 1, cmbavProfesionaltiempocita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavProfesionaltiempocita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegistroProfesional", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,90);\"", "", true, (byte)(1), "HLP_WPMiPerfilProfesional.htm");
         cmbavProfesionaltiempocita.setValue( GXutil.trim( GXutil.str( AV67ProfesionalTiempoCita, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltiempocita.getInternalname(), "Values", cmbavProfesionaltiempocita.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", edtavProfesionalfacebook_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalfacebook_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalfacebook_Internalname, "Url Facebook", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalfacebook_Internalname, AV51ProfesionalFacebook, GXutil.rtrim( localUtil.format( AV51ProfesionalFacebook, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,95);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalfacebook_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", edtavProfesionalfacebook_Visible, edtavProfesionalfacebook_Enabled, 0, "text", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", edtavProfesionallinkedin_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionallinkedin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionallinkedin_Internalname, "Url Linkedin", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionallinkedin_Internalname, AV58ProfesionalLinkedin, GXutil.rtrim( localUtil.format( AV58ProfesionalLinkedin, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionallinkedin_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", edtavProfesionallinkedin_Visible, edtavProfesionallinkedin_Enabled, 0, "text", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", edtavProfesionaltwitter_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionaltwitter_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionaltwitter_Internalname, "Url Twitter", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionaltwitter_Internalname, AV69ProfesionalTwitter, GXutil.rtrim( localUtil.format( AV69ProfesionalTwitter, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,103);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionaltwitter_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", edtavProfesionaltwitter_Visible, edtavProfesionaltwitter_Enabled, 0, "text", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", edtavProfesionalinstagram_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalinstagram_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalinstagram_Internalname, "Url Instagram", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalinstagram_Internalname, AV57ProfesionalInstagram, GXutil.rtrim( localUtil.format( AV57ProfesionalInstagram, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalinstagram_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", edtavProfesionalinstagram_Visible, edtavProfesionalinstagram_Enabled, 0, "text", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup6_Internalname, "UBICACIÓN DE RESIDENCIA", 1, 0, "px", 0, "px", "GroupRegistroMedico", "", "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup6table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionaldireccion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionaldireccion_Internalname, "Dirección", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 116,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionaldireccion_Internalname, AV48ProfesionalDireccion, GXutil.rtrim( localUtil.format( AV48ProfesionalDireccion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,116);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionaldireccion_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", 1, edtavProfesionaldireccion_Enabled, 0, "text", "", 15, "chr", 1, "row", 200, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavProfesionaldepartamento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavProfesionaldepartamento.getInternalname(), "Departamento", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 121,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavProfesionaldepartamento, cmbavProfesionaldepartamento.getInternalname(), GXutil.rtrim( AV45ProfesionalDepartamento), 1, cmbavProfesionaldepartamento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavProfesionaldepartamento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegistroProfesional", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,121);\"", "", true, (byte)(1), "HLP_WPMiPerfilProfesional.htm");
         cmbavProfesionaldepartamento.setValue( GXutil.rtrim( AV45ProfesionalDepartamento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaldepartamento.getInternalname(), "Values", cmbavProfesionaldepartamento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavProfesionalprovincia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavProfesionalprovincia.getInternalname(), "Provincia", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavProfesionalprovincia, dynavProfesionalprovincia.getInternalname(), GXutil.rtrim( AV63ProfesionalProvincia), 1, dynavProfesionalprovincia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavProfesionalprovincia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegistroProfesional", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,125);\"", "", true, (byte)(1), "HLP_WPMiPerfilProfesional.htm");
         dynavProfesionalprovincia.setValue( GXutil.rtrim( AV63ProfesionalProvincia) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProfesionalprovincia.getInternalname(), "Values", dynavProfesionalprovincia.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavProfesionaldistrito.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavProfesionaldistrito.getInternalname(), "Distrito", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavProfesionaldistrito, dynavProfesionaldistrito.getInternalname(), GXutil.rtrim( AV49ProfesionalDistrito), 1, dynavProfesionaldistrito.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavProfesionaldistrito.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegistroProfesional", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,129);\"", "", true, (byte)(1), "HLP_WPMiPerfilProfesional.htm");
         dynavProfesionaldistrito.setValue( GXutil.rtrim( AV49ProfesionalDistrito) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProfesionaldistrito.getInternalname(), "Values", dynavProfesionaldistrito.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup2_Internalname, "INFORMACIÓN DE CUENTA ", 1, 0, "px", 0, "px", "GroupRegistroMedico", "", "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup2table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalcorreo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalcorreo_Internalname, "Correo", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 138,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalcorreo_Internalname, AV44ProfesionalCorreo, GXutil.rtrim( localUtil.format( AV44ProfesionalCorreo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,138);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalcorreo_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", 1, edtavProfesionalcorreo_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalpassword_Internalname, "Contraseña", "col-xs-12 AttributeRegistroProfesionalLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 143,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalpassword_Internalname, AV62ProfesionalPassword, GXutil.rtrim( localUtil.format( AV62ProfesionalPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,143);\""+" "+"data-gx-password-reveal"+" "+"idenableshowpasswordhint=\"True\""+" ", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalpassword_Jsonclick, 0, "AttributeRegistroProfesional", "", "", "", "", 1, edtavProfesionalpassword_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(-1), (short)(0), 0, (byte)(1), (byte)(0), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup4_Internalname, "IMAGEN DE PERFIL", 1, 0, "px", 0, "px", "GroupRegistroMedico", "", "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup4table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucFileuploadimagen.setProperty("AutoUpload", Fileuploadimagen_Autoupload);
         ucFileuploadimagen.setProperty("TooltipText", Fileuploadimagen_Tooltiptext);
         ucFileuploadimagen.setProperty("EnableUploadedFileCanceling", Fileuploadimagen_Enableuploadedfilecanceling);
         ucFileuploadimagen.setProperty("MaxNumberOfFiles", Fileuploadimagen_Maxnumberoffiles);
         ucFileuploadimagen.setProperty("AutoDisableAddingFiles", Fileuploadimagen_Autodisableaddingfiles);
         ucFileuploadimagen.setProperty("AcceptedFileTypes", Fileuploadimagen_Acceptedfiletypes);
         ucFileuploadimagen.setProperty("UploadedFiles", AV82UploadedFiles);
         ucFileuploadimagen.setProperty("FailedFiles", AV19FailedFiles);
         ucFileuploadimagen.render(context, "fileupload", Fileuploadimagen_Internalname, "FILEUPLOADIMAGENContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup7_Internalname, "INFORMACIÓN ADICIONAL", 1, 0, "px", 0, "px", "GroupRegistroMedico", "", "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup7table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucTabpageregistroprofesional.setProperty("PageCount", Tabpageregistroprofesional_Pagecount);
         ucTabpageregistroprofesional.setProperty("Class", Tabpageregistroprofesional_Class);
         ucTabpageregistroprofesional.setProperty("HistoryManagement", Tabpageregistroprofesional_Historymanagement);
         ucTabpageregistroprofesional.render(context, "tab", Tabpageregistroprofesional_Internalname, "TABPAGEREGISTROPROFESIONALContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABPAGEREGISTROPROFESIONALContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpageregistroprofesional_title_Internalname, "Especialidad", "", "", lblTabpageregistroprofesional_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPageRegistroProfesional") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABPAGEREGISTROPROFESIONALContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable10_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridespecialidadsedeContainer.SetIsFreestyle(true);
         GridespecialidadsedeContainer.SetWrapped(nGXWrapped);
         if ( GridespecialidadsedeContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridespecialidadsedeContainer"+"DivS\" data-gxgridid=\"167\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridespecialidadsede_Internalname, subGridespecialidadsede_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridespecialidadsedeContainer.AddObjectProperty("GridName", "Gridespecialidadsede");
         }
         else
         {
            GridespecialidadsedeContainer.AddObjectProperty("GridName", "Gridespecialidadsede");
            GridespecialidadsedeContainer.AddObjectProperty("Header", subGridespecialidadsede_Header);
            GridespecialidadsedeContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridespecialidadsedeContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridespecialidadsedeContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridespecialidadsedeContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridespecialidadsedeContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridespecialidadsede_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridespecialidadsedeContainer.AddObjectProperty("CmpContext", "");
            GridespecialidadsedeContainer.AddObjectProperty("InMasterPage", "false");
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridespecialidadsedeContainer.AddColumnProperties(GridespecialidadsedeColumn);
            GridespecialidadsedeContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridespecialidadsede_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridespecialidadsedeContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridespecialidadsede_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridespecialidadsedeContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridespecialidadsede_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridespecialidadsedeContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridespecialidadsede_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridespecialidadsedeContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridespecialidadsede_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridespecialidadsedeContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridespecialidadsede_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridespecialidadsedeContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridespecialidadsede_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 167 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_167 = (int)(nGXsfl_167_idx-1) ;
         if ( GridespecialidadsedeContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV85GXV1 = nGXsfl_167_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridespecialidadsedeContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridespecialidadsede", GridespecialidadsedeContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridespecialidadsedeContainerData", GridespecialidadsedeContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridespecialidadsedeContainerData"+"V", GridespecialidadsedeContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridespecialidadsedeContainerData"+"V"+"\" value='"+GridespecialidadsedeContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 184,'',false,'',0)\"" ;
         ClassString = "ButtonNewLineProfesional" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttAddnewespecialidad_Internalname, "gx.evt.setGridEvt("+GXutil.str( 167, 3, 0)+","+"null"+");", "Añadir Especialidad", bttAddnewespecialidad_Jsonclick, 5, "Añadir Especialidad", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'ADD NEW ESPECIALIDAD\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABPAGEREGISTROPROFESIONALContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpage2_title_Internalname, "Educación", "", "", lblTabpage2_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPage2") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABPAGEREGISTROPROFESIONALContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage2table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable6_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GrideducacionContainer.SetIsFreestyle(true);
         GrideducacionContainer.SetWrapped(nGXWrapped);
         if ( GrideducacionContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GrideducacionContainer"+"DivS\" data-gxgridid=\"195\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGrideducacion_Internalname, subGrideducacion_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GrideducacionContainer.AddObjectProperty("GridName", "Grideducacion");
         }
         else
         {
            GrideducacionContainer.AddObjectProperty("GridName", "Grideducacion");
            GrideducacionContainer.AddObjectProperty("Header", subGrideducacion_Header);
            GrideducacionContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GrideducacionContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GrideducacionContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GrideducacionContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GrideducacionContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrideducacion_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GrideducacionContainer.AddObjectProperty("CmpContext", "");
            GrideducacionContainer.AddObjectProperty("InMasterPage", "false");
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GrideducacionContainer.AddColumnProperties(GrideducacionColumn);
            GrideducacionContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrideducacion_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GrideducacionContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrideducacion_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GrideducacionContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrideducacion_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GrideducacionContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrideducacion_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GrideducacionContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrideducacion_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GrideducacionContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrideducacion_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GrideducacionContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrideducacion_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 195 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_195 = (int)(nGXsfl_195_idx-1) ;
         if ( GrideducacionContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV89GXV5 = nGXsfl_195_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GrideducacionContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grideducacion", GrideducacionContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GrideducacionContainerData", GrideducacionContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GrideducacionContainerData"+"V", GrideducacionContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GrideducacionContainerData"+"V"+"\" value='"+GrideducacionContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 224,'',false,'',0)\"" ;
         ClassString = "ButtonNewLineProfesional" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttAddeducacion_Internalname, "gx.evt.setGridEvt("+GXutil.str( 167, 3, 0)+","+"null"+");", "Añadir Educación", bttAddeducacion_Jsonclick, 5, "Añadir Educación", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'ADD EDUCACION\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABPAGEREGISTROPROFESIONALContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpage3_title_Internalname, "Experiencia Laboral", "", "", lblTabpage3_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPage3") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABPAGEREGISTROPROFESIONALContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage3table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable7_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridexperiencialaboralContainer.SetIsFreestyle(true);
         GridexperiencialaboralContainer.SetWrapped(nGXWrapped);
         if ( GridexperiencialaboralContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridexperiencialaboralContainer"+"DivS\" data-gxgridid=\"235\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridexperiencialaboral_Internalname, subGridexperiencialaboral_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridexperiencialaboralContainer.AddObjectProperty("GridName", "Gridexperiencialaboral");
         }
         else
         {
            GridexperiencialaboralContainer.AddObjectProperty("GridName", "Gridexperiencialaboral");
            GridexperiencialaboralContainer.AddObjectProperty("Header", subGridexperiencialaboral_Header);
            GridexperiencialaboralContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridexperiencialaboralContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridexperiencialaboralContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridexperiencialaboralContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridexperiencialaboralContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridexperiencialaboral_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridexperiencialaboralContainer.AddObjectProperty("CmpContext", "");
            GridexperiencialaboralContainer.AddObjectProperty("InMasterPage", "false");
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridexperiencialaboralContainer.AddColumnProperties(GridexperiencialaboralColumn);
            GridexperiencialaboralContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridexperiencialaboral_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridexperiencialaboralContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridexperiencialaboral_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridexperiencialaboralContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridexperiencialaboral_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridexperiencialaboralContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridexperiencialaboral_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridexperiencialaboralContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridexperiencialaboral_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridexperiencialaboralContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridexperiencialaboral_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridexperiencialaboralContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridexperiencialaboral_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 235 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_235 = (int)(nGXsfl_235_idx-1) ;
         if ( GridexperiencialaboralContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV95GXV11 = nGXsfl_235_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridexperiencialaboralContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridexperiencialaboral", GridexperiencialaboralContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridexperiencialaboralContainerData", GridexperiencialaboralContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridexperiencialaboralContainerData"+"V", GridexperiencialaboralContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridexperiencialaboralContainerData"+"V"+"\" value='"+GridexperiencialaboralContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 255,'',false,'',0)\"" ;
         ClassString = "ButtonNewLineProfesional" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttAddexperiencialaboral_Internalname, "gx.evt.setGridEvt("+GXutil.str( 167, 3, 0)+","+"null"+");", "Añadir Experiencia Laboral", bttAddexperiencialaboral_Jsonclick, 5, "Añadir Experiencia Laboral", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'ADD EXPERIENCIA LABORAL\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABPAGEREGISTROPROFESIONALContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpage1_title_Internalname, "Premios y Logros", "", "", lblTabpage1_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPage1") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABPAGEREGISTROPROFESIONALContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage1table1_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable8_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridpremiosContainer.SetIsFreestyle(true);
         GridpremiosContainer.SetWrapped(nGXWrapped);
         if ( GridpremiosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridpremiosContainer"+"DivS\" data-gxgridid=\"266\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridpremios_Internalname, subGridpremios_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridpremiosContainer.AddObjectProperty("GridName", "Gridpremios");
         }
         else
         {
            GridpremiosContainer.AddObjectProperty("GridName", "Gridpremios");
            GridpremiosContainer.AddObjectProperty("Header", subGridpremios_Header);
            GridpremiosContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridpremiosContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridpremiosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridpremiosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridpremiosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridpremios_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridpremiosContainer.AddObjectProperty("CmpContext", "");
            GridpremiosContainer.AddObjectProperty("InMasterPage", "false");
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpremiosContainer.AddColumnProperties(GridpremiosColumn);
            GridpremiosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridpremios_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridpremiosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridpremios_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridpremiosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridpremios_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridpremiosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridpremios_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridpremiosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridpremios_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridpremiosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridpremios_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridpremiosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridpremios_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 266 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_266 = (int)(nGXsfl_266_idx-1) ;
         if ( GridpremiosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV100GXV16 = nGXsfl_266_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridpremiosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridpremios", GridpremiosContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpremiosContainerData", GridpremiosContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpremiosContainerData"+"V", GridpremiosContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridpremiosContainerData"+"V"+"\" value='"+GridpremiosContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 288,'',false,'',0)\"" ;
         ClassString = "ButtonNewLineProfesional" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttAddpremio_Internalname, "gx.evt.setGridEvt("+GXutil.str( 167, 3, 0)+","+"null"+");", "Añadir  Premio o Logro ", bttAddpremio_Jsonclick, 5, "Añadir  Premio o Logro ", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'ADD PREMIO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABPAGEREGISTROPROFESIONALContainer"+"title5"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpage4_title_Internalname, "Servicios", "", "", lblTabpage4_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilProfesional.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPage4") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABPAGEREGISTROPROFESIONALContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage4table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable9_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridserviciosContainer.SetIsFreestyle(true);
         GridserviciosContainer.SetWrapped(nGXWrapped);
         if ( GridserviciosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridserviciosContainer"+"DivS\" data-gxgridid=\"299\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridservicios_Internalname, subGridservicios_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridserviciosContainer.AddObjectProperty("GridName", "Gridservicios");
         }
         else
         {
            GridserviciosContainer.AddObjectProperty("GridName", "Gridservicios");
            GridserviciosContainer.AddObjectProperty("Header", subGridservicios_Header);
            GridserviciosContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridserviciosContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridserviciosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridserviciosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridserviciosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridservicios_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridserviciosContainer.AddObjectProperty("CmpContext", "");
            GridserviciosContainer.AddObjectProperty("InMasterPage", "false");
            GridserviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridserviciosContainer.AddColumnProperties(GridserviciosColumn);
            GridserviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridserviciosContainer.AddColumnProperties(GridserviciosColumn);
            GridserviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridserviciosContainer.AddColumnProperties(GridserviciosColumn);
            GridserviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridserviciosContainer.AddColumnProperties(GridserviciosColumn);
            GridserviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridserviciosContainer.AddColumnProperties(GridserviciosColumn);
            GridserviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridserviciosContainer.AddColumnProperties(GridserviciosColumn);
            GridserviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridserviciosContainer.AddColumnProperties(GridserviciosColumn);
            GridserviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridserviciosContainer.AddColumnProperties(GridserviciosColumn);
            GridserviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridserviciosContainer.AddColumnProperties(GridserviciosColumn);
            GridserviciosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridservicios_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridserviciosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridservicios_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridserviciosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridservicios_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridserviciosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridservicios_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridserviciosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridservicios_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridserviciosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridservicios_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridserviciosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridservicios_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 299 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_299 = (int)(nGXsfl_299_idx-1) ;
         if ( GridserviciosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV105GXV21 = nGXsfl_299_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridserviciosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridservicios", GridserviciosContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridserviciosContainerData", GridserviciosContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridserviciosContainerData"+"V", GridserviciosContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridserviciosContainerData"+"V"+"\" value='"+GridserviciosContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 311,'',false,'',0)\"" ;
         ClassString = "ButtonNewLineProfesional" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttAddnewservicio_Internalname, "gx.evt.setGridEvt("+GXutil.str( 167, 3, 0)+","+"null"+");", "Añadir  Servicio", bttAddnewservicio_Jsonclick, 5, "Añadir  Servicio", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'ADD NEW SERVICIO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-1", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavProfesionalterminoscondiciones.getInternalname(), "Profesional Terminos Condiciones", "col-sm-3 AttributeLabel", 0, true, "");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 315,'',false,'" + sGXsfl_167_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavProfesionalterminoscondiciones.getInternalname(), GXutil.booltostr( AV66ProfesionalTerminosCondiciones), "", "Profesional Terminos Condiciones", 1, chkavProfesionalterminoscondiciones.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(315, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,315);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-11 TableMTML", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktercond_Internalname, lblTextblocktercond_Caption, "", "", lblTextblocktercond_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPMiPerfilProfesional.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 322,'',false,'',0)\"" ;
         ClassString = "ButtonAddCancelProfesional" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttGuardarprofesional_Internalname, "gx.evt.setGridEvt("+GXutil.str( 167, 3, 0)+","+"null"+");", "Guardar ", bttGuardarprofesional_Jsonclick, 5, "Guardar ", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'GUARDARPROFESIONAL\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilProfesional.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 324,'',false,'',0)\"" ;
         ClassString = "ButtonAddCancelProfesional" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttSalir_Internalname, "gx.evt.setGridEvt("+GXutil.str( 167, 3, 0)+","+"null"+");", "Salir ", bttSalir_Jsonclick, 7, "Salir ", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e116u1_client"+"'", TempTags, "", 2, "HLP_WPMiPerfilProfesional.htm");
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
      if ( wbEnd == 167 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridespecialidadsedeContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV85GXV1 = nGXsfl_167_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridespecialidadsedeContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridespecialidadsede", GridespecialidadsedeContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridespecialidadsedeContainerData", GridespecialidadsedeContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridespecialidadsedeContainerData"+"V", GridespecialidadsedeContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridespecialidadsedeContainerData"+"V"+"\" value='"+GridespecialidadsedeContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 195 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GrideducacionContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV89GXV5 = nGXsfl_195_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GrideducacionContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grideducacion", GrideducacionContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GrideducacionContainerData", GrideducacionContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GrideducacionContainerData"+"V", GrideducacionContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GrideducacionContainerData"+"V"+"\" value='"+GrideducacionContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 235 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridexperiencialaboralContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV95GXV11 = nGXsfl_235_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridexperiencialaboralContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridexperiencialaboral", GridexperiencialaboralContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridexperiencialaboralContainerData", GridexperiencialaboralContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridexperiencialaboralContainerData"+"V", GridexperiencialaboralContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridexperiencialaboralContainerData"+"V"+"\" value='"+GridexperiencialaboralContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 266 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridpremiosContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV100GXV16 = nGXsfl_266_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridpremiosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridpremios", GridpremiosContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpremiosContainerData", GridpremiosContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpremiosContainerData"+"V", GridpremiosContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridpremiosContainerData"+"V"+"\" value='"+GridpremiosContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 299 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridserviciosContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV105GXV21 = nGXsfl_299_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridserviciosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridservicios", GridserviciosContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridserviciosContainerData", GridserviciosContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridserviciosContainerData"+"V", GridserviciosContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridserviciosContainerData"+"V"+"\" value='"+GridserviciosContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start6U2( )
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
         Form.getMeta().addItem("description", "Mi Perfil", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6U0( ) ;
   }

   public void ws6U2( )
   {
      start6U2( ) ;
      evt6U2( ) ;
   }

   public void evt6U2( )
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
                        else if ( GXutil.strcmp(sEvt, "VPROFESIONALANIO.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e126U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VPROFESIONALMES.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e136U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'GUARDARPROFESIONAL'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'GuardarProfesional' */
                           e146U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VPROFESIONALNRODOCUMENTO.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e156U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ADD EDUCACION'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Add Educacion' */
                           e166U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ADD EXPERIENCIA LABORAL'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Add Experiencia Laboral' */
                           e176U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ADD PREMIO'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Add Premio' */
                           e186U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ADD NEW SERVICIO'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Add New Servicio' */
                           e196U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ADD NEW ESPECIALIDAD'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Add New Especialidad' */
                           e206U2 ();
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
                        if ( GXutil.strcmp(GXutil.left( sEvt, 18), "GRIDEDUCACION.LOAD") == 0 )
                        {
                           nGXsfl_195_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_195_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_195_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1958( ) ;
                           AV89GXV5 = nGXsfl_195_idx ;
                           if ( ( AV12EducacionList.size() >= AV89GXV5 ) && ( AV89GXV5 > 0 ) )
                           {
                              AV12EducacionList.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDEDUCACION.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e216U8 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 27), "GRIDEXPERIENCIALABORAL.LOAD") == 0 )
                        {
                           nGXsfl_235_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2357( ) ;
                           AV95GXV11 = nGXsfl_235_idx ;
                           if ( ( AV18ExperienciaLaboralList.size() >= AV95GXV11 ) && ( AV95GXV11 > 0 ) )
                           {
                              AV18ExperienciaLaboralList.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDEXPERIENCIALABORAL.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e226U7 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 16), "GRIDPREMIOS.LOAD") == 0 )
                        {
                           nGXsfl_266_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_266_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_266_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2666( ) ;
                           AV100GXV16 = nGXsfl_266_idx ;
                           if ( ( AV38PremiosList.size() >= AV100GXV16 ) && ( AV100GXV16 > 0 ) )
                           {
                              AV38PremiosList.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDPREMIOS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e236U6 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 18), "GRIDSERVICIOS.LOAD") == 0 )
                        {
                           nGXsfl_299_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_299_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_299_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2995( ) ;
                           AV105GXV21 = nGXsfl_299_idx ;
                           if ( ( AV76ServiciosList.size() >= AV105GXV21 ) && ( AV105GXV21 > 0 ) )
                           {
                              AV76ServiciosList.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV76ServiciosList.elementAt(-1+AV105GXV21)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSERVICIOS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e246U5 ();
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
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "GRIDESPECIALIDADSEDE.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_167_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_167_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_167_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1672( ) ;
                           AV85GXV1 = nGXsfl_167_idx ;
                           if ( ( AV15EspecialidadList.size() >= AV85GXV1 ) && ( AV85GXV1 > 0 ) )
                           {
                              AV15EspecialidadList.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)) );
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
                                 e256U2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDESPECIALIDADSEDE.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e266U2 ();
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

   public void we6U2( )
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

   public void pa6U2( )
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
            GX_FocusControl = cmbavProfesionaltipodocumento.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      gxvvprofesionaldistrito_html6U2( AV45ProfesionalDepartamento, AV63ProfesionalProvincia) ;
      /* End function dynload_actions */
   }

   public void gxdlvvpaisid6U2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvpaisid_data6U2( ) ;
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

   public void gxvvpaisid_html6U2( )
   {
      short gxdynajaxvalue;
      gxdlvvpaisid_data6U2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavPaisid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavPaisid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvpaisid_data6U2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione:");
      /* Using cursor H006U2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H006U2_A43PaisId[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H006U2_A184PaisDescripcion[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvprofesionalprovincia6U2( String AV45ProfesionalDepartamento )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvprofesionalprovincia_data6U2( AV45ProfesionalDepartamento) ;
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

   public void gxvvprofesionalprovincia_html6U2( String AV45ProfesionalDepartamento )
   {
      String gxdynajaxvalue;
      gxdlvvprofesionalprovincia_data6U2( AV45ProfesionalDepartamento) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavProfesionalprovincia.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavProfesionalprovincia.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvprofesionalprovincia_data6U2( String AV45ProfesionalDepartamento )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccione:");
      /* Using cursor H006U3 */
      pr_default.execute(1, new Object[] {AV45ProfesionalDepartamento});
      while ( (pr_default.getStatus(1) != 101) )
      {
         if ( GXutil.strcmp(H006U3_A295UbigeoDepartamentoCode[0], AV45ProfesionalDepartamento) == 0 )
         {
            gxdynajaxctrlcodr.add(H006U3_A296UbigeoProvinciaCode[0]);
            gxdynajaxctrldescr.add(H006U3_A187UbigeoProvincia[0]);
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxdlvvprofesionaldistrito6U2( String AV45ProfesionalDepartamento ,
                                             String AV63ProfesionalProvincia )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvprofesionaldistrito_data6U2( AV45ProfesionalDepartamento, AV63ProfesionalProvincia) ;
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

   public void gxvvprofesionaldistrito_html6U2( String AV45ProfesionalDepartamento ,
                                                String AV63ProfesionalProvincia )
   {
      String gxdynajaxvalue;
      gxdlvvprofesionaldistrito_data6U2( AV45ProfesionalDepartamento, AV63ProfesionalProvincia) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavProfesionaldistrito.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavProfesionaldistrito.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvprofesionaldistrito_data6U2( String AV45ProfesionalDepartamento ,
                                                     String AV63ProfesionalProvincia )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccione:");
      /* Using cursor H006U4 */
      pr_default.execute(2, new Object[] {AV45ProfesionalDepartamento, AV63ProfesionalProvincia});
      while ( (pr_default.getStatus(2) != 101) )
      {
         gxdynajaxctrlcodr.add(H006U4_A297UbigeoDistritoCode[0]);
         gxdynajaxctrldescr.add(H006U4_A188UbigeoDistrito[0]);
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void gxdlvctlespecialidadid6U2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvctlespecialidadid_data6U2( ) ;
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

   public void gxvctlespecialidadid_html6U2( )
   {
      short gxdynajaxvalue;
      gxdlvctlespecialidadid_data6U2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavCtlespecialidadid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavCtlespecialidadid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvctlespecialidadid_data6U2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione");
      /* Using cursor H006U5 */
      pr_default.execute(3);
      while ( (pr_default.getStatus(3) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H006U5_A32EspecialidadId[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H006U5_A71EspecialidadNombre[0]);
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   public void gxnrgridespecialidadsede_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1672( ) ;
      while ( nGXsfl_167_idx <= nRC_GXsfl_167 )
      {
         sendrow_1672( ) ;
         nGXsfl_167_idx = ((subGridespecialidadsede_Islastpage==1)&&(nGXsfl_167_idx+1>subgridespecialidadsede_fnc_recordsperpage( )) ? 1 : nGXsfl_167_idx+1) ;
         sGXsfl_167_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_167_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1672( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridespecialidadsedeContainer)) ;
      /* End function gxnrGridespecialidadsede_newrow */
   }

   public void gxnrgridservicios_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2995( ) ;
      while ( nGXsfl_299_idx <= nRC_GXsfl_299 )
      {
         sendrow_2995( ) ;
         nGXsfl_299_idx = ((subGridservicios_Islastpage==1)&&(nGXsfl_299_idx+1>subgridservicios_fnc_recordsperpage( )) ? 1 : nGXsfl_299_idx+1) ;
         sGXsfl_299_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_299_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2995( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridserviciosContainer)) ;
      /* End function gxnrGridservicios_newrow */
   }

   public void gxnrgridpremios_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2666( ) ;
      while ( nGXsfl_266_idx <= nRC_GXsfl_266 )
      {
         sendrow_2666( ) ;
         nGXsfl_266_idx = ((subGridpremios_Islastpage==1)&&(nGXsfl_266_idx+1>subgridpremios_fnc_recordsperpage( )) ? 1 : nGXsfl_266_idx+1) ;
         sGXsfl_266_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_266_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2666( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridpremiosContainer)) ;
      /* End function gxnrGridpremios_newrow */
   }

   public void gxnrgridexperiencialaboral_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2357( ) ;
      while ( nGXsfl_235_idx <= nRC_GXsfl_235 )
      {
         sendrow_2357( ) ;
         nGXsfl_235_idx = ((subGridexperiencialaboral_Islastpage==1)&&(nGXsfl_235_idx+1>subgridexperiencialaboral_fnc_recordsperpage( )) ? 1 : nGXsfl_235_idx+1) ;
         sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2357( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridexperiencialaboralContainer)) ;
      /* End function gxnrGridexperiencialaboral_newrow */
   }

   public void gxnrgrideducacion_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1958( ) ;
      while ( nGXsfl_195_idx <= nRC_GXsfl_195 )
      {
         sendrow_1958( ) ;
         nGXsfl_195_idx = ((subGrideducacion_Islastpage==1)&&(nGXsfl_195_idx+1>subgrideducacion_fnc_recordsperpage( )) ? 1 : nGXsfl_195_idx+1) ;
         sGXsfl_195_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_195_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1958( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GrideducacionContainer)) ;
      /* End function gxnrGrideducacion_newrow */
   }

   public void gxgrgridespecialidadsede_refresh( short AV34PaisId ,
                                                 boolean AV66ProfesionalTerminosCondiciones ,
                                                 String AV36Pattern ,
                                                 java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDESPECIALIDADSEDE_nCurrentRecord = 0 ;
      rf6U2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridespecialidadsede_refresh */
   }

   public void gxgrgrideducacion_refresh( short AV34PaisId ,
                                          boolean AV66ProfesionalTerminosCondiciones ,
                                          String AV36Pattern ,
                                          java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDEDUCACION_nCurrentRecord = 0 ;
      rf6U8( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrideducacion_refresh */
   }

   public void gxgrgridexperiencialaboral_refresh( short AV34PaisId ,
                                                   boolean AV66ProfesionalTerminosCondiciones ,
                                                   String AV36Pattern ,
                                                   java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDEXPERIENCIALABORAL_nCurrentRecord = 0 ;
      rf6U7( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridexperiencialaboral_refresh */
   }

   public void gxgrgridpremios_refresh( short AV34PaisId ,
                                        boolean AV66ProfesionalTerminosCondiciones ,
                                        String AV36Pattern ,
                                        java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDPREMIOS_nCurrentRecord = 0 ;
      rf6U6( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridpremios_refresh */
   }

   public void gxgrgridservicios_refresh( short AV34PaisId ,
                                          boolean AV66ProfesionalTerminosCondiciones ,
                                          String AV36Pattern ,
                                          java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDSERVICIOS_nCurrentRecord = 0 ;
      rf6U5( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridservicios_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvvpaisid_html6U2( ) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavProfesionaltipodocumento.getItemCount() > 0 )
      {
         AV68ProfesionalTipoDocumento = cmbavProfesionaltipodocumento.getValidValue(AV68ProfesionalTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV68ProfesionalTipoDocumento", AV68ProfesionalTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavProfesionaltipodocumento.setValue( GXutil.rtrim( AV68ProfesionalTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltipodocumento.getInternalname(), "Values", cmbavProfesionaltipodocumento.ToJavascriptSource(), true);
      }
      if ( cmbavProfesionalsexo.getItemCount() > 0 )
      {
         AV64ProfesionalSexo = cmbavProfesionalsexo.getValidValue(AV64ProfesionalSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64ProfesionalSexo", AV64ProfesionalSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavProfesionalsexo.setValue( GXutil.rtrim( AV64ProfesionalSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalsexo.getInternalname(), "Values", cmbavProfesionalsexo.ToJavascriptSource(), true);
      }
      if ( cmbavProfesionaldia.getItemCount() > 0 )
      {
         AV47ProfesionalDia = (short)(GXutil.lval( cmbavProfesionaldia.getValidValue(GXutil.trim( GXutil.str( AV47ProfesionalDia, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47ProfesionalDia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47ProfesionalDia), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavProfesionaldia.setValue( GXutil.trim( GXutil.str( AV47ProfesionalDia, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaldia.getInternalname(), "Values", cmbavProfesionaldia.ToJavascriptSource(), true);
      }
      if ( cmbavProfesionalmes.getItemCount() > 0 )
      {
         AV59ProfesionalMes = cmbavProfesionalmes.getValidValue(AV59ProfesionalMes) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59ProfesionalMes", AV59ProfesionalMes);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavProfesionalmes.setValue( GXutil.rtrim( AV59ProfesionalMes) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalmes.getInternalname(), "Values", cmbavProfesionalmes.ToJavascriptSource(), true);
      }
      if ( cmbavProfesionalanio.getItemCount() > 0 )
      {
         AV39ProfesionalAnio = (short)(GXutil.lval( cmbavProfesionalanio.getValidValue(GXutil.trim( GXutil.str( AV39ProfesionalAnio, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39ProfesionalAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39ProfesionalAnio), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavProfesionalanio.setValue( GXutil.trim( GXutil.str( AV39ProfesionalAnio, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalanio.getInternalname(), "Values", cmbavProfesionalanio.ToJavascriptSource(), true);
      }
      if ( dynavPaisid.getItemCount() > 0 )
      {
         AV34PaisId = (short)(GXutil.lval( dynavPaisid.getValidValue(GXutil.trim( GXutil.str( AV34PaisId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34PaisId), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPaisid.setValue( GXutil.trim( GXutil.str( AV34PaisId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPaisid.getInternalname(), "Values", dynavPaisid.ToJavascriptSource(), true);
      }
      if ( cmbavProfesionaltiempocita.getItemCount() > 0 )
      {
         AV67ProfesionalTiempoCita = (byte)(GXutil.lval( cmbavProfesionaltiempocita.getValidValue(GXutil.trim( GXutil.str( AV67ProfesionalTiempoCita, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV67ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67ProfesionalTiempoCita), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavProfesionaltiempocita.setValue( GXutil.trim( GXutil.str( AV67ProfesionalTiempoCita, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltiempocita.getInternalname(), "Values", cmbavProfesionaltiempocita.ToJavascriptSource(), true);
      }
      if ( cmbavProfesionaldepartamento.getItemCount() > 0 )
      {
         AV45ProfesionalDepartamento = cmbavProfesionaldepartamento.getValidValue(AV45ProfesionalDepartamento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45ProfesionalDepartamento", AV45ProfesionalDepartamento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavProfesionaldepartamento.setValue( GXutil.rtrim( AV45ProfesionalDepartamento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaldepartamento.getInternalname(), "Values", cmbavProfesionaldepartamento.ToJavascriptSource(), true);
      }
      if ( dynavProfesionalprovincia.getItemCount() > 0 )
      {
         AV63ProfesionalProvincia = dynavProfesionalprovincia.getValidValue(AV63ProfesionalProvincia) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63ProfesionalProvincia", AV63ProfesionalProvincia);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProfesionalprovincia.setValue( GXutil.rtrim( AV63ProfesionalProvincia) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProfesionalprovincia.getInternalname(), "Values", dynavProfesionalprovincia.ToJavascriptSource(), true);
      }
      if ( dynavProfesionaldistrito.getItemCount() > 0 )
      {
         AV49ProfesionalDistrito = dynavProfesionaldistrito.getValidValue(AV49ProfesionalDistrito) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49ProfesionalDistrito", AV49ProfesionalDistrito);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProfesionaldistrito.setValue( GXutil.rtrim( AV49ProfesionalDistrito) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProfesionaldistrito.getInternalname(), "Values", dynavProfesionaldistrito.ToJavascriptSource(), true);
      }
      AV66ProfesionalTerminosCondiciones = GXutil.strtobool( GXutil.booltostr( AV66ProfesionalTerminosCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66ProfesionalTerminosCondiciones", AV66ProfesionalTerminosCondiciones);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf6U2( ) ;
      rf6U8( ) ;
      rf6U7( ) ;
      rf6U6( ) ;
      rf6U5( ) ;
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

   public void rf6U2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridespecialidadsedeContainer.ClearRows();
      }
      wbStart = (short)(167) ;
      nGXsfl_167_idx = 1 ;
      sGXsfl_167_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_167_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1672( ) ;
      bGXsfl_167_Refreshing = true ;
      GridespecialidadsedeContainer.AddObjectProperty("GridName", "Gridespecialidadsede");
      GridespecialidadsedeContainer.AddObjectProperty("CmpContext", "");
      GridespecialidadsedeContainer.AddObjectProperty("InMasterPage", "false");
      GridespecialidadsedeContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridespecialidadsedeContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridespecialidadsedeContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridespecialidadsedeContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridespecialidadsedeContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridespecialidadsede_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridespecialidadsedeContainer.setPageSize( subgridespecialidadsede_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1672( ) ;
         e266U2 ();
         wbEnd = (short)(167) ;
         wb6U0( ) ;
      }
      bGXsfl_167_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6U2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPATTERN", AV36Pattern);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPATTERN", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV36Pattern, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
   }

   public void rf6U5( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridserviciosContainer.ClearRows();
      }
      wbStart = (short)(299) ;
      nGXsfl_299_idx = 1 ;
      sGXsfl_299_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_299_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2995( ) ;
      bGXsfl_299_Refreshing = true ;
      GridserviciosContainer.AddObjectProperty("GridName", "Gridservicios");
      GridserviciosContainer.AddObjectProperty("CmpContext", "");
      GridserviciosContainer.AddObjectProperty("InMasterPage", "false");
      GridserviciosContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridserviciosContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridserviciosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridserviciosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridserviciosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridservicios_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridserviciosContainer.setPageSize( subgridservicios_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2995( ) ;
         e246U5 ();
         wbEnd = (short)(299) ;
         wb6U0( ) ;
      }
      bGXsfl_299_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6U5( )
   {
   }

   public void rf6U6( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridpremiosContainer.ClearRows();
      }
      wbStart = (short)(266) ;
      nGXsfl_266_idx = 1 ;
      sGXsfl_266_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_266_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2666( ) ;
      bGXsfl_266_Refreshing = true ;
      GridpremiosContainer.AddObjectProperty("GridName", "Gridpremios");
      GridpremiosContainer.AddObjectProperty("CmpContext", "");
      GridpremiosContainer.AddObjectProperty("InMasterPage", "false");
      GridpremiosContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridpremiosContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridpremiosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridpremiosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridpremiosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridpremios_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridpremiosContainer.setPageSize( subgridpremios_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2666( ) ;
         e236U6 ();
         wbEnd = (short)(266) ;
         wb6U0( ) ;
      }
      bGXsfl_266_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6U6( )
   {
   }

   public void rf6U7( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridexperiencialaboralContainer.ClearRows();
      }
      wbStart = (short)(235) ;
      nGXsfl_235_idx = 1 ;
      sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2357( ) ;
      bGXsfl_235_Refreshing = true ;
      GridexperiencialaboralContainer.AddObjectProperty("GridName", "Gridexperiencialaboral");
      GridexperiencialaboralContainer.AddObjectProperty("CmpContext", "");
      GridexperiencialaboralContainer.AddObjectProperty("InMasterPage", "false");
      GridexperiencialaboralContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridexperiencialaboralContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridexperiencialaboralContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridexperiencialaboralContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridexperiencialaboralContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridexperiencialaboral_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridexperiencialaboralContainer.setPageSize( subgridexperiencialaboral_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2357( ) ;
         e226U7 ();
         wbEnd = (short)(235) ;
         wb6U0( ) ;
      }
      bGXsfl_235_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6U7( )
   {
   }

   public void rf6U8( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GrideducacionContainer.ClearRows();
      }
      wbStart = (short)(195) ;
      nGXsfl_195_idx = 1 ;
      sGXsfl_195_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_195_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1958( ) ;
      bGXsfl_195_Refreshing = true ;
      GrideducacionContainer.AddObjectProperty("GridName", "Grideducacion");
      GrideducacionContainer.AddObjectProperty("CmpContext", "");
      GrideducacionContainer.AddObjectProperty("InMasterPage", "false");
      GrideducacionContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GrideducacionContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GrideducacionContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GrideducacionContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GrideducacionContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrideducacion_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GrideducacionContainer.setPageSize( subgrideducacion_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1958( ) ;
         e216U8 ();
         wbEnd = (short)(195) ;
         wb6U0( ) ;
      }
      bGXsfl_195_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6U8( )
   {
   }

   public int subgridespecialidadsede_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridespecialidadsede_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridespecialidadsede_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridespecialidadsede_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subgridservicios_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridservicios_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridservicios_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridservicios_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subgridpremios_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridpremios_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridpremios_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridpremios_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subgridexperiencialaboral_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridexperiencialaboral_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridexperiencialaboral_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridexperiencialaboral_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subgrideducacion_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgrideducacion_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgrideducacion_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgrideducacion_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      gxvvpaisid_html6U2( ) ;
      gxvctlespecialidadid_html6U2( ) ;
      /* Using cursor H006U7 */
      pr_default.execute(4, new Object[] {AV61ProfesionalNroDocumento, AV44ProfesionalCorreo});
      if ( (pr_default.getStatus(4) != 101) )
      {
         A40000ProfesionalId = H006U7_A40000ProfesionalId[0] ;
         n40000ProfesionalId = H006U7_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
      }
      pr_default.close(4);
      /* Using cursor H006U9 */
      pr_default.execute(5, new Object[] {AV61ProfesionalNroDocumento, AV44ProfesionalCorreo});
      if ( (pr_default.getStatus(5) != 101) )
      {
         A40001SecUserId = H006U9_A40001SecUserId[0] ;
         n40001SecUserId = H006U9_n40001SecUserId[0] ;
      }
      else
      {
         A40001SecUserId = (short)(0) ;
         n40001SecUserId = false ;
      }
      pr_default.close(5);
      fix_multi_value_controls( ) ;
   }

   public void strup6U0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e256U2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvvprofesionalprovincia_html6U2( AV45ProfesionalDepartamento) ;
      gxvvprofesionaldistrito_html6U2( AV45ProfesionalDepartamento, AV63ProfesionalProvincia) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Educacionlist"), AV12EducacionList);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Experiencialaborallist"), AV18ExperienciaLaboralList);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Premioslist"), AV38PremiosList);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Servicioslist"), AV76ServiciosList);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Especialidadlist"), AV15EspecialidadList);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vUPLOADEDFILES"), AV82UploadedFiles);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFAILEDFILES"), AV19FailedFiles);
         /* Read saved values. */
         nRC_GXsfl_167 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_167"), ",", ".")) ;
         nRC_GXsfl_195 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_195"), ",", ".")) ;
         nRC_GXsfl_235 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_235"), ",", ".")) ;
         nRC_GXsfl_266 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_266"), ",", ".")) ;
         nRC_GXsfl_299 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_299"), ",", ".")) ;
         Fileuploadimagen_Autoupload = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOADIMAGEN_Autoupload")) ;
         Fileuploadimagen_Enableuploadedfilecanceling = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOADIMAGEN_Enableuploadedfilecanceling")) ;
         Fileuploadimagen_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( "FILEUPLOADIMAGEN_Maxnumberoffiles"), ",", ".")) ;
         Fileuploadimagen_Autodisableaddingfiles = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOADIMAGEN_Autodisableaddingfiles")) ;
         Fileuploadimagen_Acceptedfiletypes = httpContext.cgiGet( "FILEUPLOADIMAGEN_Acceptedfiletypes") ;
         Tabpageregistroprofesional_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TABPAGEREGISTROPROFESIONAL_Pagecount"), ",", ".")) ;
         Tabpageregistroprofesional_Class = httpContext.cgiGet( "TABPAGEREGISTROPROFESIONAL_Class") ;
         Tabpageregistroprofesional_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TABPAGEREGISTROPROFESIONAL_Historymanagement")) ;
         nRC_GXsfl_167 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_167"), ",", ".")) ;
         nGXsfl_167_fel_idx = 0 ;
         while ( nGXsfl_167_fel_idx < nRC_GXsfl_167 )
         {
            nGXsfl_167_fel_idx = ((subGridespecialidadsede_Islastpage==1)&&(nGXsfl_167_fel_idx+1>subgridespecialidadsede_fnc_recordsperpage( )) ? 1 : nGXsfl_167_fel_idx+1) ;
            sGXsfl_167_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_167_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1672( ) ;
            AV85GXV1 = nGXsfl_167_fel_idx ;
            if ( ( AV15EspecialidadList.size() >= AV85GXV1 ) && ( AV85GXV1 > 0 ) )
            {
               AV15EspecialidadList.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)) );
            }
         }
         if ( nGXsfl_167_fel_idx == 0 )
         {
            nGXsfl_167_idx = 1 ;
            sGXsfl_167_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_167_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1672( ) ;
         }
         nGXsfl_167_fel_idx = 1 ;
         nRC_GXsfl_195 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_195"), ",", ".")) ;
         nGXsfl_195_fel_idx = 0 ;
         while ( nGXsfl_195_fel_idx < nRC_GXsfl_195 )
         {
            nGXsfl_195_fel_idx = ((subGrideducacion_Islastpage==1)&&(nGXsfl_195_fel_idx+1>subgrideducacion_fnc_recordsperpage( )) ? 1 : nGXsfl_195_fel_idx+1) ;
            sGXsfl_195_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_195_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1958( ) ;
            AV89GXV5 = nGXsfl_195_fel_idx ;
            if ( ( AV12EducacionList.size() >= AV89GXV5 ) && ( AV89GXV5 > 0 ) )
            {
               AV12EducacionList.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)) );
            }
         }
         if ( nGXsfl_195_fel_idx == 0 )
         {
            nGXsfl_195_idx = 1 ;
            sGXsfl_195_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_195_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1958( ) ;
         }
         nGXsfl_195_fel_idx = 1 ;
         nRC_GXsfl_235 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_235"), ",", ".")) ;
         nGXsfl_235_fel_idx = 0 ;
         while ( nGXsfl_235_fel_idx < nRC_GXsfl_235 )
         {
            nGXsfl_235_fel_idx = ((subGridexperiencialaboral_Islastpage==1)&&(nGXsfl_235_fel_idx+1>subgridexperiencialaboral_fnc_recordsperpage( )) ? 1 : nGXsfl_235_fel_idx+1) ;
            sGXsfl_235_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2357( ) ;
            AV95GXV11 = nGXsfl_235_fel_idx ;
            if ( ( AV18ExperienciaLaboralList.size() >= AV95GXV11 ) && ( AV95GXV11 > 0 ) )
            {
               AV18ExperienciaLaboralList.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)) );
            }
         }
         if ( nGXsfl_235_fel_idx == 0 )
         {
            nGXsfl_235_idx = 1 ;
            sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2357( ) ;
         }
         nGXsfl_235_fel_idx = 1 ;
         nRC_GXsfl_266 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_266"), ",", ".")) ;
         nGXsfl_266_fel_idx = 0 ;
         while ( nGXsfl_266_fel_idx < nRC_GXsfl_266 )
         {
            nGXsfl_266_fel_idx = ((subGridpremios_Islastpage==1)&&(nGXsfl_266_fel_idx+1>subgridpremios_fnc_recordsperpage( )) ? 1 : nGXsfl_266_fel_idx+1) ;
            sGXsfl_266_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_266_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2666( ) ;
            AV100GXV16 = nGXsfl_266_fel_idx ;
            if ( ( AV38PremiosList.size() >= AV100GXV16 ) && ( AV100GXV16 > 0 ) )
            {
               AV38PremiosList.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)) );
            }
         }
         if ( nGXsfl_266_fel_idx == 0 )
         {
            nGXsfl_266_idx = 1 ;
            sGXsfl_266_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_266_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2666( ) ;
         }
         nGXsfl_266_fel_idx = 1 ;
         nRC_GXsfl_299 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_299"), ",", ".")) ;
         nGXsfl_299_fel_idx = 0 ;
         while ( nGXsfl_299_fel_idx < nRC_GXsfl_299 )
         {
            nGXsfl_299_fel_idx = ((subGridservicios_Islastpage==1)&&(nGXsfl_299_fel_idx+1>subgridservicios_fnc_recordsperpage( )) ? 1 : nGXsfl_299_fel_idx+1) ;
            sGXsfl_299_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_299_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2995( ) ;
            AV105GXV21 = nGXsfl_299_fel_idx ;
            if ( ( AV76ServiciosList.size() >= AV105GXV21 ) && ( AV105GXV21 > 0 ) )
            {
               AV76ServiciosList.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV76ServiciosList.elementAt(-1+AV105GXV21)) );
            }
         }
         if ( nGXsfl_299_fel_idx == 0 )
         {
            nGXsfl_299_idx = 1 ;
            sGXsfl_299_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_299_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2995( ) ;
         }
         nGXsfl_299_fel_idx = 1 ;
         /* Read variables values. */
         cmbavProfesionaltipodocumento.setName( cmbavProfesionaltipodocumento.getInternalname() );
         cmbavProfesionaltipodocumento.setValue( httpContext.cgiGet( cmbavProfesionaltipodocumento.getInternalname()) );
         AV68ProfesionalTipoDocumento = httpContext.cgiGet( cmbavProfesionaltipodocumento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV68ProfesionalTipoDocumento", AV68ProfesionalTipoDocumento);
         AV61ProfesionalNroDocumento = httpContext.cgiGet( edtavProfesionalnrodocumento_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV61ProfesionalNroDocumento", AV61ProfesionalNroDocumento);
         AV60ProfesionalNombres = httpContext.cgiGet( edtavProfesionalnombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV60ProfesionalNombres", AV60ProfesionalNombres);
         AV41ProfesionalApellidoPaterno = httpContext.cgiGet( edtavProfesionalapellidopaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41ProfesionalApellidoPaterno", AV41ProfesionalApellidoPaterno);
         AV40ProfesionalApellidoMaterno = httpContext.cgiGet( edtavProfesionalapellidomaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40ProfesionalApellidoMaterno", AV40ProfesionalApellidoMaterno);
         cmbavProfesionalsexo.setName( cmbavProfesionalsexo.getInternalname() );
         cmbavProfesionalsexo.setValue( httpContext.cgiGet( cmbavProfesionalsexo.getInternalname()) );
         AV64ProfesionalSexo = httpContext.cgiGet( cmbavProfesionalsexo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64ProfesionalSexo", AV64ProfesionalSexo);
         cmbavProfesionaldia.setName( cmbavProfesionaldia.getInternalname() );
         cmbavProfesionaldia.setValue( httpContext.cgiGet( cmbavProfesionaldia.getInternalname()) );
         AV47ProfesionalDia = (short)(GXutil.lval( httpContext.cgiGet( cmbavProfesionaldia.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47ProfesionalDia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47ProfesionalDia), 4, 0));
         cmbavProfesionalmes.setName( cmbavProfesionalmes.getInternalname() );
         cmbavProfesionalmes.setValue( httpContext.cgiGet( cmbavProfesionalmes.getInternalname()) );
         AV59ProfesionalMes = httpContext.cgiGet( cmbavProfesionalmes.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59ProfesionalMes", AV59ProfesionalMes);
         cmbavProfesionalanio.setName( cmbavProfesionalanio.getInternalname() );
         cmbavProfesionalanio.setValue( httpContext.cgiGet( cmbavProfesionalanio.getInternalname()) );
         AV39ProfesionalAnio = (short)(GXutil.lval( httpContext.cgiGet( cmbavProfesionalanio.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39ProfesionalAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39ProfesionalAnio), 4, 0));
         AV43ProfesionalCOP = httpContext.cgiGet( edtavProfesionalcop_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43ProfesionalCOP", AV43ProfesionalCOP);
         AV46ProfesionalDescripcion = httpContext.cgiGet( edtavProfesionaldescripcion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46ProfesionalDescripcion", AV46ProfesionalDescripcion);
         dynavPaisid.setName( dynavPaisid.getInternalname() );
         dynavPaisid.setValue( httpContext.cgiGet( dynavPaisid.getInternalname()) );
         AV34PaisId = (short)(GXutil.lval( httpContext.cgiGet( dynavPaisid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34PaisId), 4, 0));
         AV65ProfesionalTelefono = httpContext.cgiGet( edtavProfesionaltelefono_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ProfesionalTelefono", AV65ProfesionalTelefono);
         cmbavProfesionaltiempocita.setName( cmbavProfesionaltiempocita.getInternalname() );
         cmbavProfesionaltiempocita.setValue( httpContext.cgiGet( cmbavProfesionaltiempocita.getInternalname()) );
         AV67ProfesionalTiempoCita = (byte)(GXutil.lval( httpContext.cgiGet( cmbavProfesionaltiempocita.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV67ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67ProfesionalTiempoCita), 2, 0));
         AV51ProfesionalFacebook = httpContext.cgiGet( edtavProfesionalfacebook_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51ProfesionalFacebook", AV51ProfesionalFacebook);
         AV58ProfesionalLinkedin = httpContext.cgiGet( edtavProfesionallinkedin_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58ProfesionalLinkedin", AV58ProfesionalLinkedin);
         AV69ProfesionalTwitter = httpContext.cgiGet( edtavProfesionaltwitter_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV69ProfesionalTwitter", AV69ProfesionalTwitter);
         AV57ProfesionalInstagram = httpContext.cgiGet( edtavProfesionalinstagram_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV57ProfesionalInstagram", AV57ProfesionalInstagram);
         AV48ProfesionalDireccion = httpContext.cgiGet( edtavProfesionaldireccion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48ProfesionalDireccion", AV48ProfesionalDireccion);
         cmbavProfesionaldepartamento.setName( cmbavProfesionaldepartamento.getInternalname() );
         cmbavProfesionaldepartamento.setValue( httpContext.cgiGet( cmbavProfesionaldepartamento.getInternalname()) );
         AV45ProfesionalDepartamento = httpContext.cgiGet( cmbavProfesionaldepartamento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45ProfesionalDepartamento", AV45ProfesionalDepartamento);
         dynavProfesionalprovincia.setName( dynavProfesionalprovincia.getInternalname() );
         dynavProfesionalprovincia.setValue( httpContext.cgiGet( dynavProfesionalprovincia.getInternalname()) );
         AV63ProfesionalProvincia = httpContext.cgiGet( dynavProfesionalprovincia.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63ProfesionalProvincia", AV63ProfesionalProvincia);
         dynavProfesionaldistrito.setName( dynavProfesionaldistrito.getInternalname() );
         dynavProfesionaldistrito.setValue( httpContext.cgiGet( dynavProfesionaldistrito.getInternalname()) );
         AV49ProfesionalDistrito = httpContext.cgiGet( dynavProfesionaldistrito.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49ProfesionalDistrito", AV49ProfesionalDistrito);
         AV44ProfesionalCorreo = httpContext.cgiGet( edtavProfesionalcorreo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44ProfesionalCorreo", AV44ProfesionalCorreo);
         AV62ProfesionalPassword = httpContext.cgiGet( edtavProfesionalpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV62ProfesionalPassword", AV62ProfesionalPassword);
         AV66ProfesionalTerminosCondiciones = GXutil.strtobool( httpContext.cgiGet( chkavProfesionalterminoscondiciones.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66ProfesionalTerminosCondiciones", AV66ProfesionalTerminosCondiciones);
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
      e256U2 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e256U2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/RegistroProfesional.css\" type=\"text/css\">" );
      Form.getJscriptsrc().add("sweetalert2.all.min.js") ;
      Form.getJscriptsrc().add("SweetAlert2.js") ;
      Form.getJscriptsrc().add("ActualizarPagina.js") ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/bootstrap-4.min.css\" type=\"text/css\">" );
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/sweetalert2.min.css\" type=\"text/css\">" );
      this.executeExternalObjectMethod("", false, "AV9ActualizarPagina", "ActualizarPagina", new Object[] {Integer.valueOf(1)}, false);
      edtavProfesionalfacebook_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalfacebook_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalfacebook_Visible), 5, 0), true);
      edtavProfesionaltwitter_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionaltwitter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionaltwitter_Visible), 5, 0), true);
      edtavProfesionallinkedin_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionallinkedin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionallinkedin_Visible), 5, 0), true);
      edtavProfesionalinstagram_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalinstagram_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalinstagram_Visible), 5, 0), true);
      /* Using cursor H006U10 */
      pr_default.execute(6);
      while ( (pr_default.getStatus(6) != 101) )
      {
         A186UbigeoDepartamento = H006U10_A186UbigeoDepartamento[0] ;
         A295UbigeoDepartamentoCode = H006U10_A295UbigeoDepartamentoCode[0] ;
         A44UbigeoCode = H006U10_A44UbigeoCode[0] ;
         cmbavProfesionaldepartamento.addItem(A295UbigeoDepartamentoCode, A186UbigeoDepartamento, (short)(0));
         pr_default.readNext(6);
      }
      pr_default.close(6);
      AV24i = (short)(GXutil.year( GXutil.addyr( Gx_date, (short)(-18)))) ;
      cmbavProfesionalanio.removeAllItems();
      while ( AV24i > GXutil.year( GXutil.addyr( Gx_date, (short)(-18))) - 92 )
      {
         cmbavProfesionalanio.addItem(GXutil.trim( GXutil.str( AV24i, 4, 0)), GXutil.str( AV24i, 10, 0), (short)(0));
         AV24i = (short)(AV24i-1) ;
      }
      /* Execute user subroutine: 'SHOWDAYS' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         returnInSub = true;
         if (true) return;
      }
      AV66ProfesionalTerminosCondiciones = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66ProfesionalTerminosCondiciones", AV66ProfesionalTerminosCondiciones);
      AV22HtmlTerminosCondiciones = "<span style=\"font-family: Poppins, sans-serif;\">Acepto el tratamiento de mis datos personales para los servicios de Teleorientación Médica y Telemonitoreo. <a href=\"" + formatLink("com.projectthani.terminoscondicionesproveedor", new String[] {}, new String[] {})  + "\" target=\"_blank\"> Términos y Condiciones </a></span>" ;
      lblTextblocktercond_Caption = AV22HtmlTerminosCondiciones ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktercond_Internalname, "Caption", lblTextblocktercond_Caption, true);
      AV36Pattern = "^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36Pattern", AV36Pattern);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPATTERN", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV36Pattern, ""))));
      AV30NewEspecialidad = (com.projectthani.SdtSDTProfesionalEspecialidadSede)new com.projectthani.SdtSDTProfesionalEspecialidadSede(remoteHandle, context);
      AV15EspecialidadList.add(AV30NewEspecialidad, 0);
      gx_BV167 = true ;
      AV29NewEducacion = (com.projectthani.SdtSDTProfesionalEducacion)new com.projectthani.SdtSDTProfesionalEducacion(remoteHandle, context);
      AV12EducacionList.add(AV29NewEducacion, 0);
      gx_BV195 = true ;
      AV31NewExperienciaLaboral = (com.projectthani.SdtSDTProfesionalExperienciaLaboral)new com.projectthani.SdtSDTProfesionalExperienciaLaboral(remoteHandle, context);
      AV18ExperienciaLaboralList.add(AV31NewExperienciaLaboral, 0);
      gx_BV235 = true ;
      AV33NewServicios = (com.projectthani.SdtSDTProfesionalServicios)new com.projectthani.SdtSDTProfesionalServicios(remoteHandle, context);
      AV76ServiciosList.add(AV33NewServicios, 0);
      gx_BV299 = true ;
      AV32NewPremios = (com.projectthani.SdtSDTProfesionalPremios)new com.projectthani.SdtSDTProfesionalPremios(remoteHandle, context);
      AV38PremiosList.add(AV32NewPremios, 0);
      gx_BV266 = true ;
   }

   public void e126U2( )
   {
      /* Profesionalanio_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SHOWDAYS' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         returnInSub = true;
         if (true) return;
      }
      /*  Sending Event outputs  */
      cmbavProfesionaldia.setValue( GXutil.trim( GXutil.str( AV47ProfesionalDia, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaldia.getInternalname(), "Values", cmbavProfesionaldia.ToJavascriptSource(), true);
   }

   public void e136U2( )
   {
      /* Profesionalmes_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SHOWDAYS' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         returnInSub = true;
         if (true) return;
      }
      AV47ProfesionalDia = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47ProfesionalDia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47ProfesionalDia), 4, 0));
      /*  Sending Event outputs  */
      cmbavProfesionaldia.setValue( GXutil.trim( GXutil.str( AV47ProfesionalDia, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaldia.getInternalname(), "Values", cmbavProfesionaldia.ToJavascriptSource(), true);
   }

   public void S112( )
   {
      /* 'SHOWDAYS' Routine */
      returnInSub = false ;
      AV78TempFechaNac = localUtil.ymdtod( AV39ProfesionalAnio, (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV59ProfesionalMes, "."))), 1) ;
      AV24i = (short)(1) ;
      cmbavProfesionaldia.removeAllItems();
      while ( AV24i <= GXutil.day( GXutil.eomdate( AV78TempFechaNac)) )
      {
         cmbavProfesionaldia.addItem(GXutil.trim( GXutil.str( AV24i, 4, 0)), GXutil.str( AV24i, 10, 0), (short)(0));
         AV24i = (short)(AV24i+1) ;
      }
   }

   public void e146U2( )
   {
      AV89GXV5 = nGXsfl_195_idx ;
      if ( AV12EducacionList.size() >= AV89GXV5 )
      {
         AV12EducacionList.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)) );
      }
      AV95GXV11 = nGXsfl_235_idx ;
      if ( AV18ExperienciaLaboralList.size() >= AV95GXV11 )
      {
         AV18ExperienciaLaboralList.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)) );
      }
      AV100GXV16 = nGXsfl_266_idx ;
      if ( AV38PremiosList.size() >= AV100GXV16 )
      {
         AV38PremiosList.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)) );
      }
      AV105GXV21 = nGXsfl_299_idx ;
      if ( AV76ServiciosList.size() >= AV105GXV21 )
      {
         AV76ServiciosList.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV76ServiciosList.elementAt(-1+AV105GXV21)) );
      }
      AV85GXV1 = nGXsfl_167_idx ;
      if ( AV15EspecialidadList.size() >= AV85GXV1 )
      {
         AV15EspecialidadList.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)) );
      }
      /* 'GuardarProfesional' Routine */
      returnInSub = false ;
      /* Using cursor H006U12 */
      pr_default.execute(7, new Object[] {AV61ProfesionalNroDocumento, AV44ProfesionalCorreo});
      if ( (pr_default.getStatus(7) != 101) )
      {
         A40000ProfesionalId = H006U12_A40000ProfesionalId[0] ;
         n40000ProfesionalId = H006U12_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
      }
      pr_default.close(7);
      /* Using cursor H006U14 */
      pr_default.execute(8, new Object[] {AV61ProfesionalNroDocumento, AV44ProfesionalCorreo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         A40001SecUserId = H006U14_A40001SecUserId[0] ;
         n40001SecUserId = H006U14_n40001SecUserId[0] ;
      }
      else
      {
         A40001SecUserId = (short)(0) ;
         n40001SecUserId = false ;
      }
      pr_default.close(8);
      AV81UbigeoCode = AV45ProfesionalDepartamento + AV63ProfesionalProvincia + AV49ProfesionalDistrito ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81UbigeoCode", AV81UbigeoCode);
      AV52ProfesionalFechaNacimiento = localUtil.ymdtod( AV39ProfesionalAnio, (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV59ProfesionalMes, "."))), AV47ProfesionalDia) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52ProfesionalFechaNacimiento", localUtil.format(AV52ProfesionalFechaNacimiento, "99/99/9999"));
      AV25Mensaje.clear();
      if ( ( GXutil.strcmp(GXutil.trim( AV41ProfesionalApellidoPaterno), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV40ProfesionalApellidoMaterno), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV44ProfesionalCorreo), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV43ProfesionalCOP), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV60ProfesionalNombres), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV61ProfesionalNroDocumento), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV68ProfesionalTipoDocumento), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV64ProfesionalSexo), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV65ProfesionalTelefono), "") == 0 ) )
      {
         AV25Mensaje.add("Todos los datos son obligatorios", 0);
      }
      else
      {
         if ( GXutil.strcmp(AV68ProfesionalTipoDocumento, "1") == 0 )
         {
            if ( GXutil.len( GXutil.trim( AV61ProfesionalNroDocumento)) != 8 )
            {
               AV25Mensaje.add("Ingrese un número de DNI correcto", 0);
            }
            if ( CommonUtil.decimalVal( GXutil.trim( AV61ProfesionalNroDocumento), ".").doubleValue() == 0 )
            {
               AV25Mensaje.add("El número de DNI ingresado no es correcto", 0);
            }
         }
         else
         {
            if ( GXutil.len( GXutil.trim( AV61ProfesionalNroDocumento)) < 8 )
            {
               AV25Mensaje.add("Ingrese un número de documento correcto", 0);
            }
         }
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV52ProfesionalFechaNacimiento)) )
         {
            AV25Mensaje.add("Debe seleccionar su fecha de nacimiento", 0);
         }
         GXt_dtime1 = GXutil.resetTime( AV52ProfesionalFechaNacimiento );
         if ( GXutil.age( GXt_dtime1, GXutil.now( )) < 18 )
         {
            AV25Mensaje.add("Debe ser mayor de 18 años", 0);
         }
         if ( (GXutil.strcmp("", AV62ProfesionalPassword)==0) )
         {
            AV25Mensaje.add("Debe ingresar su contraseña", 0);
         }
         if ( (GXutil.strcmp("", AV45ProfesionalDepartamento)==0) )
         {
            AV25Mensaje.add("Debe seleccionar un país del listado", 0);
         }
         if ( ( GXutil.len( AV81UbigeoCode) != 6 ) && ( AV34PaisId == 28 ) )
         {
            AV25Mensaje.add("Debe seleccionar un distrito del listado", 0);
         }
         if ( ! GxRegex.IsMatch(AV44ProfesionalCorreo,AV36Pattern) )
         {
            AV25Mensaje.add("Debe ingresar un correo electrónico válido", 0);
         }
         if ( ! AV66ProfesionalTerminosCondiciones )
         {
            AV25Mensaje.add("Debe aceptar los términos y condiciones", 0);
         }
         if ( ( A40000ProfesionalId > 0 ) && ( GXutil.strcmp(GXutil.trim( AV61ProfesionalNroDocumento), "") != 0 ) )
         {
            AV25Mensaje.add("Ya existe un usuario con los datos ingresados. Por favor inicie sesión", 0);
         }
         else
         {
            if ( ( A40001SecUserId > 0 ) && ( GXutil.strcmp(GXutil.trim( AV61ProfesionalNroDocumento), "") != 0 ) )
            {
               AV25Mensaje.add("Ya existe un usuario con los datos ingresados. Por favor inicie sesión", 0);
            }
         }
         if ( AV82UploadedFiles.size() <= 0 )
         {
            AV25Mensaje.add("Debe adjuntar una fotografía para el perfil.", 0);
         }
      }
      if ( AV25Mensaje.size() > 0 )
      {
         /* Execute user subroutine: 'SHOWMESSAGES' */
         S122 ();
         if ( returnInSub )
         {
            pr_default.close(8);
            pr_default.close(7);
            returnInSub = true;
            if (true) return;
         }
      }
      else
      {
         /* Execute user subroutine: 'GETPROFESIONAL' */
         S132 ();
         if ( returnInSub )
         {
            pr_default.close(8);
            pr_default.close(7);
            returnInSub = true;
            if (true) return;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25Mensaje", AV25Mensaje);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6SecUser", AV6SecUser);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7SecUserRole", AV7SecUserRole);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5Profesional", AV5Profesional);
   }

   public void S132( )
   {
      /* 'GETPROFESIONAL' Routine */
      returnInSub = false ;
      AV6SecUser.setgxTv_SdtSecUser_Secusername( GXutil.trim( AV61ProfesionalNroDocumento) );
      AV6SecUser.setgxTv_SdtSecUser_Secuseremail( GXutil.trim( AV44ProfesionalCorreo) );
      AV6SecUser.setgxTv_SdtSecUser_Secuserpassword( GXutil.trim( AV62ProfesionalPassword) );
      AV6SecUser.Save();
      if ( AV6SecUser.Success() )
      {
         AV7SecUserRole.setgxTv_SdtSecUserRole_Secuserid( AV6SecUser.getgxTv_SdtSecUser_Secuserid() );
         /* Using cursor H006U15 */
         pr_default.execute(9);
         while ( (pr_default.getStatus(9) != 101) )
         {
            A13SecRoleName = H006U15_A13SecRoleName[0] ;
            A4SecRoleId = H006U15_A4SecRoleId[0] ;
            AV7SecUserRole.setgxTv_SdtSecUserRole_Secroleid( A4SecRoleId );
            pr_default.readNext(9);
         }
         pr_default.close(9);
         AV7SecUserRole.Save();
         AV5Profesional.setgxTv_SdtProfesional_Profesionalnombres( AV60ProfesionalNombres );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalapellidopaterno( AV41ProfesionalApellidoPaterno );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalapellidomaterno( AV40ProfesionalApellidoMaterno );
         AV5Profesional.setgxTv_SdtProfesional_Profesionaltipodocumento( AV68ProfesionalTipoDocumento );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalnrodocumento( GXutil.trim( AV61ProfesionalNroDocumento) );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalfechanacimiento( AV52ProfesionalFechaNacimiento );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalsexo( AV64ProfesionalSexo );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalcorreo( AV44ProfesionalCorreo );
         AV5Profesional.setgxTv_SdtProfesional_Profesionaldireccion( AV48ProfesionalDireccion );
         AV5Profesional.setgxTv_SdtProfesional_Profesionaldescripcion( AV46ProfesionalDescripcion );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalcolorcita( "#376A4A" );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalcolordisponible( "#8CE1B3" );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalcop( AV43ProfesionalCOP );
         AV5Profesional.setgxTv_SdtProfesional_Profesionaltiempocita( AV67ProfesionalTiempoCita );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalfecharegistro( Gx_date );
         AV5Profesional.setgxTv_SdtProfesional_Profesionaltelefono( AV65ProfesionalTelefono );
         AV5Profesional.setgxTv_SdtProfesional_Paisid( AV34PaisId );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalestado( "P" );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalestadocuenta( "CP" );
         AV5Profesional.setgxTv_SdtProfesional_Secuserid( AV6SecUser.getgxTv_SdtSecUser_Secuserid() );
         AV5Profesional.setgxTv_SdtProfesional_Ubigeocode( AV81UbigeoCode );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalfacebook( AV51ProfesionalFacebook );
         AV5Profesional.setgxTv_SdtProfesional_Profesionaltwitter( AV69ProfesionalTwitter );
         AV5Profesional.setgxTv_SdtProfesional_Profesionallinkedin( AV58ProfesionalLinkedin );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalinstagram( AV57ProfesionalInstagram );
         AV5Profesional.setgxTv_SdtProfesional_Profesionalterminoscondiciones( AV66ProfesionalTerminosCondiciones );
         if ( AV82UploadedFiles.size() > 0 )
         {
            AV5Profesional.setgxTv_SdtProfesional_Profesionalfoto( ((com.projectthani.SdtFileUploadData)AV82UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_File() );
            AV5Profesional.setgxTv_SdtProfesional_Profesionalfoto_gxi( com.genexus.GXDbFile.getUriFromFile( "", "", ((com.projectthani.SdtFileUploadData)AV82UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_File()) );
         }
         /* Start For Each Line in Grideducacion */
         nRC_GXsfl_195 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_195"), ",", ".")) ;
         nGXsfl_195_fel_idx = 0 ;
         while ( nGXsfl_195_fel_idx < nRC_GXsfl_195 )
         {
            nGXsfl_195_fel_idx = ((subGrideducacion_Islastpage==1)&&(nGXsfl_195_fel_idx+1>subgrideducacion_fnc_recordsperpage( )) ? 1 : nGXsfl_195_fel_idx+1) ;
            sGXsfl_195_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_195_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1958( ) ;
            AV89GXV5 = nGXsfl_195_fel_idx ;
            if ( ( AV12EducacionList.size() >= AV89GXV5 ) && ( AV89GXV5 > 0 ) )
            {
               AV12EducacionList.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)) );
            }
            if ( ! (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalEducacion)(AV12EducacionList.currentItem())).getgxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion())==0) )
            {
               AV11Educacion = (com.projectthani.SdtProfesional_Educacion)new com.projectthani.SdtProfesional_Educacion( remoteHandle, context);
               AV11Educacion.setgxTv_SdtProfesional_Educacion_Educacionid( java.util.UUID.randomUUID( ) );
               AV11Educacion.setgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion( ((com.projectthani.SdtSDTProfesionalEducacion)(AV12EducacionList.currentItem())).getgxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion() );
               AV11Educacion.setgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion( ((com.projectthani.SdtSDTProfesionalEducacion)(AV12EducacionList.currentItem())).getgxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion() );
               AV11Educacion.setgxTv_SdtProfesional_Educacion_Educaciondesde( ((com.projectthani.SdtSDTProfesionalEducacion)(AV12EducacionList.currentItem())).getgxTv_SdtSDTProfesionalEducacion_Educaciondesde() );
               AV11Educacion.setgxTv_SdtProfesional_Educacion_Educacionhasta( ((com.projectthani.SdtSDTProfesionalEducacion)(AV12EducacionList.currentItem())).getgxTv_SdtSDTProfesionalEducacion_Educacionhasta() );
               AV5Profesional.getgxTv_SdtProfesional_Educacion().add(AV11Educacion, 0);
            }
            /* End For Each Line */
         }
         if ( nGXsfl_195_fel_idx == 0 )
         {
            nGXsfl_195_idx = 1 ;
            sGXsfl_195_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_195_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1958( ) ;
         }
         nGXsfl_195_fel_idx = 1 ;
         /* Start For Each Line in Gridexperiencialaboral */
         nRC_GXsfl_235 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_235"), ",", ".")) ;
         nGXsfl_235_fel_idx = 0 ;
         while ( nGXsfl_235_fel_idx < nRC_GXsfl_235 )
         {
            nGXsfl_235_fel_idx = ((subGridexperiencialaboral_Islastpage==1)&&(nGXsfl_235_fel_idx+1>subgridexperiencialaboral_fnc_recordsperpage( )) ? 1 : nGXsfl_235_fel_idx+1) ;
            sGXsfl_235_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2357( ) ;
            AV95GXV11 = nGXsfl_235_fel_idx ;
            if ( ( AV18ExperienciaLaboralList.size() >= AV95GXV11 ) && ( AV95GXV11 > 0 ) )
            {
               AV18ExperienciaLaboralList.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)) );
            }
            if ( ! (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)(AV18ExperienciaLaboralList.currentItem())).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre())==0) )
            {
               AV17ExperienciaLaboral = (com.projectthani.SdtProfesional_ExperienciaLaboral)new com.projectthani.SdtProfesional_ExperienciaLaboral( remoteHandle, context);
               AV17ExperienciaLaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid( java.util.UUID.randomUUID( ) );
               AV17ExperienciaLaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)(AV18ExperienciaLaboralList.currentItem())).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre() );
               AV17ExperienciaLaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)(AV18ExperienciaLaboralList.currentItem())).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde() );
               AV17ExperienciaLaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)(AV18ExperienciaLaboralList.currentItem())).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta() );
               AV5Profesional.getgxTv_SdtProfesional_Experiencialaboral().add(AV17ExperienciaLaboral, 0);
            }
            /* End For Each Line */
         }
         if ( nGXsfl_235_fel_idx == 0 )
         {
            nGXsfl_235_idx = 1 ;
            sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2357( ) ;
         }
         nGXsfl_235_fel_idx = 1 ;
         /* Start For Each Line in Gridpremios */
         nRC_GXsfl_266 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_266"), ",", ".")) ;
         nGXsfl_266_fel_idx = 0 ;
         while ( nGXsfl_266_fel_idx < nRC_GXsfl_266 )
         {
            nGXsfl_266_fel_idx = ((subGridpremios_Islastpage==1)&&(nGXsfl_266_fel_idx+1>subgridpremios_fnc_recordsperpage( )) ? 1 : nGXsfl_266_fel_idx+1) ;
            sGXsfl_266_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_266_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2666( ) ;
            AV100GXV16 = nGXsfl_266_fel_idx ;
            if ( ( AV38PremiosList.size() >= AV100GXV16 ) && ( AV100GXV16 > 0 ) )
            {
               AV38PremiosList.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)) );
            }
            if ( ! (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalPremios)(AV38PremiosList.currentItem())).getgxTv_SdtSDTProfesionalPremios_Premiosnombre())==0) )
            {
               AV37Premios = (com.projectthani.SdtProfesional_Premios)new com.projectthani.SdtProfesional_Premios( remoteHandle, context);
               AV37Premios.setgxTv_SdtProfesional_Premios_Premiosid( java.util.UUID.randomUUID( ) );
               AV37Premios.setgxTv_SdtProfesional_Premios_Premiosnombre( ((com.projectthani.SdtSDTProfesionalPremios)(AV38PremiosList.currentItem())).getgxTv_SdtSDTProfesionalPremios_Premiosnombre() );
               AV37Premios.setgxTv_SdtProfesional_Premios_Premiosdescripcion( ((com.projectthani.SdtSDTProfesionalPremios)(AV38PremiosList.currentItem())).getgxTv_SdtSDTProfesionalPremios_Premiosdescripcion() );
               AV37Premios.setgxTv_SdtProfesional_Premios_Premiosfecha( ((com.projectthani.SdtSDTProfesionalPremios)(AV38PremiosList.currentItem())).getgxTv_SdtSDTProfesionalPremios_Premiosfecha() );
               AV5Profesional.getgxTv_SdtProfesional_Premios().add(AV37Premios, 0);
            }
            /* End For Each Line */
         }
         if ( nGXsfl_266_fel_idx == 0 )
         {
            nGXsfl_266_idx = 1 ;
            sGXsfl_266_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_266_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2666( ) ;
         }
         nGXsfl_266_fel_idx = 1 ;
         /* Start For Each Line in Gridservicios */
         nRC_GXsfl_299 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_299"), ",", ".")) ;
         nGXsfl_299_fel_idx = 0 ;
         while ( nGXsfl_299_fel_idx < nRC_GXsfl_299 )
         {
            nGXsfl_299_fel_idx = ((subGridservicios_Islastpage==1)&&(nGXsfl_299_fel_idx+1>subgridservicios_fnc_recordsperpage( )) ? 1 : nGXsfl_299_fel_idx+1) ;
            sGXsfl_299_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_299_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2995( ) ;
            AV105GXV21 = nGXsfl_299_fel_idx ;
            if ( ( AV76ServiciosList.size() >= AV105GXV21 ) && ( AV105GXV21 > 0 ) )
            {
               AV76ServiciosList.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV76ServiciosList.elementAt(-1+AV105GXV21)) );
            }
            if ( ! (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalServicios)(AV76ServiciosList.currentItem())).getgxTv_SdtSDTProfesionalServicios_Serviciosnombre())==0) )
            {
               AV75Servicios = (com.projectthani.SdtProfesional_Servicios)new com.projectthani.SdtProfesional_Servicios( remoteHandle, context);
               AV75Servicios.setgxTv_SdtProfesional_Servicios_Serviciosid( java.util.UUID.randomUUID( ) );
               AV75Servicios.setgxTv_SdtProfesional_Servicios_Serviciosnombre( ((com.projectthani.SdtSDTProfesionalServicios)(AV76ServiciosList.currentItem())).getgxTv_SdtSDTProfesionalServicios_Serviciosnombre() );
               AV5Profesional.getgxTv_SdtProfesional_Servicios().add(AV75Servicios, 0);
            }
            /* End For Each Line */
         }
         if ( nGXsfl_299_fel_idx == 0 )
         {
            nGXsfl_299_idx = 1 ;
            sGXsfl_299_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_299_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2995( ) ;
         }
         nGXsfl_299_fel_idx = 1 ;
         AV5Profesional.Save();
         if ( AV5Profesional.Success() )
         {
            AV8WebSession.destroy();
            Application.commitDataStores(context, remoteHandle, pr_default, "wpmiperfilprofesional");
            this.executeExternalObjectMethod("", false, "AV9ActualizarPagina", "ActualizarPagina", new Object[] {Integer.valueOf(2)}, false);
            AV28MsgSuccss = "Para finalizar el registro se le envió un correo de confirmación a la siguiente dirección:<b> " + AV5Profesional.getgxTv_SdtProfesional_Profesionalcorreo() + "</b>, en caso de no visualizar dicho correo en su bandeja de entrada, verificar la bandeja de correos no deseados." ;
            this.executeExternalObjectMethod("", false, "AV77SweetAlert2", "Alert", new Object[] {"success","Sus datos se registraron correctamente.",AV28MsgSuccss,""}, false);
            /* Start For Each Line in Gridespecialidadsede */
            nRC_GXsfl_167 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_167"), ",", ".")) ;
            nGXsfl_167_fel_idx = 0 ;
            while ( nGXsfl_167_fel_idx < nRC_GXsfl_167 )
            {
               nGXsfl_167_fel_idx = ((subGridespecialidadsede_Islastpage==1)&&(nGXsfl_167_fel_idx+1>subgridespecialidadsede_fnc_recordsperpage( )) ? 1 : nGXsfl_167_fel_idx+1) ;
               sGXsfl_167_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_167_fel_idx), 4, 0), (short)(4), "0") ;
               subsflControlProps_fel_1672( ) ;
               AV85GXV1 = nGXsfl_167_fel_idx ;
               if ( ( AV15EspecialidadList.size() >= AV85GXV1 ) && ( AV85GXV1 > 0 ) )
               {
                  AV15EspecialidadList.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)) );
               }
               if ( ! (0==((com.projectthani.SdtSDTProfesionalEspecialidadSede)(AV15EspecialidadList.currentItem())).getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid()) )
               {
                  AV74SedeId = (short)(1) ;
                  new com.projectthani.prcinsertprofesionalespecialidad(remoteHandle, context).execute( AV5Profesional.getgxTv_SdtProfesional_Profesionalid(), ((com.projectthani.SdtSDTProfesionalEspecialidadSede)(AV15EspecialidadList.currentItem())).getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid(), AV74SedeId, ((com.projectthani.SdtSDTProfesionalEspecialidadSede)(AV15EspecialidadList.currentItem())).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta(), ((com.projectthani.SdtSDTProfesionalEspecialidadSede)(AV15EspecialidadList.currentItem())).getgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta()) ;
               }
               /* End For Each Line */
            }
            if ( nGXsfl_167_fel_idx == 0 )
            {
               nGXsfl_167_idx = 1 ;
               sGXsfl_167_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_167_idx), 4, 0), (short)(4), "0") ;
               subsflControlProps_1672( ) ;
            }
            nGXsfl_167_fel_idx = 1 ;
            new com.projectthani.prcactivarcuentaprofesional(remoteHandle, context).execute( AV5Profesional.getgxTv_SdtProfesional_Profesionalid()) ;
            callWebObject(formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            Application.rollbackDataStores(context, remoteHandle, pr_default, "wpmiperfilprofesional");
            httpContext.GX_msglist.addItem("Ocurrió un error, por favor intente nuevamente");
         }
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wpmiperfilprofesional");
         httpContext.GX_msglist.addItem("Ocurrió un error, por favor intente nuevamente");
      }
   }

   public void S122( )
   {
      /* 'SHOWMESSAGES' Routine */
      returnInSub = false ;
      AV79textoMensaj = "" ;
      AV116GXV24 = 1 ;
      while ( AV116GXV24 <= AV25Mensaje.size() )
      {
         AV26Mensajei = (String)AV25Mensaje.elementAt(-1+AV116GXV24) ;
         AV79textoMensaj += "&#10060; " + AV26Mensajei + GXutil.newLine( ) ;
         AV116GXV24 = (int)(AV116GXV24+1) ;
      }
      httpContext.GX_msglist.addItem(AV79textoMensaj);
   }

   public void e156U2( )
   {
      /* Profesionalnrodocumento_Controlvaluechanged Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV68ProfesionalTipoDocumento, "1") == 0 )
      {
         AV72SDTResponseDni = (com.projectthani.SdtSDTResponseDni)new com.projectthani.SdtSDTResponseDni(remoteHandle, context);
         GXv_int2[0] = AV23httpstatus ;
         GXv_char3[0] = AV70result ;
         new com.projectthani.consultareniec(remoteHandle, context).execute( AV61ProfesionalNroDocumento, GXv_int2, GXv_char3, "Content-Type", "application/json") ;
         wpmiperfilprofesional_impl.this.AV23httpstatus = (short)((short)(GXv_int2[0])) ;
         wpmiperfilprofesional_impl.this.AV70result = GXv_char3[0] ;
         AV73SDTResponseWSDni.fromJSonString(AV70result, null);
         AV72SDTResponseDni = AV73SDTResponseWSDni.getgxTv_SdtSDTResponseWSDni_Data();
         if ( ! (GXutil.strcmp("", AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_materno())==0) )
         {
            AV40ProfesionalApellidoMaterno = AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_materno() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40ProfesionalApellidoMaterno", AV40ProfesionalApellidoMaterno);
         }
         if ( ! (GXutil.strcmp("", AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_paterno())==0) )
         {
            AV41ProfesionalApellidoPaterno = AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_paterno() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41ProfesionalApellidoPaterno", AV41ProfesionalApellidoPaterno);
         }
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento())) )
         {
            AV47ProfesionalDia = (short)(GXutil.day( AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47ProfesionalDia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47ProfesionalDia), 4, 0));
            AV39ProfesionalAnio = (short)(GXutil.year( AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39ProfesionalAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39ProfesionalAnio), 4, 0));
            AV27MesTemporal = "" ;
            if ( GXutil.month( AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento()) < 10 )
            {
               AV27MesTemporal = "0" ;
            }
            AV27MesTemporal += GXutil.trim( GXutil.str( GXutil.month( AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento()), 10, 0)) ;
            AV59ProfesionalMes = AV27MesTemporal ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59ProfesionalMes", AV59ProfesionalMes);
            /* Execute user subroutine: 'SHOWDAYS' */
            S112 ();
            if ( returnInSub )
            {
               pr_default.close(8);
               pr_default.close(7);
               returnInSub = true;
               if (true) return;
            }
         }
         if ( ! (GXutil.strcmp("", AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Nombres())==0) )
         {
            AV60ProfesionalNombres = AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Nombres() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60ProfesionalNombres", AV60ProfesionalNombres);
         }
         if ( ! (GXutil.strcmp("", AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Sexo())==0) )
         {
            if ( GXutil.strcmp(GXutil.charAt( AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Sexo(), 1), "M") == 0 )
            {
               AV64ProfesionalSexo = "M" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV64ProfesionalSexo", AV64ProfesionalSexo);
            }
            if ( GXutil.strcmp(GXutil.charAt( AV72SDTResponseDni.getgxTv_SdtSDTResponseDni_Sexo(), 1), "F") == 0 )
            {
               AV64ProfesionalSexo = "F" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV64ProfesionalSexo", AV64ProfesionalSexo);
            }
         }
      }
      /*  Sending Event outputs  */
      cmbavProfesionaldia.setValue( GXutil.trim( GXutil.str( AV47ProfesionalDia, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaldia.getInternalname(), "Values", cmbavProfesionaldia.ToJavascriptSource(), true);
      cmbavProfesionalanio.setValue( GXutil.trim( GXutil.str( AV39ProfesionalAnio, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalanio.getInternalname(), "Values", cmbavProfesionalanio.ToJavascriptSource(), true);
      cmbavProfesionalmes.setValue( GXutil.rtrim( AV59ProfesionalMes) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalmes.getInternalname(), "Values", cmbavProfesionalmes.ToJavascriptSource(), true);
      cmbavProfesionalsexo.setValue( GXutil.rtrim( AV64ProfesionalSexo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalsexo.getInternalname(), "Values", cmbavProfesionalsexo.ToJavascriptSource(), true);
   }

   public void e166U2( )
   {
      AV89GXV5 = nGXsfl_195_idx ;
      if ( AV12EducacionList.size() >= AV89GXV5 )
      {
         AV12EducacionList.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)) );
      }
      /* 'Add Educacion' Routine */
      returnInSub = false ;
      AV29NewEducacion = (com.projectthani.SdtSDTProfesionalEducacion)new com.projectthani.SdtSDTProfesionalEducacion(remoteHandle, context);
      AV12EducacionList.add(AV29NewEducacion, 0);
      gx_BV195 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12EducacionList", AV12EducacionList);
      nGXsfl_195_bak_idx = nGXsfl_195_idx ;
      gxgrgrideducacion_refresh( AV34PaisId, AV66ProfesionalTerminosCondiciones, AV36Pattern, Gx_date) ;
      nGXsfl_195_idx = nGXsfl_195_bak_idx ;
      sGXsfl_195_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_195_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1958( ) ;
   }

   public void e176U2( )
   {
      AV95GXV11 = nGXsfl_235_idx ;
      if ( AV18ExperienciaLaboralList.size() >= AV95GXV11 )
      {
         AV18ExperienciaLaboralList.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)) );
      }
      /* 'Add Experiencia Laboral' Routine */
      returnInSub = false ;
      AV31NewExperienciaLaboral = (com.projectthani.SdtSDTProfesionalExperienciaLaboral)new com.projectthani.SdtSDTProfesionalExperienciaLaboral(remoteHandle, context);
      AV18ExperienciaLaboralList.add(AV31NewExperienciaLaboral, 0);
      gx_BV235 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV18ExperienciaLaboralList", AV18ExperienciaLaboralList);
      nGXsfl_235_bak_idx = nGXsfl_235_idx ;
      gxgrgridexperiencialaboral_refresh( AV34PaisId, AV66ProfesionalTerminosCondiciones, AV36Pattern, Gx_date) ;
      nGXsfl_235_idx = nGXsfl_235_bak_idx ;
      sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2357( ) ;
   }

   public void e186U2( )
   {
      AV100GXV16 = nGXsfl_266_idx ;
      if ( AV38PremiosList.size() >= AV100GXV16 )
      {
         AV38PremiosList.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)) );
      }
      /* 'Add Premio' Routine */
      returnInSub = false ;
      AV32NewPremios = (com.projectthani.SdtSDTProfesionalPremios)new com.projectthani.SdtSDTProfesionalPremios(remoteHandle, context);
      AV38PremiosList.add(AV32NewPremios, 0);
      gx_BV266 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV38PremiosList", AV38PremiosList);
      nGXsfl_266_bak_idx = nGXsfl_266_idx ;
      gxgrgridpremios_refresh( AV34PaisId, AV66ProfesionalTerminosCondiciones, AV36Pattern, Gx_date) ;
      nGXsfl_266_idx = nGXsfl_266_bak_idx ;
      sGXsfl_266_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_266_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2666( ) ;
   }

   public void e196U2( )
   {
      AV105GXV21 = nGXsfl_299_idx ;
      if ( AV76ServiciosList.size() >= AV105GXV21 )
      {
         AV76ServiciosList.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV76ServiciosList.elementAt(-1+AV105GXV21)) );
      }
      /* 'Add New Servicio' Routine */
      returnInSub = false ;
      AV33NewServicios = (com.projectthani.SdtSDTProfesionalServicios)new com.projectthani.SdtSDTProfesionalServicios(remoteHandle, context);
      AV76ServiciosList.add(AV33NewServicios, 0);
      gx_BV299 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76ServiciosList", AV76ServiciosList);
      nGXsfl_299_bak_idx = nGXsfl_299_idx ;
      gxgrgridservicios_refresh( AV34PaisId, AV66ProfesionalTerminosCondiciones, AV36Pattern, Gx_date) ;
      nGXsfl_299_idx = nGXsfl_299_bak_idx ;
      sGXsfl_299_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_299_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2995( ) ;
   }

   public void e206U2( )
   {
      AV85GXV1 = nGXsfl_167_idx ;
      if ( AV15EspecialidadList.size() >= AV85GXV1 )
      {
         AV15EspecialidadList.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)) );
      }
      /* 'Add New Especialidad' Routine */
      returnInSub = false ;
      AV30NewEspecialidad = (com.projectthani.SdtSDTProfesionalEspecialidadSede)new com.projectthani.SdtSDTProfesionalEspecialidadSede(remoteHandle, context);
      AV15EspecialidadList.add(AV30NewEspecialidad, 0);
      gx_BV167 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV15EspecialidadList", AV15EspecialidadList);
      nGXsfl_167_bak_idx = nGXsfl_167_idx ;
      gxgrgridespecialidadsede_refresh( AV34PaisId, AV66ProfesionalTerminosCondiciones, AV36Pattern, Gx_date) ;
      nGXsfl_167_idx = nGXsfl_167_bak_idx ;
      sGXsfl_167_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_167_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1672( ) ;
   }

   private void e266U2( )
   {
      /* Gridespecialidadsede_Load Routine */
      returnInSub = false ;
      AV85GXV1 = 1 ;
      while ( AV85GXV1 <= AV15EspecialidadList.size() )
      {
         AV15EspecialidadList.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(167) ;
         }
         sendrow_1672( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_167_Refreshing )
         {
            httpContext.doAjaxLoad(167, GridespecialidadsedeRow);
         }
         AV85GXV1 = (int)(AV85GXV1+1) ;
      }
   }

   private void e246U5( )
   {
      /* Gridservicios_Load Routine */
      returnInSub = false ;
      AV105GXV21 = 1 ;
      while ( AV105GXV21 <= AV76ServiciosList.size() )
      {
         AV76ServiciosList.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV76ServiciosList.elementAt(-1+AV105GXV21)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(299) ;
         }
         sendrow_2995( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_299_Refreshing )
         {
            httpContext.doAjaxLoad(299, GridserviciosRow);
         }
         AV105GXV21 = (int)(AV105GXV21+1) ;
      }
   }

   private void e236U6( )
   {
      /* Gridpremios_Load Routine */
      returnInSub = false ;
      AV100GXV16 = 1 ;
      while ( AV100GXV16 <= AV38PremiosList.size() )
      {
         AV38PremiosList.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(266) ;
         }
         sendrow_2666( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_266_Refreshing )
         {
            httpContext.doAjaxLoad(266, GridpremiosRow);
         }
         AV100GXV16 = (int)(AV100GXV16+1) ;
      }
   }

   private void e226U7( )
   {
      /* Gridexperiencialaboral_Load Routine */
      returnInSub = false ;
      AV95GXV11 = 1 ;
      while ( AV95GXV11 <= AV18ExperienciaLaboralList.size() )
      {
         AV18ExperienciaLaboralList.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(235) ;
         }
         sendrow_2357( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_235_Refreshing )
         {
            httpContext.doAjaxLoad(235, GridexperiencialaboralRow);
         }
         AV95GXV11 = (int)(AV95GXV11+1) ;
      }
   }

   private void e216U8( )
   {
      /* Grideducacion_Load Routine */
      returnInSub = false ;
      AV89GXV5 = 1 ;
      while ( AV89GXV5 <= AV12EducacionList.size() )
      {
         AV12EducacionList.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(195) ;
         }
         sendrow_1958( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_195_Refreshing )
         {
            httpContext.doAjaxLoad(195, GrideducacionRow);
         }
         AV89GXV5 = (int)(AV89GXV5+1) ;
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
      pa6U2( ) ;
      ws6U2( ) ;
      we6U2( ) ;
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
      httpContext.AddStyleSheetFile("FileUpload/fileupload.min.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110342090", true, true);
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
      httpContext.AddJavascriptSource("wpmiperfilprofesional.js", "?20225110342091", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1672( )
   {
      dynavCtlespecialidadid.setInternalname( "CTLESPECIALIDADID_"+sGXsfl_167_idx );
      cmbavCtlsedetipoconsulta.setInternalname( "CTLSEDETIPOCONSULTA_"+sGXsfl_167_idx );
      edtavCtlcostoconsulta_Internalname = "CTLCOSTOCONSULTA_"+sGXsfl_167_idx ;
   }

   public void subsflControlProps_fel_1672( )
   {
      dynavCtlespecialidadid.setInternalname( "CTLESPECIALIDADID_"+sGXsfl_167_fel_idx );
      cmbavCtlsedetipoconsulta.setInternalname( "CTLSEDETIPOCONSULTA_"+sGXsfl_167_fel_idx );
      edtavCtlcostoconsulta_Internalname = "CTLCOSTOCONSULTA_"+sGXsfl_167_fel_idx ;
   }

   public void sendrow_1672( )
   {
      subsflControlProps_1672( ) ;
      wb6U0( ) ;
      GridespecialidadsedeRow = GXWebRow.GetNew(context,GridespecialidadsedeContainer) ;
      if ( subGridespecialidadsede_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridespecialidadsede_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridespecialidadsede_Class, "") != 0 )
         {
            subGridespecialidadsede_Linesclass = subGridespecialidadsede_Class+"Odd" ;
         }
      }
      else if ( subGridespecialidadsede_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridespecialidadsede_Backstyle = (byte)(0) ;
         subGridespecialidadsede_Backcolor = subGridespecialidadsede_Allbackcolor ;
         if ( GXutil.strcmp(subGridespecialidadsede_Class, "") != 0 )
         {
            subGridespecialidadsede_Linesclass = subGridespecialidadsede_Class+"Uniform" ;
         }
      }
      else if ( subGridespecialidadsede_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridespecialidadsede_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridespecialidadsede_Class, "") != 0 )
         {
            subGridespecialidadsede_Linesclass = subGridespecialidadsede_Class+"Odd" ;
         }
         subGridespecialidadsede_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridespecialidadsede_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridespecialidadsede_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_167_idx) % (2))) == 0 )
         {
            subGridespecialidadsede_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridespecialidadsede_Class, "") != 0 )
            {
               subGridespecialidadsede_Linesclass = subGridespecialidadsede_Class+"Even" ;
            }
         }
         else
         {
            subGridespecialidadsede_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridespecialidadsede_Class, "") != 0 )
            {
               subGridespecialidadsede_Linesclass = subGridespecialidadsede_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridespecialidadsedeContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridespecialidadsede_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_167_idx+"\">") ;
      }
      gxvctlespecialidadid_html6U2( ) ;
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid1table2_Internalname+"_"+sGXsfl_167_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+dynavCtlespecialidadid.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      GridespecialidadsedeRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {dynavCtlespecialidadid.getInternalname(),"Especialidad","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      TempTags = " " + ((dynavCtlespecialidadid.getEnabled()!=0)&&(dynavCtlespecialidadid.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 173,'',false,'"+sGXsfl_167_idx+"',167)\"" : " ") ;
      if ( ( dynavCtlespecialidadid.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CTLESPECIALIDADID_" + sGXsfl_167_idx ;
         dynavCtlespecialidadid.setName( GXCCtl );
         dynavCtlespecialidadid.setWebtags( "" );
      }
      /* ComboBox */
      GridespecialidadsedeRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynavCtlespecialidadid,dynavCtlespecialidadid.getInternalname(),GXutil.trim( GXutil.str( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid(), 4, 0)),Integer.valueOf(1),dynavCtlespecialidadid.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","AttributeRegistroProfesional","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((dynavCtlespecialidadid.getEnabled()!=0)&&(dynavCtlespecialidadid.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,173);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(1)});
      dynavCtlespecialidadid.setValue( GXutil.trim( GXutil.str( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid(), 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavCtlespecialidadid.getInternalname(), "Values", dynavCtlespecialidadid.ToJavascriptSource(), !bGXsfl_167_Refreshing);
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavCtlsedetipoconsulta.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      GridespecialidadsedeRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavCtlsedetipoconsulta.getInternalname(),"Tipo Consulta","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      TempTags = " " + ((cmbavCtlsedetipoconsulta.getEnabled()!=0)&&(cmbavCtlsedetipoconsulta.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 177,'',false,'"+sGXsfl_167_idx+"',167)\"" : " ") ;
      if ( ( cmbavCtlsedetipoconsulta.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CTLSEDETIPOCONSULTA_" + sGXsfl_167_idx ;
         cmbavCtlsedetipoconsulta.setName( GXCCtl );
         cmbavCtlsedetipoconsulta.setWebtags( "" );
         cmbavCtlsedetipoconsulta.addItem("", "Seleccione:", (short)(0));
         cmbavCtlsedetipoconsulta.addItem("V", "Virtual", (short)(0));
         cmbavCtlsedetipoconsulta.addItem("P", "En consultorio", (short)(0));
         cmbavCtlsedetipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
         if ( cmbavCtlsedetipoconsulta.getItemCount() > 0 )
         {
            if ( ( AV85GXV1 > 0 ) && ( AV15EspecialidadList.size() >= AV85GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta())==0) )
            {
               ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).setgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta( cmbavCtlsedetipoconsulta.getValidValue(((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()) );
            }
         }
      }
      /* ComboBox */
      GridespecialidadsedeRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavCtlsedetipoconsulta,cmbavCtlsedetipoconsulta.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()),Integer.valueOf(1),cmbavCtlsedetipoconsulta.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","AttributeRegistroProfesional","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavCtlsedetipoconsulta.getEnabled()!=0)&&(cmbavCtlsedetipoconsulta.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,177);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavCtlsedetipoconsulta.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCtlsedetipoconsulta.getInternalname(), "Values", cmbavCtlsedetipoconsulta.ToJavascriptSource(), !bGXsfl_167_Refreshing);
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlcostoconsulta_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridespecialidadsedeRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlcostoconsulta_Internalname,"Costo Consulta","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridespecialidadsedeRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlcostoconsulta_Enabled!=0)&&(edtavCtlcostoconsulta_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 181,'',false,'"+sGXsfl_167_idx+"',167)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GridespecialidadsedeRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlcostoconsulta_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta(), (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Costoconsulta(), "ZZ9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavCtlcostoconsulta_Enabled!=0)&&(edtavCtlcostoconsulta_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,181);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlcostoconsulta_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(6),"chr",Integer.valueOf(1),"row",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(167),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridespecialidadsedeRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6U2( ) ;
      /* End of Columns property logic. */
      GridespecialidadsedeContainer.AddRow(GridespecialidadsedeRow);
      nGXsfl_167_idx = ((subGridespecialidadsede_Islastpage==1)&&(nGXsfl_167_idx+1>subgridespecialidadsede_fnc_recordsperpage( )) ? 1 : nGXsfl_167_idx+1) ;
      sGXsfl_167_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_167_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1672( ) ;
      /* End function sendrow_1672 */
   }

   public void subsflControlProps_1958( )
   {
      edtavCtleducacionid_Internalname = "CTLEDUCACIONID_"+sGXsfl_195_idx ;
      edtavCtleducacionnombreinstitucion_Internalname = "CTLEDUCACIONNOMBREINSTITUCION_"+sGXsfl_195_idx ;
      edtavCtleducacionpaisdescripcion_Internalname = "CTLEDUCACIONPAISDESCRIPCION_"+sGXsfl_195_idx ;
      edtavCtleducaciondesde_Internalname = "CTLEDUCACIONDESDE_"+sGXsfl_195_idx ;
      edtavCtleducacionhasta_Internalname = "CTLEDUCACIONHASTA_"+sGXsfl_195_idx ;
   }

   public void subsflControlProps_fel_1958( )
   {
      edtavCtleducacionid_Internalname = "CTLEDUCACIONID_"+sGXsfl_195_fel_idx ;
      edtavCtleducacionnombreinstitucion_Internalname = "CTLEDUCACIONNOMBREINSTITUCION_"+sGXsfl_195_fel_idx ;
      edtavCtleducacionpaisdescripcion_Internalname = "CTLEDUCACIONPAISDESCRIPCION_"+sGXsfl_195_fel_idx ;
      edtavCtleducaciondesde_Internalname = "CTLEDUCACIONDESDE_"+sGXsfl_195_fel_idx ;
      edtavCtleducacionhasta_Internalname = "CTLEDUCACIONHASTA_"+sGXsfl_195_fel_idx ;
   }

   public void sendrow_1958( )
   {
      subsflControlProps_1958( ) ;
      wb6U0( ) ;
      GrideducacionRow = GXWebRow.GetNew(context,GrideducacionContainer) ;
      if ( subGrideducacion_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGrideducacion_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGrideducacion_Class, "") != 0 )
         {
            subGrideducacion_Linesclass = subGrideducacion_Class+"Odd" ;
         }
      }
      else if ( subGrideducacion_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGrideducacion_Backstyle = (byte)(0) ;
         subGrideducacion_Backcolor = subGrideducacion_Allbackcolor ;
         if ( GXutil.strcmp(subGrideducacion_Class, "") != 0 )
         {
            subGrideducacion_Linesclass = subGrideducacion_Class+"Uniform" ;
         }
      }
      else if ( subGrideducacion_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGrideducacion_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGrideducacion_Class, "") != 0 )
         {
            subGrideducacion_Linesclass = subGrideducacion_Class+"Odd" ;
         }
         subGrideducacion_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGrideducacion_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGrideducacion_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_195_idx) % (2))) == 0 )
         {
            subGrideducacion_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGrideducacion_Class, "") != 0 )
            {
               subGrideducacion_Linesclass = subGrideducacion_Class+"Even" ;
            }
         }
         else
         {
            subGrideducacion_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGrideducacion_Class, "") != 0 )
            {
               subGrideducacion_Linesclass = subGrideducacion_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GrideducacionContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGrideducacion_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_195_idx+"\">") ;
      }
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid2table_Internalname+"_"+sGXsfl_195_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs col-sm-6 hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtleducacionid_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GrideducacionRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtleducacionid_Internalname,"Educacion Id","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtleducacionid_Enabled!=0)&&(edtavCtleducacionid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 201,'',false,'"+sGXsfl_195_idx+"',195)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GrideducacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtleducacionid_Internalname,((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)).getgxTv_SdtSDTProfesionalEducacion_Educacionid().toString(),((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)).getgxTv_SdtSDTProfesionalEducacion_Educacionid().toString(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtleducacionid_Enabled!=0)&&(edtavCtleducacionid_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,201);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtleducacionid_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(36),"chr",Integer.valueOf(1),"row",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(195),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(true),"","",Boolean.valueOf(false),""});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 col-lg-2","left","top","","","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-2","left","top","","","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtleducacionnombreinstitucion_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GrideducacionRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtleducacionnombreinstitucion_Internalname,"Nombre de la Institución","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtleducacionnombreinstitucion_Enabled!=0)&&(edtavCtleducacionnombreinstitucion_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 208,'',false,'"+sGXsfl_195_idx+"',195)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GrideducacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtleducacionnombreinstitucion_Internalname,((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)).getgxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtleducacionnombreinstitucion_Enabled!=0)&&(edtavCtleducacionnombreinstitucion_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,208);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtleducacionnombreinstitucion_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(195),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 col-md-6","left","top","","","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtleducacionpaisdescripcion_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GrideducacionRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtleducacionpaisdescripcion_Internalname,"País","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtleducacionpaisdescripcion_Enabled!=0)&&(edtavCtleducacionpaisdescripcion_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 213,'',false,'"+sGXsfl_195_idx+"',195)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GrideducacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtleducacionpaisdescripcion_Internalname,((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)).getgxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtleducacionpaisdescripcion_Enabled!=0)&&(edtavCtleducacionpaisdescripcion_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,213);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtleducacionpaisdescripcion_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(195),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 col-md-3","left","top","","","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtleducaciondesde_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GrideducacionRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtleducaciondesde_Internalname,"Desde","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtleducaciondesde_Enabled!=0)&&(edtavCtleducaciondesde_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 217,'',false,'"+sGXsfl_195_idx+"',195)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GrideducacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtleducaciondesde_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)).getgxTv_SdtSDTProfesionalEducacion_Educaciondesde(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)).getgxTv_SdtSDTProfesionalEducacion_Educaciondesde(), "99/99/99"),TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+((edtavCtleducaciondesde_Enabled!=0)&&(edtavCtleducaciondesde_Visible!=0) ? " onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,217);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtleducaciondesde_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(195),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 col-md-3","left","top","","","div"});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtleducacionhasta_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GrideducacionRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtleducacionhasta_Internalname,"Hasta","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GrideducacionRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtleducacionhasta_Enabled!=0)&&(edtavCtleducacionhasta_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 221,'',false,'"+sGXsfl_195_idx+"',195)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GrideducacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtleducacionhasta_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)).getgxTv_SdtSDTProfesionalEducacion_Educacionhasta(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTProfesionalEducacion)AV12EducacionList.elementAt(-1+AV89GXV5)).getgxTv_SdtSDTProfesionalEducacion_Educacionhasta(), "99/99/99"),TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+((edtavCtleducacionhasta_Enabled!=0)&&(edtavCtleducacionhasta_Visible!=0) ? " onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,221);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtleducacionhasta_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(195),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GrideducacionRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6U8( ) ;
      /* End of Columns property logic. */
      GrideducacionContainer.AddRow(GrideducacionRow);
      nGXsfl_195_idx = ((subGrideducacion_Islastpage==1)&&(nGXsfl_195_idx+1>subgrideducacion_fnc_recordsperpage( )) ? 1 : nGXsfl_195_idx+1) ;
      sGXsfl_195_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_195_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1958( ) ;
      /* End function sendrow_1958 */
   }

   public void subsflControlProps_2357( )
   {
      edtavCtlexperiencialaboralid_Internalname = "CTLEXPERIENCIALABORALID_"+sGXsfl_235_idx ;
      edtavCtlexperiencialaboralempresanombre_Internalname = "CTLEXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_235_idx ;
      edtavCtlexperiencialaboraldesde_Internalname = "CTLEXPERIENCIALABORALDESDE_"+sGXsfl_235_idx ;
      edtavCtlexperiencialaboralhasta_Internalname = "CTLEXPERIENCIALABORALHASTA_"+sGXsfl_235_idx ;
   }

   public void subsflControlProps_fel_2357( )
   {
      edtavCtlexperiencialaboralid_Internalname = "CTLEXPERIENCIALABORALID_"+sGXsfl_235_fel_idx ;
      edtavCtlexperiencialaboralempresanombre_Internalname = "CTLEXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_235_fel_idx ;
      edtavCtlexperiencialaboraldesde_Internalname = "CTLEXPERIENCIALABORALDESDE_"+sGXsfl_235_fel_idx ;
      edtavCtlexperiencialaboralhasta_Internalname = "CTLEXPERIENCIALABORALHASTA_"+sGXsfl_235_fel_idx ;
   }

   public void sendrow_2357( )
   {
      subsflControlProps_2357( ) ;
      wb6U0( ) ;
      GridexperiencialaboralRow = GXWebRow.GetNew(context,GridexperiencialaboralContainer) ;
      if ( subGridexperiencialaboral_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridexperiencialaboral_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridexperiencialaboral_Class, "") != 0 )
         {
            subGridexperiencialaboral_Linesclass = subGridexperiencialaboral_Class+"Odd" ;
         }
      }
      else if ( subGridexperiencialaboral_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridexperiencialaboral_Backstyle = (byte)(0) ;
         subGridexperiencialaboral_Backcolor = subGridexperiencialaboral_Allbackcolor ;
         if ( GXutil.strcmp(subGridexperiencialaboral_Class, "") != 0 )
         {
            subGridexperiencialaboral_Linesclass = subGridexperiencialaboral_Class+"Uniform" ;
         }
      }
      else if ( subGridexperiencialaboral_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridexperiencialaboral_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridexperiencialaboral_Class, "") != 0 )
         {
            subGridexperiencialaboral_Linesclass = subGridexperiencialaboral_Class+"Odd" ;
         }
         subGridexperiencialaboral_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridexperiencialaboral_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridexperiencialaboral_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_235_idx) % (2))) == 0 )
         {
            subGridexperiencialaboral_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridexperiencialaboral_Class, "") != 0 )
            {
               subGridexperiencialaboral_Linesclass = subGridexperiencialaboral_Class+"Even" ;
            }
         }
         else
         {
            subGridexperiencialaboral_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridexperiencialaboral_Class, "") != 0 )
            {
               subGridexperiencialaboral_Linesclass = subGridexperiencialaboral_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridexperiencialaboralContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridexperiencialaboral_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_235_idx+"\">") ;
      }
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid1table_Internalname+"_"+sGXsfl_235_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs col-sm-4 hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridexperiencialaboralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlexperiencialaboralid_Internalname,"Experiencia Laboral Id","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      TempTags = " " + ((edtavCtlexperiencialaboralid_Enabled!=0)&&(edtavCtlexperiencialaboralid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 240,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridexperiencialaboralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlexperiencialaboralid_Internalname,((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid().toString(),((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralid().toString(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlexperiencialaboralid_Enabled!=0)&&(edtavCtlexperiencialaboralid_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,240);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlexperiencialaboralid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(36),"chr",Integer.valueOf(1),"row",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(true),"","",Boolean.valueOf(false),""});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 col-md-6","left","top","","","div"});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlexperiencialaboralempresanombre_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridexperiencialaboralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlexperiencialaboralempresanombre_Internalname,"Nombre De La Empresa","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlexperiencialaboralempresanombre_Enabled!=0)&&(edtavCtlexperiencialaboralempresanombre_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 244,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GridexperiencialaboralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlexperiencialaboralempresanombre_Internalname,((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlexperiencialaboralempresanombre_Enabled!=0)&&(edtavCtlexperiencialaboralempresanombre_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,244);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlexperiencialaboralempresanombre_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 col-md-3","left","top","","","div"});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlexperiencialaboraldesde_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridexperiencialaboralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlexperiencialaboraldesde_Internalname,"Desde","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlexperiencialaboraldesde_Enabled!=0)&&(edtavCtlexperiencialaboraldesde_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 248,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GridexperiencialaboralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlexperiencialaboraldesde_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde(), "99/99/9999"),localUtil.format( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde(), "99/99/9999"),TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+((edtavCtlexperiencialaboraldesde_Enabled!=0)&&(edtavCtlexperiencialaboraldesde_Visible!=0) ? " onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,248);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlexperiencialaboraldesde_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4 col-md-3","left","top","","","div"});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlexperiencialaboralhasta_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridexperiencialaboralRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlexperiencialaboralhasta_Internalname,"Hasta","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridexperiencialaboralRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlexperiencialaboralhasta_Enabled!=0)&&(edtavCtlexperiencialaboralhasta_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 252,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GridexperiencialaboralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlexperiencialaboralhasta_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta(), "99/99/9999"),localUtil.format( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV18ExperienciaLaboralList.elementAt(-1+AV95GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta(), "99/99/9999"),TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+((edtavCtlexperiencialaboralhasta_Enabled!=0)&&(edtavCtlexperiencialaboralhasta_Visible!=0) ? " onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,252);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlexperiencialaboralhasta_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridexperiencialaboralRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6U7( ) ;
      /* End of Columns property logic. */
      GridexperiencialaboralContainer.AddRow(GridexperiencialaboralRow);
      nGXsfl_235_idx = ((subGridexperiencialaboral_Islastpage==1)&&(nGXsfl_235_idx+1>subgridexperiencialaboral_fnc_recordsperpage( )) ? 1 : nGXsfl_235_idx+1) ;
      sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2357( ) ;
      /* End function sendrow_2357 */
   }

   public void subsflControlProps_2666( )
   {
      edtavCtlpremiosid_Internalname = "CTLPREMIOSID_"+sGXsfl_266_idx ;
      edtavCtlpremiosnombre_Internalname = "CTLPREMIOSNOMBRE_"+sGXsfl_266_idx ;
      edtavCtlpremiosfecha_Internalname = "CTLPREMIOSFECHA_"+sGXsfl_266_idx ;
      edtavCtlpremiosdescripcion_Internalname = "CTLPREMIOSDESCRIPCION_"+sGXsfl_266_idx ;
   }

   public void subsflControlProps_fel_2666( )
   {
      edtavCtlpremiosid_Internalname = "CTLPREMIOSID_"+sGXsfl_266_fel_idx ;
      edtavCtlpremiosnombre_Internalname = "CTLPREMIOSNOMBRE_"+sGXsfl_266_fel_idx ;
      edtavCtlpremiosfecha_Internalname = "CTLPREMIOSFECHA_"+sGXsfl_266_fel_idx ;
      edtavCtlpremiosdescripcion_Internalname = "CTLPREMIOSDESCRIPCION_"+sGXsfl_266_fel_idx ;
   }

   public void sendrow_2666( )
   {
      subsflControlProps_2666( ) ;
      wb6U0( ) ;
      GridpremiosRow = GXWebRow.GetNew(context,GridpremiosContainer) ;
      if ( subGridpremios_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridpremios_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridpremios_Class, "") != 0 )
         {
            subGridpremios_Linesclass = subGridpremios_Class+"Odd" ;
         }
      }
      else if ( subGridpremios_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridpremios_Backstyle = (byte)(0) ;
         subGridpremios_Backcolor = subGridpremios_Allbackcolor ;
         if ( GXutil.strcmp(subGridpremios_Class, "") != 0 )
         {
            subGridpremios_Linesclass = subGridpremios_Class+"Uniform" ;
         }
      }
      else if ( subGridpremios_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridpremios_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridpremios_Class, "") != 0 )
         {
            subGridpremios_Linesclass = subGridpremios_Class+"Odd" ;
         }
         subGridpremios_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridpremios_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridpremios_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_266_idx) % (2))) == 0 )
         {
            subGridpremios_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridpremios_Class, "") != 0 )
            {
               subGridpremios_Linesclass = subGridpremios_Class+"Even" ;
            }
         }
         else
         {
            subGridpremios_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridpremios_Class, "") != 0 )
            {
               subGridpremios_Linesclass = subGridpremios_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridpremiosContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridpremios_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_266_idx+"\">") ;
      }
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid1table1_Internalname+"_"+sGXsfl_266_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridpremiosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlpremiosid_Internalname,"Premios Id","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      TempTags = " " + ((edtavCtlpremiosid_Enabled!=0)&&(edtavCtlpremiosid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 271,'',false,'"+sGXsfl_266_idx+"',266)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridpremiosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlpremiosid_Internalname,((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)).getgxTv_SdtSDTProfesionalPremios_Premiosid().toString(),((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)).getgxTv_SdtSDTProfesionalPremios_Premiosid().toString(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlpremiosid_Enabled!=0)&&(edtavCtlpremiosid_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,271);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlpremiosid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(36),"chr",Integer.valueOf(1),"row",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(266),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(true),"","",Boolean.valueOf(false),""});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-8","left","top","","","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlpremiosnombre_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpremiosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlpremiosnombre_Internalname,"Nombre Del Premio","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlpremiosnombre_Enabled!=0)&&(edtavCtlpremiosnombre_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 276,'',false,'"+sGXsfl_266_idx+"',266)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GridpremiosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlpremiosnombre_Internalname,((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)).getgxTv_SdtSDTProfesionalPremios_Premiosnombre(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlpremiosnombre_Enabled!=0)&&(edtavCtlpremiosnombre_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,276);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlpremiosnombre_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(500),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(266),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4","left","top","","","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlpremiosfecha_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpremiosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlpremiosfecha_Internalname,"Fecha","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlpremiosfecha_Enabled!=0)&&(edtavCtlpremiosfecha_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 280,'',false,'"+sGXsfl_266_idx+"',266)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GridpremiosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlpremiosfecha_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)).getgxTv_SdtSDTProfesionalPremios_Premiosfecha(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)).getgxTv_SdtSDTProfesionalPremios_Premiosfecha(), "99/99/99"),TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+((edtavCtlpremiosfecha_Enabled!=0)&&(edtavCtlpremiosfecha_Visible!=0) ? " onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,280);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlpremiosfecha_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(266),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlpremiosdescripcion_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpremiosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlpremiosdescripcion_Internalname,"Descripción Del Premio","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpremiosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlpremiosdescripcion_Enabled!=0)&&(edtavCtlpremiosdescripcion_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 285,'',false,'"+sGXsfl_266_idx+"',266)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GridpremiosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlpremiosdescripcion_Internalname,((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)).getgxTv_SdtSDTProfesionalPremios_Premiosdescripcion(),((com.projectthani.SdtSDTProfesionalPremios)AV38PremiosList.elementAt(-1+AV100GXV16)).getgxTv_SdtSDTProfesionalPremios_Premiosdescripcion(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlpremiosdescripcion_Enabled!=0)&&(edtavCtlpremiosdescripcion_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,285);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlpremiosdescripcion_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(266),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpremiosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6U6( ) ;
      /* End of Columns property logic. */
      GridpremiosContainer.AddRow(GridpremiosRow);
      nGXsfl_266_idx = ((subGridpremios_Islastpage==1)&&(nGXsfl_266_idx+1>subgridpremios_fnc_recordsperpage( )) ? 1 : nGXsfl_266_idx+1) ;
      sGXsfl_266_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_266_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2666( ) ;
      /* End function sendrow_2666 */
   }

   public void subsflControlProps_2995( )
   {
      edtavCtlserviciosid_Internalname = "CTLSERVICIOSID_"+sGXsfl_299_idx ;
      edtavCtlserviciosnombre_Internalname = "CTLSERVICIOSNOMBRE_"+sGXsfl_299_idx ;
   }

   public void subsflControlProps_fel_2995( )
   {
      edtavCtlserviciosid_Internalname = "CTLSERVICIOSID_"+sGXsfl_299_fel_idx ;
      edtavCtlserviciosnombre_Internalname = "CTLSERVICIOSNOMBRE_"+sGXsfl_299_fel_idx ;
   }

   public void sendrow_2995( )
   {
      subsflControlProps_2995( ) ;
      wb6U0( ) ;
      GridserviciosRow = GXWebRow.GetNew(context,GridserviciosContainer) ;
      if ( subGridservicios_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridservicios_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridservicios_Class, "") != 0 )
         {
            subGridservicios_Linesclass = subGridservicios_Class+"Odd" ;
         }
      }
      else if ( subGridservicios_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridservicios_Backstyle = (byte)(0) ;
         subGridservicios_Backcolor = subGridservicios_Allbackcolor ;
         if ( GXutil.strcmp(subGridservicios_Class, "") != 0 )
         {
            subGridservicios_Linesclass = subGridservicios_Class+"Uniform" ;
         }
      }
      else if ( subGridservicios_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridservicios_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridservicios_Class, "") != 0 )
         {
            subGridservicios_Linesclass = subGridservicios_Class+"Odd" ;
         }
         subGridservicios_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridservicios_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridservicios_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_299_idx) % (2))) == 0 )
         {
            subGridservicios_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridservicios_Class, "") != 0 )
            {
               subGridservicios_Linesclass = subGridservicios_Class+"Even" ;
            }
         }
         else
         {
            subGridservicios_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridservicios_Class, "") != 0 )
            {
               subGridservicios_Linesclass = subGridservicios_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridserviciosContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridservicios_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_299_idx+"\">") ;
      }
      /* Div Control */
      GridserviciosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid2table1_Internalname+"_"+sGXsfl_299_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridserviciosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridserviciosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs col-sm-6 hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      GridserviciosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridserviciosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlserviciosid_Internalname,"Servicios Id","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      TempTags = " " + ((edtavCtlserviciosid_Enabled!=0)&&(edtavCtlserviciosid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 304,'',false,'"+sGXsfl_299_idx+"',299)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridserviciosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlserviciosid_Internalname,((com.projectthani.SdtSDTProfesionalServicios)AV76ServiciosList.elementAt(-1+AV105GXV21)).getgxTv_SdtSDTProfesionalServicios_Serviciosid().toString(),((com.projectthani.SdtSDTProfesionalServicios)AV76ServiciosList.elementAt(-1+AV105GXV21)).getgxTv_SdtSDTProfesionalServicios_Serviciosid().toString(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlserviciosid_Enabled!=0)&&(edtavCtlserviciosid_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,304);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlserviciosid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(36),"chr",Integer.valueOf(1),"row",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(299),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(true),"","",Boolean.valueOf(false),""});
      GridserviciosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridserviciosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridserviciosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6","left","top","","","div"});
      /* Div Control */
      GridserviciosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlserviciosnombre_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridserviciosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlserviciosnombre_Internalname,"Nombre Del Servicio","col-xs-12 AttributeRegistroProfesionalLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridserviciosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlserviciosnombre_Enabled!=0)&&(edtavCtlserviciosnombre_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 308,'',false,'"+sGXsfl_299_idx+"',299)\"" : " ") ;
      ROClassString = "AttributeRegistroProfesional" ;
      GridserviciosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlserviciosnombre_Internalname,((com.projectthani.SdtSDTProfesionalServicios)AV76ServiciosList.elementAt(-1+AV105GXV21)).getgxTv_SdtSDTProfesionalServicios_Serviciosnombre(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlserviciosnombre_Enabled!=0)&&(edtavCtlserviciosnombre_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,308);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlserviciosnombre_Jsonclick,Integer.valueOf(0),"AttributeRegistroProfesional","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(299),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridserviciosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridserviciosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridserviciosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridserviciosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridserviciosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6U5( ) ;
      /* End of Columns property logic. */
      GridserviciosContainer.AddRow(GridserviciosRow);
      nGXsfl_299_idx = ((subGridservicios_Islastpage==1)&&(nGXsfl_299_idx+1>subgridservicios_fnc_recordsperpage( )) ? 1 : nGXsfl_299_idx+1) ;
      sGXsfl_299_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_299_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2995( ) ;
      /* End function sendrow_2995 */
   }

   public void init_default_properties( )
   {
      imgImage2_Internalname = "IMAGE2" ;
      lblTextblockinfosolicitadaprof_Internalname = "TEXTBLOCKINFOSOLICITADAPROF" ;
      cmbavProfesionaltipodocumento.setInternalname( "vPROFESIONALTIPODOCUMENTO" );
      edtavProfesionalnrodocumento_Internalname = "vPROFESIONALNRODOCUMENTO" ;
      edtavProfesionalnombres_Internalname = "vPROFESIONALNOMBRES" ;
      edtavProfesionalapellidopaterno_Internalname = "vPROFESIONALAPELLIDOPATERNO" ;
      edtavProfesionalapellidomaterno_Internalname = "vPROFESIONALAPELLIDOMATERNO" ;
      cmbavProfesionalsexo.setInternalname( "vPROFESIONALSEXO" );
      cmbavProfesionaldia.setInternalname( "vPROFESIONALDIA" );
      cmbavProfesionalmes.setInternalname( "vPROFESIONALMES" );
      cmbavProfesionalanio.setInternalname( "vPROFESIONALANIO" );
      divGroup1table1_Internalname = "GROUP1TABLE1" ;
      grpGroup1_Internalname = "GROUP1" ;
      edtavProfesionalcop_Internalname = "vPROFESIONALCOP" ;
      edtavProfesionaldescripcion_Internalname = "vPROFESIONALDESCRIPCION" ;
      dynavPaisid.setInternalname( "vPAISID" );
      edtavProfesionaltelefono_Internalname = "vPROFESIONALTELEFONO" ;
      cmbavProfesionaltiempocita.setInternalname( "vPROFESIONALTIEMPOCITA" );
      edtavProfesionalfacebook_Internalname = "vPROFESIONALFACEBOOK" ;
      edtavProfesionallinkedin_Internalname = "vPROFESIONALLINKEDIN" ;
      edtavProfesionaltwitter_Internalname = "vPROFESIONALTWITTER" ;
      edtavProfesionalinstagram_Internalname = "vPROFESIONALINSTAGRAM" ;
      divTable5_Internalname = "TABLE5" ;
      divGroup5table_Internalname = "GROUP5TABLE" ;
      grpGroup5_Internalname = "GROUP5" ;
      edtavProfesionaldireccion_Internalname = "vPROFESIONALDIRECCION" ;
      cmbavProfesionaldepartamento.setInternalname( "vPROFESIONALDEPARTAMENTO" );
      dynavProfesionalprovincia.setInternalname( "vPROFESIONALPROVINCIA" );
      dynavProfesionaldistrito.setInternalname( "vPROFESIONALDISTRITO" );
      divGroup6table_Internalname = "GROUP6TABLE" ;
      grpGroup6_Internalname = "GROUP6" ;
      edtavProfesionalcorreo_Internalname = "vPROFESIONALCORREO" ;
      edtavProfesionalpassword_Internalname = "vPROFESIONALPASSWORD" ;
      divGroup2table_Internalname = "GROUP2TABLE" ;
      grpGroup2_Internalname = "GROUP2" ;
      Fileuploadimagen_Internalname = "FILEUPLOADIMAGEN" ;
      divGroup4table_Internalname = "GROUP4TABLE" ;
      grpGroup4_Internalname = "GROUP4" ;
      lblTabpageregistroprofesional_title_Internalname = "TABPAGEREGISTROPROFESIONAL_TITLE" ;
      dynavCtlespecialidadid.setInternalname( "CTLESPECIALIDADID" );
      cmbavCtlsedetipoconsulta.setInternalname( "CTLSEDETIPOCONSULTA" );
      edtavCtlcostoconsulta_Internalname = "CTLCOSTOCONSULTA" ;
      divGrid1table2_Internalname = "GRID1TABLE2" ;
      bttAddnewespecialidad_Internalname = "ADDNEWESPECIALIDAD" ;
      divTable10_Internalname = "TABLE10" ;
      divTabpage1table_Internalname = "TABPAGE1TABLE" ;
      lblTabpage2_title_Internalname = "TABPAGE2_TITLE" ;
      edtavCtleducacionid_Internalname = "CTLEDUCACIONID" ;
      edtavCtleducacionnombreinstitucion_Internalname = "CTLEDUCACIONNOMBREINSTITUCION" ;
      edtavCtleducacionpaisdescripcion_Internalname = "CTLEDUCACIONPAISDESCRIPCION" ;
      edtavCtleducaciondesde_Internalname = "CTLEDUCACIONDESDE" ;
      edtavCtleducacionhasta_Internalname = "CTLEDUCACIONHASTA" ;
      divGrid2table_Internalname = "GRID2TABLE" ;
      bttAddeducacion_Internalname = "ADDEDUCACION" ;
      divTable6_Internalname = "TABLE6" ;
      divTabpage2table_Internalname = "TABPAGE2TABLE" ;
      lblTabpage3_title_Internalname = "TABPAGE3_TITLE" ;
      edtavCtlexperiencialaboralid_Internalname = "CTLEXPERIENCIALABORALID" ;
      edtavCtlexperiencialaboralempresanombre_Internalname = "CTLEXPERIENCIALABORALEMPRESANOMBRE" ;
      edtavCtlexperiencialaboraldesde_Internalname = "CTLEXPERIENCIALABORALDESDE" ;
      edtavCtlexperiencialaboralhasta_Internalname = "CTLEXPERIENCIALABORALHASTA" ;
      divGrid1table_Internalname = "GRID1TABLE" ;
      bttAddexperiencialaboral_Internalname = "ADDEXPERIENCIALABORAL" ;
      divTable7_Internalname = "TABLE7" ;
      divTabpage3table_Internalname = "TABPAGE3TABLE" ;
      lblTabpage1_title_Internalname = "TABPAGE1_TITLE" ;
      edtavCtlpremiosid_Internalname = "CTLPREMIOSID" ;
      edtavCtlpremiosnombre_Internalname = "CTLPREMIOSNOMBRE" ;
      edtavCtlpremiosfecha_Internalname = "CTLPREMIOSFECHA" ;
      edtavCtlpremiosdescripcion_Internalname = "CTLPREMIOSDESCRIPCION" ;
      divGrid1table1_Internalname = "GRID1TABLE1" ;
      bttAddpremio_Internalname = "ADDPREMIO" ;
      divTable8_Internalname = "TABLE8" ;
      divTabpage1table1_Internalname = "TABPAGE1TABLE1" ;
      lblTabpage4_title_Internalname = "TABPAGE4_TITLE" ;
      edtavCtlserviciosid_Internalname = "CTLSERVICIOSID" ;
      edtavCtlserviciosnombre_Internalname = "CTLSERVICIOSNOMBRE" ;
      divGrid2table1_Internalname = "GRID2TABLE1" ;
      bttAddnewservicio_Internalname = "ADDNEWSERVICIO" ;
      divTable9_Internalname = "TABLE9" ;
      divTabpage4table_Internalname = "TABPAGE4TABLE" ;
      Tabpageregistroprofesional_Internalname = "TABPAGEREGISTROPROFESIONAL" ;
      divGroup7table_Internalname = "GROUP7TABLE" ;
      grpGroup7_Internalname = "GROUP7" ;
      chkavProfesionalterminoscondiciones.setInternalname( "vPROFESIONALTERMINOSCONDICIONES" );
      lblTextblocktercond_Internalname = "TEXTBLOCKTERCOND" ;
      bttGuardarprofesional_Internalname = "GUARDARPROFESIONAL" ;
      bttSalir_Internalname = "SALIR" ;
      divTable4_Internalname = "TABLE4" ;
      divTable3_Internalname = "TABLE3" ;
      divTable1_Internalname = "TABLE1" ;
      Dvmessage1_Internalname = "DVMESSAGE1" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridespecialidadsede_Internalname = "GRIDESPECIALIDADSEDE" ;
      subGrideducacion_Internalname = "GRIDEDUCACION" ;
      subGridexperiencialaboral_Internalname = "GRIDEXPERIENCIALABORAL" ;
      subGridpremios_Internalname = "GRIDPREMIOS" ;
      subGridservicios_Internalname = "GRIDSERVICIOS" ;
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
      edtavCtlserviciosnombre_Jsonclick = "" ;
      edtavCtlserviciosnombre_Visible = 1 ;
      edtavCtlserviciosnombre_Enabled = 1 ;
      edtavCtlserviciosid_Jsonclick = "" ;
      edtavCtlserviciosid_Visible = 1 ;
      edtavCtlserviciosid_Enabled = 1 ;
      subGridservicios_Class = "FreeStyleGrid" ;
      edtavCtlpremiosdescripcion_Jsonclick = "" ;
      edtavCtlpremiosdescripcion_Visible = 1 ;
      edtavCtlpremiosdescripcion_Enabled = 1 ;
      edtavCtlpremiosfecha_Jsonclick = "" ;
      edtavCtlpremiosfecha_Visible = 1 ;
      edtavCtlpremiosfecha_Enabled = 1 ;
      edtavCtlpremiosnombre_Jsonclick = "" ;
      edtavCtlpremiosnombre_Visible = 1 ;
      edtavCtlpremiosnombre_Enabled = 1 ;
      edtavCtlpremiosid_Jsonclick = "" ;
      edtavCtlpremiosid_Visible = 1 ;
      edtavCtlpremiosid_Enabled = 1 ;
      subGridpremios_Class = "FreeStyleGrid" ;
      edtavCtlexperiencialaboralhasta_Jsonclick = "" ;
      edtavCtlexperiencialaboralhasta_Visible = 1 ;
      edtavCtlexperiencialaboralhasta_Enabled = 1 ;
      edtavCtlexperiencialaboraldesde_Jsonclick = "" ;
      edtavCtlexperiencialaboraldesde_Visible = 1 ;
      edtavCtlexperiencialaboraldesde_Enabled = 1 ;
      edtavCtlexperiencialaboralempresanombre_Jsonclick = "" ;
      edtavCtlexperiencialaboralempresanombre_Visible = 1 ;
      edtavCtlexperiencialaboralempresanombre_Enabled = 1 ;
      edtavCtlexperiencialaboralid_Jsonclick = "" ;
      edtavCtlexperiencialaboralid_Visible = 1 ;
      edtavCtlexperiencialaboralid_Enabled = 1 ;
      subGridexperiencialaboral_Class = "FreeStyleGrid" ;
      edtavCtleducacionhasta_Jsonclick = "" ;
      edtavCtleducacionhasta_Visible = 1 ;
      edtavCtleducacionhasta_Enabled = 1 ;
      edtavCtleducaciondesde_Jsonclick = "" ;
      edtavCtleducaciondesde_Visible = 1 ;
      edtavCtleducaciondesde_Enabled = 1 ;
      edtavCtleducacionpaisdescripcion_Jsonclick = "" ;
      edtavCtleducacionpaisdescripcion_Visible = 1 ;
      edtavCtleducacionpaisdescripcion_Enabled = 1 ;
      edtavCtleducacionnombreinstitucion_Jsonclick = "" ;
      edtavCtleducacionnombreinstitucion_Visible = 1 ;
      edtavCtleducacionnombreinstitucion_Enabled = 1 ;
      edtavCtleducacionid_Jsonclick = "" ;
      edtavCtleducacionid_Visible = 1 ;
      edtavCtleducacionid_Enabled = 1 ;
      subGrideducacion_Class = "FreeStyleGrid" ;
      edtavCtlcostoconsulta_Jsonclick = "" ;
      edtavCtlcostoconsulta_Visible = 1 ;
      edtavCtlcostoconsulta_Enabled = 1 ;
      cmbavCtlsedetipoconsulta.setJsonclick( "" );
      cmbavCtlsedetipoconsulta.setVisible( 1 );
      cmbavCtlsedetipoconsulta.setEnabled( 1 );
      dynavCtlespecialidadid.setJsonclick( "" );
      dynavCtlespecialidadid.setVisible( 1 );
      dynavCtlespecialidadid.setEnabled( 1 );
      subGridespecialidadsede_Class = "FreeStyleGrid" ;
      lblTextblocktercond_Caption = "Text Block" ;
      chkavProfesionalterminoscondiciones.setEnabled( 1 );
      subGridservicios_Allowcollapsing = (byte)(0) ;
      subGridservicios_Backcolorstyle = (byte)(0) ;
      subGridpremios_Allowcollapsing = (byte)(0) ;
      subGridpremios_Backcolorstyle = (byte)(0) ;
      subGridexperiencialaboral_Allowcollapsing = (byte)(0) ;
      subGridexperiencialaboral_Backcolorstyle = (byte)(0) ;
      subGrideducacion_Allowcollapsing = (byte)(0) ;
      subGrideducacion_Backcolorstyle = (byte)(0) ;
      subGridespecialidadsede_Allowcollapsing = (byte)(0) ;
      subGridespecialidadsede_Backcolorstyle = (byte)(0) ;
      Fileuploadimagen_Tooltiptext = "" ;
      edtavProfesionalpassword_Jsonclick = "" ;
      edtavProfesionalpassword_Enabled = 1 ;
      edtavProfesionalcorreo_Jsonclick = "" ;
      edtavProfesionalcorreo_Enabled = 1 ;
      dynavProfesionaldistrito.setJsonclick( "" );
      dynavProfesionaldistrito.setEnabled( 1 );
      dynavProfesionalprovincia.setJsonclick( "" );
      dynavProfesionalprovincia.setEnabled( 1 );
      cmbavProfesionaldepartamento.setJsonclick( "" );
      cmbavProfesionaldepartamento.setEnabled( 1 );
      edtavProfesionaldireccion_Jsonclick = "" ;
      edtavProfesionaldireccion_Enabled = 1 ;
      edtavProfesionalinstagram_Jsonclick = "" ;
      edtavProfesionalinstagram_Enabled = 1 ;
      edtavProfesionalinstagram_Visible = 1 ;
      edtavProfesionaltwitter_Jsonclick = "" ;
      edtavProfesionaltwitter_Enabled = 1 ;
      edtavProfesionaltwitter_Visible = 1 ;
      edtavProfesionallinkedin_Jsonclick = "" ;
      edtavProfesionallinkedin_Enabled = 1 ;
      edtavProfesionallinkedin_Visible = 1 ;
      edtavProfesionalfacebook_Jsonclick = "" ;
      edtavProfesionalfacebook_Enabled = 1 ;
      edtavProfesionalfacebook_Visible = 1 ;
      cmbavProfesionaltiempocita.setJsonclick( "" );
      cmbavProfesionaltiempocita.setEnabled( 1 );
      edtavProfesionaltelefono_Jsonclick = "" ;
      edtavProfesionaltelefono_Enabled = 1 ;
      dynavPaisid.setJsonclick( "" );
      dynavPaisid.setEnabled( 1 );
      edtavProfesionaldescripcion_Jsonclick = "" ;
      edtavProfesionaldescripcion_Enabled = 1 ;
      edtavProfesionalcop_Jsonclick = "" ;
      edtavProfesionalcop_Enabled = 1 ;
      cmbavProfesionalanio.setJsonclick( "" );
      cmbavProfesionalanio.setEnabled( 1 );
      cmbavProfesionalmes.setJsonclick( "" );
      cmbavProfesionalmes.setEnabled( 1 );
      cmbavProfesionaldia.setJsonclick( "" );
      cmbavProfesionaldia.setEnabled( 1 );
      cmbavProfesionalsexo.setJsonclick( "" );
      cmbavProfesionalsexo.setEnabled( 1 );
      edtavProfesionalapellidomaterno_Jsonclick = "" ;
      edtavProfesionalapellidomaterno_Enabled = 1 ;
      edtavProfesionalapellidopaterno_Jsonclick = "" ;
      edtavProfesionalapellidopaterno_Enabled = 1 ;
      edtavProfesionalnombres_Jsonclick = "" ;
      edtavProfesionalnombres_Enabled = 1 ;
      edtavProfesionalnrodocumento_Jsonclick = "" ;
      edtavProfesionalnrodocumento_Enabled = 1 ;
      cmbavProfesionaltipodocumento.setJsonclick( "" );
      cmbavProfesionaltipodocumento.setEnabled( 1 );
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Mi Perfil" );
      Tabpageregistroprofesional_Historymanagement = GXutil.toBoolean( 0) ;
      Tabpageregistroprofesional_Class = "TabPageRegistroProfesional" ;
      Tabpageregistroprofesional_Pagecount = 5 ;
      Fileuploadimagen_Acceptedfiletypes = "image" ;
      Fileuploadimagen_Autodisableaddingfiles = GXutil.toBoolean( 0) ;
      Fileuploadimagen_Maxnumberoffiles = 1 ;
      Fileuploadimagen_Enableuploadedfilecanceling = GXutil.toBoolean( -1) ;
      Fileuploadimagen_Autoupload = GXutil.toBoolean( -1) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavProfesionaltipodocumento.setName( "vPROFESIONALTIPODOCUMENTO" );
      cmbavProfesionaltipodocumento.setWebtags( "" );
      cmbavProfesionaltipodocumento.addItem("", "Seleccionar:", (short)(0));
      cmbavProfesionaltipodocumento.addItem("1", "DNI", (short)(0));
      cmbavProfesionaltipodocumento.addItem("6", "RUC", (short)(0));
      cmbavProfesionaltipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavProfesionaltipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavProfesionaltipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavProfesionaltipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavProfesionaltipodocumento.getItemCount() > 0 )
      {
         AV68ProfesionalTipoDocumento = cmbavProfesionaltipodocumento.getValidValue(AV68ProfesionalTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV68ProfesionalTipoDocumento", AV68ProfesionalTipoDocumento);
      }
      cmbavProfesionalsexo.setName( "vPROFESIONALSEXO" );
      cmbavProfesionalsexo.setWebtags( "" );
      cmbavProfesionalsexo.addItem("M", "Masculino", (short)(0));
      cmbavProfesionalsexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavProfesionalsexo.getItemCount() > 0 )
      {
         AV64ProfesionalSexo = cmbavProfesionalsexo.getValidValue(AV64ProfesionalSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64ProfesionalSexo", AV64ProfesionalSexo);
      }
      cmbavProfesionaldia.setName( "vPROFESIONALDIA" );
      cmbavProfesionaldia.setWebtags( "" );
      if ( cmbavProfesionaldia.getItemCount() > 0 )
      {
         AV47ProfesionalDia = (short)(GXutil.lval( cmbavProfesionaldia.getValidValue(GXutil.trim( GXutil.str( AV47ProfesionalDia, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47ProfesionalDia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47ProfesionalDia), 4, 0));
      }
      cmbavProfesionalmes.setName( "vPROFESIONALMES" );
      cmbavProfesionalmes.setWebtags( "" );
      cmbavProfesionalmes.addItem("01", "Enero", (short)(0));
      cmbavProfesionalmes.addItem("02", "Febrero", (short)(0));
      cmbavProfesionalmes.addItem("03", "Marzo", (short)(0));
      cmbavProfesionalmes.addItem("04", "Abril", (short)(0));
      cmbavProfesionalmes.addItem("05", "Mayo", (short)(0));
      cmbavProfesionalmes.addItem("06", "Junio", (short)(0));
      cmbavProfesionalmes.addItem("07", "Julio", (short)(0));
      cmbavProfesionalmes.addItem("08", "Agosto", (short)(0));
      cmbavProfesionalmes.addItem("09", "Septiembre", (short)(0));
      cmbavProfesionalmes.addItem("10", "Octubre", (short)(0));
      cmbavProfesionalmes.addItem("11", "Noviembre", (short)(0));
      cmbavProfesionalmes.addItem("12", "Diciembre", (short)(0));
      if ( cmbavProfesionalmes.getItemCount() > 0 )
      {
         AV59ProfesionalMes = cmbavProfesionalmes.getValidValue(AV59ProfesionalMes) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59ProfesionalMes", AV59ProfesionalMes);
      }
      cmbavProfesionalanio.setName( "vPROFESIONALANIO" );
      cmbavProfesionalanio.setWebtags( "" );
      if ( cmbavProfesionalanio.getItemCount() > 0 )
      {
         AV39ProfesionalAnio = (short)(GXutil.lval( cmbavProfesionalanio.getValidValue(GXutil.trim( GXutil.str( AV39ProfesionalAnio, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39ProfesionalAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39ProfesionalAnio), 4, 0));
      }
      dynavPaisid.setName( "vPAISID" );
      dynavPaisid.setWebtags( "" );
      cmbavProfesionaltiempocita.setName( "vPROFESIONALTIEMPOCITA" );
      cmbavProfesionaltiempocita.setWebtags( "" );
      cmbavProfesionaltiempocita.addItem("30", "30 minutos", (short)(0));
      cmbavProfesionaltiempocita.addItem("60", "1 hora", (short)(0));
      if ( cmbavProfesionaltiempocita.getItemCount() > 0 )
      {
         AV67ProfesionalTiempoCita = (byte)(GXutil.lval( cmbavProfesionaltiempocita.getValidValue(GXutil.trim( GXutil.str( AV67ProfesionalTiempoCita, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV67ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67ProfesionalTiempoCita), 2, 0));
      }
      cmbavProfesionaldepartamento.setName( "vPROFESIONALDEPARTAMENTO" );
      cmbavProfesionaldepartamento.setWebtags( "" );
      cmbavProfesionaldepartamento.addItem("", "Seleccione:", (short)(0));
      if ( cmbavProfesionaldepartamento.getItemCount() > 0 )
      {
         AV45ProfesionalDepartamento = cmbavProfesionaldepartamento.getValidValue(AV45ProfesionalDepartamento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45ProfesionalDepartamento", AV45ProfesionalDepartamento);
      }
      dynavProfesionalprovincia.setName( "vPROFESIONALPROVINCIA" );
      dynavProfesionalprovincia.setWebtags( "" );
      dynavProfesionaldistrito.setName( "vPROFESIONALDISTRITO" );
      dynavProfesionaldistrito.setWebtags( "" );
      GXCCtl = "CTLESPECIALIDADID_" + sGXsfl_167_idx ;
      dynavCtlespecialidadid.setName( GXCCtl );
      dynavCtlespecialidadid.setWebtags( "" );
      GXCCtl = "CTLSEDETIPOCONSULTA_" + sGXsfl_167_idx ;
      cmbavCtlsedetipoconsulta.setName( GXCCtl );
      cmbavCtlsedetipoconsulta.setWebtags( "" );
      cmbavCtlsedetipoconsulta.addItem("", "Seleccione:", (short)(0));
      cmbavCtlsedetipoconsulta.addItem("V", "Virtual", (short)(0));
      cmbavCtlsedetipoconsulta.addItem("P", "En consultorio", (short)(0));
      cmbavCtlsedetipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbavCtlsedetipoconsulta.getItemCount() > 0 )
      {
         if ( ( AV85GXV1 > 0 ) && ( AV15EspecialidadList.size() >= AV85GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta())==0) )
         {
            ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).setgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta( cmbavCtlsedetipoconsulta.getValidValue(((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV15EspecialidadList.elementAt(-1+AV85GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()) );
         }
      }
      chkavProfesionalterminoscondiciones.setName( "vPROFESIONALTERMINOSCONDICIONES" );
      chkavProfesionalterminoscondiciones.setWebtags( "" );
      chkavProfesionalterminoscondiciones.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavProfesionalterminoscondiciones.getInternalname(), "TitleCaption", chkavProfesionalterminoscondiciones.getCaption(), true);
      chkavProfesionalterminoscondiciones.setCheckedValue( "false" );
      AV66ProfesionalTerminosCondiciones = GXutil.strtobool( GXutil.booltostr( AV66ProfesionalTerminosCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66ProfesionalTerminosCondiciones", AV66ProfesionalTerminosCondiciones);
      /* End function init_web_controls */
   }

   public void validv_Profesionaldepartamento( )
   {
      AV34PaisId = (short)(GXutil.lval( dynavPaisid.getValue())) ;
      AV45ProfesionalDepartamento = cmbavProfesionaldepartamento.getValue() ;
      AV63ProfesionalProvincia = dynavProfesionalprovincia.getValue() ;
      AV49ProfesionalDistrito = dynavProfesionaldistrito.getValue() ;
      GXV2 = (short)(GXutil.lval( dynavCtlespecialidadid.getValue())) ;
      gxvvprofesionalprovincia_html6U2( AV45ProfesionalDepartamento) ;
      gxvvprofesionaldistrito_html6U2( AV45ProfesionalDepartamento, AV63ProfesionalProvincia) ;
      dynload_actions( ) ;
      if ( dynavProfesionalprovincia.getItemCount() > 0 )
      {
         AV63ProfesionalProvincia = dynavProfesionalprovincia.getValidValue(AV63ProfesionalProvincia) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProfesionalprovincia.setValue( GXutil.rtrim( AV63ProfesionalProvincia) );
      }
      if ( dynavProfesionaldistrito.getItemCount() > 0 )
      {
         AV49ProfesionalDistrito = dynavProfesionaldistrito.getValidValue(AV49ProfesionalDistrito) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProfesionaldistrito.setValue( GXutil.rtrim( AV49ProfesionalDistrito) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV63ProfesionalProvincia", AV63ProfesionalProvincia);
      dynavProfesionalprovincia.setValue( GXutil.rtrim( AV63ProfesionalProvincia) );
      httpContext.ajax_rsp_assign_prop("", false, dynavProfesionalprovincia.getInternalname(), "Values", dynavProfesionalprovincia.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV49ProfesionalDistrito", AV49ProfesionalDistrito);
      dynavProfesionaldistrito.setValue( GXutil.rtrim( AV49ProfesionalDistrito) );
      httpContext.ajax_rsp_assign_prop("", false, dynavProfesionaldistrito.getInternalname(), "Values", dynavProfesionaldistrito.ToJavascriptSource(), true);
   }

   public void validv_Profesionalprovincia( )
   {
      AV34PaisId = (short)(GXutil.lval( dynavPaisid.getValue())) ;
      AV45ProfesionalDepartamento = cmbavProfesionaldepartamento.getValue() ;
      AV63ProfesionalProvincia = dynavProfesionalprovincia.getValue() ;
      AV49ProfesionalDistrito = dynavProfesionaldistrito.getValue() ;
      GXV2 = (short)(GXutil.lval( dynavCtlespecialidadid.getValue())) ;
      gxvvprofesionaldistrito_html6U2( AV45ProfesionalDepartamento, AV63ProfesionalProvincia) ;
      dynload_actions( ) ;
      if ( dynavProfesionaldistrito.getItemCount() > 0 )
      {
         AV49ProfesionalDistrito = dynavProfesionaldistrito.getValidValue(AV49ProfesionalDistrito) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProfesionaldistrito.setValue( GXutil.rtrim( AV49ProfesionalDistrito) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV49ProfesionalDistrito", AV49ProfesionalDistrito);
      dynavProfesionaldistrito.setValue( GXutil.rtrim( AV49ProfesionalDistrito) );
      httpContext.ajax_rsp_assign_prop("", false, dynavProfesionaldistrito.getInternalname(), "Values", dynavProfesionaldistrito.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDESPECIALIDADSEDE_nFirstRecordOnPage'},{av:'GRIDESPECIALIDADSEDE_nEOF'},{av:'AV15EspecialidadList',fld:'vESPECIALIDADLIST',grid:167,pic:''},{av:'nRC_GXsfl_167',ctrl:'GRIDESPECIALIDADSEDE',prop:'GridRC',grid:167},{av:'GRIDSERVICIOS_nFirstRecordOnPage'},{av:'GRIDSERVICIOS_nEOF'},{av:'AV76ServiciosList',fld:'vSERVICIOSLIST',grid:299,pic:''},{av:'nRC_GXsfl_299',ctrl:'GRIDSERVICIOS',prop:'GridRC',grid:299},{av:'GRIDPREMIOS_nFirstRecordOnPage'},{av:'GRIDPREMIOS_nEOF'},{av:'AV38PremiosList',fld:'vPREMIOSLIST',grid:266,pic:''},{av:'nRC_GXsfl_266',ctrl:'GRIDPREMIOS',prop:'GridRC',grid:266},{av:'GRIDEXPERIENCIALABORAL_nFirstRecordOnPage'},{av:'GRIDEXPERIENCIALABORAL_nEOF'},{av:'AV18ExperienciaLaboralList',fld:'vEXPERIENCIALABORALLIST',grid:235,pic:''},{av:'nRC_GXsfl_235',ctrl:'GRIDEXPERIENCIALABORAL',prop:'GridRC',grid:235},{av:'GRIDEDUCACION_nFirstRecordOnPage'},{av:'GRIDEDUCACION_nEOF'},{av:'AV12EducacionList',fld:'vEDUCACIONLIST',grid:195,pic:''},{av:'nRC_GXsfl_195',ctrl:'GRIDEDUCACION',prop:'GridRC',grid:195},{av:'AV36Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VPROFESIONALANIO.CONTROLVALUECHANGED","{handler:'e126U2',iparms:[{av:'cmbavProfesionalanio'},{av:'AV39ProfesionalAnio',fld:'vPROFESIONALANIO',pic:'ZZZ9'},{av:'cmbavProfesionalmes'},{av:'AV59ProfesionalMes',fld:'vPROFESIONALMES',pic:''},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VPROFESIONALANIO.CONTROLVALUECHANGED",",oparms:[{av:'cmbavProfesionaldia'},{av:'AV47ProfesionalDia',fld:'vPROFESIONALDIA',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VPROFESIONALMES.CONTROLVALUECHANGED","{handler:'e136U2',iparms:[{av:'cmbavProfesionalanio'},{av:'AV39ProfesionalAnio',fld:'vPROFESIONALANIO',pic:'ZZZ9'},{av:'cmbavProfesionalmes'},{av:'AV59ProfesionalMes',fld:'vPROFESIONALMES',pic:''},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VPROFESIONALMES.CONTROLVALUECHANGED",",oparms:[{av:'cmbavProfesionaldia'},{av:'AV47ProfesionalDia',fld:'vPROFESIONALDIA',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'GUARDARPROFESIONAL'","{handler:'e146U2',iparms:[{av:'cmbavProfesionaldepartamento'},{av:'AV45ProfesionalDepartamento',fld:'vPROFESIONALDEPARTAMENTO',pic:''},{av:'dynavProfesionalprovincia'},{av:'AV63ProfesionalProvincia',fld:'vPROFESIONALPROVINCIA',pic:''},{av:'dynavProfesionaldistrito'},{av:'AV49ProfesionalDistrito',fld:'vPROFESIONALDISTRITO',pic:''},{av:'cmbavProfesionalanio'},{av:'AV39ProfesionalAnio',fld:'vPROFESIONALANIO',pic:'ZZZ9'},{av:'cmbavProfesionalmes'},{av:'AV59ProfesionalMes',fld:'vPROFESIONALMES',pic:''},{av:'cmbavProfesionaldia'},{av:'AV47ProfesionalDia',fld:'vPROFESIONALDIA',pic:'ZZZ9'},{av:'AV41ProfesionalApellidoPaterno',fld:'vPROFESIONALAPELLIDOPATERNO',pic:''},{av:'AV40ProfesionalApellidoMaterno',fld:'vPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV44ProfesionalCorreo',fld:'vPROFESIONALCORREO',pic:''},{av:'AV43ProfesionalCOP',fld:'vPROFESIONALCOP',pic:''},{av:'AV60ProfesionalNombres',fld:'vPROFESIONALNOMBRES',pic:''},{av:'AV61ProfesionalNroDocumento',fld:'vPROFESIONALNRODOCUMENTO',pic:''},{av:'cmbavProfesionaltipodocumento'},{av:'AV68ProfesionalTipoDocumento',fld:'vPROFESIONALTIPODOCUMENTO',pic:''},{av:'cmbavProfesionalsexo'},{av:'AV64ProfesionalSexo',fld:'vPROFESIONALSEXO',pic:''},{av:'AV65ProfesionalTelefono',fld:'vPROFESIONALTELEFONO',pic:''},{av:'AV62ProfesionalPassword',fld:'vPROFESIONALPASSWORD',pic:''},{av:'AV36Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'AV82UploadedFiles',fld:'vUPLOADEDFILES',pic:''},{av:'AV25Mensaje',fld:'vMENSAJE',pic:''},{av:'AV6SecUser',fld:'vSECUSER',pic:''},{av:'AV7SecUserRole',fld:'vSECUSERROLE',pic:''},{av:'A13SecRoleName',fld:'SECROLENAME',pic:''},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV5Profesional',fld:'vPROFESIONAL',pic:''},{av:'AV52ProfesionalFechaNacimiento',fld:'vPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV48ProfesionalDireccion',fld:'vPROFESIONALDIRECCION',pic:''},{av:'AV46ProfesionalDescripcion',fld:'vPROFESIONALDESCRIPCION',pic:''},{av:'cmbavProfesionaltiempocita'},{av:'AV67ProfesionalTiempoCita',fld:'vPROFESIONALTIEMPOCITA',pic:'Z9'},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV81UbigeoCode',fld:'vUBIGEOCODE',pic:''},{av:'AV51ProfesionalFacebook',fld:'vPROFESIONALFACEBOOK',pic:''},{av:'AV69ProfesionalTwitter',fld:'vPROFESIONALTWITTER',pic:''},{av:'AV58ProfesionalLinkedin',fld:'vPROFESIONALLINKEDIN',pic:''},{av:'AV57ProfesionalInstagram',fld:'vPROFESIONALINSTAGRAM',pic:''},{av:'AV12EducacionList',fld:'vEDUCACIONLIST',grid:195,pic:''},{av:'GRIDEDUCACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_195',ctrl:'GRIDEDUCACION',grid:195,prop:'GridRC',grid:195},{av:'AV18ExperienciaLaboralList',fld:'vEXPERIENCIALABORALLIST',grid:235,pic:''},{av:'GRIDEXPERIENCIALABORAL_nFirstRecordOnPage'},{av:'nRC_GXsfl_235',ctrl:'GRIDEXPERIENCIALABORAL',grid:235,prop:'GridRC',grid:235},{av:'AV38PremiosList',fld:'vPREMIOSLIST',grid:266,pic:''},{av:'GRIDPREMIOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_266',ctrl:'GRIDPREMIOS',grid:266,prop:'GridRC',grid:266},{av:'AV76ServiciosList',fld:'vSERVICIOSLIST',grid:299,pic:''},{av:'GRIDSERVICIOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_299',ctrl:'GRIDSERVICIOS',grid:299,prop:'GridRC',grid:299},{av:'AV15EspecialidadList',fld:'vESPECIALIDADLIST',grid:167,pic:''},{av:'GRIDESPECIALIDADSEDE_nFirstRecordOnPage'},{av:'nRC_GXsfl_167',ctrl:'GRIDESPECIALIDADSEDE',grid:167,prop:'GridRC',grid:167},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'GUARDARPROFESIONAL'",",oparms:[{av:'AV81UbigeoCode',fld:'vUBIGEOCODE',pic:''},{av:'AV52ProfesionalFechaNacimiento',fld:'vPROFESIONALFECHANACIMIENTO',pic:''},{av:'AV25Mensaje',fld:'vMENSAJE',pic:''},{av:'AV6SecUser',fld:'vSECUSER',pic:''},{av:'AV7SecUserRole',fld:'vSECUSERROLE',pic:''},{av:'AV5Profesional',fld:'vPROFESIONAL',pic:''},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VPROFESIONALNRODOCUMENTO.CONTROLVALUECHANGED","{handler:'e156U2',iparms:[{av:'cmbavProfesionaltipodocumento'},{av:'AV68ProfesionalTipoDocumento',fld:'vPROFESIONALTIPODOCUMENTO',pic:''},{av:'AV61ProfesionalNroDocumento',fld:'vPROFESIONALNRODOCUMENTO',pic:''},{av:'cmbavProfesionalanio'},{av:'AV39ProfesionalAnio',fld:'vPROFESIONALANIO',pic:'ZZZ9'},{av:'cmbavProfesionalmes'},{av:'AV59ProfesionalMes',fld:'vPROFESIONALMES',pic:''},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VPROFESIONALNRODOCUMENTO.CONTROLVALUECHANGED",",oparms:[{av:'AV40ProfesionalApellidoMaterno',fld:'vPROFESIONALAPELLIDOMATERNO',pic:''},{av:'AV41ProfesionalApellidoPaterno',fld:'vPROFESIONALAPELLIDOPATERNO',pic:''},{av:'cmbavProfesionaldia'},{av:'AV47ProfesionalDia',fld:'vPROFESIONALDIA',pic:'ZZZ9'},{av:'cmbavProfesionalanio'},{av:'AV39ProfesionalAnio',fld:'vPROFESIONALANIO',pic:'ZZZ9'},{av:'cmbavProfesionalmes'},{av:'AV59ProfesionalMes',fld:'vPROFESIONALMES',pic:''},{av:'AV60ProfesionalNombres',fld:'vPROFESIONALNOMBRES',pic:''},{av:'cmbavProfesionalsexo'},{av:'AV64ProfesionalSexo',fld:'vPROFESIONALSEXO',pic:''},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'ADD EDUCACION'","{handler:'e166U2',iparms:[{av:'AV12EducacionList',fld:'vEDUCACIONLIST',grid:195,pic:''},{av:'GRIDEDUCACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_195',ctrl:'GRIDEDUCACION',prop:'GridRC',grid:195},{av:'GRIDESPECIALIDADSEDE_nFirstRecordOnPage'},{av:'GRIDESPECIALIDADSEDE_nEOF'},{av:'AV15EspecialidadList',fld:'vESPECIALIDADLIST',grid:167,pic:''},{av:'nRC_GXsfl_167',ctrl:'GRIDESPECIALIDADSEDE',prop:'GridRC',grid:167},{av:'GRIDSERVICIOS_nFirstRecordOnPage'},{av:'GRIDSERVICIOS_nEOF'},{av:'AV76ServiciosList',fld:'vSERVICIOSLIST',grid:299,pic:''},{av:'nRC_GXsfl_299',ctrl:'GRIDSERVICIOS',prop:'GridRC',grid:299},{av:'GRIDPREMIOS_nFirstRecordOnPage'},{av:'GRIDPREMIOS_nEOF'},{av:'AV38PremiosList',fld:'vPREMIOSLIST',grid:266,pic:''},{av:'nRC_GXsfl_266',ctrl:'GRIDPREMIOS',prop:'GridRC',grid:266},{av:'GRIDEXPERIENCIALABORAL_nFirstRecordOnPage'},{av:'GRIDEXPERIENCIALABORAL_nEOF'},{av:'AV18ExperienciaLaboralList',fld:'vEXPERIENCIALABORALLIST',grid:235,pic:''},{av:'nRC_GXsfl_235',ctrl:'GRIDEXPERIENCIALABORAL',prop:'GridRC',grid:235},{av:'GRIDEDUCACION_nEOF'},{av:'AV36Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'ADD EDUCACION'",",oparms:[{av:'AV12EducacionList',fld:'vEDUCACIONLIST',grid:195,pic:''},{av:'GRIDEDUCACION_nFirstRecordOnPage'},{av:'nRC_GXsfl_195',ctrl:'GRIDEDUCACION',prop:'GridRC',grid:195},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'ADD EXPERIENCIA LABORAL'","{handler:'e176U2',iparms:[{av:'AV18ExperienciaLaboralList',fld:'vEXPERIENCIALABORALLIST',grid:235,pic:''},{av:'GRIDEXPERIENCIALABORAL_nFirstRecordOnPage'},{av:'nRC_GXsfl_235',ctrl:'GRIDEXPERIENCIALABORAL',prop:'GridRC',grid:235},{av:'GRIDESPECIALIDADSEDE_nFirstRecordOnPage'},{av:'GRIDESPECIALIDADSEDE_nEOF'},{av:'AV15EspecialidadList',fld:'vESPECIALIDADLIST',grid:167,pic:''},{av:'nRC_GXsfl_167',ctrl:'GRIDESPECIALIDADSEDE',prop:'GridRC',grid:167},{av:'GRIDSERVICIOS_nFirstRecordOnPage'},{av:'GRIDSERVICIOS_nEOF'},{av:'AV76ServiciosList',fld:'vSERVICIOSLIST',grid:299,pic:''},{av:'nRC_GXsfl_299',ctrl:'GRIDSERVICIOS',prop:'GridRC',grid:299},{av:'GRIDPREMIOS_nFirstRecordOnPage'},{av:'GRIDPREMIOS_nEOF'},{av:'AV38PremiosList',fld:'vPREMIOSLIST',grid:266,pic:''},{av:'nRC_GXsfl_266',ctrl:'GRIDPREMIOS',prop:'GridRC',grid:266},{av:'GRIDEXPERIENCIALABORAL_nEOF'},{av:'GRIDEDUCACION_nFirstRecordOnPage'},{av:'GRIDEDUCACION_nEOF'},{av:'AV12EducacionList',fld:'vEDUCACIONLIST',grid:195,pic:''},{av:'nRC_GXsfl_195',ctrl:'GRIDEDUCACION',prop:'GridRC',grid:195},{av:'AV36Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'ADD EXPERIENCIA LABORAL'",",oparms:[{av:'AV18ExperienciaLaboralList',fld:'vEXPERIENCIALABORALLIST',grid:235,pic:''},{av:'GRIDEXPERIENCIALABORAL_nFirstRecordOnPage'},{av:'nRC_GXsfl_235',ctrl:'GRIDEXPERIENCIALABORAL',prop:'GridRC',grid:235},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'ADD PREMIO'","{handler:'e186U2',iparms:[{av:'AV38PremiosList',fld:'vPREMIOSLIST',grid:266,pic:''},{av:'GRIDPREMIOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_266',ctrl:'GRIDPREMIOS',prop:'GridRC',grid:266},{av:'GRIDESPECIALIDADSEDE_nFirstRecordOnPage'},{av:'GRIDESPECIALIDADSEDE_nEOF'},{av:'AV15EspecialidadList',fld:'vESPECIALIDADLIST',grid:167,pic:''},{av:'nRC_GXsfl_167',ctrl:'GRIDESPECIALIDADSEDE',prop:'GridRC',grid:167},{av:'GRIDSERVICIOS_nFirstRecordOnPage'},{av:'GRIDSERVICIOS_nEOF'},{av:'AV76ServiciosList',fld:'vSERVICIOSLIST',grid:299,pic:''},{av:'nRC_GXsfl_299',ctrl:'GRIDSERVICIOS',prop:'GridRC',grid:299},{av:'GRIDPREMIOS_nEOF'},{av:'GRIDEXPERIENCIALABORAL_nFirstRecordOnPage'},{av:'GRIDEXPERIENCIALABORAL_nEOF'},{av:'AV18ExperienciaLaboralList',fld:'vEXPERIENCIALABORALLIST',grid:235,pic:''},{av:'nRC_GXsfl_235',ctrl:'GRIDEXPERIENCIALABORAL',prop:'GridRC',grid:235},{av:'GRIDEDUCACION_nFirstRecordOnPage'},{av:'GRIDEDUCACION_nEOF'},{av:'AV12EducacionList',fld:'vEDUCACIONLIST',grid:195,pic:''},{av:'nRC_GXsfl_195',ctrl:'GRIDEDUCACION',prop:'GridRC',grid:195},{av:'AV36Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'ADD PREMIO'",",oparms:[{av:'AV38PremiosList',fld:'vPREMIOSLIST',grid:266,pic:''},{av:'GRIDPREMIOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_266',ctrl:'GRIDPREMIOS',prop:'GridRC',grid:266},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'ADD NEW SERVICIO'","{handler:'e196U2',iparms:[{av:'AV76ServiciosList',fld:'vSERVICIOSLIST',grid:299,pic:''},{av:'GRIDSERVICIOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_299',ctrl:'GRIDSERVICIOS',prop:'GridRC',grid:299},{av:'GRIDESPECIALIDADSEDE_nFirstRecordOnPage'},{av:'GRIDESPECIALIDADSEDE_nEOF'},{av:'AV15EspecialidadList',fld:'vESPECIALIDADLIST',grid:167,pic:''},{av:'nRC_GXsfl_167',ctrl:'GRIDESPECIALIDADSEDE',prop:'GridRC',grid:167},{av:'GRIDSERVICIOS_nEOF'},{av:'GRIDPREMIOS_nFirstRecordOnPage'},{av:'GRIDPREMIOS_nEOF'},{av:'AV38PremiosList',fld:'vPREMIOSLIST',grid:266,pic:''},{av:'nRC_GXsfl_266',ctrl:'GRIDPREMIOS',prop:'GridRC',grid:266},{av:'GRIDEXPERIENCIALABORAL_nFirstRecordOnPage'},{av:'GRIDEXPERIENCIALABORAL_nEOF'},{av:'AV18ExperienciaLaboralList',fld:'vEXPERIENCIALABORALLIST',grid:235,pic:''},{av:'nRC_GXsfl_235',ctrl:'GRIDEXPERIENCIALABORAL',prop:'GridRC',grid:235},{av:'GRIDEDUCACION_nFirstRecordOnPage'},{av:'GRIDEDUCACION_nEOF'},{av:'AV12EducacionList',fld:'vEDUCACIONLIST',grid:195,pic:''},{av:'nRC_GXsfl_195',ctrl:'GRIDEDUCACION',prop:'GridRC',grid:195},{av:'AV36Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'ADD NEW SERVICIO'",",oparms:[{av:'AV76ServiciosList',fld:'vSERVICIOSLIST',grid:299,pic:''},{av:'GRIDSERVICIOS_nFirstRecordOnPage'},{av:'nRC_GXsfl_299',ctrl:'GRIDSERVICIOS',prop:'GridRC',grid:299},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'ADD NEW ESPECIALIDAD'","{handler:'e206U2',iparms:[{av:'AV15EspecialidadList',fld:'vESPECIALIDADLIST',grid:167,pic:''},{av:'GRIDESPECIALIDADSEDE_nFirstRecordOnPage'},{av:'nRC_GXsfl_167',ctrl:'GRIDESPECIALIDADSEDE',prop:'GridRC',grid:167},{av:'GRIDESPECIALIDADSEDE_nEOF'},{av:'GRIDSERVICIOS_nFirstRecordOnPage'},{av:'GRIDSERVICIOS_nEOF'},{av:'AV76ServiciosList',fld:'vSERVICIOSLIST',grid:299,pic:''},{av:'nRC_GXsfl_299',ctrl:'GRIDSERVICIOS',prop:'GridRC',grid:299},{av:'GRIDPREMIOS_nFirstRecordOnPage'},{av:'GRIDPREMIOS_nEOF'},{av:'AV38PremiosList',fld:'vPREMIOSLIST',grid:266,pic:''},{av:'nRC_GXsfl_266',ctrl:'GRIDPREMIOS',prop:'GridRC',grid:266},{av:'GRIDEXPERIENCIALABORAL_nFirstRecordOnPage'},{av:'GRIDEXPERIENCIALABORAL_nEOF'},{av:'AV18ExperienciaLaboralList',fld:'vEXPERIENCIALABORALLIST',grid:235,pic:''},{av:'nRC_GXsfl_235',ctrl:'GRIDEXPERIENCIALABORAL',prop:'GridRC',grid:235},{av:'GRIDEDUCACION_nFirstRecordOnPage'},{av:'GRIDEDUCACION_nEOF'},{av:'AV12EducacionList',fld:'vEDUCACIONLIST',grid:195,pic:''},{av:'nRC_GXsfl_195',ctrl:'GRIDEDUCACION',prop:'GridRC',grid:195},{av:'AV36Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'ADD NEW ESPECIALIDAD'",",oparms:[{av:'AV15EspecialidadList',fld:'vESPECIALIDADLIST',grid:167,pic:''},{av:'GRIDESPECIALIDADSEDE_nFirstRecordOnPage'},{av:'nRC_GXsfl_167',ctrl:'GRIDESPECIALIDADSEDE',prop:'GridRC',grid:167},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'SALIR '","{handler:'e116U1',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'SALIR '",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALTIPODOCUMENTO","{handler:'validv_Profesionaltipodocumento',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALTIPODOCUMENTO",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALSEXO","{handler:'validv_Profesionalsexo',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALSEXO",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALMES","{handler:'validv_Profesionalmes',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALMES",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALTIEMPOCITA","{handler:'validv_Profesionaltiempocita',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALTIEMPOCITA",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALFACEBOOK","{handler:'validv_Profesionalfacebook',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALFACEBOOK",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALLINKEDIN","{handler:'validv_Profesionallinkedin',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALLINKEDIN",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALTWITTER","{handler:'validv_Profesionaltwitter',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALTWITTER",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALINSTAGRAM","{handler:'validv_Profesionalinstagram',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALINSTAGRAM",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALDEPARTAMENTO","{handler:'validv_Profesionaldepartamento',iparms:[{av:'cmbavProfesionaldepartamento'},{av:'AV45ProfesionalDepartamento',fld:'vPROFESIONALDEPARTAMENTO',pic:''},{av:'dynavProfesionalprovincia'},{av:'AV63ProfesionalProvincia',fld:'vPROFESIONALPROVINCIA',pic:''},{av:'dynavProfesionaldistrito'},{av:'AV49ProfesionalDistrito',fld:'vPROFESIONALDISTRITO',pic:''},{av:'dynavCtlespecialidadid'},{av:'GXV2',fld:'CTLESPECIALIDADID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALDEPARTAMENTO",",oparms:[{av:'dynavProfesionalprovincia'},{av:'AV63ProfesionalProvincia',fld:'vPROFESIONALPROVINCIA',pic:''},{av:'dynavProfesionaldistrito'},{av:'AV49ProfesionalDistrito',fld:'vPROFESIONALDISTRITO',pic:''},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALPROVINCIA","{handler:'validv_Profesionalprovincia',iparms:[{av:'cmbavProfesionaldepartamento'},{av:'AV45ProfesionalDepartamento',fld:'vPROFESIONALDEPARTAMENTO',pic:''},{av:'dynavProfesionalprovincia'},{av:'AV63ProfesionalProvincia',fld:'vPROFESIONALPROVINCIA',pic:''},{av:'dynavProfesionaldistrito'},{av:'AV49ProfesionalDistrito',fld:'vPROFESIONALDISTRITO',pic:''},{av:'dynavCtlespecialidadid'},{av:'GXV2',fld:'CTLESPECIALIDADID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALPROVINCIA",",oparms:[{av:'dynavProfesionaldistrito'},{av:'AV49ProfesionalDistrito',fld:'vPROFESIONALDISTRITO',pic:''},{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALCORREO","{handler:'validv_Profesionalcorreo',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALCORREO",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV3","{handler:'validv_Gxv3',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV3",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv4',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV6","{handler:'validv_Gxv6',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV6",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv10',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV12","{handler:'validv_Gxv12',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV12",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv15',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV17","{handler:'validv_Gxv17',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV17",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv20',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV22","{handler:'validv_Gxv22',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV22",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv23',iparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'dynavPaisid'},{av:'AV34PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV66ProfesionalTerminosCondiciones',fld:'vPROFESIONALTERMINOSCONDICIONES',pic:''}]}");
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
      AV45ProfesionalDepartamento = "" ;
      AV63ProfesionalProvincia = "" ;
      AV36Pattern = "" ;
      Gx_date = GXutil.nullDate() ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV12EducacionList = new GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion>(com.projectthani.SdtSDTProfesionalEducacion.class, "SDTProfesionalEducacion", "ProjectThani", remoteHandle);
      AV18ExperienciaLaboralList = new GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral>(com.projectthani.SdtSDTProfesionalExperienciaLaboral.class, "SDTProfesionalExperienciaLaboral", "ProjectThani", remoteHandle);
      AV38PremiosList = new GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios>(com.projectthani.SdtSDTProfesionalPremios.class, "SDTProfesionalPremios", "ProjectThani", remoteHandle);
      AV76ServiciosList = new GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios>(com.projectthani.SdtSDTProfesionalServicios.class, "SDTProfesionalServicios", "ProjectThani", remoteHandle);
      AV15EspecialidadList = new GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede>(com.projectthani.SdtSDTProfesionalEspecialidadSede.class, "SDTProfesionalEspecialidadSede", "ProjectThani", remoteHandle);
      AV82UploadedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV19FailedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV25Mensaje = new GXSimpleCollection<String>(String.class, "internal", "");
      AV6SecUser = new com.projectthani.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV7SecUserRole = new com.projectthani.wwpbaseobjects.SdtSecUserRole(remoteHandle);
      A13SecRoleName = "" ;
      AV5Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV52ProfesionalFechaNacimiento = GXutil.nullDate() ;
      AV81UbigeoCode = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      lblTextblockinfosolicitadaprof_Jsonclick = "" ;
      TempTags = "" ;
      AV68ProfesionalTipoDocumento = "" ;
      AV61ProfesionalNroDocumento = "" ;
      AV60ProfesionalNombres = "" ;
      AV41ProfesionalApellidoPaterno = "" ;
      AV40ProfesionalApellidoMaterno = "" ;
      AV64ProfesionalSexo = "" ;
      AV59ProfesionalMes = "" ;
      AV43ProfesionalCOP = "" ;
      AV46ProfesionalDescripcion = "" ;
      AV65ProfesionalTelefono = "" ;
      AV67ProfesionalTiempoCita = (byte)(30) ;
      AV51ProfesionalFacebook = "" ;
      AV58ProfesionalLinkedin = "" ;
      AV69ProfesionalTwitter = "" ;
      AV57ProfesionalInstagram = "" ;
      AV48ProfesionalDireccion = "" ;
      AV49ProfesionalDistrito = "" ;
      AV44ProfesionalCorreo = "" ;
      AV62ProfesionalPassword = "" ;
      ucFileuploadimagen = new com.genexus.webpanels.GXUserControl();
      ucTabpageregistroprofesional = new com.genexus.webpanels.GXUserControl();
      lblTabpageregistroprofesional_title_Jsonclick = "" ;
      GridespecialidadsedeContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGridespecialidadsede_Header = "" ;
      GridespecialidadsedeColumn = new com.genexus.webpanels.GXWebColumn();
      bttAddnewespecialidad_Jsonclick = "" ;
      lblTabpage2_title_Jsonclick = "" ;
      GrideducacionContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGrideducacion_Header = "" ;
      GrideducacionColumn = new com.genexus.webpanels.GXWebColumn();
      bttAddeducacion_Jsonclick = "" ;
      lblTabpage3_title_Jsonclick = "" ;
      GridexperiencialaboralContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGridexperiencialaboral_Header = "" ;
      GridexperiencialaboralColumn = new com.genexus.webpanels.GXWebColumn();
      bttAddexperiencialaboral_Jsonclick = "" ;
      lblTabpage1_title_Jsonclick = "" ;
      GridpremiosContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGridpremios_Header = "" ;
      GridpremiosColumn = new com.genexus.webpanels.GXWebColumn();
      bttAddpremio_Jsonclick = "" ;
      lblTabpage4_title_Jsonclick = "" ;
      GridserviciosContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGridservicios_Header = "" ;
      GridserviciosColumn = new com.genexus.webpanels.GXWebColumn();
      bttAddnewservicio_Jsonclick = "" ;
      lblTextblocktercond_Jsonclick = "" ;
      bttGuardarprofesional_Jsonclick = "" ;
      bttSalir_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H006U2_A43PaisId = new short[1] ;
      H006U2_A184PaisDescripcion = new String[] {""} ;
      H006U3_A44UbigeoCode = new String[] {""} ;
      H006U3_A187UbigeoProvincia = new String[] {""} ;
      H006U3_A296UbigeoProvinciaCode = new String[] {""} ;
      H006U3_A295UbigeoDepartamentoCode = new String[] {""} ;
      H006U4_A44UbigeoCode = new String[] {""} ;
      H006U4_A188UbigeoDistrito = new String[] {""} ;
      H006U4_A297UbigeoDistritoCode = new String[] {""} ;
      H006U4_A295UbigeoDepartamentoCode = new String[] {""} ;
      H006U4_A296UbigeoProvinciaCode = new String[] {""} ;
      H006U5_A32EspecialidadId = new short[1] ;
      H006U5_A71EspecialidadNombre = new String[] {""} ;
      H006U7_A40000ProfesionalId = new int[1] ;
      H006U7_n40000ProfesionalId = new boolean[] {false} ;
      H006U9_A40001SecUserId = new short[1] ;
      H006U9_n40001SecUserId = new boolean[] {false} ;
      H006U10_A186UbigeoDepartamento = new String[] {""} ;
      H006U10_A295UbigeoDepartamentoCode = new String[] {""} ;
      H006U10_A44UbigeoCode = new String[] {""} ;
      A186UbigeoDepartamento = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A44UbigeoCode = "" ;
      AV22HtmlTerminosCondiciones = "" ;
      AV30NewEspecialidad = new com.projectthani.SdtSDTProfesionalEspecialidadSede(remoteHandle, context);
      AV29NewEducacion = new com.projectthani.SdtSDTProfesionalEducacion(remoteHandle, context);
      AV31NewExperienciaLaboral = new com.projectthani.SdtSDTProfesionalExperienciaLaboral(remoteHandle, context);
      AV33NewServicios = new com.projectthani.SdtSDTProfesionalServicios(remoteHandle, context);
      AV32NewPremios = new com.projectthani.SdtSDTProfesionalPremios(remoteHandle, context);
      AV78TempFechaNac = GXutil.nullDate() ;
      H006U12_A40000ProfesionalId = new int[1] ;
      H006U12_n40000ProfesionalId = new boolean[] {false} ;
      H006U14_A40001SecUserId = new short[1] ;
      H006U14_n40001SecUserId = new boolean[] {false} ;
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      H006U15_A13SecRoleName = new String[] {""} ;
      H006U15_A4SecRoleId = new short[1] ;
      AV11Educacion = new com.projectthani.SdtProfesional_Educacion(remoteHandle);
      AV17ExperienciaLaboral = new com.projectthani.SdtProfesional_ExperienciaLaboral(remoteHandle);
      AV37Premios = new com.projectthani.SdtProfesional_Premios(remoteHandle);
      AV75Servicios = new com.projectthani.SdtProfesional_Servicios(remoteHandle);
      AV8WebSession = httpContext.getWebSession();
      AV28MsgSuccss = "" ;
      AV79textoMensaj = "" ;
      AV26Mensajei = "" ;
      AV72SDTResponseDni = new com.projectthani.SdtSDTResponseDni(remoteHandle, context);
      GXv_int2 = new int[1] ;
      AV70result = "" ;
      GXv_char3 = new String[1] ;
      AV73SDTResponseWSDni = new com.projectthani.SdtSDTResponseWSDni(remoteHandle, context);
      AV27MesTemporal = "" ;
      GridespecialidadsedeRow = new com.genexus.webpanels.GXWebRow();
      GridserviciosRow = new com.genexus.webpanels.GXWebRow();
      GridpremiosRow = new com.genexus.webpanels.GXWebRow();
      GridexperiencialaboralRow = new com.genexus.webpanels.GXWebRow();
      GrideducacionRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridespecialidadsede_Linesclass = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      subGrideducacion_Linesclass = "" ;
      subGridexperiencialaboral_Linesclass = "" ;
      subGridpremios_Linesclass = "" ;
      subGridservicios_Linesclass = "" ;
      ZV63ProfesionalProvincia = "" ;
      ZV49ProfesionalDistrito = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpmiperfilprofesional__default(),
         new Object[] {
             new Object[] {
            H006U2_A43PaisId, H006U2_A184PaisDescripcion
            }
            , new Object[] {
            H006U3_A44UbigeoCode, H006U3_A187UbigeoProvincia, H006U3_A296UbigeoProvinciaCode, H006U3_A295UbigeoDepartamentoCode
            }
            , new Object[] {
            H006U4_A44UbigeoCode, H006U4_A188UbigeoDistrito, H006U4_A297UbigeoDistritoCode, H006U4_A295UbigeoDepartamentoCode, H006U4_A296UbigeoProvinciaCode
            }
            , new Object[] {
            H006U5_A32EspecialidadId, H006U5_A71EspecialidadNombre
            }
            , new Object[] {
            H006U7_A40000ProfesionalId, H006U7_n40000ProfesionalId
            }
            , new Object[] {
            H006U9_A40001SecUserId, H006U9_n40001SecUserId
            }
            , new Object[] {
            H006U10_A186UbigeoDepartamento, H006U10_A295UbigeoDepartamentoCode, H006U10_A44UbigeoCode
            }
            , new Object[] {
            H006U12_A40000ProfesionalId, H006U12_n40000ProfesionalId
            }
            , new Object[] {
            H006U14_A40001SecUserId, H006U14_n40001SecUserId
            }
            , new Object[] {
            H006U15_A13SecRoleName, H006U15_A4SecRoleId
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV67ProfesionalTiempoCita ;
   private byte subGridespecialidadsede_Backcolorstyle ;
   private byte subGridespecialidadsede_Allowselection ;
   private byte subGridespecialidadsede_Allowhovering ;
   private byte subGridespecialidadsede_Allowcollapsing ;
   private byte subGridespecialidadsede_Collapsed ;
   private byte subGrideducacion_Backcolorstyle ;
   private byte subGrideducacion_Allowselection ;
   private byte subGrideducacion_Allowhovering ;
   private byte subGrideducacion_Allowcollapsing ;
   private byte subGrideducacion_Collapsed ;
   private byte subGridexperiencialaboral_Backcolorstyle ;
   private byte subGridexperiencialaboral_Allowselection ;
   private byte subGridexperiencialaboral_Allowhovering ;
   private byte subGridexperiencialaboral_Allowcollapsing ;
   private byte subGridexperiencialaboral_Collapsed ;
   private byte subGridpremios_Backcolorstyle ;
   private byte subGridpremios_Allowselection ;
   private byte subGridpremios_Allowhovering ;
   private byte subGridpremios_Allowcollapsing ;
   private byte subGridpremios_Collapsed ;
   private byte subGridservicios_Backcolorstyle ;
   private byte subGridservicios_Allowselection ;
   private byte subGridservicios_Allowhovering ;
   private byte subGridservicios_Allowcollapsing ;
   private byte subGridservicios_Collapsed ;
   private byte nDonePA ;
   private byte GRIDESPECIALIDADSEDE_nEOF ;
   private byte GRIDSERVICIOS_nEOF ;
   private byte GRIDPREMIOS_nEOF ;
   private byte GRIDEXPERIENCIALABORAL_nEOF ;
   private byte GRIDEDUCACION_nEOF ;
   private byte nGXWrapped ;
   private byte subGridespecialidadsede_Backstyle ;
   private byte subGrideducacion_Backstyle ;
   private byte subGridexperiencialaboral_Backstyle ;
   private byte subGridpremios_Backstyle ;
   private byte subGridservicios_Backstyle ;
   private short nRcdExists_8 ;
   private short nIsMod_8 ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV34PaisId ;
   private short A4SecRoleId ;
   private short A40001SecUserId ;
   private short wbEnd ;
   private short wbStart ;
   private short AV47ProfesionalDia ;
   private short AV39ProfesionalAnio ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV24i ;
   private short AV74SedeId ;
   private short AV23httpstatus ;
   private short GXV2=0 ;
   private int nRC_GXsfl_167 ;
   private int nRC_GXsfl_195 ;
   private int nRC_GXsfl_235 ;
   private int nRC_GXsfl_266 ;
   private int nRC_GXsfl_299 ;
   private int nGXsfl_167_idx=1 ;
   private int Fileuploadimagen_Maxnumberoffiles ;
   private int Tabpageregistroprofesional_Pagecount ;
   private int nGXsfl_195_idx=1 ;
   private int nGXsfl_235_idx=1 ;
   private int nGXsfl_266_idx=1 ;
   private int nGXsfl_299_idx=1 ;
   private int A40000ProfesionalId ;
   private int edtavProfesionalnrodocumento_Enabled ;
   private int edtavProfesionalnombres_Enabled ;
   private int edtavProfesionalapellidopaterno_Enabled ;
   private int edtavProfesionalapellidomaterno_Enabled ;
   private int edtavProfesionalcop_Enabled ;
   private int edtavProfesionaldescripcion_Enabled ;
   private int edtavProfesionaltelefono_Enabled ;
   private int edtavProfesionalfacebook_Visible ;
   private int edtavProfesionalfacebook_Enabled ;
   private int edtavProfesionallinkedin_Visible ;
   private int edtavProfesionallinkedin_Enabled ;
   private int edtavProfesionaltwitter_Visible ;
   private int edtavProfesionaltwitter_Enabled ;
   private int edtavProfesionalinstagram_Visible ;
   private int edtavProfesionalinstagram_Enabled ;
   private int edtavProfesionaldireccion_Enabled ;
   private int edtavProfesionalcorreo_Enabled ;
   private int edtavProfesionalpassword_Enabled ;
   private int subGridespecialidadsede_Selectedindex ;
   private int subGridespecialidadsede_Selectioncolor ;
   private int subGridespecialidadsede_Hoveringcolor ;
   private int AV85GXV1 ;
   private int subGrideducacion_Selectedindex ;
   private int subGrideducacion_Selectioncolor ;
   private int subGrideducacion_Hoveringcolor ;
   private int AV89GXV5 ;
   private int subGridexperiencialaboral_Selectedindex ;
   private int subGridexperiencialaboral_Selectioncolor ;
   private int subGridexperiencialaboral_Hoveringcolor ;
   private int AV95GXV11 ;
   private int subGridpremios_Selectedindex ;
   private int subGridpremios_Selectioncolor ;
   private int subGridpremios_Hoveringcolor ;
   private int AV100GXV16 ;
   private int subGridservicios_Selectedindex ;
   private int subGridservicios_Selectioncolor ;
   private int subGridservicios_Hoveringcolor ;
   private int AV105GXV21 ;
   private int gxdynajaxindex ;
   private int subGridespecialidadsede_Islastpage ;
   private int subGridservicios_Islastpage ;
   private int subGridpremios_Islastpage ;
   private int subGridexperiencialaboral_Islastpage ;
   private int subGrideducacion_Islastpage ;
   private int nGXsfl_167_fel_idx=1 ;
   private int nGXsfl_195_fel_idx=1 ;
   private int nGXsfl_235_fel_idx=1 ;
   private int nGXsfl_266_fel_idx=1 ;
   private int nGXsfl_299_fel_idx=1 ;
   private int AV116GXV24 ;
   private int GXv_int2[] ;
   private int nGXsfl_195_bak_idx=1 ;
   private int nGXsfl_235_bak_idx=1 ;
   private int nGXsfl_266_bak_idx=1 ;
   private int nGXsfl_299_bak_idx=1 ;
   private int nGXsfl_167_bak_idx=1 ;
   private int idxLst ;
   private int subGridespecialidadsede_Backcolor ;
   private int subGridespecialidadsede_Allbackcolor ;
   private int edtavCtlcostoconsulta_Enabled ;
   private int edtavCtlcostoconsulta_Visible ;
   private int subGrideducacion_Backcolor ;
   private int subGrideducacion_Allbackcolor ;
   private int edtavCtleducacionid_Enabled ;
   private int edtavCtleducacionid_Visible ;
   private int edtavCtleducacionnombreinstitucion_Enabled ;
   private int edtavCtleducacionnombreinstitucion_Visible ;
   private int edtavCtleducacionpaisdescripcion_Enabled ;
   private int edtavCtleducacionpaisdescripcion_Visible ;
   private int edtavCtleducaciondesde_Enabled ;
   private int edtavCtleducaciondesde_Visible ;
   private int edtavCtleducacionhasta_Enabled ;
   private int edtavCtleducacionhasta_Visible ;
   private int subGridexperiencialaboral_Backcolor ;
   private int subGridexperiencialaboral_Allbackcolor ;
   private int edtavCtlexperiencialaboralid_Enabled ;
   private int edtavCtlexperiencialaboralid_Visible ;
   private int edtavCtlexperiencialaboralempresanombre_Enabled ;
   private int edtavCtlexperiencialaboralempresanombre_Visible ;
   private int edtavCtlexperiencialaboraldesde_Enabled ;
   private int edtavCtlexperiencialaboraldesde_Visible ;
   private int edtavCtlexperiencialaboralhasta_Enabled ;
   private int edtavCtlexperiencialaboralhasta_Visible ;
   private int subGridpremios_Backcolor ;
   private int subGridpremios_Allbackcolor ;
   private int edtavCtlpremiosid_Enabled ;
   private int edtavCtlpremiosid_Visible ;
   private int edtavCtlpremiosnombre_Enabled ;
   private int edtavCtlpremiosnombre_Visible ;
   private int edtavCtlpremiosfecha_Enabled ;
   private int edtavCtlpremiosfecha_Visible ;
   private int edtavCtlpremiosdescripcion_Enabled ;
   private int edtavCtlpremiosdescripcion_Visible ;
   private int subGridservicios_Backcolor ;
   private int subGridservicios_Allbackcolor ;
   private int edtavCtlserviciosid_Enabled ;
   private int edtavCtlserviciosid_Visible ;
   private int edtavCtlserviciosnombre_Enabled ;
   private int edtavCtlserviciosnombre_Visible ;
   private long GRIDESPECIALIDADSEDE_nCurrentRecord ;
   private long GRIDEDUCACION_nCurrentRecord ;
   private long GRIDEXPERIENCIALABORAL_nCurrentRecord ;
   private long GRIDPREMIOS_nCurrentRecord ;
   private long GRIDSERVICIOS_nCurrentRecord ;
   private long GRIDESPECIALIDADSEDE_nFirstRecordOnPage ;
   private long GRIDSERVICIOS_nFirstRecordOnPage ;
   private long GRIDPREMIOS_nFirstRecordOnPage ;
   private long GRIDEXPERIENCIALABORAL_nFirstRecordOnPage ;
   private long GRIDEDUCACION_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_167_idx="0001" ;
   private String Fileuploadimagen_Acceptedfiletypes ;
   private String Tabpageregistroprofesional_Class ;
   private String sGXsfl_195_idx="0001" ;
   private String sGXsfl_235_idx="0001" ;
   private String sGXsfl_266_idx="0001" ;
   private String sGXsfl_299_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV81UbigeoCode ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTable1_Internalname ;
   private String divTable3_Internalname ;
   private String divTable4_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgImage2_Internalname ;
   private String lblTextblockinfosolicitadaprof_Internalname ;
   private String lblTextblockinfosolicitadaprof_Jsonclick ;
   private String grpGroup5_Internalname ;
   private String divGroup5table_Internalname ;
   private String divTable5_Internalname ;
   private String TempTags ;
   private String AV68ProfesionalTipoDocumento ;
   private String edtavProfesionalnrodocumento_Internalname ;
   private String edtavProfesionalnrodocumento_Jsonclick ;
   private String edtavProfesionalnombres_Internalname ;
   private String edtavProfesionalnombres_Jsonclick ;
   private String edtavProfesionalapellidopaterno_Internalname ;
   private String edtavProfesionalapellidopaterno_Jsonclick ;
   private String edtavProfesionalapellidomaterno_Internalname ;
   private String edtavProfesionalapellidomaterno_Jsonclick ;
   private String AV64ProfesionalSexo ;
   private String grpGroup1_Internalname ;
   private String divGroup1table1_Internalname ;
   private String edtavProfesionalcop_Internalname ;
   private String edtavProfesionalcop_Jsonclick ;
   private String edtavProfesionaldescripcion_Internalname ;
   private String edtavProfesionaldescripcion_Jsonclick ;
   private String edtavProfesionaltelefono_Internalname ;
   private String AV65ProfesionalTelefono ;
   private String edtavProfesionaltelefono_Jsonclick ;
   private String edtavProfesionalfacebook_Internalname ;
   private String edtavProfesionalfacebook_Jsonclick ;
   private String edtavProfesionallinkedin_Internalname ;
   private String edtavProfesionallinkedin_Jsonclick ;
   private String edtavProfesionaltwitter_Internalname ;
   private String edtavProfesionaltwitter_Jsonclick ;
   private String edtavProfesionalinstagram_Internalname ;
   private String edtavProfesionalinstagram_Jsonclick ;
   private String grpGroup6_Internalname ;
   private String divGroup6table_Internalname ;
   private String edtavProfesionaldireccion_Internalname ;
   private String edtavProfesionaldireccion_Jsonclick ;
   private String grpGroup2_Internalname ;
   private String divGroup2table_Internalname ;
   private String edtavProfesionalcorreo_Internalname ;
   private String edtavProfesionalcorreo_Jsonclick ;
   private String edtavProfesionalpassword_Internalname ;
   private String edtavProfesionalpassword_Jsonclick ;
   private String grpGroup4_Internalname ;
   private String divGroup4table_Internalname ;
   private String Fileuploadimagen_Tooltiptext ;
   private String Fileuploadimagen_Internalname ;
   private String grpGroup7_Internalname ;
   private String divGroup7table_Internalname ;
   private String Tabpageregistroprofesional_Internalname ;
   private String lblTabpageregistroprofesional_title_Internalname ;
   private String lblTabpageregistroprofesional_title_Jsonclick ;
   private String divTabpage1table_Internalname ;
   private String divTable10_Internalname ;
   private String sStyleString ;
   private String subGridespecialidadsede_Internalname ;
   private String subGridespecialidadsede_Header ;
   private String bttAddnewespecialidad_Internalname ;
   private String bttAddnewespecialidad_Jsonclick ;
   private String lblTabpage2_title_Internalname ;
   private String lblTabpage2_title_Jsonclick ;
   private String divTabpage2table_Internalname ;
   private String divTable6_Internalname ;
   private String subGrideducacion_Internalname ;
   private String subGrideducacion_Header ;
   private String bttAddeducacion_Internalname ;
   private String bttAddeducacion_Jsonclick ;
   private String lblTabpage3_title_Internalname ;
   private String lblTabpage3_title_Jsonclick ;
   private String divTabpage3table_Internalname ;
   private String divTable7_Internalname ;
   private String subGridexperiencialaboral_Internalname ;
   private String subGridexperiencialaboral_Header ;
   private String bttAddexperiencialaboral_Internalname ;
   private String bttAddexperiencialaboral_Jsonclick ;
   private String lblTabpage1_title_Internalname ;
   private String lblTabpage1_title_Jsonclick ;
   private String divTabpage1table1_Internalname ;
   private String divTable8_Internalname ;
   private String subGridpremios_Internalname ;
   private String subGridpremios_Header ;
   private String bttAddpremio_Internalname ;
   private String bttAddpremio_Jsonclick ;
   private String lblTabpage4_title_Internalname ;
   private String lblTabpage4_title_Jsonclick ;
   private String divTabpage4table_Internalname ;
   private String divTable9_Internalname ;
   private String subGridservicios_Internalname ;
   private String subGridservicios_Header ;
   private String bttAddnewservicio_Internalname ;
   private String bttAddnewservicio_Jsonclick ;
   private String lblTextblocktercond_Internalname ;
   private String lblTextblocktercond_Caption ;
   private String lblTextblocktercond_Jsonclick ;
   private String bttGuardarprofesional_Internalname ;
   private String bttGuardarprofesional_Jsonclick ;
   private String bttSalir_Internalname ;
   private String bttSalir_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String sGXsfl_167_fel_idx="0001" ;
   private String sGXsfl_195_fel_idx="0001" ;
   private String sGXsfl_235_fel_idx="0001" ;
   private String sGXsfl_266_fel_idx="0001" ;
   private String sGXsfl_299_fel_idx="0001" ;
   private String A44UbigeoCode ;
   private String GXv_char3[] ;
   private String edtavCtlcostoconsulta_Internalname ;
   private String subGridespecialidadsede_Class ;
   private String subGridespecialidadsede_Linesclass ;
   private String divGrid1table2_Internalname ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtavCtlcostoconsulta_Jsonclick ;
   private String edtavCtleducacionid_Internalname ;
   private String edtavCtleducacionnombreinstitucion_Internalname ;
   private String edtavCtleducacionpaisdescripcion_Internalname ;
   private String edtavCtleducaciondesde_Internalname ;
   private String edtavCtleducacionhasta_Internalname ;
   private String subGrideducacion_Class ;
   private String subGrideducacion_Linesclass ;
   private String divGrid2table_Internalname ;
   private String edtavCtleducacionid_Jsonclick ;
   private String edtavCtleducacionnombreinstitucion_Jsonclick ;
   private String edtavCtleducacionpaisdescripcion_Jsonclick ;
   private String edtavCtleducaciondesde_Jsonclick ;
   private String edtavCtleducacionhasta_Jsonclick ;
   private String edtavCtlexperiencialaboralid_Internalname ;
   private String edtavCtlexperiencialaboralempresanombre_Internalname ;
   private String edtavCtlexperiencialaboraldesde_Internalname ;
   private String edtavCtlexperiencialaboralhasta_Internalname ;
   private String subGridexperiencialaboral_Class ;
   private String subGridexperiencialaboral_Linesclass ;
   private String divGrid1table_Internalname ;
   private String edtavCtlexperiencialaboralid_Jsonclick ;
   private String edtavCtlexperiencialaboralempresanombre_Jsonclick ;
   private String edtavCtlexperiencialaboraldesde_Jsonclick ;
   private String edtavCtlexperiencialaboralhasta_Jsonclick ;
   private String edtavCtlpremiosid_Internalname ;
   private String edtavCtlpremiosnombre_Internalname ;
   private String edtavCtlpremiosfecha_Internalname ;
   private String edtavCtlpremiosdescripcion_Internalname ;
   private String subGridpremios_Class ;
   private String subGridpremios_Linesclass ;
   private String divGrid1table1_Internalname ;
   private String edtavCtlpremiosid_Jsonclick ;
   private String edtavCtlpremiosnombre_Jsonclick ;
   private String edtavCtlpremiosfecha_Jsonclick ;
   private String edtavCtlpremiosdescripcion_Jsonclick ;
   private String edtavCtlserviciosid_Internalname ;
   private String edtavCtlserviciosnombre_Internalname ;
   private String subGridservicios_Class ;
   private String subGridservicios_Linesclass ;
   private String divGrid2table1_Internalname ;
   private String edtavCtlserviciosid_Jsonclick ;
   private String edtavCtlserviciosnombre_Jsonclick ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date Gx_date ;
   private java.util.Date AV52ProfesionalFechaNacimiento ;
   private java.util.Date AV78TempFechaNac ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV66ProfesionalTerminosCondiciones ;
   private boolean Fileuploadimagen_Autoupload ;
   private boolean Fileuploadimagen_Enableuploadedfilecanceling ;
   private boolean Fileuploadimagen_Autodisableaddingfiles ;
   private boolean Tabpageregistroprofesional_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_167_Refreshing=false ;
   private boolean bGXsfl_299_Refreshing=false ;
   private boolean bGXsfl_266_Refreshing=false ;
   private boolean bGXsfl_235_Refreshing=false ;
   private boolean bGXsfl_195_Refreshing=false ;
   private boolean n40000ProfesionalId ;
   private boolean n40001SecUserId ;
   private boolean returnInSub ;
   private boolean gx_BV167 ;
   private boolean gx_BV195 ;
   private boolean gx_BV235 ;
   private boolean gx_BV299 ;
   private boolean gx_BV266 ;
   private String AV22HtmlTerminosCondiciones ;
   private String AV28MsgSuccss ;
   private String AV70result ;
   private String AV45ProfesionalDepartamento ;
   private String AV63ProfesionalProvincia ;
   private String AV36Pattern ;
   private String A13SecRoleName ;
   private String AV61ProfesionalNroDocumento ;
   private String AV60ProfesionalNombres ;
   private String AV41ProfesionalApellidoPaterno ;
   private String AV40ProfesionalApellidoMaterno ;
   private String AV59ProfesionalMes ;
   private String AV43ProfesionalCOP ;
   private String AV46ProfesionalDescripcion ;
   private String AV51ProfesionalFacebook ;
   private String AV58ProfesionalLinkedin ;
   private String AV69ProfesionalTwitter ;
   private String AV57ProfesionalInstagram ;
   private String AV48ProfesionalDireccion ;
   private String AV49ProfesionalDistrito ;
   private String AV44ProfesionalCorreo ;
   private String AV62ProfesionalPassword ;
   private String A186UbigeoDepartamento ;
   private String A295UbigeoDepartamentoCode ;
   private String AV79textoMensaj ;
   private String AV26Mensajei ;
   private String AV27MesTemporal ;
   private String ZV63ProfesionalProvincia ;
   private String ZV49ProfesionalDistrito ;
   private com.genexus.webpanels.GXWebGrid GridespecialidadsedeContainer ;
   private com.genexus.webpanels.GXWebGrid GrideducacionContainer ;
   private com.genexus.webpanels.GXWebGrid GridexperiencialaboralContainer ;
   private com.genexus.webpanels.GXWebGrid GridpremiosContainer ;
   private com.genexus.webpanels.GXWebGrid GridserviciosContainer ;
   private com.genexus.webpanels.GXWebRow GridespecialidadsedeRow ;
   private com.genexus.webpanels.GXWebRow GridserviciosRow ;
   private com.genexus.webpanels.GXWebRow GridpremiosRow ;
   private com.genexus.webpanels.GXWebRow GridexperiencialaboralRow ;
   private com.genexus.webpanels.GXWebRow GrideducacionRow ;
   private com.genexus.webpanels.GXWebColumn GridespecialidadsedeColumn ;
   private com.genexus.webpanels.GXWebColumn GrideducacionColumn ;
   private com.genexus.webpanels.GXWebColumn GridexperiencialaboralColumn ;
   private com.genexus.webpanels.GXWebColumn GridpremiosColumn ;
   private com.genexus.webpanels.GXWebColumn GridserviciosColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucFileuploadimagen ;
   private com.genexus.webpanels.GXUserControl ucTabpageregistroprofesional ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private HTMLChoice cmbavProfesionaltipodocumento ;
   private HTMLChoice cmbavProfesionalsexo ;
   private HTMLChoice cmbavProfesionaldia ;
   private HTMLChoice cmbavProfesionalmes ;
   private HTMLChoice cmbavProfesionalanio ;
   private HTMLChoice dynavPaisid ;
   private HTMLChoice cmbavProfesionaltiempocita ;
   private HTMLChoice cmbavProfesionaldepartamento ;
   private HTMLChoice dynavProfesionalprovincia ;
   private HTMLChoice dynavProfesionaldistrito ;
   private HTMLChoice dynavCtlespecialidadid ;
   private HTMLChoice cmbavCtlsedetipoconsulta ;
   private ICheckbox chkavProfesionalterminoscondiciones ;
   private IDataStoreProvider pr_default ;
   private short[] H006U2_A43PaisId ;
   private String[] H006U2_A184PaisDescripcion ;
   private String[] H006U3_A44UbigeoCode ;
   private String[] H006U3_A187UbigeoProvincia ;
   private String[] H006U3_A296UbigeoProvinciaCode ;
   private String[] H006U3_A295UbigeoDepartamentoCode ;
   private String[] H006U4_A44UbigeoCode ;
   private String[] H006U4_A188UbigeoDistrito ;
   private String[] H006U4_A297UbigeoDistritoCode ;
   private String[] H006U4_A295UbigeoDepartamentoCode ;
   private String[] H006U4_A296UbigeoProvinciaCode ;
   private short[] H006U5_A32EspecialidadId ;
   private String[] H006U5_A71EspecialidadNombre ;
   private int[] H006U7_A40000ProfesionalId ;
   private boolean[] H006U7_n40000ProfesionalId ;
   private short[] H006U9_A40001SecUserId ;
   private boolean[] H006U9_n40001SecUserId ;
   private String[] H006U10_A186UbigeoDepartamento ;
   private String[] H006U10_A295UbigeoDepartamentoCode ;
   private String[] H006U10_A44UbigeoCode ;
   private int[] H006U12_A40000ProfesionalId ;
   private boolean[] H006U12_n40000ProfesionalId ;
   private short[] H006U14_A40001SecUserId ;
   private boolean[] H006U14_n40001SecUserId ;
   private String[] H006U15_A13SecRoleName ;
   private short[] H006U15_A4SecRoleId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV8WebSession ;
   private GXSimpleCollection<String> AV25Mensaje ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion> AV12EducacionList ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede> AV15EspecialidadList ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral> AV18ExperienciaLaboralList ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV82UploadedFiles ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV19FailedFiles ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios> AV38PremiosList ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios> AV76ServiciosList ;
   private com.projectthani.SdtProfesional AV5Profesional ;
   private com.projectthani.SdtProfesional_Educacion AV11Educacion ;
   private com.projectthani.SdtProfesional_ExperienciaLaboral AV17ExperienciaLaboral ;
   private com.projectthani.SdtProfesional_Premios AV37Premios ;
   private com.projectthani.SdtProfesional_Servicios AV75Servicios ;
   private com.projectthani.wwpbaseobjects.SdtSecUser AV6SecUser ;
   private com.projectthani.wwpbaseobjects.SdtSecUserRole AV7SecUserRole ;
   private com.projectthani.SdtSDTProfesionalEducacion AV29NewEducacion ;
   private com.projectthani.SdtSDTProfesionalEspecialidadSede AV30NewEspecialidad ;
   private com.projectthani.SdtSDTProfesionalExperienciaLaboral AV31NewExperienciaLaboral ;
   private com.projectthani.SdtSDTProfesionalPremios AV32NewPremios ;
   private com.projectthani.SdtSDTProfesionalServicios AV33NewServicios ;
   private com.projectthani.SdtSDTResponseDni AV72SDTResponseDni ;
   private com.projectthani.SdtSDTResponseWSDni AV73SDTResponseWSDni ;
}

final  class wpmiperfilprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006U2", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006U3", "SELECT [UbigeoCode], [UbigeoProvincia], SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode FROM [Ubigeo] WHERE SUBSTRING([UbigeoCode], 1, 2) = ? ORDER BY [UbigeoProvincia] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006U4", "SELECT [UbigeoCode], [UbigeoDistrito], SUBSTRING([UbigeoCode], 5, 2) AS UbigeoDistritoCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode FROM [Ubigeo] WHERE (SUBSTRING([UbigeoCode], 1, 2) = ?) AND (SUBSTRING([UbigeoCode], 3, 2) = ?) ORDER BY [UbigeoDistrito] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006U5", "SELECT [EspecialidadId], [EspecialidadNombre] FROM [Especialidad] ORDER BY [EspecialidadNombre] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006U7", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT MIN([ProfesionalId]) AS ProfesionalId FROM [Profesional] WHERE [ProfesionalNroDocumento] = RTRIM(LTRIM(?)) or [ProfesionalCorreo] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006U9", "SELECT COALESCE( T1.[SecUserId], 0) AS SecUserId FROM (SELECT MIN([SecUserId]) AS SecUserId FROM [SecUser] WHERE [SecUserName] = RTRIM(LTRIM(?)) or [SecUserEmail] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006U10", "SELECT DISTINCT [UbigeoDepartamento], [UbigeoDepartamentoCode], NULL AS [UbigeoCode] FROM ( SELECT TOP(100) PERCENT [UbigeoDepartamento], SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, [UbigeoCode] FROM [Ubigeo] ORDER BY [UbigeoDepartamento]) DistinctT ORDER BY [UbigeoDepartamento] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006U12", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT MIN([ProfesionalId]) AS ProfesionalId FROM [Profesional] WHERE [ProfesionalNroDocumento] = RTRIM(LTRIM(?)) or [ProfesionalCorreo] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006U14", "SELECT COALESCE( T1.[SecUserId], 0) AS SecUserId FROM (SELECT MIN([SecUserId]) AS SecUserId FROM [SecUser] WHERE [SecUserName] = RTRIM(LTRIM(?)) or [SecUserEmail] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006U15", "SELECT [SecRoleName], [SecRoleId] FROM [SecRole] WHERE [SecRoleName] = 'Doctor' ORDER BY [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 2);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 2);
               stmt.setVarchar(2, (String)parms[1], 2);
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 5 :
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
      }
   }

}

