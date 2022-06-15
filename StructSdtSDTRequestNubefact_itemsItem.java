package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTRequestNubefact_itemsItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTRequestNubefact_itemsItem( )
   {
      this( -1, new ModelContext( StructSdtSDTRequestNubefact_itemsItem.class ));
   }

   public StructSdtSDTRequestNubefact_itemsItem( int remoteHandle ,
                                                 ModelContext context )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Codigo = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Descuento = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Igv = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Total = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie = "" ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero = "" ;
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

   public String getUnidad_de_medida( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida ;
   }

   public void setUnidad_de_medida( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida = value ;
   }

   public String getCodigo( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Codigo ;
   }

   public void setCodigo( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Codigo = value ;
   }

   public String getCodigo_producto_sunat( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat ;
   }

   public void setCodigo_producto_sunat( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat = value ;
   }

   public String getDescripcion( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion ;
   }

   public void setDescripcion( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion = value ;
   }

   public java.math.BigDecimal getCantidad( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad ;
   }

   public void setCantidad( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad = value ;
   }

   public java.math.BigDecimal getValor_unitario( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario ;
   }

   public void setValor_unitario( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario = value ;
   }

   public java.math.BigDecimal getPrecio_unitario( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario ;
   }

   public void setPrecio_unitario( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario = value ;
   }

   public String getDescuento( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Descuento ;
   }

   public void setDescuento( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Descuento = value ;
   }

   public java.math.BigDecimal getSubtotal( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal ;
   }

   public void setSubtotal( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal = value ;
   }

   public java.math.BigDecimal getTipo_de_igv( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv ;
   }

   public void setTipo_de_igv( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv = value ;
   }

   public java.math.BigDecimal getIgv( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Igv ;
   }

   public void setIgv( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Igv = value ;
   }

   public java.math.BigDecimal getTotal( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Total ;
   }

   public void setTotal( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Total = value ;
   }

   public boolean getAnticipo_regularizacion( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion ;
   }

   public void setAnticipo_regularizacion( boolean value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion = value ;
   }

   public String getAnticipo_documento_serie( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie ;
   }

   public void setAnticipo_documento_serie( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie = value ;
   }

   public String getAnticipo_documento_numero( )
   {
      return gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero ;
   }

   public void setAnticipo_documento_numero( String value )
   {
      gxTv_SdtSDTRequestNubefact_itemsItem_N = (byte)(0) ;
      gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero = value ;
   }

   protected byte gxTv_SdtSDTRequestNubefact_itemsItem_N ;
   protected boolean gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_regularizacion ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Unidad_de_medida ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Codigo ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Codigo_producto_sunat ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Descripcion ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Descuento ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_serie ;
   protected String gxTv_SdtSDTRequestNubefact_itemsItem_Anticipo_documento_numero ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Cantidad ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Valor_unitario ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Precio_unitario ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Subtotal ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Tipo_de_igv ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Igv ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestNubefact_itemsItem_Total ;
}

