package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTResponseAutorizacionPago200Fulfillment implements Cloneable, java.io.Serializable
{
   public StructSdtSDTResponseAutorizacionPago200Fulfillment( )
   {
      this( -1, new ModelContext( StructSdtSDTResponseAutorizacionPago200Fulfillment.class ));
   }

   public StructSdtSDTResponseAutorizacionPago200Fulfillment( int remoteHandle ,
                                                              ModelContext context )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype = "" ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature = "" ;
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
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel ;
   }

   public void setChannel( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel = value ;
   }

   public String getMerchantid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid ;
   }

   public void setMerchantid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid = value ;
   }

   public String getTerminalid( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid ;
   }

   public void setTerminalid( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid = value ;
   }

   public String getCapturetype( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype ;
   }

   public void setCapturetype( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype = value ;
   }

   public boolean getCountable( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable ;
   }

   public void setCountable( boolean value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable = value ;
   }

   public boolean getFastpayment( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment ;
   }

   public void setFastpayment( boolean value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment = value ;
   }

   public String getSignature( )
   {
      return gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature ;
   }

   public void setSignature( String value )
   {
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N = (byte)(0) ;
      gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature = value ;
   }

   protected byte gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_N ;
   protected boolean gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Countable ;
   protected boolean gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Fastpayment ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Channel ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Merchantid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Terminalid ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Capturetype ;
   protected String gxTv_SdtSDTResponseAutorizacionPago200Fulfillment_Signature ;
}

