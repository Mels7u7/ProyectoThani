package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTRequestNubefact implements Cloneable, java.io.Serializable
{
   public StructSdtSDTRequestNubefact( )
   {
      this( -1, new ModelContext( StructSdtSDTRequestNubefact.class ));
   }

   public StructSdtSDTRequestNubefact( int remoteHandle ,
                                       ModelContext context )
   {
      gxTv_SdtSDTRequestNubefact_Operacion = "" ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_Serie = "" ;
      gxTv_SdtSDTRequestNubefact_Numero = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_Sunat_transaction = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento = "" ;
      gxTv_SdtSDTRequestNubefact_Cliente_denominacion = "" ;
      gxTv_SdtSDTRequestNubefact_Cliente_direccion = "" ;
      gxTv_SdtSDTRequestNubefact_Cliente_email = "" ;
      gxTv_SdtSDTRequestNubefact_Cliente_email_1 = "" ;
      gxTv_SdtSDTRequestNubefact_Cliente_email_2 = "" ;
      gxTv_SdtSDTRequestNubefact_Fecha_de_emision = "" ;
      gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento = "" ;
      gxTv_SdtSDTRequestNubefact_Moneda = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_cambio = "" ;
      gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_Descuento_global = "" ;
      gxTv_SdtSDTRequestNubefact_Total_descuento = "" ;
      gxTv_SdtSDTRequestNubefact_Total_anticipo = "" ;
      gxTv_SdtSDTRequestNubefact_Total_gravada = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_Total_inafecta = "" ;
      gxTv_SdtSDTRequestNubefact_Total_exonerada = "" ;
      gxTv_SdtSDTRequestNubefact_Total_igv = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_Total_gratuita = "" ;
      gxTv_SdtSDTRequestNubefact_Total_otros_cargos = "" ;
      gxTv_SdtSDTRequestNubefact_Total = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_Percepcion_tipo = "" ;
      gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible = "" ;
      gxTv_SdtSDTRequestNubefact_Total_percepcion = "" ;
      gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion = "" ;
      gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas = "" ;
      gxTv_SdtSDTRequestNubefact_Observaciones = "" ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo = "" ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie = "" ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero = "" ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito = "" ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito = "" ;
      gxTv_SdtSDTRequestNubefact_Condiciones_de_pago = "" ;
      gxTv_SdtSDTRequestNubefact_Medio_de_pago = "" ;
      gxTv_SdtSDTRequestNubefact_Placa_vehiculo = "" ;
      gxTv_SdtSDTRequestNubefact_Orden_compra_servicio = "" ;
      gxTv_SdtSDTRequestNubefact_Formato_de_pdf = "" ;
      gxTv_SdtSDTRequestNubefact_Generado_por_contingencia = "" ;
      gxTv_SdtSDTRequestNubefact_Bienes_region_selva = "" ;
      gxTv_SdtSDTRequestNubefact_Servicios_region_selva = "" ;
      gxTv_SdtSDTRequestNubefact_Items_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getOperacion( )
   {
      return gxTv_SdtSDTRequestNubefact_Operacion ;
   }

   public void setOperacion( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Operacion = value ;
   }

   public java.math.BigDecimal getTipo_de_comprobante( )
   {
      return gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante ;
   }

   public void setTipo_de_comprobante( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante = value ;
   }

   public String getSerie( )
   {
      return gxTv_SdtSDTRequestNubefact_Serie ;
   }

   public void setSerie( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Serie = value ;
   }

   public java.math.BigDecimal getNumero( )
   {
      return gxTv_SdtSDTRequestNubefact_Numero ;
   }

   public void setNumero( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Numero = value ;
   }

   public java.math.BigDecimal getSunat_transaction( )
   {
      return gxTv_SdtSDTRequestNubefact_Sunat_transaction ;
   }

   public void setSunat_transaction( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Sunat_transaction = value ;
   }

   public java.math.BigDecimal getCliente_tipo_de_documento( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento ;
   }

   public void setCliente_tipo_de_documento( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento = value ;
   }

   public String getCliente_numero_de_documento( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento ;
   }

   public void setCliente_numero_de_documento( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento = value ;
   }

   public String getCliente_denominacion( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_denominacion ;
   }

   public void setCliente_denominacion( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_denominacion = value ;
   }

   public String getCliente_direccion( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_direccion ;
   }

   public void setCliente_direccion( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_direccion = value ;
   }

   public String getCliente_email( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_email ;
   }

   public void setCliente_email( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_email = value ;
   }

   public String getCliente_email_1( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_email_1 ;
   }

   public void setCliente_email_1( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_email_1 = value ;
   }

   public String getCliente_email_2( )
   {
      return gxTv_SdtSDTRequestNubefact_Cliente_email_2 ;
   }

   public void setCliente_email_2( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Cliente_email_2 = value ;
   }

   public String getFecha_de_emision( )
   {
      return gxTv_SdtSDTRequestNubefact_Fecha_de_emision ;
   }

   public void setFecha_de_emision( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Fecha_de_emision = value ;
   }

   public String getFecha_de_vencimiento( )
   {
      return gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento ;
   }

   public void setFecha_de_vencimiento( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento = value ;
   }

   public java.math.BigDecimal getMoneda( )
   {
      return gxTv_SdtSDTRequestNubefact_Moneda ;
   }

   public void setMoneda( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Moneda = value ;
   }

   public String getTipo_de_cambio( )
   {
      return gxTv_SdtSDTRequestNubefact_Tipo_de_cambio ;
   }

   public void setTipo_de_cambio( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_cambio = value ;
   }

   public java.math.BigDecimal getPorcentaje_de_igv( )
   {
      return gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv ;
   }

   public void setPorcentaje_de_igv( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv = value ;
   }

   public String getDescuento_global( )
   {
      return gxTv_SdtSDTRequestNubefact_Descuento_global ;
   }

   public void setDescuento_global( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Descuento_global = value ;
   }

   public String getTotal_descuento( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_descuento ;
   }

   public void setTotal_descuento( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_descuento = value ;
   }

   public String getTotal_anticipo( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_anticipo ;
   }

   public void setTotal_anticipo( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_anticipo = value ;
   }

   public java.math.BigDecimal getTotal_gravada( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_gravada ;
   }

   public void setTotal_gravada( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_gravada = value ;
   }

   public String getTotal_inafecta( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_inafecta ;
   }

   public void setTotal_inafecta( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_inafecta = value ;
   }

   public String getTotal_exonerada( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_exonerada ;
   }

   public void setTotal_exonerada( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_exonerada = value ;
   }

   public java.math.BigDecimal getTotal_igv( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_igv ;
   }

   public void setTotal_igv( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_igv = value ;
   }

   public String getTotal_gratuita( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_gratuita ;
   }

   public void setTotal_gratuita( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_gratuita = value ;
   }

   public String getTotal_otros_cargos( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_otros_cargos ;
   }

   public void setTotal_otros_cargos( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_otros_cargos = value ;
   }

   public java.math.BigDecimal getTotal( )
   {
      return gxTv_SdtSDTRequestNubefact_Total ;
   }

   public void setTotal( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total = value ;
   }

   public String getPercepcion_tipo( )
   {
      return gxTv_SdtSDTRequestNubefact_Percepcion_tipo ;
   }

   public void setPercepcion_tipo( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Percepcion_tipo = value ;
   }

   public String getPercepcion_base_imponible( )
   {
      return gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible ;
   }

   public void setPercepcion_base_imponible( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible = value ;
   }

   public String getTotal_percepcion( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_percepcion ;
   }

   public void setTotal_percepcion( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_percepcion = value ;
   }

   public String getTotal_incluido_percepcion( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion ;
   }

   public void setTotal_incluido_percepcion( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion = value ;
   }

   public String getTotal_impuestos_bolsas( )
   {
      return gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas ;
   }

   public void setTotal_impuestos_bolsas( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas = value ;
   }

   public boolean getDetraccion( )
   {
      return gxTv_SdtSDTRequestNubefact_Detraccion ;
   }

   public void setDetraccion( boolean value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Detraccion = value ;
   }

   public String getObservaciones( )
   {
      return gxTv_SdtSDTRequestNubefact_Observaciones ;
   }

   public void setObservaciones( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Observaciones = value ;
   }

   public String getDocumento_que_se_modifica_tipo( )
   {
      return gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo ;
   }

   public void setDocumento_que_se_modifica_tipo( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo = value ;
   }

   public String getDocumento_que_se_modifica_serie( )
   {
      return gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie ;
   }

   public void setDocumento_que_se_modifica_serie( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie = value ;
   }

   public String getDocumento_que_se_modifica_numero( )
   {
      return gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero ;
   }

   public void setDocumento_que_se_modifica_numero( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero = value ;
   }

   public String getTipo_de_nota_de_credito( )
   {
      return gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito ;
   }

   public void setTipo_de_nota_de_credito( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito = value ;
   }

   public String getTipo_de_nota_de_debito( )
   {
      return gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito ;
   }

   public void setTipo_de_nota_de_debito( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito = value ;
   }

   public boolean getEnviar_automaticamente_a_la_sunat( )
   {
      return gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat ;
   }

   public void setEnviar_automaticamente_a_la_sunat( boolean value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat = value ;
   }

   public boolean getEnviar_automaticamente_al_cliente( )
   {
      return gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente ;
   }

   public void setEnviar_automaticamente_al_cliente( boolean value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente = value ;
   }

   public String getCondiciones_de_pago( )
   {
      return gxTv_SdtSDTRequestNubefact_Condiciones_de_pago ;
   }

   public void setCondiciones_de_pago( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Condiciones_de_pago = value ;
   }

   public String getMedio_de_pago( )
   {
      return gxTv_SdtSDTRequestNubefact_Medio_de_pago ;
   }

   public void setMedio_de_pago( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Medio_de_pago = value ;
   }

   public String getPlaca_vehiculo( )
   {
      return gxTv_SdtSDTRequestNubefact_Placa_vehiculo ;
   }

   public void setPlaca_vehiculo( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Placa_vehiculo = value ;
   }

   public String getOrden_compra_servicio( )
   {
      return gxTv_SdtSDTRequestNubefact_Orden_compra_servicio ;
   }

   public void setOrden_compra_servicio( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Orden_compra_servicio = value ;
   }

   public String getFormato_de_pdf( )
   {
      return gxTv_SdtSDTRequestNubefact_Formato_de_pdf ;
   }

   public void setFormato_de_pdf( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Formato_de_pdf = value ;
   }

   public String getGenerado_por_contingencia( )
   {
      return gxTv_SdtSDTRequestNubefact_Generado_por_contingencia ;
   }

   public void setGenerado_por_contingencia( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Generado_por_contingencia = value ;
   }

   public String getBienes_region_selva( )
   {
      return gxTv_SdtSDTRequestNubefact_Bienes_region_selva ;
   }

   public void setBienes_region_selva( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Bienes_region_selva = value ;
   }

   public String getServicios_region_selva( )
   {
      return gxTv_SdtSDTRequestNubefact_Servicios_region_selva ;
   }

   public void setServicios_region_selva( String value )
   {
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Servicios_region_selva = value ;
   }

   public java.util.Vector<com.projectthani.StructSdtSDTRequestNubefact_itemsItem> getItems( )
   {
      return gxTv_SdtSDTRequestNubefact_Items ;
   }

   public void setItems( java.util.Vector<com.projectthani.StructSdtSDTRequestNubefact_itemsItem> value )
   {
      gxTv_SdtSDTRequestNubefact_Items_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_Items = value ;
   }

   protected byte gxTv_SdtSDTRequestNubefact_Items_N ;
   protected byte gxTv_SdtSDTRequestNubefact_N ;
   protected boolean gxTv_SdtSDTRequestNubefact_Detraccion ;
   protected boolean gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_a_la_sunat ;
   protected boolean gxTv_SdtSDTRequestNubefact_Enviar_automaticamente_al_cliente ;
   protected String gxTv_SdtSDTRequestNubefact_Operacion ;
   protected String gxTv_SdtSDTRequestNubefact_Serie ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_numero_de_documento ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_denominacion ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_direccion ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_email ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_email_1 ;
   protected String gxTv_SdtSDTRequestNubefact_Cliente_email_2 ;
   protected String gxTv_SdtSDTRequestNubefact_Fecha_de_emision ;
   protected String gxTv_SdtSDTRequestNubefact_Fecha_de_vencimiento ;
   protected String gxTv_SdtSDTRequestNubefact_Tipo_de_cambio ;
   protected String gxTv_SdtSDTRequestNubefact_Descuento_global ;
   protected String gxTv_SdtSDTRequestNubefact_Total_descuento ;
   protected String gxTv_SdtSDTRequestNubefact_Total_anticipo ;
   protected String gxTv_SdtSDTRequestNubefact_Total_inafecta ;
   protected String gxTv_SdtSDTRequestNubefact_Total_exonerada ;
   protected String gxTv_SdtSDTRequestNubefact_Total_gratuita ;
   protected String gxTv_SdtSDTRequestNubefact_Total_otros_cargos ;
   protected String gxTv_SdtSDTRequestNubefact_Percepcion_tipo ;
   protected String gxTv_SdtSDTRequestNubefact_Percepcion_base_imponible ;
   protected String gxTv_SdtSDTRequestNubefact_Total_percepcion ;
   protected String gxTv_SdtSDTRequestNubefact_Total_incluido_percepcion ;
   protected String gxTv_SdtSDTRequestNubefact_Total_impuestos_bolsas ;
   protected String gxTv_SdtSDTRequestNubefact_Observaciones ;
   protected String gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_tipo ;
   protected String gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_serie ;
   protected String gxTv_SdtSDTRequestNubefact_Documento_que_se_modifica_numero ;
   protected String gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_credito ;
   protected String gxTv_SdtSDTRequestNubefact_Tipo_de_nota_de_debito ;
   protected String gxTv_SdtSDTRequestNubefact_Condiciones_de_pago ;
   protected String gxTv_SdtSDTRequestNubefact_Medio_de_pago ;
   protected String gxTv_SdtSDTRequestNubefact_Placa_vehiculo ;
   protected String gxTv_SdtSDTRequestNubefact_Orden_compra_servicio ;
   protected String gxTv_SdtSDTRequestNubefact_Formato_de_pdf ;
   protected String gxTv_SdtSDTRequestNubefact_Generado_por_contingencia ;
   protected String gxTv_SdtSDTRequestNubefact_Bienes_region_selva ;
   protected String gxTv_SdtSDTRequestNubefact_Servicios_region_selva ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Tipo_de_comprobante ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Numero ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Sunat_transaction ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Cliente_tipo_de_documento ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Moneda ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Porcentaje_de_igv ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Total_gravada ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Total_igv ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_Total ;
   protected java.util.Vector<com.projectthani.StructSdtSDTRequestNubefact_itemsItem> gxTv_SdtSDTRequestNubefact_Items=null ;
}

