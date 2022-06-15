package com.projectthani ;
import com.genexus.*;

public final  class StructSdtSDTRequestTokenSession implements Cloneable, java.io.Serializable
{
   public StructSdtSDTRequestTokenSession( )
   {
      this( -1, new ModelContext( StructSdtSDTRequestTokenSession.class ));
   }

   public StructSdtSDTRequestTokenSession( int remoteHandle ,
                                           ModelContext context )
   {
      gxTv_SdtSDTRequestTokenSession_Amount = new java.math.BigDecimal(0) ;
      gxTv_SdtSDTRequestTokenSession_Channel = "" ;
      gxTv_SdtSDTRequestTokenSession_Antifraud_N = (byte)(1) ;
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

   public java.math.BigDecimal getAmount( )
   {
      return gxTv_SdtSDTRequestTokenSession_Amount ;
   }

   public void setAmount( java.math.BigDecimal value )
   {
      gxTv_SdtSDTRequestTokenSession_N = (byte)(0) ;
      gxTv_SdtSDTRequestTokenSession_Amount = value ;
   }

   public String getChannel( )
   {
      return gxTv_SdtSDTRequestTokenSession_Channel ;
   }

   public void setChannel( String value )
   {
      gxTv_SdtSDTRequestTokenSession_N = (byte)(0) ;
      gxTv_SdtSDTRequestTokenSession_Channel = value ;
   }

   public com.projectthani.StructSdtSDTRequestAutorizacionPagoAntifraud getAntifraud( )
   {
      return gxTv_SdtSDTRequestTokenSession_Antifraud ;
   }

   public void setAntifraud( com.projectthani.StructSdtSDTRequestAutorizacionPagoAntifraud value )
   {
      gxTv_SdtSDTRequestTokenSession_Antifraud_N = (byte)(0) ;
      gxTv_SdtSDTRequestTokenSession_N = (byte)(0) ;
      gxTv_SdtSDTRequestTokenSession_Antifraud = value;
   }

   protected byte gxTv_SdtSDTRequestTokenSession_Antifraud_N ;
   protected byte gxTv_SdtSDTRequestTokenSession_N ;
   protected String gxTv_SdtSDTRequestTokenSession_Channel ;
   protected java.math.BigDecimal gxTv_SdtSDTRequestTokenSession_Amount ;
   protected com.projectthani.StructSdtSDTRequestAutorizacionPagoAntifraud gxTv_SdtSDTRequestTokenSession_Antifraud=null ;
}

