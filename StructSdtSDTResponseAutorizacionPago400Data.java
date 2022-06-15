package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseAutorizacionPago400Data implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseAutorizacionPago400Data( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseAutorizacionPago400Data.class ));
   }

   public StructSdtSDTResponseAutorizacionPago400Data( int remoteHandle ,
                                                       ModelContext context )
   {
      gxTv_SdtSDTResponseAutorizacionPago400Data_Currency = "" ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_Amount = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant = "" ;
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

   public String getCurrency( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400Data_Currency ;
   }

   public void setCurrency( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_Currency = value ;
   }

   public java.math.BigDecimal getAmount( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400Data_Amount ;
   }

   public void setAmount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_Amount = value ;
   }

   public String getMerchant( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant ;
   }

   public void setMerchant( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago400Data_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant = value ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago400Data_N ;
   protected String gxTv_SdtSDTResponseAutorizacionPago400Data_Currency ;
   protected String gxTv_SdtSDTResponseAutorizacionPago400Data_Merchant ;
   protected java.math.BigDecimal gxTv_SdtSDTResponseAutorizacionPago400Data_Amount ;
}

