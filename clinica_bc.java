package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clinica_bc extends GXWebPanel implements IGxSilentTrn
{
   public clinica_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clinica_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clinica_bc.class ));
   }

   public clinica_bc( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0E21( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0E21( ) ;
      standaloneModal( ) ;
      addRow0E21( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e110E2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z28ClinicaId = A28ClinicaId ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_0E0( )
   {
      beforeValidate0E21( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0E21( ) ;
         }
         else
         {
            checkExtendedTable0E21( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors0E21( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      AV8IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Insert", GXv_boolean3) ;
         clinica_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Update", GXv_boolean3) ;
         clinica_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Delete", GXv_boolean3) ;
         clinica_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
   }

   public void e110E2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0E21( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z118ClinicaRUC = A118ClinicaRUC ;
         Z116ClinicaNombreComercial = A116ClinicaNombreComercial ;
         Z80ClinicaNombreAbreviado = A80ClinicaNombreAbreviado ;
         Z119ClinicaDireccionComercial = A119ClinicaDireccionComercial ;
         Z340ClinicaCorreo = A340ClinicaCorreo ;
         Z341ClinicaMoneda = A341ClinicaMoneda ;
         Z346ClinicaTelefono = A346ClinicaTelefono ;
         Z347ClinicaWhatsApp = A347ClinicaWhatsApp ;
         Z348ClinicaFacebook = A348ClinicaFacebook ;
         Z349ClinicaTwiter = A349ClinicaTwiter ;
         Z350ClinicaInstagram = A350ClinicaInstagram ;
         Z351ClinicaLinkedin = A351ClinicaLinkedin ;
         Z120ClinicaTiempoDeCita = A120ClinicaTiempoDeCita ;
         Z121ClinicaEstado = A121ClinicaEstado ;
      }
      if ( GX_JID == -9 )
      {
         Z28ClinicaId = A28ClinicaId ;
         Z118ClinicaRUC = A118ClinicaRUC ;
         Z116ClinicaNombreComercial = A116ClinicaNombreComercial ;
         Z80ClinicaNombreAbreviado = A80ClinicaNombreAbreviado ;
         Z119ClinicaDireccionComercial = A119ClinicaDireccionComercial ;
         Z340ClinicaCorreo = A340ClinicaCorreo ;
         Z341ClinicaMoneda = A341ClinicaMoneda ;
         Z117ClinicaLogo = A117ClinicaLogo ;
         Z40000ClinicaLogo_GXI = A40000ClinicaLogo_GXI ;
         Z342ClinicaLogoHeader = A342ClinicaLogoHeader ;
         Z40001ClinicaLogoHeader_GXI = A40001ClinicaLogoHeader_GXI ;
         Z343ClinicaLogoFactura = A343ClinicaLogoFactura ;
         Z40002ClinicaLogoFactura_GXI = A40002ClinicaLogoFactura_GXI ;
         Z344ClinicaLogoBoleta = A344ClinicaLogoBoleta ;
         Z40003ClinicaLogoBoleta_GXI = A40003ClinicaLogoBoleta_GXI ;
         Z345ClinicaLogoPago = A345ClinicaLogoPago ;
         Z40004ClinicaLogoPago_GXI = A40004ClinicaLogoPago_GXI ;
         Z346ClinicaTelefono = A346ClinicaTelefono ;
         Z347ClinicaWhatsApp = A347ClinicaWhatsApp ;
         Z348ClinicaFacebook = A348ClinicaFacebook ;
         Z349ClinicaTwiter = A349ClinicaTwiter ;
         Z350ClinicaInstagram = A350ClinicaInstagram ;
         Z351ClinicaLinkedin = A351ClinicaLinkedin ;
         Z120ClinicaTiempoDeCita = A120ClinicaTiempoDeCita ;
         Z121ClinicaEstado = A121ClinicaEstado ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0E21( )
   {
      /* Using cursor BC000E4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound21 = (short)(1) ;
         A118ClinicaRUC = BC000E4_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = BC000E4_A116ClinicaNombreComercial[0] ;
         A80ClinicaNombreAbreviado = BC000E4_A80ClinicaNombreAbreviado[0] ;
         A119ClinicaDireccionComercial = BC000E4_A119ClinicaDireccionComercial[0] ;
         A340ClinicaCorreo = BC000E4_A340ClinicaCorreo[0] ;
         A341ClinicaMoneda = BC000E4_A341ClinicaMoneda[0] ;
         A117ClinicaLogo = BC000E4_A117ClinicaLogo[0] ;
         A40000ClinicaLogo_GXI = BC000E4_A40000ClinicaLogo_GXI[0] ;
         A342ClinicaLogoHeader = BC000E4_A342ClinicaLogoHeader[0] ;
         n342ClinicaLogoHeader = BC000E4_n342ClinicaLogoHeader[0] ;
         A40001ClinicaLogoHeader_GXI = BC000E4_A40001ClinicaLogoHeader_GXI[0] ;
         n40001ClinicaLogoHeader_GXI = BC000E4_n40001ClinicaLogoHeader_GXI[0] ;
         A343ClinicaLogoFactura = BC000E4_A343ClinicaLogoFactura[0] ;
         n343ClinicaLogoFactura = BC000E4_n343ClinicaLogoFactura[0] ;
         A40002ClinicaLogoFactura_GXI = BC000E4_A40002ClinicaLogoFactura_GXI[0] ;
         n40002ClinicaLogoFactura_GXI = BC000E4_n40002ClinicaLogoFactura_GXI[0] ;
         A344ClinicaLogoBoleta = BC000E4_A344ClinicaLogoBoleta[0] ;
         n344ClinicaLogoBoleta = BC000E4_n344ClinicaLogoBoleta[0] ;
         A40003ClinicaLogoBoleta_GXI = BC000E4_A40003ClinicaLogoBoleta_GXI[0] ;
         n40003ClinicaLogoBoleta_GXI = BC000E4_n40003ClinicaLogoBoleta_GXI[0] ;
         A345ClinicaLogoPago = BC000E4_A345ClinicaLogoPago[0] ;
         n345ClinicaLogoPago = BC000E4_n345ClinicaLogoPago[0] ;
         A40004ClinicaLogoPago_GXI = BC000E4_A40004ClinicaLogoPago_GXI[0] ;
         n40004ClinicaLogoPago_GXI = BC000E4_n40004ClinicaLogoPago_GXI[0] ;
         A346ClinicaTelefono = BC000E4_A346ClinicaTelefono[0] ;
         A347ClinicaWhatsApp = BC000E4_A347ClinicaWhatsApp[0] ;
         A348ClinicaFacebook = BC000E4_A348ClinicaFacebook[0] ;
         A349ClinicaTwiter = BC000E4_A349ClinicaTwiter[0] ;
         A350ClinicaInstagram = BC000E4_A350ClinicaInstagram[0] ;
         A351ClinicaLinkedin = BC000E4_A351ClinicaLinkedin[0] ;
         A120ClinicaTiempoDeCita = BC000E4_A120ClinicaTiempoDeCita[0] ;
         A121ClinicaEstado = BC000E4_A121ClinicaEstado[0] ;
         zm0E21( -9) ;
      }
      pr_default.close(2);
      onLoadActions0E21( ) ;
   }

   public void onLoadActions0E21( )
   {
      AV16Pgmname = "Clinica_BC" ;
   }

   public void checkExtendedTable0E21( )
   {
      nIsDirty_21 = (short)(0) ;
      standaloneModal( ) ;
      AV16Pgmname = "Clinica_BC" ;
      if ( ! ( GxRegex.IsMatch(A340ClinicaCorreo,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Clinica Correo no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A341ClinicaMoneda == 1 ) || ( A341ClinicaMoneda == 2 ) || ( A341ClinicaMoneda == 3 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Clinica Moneda fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A348ClinicaFacebook,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Clinica Facebook no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A349ClinicaTwiter,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Clinica Twiter no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A350ClinicaInstagram,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Clinica Instagram no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A351ClinicaLinkedin,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Clinica Linkedin no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A120ClinicaTiempoDeCita == 30 ) || ( A120ClinicaTiempoDeCita == 60 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Tiempo De Cita fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A121ClinicaEstado, "A") == 0 ) || ( GXutil.strcmp(A121ClinicaEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Clinica Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0E21( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0E21( )
   {
      /* Using cursor BC000E5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound21 = (short)(1) ;
      }
      else
      {
         RcdFound21 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000E6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0E21( 9) ;
         RcdFound21 = (short)(1) ;
         A28ClinicaId = BC000E6_A28ClinicaId[0] ;
         A118ClinicaRUC = BC000E6_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = BC000E6_A116ClinicaNombreComercial[0] ;
         A80ClinicaNombreAbreviado = BC000E6_A80ClinicaNombreAbreviado[0] ;
         A119ClinicaDireccionComercial = BC000E6_A119ClinicaDireccionComercial[0] ;
         A340ClinicaCorreo = BC000E6_A340ClinicaCorreo[0] ;
         A341ClinicaMoneda = BC000E6_A341ClinicaMoneda[0] ;
         A117ClinicaLogo = BC000E6_A117ClinicaLogo[0] ;
         A40000ClinicaLogo_GXI = BC000E6_A40000ClinicaLogo_GXI[0] ;
         A342ClinicaLogoHeader = BC000E6_A342ClinicaLogoHeader[0] ;
         n342ClinicaLogoHeader = BC000E6_n342ClinicaLogoHeader[0] ;
         A40001ClinicaLogoHeader_GXI = BC000E6_A40001ClinicaLogoHeader_GXI[0] ;
         n40001ClinicaLogoHeader_GXI = BC000E6_n40001ClinicaLogoHeader_GXI[0] ;
         A343ClinicaLogoFactura = BC000E6_A343ClinicaLogoFactura[0] ;
         n343ClinicaLogoFactura = BC000E6_n343ClinicaLogoFactura[0] ;
         A40002ClinicaLogoFactura_GXI = BC000E6_A40002ClinicaLogoFactura_GXI[0] ;
         n40002ClinicaLogoFactura_GXI = BC000E6_n40002ClinicaLogoFactura_GXI[0] ;
         A344ClinicaLogoBoleta = BC000E6_A344ClinicaLogoBoleta[0] ;
         n344ClinicaLogoBoleta = BC000E6_n344ClinicaLogoBoleta[0] ;
         A40003ClinicaLogoBoleta_GXI = BC000E6_A40003ClinicaLogoBoleta_GXI[0] ;
         n40003ClinicaLogoBoleta_GXI = BC000E6_n40003ClinicaLogoBoleta_GXI[0] ;
         A345ClinicaLogoPago = BC000E6_A345ClinicaLogoPago[0] ;
         n345ClinicaLogoPago = BC000E6_n345ClinicaLogoPago[0] ;
         A40004ClinicaLogoPago_GXI = BC000E6_A40004ClinicaLogoPago_GXI[0] ;
         n40004ClinicaLogoPago_GXI = BC000E6_n40004ClinicaLogoPago_GXI[0] ;
         A346ClinicaTelefono = BC000E6_A346ClinicaTelefono[0] ;
         A347ClinicaWhatsApp = BC000E6_A347ClinicaWhatsApp[0] ;
         A348ClinicaFacebook = BC000E6_A348ClinicaFacebook[0] ;
         A349ClinicaTwiter = BC000E6_A349ClinicaTwiter[0] ;
         A350ClinicaInstagram = BC000E6_A350ClinicaInstagram[0] ;
         A351ClinicaLinkedin = BC000E6_A351ClinicaLinkedin[0] ;
         A120ClinicaTiempoDeCita = BC000E6_A120ClinicaTiempoDeCita[0] ;
         A121ClinicaEstado = BC000E6_A121ClinicaEstado[0] ;
         Z28ClinicaId = A28ClinicaId ;
         sMode21 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0E21( ) ;
         if ( AnyError == 1 )
         {
            RcdFound21 = (short)(0) ;
            initializeNonKey0E21( ) ;
         }
         Gx_mode = sMode21 ;
      }
      else
      {
         RcdFound21 = (short)(0) ;
         initializeNonKey0E21( ) ;
         sMode21 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode21 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0E21( ) ;
      if ( RcdFound21 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_0E0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0E21( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000E7 */
         pr_default.execute(5, new Object[] {Short.valueOf(A28ClinicaId)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Clinica"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(5) == 101) || ( Z118ClinicaRUC != BC000E7_A118ClinicaRUC[0] ) || ( GXutil.strcmp(Z116ClinicaNombreComercial, BC000E7_A116ClinicaNombreComercial[0]) != 0 ) || ( GXutil.strcmp(Z80ClinicaNombreAbreviado, BC000E7_A80ClinicaNombreAbreviado[0]) != 0 ) || ( GXutil.strcmp(Z119ClinicaDireccionComercial, BC000E7_A119ClinicaDireccionComercial[0]) != 0 ) || ( GXutil.strcmp(Z340ClinicaCorreo, BC000E7_A340ClinicaCorreo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z341ClinicaMoneda != BC000E7_A341ClinicaMoneda[0] ) || ( GXutil.strcmp(Z346ClinicaTelefono, BC000E7_A346ClinicaTelefono[0]) != 0 ) || ( GXutil.strcmp(Z347ClinicaWhatsApp, BC000E7_A347ClinicaWhatsApp[0]) != 0 ) || ( GXutil.strcmp(Z348ClinicaFacebook, BC000E7_A348ClinicaFacebook[0]) != 0 ) || ( GXutil.strcmp(Z349ClinicaTwiter, BC000E7_A349ClinicaTwiter[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z350ClinicaInstagram, BC000E7_A350ClinicaInstagram[0]) != 0 ) || ( GXutil.strcmp(Z351ClinicaLinkedin, BC000E7_A351ClinicaLinkedin[0]) != 0 ) || ( Z120ClinicaTiempoDeCita != BC000E7_A120ClinicaTiempoDeCita[0] ) || ( GXutil.strcmp(Z121ClinicaEstado, BC000E7_A121ClinicaEstado[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Clinica"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0E21( )
   {
      beforeValidate0E21( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E21( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0E21( 0) ;
         checkOptimisticConcurrency0E21( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E21( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0E21( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000E8 */
                  pr_default.execute(6, new Object[] {Long.valueOf(A118ClinicaRUC), A116ClinicaNombreComercial, A80ClinicaNombreAbreviado, A119ClinicaDireccionComercial, A340ClinicaCorreo, Short.valueOf(A341ClinicaMoneda), A117ClinicaLogo, A40000ClinicaLogo_GXI, Boolean.valueOf(n342ClinicaLogoHeader), A342ClinicaLogoHeader, Boolean.valueOf(n40001ClinicaLogoHeader_GXI), A40001ClinicaLogoHeader_GXI, Boolean.valueOf(n343ClinicaLogoFactura), A343ClinicaLogoFactura, Boolean.valueOf(n40002ClinicaLogoFactura_GXI), A40002ClinicaLogoFactura_GXI, Boolean.valueOf(n344ClinicaLogoBoleta), A344ClinicaLogoBoleta, Boolean.valueOf(n40003ClinicaLogoBoleta_GXI), A40003ClinicaLogoBoleta_GXI, Boolean.valueOf(n345ClinicaLogoPago), A345ClinicaLogoPago, Boolean.valueOf(n40004ClinicaLogoPago_GXI), A40004ClinicaLogoPago_GXI, A346ClinicaTelefono, A347ClinicaWhatsApp, A348ClinicaFacebook, A349ClinicaTwiter, A350ClinicaInstagram, A351ClinicaLinkedin, Byte.valueOf(A120ClinicaTiempoDeCita), A121ClinicaEstado});
                  A28ClinicaId = BC000E8_A28ClinicaId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0E21( ) ;
         }
         endLevel0E21( ) ;
      }
      closeExtendedTableCursors0E21( ) ;
   }

   public void update0E21( )
   {
      beforeValidate0E21( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E21( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E21( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E21( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0E21( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000E9 */
                  pr_default.execute(7, new Object[] {Long.valueOf(A118ClinicaRUC), A116ClinicaNombreComercial, A80ClinicaNombreAbreviado, A119ClinicaDireccionComercial, A340ClinicaCorreo, Short.valueOf(A341ClinicaMoneda), A346ClinicaTelefono, A347ClinicaWhatsApp, A348ClinicaFacebook, A349ClinicaTwiter, A350ClinicaInstagram, A351ClinicaLinkedin, Byte.valueOf(A120ClinicaTiempoDeCita), A121ClinicaEstado, Short.valueOf(A28ClinicaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Clinica"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0E21( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0E21( ) ;
      }
      closeExtendedTableCursors0E21( ) ;
   }

   public void deferredUpdate0E21( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000E10 */
         pr_default.execute(8, new Object[] {A117ClinicaLogo, A40000ClinicaLogo_GXI, Short.valueOf(A28ClinicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000E11 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n342ClinicaLogoHeader), A342ClinicaLogoHeader, Boolean.valueOf(n40001ClinicaLogoHeader_GXI), A40001ClinicaLogoHeader_GXI, Short.valueOf(A28ClinicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000E12 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n343ClinicaLogoFactura), A343ClinicaLogoFactura, Boolean.valueOf(n40002ClinicaLogoFactura_GXI), A40002ClinicaLogoFactura_GXI, Short.valueOf(A28ClinicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000E13 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n344ClinicaLogoBoleta), A344ClinicaLogoBoleta, Boolean.valueOf(n40003ClinicaLogoBoleta_GXI), A40003ClinicaLogoBoleta_GXI, Short.valueOf(A28ClinicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000E14 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n345ClinicaLogoPago), A345ClinicaLogoPago, Boolean.valueOf(n40004ClinicaLogoPago_GXI), A40004ClinicaLogoPago_GXI, Short.valueOf(A28ClinicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0E21( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E21( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0E21( ) ;
         afterConfirm0E21( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0E21( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000E15 */
               pr_default.execute(13, new Object[] {Short.valueOf(A28ClinicaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode21 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0E21( ) ;
      Gx_mode = sMode21 ;
   }

   public void onDeleteControls0E21( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV16Pgmname = "Clinica_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000E16 */
         pr_default.execute(14, new Object[] {Short.valueOf(A28ClinicaId)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sede"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
   }

   public void endLevel0E21( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0E21( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0E21( )
   {
      /* Scan By routine */
      /* Using cursor BC000E17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A28ClinicaId)});
      RcdFound21 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound21 = (short)(1) ;
         A28ClinicaId = BC000E17_A28ClinicaId[0] ;
         A118ClinicaRUC = BC000E17_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = BC000E17_A116ClinicaNombreComercial[0] ;
         A80ClinicaNombreAbreviado = BC000E17_A80ClinicaNombreAbreviado[0] ;
         A119ClinicaDireccionComercial = BC000E17_A119ClinicaDireccionComercial[0] ;
         A340ClinicaCorreo = BC000E17_A340ClinicaCorreo[0] ;
         A341ClinicaMoneda = BC000E17_A341ClinicaMoneda[0] ;
         A117ClinicaLogo = BC000E17_A117ClinicaLogo[0] ;
         A40000ClinicaLogo_GXI = BC000E17_A40000ClinicaLogo_GXI[0] ;
         A342ClinicaLogoHeader = BC000E17_A342ClinicaLogoHeader[0] ;
         n342ClinicaLogoHeader = BC000E17_n342ClinicaLogoHeader[0] ;
         A40001ClinicaLogoHeader_GXI = BC000E17_A40001ClinicaLogoHeader_GXI[0] ;
         n40001ClinicaLogoHeader_GXI = BC000E17_n40001ClinicaLogoHeader_GXI[0] ;
         A343ClinicaLogoFactura = BC000E17_A343ClinicaLogoFactura[0] ;
         n343ClinicaLogoFactura = BC000E17_n343ClinicaLogoFactura[0] ;
         A40002ClinicaLogoFactura_GXI = BC000E17_A40002ClinicaLogoFactura_GXI[0] ;
         n40002ClinicaLogoFactura_GXI = BC000E17_n40002ClinicaLogoFactura_GXI[0] ;
         A344ClinicaLogoBoleta = BC000E17_A344ClinicaLogoBoleta[0] ;
         n344ClinicaLogoBoleta = BC000E17_n344ClinicaLogoBoleta[0] ;
         A40003ClinicaLogoBoleta_GXI = BC000E17_A40003ClinicaLogoBoleta_GXI[0] ;
         n40003ClinicaLogoBoleta_GXI = BC000E17_n40003ClinicaLogoBoleta_GXI[0] ;
         A345ClinicaLogoPago = BC000E17_A345ClinicaLogoPago[0] ;
         n345ClinicaLogoPago = BC000E17_n345ClinicaLogoPago[0] ;
         A40004ClinicaLogoPago_GXI = BC000E17_A40004ClinicaLogoPago_GXI[0] ;
         n40004ClinicaLogoPago_GXI = BC000E17_n40004ClinicaLogoPago_GXI[0] ;
         A346ClinicaTelefono = BC000E17_A346ClinicaTelefono[0] ;
         A347ClinicaWhatsApp = BC000E17_A347ClinicaWhatsApp[0] ;
         A348ClinicaFacebook = BC000E17_A348ClinicaFacebook[0] ;
         A349ClinicaTwiter = BC000E17_A349ClinicaTwiter[0] ;
         A350ClinicaInstagram = BC000E17_A350ClinicaInstagram[0] ;
         A351ClinicaLinkedin = BC000E17_A351ClinicaLinkedin[0] ;
         A120ClinicaTiempoDeCita = BC000E17_A120ClinicaTiempoDeCita[0] ;
         A121ClinicaEstado = BC000E17_A121ClinicaEstado[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0E21( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound21 = (short)(0) ;
      scanKeyLoad0E21( ) ;
   }

   public void scanKeyLoad0E21( )
   {
      sMode21 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound21 = (short)(1) ;
         A28ClinicaId = BC000E17_A28ClinicaId[0] ;
         A118ClinicaRUC = BC000E17_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = BC000E17_A116ClinicaNombreComercial[0] ;
         A80ClinicaNombreAbreviado = BC000E17_A80ClinicaNombreAbreviado[0] ;
         A119ClinicaDireccionComercial = BC000E17_A119ClinicaDireccionComercial[0] ;
         A340ClinicaCorreo = BC000E17_A340ClinicaCorreo[0] ;
         A341ClinicaMoneda = BC000E17_A341ClinicaMoneda[0] ;
         A117ClinicaLogo = BC000E17_A117ClinicaLogo[0] ;
         A40000ClinicaLogo_GXI = BC000E17_A40000ClinicaLogo_GXI[0] ;
         A342ClinicaLogoHeader = BC000E17_A342ClinicaLogoHeader[0] ;
         n342ClinicaLogoHeader = BC000E17_n342ClinicaLogoHeader[0] ;
         A40001ClinicaLogoHeader_GXI = BC000E17_A40001ClinicaLogoHeader_GXI[0] ;
         n40001ClinicaLogoHeader_GXI = BC000E17_n40001ClinicaLogoHeader_GXI[0] ;
         A343ClinicaLogoFactura = BC000E17_A343ClinicaLogoFactura[0] ;
         n343ClinicaLogoFactura = BC000E17_n343ClinicaLogoFactura[0] ;
         A40002ClinicaLogoFactura_GXI = BC000E17_A40002ClinicaLogoFactura_GXI[0] ;
         n40002ClinicaLogoFactura_GXI = BC000E17_n40002ClinicaLogoFactura_GXI[0] ;
         A344ClinicaLogoBoleta = BC000E17_A344ClinicaLogoBoleta[0] ;
         n344ClinicaLogoBoleta = BC000E17_n344ClinicaLogoBoleta[0] ;
         A40003ClinicaLogoBoleta_GXI = BC000E17_A40003ClinicaLogoBoleta_GXI[0] ;
         n40003ClinicaLogoBoleta_GXI = BC000E17_n40003ClinicaLogoBoleta_GXI[0] ;
         A345ClinicaLogoPago = BC000E17_A345ClinicaLogoPago[0] ;
         n345ClinicaLogoPago = BC000E17_n345ClinicaLogoPago[0] ;
         A40004ClinicaLogoPago_GXI = BC000E17_A40004ClinicaLogoPago_GXI[0] ;
         n40004ClinicaLogoPago_GXI = BC000E17_n40004ClinicaLogoPago_GXI[0] ;
         A346ClinicaTelefono = BC000E17_A346ClinicaTelefono[0] ;
         A347ClinicaWhatsApp = BC000E17_A347ClinicaWhatsApp[0] ;
         A348ClinicaFacebook = BC000E17_A348ClinicaFacebook[0] ;
         A349ClinicaTwiter = BC000E17_A349ClinicaTwiter[0] ;
         A350ClinicaInstagram = BC000E17_A350ClinicaInstagram[0] ;
         A351ClinicaLinkedin = BC000E17_A351ClinicaLinkedin[0] ;
         A120ClinicaTiempoDeCita = BC000E17_A120ClinicaTiempoDeCita[0] ;
         A121ClinicaEstado = BC000E17_A121ClinicaEstado[0] ;
      }
      Gx_mode = sMode21 ;
   }

   public void scanKeyEnd0E21( )
   {
      pr_default.close(15);
   }

   public void afterConfirm0E21( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0E21( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0E21( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0E21( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0E21( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0E21( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0E21( )
   {
   }

   public void send_integrity_lvl_hashes0E21( )
   {
   }

   public void addRow0E21( )
   {
      VarsToRow21( bcClinica) ;
   }

   public void readRow0E21( )
   {
      RowToVars21( bcClinica, 1) ;
   }

   public void initializeNonKey0E21( )
   {
      A118ClinicaRUC = 0 ;
      A116ClinicaNombreComercial = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A119ClinicaDireccionComercial = "" ;
      A340ClinicaCorreo = "" ;
      A341ClinicaMoneda = (short)(0) ;
      A117ClinicaLogo = "" ;
      A40000ClinicaLogo_GXI = "" ;
      A342ClinicaLogoHeader = "" ;
      n342ClinicaLogoHeader = false ;
      A40001ClinicaLogoHeader_GXI = "" ;
      n40001ClinicaLogoHeader_GXI = false ;
      A343ClinicaLogoFactura = "" ;
      n343ClinicaLogoFactura = false ;
      A40002ClinicaLogoFactura_GXI = "" ;
      n40002ClinicaLogoFactura_GXI = false ;
      A344ClinicaLogoBoleta = "" ;
      n344ClinicaLogoBoleta = false ;
      A40003ClinicaLogoBoleta_GXI = "" ;
      n40003ClinicaLogoBoleta_GXI = false ;
      A345ClinicaLogoPago = "" ;
      n345ClinicaLogoPago = false ;
      A40004ClinicaLogoPago_GXI = "" ;
      n40004ClinicaLogoPago_GXI = false ;
      A346ClinicaTelefono = "" ;
      A347ClinicaWhatsApp = "" ;
      A348ClinicaFacebook = "" ;
      A349ClinicaTwiter = "" ;
      A350ClinicaInstagram = "" ;
      A351ClinicaLinkedin = "" ;
      A120ClinicaTiempoDeCita = (byte)(0) ;
      A121ClinicaEstado = "" ;
      Z118ClinicaRUC = 0 ;
      Z116ClinicaNombreComercial = "" ;
      Z80ClinicaNombreAbreviado = "" ;
      Z119ClinicaDireccionComercial = "" ;
      Z340ClinicaCorreo = "" ;
      Z341ClinicaMoneda = (short)(0) ;
      Z346ClinicaTelefono = "" ;
      Z347ClinicaWhatsApp = "" ;
      Z348ClinicaFacebook = "" ;
      Z349ClinicaTwiter = "" ;
      Z350ClinicaInstagram = "" ;
      Z351ClinicaLinkedin = "" ;
      Z120ClinicaTiempoDeCita = (byte)(0) ;
      Z121ClinicaEstado = "" ;
   }

   public void initAll0E21( )
   {
      A28ClinicaId = (short)(0) ;
      initializeNonKey0E21( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow21( com.projectthani.SdtClinica obj21 )
   {
      obj21.setgxTv_SdtClinica_Mode( Gx_mode );
      obj21.setgxTv_SdtClinica_Clinicaruc( A118ClinicaRUC );
      obj21.setgxTv_SdtClinica_Clinicanombrecomercial( A116ClinicaNombreComercial );
      obj21.setgxTv_SdtClinica_Clinicanombreabreviado( A80ClinicaNombreAbreviado );
      obj21.setgxTv_SdtClinica_Clinicadireccioncomercial( A119ClinicaDireccionComercial );
      obj21.setgxTv_SdtClinica_Clinicacorreo( A340ClinicaCorreo );
      obj21.setgxTv_SdtClinica_Clinicamoneda( A341ClinicaMoneda );
      obj21.setgxTv_SdtClinica_Clinicalogo( A117ClinicaLogo );
      obj21.setgxTv_SdtClinica_Clinicalogo_gxi( A40000ClinicaLogo_GXI );
      obj21.setgxTv_SdtClinica_Clinicalogoheader( A342ClinicaLogoHeader );
      obj21.setgxTv_SdtClinica_Clinicalogoheader_gxi( A40001ClinicaLogoHeader_GXI );
      obj21.setgxTv_SdtClinica_Clinicalogofactura( A343ClinicaLogoFactura );
      obj21.setgxTv_SdtClinica_Clinicalogofactura_gxi( A40002ClinicaLogoFactura_GXI );
      obj21.setgxTv_SdtClinica_Clinicalogoboleta( A344ClinicaLogoBoleta );
      obj21.setgxTv_SdtClinica_Clinicalogoboleta_gxi( A40003ClinicaLogoBoleta_GXI );
      obj21.setgxTv_SdtClinica_Clinicalogopago( A345ClinicaLogoPago );
      obj21.setgxTv_SdtClinica_Clinicalogopago_gxi( A40004ClinicaLogoPago_GXI );
      obj21.setgxTv_SdtClinica_Clinicatelefono( A346ClinicaTelefono );
      obj21.setgxTv_SdtClinica_Clinicawhatsapp( A347ClinicaWhatsApp );
      obj21.setgxTv_SdtClinica_Clinicafacebook( A348ClinicaFacebook );
      obj21.setgxTv_SdtClinica_Clinicatwiter( A349ClinicaTwiter );
      obj21.setgxTv_SdtClinica_Clinicainstagram( A350ClinicaInstagram );
      obj21.setgxTv_SdtClinica_Clinicalinkedin( A351ClinicaLinkedin );
      obj21.setgxTv_SdtClinica_Clinicatiempodecita( A120ClinicaTiempoDeCita );
      obj21.setgxTv_SdtClinica_Clinicaestado( A121ClinicaEstado );
      obj21.setgxTv_SdtClinica_Clinicaid( A28ClinicaId );
      obj21.setgxTv_SdtClinica_Clinicaid_Z( Z28ClinicaId );
      obj21.setgxTv_SdtClinica_Clinicaruc_Z( Z118ClinicaRUC );
      obj21.setgxTv_SdtClinica_Clinicanombrecomercial_Z( Z116ClinicaNombreComercial );
      obj21.setgxTv_SdtClinica_Clinicanombreabreviado_Z( Z80ClinicaNombreAbreviado );
      obj21.setgxTv_SdtClinica_Clinicadireccioncomercial_Z( Z119ClinicaDireccionComercial );
      obj21.setgxTv_SdtClinica_Clinicacorreo_Z( Z340ClinicaCorreo );
      obj21.setgxTv_SdtClinica_Clinicamoneda_Z( Z341ClinicaMoneda );
      obj21.setgxTv_SdtClinica_Clinicatelefono_Z( Z346ClinicaTelefono );
      obj21.setgxTv_SdtClinica_Clinicawhatsapp_Z( Z347ClinicaWhatsApp );
      obj21.setgxTv_SdtClinica_Clinicafacebook_Z( Z348ClinicaFacebook );
      obj21.setgxTv_SdtClinica_Clinicatwiter_Z( Z349ClinicaTwiter );
      obj21.setgxTv_SdtClinica_Clinicainstagram_Z( Z350ClinicaInstagram );
      obj21.setgxTv_SdtClinica_Clinicalinkedin_Z( Z351ClinicaLinkedin );
      obj21.setgxTv_SdtClinica_Clinicatiempodecita_Z( Z120ClinicaTiempoDeCita );
      obj21.setgxTv_SdtClinica_Clinicaestado_Z( Z121ClinicaEstado );
      obj21.setgxTv_SdtClinica_Clinicalogo_gxi_Z( Z40000ClinicaLogo_GXI );
      obj21.setgxTv_SdtClinica_Clinicalogoheader_gxi_Z( Z40001ClinicaLogoHeader_GXI );
      obj21.setgxTv_SdtClinica_Clinicalogofactura_gxi_Z( Z40002ClinicaLogoFactura_GXI );
      obj21.setgxTv_SdtClinica_Clinicalogoboleta_gxi_Z( Z40003ClinicaLogoBoleta_GXI );
      obj21.setgxTv_SdtClinica_Clinicalogopago_gxi_Z( Z40004ClinicaLogoPago_GXI );
      obj21.setgxTv_SdtClinica_Clinicalogoheader_N( (byte)((byte)((n342ClinicaLogoHeader)?1:0)) );
      obj21.setgxTv_SdtClinica_Clinicalogofactura_N( (byte)((byte)((n343ClinicaLogoFactura)?1:0)) );
      obj21.setgxTv_SdtClinica_Clinicalogoboleta_N( (byte)((byte)((n344ClinicaLogoBoleta)?1:0)) );
      obj21.setgxTv_SdtClinica_Clinicalogopago_N( (byte)((byte)((n345ClinicaLogoPago)?1:0)) );
      obj21.setgxTv_SdtClinica_Clinicalogoheader_gxi_N( (byte)((byte)((n40001ClinicaLogoHeader_GXI)?1:0)) );
      obj21.setgxTv_SdtClinica_Clinicalogofactura_gxi_N( (byte)((byte)((n40002ClinicaLogoFactura_GXI)?1:0)) );
      obj21.setgxTv_SdtClinica_Clinicalogoboleta_gxi_N( (byte)((byte)((n40003ClinicaLogoBoleta_GXI)?1:0)) );
      obj21.setgxTv_SdtClinica_Clinicalogopago_gxi_N( (byte)((byte)((n40004ClinicaLogoPago_GXI)?1:0)) );
      obj21.setgxTv_SdtClinica_Mode( Gx_mode );
   }

   public void KeyVarsToRow21( com.projectthani.SdtClinica obj21 )
   {
      obj21.setgxTv_SdtClinica_Clinicaid( A28ClinicaId );
   }

   public void RowToVars21( com.projectthani.SdtClinica obj21 ,
                            int forceLoad )
   {
      Gx_mode = obj21.getgxTv_SdtClinica_Mode() ;
      A118ClinicaRUC = obj21.getgxTv_SdtClinica_Clinicaruc() ;
      A116ClinicaNombreComercial = obj21.getgxTv_SdtClinica_Clinicanombrecomercial() ;
      A80ClinicaNombreAbreviado = obj21.getgxTv_SdtClinica_Clinicanombreabreviado() ;
      A119ClinicaDireccionComercial = obj21.getgxTv_SdtClinica_Clinicadireccioncomercial() ;
      A340ClinicaCorreo = obj21.getgxTv_SdtClinica_Clinicacorreo() ;
      A341ClinicaMoneda = obj21.getgxTv_SdtClinica_Clinicamoneda() ;
      A117ClinicaLogo = obj21.getgxTv_SdtClinica_Clinicalogo() ;
      A40000ClinicaLogo_GXI = obj21.getgxTv_SdtClinica_Clinicalogo_gxi() ;
      A342ClinicaLogoHeader = obj21.getgxTv_SdtClinica_Clinicalogoheader() ;
      n342ClinicaLogoHeader = false ;
      A40001ClinicaLogoHeader_GXI = obj21.getgxTv_SdtClinica_Clinicalogoheader_gxi() ;
      n40001ClinicaLogoHeader_GXI = false ;
      A343ClinicaLogoFactura = obj21.getgxTv_SdtClinica_Clinicalogofactura() ;
      n343ClinicaLogoFactura = false ;
      A40002ClinicaLogoFactura_GXI = obj21.getgxTv_SdtClinica_Clinicalogofactura_gxi() ;
      n40002ClinicaLogoFactura_GXI = false ;
      A344ClinicaLogoBoleta = obj21.getgxTv_SdtClinica_Clinicalogoboleta() ;
      n344ClinicaLogoBoleta = false ;
      A40003ClinicaLogoBoleta_GXI = obj21.getgxTv_SdtClinica_Clinicalogoboleta_gxi() ;
      n40003ClinicaLogoBoleta_GXI = false ;
      A345ClinicaLogoPago = obj21.getgxTv_SdtClinica_Clinicalogopago() ;
      n345ClinicaLogoPago = false ;
      A40004ClinicaLogoPago_GXI = obj21.getgxTv_SdtClinica_Clinicalogopago_gxi() ;
      n40004ClinicaLogoPago_GXI = false ;
      A346ClinicaTelefono = obj21.getgxTv_SdtClinica_Clinicatelefono() ;
      A347ClinicaWhatsApp = obj21.getgxTv_SdtClinica_Clinicawhatsapp() ;
      A348ClinicaFacebook = obj21.getgxTv_SdtClinica_Clinicafacebook() ;
      A349ClinicaTwiter = obj21.getgxTv_SdtClinica_Clinicatwiter() ;
      A350ClinicaInstagram = obj21.getgxTv_SdtClinica_Clinicainstagram() ;
      A351ClinicaLinkedin = obj21.getgxTv_SdtClinica_Clinicalinkedin() ;
      A120ClinicaTiempoDeCita = obj21.getgxTv_SdtClinica_Clinicatiempodecita() ;
      A121ClinicaEstado = obj21.getgxTv_SdtClinica_Clinicaestado() ;
      A28ClinicaId = obj21.getgxTv_SdtClinica_Clinicaid() ;
      Z28ClinicaId = obj21.getgxTv_SdtClinica_Clinicaid_Z() ;
      Z118ClinicaRUC = obj21.getgxTv_SdtClinica_Clinicaruc_Z() ;
      Z116ClinicaNombreComercial = obj21.getgxTv_SdtClinica_Clinicanombrecomercial_Z() ;
      Z80ClinicaNombreAbreviado = obj21.getgxTv_SdtClinica_Clinicanombreabreviado_Z() ;
      Z119ClinicaDireccionComercial = obj21.getgxTv_SdtClinica_Clinicadireccioncomercial_Z() ;
      Z340ClinicaCorreo = obj21.getgxTv_SdtClinica_Clinicacorreo_Z() ;
      Z341ClinicaMoneda = obj21.getgxTv_SdtClinica_Clinicamoneda_Z() ;
      Z346ClinicaTelefono = obj21.getgxTv_SdtClinica_Clinicatelefono_Z() ;
      Z347ClinicaWhatsApp = obj21.getgxTv_SdtClinica_Clinicawhatsapp_Z() ;
      Z348ClinicaFacebook = obj21.getgxTv_SdtClinica_Clinicafacebook_Z() ;
      Z349ClinicaTwiter = obj21.getgxTv_SdtClinica_Clinicatwiter_Z() ;
      Z350ClinicaInstagram = obj21.getgxTv_SdtClinica_Clinicainstagram_Z() ;
      Z351ClinicaLinkedin = obj21.getgxTv_SdtClinica_Clinicalinkedin_Z() ;
      Z120ClinicaTiempoDeCita = obj21.getgxTv_SdtClinica_Clinicatiempodecita_Z() ;
      Z121ClinicaEstado = obj21.getgxTv_SdtClinica_Clinicaestado_Z() ;
      Z40000ClinicaLogo_GXI = obj21.getgxTv_SdtClinica_Clinicalogo_gxi_Z() ;
      Z40001ClinicaLogoHeader_GXI = obj21.getgxTv_SdtClinica_Clinicalogoheader_gxi_Z() ;
      Z40002ClinicaLogoFactura_GXI = obj21.getgxTv_SdtClinica_Clinicalogofactura_gxi_Z() ;
      Z40003ClinicaLogoBoleta_GXI = obj21.getgxTv_SdtClinica_Clinicalogoboleta_gxi_Z() ;
      Z40004ClinicaLogoPago_GXI = obj21.getgxTv_SdtClinica_Clinicalogopago_gxi_Z() ;
      n342ClinicaLogoHeader = (boolean)((obj21.getgxTv_SdtClinica_Clinicalogoheader_N()==0)?false:true) ;
      n343ClinicaLogoFactura = (boolean)((obj21.getgxTv_SdtClinica_Clinicalogofactura_N()==0)?false:true) ;
      n344ClinicaLogoBoleta = (boolean)((obj21.getgxTv_SdtClinica_Clinicalogoboleta_N()==0)?false:true) ;
      n345ClinicaLogoPago = (boolean)((obj21.getgxTv_SdtClinica_Clinicalogopago_N()==0)?false:true) ;
      n40001ClinicaLogoHeader_GXI = (boolean)((obj21.getgxTv_SdtClinica_Clinicalogoheader_gxi_N()==0)?false:true) ;
      n40002ClinicaLogoFactura_GXI = (boolean)((obj21.getgxTv_SdtClinica_Clinicalogofactura_gxi_N()==0)?false:true) ;
      n40003ClinicaLogoBoleta_GXI = (boolean)((obj21.getgxTv_SdtClinica_Clinicalogoboleta_gxi_N()==0)?false:true) ;
      n40004ClinicaLogoPago_GXI = (boolean)((obj21.getgxTv_SdtClinica_Clinicalogopago_gxi_N()==0)?false:true) ;
      Gx_mode = obj21.getgxTv_SdtClinica_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A28ClinicaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0E21( ) ;
      scanKeyStart0E21( ) ;
      if ( RcdFound21 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z28ClinicaId = A28ClinicaId ;
      }
      zm0E21( -9) ;
      onLoadActions0E21( ) ;
      addRow0E21( ) ;
      scanKeyEnd0E21( ) ;
      if ( RcdFound21 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars21( bcClinica, 0) ;
      scanKeyStart0E21( ) ;
      if ( RcdFound21 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z28ClinicaId = A28ClinicaId ;
      }
      zm0E21( -9) ;
      onLoadActions0E21( ) ;
      addRow0E21( ) ;
      scanKeyEnd0E21( ) ;
      if ( RcdFound21 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0E21( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0E21( ) ;
      }
      else
      {
         if ( RcdFound21 == 1 )
         {
            if ( A28ClinicaId != Z28ClinicaId )
            {
               A28ClinicaId = Z28ClinicaId ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0E21( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A28ClinicaId != Z28ClinicaId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0E21( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0E21( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars21( bcClinica, 1) ;
      saveImpl( ) ;
      VarsToRow21( bcClinica) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars21( bcClinica, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0E21( ) ;
      afterTrn( ) ;
      VarsToRow21( bcClinica) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         com.projectthani.SdtClinica auxBC = new com.projectthani.SdtClinica( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A28ClinicaId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcClinica);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars21( bcClinica, 1) ;
      updateImpl( ) ;
      VarsToRow21( bcClinica) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars21( bcClinica, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0E21( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow21( bcClinica) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars21( bcClinica, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0E21( ) ;
      if ( RcdFound21 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A28ClinicaId != Z28ClinicaId )
         {
            A28ClinicaId = Z28ClinicaId ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A28ClinicaId != Z28ClinicaId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      pr_default.close(1);
      pr_default.close(0);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "clinica_bc");
      VarsToRow21( bcClinica) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcClinica.getgxTv_SdtClinica_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcClinica.setgxTv_SdtClinica_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtClinica sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcClinica )
      {
         bcClinica = sdt ;
         if ( GXutil.strcmp(bcClinica.getgxTv_SdtClinica_Mode(), "") == 0 )
         {
            bcClinica.setgxTv_SdtClinica_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow21( bcClinica) ;
         }
         else
         {
            RowToVars21( bcClinica, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcClinica.getgxTv_SdtClinica_Mode(), "") == 0 )
         {
            bcClinica.setgxTv_SdtClinica_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars21( bcClinica, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtClinica getClinica_BC( )
   {
      return bcClinica ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
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
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV16Pgmname = "" ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      Z116ClinicaNombreComercial = "" ;
      A116ClinicaNombreComercial = "" ;
      Z80ClinicaNombreAbreviado = "" ;
      A80ClinicaNombreAbreviado = "" ;
      Z119ClinicaDireccionComercial = "" ;
      A119ClinicaDireccionComercial = "" ;
      Z340ClinicaCorreo = "" ;
      A340ClinicaCorreo = "" ;
      Z346ClinicaTelefono = "" ;
      A346ClinicaTelefono = "" ;
      Z347ClinicaWhatsApp = "" ;
      A347ClinicaWhatsApp = "" ;
      Z348ClinicaFacebook = "" ;
      A348ClinicaFacebook = "" ;
      Z349ClinicaTwiter = "" ;
      A349ClinicaTwiter = "" ;
      Z350ClinicaInstagram = "" ;
      A350ClinicaInstagram = "" ;
      Z351ClinicaLinkedin = "" ;
      A351ClinicaLinkedin = "" ;
      Z121ClinicaEstado = "" ;
      A121ClinicaEstado = "" ;
      Z117ClinicaLogo = "" ;
      A117ClinicaLogo = "" ;
      Z40000ClinicaLogo_GXI = "" ;
      A40000ClinicaLogo_GXI = "" ;
      Z342ClinicaLogoHeader = "" ;
      A342ClinicaLogoHeader = "" ;
      Z40001ClinicaLogoHeader_GXI = "" ;
      A40001ClinicaLogoHeader_GXI = "" ;
      Z343ClinicaLogoFactura = "" ;
      A343ClinicaLogoFactura = "" ;
      Z40002ClinicaLogoFactura_GXI = "" ;
      A40002ClinicaLogoFactura_GXI = "" ;
      Z344ClinicaLogoBoleta = "" ;
      A344ClinicaLogoBoleta = "" ;
      Z40003ClinicaLogoBoleta_GXI = "" ;
      A40003ClinicaLogoBoleta_GXI = "" ;
      Z345ClinicaLogoPago = "" ;
      A345ClinicaLogoPago = "" ;
      Z40004ClinicaLogoPago_GXI = "" ;
      A40004ClinicaLogoPago_GXI = "" ;
      BC000E4_A28ClinicaId = new short[1] ;
      BC000E4_A118ClinicaRUC = new long[1] ;
      BC000E4_A116ClinicaNombreComercial = new String[] {""} ;
      BC000E4_A80ClinicaNombreAbreviado = new String[] {""} ;
      BC000E4_A119ClinicaDireccionComercial = new String[] {""} ;
      BC000E4_A340ClinicaCorreo = new String[] {""} ;
      BC000E4_A341ClinicaMoneda = new short[1] ;
      BC000E4_A117ClinicaLogo = new String[] {""} ;
      BC000E4_A40000ClinicaLogo_GXI = new String[] {""} ;
      BC000E4_A342ClinicaLogoHeader = new String[] {""} ;
      BC000E4_n342ClinicaLogoHeader = new boolean[] {false} ;
      BC000E4_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      BC000E4_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      BC000E4_A343ClinicaLogoFactura = new String[] {""} ;
      BC000E4_n343ClinicaLogoFactura = new boolean[] {false} ;
      BC000E4_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      BC000E4_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      BC000E4_A344ClinicaLogoBoleta = new String[] {""} ;
      BC000E4_n344ClinicaLogoBoleta = new boolean[] {false} ;
      BC000E4_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      BC000E4_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      BC000E4_A345ClinicaLogoPago = new String[] {""} ;
      BC000E4_n345ClinicaLogoPago = new boolean[] {false} ;
      BC000E4_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      BC000E4_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      BC000E4_A346ClinicaTelefono = new String[] {""} ;
      BC000E4_A347ClinicaWhatsApp = new String[] {""} ;
      BC000E4_A348ClinicaFacebook = new String[] {""} ;
      BC000E4_A349ClinicaTwiter = new String[] {""} ;
      BC000E4_A350ClinicaInstagram = new String[] {""} ;
      BC000E4_A351ClinicaLinkedin = new String[] {""} ;
      BC000E4_A120ClinicaTiempoDeCita = new byte[1] ;
      BC000E4_A121ClinicaEstado = new String[] {""} ;
      BC000E5_A28ClinicaId = new short[1] ;
      BC000E6_A28ClinicaId = new short[1] ;
      BC000E6_A118ClinicaRUC = new long[1] ;
      BC000E6_A116ClinicaNombreComercial = new String[] {""} ;
      BC000E6_A80ClinicaNombreAbreviado = new String[] {""} ;
      BC000E6_A119ClinicaDireccionComercial = new String[] {""} ;
      BC000E6_A340ClinicaCorreo = new String[] {""} ;
      BC000E6_A341ClinicaMoneda = new short[1] ;
      BC000E6_A117ClinicaLogo = new String[] {""} ;
      BC000E6_A40000ClinicaLogo_GXI = new String[] {""} ;
      BC000E6_A342ClinicaLogoHeader = new String[] {""} ;
      BC000E6_n342ClinicaLogoHeader = new boolean[] {false} ;
      BC000E6_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      BC000E6_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      BC000E6_A343ClinicaLogoFactura = new String[] {""} ;
      BC000E6_n343ClinicaLogoFactura = new boolean[] {false} ;
      BC000E6_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      BC000E6_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      BC000E6_A344ClinicaLogoBoleta = new String[] {""} ;
      BC000E6_n344ClinicaLogoBoleta = new boolean[] {false} ;
      BC000E6_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      BC000E6_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      BC000E6_A345ClinicaLogoPago = new String[] {""} ;
      BC000E6_n345ClinicaLogoPago = new boolean[] {false} ;
      BC000E6_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      BC000E6_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      BC000E6_A346ClinicaTelefono = new String[] {""} ;
      BC000E6_A347ClinicaWhatsApp = new String[] {""} ;
      BC000E6_A348ClinicaFacebook = new String[] {""} ;
      BC000E6_A349ClinicaTwiter = new String[] {""} ;
      BC000E6_A350ClinicaInstagram = new String[] {""} ;
      BC000E6_A351ClinicaLinkedin = new String[] {""} ;
      BC000E6_A120ClinicaTiempoDeCita = new byte[1] ;
      BC000E6_A121ClinicaEstado = new String[] {""} ;
      sMode21 = "" ;
      BC000E7_A28ClinicaId = new short[1] ;
      BC000E7_A118ClinicaRUC = new long[1] ;
      BC000E7_A116ClinicaNombreComercial = new String[] {""} ;
      BC000E7_A80ClinicaNombreAbreviado = new String[] {""} ;
      BC000E7_A119ClinicaDireccionComercial = new String[] {""} ;
      BC000E7_A340ClinicaCorreo = new String[] {""} ;
      BC000E7_A341ClinicaMoneda = new short[1] ;
      BC000E7_A117ClinicaLogo = new String[] {""} ;
      BC000E7_A40000ClinicaLogo_GXI = new String[] {""} ;
      BC000E7_A342ClinicaLogoHeader = new String[] {""} ;
      BC000E7_n342ClinicaLogoHeader = new boolean[] {false} ;
      BC000E7_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      BC000E7_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      BC000E7_A343ClinicaLogoFactura = new String[] {""} ;
      BC000E7_n343ClinicaLogoFactura = new boolean[] {false} ;
      BC000E7_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      BC000E7_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      BC000E7_A344ClinicaLogoBoleta = new String[] {""} ;
      BC000E7_n344ClinicaLogoBoleta = new boolean[] {false} ;
      BC000E7_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      BC000E7_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      BC000E7_A345ClinicaLogoPago = new String[] {""} ;
      BC000E7_n345ClinicaLogoPago = new boolean[] {false} ;
      BC000E7_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      BC000E7_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      BC000E7_A346ClinicaTelefono = new String[] {""} ;
      BC000E7_A347ClinicaWhatsApp = new String[] {""} ;
      BC000E7_A348ClinicaFacebook = new String[] {""} ;
      BC000E7_A349ClinicaTwiter = new String[] {""} ;
      BC000E7_A350ClinicaInstagram = new String[] {""} ;
      BC000E7_A351ClinicaLinkedin = new String[] {""} ;
      BC000E7_A120ClinicaTiempoDeCita = new byte[1] ;
      BC000E7_A121ClinicaEstado = new String[] {""} ;
      BC000E8_A28ClinicaId = new short[1] ;
      BC000E16_A30SedeId = new short[1] ;
      BC000E17_A28ClinicaId = new short[1] ;
      BC000E17_A118ClinicaRUC = new long[1] ;
      BC000E17_A116ClinicaNombreComercial = new String[] {""} ;
      BC000E17_A80ClinicaNombreAbreviado = new String[] {""} ;
      BC000E17_A119ClinicaDireccionComercial = new String[] {""} ;
      BC000E17_A340ClinicaCorreo = new String[] {""} ;
      BC000E17_A341ClinicaMoneda = new short[1] ;
      BC000E17_A117ClinicaLogo = new String[] {""} ;
      BC000E17_A40000ClinicaLogo_GXI = new String[] {""} ;
      BC000E17_A342ClinicaLogoHeader = new String[] {""} ;
      BC000E17_n342ClinicaLogoHeader = new boolean[] {false} ;
      BC000E17_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      BC000E17_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      BC000E17_A343ClinicaLogoFactura = new String[] {""} ;
      BC000E17_n343ClinicaLogoFactura = new boolean[] {false} ;
      BC000E17_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      BC000E17_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      BC000E17_A344ClinicaLogoBoleta = new String[] {""} ;
      BC000E17_n344ClinicaLogoBoleta = new boolean[] {false} ;
      BC000E17_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      BC000E17_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      BC000E17_A345ClinicaLogoPago = new String[] {""} ;
      BC000E17_n345ClinicaLogoPago = new boolean[] {false} ;
      BC000E17_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      BC000E17_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      BC000E17_A346ClinicaTelefono = new String[] {""} ;
      BC000E17_A347ClinicaWhatsApp = new String[] {""} ;
      BC000E17_A348ClinicaFacebook = new String[] {""} ;
      BC000E17_A349ClinicaTwiter = new String[] {""} ;
      BC000E17_A350ClinicaInstagram = new String[] {""} ;
      BC000E17_A351ClinicaLinkedin = new String[] {""} ;
      BC000E17_A120ClinicaTiempoDeCita = new byte[1] ;
      BC000E17_A121ClinicaEstado = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.clinica_bc__default(),
         new Object[] {
             new Object[] {
            BC000E2_A28ClinicaId, BC000E2_A118ClinicaRUC, BC000E2_A116ClinicaNombreComercial, BC000E2_A80ClinicaNombreAbreviado, BC000E2_A119ClinicaDireccionComercial, BC000E2_A340ClinicaCorreo, BC000E2_A341ClinicaMoneda, BC000E2_A117ClinicaLogo, BC000E2_A40000ClinicaLogo_GXI, BC000E2_A342ClinicaLogoHeader,
            BC000E2_n342ClinicaLogoHeader, BC000E2_A40001ClinicaLogoHeader_GXI, BC000E2_n40001ClinicaLogoHeader_GXI, BC000E2_A343ClinicaLogoFactura, BC000E2_n343ClinicaLogoFactura, BC000E2_A40002ClinicaLogoFactura_GXI, BC000E2_n40002ClinicaLogoFactura_GXI, BC000E2_A344ClinicaLogoBoleta, BC000E2_n344ClinicaLogoBoleta, BC000E2_A40003ClinicaLogoBoleta_GXI,
            BC000E2_n40003ClinicaLogoBoleta_GXI, BC000E2_A345ClinicaLogoPago, BC000E2_n345ClinicaLogoPago, BC000E2_A40004ClinicaLogoPago_GXI, BC000E2_n40004ClinicaLogoPago_GXI, BC000E2_A346ClinicaTelefono, BC000E2_A347ClinicaWhatsApp, BC000E2_A348ClinicaFacebook, BC000E2_A349ClinicaTwiter, BC000E2_A350ClinicaInstagram,
            BC000E2_A351ClinicaLinkedin, BC000E2_A120ClinicaTiempoDeCita, BC000E2_A121ClinicaEstado
            }
            , new Object[] {
            BC000E3_A28ClinicaId, BC000E3_A118ClinicaRUC, BC000E3_A116ClinicaNombreComercial, BC000E3_A80ClinicaNombreAbreviado, BC000E3_A119ClinicaDireccionComercial, BC000E3_A340ClinicaCorreo, BC000E3_A341ClinicaMoneda, BC000E3_A117ClinicaLogo, BC000E3_A40000ClinicaLogo_GXI, BC000E3_A342ClinicaLogoHeader,
            BC000E3_n342ClinicaLogoHeader, BC000E3_A40001ClinicaLogoHeader_GXI, BC000E3_n40001ClinicaLogoHeader_GXI, BC000E3_A343ClinicaLogoFactura, BC000E3_n343ClinicaLogoFactura, BC000E3_A40002ClinicaLogoFactura_GXI, BC000E3_n40002ClinicaLogoFactura_GXI, BC000E3_A344ClinicaLogoBoleta, BC000E3_n344ClinicaLogoBoleta, BC000E3_A40003ClinicaLogoBoleta_GXI,
            BC000E3_n40003ClinicaLogoBoleta_GXI, BC000E3_A345ClinicaLogoPago, BC000E3_n345ClinicaLogoPago, BC000E3_A40004ClinicaLogoPago_GXI, BC000E3_n40004ClinicaLogoPago_GXI, BC000E3_A346ClinicaTelefono, BC000E3_A347ClinicaWhatsApp, BC000E3_A348ClinicaFacebook, BC000E3_A349ClinicaTwiter, BC000E3_A350ClinicaInstagram,
            BC000E3_A351ClinicaLinkedin, BC000E3_A120ClinicaTiempoDeCita, BC000E3_A121ClinicaEstado
            }
            , new Object[] {
            BC000E4_A28ClinicaId, BC000E4_A118ClinicaRUC, BC000E4_A116ClinicaNombreComercial, BC000E4_A80ClinicaNombreAbreviado, BC000E4_A119ClinicaDireccionComercial, BC000E4_A340ClinicaCorreo, BC000E4_A341ClinicaMoneda, BC000E4_A117ClinicaLogo, BC000E4_A40000ClinicaLogo_GXI, BC000E4_A342ClinicaLogoHeader,
            BC000E4_n342ClinicaLogoHeader, BC000E4_A40001ClinicaLogoHeader_GXI, BC000E4_n40001ClinicaLogoHeader_GXI, BC000E4_A343ClinicaLogoFactura, BC000E4_n343ClinicaLogoFactura, BC000E4_A40002ClinicaLogoFactura_GXI, BC000E4_n40002ClinicaLogoFactura_GXI, BC000E4_A344ClinicaLogoBoleta, BC000E4_n344ClinicaLogoBoleta, BC000E4_A40003ClinicaLogoBoleta_GXI,
            BC000E4_n40003ClinicaLogoBoleta_GXI, BC000E4_A345ClinicaLogoPago, BC000E4_n345ClinicaLogoPago, BC000E4_A40004ClinicaLogoPago_GXI, BC000E4_n40004ClinicaLogoPago_GXI, BC000E4_A346ClinicaTelefono, BC000E4_A347ClinicaWhatsApp, BC000E4_A348ClinicaFacebook, BC000E4_A349ClinicaTwiter, BC000E4_A350ClinicaInstagram,
            BC000E4_A351ClinicaLinkedin, BC000E4_A120ClinicaTiempoDeCita, BC000E4_A121ClinicaEstado
            }
            , new Object[] {
            BC000E5_A28ClinicaId
            }
            , new Object[] {
            BC000E6_A28ClinicaId, BC000E6_A118ClinicaRUC, BC000E6_A116ClinicaNombreComercial, BC000E6_A80ClinicaNombreAbreviado, BC000E6_A119ClinicaDireccionComercial, BC000E6_A340ClinicaCorreo, BC000E6_A341ClinicaMoneda, BC000E6_A117ClinicaLogo, BC000E6_A40000ClinicaLogo_GXI, BC000E6_A342ClinicaLogoHeader,
            BC000E6_n342ClinicaLogoHeader, BC000E6_A40001ClinicaLogoHeader_GXI, BC000E6_n40001ClinicaLogoHeader_GXI, BC000E6_A343ClinicaLogoFactura, BC000E6_n343ClinicaLogoFactura, BC000E6_A40002ClinicaLogoFactura_GXI, BC000E6_n40002ClinicaLogoFactura_GXI, BC000E6_A344ClinicaLogoBoleta, BC000E6_n344ClinicaLogoBoleta, BC000E6_A40003ClinicaLogoBoleta_GXI,
            BC000E6_n40003ClinicaLogoBoleta_GXI, BC000E6_A345ClinicaLogoPago, BC000E6_n345ClinicaLogoPago, BC000E6_A40004ClinicaLogoPago_GXI, BC000E6_n40004ClinicaLogoPago_GXI, BC000E6_A346ClinicaTelefono, BC000E6_A347ClinicaWhatsApp, BC000E6_A348ClinicaFacebook, BC000E6_A349ClinicaTwiter, BC000E6_A350ClinicaInstagram,
            BC000E6_A351ClinicaLinkedin, BC000E6_A120ClinicaTiempoDeCita, BC000E6_A121ClinicaEstado
            }
            , new Object[] {
            BC000E7_A28ClinicaId, BC000E7_A118ClinicaRUC, BC000E7_A116ClinicaNombreComercial, BC000E7_A80ClinicaNombreAbreviado, BC000E7_A119ClinicaDireccionComercial, BC000E7_A340ClinicaCorreo, BC000E7_A341ClinicaMoneda, BC000E7_A117ClinicaLogo, BC000E7_A40000ClinicaLogo_GXI, BC000E7_A342ClinicaLogoHeader,
            BC000E7_n342ClinicaLogoHeader, BC000E7_A40001ClinicaLogoHeader_GXI, BC000E7_n40001ClinicaLogoHeader_GXI, BC000E7_A343ClinicaLogoFactura, BC000E7_n343ClinicaLogoFactura, BC000E7_A40002ClinicaLogoFactura_GXI, BC000E7_n40002ClinicaLogoFactura_GXI, BC000E7_A344ClinicaLogoBoleta, BC000E7_n344ClinicaLogoBoleta, BC000E7_A40003ClinicaLogoBoleta_GXI,
            BC000E7_n40003ClinicaLogoBoleta_GXI, BC000E7_A345ClinicaLogoPago, BC000E7_n345ClinicaLogoPago, BC000E7_A40004ClinicaLogoPago_GXI, BC000E7_n40004ClinicaLogoPago_GXI, BC000E7_A346ClinicaTelefono, BC000E7_A347ClinicaWhatsApp, BC000E7_A348ClinicaFacebook, BC000E7_A349ClinicaTwiter, BC000E7_A350ClinicaInstagram,
            BC000E7_A351ClinicaLinkedin, BC000E7_A120ClinicaTiempoDeCita, BC000E7_A121ClinicaEstado
            }
            , new Object[] {
            BC000E8_A28ClinicaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000E16_A30SedeId
            }
            , new Object[] {
            BC000E17_A28ClinicaId, BC000E17_A118ClinicaRUC, BC000E17_A116ClinicaNombreComercial, BC000E17_A80ClinicaNombreAbreviado, BC000E17_A119ClinicaDireccionComercial, BC000E17_A340ClinicaCorreo, BC000E17_A341ClinicaMoneda, BC000E17_A117ClinicaLogo, BC000E17_A40000ClinicaLogo_GXI, BC000E17_A342ClinicaLogoHeader,
            BC000E17_n342ClinicaLogoHeader, BC000E17_A40001ClinicaLogoHeader_GXI, BC000E17_n40001ClinicaLogoHeader_GXI, BC000E17_A343ClinicaLogoFactura, BC000E17_n343ClinicaLogoFactura, BC000E17_A40002ClinicaLogoFactura_GXI, BC000E17_n40002ClinicaLogoFactura_GXI, BC000E17_A344ClinicaLogoBoleta, BC000E17_n344ClinicaLogoBoleta, BC000E17_A40003ClinicaLogoBoleta_GXI,
            BC000E17_n40003ClinicaLogoBoleta_GXI, BC000E17_A345ClinicaLogoPago, BC000E17_n345ClinicaLogoPago, BC000E17_A40004ClinicaLogoPago_GXI, BC000E17_n40004ClinicaLogoPago_GXI, BC000E17_A346ClinicaTelefono, BC000E17_A347ClinicaWhatsApp, BC000E17_A348ClinicaFacebook, BC000E17_A349ClinicaTwiter, BC000E17_A350ClinicaInstagram,
            BC000E17_A351ClinicaLinkedin, BC000E17_A120ClinicaTiempoDeCita, BC000E17_A121ClinicaEstado
            }
         }
      );
      AV16Pgmname = "Clinica_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120E2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z120ClinicaTiempoDeCita ;
   private byte A120ClinicaTiempoDeCita ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z28ClinicaId ;
   private short A28ClinicaId ;
   private short Z341ClinicaMoneda ;
   private short A341ClinicaMoneda ;
   private short RcdFound21 ;
   private short nIsDirty_21 ;
   private int trnEnded ;
   private int GX_JID ;
   private long Z118ClinicaRUC ;
   private long A118ClinicaRUC ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV16Pgmname ;
   private String Z346ClinicaTelefono ;
   private String A346ClinicaTelefono ;
   private String Z347ClinicaWhatsApp ;
   private String A347ClinicaWhatsApp ;
   private String Z121ClinicaEstado ;
   private String A121ClinicaEstado ;
   private String sMode21 ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n342ClinicaLogoHeader ;
   private boolean n40001ClinicaLogoHeader_GXI ;
   private boolean n343ClinicaLogoFactura ;
   private boolean n40002ClinicaLogoFactura_GXI ;
   private boolean n344ClinicaLogoBoleta ;
   private boolean n40003ClinicaLogoBoleta_GXI ;
   private boolean n345ClinicaLogoPago ;
   private boolean n40004ClinicaLogoPago_GXI ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z116ClinicaNombreComercial ;
   private String A116ClinicaNombreComercial ;
   private String Z80ClinicaNombreAbreviado ;
   private String A80ClinicaNombreAbreviado ;
   private String Z119ClinicaDireccionComercial ;
   private String A119ClinicaDireccionComercial ;
   private String Z340ClinicaCorreo ;
   private String A340ClinicaCorreo ;
   private String Z348ClinicaFacebook ;
   private String A348ClinicaFacebook ;
   private String Z349ClinicaTwiter ;
   private String A349ClinicaTwiter ;
   private String Z350ClinicaInstagram ;
   private String A350ClinicaInstagram ;
   private String Z351ClinicaLinkedin ;
   private String A351ClinicaLinkedin ;
   private String Z40000ClinicaLogo_GXI ;
   private String A40000ClinicaLogo_GXI ;
   private String Z40001ClinicaLogoHeader_GXI ;
   private String A40001ClinicaLogoHeader_GXI ;
   private String Z40002ClinicaLogoFactura_GXI ;
   private String A40002ClinicaLogoFactura_GXI ;
   private String Z40003ClinicaLogoBoleta_GXI ;
   private String A40003ClinicaLogoBoleta_GXI ;
   private String Z40004ClinicaLogoPago_GXI ;
   private String A40004ClinicaLogoPago_GXI ;
   private String Z117ClinicaLogo ;
   private String A117ClinicaLogo ;
   private String Z342ClinicaLogoHeader ;
   private String A342ClinicaLogoHeader ;
   private String Z343ClinicaLogoFactura ;
   private String A343ClinicaLogoFactura ;
   private String Z344ClinicaLogoBoleta ;
   private String A344ClinicaLogoBoleta ;
   private String Z345ClinicaLogoPago ;
   private String A345ClinicaLogoPago ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.projectthani.SdtClinica bcClinica ;
   private IDataStoreProvider pr_default ;
   private short[] BC000E4_A28ClinicaId ;
   private long[] BC000E4_A118ClinicaRUC ;
   private String[] BC000E4_A116ClinicaNombreComercial ;
   private String[] BC000E4_A80ClinicaNombreAbreviado ;
   private String[] BC000E4_A119ClinicaDireccionComercial ;
   private String[] BC000E4_A340ClinicaCorreo ;
   private short[] BC000E4_A341ClinicaMoneda ;
   private String[] BC000E4_A117ClinicaLogo ;
   private String[] BC000E4_A40000ClinicaLogo_GXI ;
   private String[] BC000E4_A342ClinicaLogoHeader ;
   private boolean[] BC000E4_n342ClinicaLogoHeader ;
   private String[] BC000E4_A40001ClinicaLogoHeader_GXI ;
   private boolean[] BC000E4_n40001ClinicaLogoHeader_GXI ;
   private String[] BC000E4_A343ClinicaLogoFactura ;
   private boolean[] BC000E4_n343ClinicaLogoFactura ;
   private String[] BC000E4_A40002ClinicaLogoFactura_GXI ;
   private boolean[] BC000E4_n40002ClinicaLogoFactura_GXI ;
   private String[] BC000E4_A344ClinicaLogoBoleta ;
   private boolean[] BC000E4_n344ClinicaLogoBoleta ;
   private String[] BC000E4_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] BC000E4_n40003ClinicaLogoBoleta_GXI ;
   private String[] BC000E4_A345ClinicaLogoPago ;
   private boolean[] BC000E4_n345ClinicaLogoPago ;
   private String[] BC000E4_A40004ClinicaLogoPago_GXI ;
   private boolean[] BC000E4_n40004ClinicaLogoPago_GXI ;
   private String[] BC000E4_A346ClinicaTelefono ;
   private String[] BC000E4_A347ClinicaWhatsApp ;
   private String[] BC000E4_A348ClinicaFacebook ;
   private String[] BC000E4_A349ClinicaTwiter ;
   private String[] BC000E4_A350ClinicaInstagram ;
   private String[] BC000E4_A351ClinicaLinkedin ;
   private byte[] BC000E4_A120ClinicaTiempoDeCita ;
   private String[] BC000E4_A121ClinicaEstado ;
   private short[] BC000E5_A28ClinicaId ;
   private short[] BC000E6_A28ClinicaId ;
   private long[] BC000E6_A118ClinicaRUC ;
   private String[] BC000E6_A116ClinicaNombreComercial ;
   private String[] BC000E6_A80ClinicaNombreAbreviado ;
   private String[] BC000E6_A119ClinicaDireccionComercial ;
   private String[] BC000E6_A340ClinicaCorreo ;
   private short[] BC000E6_A341ClinicaMoneda ;
   private String[] BC000E6_A117ClinicaLogo ;
   private String[] BC000E6_A40000ClinicaLogo_GXI ;
   private String[] BC000E6_A342ClinicaLogoHeader ;
   private boolean[] BC000E6_n342ClinicaLogoHeader ;
   private String[] BC000E6_A40001ClinicaLogoHeader_GXI ;
   private boolean[] BC000E6_n40001ClinicaLogoHeader_GXI ;
   private String[] BC000E6_A343ClinicaLogoFactura ;
   private boolean[] BC000E6_n343ClinicaLogoFactura ;
   private String[] BC000E6_A40002ClinicaLogoFactura_GXI ;
   private boolean[] BC000E6_n40002ClinicaLogoFactura_GXI ;
   private String[] BC000E6_A344ClinicaLogoBoleta ;
   private boolean[] BC000E6_n344ClinicaLogoBoleta ;
   private String[] BC000E6_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] BC000E6_n40003ClinicaLogoBoleta_GXI ;
   private String[] BC000E6_A345ClinicaLogoPago ;
   private boolean[] BC000E6_n345ClinicaLogoPago ;
   private String[] BC000E6_A40004ClinicaLogoPago_GXI ;
   private boolean[] BC000E6_n40004ClinicaLogoPago_GXI ;
   private String[] BC000E6_A346ClinicaTelefono ;
   private String[] BC000E6_A347ClinicaWhatsApp ;
   private String[] BC000E6_A348ClinicaFacebook ;
   private String[] BC000E6_A349ClinicaTwiter ;
   private String[] BC000E6_A350ClinicaInstagram ;
   private String[] BC000E6_A351ClinicaLinkedin ;
   private byte[] BC000E6_A120ClinicaTiempoDeCita ;
   private String[] BC000E6_A121ClinicaEstado ;
   private short[] BC000E7_A28ClinicaId ;
   private long[] BC000E7_A118ClinicaRUC ;
   private String[] BC000E7_A116ClinicaNombreComercial ;
   private String[] BC000E7_A80ClinicaNombreAbreviado ;
   private String[] BC000E7_A119ClinicaDireccionComercial ;
   private String[] BC000E7_A340ClinicaCorreo ;
   private short[] BC000E7_A341ClinicaMoneda ;
   private String[] BC000E7_A117ClinicaLogo ;
   private String[] BC000E7_A40000ClinicaLogo_GXI ;
   private String[] BC000E7_A342ClinicaLogoHeader ;
   private boolean[] BC000E7_n342ClinicaLogoHeader ;
   private String[] BC000E7_A40001ClinicaLogoHeader_GXI ;
   private boolean[] BC000E7_n40001ClinicaLogoHeader_GXI ;
   private String[] BC000E7_A343ClinicaLogoFactura ;
   private boolean[] BC000E7_n343ClinicaLogoFactura ;
   private String[] BC000E7_A40002ClinicaLogoFactura_GXI ;
   private boolean[] BC000E7_n40002ClinicaLogoFactura_GXI ;
   private String[] BC000E7_A344ClinicaLogoBoleta ;
   private boolean[] BC000E7_n344ClinicaLogoBoleta ;
   private String[] BC000E7_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] BC000E7_n40003ClinicaLogoBoleta_GXI ;
   private String[] BC000E7_A345ClinicaLogoPago ;
   private boolean[] BC000E7_n345ClinicaLogoPago ;
   private String[] BC000E7_A40004ClinicaLogoPago_GXI ;
   private boolean[] BC000E7_n40004ClinicaLogoPago_GXI ;
   private String[] BC000E7_A346ClinicaTelefono ;
   private String[] BC000E7_A347ClinicaWhatsApp ;
   private String[] BC000E7_A348ClinicaFacebook ;
   private String[] BC000E7_A349ClinicaTwiter ;
   private String[] BC000E7_A350ClinicaInstagram ;
   private String[] BC000E7_A351ClinicaLinkedin ;
   private byte[] BC000E7_A120ClinicaTiempoDeCita ;
   private String[] BC000E7_A121ClinicaEstado ;
   private short[] BC000E8_A28ClinicaId ;
   private short[] BC000E16_A30SedeId ;
   private short[] BC000E17_A28ClinicaId ;
   private long[] BC000E17_A118ClinicaRUC ;
   private String[] BC000E17_A116ClinicaNombreComercial ;
   private String[] BC000E17_A80ClinicaNombreAbreviado ;
   private String[] BC000E17_A119ClinicaDireccionComercial ;
   private String[] BC000E17_A340ClinicaCorreo ;
   private short[] BC000E17_A341ClinicaMoneda ;
   private String[] BC000E17_A117ClinicaLogo ;
   private String[] BC000E17_A40000ClinicaLogo_GXI ;
   private String[] BC000E17_A342ClinicaLogoHeader ;
   private boolean[] BC000E17_n342ClinicaLogoHeader ;
   private String[] BC000E17_A40001ClinicaLogoHeader_GXI ;
   private boolean[] BC000E17_n40001ClinicaLogoHeader_GXI ;
   private String[] BC000E17_A343ClinicaLogoFactura ;
   private boolean[] BC000E17_n343ClinicaLogoFactura ;
   private String[] BC000E17_A40002ClinicaLogoFactura_GXI ;
   private boolean[] BC000E17_n40002ClinicaLogoFactura_GXI ;
   private String[] BC000E17_A344ClinicaLogoBoleta ;
   private boolean[] BC000E17_n344ClinicaLogoBoleta ;
   private String[] BC000E17_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] BC000E17_n40003ClinicaLogoBoleta_GXI ;
   private String[] BC000E17_A345ClinicaLogoPago ;
   private boolean[] BC000E17_n345ClinicaLogoPago ;
   private String[] BC000E17_A40004ClinicaLogoPago_GXI ;
   private boolean[] BC000E17_n40004ClinicaLogoPago_GXI ;
   private String[] BC000E17_A346ClinicaTelefono ;
   private String[] BC000E17_A347ClinicaWhatsApp ;
   private String[] BC000E17_A348ClinicaFacebook ;
   private String[] BC000E17_A349ClinicaTwiter ;
   private String[] BC000E17_A350ClinicaInstagram ;
   private String[] BC000E17_A351ClinicaLinkedin ;
   private byte[] BC000E17_A120ClinicaTiempoDeCita ;
   private String[] BC000E17_A121ClinicaEstado ;
   private short[] BC000E2_A28ClinicaId ;
   private long[] BC000E2_A118ClinicaRUC ;
   private String[] BC000E2_A116ClinicaNombreComercial ;
   private String[] BC000E2_A80ClinicaNombreAbreviado ;
   private String[] BC000E2_A119ClinicaDireccionComercial ;
   private String[] BC000E2_A340ClinicaCorreo ;
   private short[] BC000E2_A341ClinicaMoneda ;
   private String[] BC000E2_A117ClinicaLogo ;
   private String[] BC000E2_A40000ClinicaLogo_GXI ;
   private String[] BC000E2_A342ClinicaLogoHeader ;
   private String[] BC000E2_A40001ClinicaLogoHeader_GXI ;
   private String[] BC000E2_A343ClinicaLogoFactura ;
   private String[] BC000E2_A40002ClinicaLogoFactura_GXI ;
   private String[] BC000E2_A344ClinicaLogoBoleta ;
   private String[] BC000E2_A40003ClinicaLogoBoleta_GXI ;
   private String[] BC000E2_A345ClinicaLogoPago ;
   private String[] BC000E2_A40004ClinicaLogoPago_GXI ;
   private String[] BC000E2_A346ClinicaTelefono ;
   private String[] BC000E2_A347ClinicaWhatsApp ;
   private String[] BC000E2_A348ClinicaFacebook ;
   private String[] BC000E2_A349ClinicaTwiter ;
   private String[] BC000E2_A350ClinicaInstagram ;
   private String[] BC000E2_A351ClinicaLinkedin ;
   private byte[] BC000E2_A120ClinicaTiempoDeCita ;
   private String[] BC000E2_A121ClinicaEstado ;
   private short[] BC000E3_A28ClinicaId ;
   private long[] BC000E3_A118ClinicaRUC ;
   private String[] BC000E3_A116ClinicaNombreComercial ;
   private String[] BC000E3_A80ClinicaNombreAbreviado ;
   private String[] BC000E3_A119ClinicaDireccionComercial ;
   private String[] BC000E3_A340ClinicaCorreo ;
   private short[] BC000E3_A341ClinicaMoneda ;
   private String[] BC000E3_A117ClinicaLogo ;
   private String[] BC000E3_A40000ClinicaLogo_GXI ;
   private String[] BC000E3_A342ClinicaLogoHeader ;
   private String[] BC000E3_A40001ClinicaLogoHeader_GXI ;
   private String[] BC000E3_A343ClinicaLogoFactura ;
   private String[] BC000E3_A40002ClinicaLogoFactura_GXI ;
   private String[] BC000E3_A344ClinicaLogoBoleta ;
   private String[] BC000E3_A40003ClinicaLogoBoleta_GXI ;
   private String[] BC000E3_A345ClinicaLogoPago ;
   private String[] BC000E3_A40004ClinicaLogoPago_GXI ;
   private String[] BC000E3_A346ClinicaTelefono ;
   private String[] BC000E3_A347ClinicaWhatsApp ;
   private String[] BC000E3_A348ClinicaFacebook ;
   private String[] BC000E3_A349ClinicaTwiter ;
   private String[] BC000E3_A350ClinicaInstagram ;
   private String[] BC000E3_A351ClinicaLinkedin ;
   private byte[] BC000E3_A120ClinicaTiempoDeCita ;
   private String[] BC000E3_A121ClinicaEstado ;
   private boolean[] BC000E2_n342ClinicaLogoHeader ;
   private boolean[] BC000E2_n40001ClinicaLogoHeader_GXI ;
   private boolean[] BC000E2_n343ClinicaLogoFactura ;
   private boolean[] BC000E2_n40002ClinicaLogoFactura_GXI ;
   private boolean[] BC000E2_n344ClinicaLogoBoleta ;
   private boolean[] BC000E2_n40003ClinicaLogoBoleta_GXI ;
   private boolean[] BC000E2_n345ClinicaLogoPago ;
   private boolean[] BC000E2_n40004ClinicaLogoPago_GXI ;
   private boolean[] BC000E3_n342ClinicaLogoHeader ;
   private boolean[] BC000E3_n40001ClinicaLogoHeader_GXI ;
   private boolean[] BC000E3_n343ClinicaLogoFactura ;
   private boolean[] BC000E3_n40002ClinicaLogoFactura_GXI ;
   private boolean[] BC000E3_n344ClinicaLogoBoleta ;
   private boolean[] BC000E3_n40003ClinicaLogoBoleta_GXI ;
   private boolean[] BC000E3_n345ClinicaLogoPago ;
   private boolean[] BC000E3_n40004ClinicaLogoPago_GXI ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
}

final  class clinica_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000E2", "SELECT [ClinicaId], [ClinicaRUC], [ClinicaNombreComercial], [ClinicaNombreAbreviado], [ClinicaDireccionComercial], [ClinicaCorreo], [ClinicaMoneda], [ClinicaLogo], [ClinicaLogo_GXI], [ClinicaLogoHeader], [ClinicaLogoHeader_GXI], [ClinicaLogoFactura], [ClinicaLogoFactura_GXI], [ClinicaLogoBoleta], [ClinicaLogoBoleta_GXI], [ClinicaLogoPago], [ClinicaLogoPago_GXI], [ClinicaTelefono], [ClinicaWhatsApp], [ClinicaFacebook], [ClinicaTwiter], [ClinicaInstagram], [ClinicaLinkedin], [ClinicaTiempoDeCita], [ClinicaEstado] FROM [Clinica] WITH (UPDLOCK) WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E3", "SELECT [ClinicaId], [ClinicaRUC], [ClinicaNombreComercial], [ClinicaNombreAbreviado], [ClinicaDireccionComercial], [ClinicaCorreo], [ClinicaMoneda], [ClinicaLogo], [ClinicaLogo_GXI], [ClinicaLogoHeader], [ClinicaLogoHeader_GXI], [ClinicaLogoFactura], [ClinicaLogoFactura_GXI], [ClinicaLogoBoleta], [ClinicaLogoBoleta_GXI], [ClinicaLogoPago], [ClinicaLogoPago_GXI], [ClinicaTelefono], [ClinicaWhatsApp], [ClinicaFacebook], [ClinicaTwiter], [ClinicaInstagram], [ClinicaLinkedin], [ClinicaTiempoDeCita], [ClinicaEstado] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E4", "SELECT TM1.[ClinicaId], TM1.[ClinicaRUC], TM1.[ClinicaNombreComercial], TM1.[ClinicaNombreAbreviado], TM1.[ClinicaDireccionComercial], TM1.[ClinicaCorreo], TM1.[ClinicaMoneda], TM1.[ClinicaLogo], TM1.[ClinicaLogo_GXI], TM1.[ClinicaLogoHeader], TM1.[ClinicaLogoHeader_GXI], TM1.[ClinicaLogoFactura], TM1.[ClinicaLogoFactura_GXI], TM1.[ClinicaLogoBoleta], TM1.[ClinicaLogoBoleta_GXI], TM1.[ClinicaLogoPago], TM1.[ClinicaLogoPago_GXI], TM1.[ClinicaTelefono], TM1.[ClinicaWhatsApp], TM1.[ClinicaFacebook], TM1.[ClinicaTwiter], TM1.[ClinicaInstagram], TM1.[ClinicaLinkedin], TM1.[ClinicaTiempoDeCita], TM1.[ClinicaEstado] FROM [Clinica] TM1 WHERE TM1.[ClinicaId] = ? ORDER BY TM1.[ClinicaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E5", "SELECT [ClinicaId] FROM [Clinica] WHERE [ClinicaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E6", "SELECT [ClinicaId], [ClinicaRUC], [ClinicaNombreComercial], [ClinicaNombreAbreviado], [ClinicaDireccionComercial], [ClinicaCorreo], [ClinicaMoneda], [ClinicaLogo], [ClinicaLogo_GXI], [ClinicaLogoHeader], [ClinicaLogoHeader_GXI], [ClinicaLogoFactura], [ClinicaLogoFactura_GXI], [ClinicaLogoBoleta], [ClinicaLogoBoleta_GXI], [ClinicaLogoPago], [ClinicaLogoPago_GXI], [ClinicaTelefono], [ClinicaWhatsApp], [ClinicaFacebook], [ClinicaTwiter], [ClinicaInstagram], [ClinicaLinkedin], [ClinicaTiempoDeCita], [ClinicaEstado] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E7", "SELECT [ClinicaId], [ClinicaRUC], [ClinicaNombreComercial], [ClinicaNombreAbreviado], [ClinicaDireccionComercial], [ClinicaCorreo], [ClinicaMoneda], [ClinicaLogo], [ClinicaLogo_GXI], [ClinicaLogoHeader], [ClinicaLogoHeader_GXI], [ClinicaLogoFactura], [ClinicaLogoFactura_GXI], [ClinicaLogoBoleta], [ClinicaLogoBoleta_GXI], [ClinicaLogoPago], [ClinicaLogoPago_GXI], [ClinicaTelefono], [ClinicaWhatsApp], [ClinicaFacebook], [ClinicaTwiter], [ClinicaInstagram], [ClinicaLinkedin], [ClinicaTiempoDeCita], [ClinicaEstado] FROM [Clinica] WITH (UPDLOCK) WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000E8", "INSERT INTO [Clinica]([ClinicaRUC], [ClinicaNombreComercial], [ClinicaNombreAbreviado], [ClinicaDireccionComercial], [ClinicaCorreo], [ClinicaMoneda], [ClinicaLogo], [ClinicaLogo_GXI], [ClinicaLogoHeader], [ClinicaLogoHeader_GXI], [ClinicaLogoFactura], [ClinicaLogoFactura_GXI], [ClinicaLogoBoleta], [ClinicaLogoBoleta_GXI], [ClinicaLogoPago], [ClinicaLogoPago_GXI], [ClinicaTelefono], [ClinicaWhatsApp], [ClinicaFacebook], [ClinicaTwiter], [ClinicaInstagram], [ClinicaLinkedin], [ClinicaTiempoDeCita], [ClinicaEstado]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000E9", "UPDATE [Clinica] SET [ClinicaRUC]=?, [ClinicaNombreComercial]=?, [ClinicaNombreAbreviado]=?, [ClinicaDireccionComercial]=?, [ClinicaCorreo]=?, [ClinicaMoneda]=?, [ClinicaTelefono]=?, [ClinicaWhatsApp]=?, [ClinicaFacebook]=?, [ClinicaTwiter]=?, [ClinicaInstagram]=?, [ClinicaLinkedin]=?, [ClinicaTiempoDeCita]=?, [ClinicaEstado]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000E10", "UPDATE [Clinica] SET [ClinicaLogo]=?, [ClinicaLogo_GXI]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000E11", "UPDATE [Clinica] SET [ClinicaLogoHeader]=?, [ClinicaLogoHeader_GXI]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000E12", "UPDATE [Clinica] SET [ClinicaLogoFactura]=?, [ClinicaLogoFactura_GXI]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000E13", "UPDATE [Clinica] SET [ClinicaLogoBoleta]=?, [ClinicaLogoBoleta_GXI]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000E14", "UPDATE [Clinica] SET [ClinicaLogoPago]=?, [ClinicaLogoPago_GXI]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000E15", "DELETE FROM [Clinica]  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000E16", "SELECT TOP 1 [SedeId] FROM [Sede] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000E17", "SELECT TM1.[ClinicaId], TM1.[ClinicaRUC], TM1.[ClinicaNombreComercial], TM1.[ClinicaNombreAbreviado], TM1.[ClinicaDireccionComercial], TM1.[ClinicaCorreo], TM1.[ClinicaMoneda], TM1.[ClinicaLogo], TM1.[ClinicaLogo_GXI], TM1.[ClinicaLogoHeader], TM1.[ClinicaLogoHeader_GXI], TM1.[ClinicaLogoFactura], TM1.[ClinicaLogoFactura_GXI], TM1.[ClinicaLogoBoleta], TM1.[ClinicaLogoBoleta_GXI], TM1.[ClinicaLogoPago], TM1.[ClinicaLogoPago_GXI], TM1.[ClinicaTelefono], TM1.[ClinicaWhatsApp], TM1.[ClinicaFacebook], TM1.[ClinicaTwiter], TM1.[ClinicaInstagram], TM1.[ClinicaLinkedin], TM1.[ClinicaTiempoDeCita], TM1.[ClinicaEstado] FROM [Clinica] TM1 WHERE TM1.[ClinicaId] = ? ORDER BY TM1.[ClinicaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getMultimediaFile(8, rslt.getVarchar(9));
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(9);
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(10, rslt.getVarchar(11));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(12, rslt.getVarchar(13));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(15));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 12);
               ((String[]) buf[26])[0] = rslt.getString(19, 15);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 1);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getMultimediaFile(8, rslt.getVarchar(9));
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(9);
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(10, rslt.getVarchar(11));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(12, rslt.getVarchar(13));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(15));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 12);
               ((String[]) buf[26])[0] = rslt.getString(19, 15);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getMultimediaFile(8, rslt.getVarchar(9));
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(9);
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(10, rslt.getVarchar(11));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(12, rslt.getVarchar(13));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(15));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 12);
               ((String[]) buf[26])[0] = rslt.getString(19, 15);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getMultimediaFile(8, rslt.getVarchar(9));
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(9);
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(10, rslt.getVarchar(11));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(12, rslt.getVarchar(13));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(15));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 12);
               ((String[]) buf[26])[0] = rslt.getString(19, 15);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getMultimediaFile(8, rslt.getVarchar(9));
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(9);
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(10, rslt.getVarchar(11));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(12, rslt.getVarchar(13));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(15));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 12);
               ((String[]) buf[26])[0] = rslt.getString(19, 15);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getMultimediaFile(8, rslt.getVarchar(9));
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(9);
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(10, rslt.getVarchar(11));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(12, rslt.getVarchar(13));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(15));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 12);
               ((String[]) buf[26])[0] = rslt.getString(19, 15);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 1);
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
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setVarchar(4, (String)parms[3], 1024, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBLOBFile(7, (String)parms[6], true);
               stmt.setGXDbFileURI(8, (String)parms[7], (String)parms[6], 2048,"Clinica","ClinicaLogo");
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(9, (String)parms[9], true);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(10, (String)parms[11], (String)parms[9], 2048,"Clinica","ClinicaLogoHeader");
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(11, (String)parms[13], true);
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(12, (String)parms[15], (String)parms[13], 2048,"Clinica","ClinicaLogoFactura");
               }
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(13, (String)parms[17], true);
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(14, (String)parms[19], (String)parms[17], 2048,"Clinica","ClinicaLogoBoleta");
               }
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(15, (String)parms[21], true);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(16, (String)parms[23], (String)parms[21], 2048,"Clinica","ClinicaLogoPago");
               }
               stmt.setString(17, (String)parms[24], 12);
               stmt.setString(18, (String)parms[25], 15);
               stmt.setVarchar(19, (String)parms[26], 1000, false);
               stmt.setVarchar(20, (String)parms[27], 1000, false);
               stmt.setVarchar(21, (String)parms[28], 1000, false);
               stmt.setVarchar(22, (String)parms[29], 1000, false);
               stmt.setByte(23, ((Number) parms[30]).byteValue());
               stmt.setString(24, (String)parms[31], 1);
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setVarchar(4, (String)parms[3], 1024, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setString(7, (String)parms[6], 12);
               stmt.setString(8, (String)parms[7], 15);
               stmt.setVarchar(9, (String)parms[8], 1000, false);
               stmt.setVarchar(10, (String)parms[9], 1000, false);
               stmt.setVarchar(11, (String)parms[10], 1000, false);
               stmt.setVarchar(12, (String)parms[11], 1000, false);
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setString(14, (String)parms[13], 1);
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               return;
            case 8 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Clinica","ClinicaLogo");
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1], true);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(2, (String)parms[3], (String)parms[1], 2048,"Clinica","ClinicaLogoHeader");
               }
               stmt.setShort(3, ((Number) parms[4]).shortValue());
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1], true);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(2, (String)parms[3], (String)parms[1], 2048,"Clinica","ClinicaLogoFactura");
               }
               stmt.setShort(3, ((Number) parms[4]).shortValue());
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1], true);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(2, (String)parms[3], (String)parms[1], 2048,"Clinica","ClinicaLogoBoleta");
               }
               stmt.setShort(3, ((Number) parms[4]).shortValue());
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1], true);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(2, (String)parms[3], (String)parms[1], 2048,"Clinica","ClinicaLogoPago");
               }
               stmt.setShort(3, ((Number) parms[4]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

