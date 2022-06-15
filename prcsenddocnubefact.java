package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcsenddocnubefact extends GXProcedure
{
   public prcsenddocnubefact( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcsenddocnubefact.class ), "" );
   }

   public prcsenddocnubefact( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      prcsenddocnubefact.this.AV17PagoId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV26tokenNubefact ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "NubefactToken", GXv_char2) ;
      prcsenddocnubefact.this.GXt_char1 = GXv_char2[0] ;
      AV26tokenNubefact = GXt_char1 ;
      GXt_char1 = AV25server ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.prcgetconfigvalue(remoteHandle, context).execute( "NubefactServer", GXv_char2) ;
      prcsenddocnubefact.this.GXt_char1 = GXv_char2[0] ;
      AV25server = GXt_char1 ;
      AV13httpclient.addHeader("Content-Type", "application/json");
      AV13httpclient.addHeader("Authorization", AV26tokenNubefact);
      AV13httpclient.addHeader("Accept-Encoding", "gzip, deflate, br");
      AV13httpclient.addHeader("Accept", "application/json");
      AV13httpclient.setHost( AV25server );
      AV13httpclient.setSecure( (byte)(1) );
      AV16Pago.Load(AV17PagoId);
      AV9Cita.Load(AV16Pago.getgxTv_SdtPago_Citaid());
      AV11Disponibilidad.Load(AV9Cita.getgxTv_SdtCita_Sgcitadisponibilidadid());
      AV12Especialidad.Load(AV11Disponibilidad.getgxTv_SdtDisponibilidad_Especialidadid());
      if ( AV16Pago.getgxTv_SdtPago_Pagotipodocumento() == 1 )
      {
         /* Using cursor P007C2 */
         pr_default.execute(0);
         while ( (pr_default.getStatus(0) != 101) )
         {
            A129ConfigEstadoR = P007C2_A129ConfigEstadoR[0] ;
            A127ConfigKey = P007C2_A127ConfigKey[0] ;
            A128ConfigValue = P007C2_A128ConfigValue[0] ;
            A33ConfigId = P007C2_A33ConfigId[0] ;
            AV24Serie = A128ConfigValue ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         if ( AV16Pago.getgxTv_SdtPago_Pagotipodocumento() == 2 )
         {
            /* Using cursor P007C3 */
            pr_default.execute(1);
            while ( (pr_default.getStatus(1) != 101) )
            {
               A129ConfigEstadoR = P007C3_A129ConfigEstadoR[0] ;
               A127ConfigKey = P007C3_A127ConfigKey[0] ;
               A128ConfigValue = P007C3_A128ConfigValue[0] ;
               A33ConfigId = P007C3_A33ConfigId[0] ;
               AV24Serie = A128ConfigValue ;
               pr_default.readNext(1);
            }
            pr_default.close(1);
         }
      }
      /* Using cursor P007C4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A129ConfigEstadoR = P007C4_A129ConfigEstadoR[0] ;
         A127ConfigKey = P007C4_A127ConfigKey[0] ;
         A128ConfigValue = P007C4_A128ConfigValue[0] ;
         A33ConfigId = P007C4_A33ConfigId[0] ;
         AV18porcentaje_de_igv = CommonUtil.decimalVal( A128ConfigValue, ".") ;
         pr_default.readNext(2);
      }
      pr_default.close(2);
      AV27total_gravada = GXutil.roundDecimal( AV16Pago.getgxTv_SdtPago_Pagomonto().divide((DecimalUtil.doubleToDec(1).add(AV18porcentaje_de_igv.multiply(DecimalUtil.stringToDec("1.00")).divide(DecimalUtil.doubleToDec(100), 18, java.math.RoundingMode.DOWN))), 18, java.math.RoundingMode.DOWN), 3) ;
      AV28total_igv = AV16Pago.getgxTv_SdtPago_Pagomonto().subtract(AV27total_gravada) ;
      GXt_int3 = AV15NumeroComprobante ;
      GXv_int4[0] = GXt_int3 ;
      new com.projectthani.prcgetnextnro(remoteHandle, context).execute( AV16Pago.getgxTv_SdtPago_Pagotipodocumento(), GXv_int4) ;
      prcsenddocnubefact.this.GXt_int3 = GXv_int4[0] ;
      AV15NumeroComprobante = GXt_int3 ;
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Operacion( "generar_comprobante" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Tipo_de_comprobante( DecimalUtil.doubleToDec(AV16Pago.getgxTv_SdtPago_Pagotipodocumento()) );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Serie( AV24Serie );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Numero( DecimalUtil.doubleToDec(AV15NumeroComprobante) );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Sunat_transaction( DecimalUtil.doubleToDec(1) );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento( CommonUtil.decimalVal( AV16Pago.getgxTv_SdtPago_Pagotipodocumentocliente(), ".") );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento( AV16Pago.getgxTv_SdtPago_Pagoclientenrodocumento() );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Cliente_denominacion( AV16Pago.getgxTv_SdtPago_Pagoclientedenominacion() );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Cliente_direccion( AV16Pago.getgxTv_SdtPago_Pagoclientedireccion() );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Cliente_email( AV16Pago.getgxTv_SdtPago_Pagoclienteemail() );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Cliente_email_1( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Cliente_email_2( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Fecha_de_emision( GXutil.padl( GXutil.str( GXutil.day( AV16Pago.getgxTv_SdtPago_Pagofechaemision()), 10, 0), (short)(2), "0")+"-"+GXutil.padl( GXutil.str( GXutil.month( AV16Pago.getgxTv_SdtPago_Pagofechaemision()), 10, 0), (short)(2), "0")+"-"+GXutil.padl( GXutil.str( GXutil.year( AV16Pago.getgxTv_SdtPago_Pagofechaemision()), 10, 0), (short)(4), "0") );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Moneda( DecimalUtil.doubleToDec(AV16Pago.getgxTv_SdtPago_Pagomoneda()) );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Tipo_de_cambio( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Porcentaje_de_igv( AV18porcentaje_de_igv );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Descuento_global( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_descuento( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_anticipo( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_inafecta( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_exonerada( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_gravada( AV27total_gravada );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_igv( AV28total_igv );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_gratuita( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_otros_cargos( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total( AV16Pago.getgxTv_SdtPago_Pagomonto() );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Percepcion_tipo( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Percepcion_base_imponible( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_percepcion( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_incluido_percepcion( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Detraccion( false );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Observaciones( "Especialidad: "+GXutil.trim( GXutil.upper( AV12Especialidad.getgxTv_SdtEspecialidad_Especialidadnombre()))+" - Fecha de cita: "+localUtil.dtoc( AV11Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadfecha(), 3, "/") );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat( true );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente( true );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Condiciones_de_pago( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Medio_de_pago( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Placa_vehiculo( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Orden_compra_servicio( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Formato_de_pdf( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Generado_por_contingencia( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Bienes_region_selva( "" );
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Servicios_region_selva( "" );
      AV22SDTRequestNubefactItemC.clear();
      AV21SDTRequestNubefactItem = (com.projectthani.SdtSDTRequestNubefact_itemsItem)new com.projectthani.SdtSDTRequestNubefact_itemsItem(remoteHandle, context);
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida( "NIU" );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Codigo( "001" );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat( "85101600" );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Descripcion( "RESERVA DE TELEORIENTACION MEDICA EN EL SERVICIO DE LA PLATAFORMA DIGITAL THANI." );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Cantidad( DecimalUtil.doubleToDec(1) );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario( GXutil.roundDecimal( AV27total_gravada, 3) );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario( AV16Pago.getgxTv_SdtPago_Pagomonto() );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Descuento( "" );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Subtotal( GXutil.roundDecimal( AV27total_gravada, 3) );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv( DecimalUtil.doubleToDec(1) );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Igv( GXutil.roundDecimal( (AV27total_gravada).multiply((AV18porcentaje_de_igv.multiply(DecimalUtil.stringToDec("1.00")).divide(DecimalUtil.doubleToDec(100), 18, java.math.RoundingMode.DOWN))), 3) );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Total( GXutil.roundDecimal( (AV27total_gravada).multiply((DecimalUtil.doubleToDec(1).add(AV18porcentaje_de_igv.multiply(DecimalUtil.stringToDec("1.00")).divide(DecimalUtil.doubleToDec(100), 18, java.math.RoundingMode.DOWN)))), 3) );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion( false );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie( "" );
      AV21SDTRequestNubefactItem.setgxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero( "" );
      AV22SDTRequestNubefactItemC.add(AV21SDTRequestNubefactItem, 0);
      AV20SDTRequestNubefact.setgxTv_SdtSDTRequestNubefact_Items( AV22SDTRequestNubefactItemC );
      AV8body = AV20SDTRequestNubefact.toJSonString(false, true) ;
      AV8body = GXutil.strReplace( GXutil.strReplace( GXutil.strReplace( GXutil.strReplace( GXutil.strReplace( AV8body, "Á", "A"), "É", "E"), "Í", "I"), "Ó", "O"), "Ú", "U") ;
      AV8body = GXutil.strReplace( GXutil.strReplace( GXutil.strReplace( GXutil.strReplace( GXutil.strReplace( AV8body, "á", "a"), "é", "E"), "í", "i"), "ó", "o"), "ú", "u") ;
      AV8body = GXutil.strReplace( GXutil.strReplace( AV8body, "Ñ", "N"), "ñ", "n") ;
      AV13httpclient.addString(AV8body);
      AV13httpclient.execute("POST", new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "NubefactEndpoint"));
      AV16Pago.setgxTv_SdtPago_Pagonubefactrequest( AV8body );
      if ( AV13httpclient.getStatusCode() == 200 )
      {
         AV19result = AV13httpclient.getString() ;
         AV23SDTResponseNubefact.fromJSonString(AV19result, null);
         AV16Pago.setgxTv_SdtPago_Pagoenlacepdf( AV23SDTResponseNubefact.getgxTv_SdtSDTResponseNubefact_Enlace_del_pdf() );
         AV16Pago.setgxTv_SdtPago_Pagoenlacexml( AV23SDTResponseNubefact.getgxTv_SdtSDTResponseNubefact_Enlace_del_xml() );
         AV14Mensaje = "Ok" ;
         AV16Pago.setgxTv_SdtPago_Pagonumero( AV15NumeroComprobante );
      }
      else
      {
         AV19result = AV13httpclient.getString() ;
      }
      AV16Pago.setgxTv_SdtPago_Pagonubefactresponse( AV19result );
      AV16Pago.Save();
      if ( AV16Pago.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "prcsenddocnubefact");
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      AV13httpclient.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26tokenNubefact = "" ;
      AV25server = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV13httpclient = new com.genexus.internet.HttpClient();
      AV16Pago = new com.projectthani.SdtPago(remoteHandle);
      AV9Cita = new com.projectthani.SdtCita(remoteHandle);
      AV11Disponibilidad = new com.projectthani.SdtDisponibilidad(remoteHandle);
      AV12Especialidad = new com.projectthani.SdtEspecialidad(remoteHandle);
      scmdbuf = "" ;
      P007C2_A129ConfigEstadoR = new String[] {""} ;
      P007C2_A127ConfigKey = new String[] {""} ;
      P007C2_A128ConfigValue = new String[] {""} ;
      P007C2_A33ConfigId = new short[1] ;
      A129ConfigEstadoR = "" ;
      A127ConfigKey = "" ;
      A128ConfigValue = "" ;
      AV24Serie = "" ;
      P007C3_A129ConfigEstadoR = new String[] {""} ;
      P007C3_A127ConfigKey = new String[] {""} ;
      P007C3_A128ConfigValue = new String[] {""} ;
      P007C3_A33ConfigId = new short[1] ;
      P007C4_A129ConfigEstadoR = new String[] {""} ;
      P007C4_A127ConfigKey = new String[] {""} ;
      P007C4_A128ConfigValue = new String[] {""} ;
      P007C4_A33ConfigId = new short[1] ;
      AV18porcentaje_de_igv = DecimalUtil.ZERO ;
      AV27total_gravada = DecimalUtil.ZERO ;
      AV28total_igv = DecimalUtil.ZERO ;
      GXv_int4 = new int[1] ;
      AV20SDTRequestNubefact = new com.projectthani.SdtSDTRequestNubefact(remoteHandle, context);
      AV22SDTRequestNubefactItemC = new GXBaseCollection<com.projectthani.SdtSDTRequestNubefact_itemsItem>(com.projectthani.SdtSDTRequestNubefact_itemsItem.class, "SDTRequestNubefact.itemsItem", "ProjectThani", remoteHandle);
      AV21SDTRequestNubefactItem = new com.projectthani.SdtSDTRequestNubefact_itemsItem(remoteHandle, context);
      AV8body = "" ;
      AV19result = "" ;
      AV23SDTResponseNubefact = new com.projectthani.SdtSDTResponseNubefact(remoteHandle, context);
      AV14Mensaje = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcsenddocnubefact__default(),
         new Object[] {
             new Object[] {
            P007C2_A129ConfigEstadoR, P007C2_A127ConfigKey, P007C2_A128ConfigValue, P007C2_A33ConfigId
            }
            , new Object[] {
            P007C3_A129ConfigEstadoR, P007C3_A127ConfigKey, P007C3_A128ConfigValue, P007C3_A33ConfigId
            }
            , new Object[] {
            P007C4_A129ConfigEstadoR, P007C4_A127ConfigKey, P007C4_A128ConfigValue, P007C4_A33ConfigId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A33ConfigId ;
   private short Gx_err ;
   private int AV17PagoId ;
   private int AV15NumeroComprobante ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private java.math.BigDecimal AV18porcentaje_de_igv ;
   private java.math.BigDecimal AV27total_gravada ;
   private java.math.BigDecimal AV28total_igv ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private String A129ConfigEstadoR ;
   private String AV8body ;
   private String AV19result ;
   private String AV26tokenNubefact ;
   private String AV25server ;
   private String A127ConfigKey ;
   private String A128ConfigValue ;
   private String AV24Serie ;
   private String AV14Mensaje ;
   private com.projectthani.SdtSDTRequestNubefact AV20SDTRequestNubefact ;
   private IDataStoreProvider pr_default ;
   private String[] P007C2_A129ConfigEstadoR ;
   private String[] P007C2_A127ConfigKey ;
   private String[] P007C2_A128ConfigValue ;
   private short[] P007C2_A33ConfigId ;
   private String[] P007C3_A129ConfigEstadoR ;
   private String[] P007C3_A127ConfigKey ;
   private String[] P007C3_A128ConfigValue ;
   private short[] P007C3_A33ConfigId ;
   private String[] P007C4_A129ConfigEstadoR ;
   private String[] P007C4_A127ConfigKey ;
   private String[] P007C4_A128ConfigValue ;
   private short[] P007C4_A33ConfigId ;
   private com.genexus.internet.HttpClient AV13httpclient ;
   private GXBaseCollection<com.projectthani.SdtSDTRequestNubefact_itemsItem> AV22SDTRequestNubefactItemC ;
   private com.projectthani.SdtCita AV9Cita ;
   private com.projectthani.SdtDisponibilidad AV11Disponibilidad ;
   private com.projectthani.SdtEspecialidad AV12Especialidad ;
   private com.projectthani.SdtPago AV16Pago ;
   private com.projectthani.SdtSDTRequestNubefact_itemsItem AV21SDTRequestNubefactItem ;
   private com.projectthani.SdtSDTResponseNubefact AV23SDTResponseNubefact ;
}

final  class prcsenddocnubefact__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007C2", "SELECT [ConfigEstadoR], [ConfigKey], [ConfigValue], [ConfigId] FROM [Config] WHERE ([ConfigKey] = 'SerieFactura') AND ([ConfigEstadoR] = 'A') ORDER BY [ConfigId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007C3", "SELECT [ConfigEstadoR], [ConfigKey], [ConfigValue], [ConfigId] FROM [Config] WHERE ([ConfigKey] = 'SerieBoleta') AND ([ConfigEstadoR] = 'A') ORDER BY [ConfigId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007C4", "SELECT [ConfigEstadoR], [ConfigKey], [ConfigValue], [ConfigId] FROM [Config] WHERE ([ConfigKey] = 'PorcentajeIGV') AND ([ConfigEstadoR] = 'A') ORDER BY [ConfigId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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

