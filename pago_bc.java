package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pago_bc extends GXWebPanel implements IGxSilentTrn
{
   public pago_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pago_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pago_bc.class ));
   }

   public pago_bc( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0T38( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0T38( ) ;
      standaloneModal( ) ;
      addRow0T38( ) ;
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
         e110T2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z47PagoId = A47PagoId ;
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

   public void confirm_0T0( )
   {
      beforeValidate0T38( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0T38( ) ;
         }
         else
         {
            checkExtendedTable0T38( ) ;
            if ( AnyError == 0 )
            {
               zm0T38( 12) ;
               zm0T38( 13) ;
               zm0T38( 14) ;
            }
            closeExtendedTableCursors0T38( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120T2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      AV7IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV7IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Insert", GXv_boolean3) ;
         pago_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV7IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV7IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Update", GXv_boolean3) ;
         pago_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV7IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV7IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Delete", GXv_boolean3) ;
         pago_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV7IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV7IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV8TrnContext.fromxml(AV9WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV8TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV24Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV25GXV1 = 1 ;
         while ( AV25GXV1 <= AV8TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV11TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV8TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV25GXV1));
            if ( GXutil.strcmp(AV11TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CitaId") == 0 )
            {
               AV10Insert_CitaId = (int)(GXutil.lval( AV11TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV11TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "DisponibilidadId") == 0 )
            {
               AV21Insert_DisponibilidadId = (int)(GXutil.lval( AV11TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV25GXV1 = (int)(AV25GXV1+1) ;
         }
      }
   }

   public void e110T2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0T38( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         Z242PagoMonto = A242PagoMonto ;
         Z243PagoToken = A243PagoToken ;
         Z247PagoTipoDocumentoCliente = A247PagoTipoDocumentoCliente ;
         Z248PagoClienteNroDocumento = A248PagoClienteNroDocumento ;
         Z249PagoClienteDenominacion = A249PagoClienteDenominacion ;
         Z250PagoClienteDireccion = A250PagoClienteDireccion ;
         Z251PagoClienteEmail = A251PagoClienteEmail ;
         Z244PagoTipoDocumento = A244PagoTipoDocumento ;
         Z245PagoNumero = A245PagoNumero ;
         Z252PagoFechaEmision = A252PagoFechaEmision ;
         Z253PagoMoneda = A253PagoMoneda ;
         Z310PagoPasarelaId = A310PagoPasarelaId ;
         Z311PagoStatusCode = A311PagoStatusCode ;
         Z338PagoEnlacePDF = A338PagoEnlacePDF ;
         Z339PagoEnlaceXML = A339PagoEnlaceXML ;
         Z246PagoEstadoR = A246PagoEstadoR ;
         Z34DisponibilidadId = A34DisponibilidadId ;
         Z19CitaId = A19CitaId ;
      }
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         Z21SGCitaDisponibilidadId = A21SGCitaDisponibilidadId ;
         Z64CitaCode = A64CitaCode ;
      }
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         Z66SGCitaDisponibilidadFecha = A66SGCitaDisponibilidadFecha ;
      }
      if ( GX_JID == -11 )
      {
         Z47PagoId = A47PagoId ;
         Z242PagoMonto = A242PagoMonto ;
         Z243PagoToken = A243PagoToken ;
         Z247PagoTipoDocumentoCliente = A247PagoTipoDocumentoCliente ;
         Z248PagoClienteNroDocumento = A248PagoClienteNroDocumento ;
         Z249PagoClienteDenominacion = A249PagoClienteDenominacion ;
         Z250PagoClienteDireccion = A250PagoClienteDireccion ;
         Z251PagoClienteEmail = A251PagoClienteEmail ;
         Z244PagoTipoDocumento = A244PagoTipoDocumento ;
         Z245PagoNumero = A245PagoNumero ;
         Z252PagoFechaEmision = A252PagoFechaEmision ;
         Z253PagoMoneda = A253PagoMoneda ;
         Z256PagoNubefactRequest = A256PagoNubefactRequest ;
         Z257PagoNubefactResponse = A257PagoNubefactResponse ;
         Z308PagoRequest = A308PagoRequest ;
         Z309PagoResponse = A309PagoResponse ;
         Z310PagoPasarelaId = A310PagoPasarelaId ;
         Z311PagoStatusCode = A311PagoStatusCode ;
         Z338PagoEnlacePDF = A338PagoEnlacePDF ;
         Z339PagoEnlaceXML = A339PagoEnlaceXML ;
         Z246PagoEstadoR = A246PagoEstadoR ;
         Z34DisponibilidadId = A34DisponibilidadId ;
         Z19CitaId = A19CitaId ;
         Z21SGCitaDisponibilidadId = A21SGCitaDisponibilidadId ;
         Z64CitaCode = A64CitaCode ;
         Z66SGCitaDisponibilidadFecha = A66SGCitaDisponibilidadFecha ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0T38( )
   {
      /* Using cursor BC000T7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A47PagoId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A21SGCitaDisponibilidadId = BC000T7_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = BC000T7_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = BC000T7_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000T7_n66SGCitaDisponibilidadFecha[0] ;
         A242PagoMonto = BC000T7_A242PagoMonto[0] ;
         A243PagoToken = BC000T7_A243PagoToken[0] ;
         A247PagoTipoDocumentoCliente = BC000T7_A247PagoTipoDocumentoCliente[0] ;
         A248PagoClienteNroDocumento = BC000T7_A248PagoClienteNroDocumento[0] ;
         A249PagoClienteDenominacion = BC000T7_A249PagoClienteDenominacion[0] ;
         A250PagoClienteDireccion = BC000T7_A250PagoClienteDireccion[0] ;
         A251PagoClienteEmail = BC000T7_A251PagoClienteEmail[0] ;
         A244PagoTipoDocumento = BC000T7_A244PagoTipoDocumento[0] ;
         A245PagoNumero = BC000T7_A245PagoNumero[0] ;
         A252PagoFechaEmision = BC000T7_A252PagoFechaEmision[0] ;
         A253PagoMoneda = BC000T7_A253PagoMoneda[0] ;
         A256PagoNubefactRequest = BC000T7_A256PagoNubefactRequest[0] ;
         A257PagoNubefactResponse = BC000T7_A257PagoNubefactResponse[0] ;
         A308PagoRequest = BC000T7_A308PagoRequest[0] ;
         A309PagoResponse = BC000T7_A309PagoResponse[0] ;
         A310PagoPasarelaId = BC000T7_A310PagoPasarelaId[0] ;
         A311PagoStatusCode = BC000T7_A311PagoStatusCode[0] ;
         A338PagoEnlacePDF = BC000T7_A338PagoEnlacePDF[0] ;
         A339PagoEnlaceXML = BC000T7_A339PagoEnlaceXML[0] ;
         A246PagoEstadoR = BC000T7_A246PagoEstadoR[0] ;
         A34DisponibilidadId = BC000T7_A34DisponibilidadId[0] ;
         n34DisponibilidadId = BC000T7_n34DisponibilidadId[0] ;
         A19CitaId = BC000T7_A19CitaId[0] ;
         n19CitaId = BC000T7_n19CitaId[0] ;
         zm0T38( -11) ;
      }
      pr_default.close(5);
      onLoadActions0T38( ) ;
   }

   public void onLoadActions0T38( )
   {
      AV24Pgmname = "Pago_BC" ;
   }

   public void checkExtendedTable0T38( )
   {
      nIsDirty_38 = (short)(0) ;
      standaloneModal( ) ;
      AV24Pgmname = "Pago_BC" ;
      /* Using cursor BC000T8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A19CitaId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
            AnyError = (short)(1) ;
         }
      }
      A21SGCitaDisponibilidadId = BC000T8_A21SGCitaDisponibilidadId[0] ;
      A64CitaCode = BC000T8_A64CitaCode[0] ;
      pr_default.close(6);
      /* Using cursor BC000T9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A21SGCitaDisponibilidadId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
            AnyError = (short)(1) ;
         }
      }
      A66SGCitaDisponibilidadFecha = BC000T9_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = BC000T9_n66SGCitaDisponibilidadFecha[0] ;
      pr_default.close(7);
      if ( ! ( ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "6") == 0 ) || ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "1") == 0 ) || ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "4") == 0 ) || ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "7") == 0 ) || ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "A") == 0 ) || ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "0") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pago Tipo Documento Cliente fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A251PagoClienteEmail,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Pago Cliente Email no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A244PagoTipoDocumento == 1 ) || ( A244PagoTipoDocumento == 2 ) || ( A244PagoTipoDocumento == 3 ) || ( A244PagoTipoDocumento == 4 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pago Tipo Documento fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A252PagoFechaEmision)) || (( GXutil.resetTime(A252PagoFechaEmision).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A252PagoFechaEmision), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pago Fecha Emision fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A253PagoMoneda == 1 ) || ( A253PagoMoneda == 2 ) || ( A253PagoMoneda == 3 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pago Moneda fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000T10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A34DisponibilidadId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Disponibilidad'.", "ForeignKeyNotFound", 1, "DISPONIBILIDADID");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(8);
      if ( ! ( GxRegex.IsMatch(A338PagoEnlacePDF,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Pago Enlace PDF no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A339PagoEnlaceXML,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Pago Enlace XML no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A246PagoEstadoR, "A") == 0 ) || ( GXutil.strcmp(A246PagoEstadoR, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pago Estado R fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0T38( )
   {
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void getKey0T38( )
   {
      /* Using cursor BC000T11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A47PagoId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound38 = (short)(1) ;
      }
      else
      {
         RcdFound38 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000T12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A47PagoId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         zm0T38( 11) ;
         RcdFound38 = (short)(1) ;
         A47PagoId = BC000T12_A47PagoId[0] ;
         A242PagoMonto = BC000T12_A242PagoMonto[0] ;
         A243PagoToken = BC000T12_A243PagoToken[0] ;
         A247PagoTipoDocumentoCliente = BC000T12_A247PagoTipoDocumentoCliente[0] ;
         A248PagoClienteNroDocumento = BC000T12_A248PagoClienteNroDocumento[0] ;
         A249PagoClienteDenominacion = BC000T12_A249PagoClienteDenominacion[0] ;
         A250PagoClienteDireccion = BC000T12_A250PagoClienteDireccion[0] ;
         A251PagoClienteEmail = BC000T12_A251PagoClienteEmail[0] ;
         A244PagoTipoDocumento = BC000T12_A244PagoTipoDocumento[0] ;
         A245PagoNumero = BC000T12_A245PagoNumero[0] ;
         A252PagoFechaEmision = BC000T12_A252PagoFechaEmision[0] ;
         A253PagoMoneda = BC000T12_A253PagoMoneda[0] ;
         A256PagoNubefactRequest = BC000T12_A256PagoNubefactRequest[0] ;
         A257PagoNubefactResponse = BC000T12_A257PagoNubefactResponse[0] ;
         A308PagoRequest = BC000T12_A308PagoRequest[0] ;
         A309PagoResponse = BC000T12_A309PagoResponse[0] ;
         A310PagoPasarelaId = BC000T12_A310PagoPasarelaId[0] ;
         A311PagoStatusCode = BC000T12_A311PagoStatusCode[0] ;
         A338PagoEnlacePDF = BC000T12_A338PagoEnlacePDF[0] ;
         A339PagoEnlaceXML = BC000T12_A339PagoEnlaceXML[0] ;
         A246PagoEstadoR = BC000T12_A246PagoEstadoR[0] ;
         A34DisponibilidadId = BC000T12_A34DisponibilidadId[0] ;
         n34DisponibilidadId = BC000T12_n34DisponibilidadId[0] ;
         A19CitaId = BC000T12_A19CitaId[0] ;
         n19CitaId = BC000T12_n19CitaId[0] ;
         Z47PagoId = A47PagoId ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0T38( ) ;
         if ( AnyError == 1 )
         {
            RcdFound38 = (short)(0) ;
            initializeNonKey0T38( ) ;
         }
         Gx_mode = sMode38 ;
      }
      else
      {
         RcdFound38 = (short)(0) ;
         initializeNonKey0T38( ) ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode38 ;
      }
      pr_default.close(10);
   }

   public void getEqualNoModal( )
   {
      getKey0T38( ) ;
      if ( RcdFound38 == 0 )
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
      confirm_0T0( ) ;
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

   public void checkOptimisticConcurrency0T38( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000T13 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A47PagoId)});
         if ( (pr_default.getStatus(11) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pago"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(11) == 101) || ( DecimalUtil.compareTo(Z242PagoMonto, BC000T13_A242PagoMonto[0]) != 0 ) || ( GXutil.strcmp(Z243PagoToken, BC000T13_A243PagoToken[0]) != 0 ) || ( GXutil.strcmp(Z247PagoTipoDocumentoCliente, BC000T13_A247PagoTipoDocumentoCliente[0]) != 0 ) || ( GXutil.strcmp(Z248PagoClienteNroDocumento, BC000T13_A248PagoClienteNroDocumento[0]) != 0 ) || ( GXutil.strcmp(Z249PagoClienteDenominacion, BC000T13_A249PagoClienteDenominacion[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z250PagoClienteDireccion, BC000T13_A250PagoClienteDireccion[0]) != 0 ) || ( GXutil.strcmp(Z251PagoClienteEmail, BC000T13_A251PagoClienteEmail[0]) != 0 ) || ( Z244PagoTipoDocumento != BC000T13_A244PagoTipoDocumento[0] ) || ( Z245PagoNumero != BC000T13_A245PagoNumero[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z252PagoFechaEmision), GXutil.resetTime(BC000T13_A252PagoFechaEmision[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z253PagoMoneda != BC000T13_A253PagoMoneda[0] ) || ( GXutil.strcmp(Z310PagoPasarelaId, BC000T13_A310PagoPasarelaId[0]) != 0 ) || ( Z311PagoStatusCode != BC000T13_A311PagoStatusCode[0] ) || ( GXutil.strcmp(Z338PagoEnlacePDF, BC000T13_A338PagoEnlacePDF[0]) != 0 ) || ( GXutil.strcmp(Z339PagoEnlaceXML, BC000T13_A339PagoEnlaceXML[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z246PagoEstadoR, BC000T13_A246PagoEstadoR[0]) != 0 ) || ( Z34DisponibilidadId != BC000T13_A34DisponibilidadId[0] ) || ( Z19CitaId != BC000T13_A19CitaId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Pago"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0T38( )
   {
      beforeValidate0T38( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0T38( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0T38( 0) ;
         checkOptimisticConcurrency0T38( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0T38( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0T38( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000T14 */
                  pr_default.execute(12, new Object[] {A242PagoMonto, A243PagoToken, A247PagoTipoDocumentoCliente, A248PagoClienteNroDocumento, A249PagoClienteDenominacion, A250PagoClienteDireccion, A251PagoClienteEmail, Short.valueOf(A244PagoTipoDocumento), Integer.valueOf(A245PagoNumero), A252PagoFechaEmision, Short.valueOf(A253PagoMoneda), A256PagoNubefactRequest, A257PagoNubefactResponse, A308PagoRequest, A309PagoResponse, A310PagoPasarelaId, Integer.valueOf(A311PagoStatusCode), A338PagoEnlacePDF, A339PagoEnlaceXML, A246PagoEstadoR, Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
                  A47PagoId = BC000T14_A47PagoId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pago");
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
            load0T38( ) ;
         }
         endLevel0T38( ) ;
      }
      closeExtendedTableCursors0T38( ) ;
   }

   public void update0T38( )
   {
      beforeValidate0T38( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0T38( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0T38( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0T38( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0T38( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000T15 */
                  pr_default.execute(13, new Object[] {A242PagoMonto, A243PagoToken, A247PagoTipoDocumentoCliente, A248PagoClienteNroDocumento, A249PagoClienteDenominacion, A250PagoClienteDireccion, A251PagoClienteEmail, Short.valueOf(A244PagoTipoDocumento), Integer.valueOf(A245PagoNumero), A252PagoFechaEmision, Short.valueOf(A253PagoMoneda), A256PagoNubefactRequest, A257PagoNubefactResponse, A308PagoRequest, A309PagoResponse, A310PagoPasarelaId, Integer.valueOf(A311PagoStatusCode), A338PagoEnlacePDF, A339PagoEnlaceXML, A246PagoEstadoR, Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId), Integer.valueOf(A47PagoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pago");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pago"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0T38( ) ;
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
         endLevel0T38( ) ;
      }
      closeExtendedTableCursors0T38( ) ;
   }

   public void deferredUpdate0T38( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0T38( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0T38( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0T38( ) ;
         afterConfirm0T38( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0T38( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000T16 */
               pr_default.execute(14, new Object[] {Integer.valueOf(A47PagoId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Pago");
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
      sMode38 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0T38( ) ;
      Gx_mode = sMode38 ;
   }

   public void onDeleteControls0T38( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV24Pgmname = "Pago_BC" ;
         /* Using cursor BC000T17 */
         pr_default.execute(15, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         A21SGCitaDisponibilidadId = BC000T17_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = BC000T17_A64CitaCode[0] ;
         pr_default.close(15);
         /* Using cursor BC000T18 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
         A66SGCitaDisponibilidadFecha = BC000T18_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000T18_n66SGCitaDisponibilidadFecha[0] ;
         pr_default.close(16);
      }
   }

   public void endLevel0T38( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0T38( ) ;
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

   public void scanKeyStart0T38( )
   {
      /* Scan By routine */
      /* Using cursor BC000T19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A47PagoId)});
      RcdFound38 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A21SGCitaDisponibilidadId = BC000T19_A21SGCitaDisponibilidadId[0] ;
         A47PagoId = BC000T19_A47PagoId[0] ;
         A64CitaCode = BC000T19_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = BC000T19_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000T19_n66SGCitaDisponibilidadFecha[0] ;
         A242PagoMonto = BC000T19_A242PagoMonto[0] ;
         A243PagoToken = BC000T19_A243PagoToken[0] ;
         A247PagoTipoDocumentoCliente = BC000T19_A247PagoTipoDocumentoCliente[0] ;
         A248PagoClienteNroDocumento = BC000T19_A248PagoClienteNroDocumento[0] ;
         A249PagoClienteDenominacion = BC000T19_A249PagoClienteDenominacion[0] ;
         A250PagoClienteDireccion = BC000T19_A250PagoClienteDireccion[0] ;
         A251PagoClienteEmail = BC000T19_A251PagoClienteEmail[0] ;
         A244PagoTipoDocumento = BC000T19_A244PagoTipoDocumento[0] ;
         A245PagoNumero = BC000T19_A245PagoNumero[0] ;
         A252PagoFechaEmision = BC000T19_A252PagoFechaEmision[0] ;
         A253PagoMoneda = BC000T19_A253PagoMoneda[0] ;
         A256PagoNubefactRequest = BC000T19_A256PagoNubefactRequest[0] ;
         A257PagoNubefactResponse = BC000T19_A257PagoNubefactResponse[0] ;
         A308PagoRequest = BC000T19_A308PagoRequest[0] ;
         A309PagoResponse = BC000T19_A309PagoResponse[0] ;
         A310PagoPasarelaId = BC000T19_A310PagoPasarelaId[0] ;
         A311PagoStatusCode = BC000T19_A311PagoStatusCode[0] ;
         A338PagoEnlacePDF = BC000T19_A338PagoEnlacePDF[0] ;
         A339PagoEnlaceXML = BC000T19_A339PagoEnlaceXML[0] ;
         A246PagoEstadoR = BC000T19_A246PagoEstadoR[0] ;
         A34DisponibilidadId = BC000T19_A34DisponibilidadId[0] ;
         n34DisponibilidadId = BC000T19_n34DisponibilidadId[0] ;
         A19CitaId = BC000T19_A19CitaId[0] ;
         n19CitaId = BC000T19_n19CitaId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0T38( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound38 = (short)(0) ;
      scanKeyLoad0T38( ) ;
   }

   public void scanKeyLoad0T38( )
   {
      sMode38 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A21SGCitaDisponibilidadId = BC000T19_A21SGCitaDisponibilidadId[0] ;
         A47PagoId = BC000T19_A47PagoId[0] ;
         A64CitaCode = BC000T19_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = BC000T19_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = BC000T19_n66SGCitaDisponibilidadFecha[0] ;
         A242PagoMonto = BC000T19_A242PagoMonto[0] ;
         A243PagoToken = BC000T19_A243PagoToken[0] ;
         A247PagoTipoDocumentoCliente = BC000T19_A247PagoTipoDocumentoCliente[0] ;
         A248PagoClienteNroDocumento = BC000T19_A248PagoClienteNroDocumento[0] ;
         A249PagoClienteDenominacion = BC000T19_A249PagoClienteDenominacion[0] ;
         A250PagoClienteDireccion = BC000T19_A250PagoClienteDireccion[0] ;
         A251PagoClienteEmail = BC000T19_A251PagoClienteEmail[0] ;
         A244PagoTipoDocumento = BC000T19_A244PagoTipoDocumento[0] ;
         A245PagoNumero = BC000T19_A245PagoNumero[0] ;
         A252PagoFechaEmision = BC000T19_A252PagoFechaEmision[0] ;
         A253PagoMoneda = BC000T19_A253PagoMoneda[0] ;
         A256PagoNubefactRequest = BC000T19_A256PagoNubefactRequest[0] ;
         A257PagoNubefactResponse = BC000T19_A257PagoNubefactResponse[0] ;
         A308PagoRequest = BC000T19_A308PagoRequest[0] ;
         A309PagoResponse = BC000T19_A309PagoResponse[0] ;
         A310PagoPasarelaId = BC000T19_A310PagoPasarelaId[0] ;
         A311PagoStatusCode = BC000T19_A311PagoStatusCode[0] ;
         A338PagoEnlacePDF = BC000T19_A338PagoEnlacePDF[0] ;
         A339PagoEnlaceXML = BC000T19_A339PagoEnlaceXML[0] ;
         A246PagoEstadoR = BC000T19_A246PagoEstadoR[0] ;
         A34DisponibilidadId = BC000T19_A34DisponibilidadId[0] ;
         n34DisponibilidadId = BC000T19_n34DisponibilidadId[0] ;
         A19CitaId = BC000T19_A19CitaId[0] ;
         n19CitaId = BC000T19_n19CitaId[0] ;
      }
      Gx_mode = sMode38 ;
   }

   public void scanKeyEnd0T38( )
   {
      pr_default.close(17);
   }

   public void afterConfirm0T38( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0T38( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0T38( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0T38( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0T38( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0T38( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0T38( )
   {
   }

   public void send_integrity_lvl_hashes0T38( )
   {
   }

   public void addRow0T38( )
   {
      VarsToRow38( bcPago) ;
   }

   public void readRow0T38( )
   {
      RowToVars38( bcPago, 1) ;
   }

   public void initializeNonKey0T38( )
   {
      A21SGCitaDisponibilidadId = 0 ;
      A19CitaId = 0 ;
      n19CitaId = false ;
      A64CitaCode = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      n66SGCitaDisponibilidadFecha = false ;
      A242PagoMonto = DecimalUtil.ZERO ;
      A243PagoToken = "" ;
      A247PagoTipoDocumentoCliente = "" ;
      A248PagoClienteNroDocumento = "" ;
      A249PagoClienteDenominacion = "" ;
      A250PagoClienteDireccion = "" ;
      A251PagoClienteEmail = "" ;
      A244PagoTipoDocumento = (short)(0) ;
      A245PagoNumero = 0 ;
      A252PagoFechaEmision = GXutil.nullDate() ;
      A253PagoMoneda = (short)(0) ;
      A256PagoNubefactRequest = "" ;
      A257PagoNubefactResponse = "" ;
      A308PagoRequest = "" ;
      A309PagoResponse = "" ;
      A310PagoPasarelaId = "" ;
      A311PagoStatusCode = 0 ;
      A34DisponibilidadId = 0 ;
      n34DisponibilidadId = false ;
      A338PagoEnlacePDF = "" ;
      A339PagoEnlaceXML = "" ;
      A246PagoEstadoR = "" ;
      Z242PagoMonto = DecimalUtil.ZERO ;
      Z243PagoToken = "" ;
      Z247PagoTipoDocumentoCliente = "" ;
      Z248PagoClienteNroDocumento = "" ;
      Z249PagoClienteDenominacion = "" ;
      Z250PagoClienteDireccion = "" ;
      Z251PagoClienteEmail = "" ;
      Z244PagoTipoDocumento = (short)(0) ;
      Z245PagoNumero = 0 ;
      Z252PagoFechaEmision = GXutil.nullDate() ;
      Z253PagoMoneda = (short)(0) ;
      Z310PagoPasarelaId = "" ;
      Z311PagoStatusCode = 0 ;
      Z338PagoEnlacePDF = "" ;
      Z339PagoEnlaceXML = "" ;
      Z246PagoEstadoR = "" ;
      Z34DisponibilidadId = 0 ;
      Z19CitaId = 0 ;
   }

   public void initAll0T38( )
   {
      A47PagoId = 0 ;
      initializeNonKey0T38( ) ;
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

   public void VarsToRow38( com.projectthani.SdtPago obj38 )
   {
      obj38.setgxTv_SdtPago_Mode( Gx_mode );
      obj38.setgxTv_SdtPago_Citaid( A19CitaId );
      obj38.setgxTv_SdtPago_Citacode( A64CitaCode );
      obj38.setgxTv_SdtPago_Sgcitadisponibilidadfecha( A66SGCitaDisponibilidadFecha );
      obj38.setgxTv_SdtPago_Pagomonto( A242PagoMonto );
      obj38.setgxTv_SdtPago_Pagotoken( A243PagoToken );
      obj38.setgxTv_SdtPago_Pagotipodocumentocliente( A247PagoTipoDocumentoCliente );
      obj38.setgxTv_SdtPago_Pagoclientenrodocumento( A248PagoClienteNroDocumento );
      obj38.setgxTv_SdtPago_Pagoclientedenominacion( A249PagoClienteDenominacion );
      obj38.setgxTv_SdtPago_Pagoclientedireccion( A250PagoClienteDireccion );
      obj38.setgxTv_SdtPago_Pagoclienteemail( A251PagoClienteEmail );
      obj38.setgxTv_SdtPago_Pagotipodocumento( A244PagoTipoDocumento );
      obj38.setgxTv_SdtPago_Pagonumero( A245PagoNumero );
      obj38.setgxTv_SdtPago_Pagofechaemision( A252PagoFechaEmision );
      obj38.setgxTv_SdtPago_Pagomoneda( A253PagoMoneda );
      obj38.setgxTv_SdtPago_Pagonubefactrequest( A256PagoNubefactRequest );
      obj38.setgxTv_SdtPago_Pagonubefactresponse( A257PagoNubefactResponse );
      obj38.setgxTv_SdtPago_Pagorequest( A308PagoRequest );
      obj38.setgxTv_SdtPago_Pagoresponse( A309PagoResponse );
      obj38.setgxTv_SdtPago_Pagopasarelaid( A310PagoPasarelaId );
      obj38.setgxTv_SdtPago_Pagostatuscode( A311PagoStatusCode );
      obj38.setgxTv_SdtPago_Disponibilidadid( A34DisponibilidadId );
      obj38.setgxTv_SdtPago_Pagoenlacepdf( A338PagoEnlacePDF );
      obj38.setgxTv_SdtPago_Pagoenlacexml( A339PagoEnlaceXML );
      obj38.setgxTv_SdtPago_Pagoestador( A246PagoEstadoR );
      obj38.setgxTv_SdtPago_Pagoid( A47PagoId );
      obj38.setgxTv_SdtPago_Pagoid_Z( Z47PagoId );
      obj38.setgxTv_SdtPago_Citaid_Z( Z19CitaId );
      obj38.setgxTv_SdtPago_Citacode_Z( Z64CitaCode );
      obj38.setgxTv_SdtPago_Sgcitadisponibilidadfecha_Z( Z66SGCitaDisponibilidadFecha );
      obj38.setgxTv_SdtPago_Pagomonto_Z( Z242PagoMonto );
      obj38.setgxTv_SdtPago_Pagotoken_Z( Z243PagoToken );
      obj38.setgxTv_SdtPago_Pagotipodocumentocliente_Z( Z247PagoTipoDocumentoCliente );
      obj38.setgxTv_SdtPago_Pagoclientenrodocumento_Z( Z248PagoClienteNroDocumento );
      obj38.setgxTv_SdtPago_Pagoclientedenominacion_Z( Z249PagoClienteDenominacion );
      obj38.setgxTv_SdtPago_Pagoclientedireccion_Z( Z250PagoClienteDireccion );
      obj38.setgxTv_SdtPago_Pagoclienteemail_Z( Z251PagoClienteEmail );
      obj38.setgxTv_SdtPago_Pagotipodocumento_Z( Z244PagoTipoDocumento );
      obj38.setgxTv_SdtPago_Pagonumero_Z( Z245PagoNumero );
      obj38.setgxTv_SdtPago_Pagofechaemision_Z( Z252PagoFechaEmision );
      obj38.setgxTv_SdtPago_Pagomoneda_Z( Z253PagoMoneda );
      obj38.setgxTv_SdtPago_Pagopasarelaid_Z( Z310PagoPasarelaId );
      obj38.setgxTv_SdtPago_Pagostatuscode_Z( Z311PagoStatusCode );
      obj38.setgxTv_SdtPago_Disponibilidadid_Z( Z34DisponibilidadId );
      obj38.setgxTv_SdtPago_Pagoenlacepdf_Z( Z338PagoEnlacePDF );
      obj38.setgxTv_SdtPago_Pagoenlacexml_Z( Z339PagoEnlaceXML );
      obj38.setgxTv_SdtPago_Pagoestador_Z( Z246PagoEstadoR );
      obj38.setgxTv_SdtPago_Citaid_N( (byte)((byte)((n19CitaId)?1:0)) );
      obj38.setgxTv_SdtPago_Sgcitadisponibilidadfecha_N( (byte)((byte)((n66SGCitaDisponibilidadFecha)?1:0)) );
      obj38.setgxTv_SdtPago_Disponibilidadid_N( (byte)((byte)((n34DisponibilidadId)?1:0)) );
      obj38.setgxTv_SdtPago_Mode( Gx_mode );
   }

   public void KeyVarsToRow38( com.projectthani.SdtPago obj38 )
   {
      obj38.setgxTv_SdtPago_Pagoid( A47PagoId );
   }

   public void RowToVars38( com.projectthani.SdtPago obj38 ,
                            int forceLoad )
   {
      Gx_mode = obj38.getgxTv_SdtPago_Mode() ;
      A19CitaId = obj38.getgxTv_SdtPago_Citaid() ;
      n19CitaId = false ;
      A64CitaCode = obj38.getgxTv_SdtPago_Citacode() ;
      A66SGCitaDisponibilidadFecha = obj38.getgxTv_SdtPago_Sgcitadisponibilidadfecha() ;
      n66SGCitaDisponibilidadFecha = false ;
      A242PagoMonto = obj38.getgxTv_SdtPago_Pagomonto() ;
      A243PagoToken = obj38.getgxTv_SdtPago_Pagotoken() ;
      A247PagoTipoDocumentoCliente = obj38.getgxTv_SdtPago_Pagotipodocumentocliente() ;
      A248PagoClienteNroDocumento = obj38.getgxTv_SdtPago_Pagoclientenrodocumento() ;
      A249PagoClienteDenominacion = obj38.getgxTv_SdtPago_Pagoclientedenominacion() ;
      A250PagoClienteDireccion = obj38.getgxTv_SdtPago_Pagoclientedireccion() ;
      A251PagoClienteEmail = obj38.getgxTv_SdtPago_Pagoclienteemail() ;
      A244PagoTipoDocumento = obj38.getgxTv_SdtPago_Pagotipodocumento() ;
      A245PagoNumero = obj38.getgxTv_SdtPago_Pagonumero() ;
      A252PagoFechaEmision = obj38.getgxTv_SdtPago_Pagofechaemision() ;
      A253PagoMoneda = obj38.getgxTv_SdtPago_Pagomoneda() ;
      A256PagoNubefactRequest = obj38.getgxTv_SdtPago_Pagonubefactrequest() ;
      A257PagoNubefactResponse = obj38.getgxTv_SdtPago_Pagonubefactresponse() ;
      A308PagoRequest = obj38.getgxTv_SdtPago_Pagorequest() ;
      A309PagoResponse = obj38.getgxTv_SdtPago_Pagoresponse() ;
      A310PagoPasarelaId = obj38.getgxTv_SdtPago_Pagopasarelaid() ;
      A311PagoStatusCode = obj38.getgxTv_SdtPago_Pagostatuscode() ;
      A34DisponibilidadId = obj38.getgxTv_SdtPago_Disponibilidadid() ;
      n34DisponibilidadId = false ;
      A338PagoEnlacePDF = obj38.getgxTv_SdtPago_Pagoenlacepdf() ;
      A339PagoEnlaceXML = obj38.getgxTv_SdtPago_Pagoenlacexml() ;
      A246PagoEstadoR = obj38.getgxTv_SdtPago_Pagoestador() ;
      A47PagoId = obj38.getgxTv_SdtPago_Pagoid() ;
      Z47PagoId = obj38.getgxTv_SdtPago_Pagoid_Z() ;
      Z19CitaId = obj38.getgxTv_SdtPago_Citaid_Z() ;
      Z64CitaCode = obj38.getgxTv_SdtPago_Citacode_Z() ;
      Z66SGCitaDisponibilidadFecha = obj38.getgxTv_SdtPago_Sgcitadisponibilidadfecha_Z() ;
      Z242PagoMonto = obj38.getgxTv_SdtPago_Pagomonto_Z() ;
      Z243PagoToken = obj38.getgxTv_SdtPago_Pagotoken_Z() ;
      Z247PagoTipoDocumentoCliente = obj38.getgxTv_SdtPago_Pagotipodocumentocliente_Z() ;
      Z248PagoClienteNroDocumento = obj38.getgxTv_SdtPago_Pagoclientenrodocumento_Z() ;
      Z249PagoClienteDenominacion = obj38.getgxTv_SdtPago_Pagoclientedenominacion_Z() ;
      Z250PagoClienteDireccion = obj38.getgxTv_SdtPago_Pagoclientedireccion_Z() ;
      Z251PagoClienteEmail = obj38.getgxTv_SdtPago_Pagoclienteemail_Z() ;
      Z244PagoTipoDocumento = obj38.getgxTv_SdtPago_Pagotipodocumento_Z() ;
      Z245PagoNumero = obj38.getgxTv_SdtPago_Pagonumero_Z() ;
      Z252PagoFechaEmision = obj38.getgxTv_SdtPago_Pagofechaemision_Z() ;
      Z253PagoMoneda = obj38.getgxTv_SdtPago_Pagomoneda_Z() ;
      Z310PagoPasarelaId = obj38.getgxTv_SdtPago_Pagopasarelaid_Z() ;
      Z311PagoStatusCode = obj38.getgxTv_SdtPago_Pagostatuscode_Z() ;
      Z34DisponibilidadId = obj38.getgxTv_SdtPago_Disponibilidadid_Z() ;
      Z338PagoEnlacePDF = obj38.getgxTv_SdtPago_Pagoenlacepdf_Z() ;
      Z339PagoEnlaceXML = obj38.getgxTv_SdtPago_Pagoenlacexml_Z() ;
      Z246PagoEstadoR = obj38.getgxTv_SdtPago_Pagoestador_Z() ;
      n19CitaId = (boolean)((obj38.getgxTv_SdtPago_Citaid_N()==0)?false:true) ;
      n66SGCitaDisponibilidadFecha = (boolean)((obj38.getgxTv_SdtPago_Sgcitadisponibilidadfecha_N()==0)?false:true) ;
      n34DisponibilidadId = (boolean)((obj38.getgxTv_SdtPago_Disponibilidadid_N()==0)?false:true) ;
      Gx_mode = obj38.getgxTv_SdtPago_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A47PagoId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0T38( ) ;
      scanKeyStart0T38( ) ;
      if ( RcdFound38 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z47PagoId = A47PagoId ;
      }
      zm0T38( -11) ;
      onLoadActions0T38( ) ;
      addRow0T38( ) ;
      scanKeyEnd0T38( ) ;
      if ( RcdFound38 == 0 )
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
      RowToVars38( bcPago, 0) ;
      scanKeyStart0T38( ) ;
      if ( RcdFound38 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z47PagoId = A47PagoId ;
      }
      zm0T38( -11) ;
      onLoadActions0T38( ) ;
      addRow0T38( ) ;
      scanKeyEnd0T38( ) ;
      if ( RcdFound38 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0T38( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0T38( ) ;
      }
      else
      {
         if ( RcdFound38 == 1 )
         {
            if ( A47PagoId != Z47PagoId )
            {
               A47PagoId = Z47PagoId ;
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
               update0T38( ) ;
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
               if ( A47PagoId != Z47PagoId )
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
                     insert0T38( ) ;
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
                     insert0T38( ) ;
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
      RowToVars38( bcPago, 1) ;
      saveImpl( ) ;
      VarsToRow38( bcPago) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars38( bcPago, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0T38( ) ;
      afterTrn( ) ;
      VarsToRow38( bcPago) ;
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
         com.projectthani.SdtPago auxBC = new com.projectthani.SdtPago( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A47PagoId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcPago);
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
      RowToVars38( bcPago, 1) ;
      updateImpl( ) ;
      VarsToRow38( bcPago) ;
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
      RowToVars38( bcPago, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0T38( ) ;
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
      VarsToRow38( bcPago) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars38( bcPago, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0T38( ) ;
      if ( RcdFound38 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A47PagoId != Z47PagoId )
         {
            A47PagoId = Z47PagoId ;
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
         if ( A47PagoId != Z47PagoId )
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
      pr_default.close(2);
      pr_default.close(15);
      pr_default.close(3);
      pr_default.close(16);
      pr_default.close(4);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "pago_bc");
      VarsToRow38( bcPago) ;
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
      Gx_mode = bcPago.getgxTv_SdtPago_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcPago.setgxTv_SdtPago_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtPago sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcPago )
      {
         bcPago = sdt ;
         if ( GXutil.strcmp(bcPago.getgxTv_SdtPago_Mode(), "") == 0 )
         {
            bcPago.setgxTv_SdtPago_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow38( bcPago) ;
         }
         else
         {
            RowToVars38( bcPago, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcPago.getgxTv_SdtPago_Mode(), "") == 0 )
         {
            bcPago.setgxTv_SdtPago_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars38( bcPago, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtPago getPago_BC( )
   {
      return bcPago ;
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
      AV12WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV24Pgmname = "" ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9WebSession = httpContext.getWebSession();
      AV11TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z242PagoMonto = DecimalUtil.ZERO ;
      A242PagoMonto = DecimalUtil.ZERO ;
      Z243PagoToken = "" ;
      A243PagoToken = "" ;
      Z247PagoTipoDocumentoCliente = "" ;
      A247PagoTipoDocumentoCliente = "" ;
      Z248PagoClienteNroDocumento = "" ;
      A248PagoClienteNroDocumento = "" ;
      Z249PagoClienteDenominacion = "" ;
      A249PagoClienteDenominacion = "" ;
      Z250PagoClienteDireccion = "" ;
      A250PagoClienteDireccion = "" ;
      Z251PagoClienteEmail = "" ;
      A251PagoClienteEmail = "" ;
      Z252PagoFechaEmision = GXutil.nullDate() ;
      A252PagoFechaEmision = GXutil.nullDate() ;
      Z310PagoPasarelaId = "" ;
      A310PagoPasarelaId = "" ;
      Z338PagoEnlacePDF = "" ;
      A338PagoEnlacePDF = "" ;
      Z339PagoEnlaceXML = "" ;
      A339PagoEnlaceXML = "" ;
      Z246PagoEstadoR = "" ;
      A246PagoEstadoR = "" ;
      Z64CitaCode = "" ;
      A64CitaCode = "" ;
      Z66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      Z256PagoNubefactRequest = "" ;
      A256PagoNubefactRequest = "" ;
      Z257PagoNubefactResponse = "" ;
      A257PagoNubefactResponse = "" ;
      Z308PagoRequest = "" ;
      A308PagoRequest = "" ;
      Z309PagoResponse = "" ;
      A309PagoResponse = "" ;
      BC000T7_A21SGCitaDisponibilidadId = new int[1] ;
      BC000T7_A47PagoId = new int[1] ;
      BC000T7_A64CitaCode = new String[] {""} ;
      BC000T7_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000T7_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000T7_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000T7_A243PagoToken = new String[] {""} ;
      BC000T7_A247PagoTipoDocumentoCliente = new String[] {""} ;
      BC000T7_A248PagoClienteNroDocumento = new String[] {""} ;
      BC000T7_A249PagoClienteDenominacion = new String[] {""} ;
      BC000T7_A250PagoClienteDireccion = new String[] {""} ;
      BC000T7_A251PagoClienteEmail = new String[] {""} ;
      BC000T7_A244PagoTipoDocumento = new short[1] ;
      BC000T7_A245PagoNumero = new int[1] ;
      BC000T7_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      BC000T7_A253PagoMoneda = new short[1] ;
      BC000T7_A256PagoNubefactRequest = new String[] {""} ;
      BC000T7_A257PagoNubefactResponse = new String[] {""} ;
      BC000T7_A308PagoRequest = new String[] {""} ;
      BC000T7_A309PagoResponse = new String[] {""} ;
      BC000T7_A310PagoPasarelaId = new String[] {""} ;
      BC000T7_A311PagoStatusCode = new int[1] ;
      BC000T7_A338PagoEnlacePDF = new String[] {""} ;
      BC000T7_A339PagoEnlaceXML = new String[] {""} ;
      BC000T7_A246PagoEstadoR = new String[] {""} ;
      BC000T7_A34DisponibilidadId = new int[1] ;
      BC000T7_n34DisponibilidadId = new boolean[] {false} ;
      BC000T7_A19CitaId = new int[1] ;
      BC000T7_n19CitaId = new boolean[] {false} ;
      BC000T8_A21SGCitaDisponibilidadId = new int[1] ;
      BC000T8_A64CitaCode = new String[] {""} ;
      BC000T9_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000T9_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000T10_A34DisponibilidadId = new int[1] ;
      BC000T10_n34DisponibilidadId = new boolean[] {false} ;
      BC000T11_A47PagoId = new int[1] ;
      BC000T12_A47PagoId = new int[1] ;
      BC000T12_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000T12_A243PagoToken = new String[] {""} ;
      BC000T12_A247PagoTipoDocumentoCliente = new String[] {""} ;
      BC000T12_A248PagoClienteNroDocumento = new String[] {""} ;
      BC000T12_A249PagoClienteDenominacion = new String[] {""} ;
      BC000T12_A250PagoClienteDireccion = new String[] {""} ;
      BC000T12_A251PagoClienteEmail = new String[] {""} ;
      BC000T12_A244PagoTipoDocumento = new short[1] ;
      BC000T12_A245PagoNumero = new int[1] ;
      BC000T12_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      BC000T12_A253PagoMoneda = new short[1] ;
      BC000T12_A256PagoNubefactRequest = new String[] {""} ;
      BC000T12_A257PagoNubefactResponse = new String[] {""} ;
      BC000T12_A308PagoRequest = new String[] {""} ;
      BC000T12_A309PagoResponse = new String[] {""} ;
      BC000T12_A310PagoPasarelaId = new String[] {""} ;
      BC000T12_A311PagoStatusCode = new int[1] ;
      BC000T12_A338PagoEnlacePDF = new String[] {""} ;
      BC000T12_A339PagoEnlaceXML = new String[] {""} ;
      BC000T12_A246PagoEstadoR = new String[] {""} ;
      BC000T12_A34DisponibilidadId = new int[1] ;
      BC000T12_n34DisponibilidadId = new boolean[] {false} ;
      BC000T12_A19CitaId = new int[1] ;
      BC000T12_n19CitaId = new boolean[] {false} ;
      sMode38 = "" ;
      BC000T13_A47PagoId = new int[1] ;
      BC000T13_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000T13_A243PagoToken = new String[] {""} ;
      BC000T13_A247PagoTipoDocumentoCliente = new String[] {""} ;
      BC000T13_A248PagoClienteNroDocumento = new String[] {""} ;
      BC000T13_A249PagoClienteDenominacion = new String[] {""} ;
      BC000T13_A250PagoClienteDireccion = new String[] {""} ;
      BC000T13_A251PagoClienteEmail = new String[] {""} ;
      BC000T13_A244PagoTipoDocumento = new short[1] ;
      BC000T13_A245PagoNumero = new int[1] ;
      BC000T13_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      BC000T13_A253PagoMoneda = new short[1] ;
      BC000T13_A256PagoNubefactRequest = new String[] {""} ;
      BC000T13_A257PagoNubefactResponse = new String[] {""} ;
      BC000T13_A308PagoRequest = new String[] {""} ;
      BC000T13_A309PagoResponse = new String[] {""} ;
      BC000T13_A310PagoPasarelaId = new String[] {""} ;
      BC000T13_A311PagoStatusCode = new int[1] ;
      BC000T13_A338PagoEnlacePDF = new String[] {""} ;
      BC000T13_A339PagoEnlaceXML = new String[] {""} ;
      BC000T13_A246PagoEstadoR = new String[] {""} ;
      BC000T13_A34DisponibilidadId = new int[1] ;
      BC000T13_n34DisponibilidadId = new boolean[] {false} ;
      BC000T13_A19CitaId = new int[1] ;
      BC000T13_n19CitaId = new boolean[] {false} ;
      BC000T14_A47PagoId = new int[1] ;
      BC000T17_A21SGCitaDisponibilidadId = new int[1] ;
      BC000T17_A64CitaCode = new String[] {""} ;
      BC000T18_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000T18_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000T19_A21SGCitaDisponibilidadId = new int[1] ;
      BC000T19_A47PagoId = new int[1] ;
      BC000T19_A64CitaCode = new String[] {""} ;
      BC000T19_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000T19_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      BC000T19_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000T19_A243PagoToken = new String[] {""} ;
      BC000T19_A247PagoTipoDocumentoCliente = new String[] {""} ;
      BC000T19_A248PagoClienteNroDocumento = new String[] {""} ;
      BC000T19_A249PagoClienteDenominacion = new String[] {""} ;
      BC000T19_A250PagoClienteDireccion = new String[] {""} ;
      BC000T19_A251PagoClienteEmail = new String[] {""} ;
      BC000T19_A244PagoTipoDocumento = new short[1] ;
      BC000T19_A245PagoNumero = new int[1] ;
      BC000T19_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      BC000T19_A253PagoMoneda = new short[1] ;
      BC000T19_A256PagoNubefactRequest = new String[] {""} ;
      BC000T19_A257PagoNubefactResponse = new String[] {""} ;
      BC000T19_A308PagoRequest = new String[] {""} ;
      BC000T19_A309PagoResponse = new String[] {""} ;
      BC000T19_A310PagoPasarelaId = new String[] {""} ;
      BC000T19_A311PagoStatusCode = new int[1] ;
      BC000T19_A338PagoEnlacePDF = new String[] {""} ;
      BC000T19_A339PagoEnlaceXML = new String[] {""} ;
      BC000T19_A246PagoEstadoR = new String[] {""} ;
      BC000T19_A34DisponibilidadId = new int[1] ;
      BC000T19_n34DisponibilidadId = new boolean[] {false} ;
      BC000T19_A19CitaId = new int[1] ;
      BC000T19_n19CitaId = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pago_bc__default(),
         new Object[] {
             new Object[] {
            BC000T2_A47PagoId, BC000T2_A242PagoMonto, BC000T2_A243PagoToken, BC000T2_A247PagoTipoDocumentoCliente, BC000T2_A248PagoClienteNroDocumento, BC000T2_A249PagoClienteDenominacion, BC000T2_A250PagoClienteDireccion, BC000T2_A251PagoClienteEmail, BC000T2_A244PagoTipoDocumento, BC000T2_A245PagoNumero,
            BC000T2_A252PagoFechaEmision, BC000T2_A253PagoMoneda, BC000T2_A256PagoNubefactRequest, BC000T2_A257PagoNubefactResponse, BC000T2_A308PagoRequest, BC000T2_A309PagoResponse, BC000T2_A310PagoPasarelaId, BC000T2_A311PagoStatusCode, BC000T2_A338PagoEnlacePDF, BC000T2_A339PagoEnlaceXML,
            BC000T2_A246PagoEstadoR, BC000T2_A34DisponibilidadId, BC000T2_n34DisponibilidadId, BC000T2_A19CitaId, BC000T2_n19CitaId
            }
            , new Object[] {
            BC000T3_A47PagoId, BC000T3_A242PagoMonto, BC000T3_A243PagoToken, BC000T3_A247PagoTipoDocumentoCliente, BC000T3_A248PagoClienteNroDocumento, BC000T3_A249PagoClienteDenominacion, BC000T3_A250PagoClienteDireccion, BC000T3_A251PagoClienteEmail, BC000T3_A244PagoTipoDocumento, BC000T3_A245PagoNumero,
            BC000T3_A252PagoFechaEmision, BC000T3_A253PagoMoneda, BC000T3_A256PagoNubefactRequest, BC000T3_A257PagoNubefactResponse, BC000T3_A308PagoRequest, BC000T3_A309PagoResponse, BC000T3_A310PagoPasarelaId, BC000T3_A311PagoStatusCode, BC000T3_A338PagoEnlacePDF, BC000T3_A339PagoEnlaceXML,
            BC000T3_A246PagoEstadoR, BC000T3_A34DisponibilidadId, BC000T3_n34DisponibilidadId, BC000T3_A19CitaId, BC000T3_n19CitaId
            }
            , new Object[] {
            BC000T4_A34DisponibilidadId
            }
            , new Object[] {
            BC000T5_A21SGCitaDisponibilidadId, BC000T5_A64CitaCode
            }
            , new Object[] {
            BC000T6_A66SGCitaDisponibilidadFecha, BC000T6_n66SGCitaDisponibilidadFecha
            }
            , new Object[] {
            BC000T7_A21SGCitaDisponibilidadId, BC000T7_A47PagoId, BC000T7_A64CitaCode, BC000T7_A66SGCitaDisponibilidadFecha, BC000T7_n66SGCitaDisponibilidadFecha, BC000T7_A242PagoMonto, BC000T7_A243PagoToken, BC000T7_A247PagoTipoDocumentoCliente, BC000T7_A248PagoClienteNroDocumento, BC000T7_A249PagoClienteDenominacion,
            BC000T7_A250PagoClienteDireccion, BC000T7_A251PagoClienteEmail, BC000T7_A244PagoTipoDocumento, BC000T7_A245PagoNumero, BC000T7_A252PagoFechaEmision, BC000T7_A253PagoMoneda, BC000T7_A256PagoNubefactRequest, BC000T7_A257PagoNubefactResponse, BC000T7_A308PagoRequest, BC000T7_A309PagoResponse,
            BC000T7_A310PagoPasarelaId, BC000T7_A311PagoStatusCode, BC000T7_A338PagoEnlacePDF, BC000T7_A339PagoEnlaceXML, BC000T7_A246PagoEstadoR, BC000T7_A34DisponibilidadId, BC000T7_n34DisponibilidadId, BC000T7_A19CitaId, BC000T7_n19CitaId
            }
            , new Object[] {
            BC000T8_A21SGCitaDisponibilidadId, BC000T8_A64CitaCode
            }
            , new Object[] {
            BC000T9_A66SGCitaDisponibilidadFecha, BC000T9_n66SGCitaDisponibilidadFecha
            }
            , new Object[] {
            BC000T10_A34DisponibilidadId
            }
            , new Object[] {
            BC000T11_A47PagoId
            }
            , new Object[] {
            BC000T12_A47PagoId, BC000T12_A242PagoMonto, BC000T12_A243PagoToken, BC000T12_A247PagoTipoDocumentoCliente, BC000T12_A248PagoClienteNroDocumento, BC000T12_A249PagoClienteDenominacion, BC000T12_A250PagoClienteDireccion, BC000T12_A251PagoClienteEmail, BC000T12_A244PagoTipoDocumento, BC000T12_A245PagoNumero,
            BC000T12_A252PagoFechaEmision, BC000T12_A253PagoMoneda, BC000T12_A256PagoNubefactRequest, BC000T12_A257PagoNubefactResponse, BC000T12_A308PagoRequest, BC000T12_A309PagoResponse, BC000T12_A310PagoPasarelaId, BC000T12_A311PagoStatusCode, BC000T12_A338PagoEnlacePDF, BC000T12_A339PagoEnlaceXML,
            BC000T12_A246PagoEstadoR, BC000T12_A34DisponibilidadId, BC000T12_n34DisponibilidadId, BC000T12_A19CitaId, BC000T12_n19CitaId
            }
            , new Object[] {
            BC000T13_A47PagoId, BC000T13_A242PagoMonto, BC000T13_A243PagoToken, BC000T13_A247PagoTipoDocumentoCliente, BC000T13_A248PagoClienteNroDocumento, BC000T13_A249PagoClienteDenominacion, BC000T13_A250PagoClienteDireccion, BC000T13_A251PagoClienteEmail, BC000T13_A244PagoTipoDocumento, BC000T13_A245PagoNumero,
            BC000T13_A252PagoFechaEmision, BC000T13_A253PagoMoneda, BC000T13_A256PagoNubefactRequest, BC000T13_A257PagoNubefactResponse, BC000T13_A308PagoRequest, BC000T13_A309PagoResponse, BC000T13_A310PagoPasarelaId, BC000T13_A311PagoStatusCode, BC000T13_A338PagoEnlacePDF, BC000T13_A339PagoEnlaceXML,
            BC000T13_A246PagoEstadoR, BC000T13_A34DisponibilidadId, BC000T13_n34DisponibilidadId, BC000T13_A19CitaId, BC000T13_n19CitaId
            }
            , new Object[] {
            BC000T14_A47PagoId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000T17_A21SGCitaDisponibilidadId, BC000T17_A64CitaCode
            }
            , new Object[] {
            BC000T18_A66SGCitaDisponibilidadFecha, BC000T18_n66SGCitaDisponibilidadFecha
            }
            , new Object[] {
            BC000T19_A21SGCitaDisponibilidadId, BC000T19_A47PagoId, BC000T19_A64CitaCode, BC000T19_A66SGCitaDisponibilidadFecha, BC000T19_n66SGCitaDisponibilidadFecha, BC000T19_A242PagoMonto, BC000T19_A243PagoToken, BC000T19_A247PagoTipoDocumentoCliente, BC000T19_A248PagoClienteNroDocumento, BC000T19_A249PagoClienteDenominacion,
            BC000T19_A250PagoClienteDireccion, BC000T19_A251PagoClienteEmail, BC000T19_A244PagoTipoDocumento, BC000T19_A245PagoNumero, BC000T19_A252PagoFechaEmision, BC000T19_A253PagoMoneda, BC000T19_A256PagoNubefactRequest, BC000T19_A257PagoNubefactResponse, BC000T19_A308PagoRequest, BC000T19_A309PagoResponse,
            BC000T19_A310PagoPasarelaId, BC000T19_A311PagoStatusCode, BC000T19_A338PagoEnlacePDF, BC000T19_A339PagoEnlaceXML, BC000T19_A246PagoEstadoR, BC000T19_A34DisponibilidadId, BC000T19_n34DisponibilidadId, BC000T19_A19CitaId, BC000T19_n19CitaId
            }
         }
      );
      AV24Pgmname = "Pago_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120T2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z244PagoTipoDocumento ;
   private short A244PagoTipoDocumento ;
   private short Z253PagoMoneda ;
   private short A253PagoMoneda ;
   private short RcdFound38 ;
   private short nIsDirty_38 ;
   private int trnEnded ;
   private int Z47PagoId ;
   private int A47PagoId ;
   private int AV25GXV1 ;
   private int AV10Insert_CitaId ;
   private int AV21Insert_DisponibilidadId ;
   private int GX_JID ;
   private int Z245PagoNumero ;
   private int A245PagoNumero ;
   private int Z311PagoStatusCode ;
   private int A311PagoStatusCode ;
   private int Z34DisponibilidadId ;
   private int A34DisponibilidadId ;
   private int Z19CitaId ;
   private int A19CitaId ;
   private int Z21SGCitaDisponibilidadId ;
   private int A21SGCitaDisponibilidadId ;
   private java.math.BigDecimal Z242PagoMonto ;
   private java.math.BigDecimal A242PagoMonto ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV24Pgmname ;
   private String Z247PagoTipoDocumentoCliente ;
   private String A247PagoTipoDocumentoCliente ;
   private String Z246PagoEstadoR ;
   private String A246PagoEstadoR ;
   private String sMode38 ;
   private java.util.Date Z252PagoFechaEmision ;
   private java.util.Date A252PagoFechaEmision ;
   private java.util.Date Z66SGCitaDisponibilidadFecha ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private boolean returnInSub ;
   private boolean AV7IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n34DisponibilidadId ;
   private boolean n19CitaId ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z256PagoNubefactRequest ;
   private String A256PagoNubefactRequest ;
   private String Z257PagoNubefactResponse ;
   private String A257PagoNubefactResponse ;
   private String Z308PagoRequest ;
   private String A308PagoRequest ;
   private String Z309PagoResponse ;
   private String A309PagoResponse ;
   private String Z243PagoToken ;
   private String A243PagoToken ;
   private String Z248PagoClienteNroDocumento ;
   private String A248PagoClienteNroDocumento ;
   private String Z249PagoClienteDenominacion ;
   private String A249PagoClienteDenominacion ;
   private String Z250PagoClienteDireccion ;
   private String A250PagoClienteDireccion ;
   private String Z251PagoClienteEmail ;
   private String A251PagoClienteEmail ;
   private String Z310PagoPasarelaId ;
   private String A310PagoPasarelaId ;
   private String Z338PagoEnlacePDF ;
   private String A338PagoEnlacePDF ;
   private String Z339PagoEnlaceXML ;
   private String A339PagoEnlaceXML ;
   private String Z64CitaCode ;
   private String A64CitaCode ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV9WebSession ;
   private com.projectthani.SdtPago bcPago ;
   private IDataStoreProvider pr_default ;
   private int[] BC000T7_A21SGCitaDisponibilidadId ;
   private int[] BC000T7_A47PagoId ;
   private String[] BC000T7_A64CitaCode ;
   private java.util.Date[] BC000T7_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000T7_n66SGCitaDisponibilidadFecha ;
   private java.math.BigDecimal[] BC000T7_A242PagoMonto ;
   private String[] BC000T7_A243PagoToken ;
   private String[] BC000T7_A247PagoTipoDocumentoCliente ;
   private String[] BC000T7_A248PagoClienteNroDocumento ;
   private String[] BC000T7_A249PagoClienteDenominacion ;
   private String[] BC000T7_A250PagoClienteDireccion ;
   private String[] BC000T7_A251PagoClienteEmail ;
   private short[] BC000T7_A244PagoTipoDocumento ;
   private int[] BC000T7_A245PagoNumero ;
   private java.util.Date[] BC000T7_A252PagoFechaEmision ;
   private short[] BC000T7_A253PagoMoneda ;
   private String[] BC000T7_A256PagoNubefactRequest ;
   private String[] BC000T7_A257PagoNubefactResponse ;
   private String[] BC000T7_A308PagoRequest ;
   private String[] BC000T7_A309PagoResponse ;
   private String[] BC000T7_A310PagoPasarelaId ;
   private int[] BC000T7_A311PagoStatusCode ;
   private String[] BC000T7_A338PagoEnlacePDF ;
   private String[] BC000T7_A339PagoEnlaceXML ;
   private String[] BC000T7_A246PagoEstadoR ;
   private int[] BC000T7_A34DisponibilidadId ;
   private boolean[] BC000T7_n34DisponibilidadId ;
   private int[] BC000T7_A19CitaId ;
   private boolean[] BC000T7_n19CitaId ;
   private int[] BC000T8_A21SGCitaDisponibilidadId ;
   private String[] BC000T8_A64CitaCode ;
   private java.util.Date[] BC000T9_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000T9_n66SGCitaDisponibilidadFecha ;
   private int[] BC000T10_A34DisponibilidadId ;
   private boolean[] BC000T10_n34DisponibilidadId ;
   private int[] BC000T11_A47PagoId ;
   private int[] BC000T12_A47PagoId ;
   private java.math.BigDecimal[] BC000T12_A242PagoMonto ;
   private String[] BC000T12_A243PagoToken ;
   private String[] BC000T12_A247PagoTipoDocumentoCliente ;
   private String[] BC000T12_A248PagoClienteNroDocumento ;
   private String[] BC000T12_A249PagoClienteDenominacion ;
   private String[] BC000T12_A250PagoClienteDireccion ;
   private String[] BC000T12_A251PagoClienteEmail ;
   private short[] BC000T12_A244PagoTipoDocumento ;
   private int[] BC000T12_A245PagoNumero ;
   private java.util.Date[] BC000T12_A252PagoFechaEmision ;
   private short[] BC000T12_A253PagoMoneda ;
   private String[] BC000T12_A256PagoNubefactRequest ;
   private String[] BC000T12_A257PagoNubefactResponse ;
   private String[] BC000T12_A308PagoRequest ;
   private String[] BC000T12_A309PagoResponse ;
   private String[] BC000T12_A310PagoPasarelaId ;
   private int[] BC000T12_A311PagoStatusCode ;
   private String[] BC000T12_A338PagoEnlacePDF ;
   private String[] BC000T12_A339PagoEnlaceXML ;
   private String[] BC000T12_A246PagoEstadoR ;
   private int[] BC000T12_A34DisponibilidadId ;
   private boolean[] BC000T12_n34DisponibilidadId ;
   private int[] BC000T12_A19CitaId ;
   private boolean[] BC000T12_n19CitaId ;
   private int[] BC000T13_A47PagoId ;
   private java.math.BigDecimal[] BC000T13_A242PagoMonto ;
   private String[] BC000T13_A243PagoToken ;
   private String[] BC000T13_A247PagoTipoDocumentoCliente ;
   private String[] BC000T13_A248PagoClienteNroDocumento ;
   private String[] BC000T13_A249PagoClienteDenominacion ;
   private String[] BC000T13_A250PagoClienteDireccion ;
   private String[] BC000T13_A251PagoClienteEmail ;
   private short[] BC000T13_A244PagoTipoDocumento ;
   private int[] BC000T13_A245PagoNumero ;
   private java.util.Date[] BC000T13_A252PagoFechaEmision ;
   private short[] BC000T13_A253PagoMoneda ;
   private String[] BC000T13_A256PagoNubefactRequest ;
   private String[] BC000T13_A257PagoNubefactResponse ;
   private String[] BC000T13_A308PagoRequest ;
   private String[] BC000T13_A309PagoResponse ;
   private String[] BC000T13_A310PagoPasarelaId ;
   private int[] BC000T13_A311PagoStatusCode ;
   private String[] BC000T13_A338PagoEnlacePDF ;
   private String[] BC000T13_A339PagoEnlaceXML ;
   private String[] BC000T13_A246PagoEstadoR ;
   private int[] BC000T13_A34DisponibilidadId ;
   private boolean[] BC000T13_n34DisponibilidadId ;
   private int[] BC000T13_A19CitaId ;
   private boolean[] BC000T13_n19CitaId ;
   private int[] BC000T14_A47PagoId ;
   private int[] BC000T17_A21SGCitaDisponibilidadId ;
   private String[] BC000T17_A64CitaCode ;
   private java.util.Date[] BC000T18_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000T18_n66SGCitaDisponibilidadFecha ;
   private int[] BC000T19_A21SGCitaDisponibilidadId ;
   private int[] BC000T19_A47PagoId ;
   private String[] BC000T19_A64CitaCode ;
   private java.util.Date[] BC000T19_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000T19_n66SGCitaDisponibilidadFecha ;
   private java.math.BigDecimal[] BC000T19_A242PagoMonto ;
   private String[] BC000T19_A243PagoToken ;
   private String[] BC000T19_A247PagoTipoDocumentoCliente ;
   private String[] BC000T19_A248PagoClienteNroDocumento ;
   private String[] BC000T19_A249PagoClienteDenominacion ;
   private String[] BC000T19_A250PagoClienteDireccion ;
   private String[] BC000T19_A251PagoClienteEmail ;
   private short[] BC000T19_A244PagoTipoDocumento ;
   private int[] BC000T19_A245PagoNumero ;
   private java.util.Date[] BC000T19_A252PagoFechaEmision ;
   private short[] BC000T19_A253PagoMoneda ;
   private String[] BC000T19_A256PagoNubefactRequest ;
   private String[] BC000T19_A257PagoNubefactResponse ;
   private String[] BC000T19_A308PagoRequest ;
   private String[] BC000T19_A309PagoResponse ;
   private String[] BC000T19_A310PagoPasarelaId ;
   private int[] BC000T19_A311PagoStatusCode ;
   private String[] BC000T19_A338PagoEnlacePDF ;
   private String[] BC000T19_A339PagoEnlaceXML ;
   private String[] BC000T19_A246PagoEstadoR ;
   private int[] BC000T19_A34DisponibilidadId ;
   private boolean[] BC000T19_n34DisponibilidadId ;
   private int[] BC000T19_A19CitaId ;
   private boolean[] BC000T19_n19CitaId ;
   private int[] BC000T2_A47PagoId ;
   private java.math.BigDecimal[] BC000T2_A242PagoMonto ;
   private String[] BC000T2_A243PagoToken ;
   private String[] BC000T2_A247PagoTipoDocumentoCliente ;
   private String[] BC000T2_A248PagoClienteNroDocumento ;
   private String[] BC000T2_A249PagoClienteDenominacion ;
   private String[] BC000T2_A250PagoClienteDireccion ;
   private String[] BC000T2_A251PagoClienteEmail ;
   private short[] BC000T2_A244PagoTipoDocumento ;
   private int[] BC000T2_A245PagoNumero ;
   private java.util.Date[] BC000T2_A252PagoFechaEmision ;
   private short[] BC000T2_A253PagoMoneda ;
   private String[] BC000T2_A256PagoNubefactRequest ;
   private String[] BC000T2_A257PagoNubefactResponse ;
   private String[] BC000T2_A308PagoRequest ;
   private String[] BC000T2_A309PagoResponse ;
   private String[] BC000T2_A310PagoPasarelaId ;
   private int[] BC000T2_A311PagoStatusCode ;
   private String[] BC000T2_A338PagoEnlacePDF ;
   private String[] BC000T2_A339PagoEnlaceXML ;
   private String[] BC000T2_A246PagoEstadoR ;
   private int[] BC000T2_A34DisponibilidadId ;
   private int[] BC000T2_A19CitaId ;
   private int[] BC000T3_A47PagoId ;
   private java.math.BigDecimal[] BC000T3_A242PagoMonto ;
   private String[] BC000T3_A243PagoToken ;
   private String[] BC000T3_A247PagoTipoDocumentoCliente ;
   private String[] BC000T3_A248PagoClienteNroDocumento ;
   private String[] BC000T3_A249PagoClienteDenominacion ;
   private String[] BC000T3_A250PagoClienteDireccion ;
   private String[] BC000T3_A251PagoClienteEmail ;
   private short[] BC000T3_A244PagoTipoDocumento ;
   private int[] BC000T3_A245PagoNumero ;
   private java.util.Date[] BC000T3_A252PagoFechaEmision ;
   private short[] BC000T3_A253PagoMoneda ;
   private String[] BC000T3_A256PagoNubefactRequest ;
   private String[] BC000T3_A257PagoNubefactResponse ;
   private String[] BC000T3_A308PagoRequest ;
   private String[] BC000T3_A309PagoResponse ;
   private String[] BC000T3_A310PagoPasarelaId ;
   private int[] BC000T3_A311PagoStatusCode ;
   private String[] BC000T3_A338PagoEnlacePDF ;
   private String[] BC000T3_A339PagoEnlaceXML ;
   private String[] BC000T3_A246PagoEstadoR ;
   private int[] BC000T3_A34DisponibilidadId ;
   private int[] BC000T3_A19CitaId ;
   private int[] BC000T4_A34DisponibilidadId ;
   private int[] BC000T5_A21SGCitaDisponibilidadId ;
   private String[] BC000T5_A64CitaCode ;
   private java.util.Date[] BC000T6_A66SGCitaDisponibilidadFecha ;
   private boolean[] BC000T2_n34DisponibilidadId ;
   private boolean[] BC000T2_n19CitaId ;
   private boolean[] BC000T3_n34DisponibilidadId ;
   private boolean[] BC000T3_n19CitaId ;
   private boolean[] BC000T6_n66SGCitaDisponibilidadFecha ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV11TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class pago_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000T2", "SELECT [PagoId], [PagoMonto], [PagoToken], [PagoTipoDocumentoCliente], [PagoClienteNroDocumento], [PagoClienteDenominacion], [PagoClienteDireccion], [PagoClienteEmail], [PagoTipoDocumento], [PagoNumero], [PagoFechaEmision], [PagoMoneda], [PagoNubefactRequest], [PagoNubefactResponse], [PagoRequest], [PagoResponse], [PagoPasarelaId], [PagoStatusCode], [PagoEnlacePDF], [PagoEnlaceXML], [PagoEstadoR], [DisponibilidadId], [CitaId] FROM [Pago] WITH (UPDLOCK) WHERE [PagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T3", "SELECT [PagoId], [PagoMonto], [PagoToken], [PagoTipoDocumentoCliente], [PagoClienteNroDocumento], [PagoClienteDenominacion], [PagoClienteDireccion], [PagoClienteEmail], [PagoTipoDocumento], [PagoNumero], [PagoFechaEmision], [PagoMoneda], [PagoNubefactRequest], [PagoNubefactResponse], [PagoRequest], [PagoResponse], [PagoPasarelaId], [PagoStatusCode], [PagoEnlacePDF], [PagoEnlaceXML], [PagoEstadoR], [DisponibilidadId], [CitaId] FROM [Pago] WHERE [PagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T4", "SELECT [DisponibilidadId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T5", "SELECT [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, [CitaCode] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T6", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T7", "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, TM1.[PagoId], T2.[CitaCode], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, TM1.[PagoMonto], TM1.[PagoToken], TM1.[PagoTipoDocumentoCliente], TM1.[PagoClienteNroDocumento], TM1.[PagoClienteDenominacion], TM1.[PagoClienteDireccion], TM1.[PagoClienteEmail], TM1.[PagoTipoDocumento], TM1.[PagoNumero], TM1.[PagoFechaEmision], TM1.[PagoMoneda], TM1.[PagoNubefactRequest], TM1.[PagoNubefactResponse], TM1.[PagoRequest], TM1.[PagoResponse], TM1.[PagoPasarelaId], TM1.[PagoStatusCode], TM1.[PagoEnlacePDF], TM1.[PagoEnlaceXML], TM1.[PagoEstadoR], TM1.[DisponibilidadId], TM1.[CitaId] FROM (([Pago] TM1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = TM1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) WHERE TM1.[PagoId] = ? ORDER BY TM1.[PagoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T8", "SELECT [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, [CitaCode] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T9", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T10", "SELECT [DisponibilidadId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T11", "SELECT [PagoId] FROM [Pago] WHERE [PagoId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T12", "SELECT [PagoId], [PagoMonto], [PagoToken], [PagoTipoDocumentoCliente], [PagoClienteNroDocumento], [PagoClienteDenominacion], [PagoClienteDireccion], [PagoClienteEmail], [PagoTipoDocumento], [PagoNumero], [PagoFechaEmision], [PagoMoneda], [PagoNubefactRequest], [PagoNubefactResponse], [PagoRequest], [PagoResponse], [PagoPasarelaId], [PagoStatusCode], [PagoEnlacePDF], [PagoEnlaceXML], [PagoEstadoR], [DisponibilidadId], [CitaId] FROM [Pago] WHERE [PagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T13", "SELECT [PagoId], [PagoMonto], [PagoToken], [PagoTipoDocumentoCliente], [PagoClienteNroDocumento], [PagoClienteDenominacion], [PagoClienteDireccion], [PagoClienteEmail], [PagoTipoDocumento], [PagoNumero], [PagoFechaEmision], [PagoMoneda], [PagoNubefactRequest], [PagoNubefactResponse], [PagoRequest], [PagoResponse], [PagoPasarelaId], [PagoStatusCode], [PagoEnlacePDF], [PagoEnlaceXML], [PagoEstadoR], [DisponibilidadId], [CitaId] FROM [Pago] WITH (UPDLOCK) WHERE [PagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T14", "INSERT INTO [Pago]([PagoMonto], [PagoToken], [PagoTipoDocumentoCliente], [PagoClienteNroDocumento], [PagoClienteDenominacion], [PagoClienteDireccion], [PagoClienteEmail], [PagoTipoDocumento], [PagoNumero], [PagoFechaEmision], [PagoMoneda], [PagoNubefactRequest], [PagoNubefactResponse], [PagoRequest], [PagoResponse], [PagoPasarelaId], [PagoStatusCode], [PagoEnlacePDF], [PagoEnlaceXML], [PagoEstadoR], [DisponibilidadId], [CitaId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000T15", "UPDATE [Pago] SET [PagoMonto]=?, [PagoToken]=?, [PagoTipoDocumentoCliente]=?, [PagoClienteNroDocumento]=?, [PagoClienteDenominacion]=?, [PagoClienteDireccion]=?, [PagoClienteEmail]=?, [PagoTipoDocumento]=?, [PagoNumero]=?, [PagoFechaEmision]=?, [PagoMoneda]=?, [PagoNubefactRequest]=?, [PagoNubefactResponse]=?, [PagoRequest]=?, [PagoResponse]=?, [PagoPasarelaId]=?, [PagoStatusCode]=?, [PagoEnlacePDF]=?, [PagoEnlaceXML]=?, [PagoEstadoR]=?, [DisponibilidadId]=?, [CitaId]=?  WHERE [PagoId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000T16", "DELETE FROM [Pago]  WHERE [PagoId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000T17", "SELECT [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, [CitaCode] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T18", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T19", "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, TM1.[PagoId], T2.[CitaCode], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, TM1.[PagoMonto], TM1.[PagoToken], TM1.[PagoTipoDocumentoCliente], TM1.[PagoClienteNroDocumento], TM1.[PagoClienteDenominacion], TM1.[PagoClienteDireccion], TM1.[PagoClienteEmail], TM1.[PagoTipoDocumento], TM1.[PagoNumero], TM1.[PagoFechaEmision], TM1.[PagoMoneda], TM1.[PagoNubefactRequest], TM1.[PagoNubefactResponse], TM1.[PagoRequest], TM1.[PagoResponse], TM1.[PagoPasarelaId], TM1.[PagoStatusCode], TM1.[PagoEnlacePDF], TM1.[PagoEnlaceXML], TM1.[PagoEstadoR], TM1.[DisponibilidadId], TM1.[CitaId] FROM (([Pago] TM1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = TM1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) WHERE TM1.[PagoId] = ? ORDER BY TM1.[PagoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((int[]) buf[17])[0] = rslt.getInt(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((int[]) buf[23])[0] = rslt.getInt(23);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((int[]) buf[17])[0] = rslt.getInt(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((int[]) buf[23])[0] = rslt.getInt(23);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((int[]) buf[13])[0] = rslt.getInt(13);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(14);
               ((short[]) buf[15])[0] = rslt.getShort(15);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(17);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(18);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(19);
               ((String[]) buf[20])[0] = rslt.getVarchar(20);
               ((int[]) buf[21])[0] = rslt.getInt(21);
               ((String[]) buf[22])[0] = rslt.getVarchar(22);
               ((String[]) buf[23])[0] = rslt.getVarchar(23);
               ((String[]) buf[24])[0] = rslt.getString(24, 1);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((int[]) buf[27])[0] = rslt.getInt(26);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((int[]) buf[17])[0] = rslt.getInt(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((int[]) buf[23])[0] = rslt.getInt(23);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((int[]) buf[17])[0] = rslt.getInt(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((int[]) buf[23])[0] = rslt.getInt(23);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 16 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((int[]) buf[13])[0] = rslt.getInt(13);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(14);
               ((short[]) buf[15])[0] = rslt.getShort(15);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(17);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(18);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(19);
               ((String[]) buf[20])[0] = rslt.getVarchar(20);
               ((int[]) buf[21])[0] = rslt.getInt(21);
               ((String[]) buf[22])[0] = rslt.getVarchar(22);
               ((String[]) buf[23])[0] = rslt.getVarchar(23);
               ((String[]) buf[24])[0] = rslt.getString(24, 1);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((int[]) buf[27])[0] = rslt.getInt(26);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 12 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               stmt.setVarchar(7, (String)parms[6], 100, false);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setNLongVarchar(12, (String)parms[11], false);
               stmt.setNLongVarchar(13, (String)parms[12], false);
               stmt.setNLongVarchar(14, (String)parms[13], false);
               stmt.setNLongVarchar(15, (String)parms[14], false);
               stmt.setVarchar(16, (String)parms[15], 100, false);
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setVarchar(18, (String)parms[17], 1000, false);
               stmt.setVarchar(19, (String)parms[18], 1000, false);
               stmt.setString(20, (String)parms[19], 1);
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(21, ((Number) parms[21]).intValue());
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(22, ((Number) parms[23]).intValue());
               }
               return;
            case 13 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               stmt.setVarchar(7, (String)parms[6], 100, false);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setNLongVarchar(12, (String)parms[11], false);
               stmt.setNLongVarchar(13, (String)parms[12], false);
               stmt.setNLongVarchar(14, (String)parms[13], false);
               stmt.setNLongVarchar(15, (String)parms[14], false);
               stmt.setVarchar(16, (String)parms[15], 100, false);
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setVarchar(18, (String)parms[17], 1000, false);
               stmt.setVarchar(19, (String)parms[18], 1000, false);
               stmt.setString(20, (String)parms[19], 1);
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(21, ((Number) parms[21]).intValue());
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(22, ((Number) parms[23]).intValue());
               }
               stmt.setInt(23, ((Number) parms[24]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

