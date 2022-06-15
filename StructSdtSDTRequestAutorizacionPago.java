package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTRequestAutorizacionPago implements Cloneable, java.io.Serializable
{
   public StructSdtSDTRequestAutorizacionPago( )
   {
      this( -1, new ModelContext( StructSdtSDTRequestAutorizacionPago.class ));
   }

   public StructSdtSDTRequestAutorizacionPago( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtSDTRequestAutorizacionPago_Channel = "" ;
      gxTv_SdtSDTRequestAutorizacionPago_Capturetype = "" ;
      gxTv_SdtSDTRequestAutorizacionPago_Order_N = (byte)(1) ;
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

   public String getChannel( )
   {
      return gxTv_SdtSDTRequestAutorizacionPago_Channel ;
   }

   public void setChannel( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPago_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPago_Channel = value ;
   }

   public String getCapturetype( )
   {
      return gxTv_SdtSDTRequestAutorizacionPago_Capturetype ;
   }

   public void setCapturetype( String value )
   {
      gxTv_SdtSDTRequestAutorizacionPago_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPago_Capturetype = value ;
   }

   public com.projectthani.StructSdtSDTRequestOrder getOrder( )
   {
      return gxTv_SdtSDTRequestAutorizacionPago_Order ;
   }

   public void setOrder( com.projectthani.StructSdtSDTRequestOrder value )
   {
      gxTv_SdtSDTRequestAutorizacionPago_Order_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPago_N = (byte)(0) ;
      gxTv_SdtSDTRequestAutorizacionPago_Order = value;
   }

   protected byte gxTv_SdtSDTRequestAutorizacionPago_Order_N ;
   protected byte gxTv_SdtSDTRequestAutorizacionPago_N ;
   protected String gxTv_SdtSDTRequestAutorizacionPago_Channel ;
   protected String gxTv_SdtSDTRequestAutorizacionPago_Capturetype ;
   protected com.projectthani.StructSdtSDTRequestOrder gxTv_SdtSDTRequestAutorizacionPago_Order=null ;
}

